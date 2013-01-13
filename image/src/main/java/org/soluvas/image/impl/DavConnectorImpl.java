/**
 */
package org.soluvas.image.impl;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.image.DavConnector;
import org.soluvas.image.ImagePackage;
import org.soluvas.image.UploadedImage;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.base.Throwables;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Web Dav Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.image.impl.DavConnectorImpl#getHiUriTemplate <em>Hi Uri Template</em>}</li>
 *   <li>{@link org.soluvas.image.impl.DavConnectorImpl#getLoUriTemplate <em>Lo Uri Template</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DavConnectorImpl extends EObjectImpl implements DavConnector {
	
	/**
	 * The default value of the '{@link #getHiUriTemplate() <em>Hi Uri Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHiUriTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final String HI_URI_TEMPLATE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getLoUriTemplate() <em>Lo Uri Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoUriTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final String LO_URI_TEMPLATE_EDEFAULT = null;

	private static final Logger log = LoggerFactory
			.getLogger(DavConnectorImpl.class);
	
	private final DefaultHttpClient client = new DefaultHttpClient(new PoolingClientConnectionManager());
	private String davUri;
	private String safeDavUri;
	private HttpHost davHost;
	private String publicUri;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public DavConnectorImpl() {
		throw new UnsupportedOperationException();
	}
	
	public DavConnectorImpl(String davUri, String publicUri) {
		super();
		// Sanity checks
		Preconditions.checkArgument(!Strings.isNullOrEmpty(davUri), "DAV URI cannot be empty");
		Preconditions.checkArgument(!Strings.isNullOrEmpty(publicUri), "Public URI cannot be empty");
		
		URI davUriDetail = URI.create(davUri);
		final String userInfo = davUriDetail.getUserInfo();
		if (!Strings.isNullOrEmpty(userInfo)) {
			String username = userInfo;
			String password = "";
			if (userInfo.contains(":")) {
				String[] splitted = userInfo.split(":");
				username = splitted[0];
				password = splitted[1];
			}
			UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
			client.getCredentialsProvider().setCredentials(AuthScope.ANY, credentials);
		}
		davHost = new HttpHost(davUriDetail.getHost(), davUriDetail.getPort() != -1 ? davUriDetail.getPort() : 80, davUriDetail.getScheme());
		try {
			safeDavUri = new URIBuilder(davUri).setUserInfo(null).build().toString();
		} catch (URISyntaxException e1) {
			Throwables.propagate(e1);
		}
	}

	/**
	 * Create {@link HttpContext} with {@link AuthCache} pre-populated,
	 * since HttpClient does not allow HttpContext to be shared among threads.
	 * @return
	 */
	protected HttpContext createHttpContext() {
		BasicHttpContext httpContext = new BasicHttpContext();
		BasicAuthCache authCache = new BasicAuthCache();
		authCache.put(davHost, new BasicScheme());
		httpContext.setAttribute(ClientContext.AUTH_CACHE, authCache);
		return httpContext;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImagePackage.Literals.DAV_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public String getHiUriTemplate() {
		return publicUri /*+ "prefix/"*/ + "{namespace}/{styleCode}/{imageId}_{styleVariant}.{ext}";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public String getLoUriTemplate() {
		return publicUri /*+ "prefix/"*/ + "{namespace}/{styleCode}/{imageId}_{styleVariant}.{ext}";
	}

	/**
	 * <!-- begin-user-doc -->
	 * Note: Use File, because if uploading using InputStream, can throw org.apache.http.client.NonRepeatableRequestException: Cannot retry request with a non-repeatable request entity.
	 * 		because InputStream can only be read once.
	 * <!-- end-user-doc -->
	 */
	@Override
	public UploadedImage upload(String namespace, String imageId, String styleCode, String extension, File file, String contentType) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void delete(String namespace, String imageId, String styleCode, String extension) {
		String uri = getImageDavUri(namespace, imageId, styleCode, extension);
		HttpDelete deleteOriginal = new HttpDelete(uri);
		try {
			HttpResponse response = client.execute(davHost, deleteOriginal, createHttpContext());
			try {
				final StatusLine statusLine = response.getStatusLine();
				if (statusLine.getStatusCode() >= 200 && statusLine.getStatusCode() < 300)
					log.info("Delete {} returned: {}", uri, statusLine);
				else
					log.error("Delete {} returned: {}", uri, statusLine);
			} finally {
				HttpClientUtils.closeQuietly(response);
			}
		} catch (Exception e) {
			log.error("Cannot delete " + namespace + " " + imageId + " style=" + styleCode + " URI: " + uri, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void destroy() {
		client.getConnectionManager().shutdown();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImagePackage.DAV_CONNECTOR__HI_URI_TEMPLATE:
				return getHiUriTemplate();
			case ImagePackage.DAV_CONNECTOR__LO_URI_TEMPLATE:
				return getLoUriTemplate();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ImagePackage.DAV_CONNECTOR__HI_URI_TEMPLATE:
				return HI_URI_TEMPLATE_EDEFAULT == null ? getHiUriTemplate() != null : !HI_URI_TEMPLATE_EDEFAULT.equals(getHiUriTemplate());
			case ImagePackage.DAV_CONNECTOR__LO_URI_TEMPLATE:
				return LO_URI_TEMPLATE_EDEFAULT == null ? getLoUriTemplate() != null : !LO_URI_TEMPLATE_EDEFAULT.equals(getLoUriTemplate());
		}
		return super.eIsSet(featureID);
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#getImageDavUri(java.lang.String, java.lang.String)
	 */
	public String getImageDavUri(String namespace, String id, String styleCode, String extension) {
		return String.format("%s%s/%s/%s_%s.%s", safeDavUri, namespace, styleCode, id, styleCode, extension);
	}
	
	/**
	 * 
	 * Note: Use File, because if uploading using InputStream, can throw org.apache.http.client.NonRepeatableRequestException: Cannot retry request with a non-repeatable request entity.
	 * 		because InputStream can only be read once.
	 * 
	 * @param uri
	 * @param source
	 * @param contentType
	 * @param length
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	protected void uploadFileDav(URI uri, File source, String contentType) throws ClientProtocolException, IOException {
		// final URI originalDavUri = URI.create(String.format("%s%s/%s/%s_%s.%s",
		// safeDavUri, namespace, 'o', imageId, 'o', extension));
		
		
		long length = source.length();
		log.info("Uploading {} ({} bytes) to {}", contentType, length, uri );
		
		HttpPut httpPut = new HttpPut(uri);
		httpPut.setHeader("Content-Type", contentType);
		httpPut.setEntity(new FileEntity(source, ContentType.create(contentType)));
		HttpResponse response = client.execute(davHost, httpPut, createHttpContext());
		try {
			if (response.getStatusLine().getStatusCode() >= 200 && response.getStatusLine().getStatusCode() < 300)
				log.info("Upload {} returned: {}", uri, response.getStatusLine());
			else
				log.error("Upload {} returned: {}", uri, response.getStatusLine());
		} finally {
			HttpClientUtils.closeQuietly(response);
		}
	}
	
} //DavConnectorImpl

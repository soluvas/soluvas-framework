/**
 */
package org.soluvas.image.impl;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.image.DavConnector;
import org.soluvas.image.ImageException;
import org.soluvas.image.ImageFactory;
import org.soluvas.image.ImagePackage;
import org.soluvas.image.UploadedImage;

import com.damnhandy.uri.template.UriTemplate;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Web Dav Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DavConnectorImpl extends ImageConnectorImpl implements DavConnector {
	
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
		this.davUri = davUri;
		this.publicUri = publicUri;
		
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
	public String getUriTemplate() {
		return publicUri /*+ "prefix/"*/ + "{namespace}/{styleCode}/{imageId}_{styleVariant}.{extension}";
	}

	public String getOriginUriTemplate() {
		return publicUri /*+ "prefix/"*/ + "{namespace}/{styleCode}/{imageId}_{styleVariant}.{extension}";
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void delete(String namespace, String imageId, String styleCode, String styleVariant, String extension) {
		String uri = getImageDavUri(namespace, imageId, styleCode, styleVariant, extension);
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
	 * Scheme: ${safeDavUri}/${namespace}/${shortCode}/${id}_${shortCode}.${extension}
	 * 
	 * This only works for non-original image styles.
	 * 
	 * @return
	 */
	public String getImageDavUri(String namespace, String id, String styleCode, String styleVariant, String extension) {
		return String.format("%s%s/%s/%s_%s.%s", safeDavUri, namespace, styleCode, id, styleVariant, extension);
	}

	public String getImageOriginUri(String namespace, String id, String styleCode, String styleVariant, String extension) {
		String uriTemplate = getOriginUriTemplate();
		// namespace, styleCode, imageId, styleVariant, ext
		final Map<String, Object> uriVars = ImmutableMap.<String, Object>of(
				"namespace", namespace, "styleCode", styleCode, "imageId", id, "styleVariant", styleVariant,
				"ext", extension);
		return UriTemplate.fromTemplate(uriTemplate).expand(uriVars);
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
	protected void uploadFileDav(String uri, File source, String contentType) throws ClientProtocolException, IOException {
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
	
	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#getDavUri()
	 */
	public String getDavUri() {
		return davUri;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#getPublicUri()
	 */
	public String getPublicUri() {
		return publicUri;
	}
	
	@Override
	public boolean download(String namespace, String imageId, String styleCode,
			String styleVariant, String extension, File file) {
		final String imageUri = getImageOriginUri(namespace, imageId, styleCode, styleCode, extension);
		log.info("Downloading {} from {}", imageId, imageUri);
		final HttpGet httpGet = new HttpGet(imageUri);
		try {
			final HttpResponse response = client.execute(davHost, httpGet, createHttpContext());
			try {
				if (response.getStatusLine().getStatusCode() >= 200 && response.getStatusLine().getStatusCode() < 300) {
					log.trace("Download {} successful: {}", imageUri, response.getStatusLine());
					final long contentLength = response.getEntity().getContentLength();
					log.debug("Writing {} bytes to {}", contentLength, file);
					FileUtils.copyInputStreamToFile(response.getEntity().getContent(), file);
					Preconditions.checkState(contentLength == file.length(),
							"Image %s has Content-Length of %s bytes, but downloaded %s bytes as %s",
							imageId, contentLength, file.length(), file); 
					return true;
				} else {
					log.error("Download {} returned: {}", imageUri, response.getStatusLine());
					throw new ImageException(String.format("Download %s returned: %s", imageUri, response.getStatusLine()));
				}
			} finally {
				HttpClientUtils.closeQuietly(response);
			}
		} catch (Exception e) {
			throw new ImageException(e, "Cannot download %s from %s", imageId, imageUri);
		}
	}

	@Override
	public UploadedImage upload(String namespace, String imageId,
			String styleCode, String styleVariant, String extension, File file,
			String contentType) {
		String uri = getImageDavUri(namespace, imageId, styleCode, styleVariant, extension);
		try {
			uploadFileDav(uri, file, contentType);
			String originUri = getUri(namespace, imageId, styleCode, styleVariant, extension);
			UploadedImage uploadedImage = ImageFactory.eINSTANCE.createUploadedImage();
			uploadedImage.setOriginUri(originUri);
			uploadedImage.setUri(originUri);
			return uploadedImage;
		} catch (Exception e) {
			throw new ImageException("Cannot upload to " + uri, e);
		}
	}

} //DavConnectorImpl

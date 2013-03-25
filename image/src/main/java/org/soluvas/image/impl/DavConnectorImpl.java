package org.soluvas.image.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

import javax.annotation.PreDestroy;

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
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.NoConnectionReuseStrategy;
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
import com.google.common.util.concurrent.ListenableFuture;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Web Dav Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("serial")
public class DavConnectorImpl extends ImageConnectorImpl implements DavConnector {
	
	private static final Logger log = LoggerFactory
			.getLogger(DavConnectorImpl.class);
	
	private final DefaultHttpClient client;
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
		this(davUri, publicUri, EXECUTOR_EDEFAULT);
	}
	
	public DavConnectorImpl(String davUri, String publicUri, ExecutorService executor) {
		super(executor);
		this.davUri = davUri;
		this.publicUri = publicUri;
		
		client = new DefaultHttpClient(new PoolingClientConnectionManager());
		// workaround for nginx dav bug, see #uploadFileDav() method
		// see http://trac.nginx.org/nginx/ticket/284#comment:5
		// Note: please use puppet-nginx which gives you at least nginx 1.2.7 on both precise & quantal
		// Bug still happens on nginx 1.2.7 though, in a more detailed way
		client.setReuseStrategy(new NoConnectionReuseStrategy());
		
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
		final String uri = getImageDavUri(namespace, imageId, styleCode, styleVariant, extension);
		final HttpDelete deleteOriginal = new HttpDelete(uri);
		try {
			final HttpResponse response = client.execute(davHost, deleteOriginal, createHttpContext());
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
	@Override @PreDestroy
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
				"extension", extension);
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
		Preconditions.checkArgument(source.exists(), "File %s to be uploaded must exists", source);
		// final URI originalDavUri = URI.create(String.format("%s%s/%s/%s_%s.%s",
		// safeDavUri, namespace, 'o', imageId, 'o', extension));
		
		final long length = source.length();
		log.info("Uploading {} from {} ({} bytes) to {}", contentType, source, length, uri );
		
		final HttpPut httpPut = new HttpPut(uri);
		httpPut.setHeader("Content-Type", contentType);
		// My new bug report is here: http://trac.nginx.org/nginx/ticket/284
/*
For some strange reason, nginx dav 1.1.19-1ubuntu0.1 on Ubuntu 12.04-x86 is unstable, but worked well (at that time) with InputStreamEntity.
tried with FileEntity, ByteArrayEntity, and InputStreamEntity, not working.

Caused by: org.soluvas.image.ImageException: Cannot upload to http://dav.berbatik.com/shop/t/canting_ayu3_square_imageadd_8229662526285897097_t.jpg
        at org.soluvas.image.impl.DavConnectorImpl.upload(DavConnectorImpl.java:286)[2886:org.soluvas.image:2.0.0.SNAPSHOT]
        at org.soluvas.image.impl.ThumbnailatorTransformerImpl.transform(ThumbnailatorTransformerImpl.java:210)[2886:org.soluvas.image:2.0.0.SNAPSHOT]
        ... 22 more
Caused by: java.net.SocketException: Connection reset
        at java.net.SocketInputStream.read(SocketInputStream.java:189)[:1.7.0_09]
        at java.net.SocketInputStream.read(SocketInputStream.java:121)[:1.7.0_09]
        at org.apache.http.impl.io.AbstractSessionInputBuffer.fillBuffer(AbstractSessionInputBuffer.java:166)[2498:org.apache.httpcomponents.httpcore:4.2.2]
        at org.apache.http.impl.io.SocketInputBuffer.fillBuffer(SocketInputBuffer.java:90)[2498:org.apache.httpcomponents.httpcore:4.2.2]
        at org.apache.http.impl.io.AbstractSessionInputBuffer.readLine(AbstractSessionInputBuffer.java:281)[2498:org.apache.httpcomponents.httpcore:4.2.2]
        at org.apache.http.impl.conn.DefaultHttpResponseParser.parseHead(DefaultHttpResponseParser.java:92)[2511:org.apache.httpcomponents.httpclient:4.2.2]
        at org.apache.http.impl.conn.DefaultHttpResponseParser.parseHead(DefaultHttpResponseParser.java:62)[2511:org.apache.httpcomponents.httpclient:4.2.2]
        at org.apache.http.impl.io.AbstractMessageParser.parse(AbstractMessageParser.java:254)[2498:org.apache.httpcomponents.httpcore:4.2.2]
        at org.apache.http.impl.AbstractHttpClientConnection.receiveResponseHeader(AbstractHttpClientConnection.java:289)[2498:org.apache.httpcomponents.httpcore:4.2.2]
        at org.apache.http.impl.conn.DefaultClientConnection.receiveResponseHeader(DefaultClientConnection.java:252)[2511:org.apache.httpcomponents.httpclient:4.2.2]
        at org.apache.http.impl.conn.ManagedClientConnectionImpl.receiveResponseHeader(ManagedClientConnectionImpl.java:191)[2511:org.apache.httpcomponents.httpclient:4.2.2]
        at org.apache.http.protocol.HttpRequestExecutor.doReceiveResponse(HttpRequestExecutor.java:300)[2498:org.apache.httpcomponents.httpcore:4.2.2]
        at org.apache.http.protocol.HttpRequestExecutor.execute(HttpRequestExecutor.java:127)[2498:org.apache.httpcomponents.httpcore:4.2.2]
        at org.apache.http.impl.client.DefaultRequestDirector.tryExecute(DefaultRequestDirector.java:712)[2511:org.apache.httpcomponents.httpclient:4.2.2]
        at org.apache.http.impl.client.DefaultRequestDirector.execute(DefaultRequestDirector.java:517)[2511:org.apache.httpcomponents.httpclient:4.2.2]
        at org.apache.http.impl.client.AbstractHttpClient.execute(AbstractHttpClient.java:906)[2511:org.apache.httpcomponents.httpclient:4.2.2]
        at org.soluvas.image.impl.DavConnectorImpl.uploadFileDav(DavConnectorImpl.java:218)[2886:org.soluvas.image:2.0.0.SNAPSHOT]
        at org.soluvas.image.impl.DavConnectorImpl.upload(DavConnectorImpl.java:279)[2886:org.soluvas.image:2.0.0.SNAPSHOT]
        ... 23 more
        
nginx side:
worker process 32408 exited on signal 11 (core dumped)

probably:
http://trac.nginx.org/nginx/ticket/238
http://forum.nginx.org/read.php?21,231434,231434

I *think* it's due to Connector uploading the original, then downloading the original before transforming (requested by Thumbnailator),
and uploading again, and because of HTTP pipelining which isn't supported by nginx's dav.
         
*/
//		httpPut.setEntity(new FileEntity(source, ContentType.create(contentType)));
//		httpPut.setEntity(new ByteArrayEntity(FileUtils.readFileToByteArray(source),
//				ContentType.create(contentType)));
		httpPut.setEntity(
				new InputStreamEntity(new FileInputStream(source), source.length(), ContentType.create(contentType)));
		final HttpResponse response = client.execute(davHost, httpPut, createHttpContext());
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
	public ListenableFuture<UploadedImage> upload(final String namespace, final String imageId,
			final String styleCode, final String styleVariant, final String extension, final File file,
			final String contentType) {
		return getExecutor().submit(new Callable<UploadedImage>() {
			@Override
			public UploadedImage call() throws Exception {
				final String uri = getImageDavUri(namespace, imageId, styleCode, styleVariant, extension);
				try {
					uploadFileDav(uri, file, contentType);
					final String originUri = getUri(namespace, imageId, styleCode, styleVariant, extension);
					final UploadedImage uploadedImage = ImageFactory.eINSTANCE.createUploadedImage();
					uploadedImage.setOriginUri(originUri);
					uploadedImage.setUri(originUri);
					return uploadedImage;
				} catch (Exception e) {
					throw new ImageException("Cannot upload to " + uri, e);
				}
			}
		});
	}

} //DavConnectorImpl

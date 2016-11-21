package org.soluvas.image.impl;

import com.amazonaws.util.IOUtils;
import com.damnhandy.uri.template.MalformedUriTemplateException;
import com.damnhandy.uri.template.UriTemplate;
import com.damnhandy.uri.template.VariableExpansionException;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.*;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ListenableFuture;
import org.soluvas.image.ImageException;
import org.soluvas.image.ImageFactory;
import org.soluvas.image.UploadedImage;
import org.soluvas.image.store.ImageRepository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Google (Cloud) Storage connector.
 */
@SuppressWarnings("serial")
public class GsConnectorImpl extends ImageConnectorImpl {

	/** Global configuration of Google Cloud Storage OAuth 2.0 scope. */
	private static final String STORAGE_SCOPE =
			"https://www.googleapis.com/auth/devstorage.read_write";

	@Inject
	private GoogleCredential credential;
	private String bucket;
	private String tenantId;
	private String tenantEnv;

	public GoogleCredential getCredential() {
		return credential;
	}

	/**
	 * Must set this, usually from JSON private key file.
	 * @param credential
	 */
	public void setCredential(GoogleCredential credential) {
		this.credential = credential;
	}

	/**
	 * Bucket name for original images, e.g. {@literal media.satukancinta.com}.
	 * @param bucket
	 */
	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public void setTenantEnv(String tenantEnv) {
		this.tenantEnv = tenantEnv;
	}

	public GsConnectorImpl() {
		super();
	}

	@PostConstruct
	public void init() {
		Preconditions.checkNotNull(credential, "credential must be set");
		Preconditions.checkNotNull(bucket, "bucket must be set");
		Preconditions.checkNotNull(tenantId, "tenantId must be set");
		Preconditions.checkNotNull(tenantEnv, "tenantEnv must be set");
	}

	public String getBucket() {
		return bucket;
	}

	public String getTenantId() {
		return tenantId;
	}

	public String getTenantEnv() {
		return tenantEnv;
	}

	@Override
	public String getUriTemplate() {
		// http(s)://storage.googleapis.com/[bucket]/[object]
		// https://cloud.google.com/storage/docs/xml-api/reference-uris
//		final String url = "https://storage.googleapis.com/media.satukancinta.com/prd/person/s/" + imageIdModel.getObject() + "_s.jpg";

		return "https://storage.googleapis.com/" + bucket + "/" + tenantId + "_" + tenantEnv + "/" +
				"{namespace}/{styleCode}/{imageId}_{styleVariant}.{extension}";
	}
	
	@Override
	public ListenableFuture<UploadedImage> upload(final String namespace, final String imageId,
			final String styleCode, final String styleVariant, final String extension, final File file,
			final String contentType) {
		// sanity check
		Preconditions.checkArgument(!Strings.isNullOrEmpty(contentType),
				"Cannot upload image without content type, namespace=%s imageId=%s styleCode=%s styleVariant=%s extension=%s file=%s",
				namespace, imageId, styleCode, styleVariant, extension, file);
		Preconditions.checkArgument(!Strings.isNullOrEmpty(extension),
				"Cannot upload image without extension, namespace=%s imageId=%s styleCode=%s styleVariant=%s file=%s contentType=%s",
				namespace, imageId, styleCode, styleVariant, file, contentType);
		Preconditions.checkArgument(file.length() > 0,
				"Cannot upload empty image, namespace=%s imageId=%s styleCode=%s styleVariant=%s file=%s contentType=%s",
				namespace, imageId, styleCode, styleVariant, file, contentType);

//		final SettableFuture<UploadedImage> future = SettableFuture.create();
		final boolean useHi = ImageRepository.ORIGINAL_CODE.equals(styleCode);
		final String key = String.format("%s_%s/%s/%s/%s_%s.%s",
				tenantId, tenantEnv, namespace, styleCode, imageId, styleVariant, extension);
//		final AccessControlList acl = new AccessControlList();
//		if (!Strings.isNullOrEmpty(canonicalUserId)) {
//			acl.grantPermission(new CanonicalGrantee(canonicalUserId), Permission.FullControl);
//		}
//		acl.grantPermission(GroupGrantee.AllUsers, Permission.Read);
//		final PutObjectRequest putReq = new PutObjectRequest(bucket, key, file)
//			.withAccessControlList(acl)
//			.withStorageClass(useHi ? StorageClass.Standard : StorageClass.ReducedRedundancy);
//		final Upload upload = transferMgr.upload(putReq);

		return executor.submit(() -> {
			final String uri = "https://storage.googleapis.com/"
					+ URLEncoder.encode(bucket, "UTF-8") + "/" + key;
			try {
				// Set up and execute a Google Cloud Storage request.
				HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
				HttpRequestFactory requestFactory = httpTransport.createRequestFactory(
						credential.createScoped(ImmutableList.of(STORAGE_SCOPE)));

				GenericUrl url = new GenericUrl(uri);
				final InputStreamContent httpContent = new InputStreamContent(contentType, new FileInputStream(file));
				HttpRequest request = requestFactory.buildPutRequest(url, httpContent);
				request.getHeaders().setCacheControl("public, max-age=0, must-revalidate"); // soft "do not cache unless you know what you're doing", for imgix operation
				HttpResponse response = request.execute();
				String content = response.parseAsString();
				log.info("Uploaded '{}' to '{}', {} bytes transferred: gs://{}/{}",
						file, uri, file.length(), bucket, key);

				final String realOriginAlias = "storage.googleapis.com";
				final String realCdnAlias = "storage.googleapis.com";
				final UploadedImage uploadedImage = ImageFactory.eINSTANCE.createUploadedImage();
				uploadedImage.setOriginUri("https://" + realOriginAlias + "/" + key);
				uploadedImage.setUri("https://" + realCdnAlias + "/" + key);
				return uploadedImage;
			} catch (Exception e) {
				final String errorMessage = String.format("Failed upload '%s' to '%s' (%s bytes): %s",
						file, uri, file.length(), e);
				log.error(errorMessage, e);
				throw new ImageException(e, errorMessage, e);
			}
        });
	}
	
	@Override
	public void delete(String namespace, String imageId, String styleCode,
			String styleVariant, String extension) {
		final String key = String.format("%s_%s/%s/%s/%s_%s.%s",
				tenantId, tenantEnv, namespace, styleCode, imageId, styleVariant, extension);
		try {
			// Set up and execute a Google Cloud Storage request.
			final String uri = "https://storage.googleapis.com/"
					+ URLEncoder.encode(bucket, "UTF-8") + "/" + key;

			HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
			HttpRequestFactory requestFactory = httpTransport.createRequestFactory(
					credential.createScoped(ImmutableList.of(STORAGE_SCOPE)));

			GenericUrl url = new GenericUrl(uri);
			HttpRequest request = requestFactory.buildDeleteRequest(url);
			HttpResponse response = request.execute();
			String content = response.parseAsString();
			log.debug("Deleted gs://{}/{}", bucket, key);
		} catch (Exception e) {
			throw new ImageException(e, "Cannot delete %s from %s", key, bucket);
		}
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.impl.ImageConnectorImpl#destroy()
	 */
	@Override @PreDestroy
	public void destroy() {
	}
	
	@Override
	public boolean download(String namespace, String imageId, String styleCode,
			String styleVariant, String extension, File file) {
		final String key = String.format("%s_%s/%s/%s/%s_%s.%s",
				tenantId, tenantEnv, namespace, styleCode, imageId, styleVariant, extension);
		try {
			final String uri = "https://storage.googleapis.com/"
					+ URLEncoder.encode(bucket, "UTF-8") + "/" + key;

			HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
			HttpRequestFactory requestFactory = httpTransport.createRequestFactory(
					credential.createScoped(ImmutableList.of(STORAGE_SCOPE)));

			GenericUrl url = new GenericUrl(uri);
			HttpRequest request = requestFactory.buildGetRequest(url);
			HttpResponse response = request.execute();
			IOUtils.copy(response.getContent(), new FileOutputStream(file));

			log.debug("Downloaded gs://{}/{}", bucket, key);
			return true;
		} catch (Exception e) {
			throw new ImageException(e, "Cannot download %s from %s", key, bucket);
		}
	}
	
	@Override
	public String getOriginUri(String namespace, String imageId,
			String styleCode, String styleVariant, String extension) {
		final String realOriginAlias = "storage.googleapis.com";
		final String uriTemplate = "https://" + realOriginAlias + "/" + tenantId + "_" + tenantEnv + "/" +
				"{namespace}/{styleCode}/{imageId}_{styleVariant}.{extension}";
		// namespace, styleCode, imageId, styleVariant, extension
		final Map<String, Object> uriVars = Maps.newHashMap();
		uriVars.put("namespace", namespace);
		uriVars.put("styleCode", styleCode);
		uriVars.put("imageId", imageId);
		uriVars.put("styleVariant", styleVariant);
		uriVars.put("extension", extension);
		try {
			return UriTemplate.fromTemplate(uriTemplate).expand(uriVars);
		} catch (VariableExpansionException | MalformedUriTemplateException e) {
			throw new ImageException(e, "Cannot expand URI template '%s' using %s", uriTemplate, uriVars);
		}
	}
	
} //S3ConnectorImpl

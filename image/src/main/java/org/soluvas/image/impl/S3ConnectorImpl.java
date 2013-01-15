/**
 */
package org.soluvas.image.impl;

import java.io.File;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.image.ImageException;
import org.soluvas.image.ImageFactory;
import org.soluvas.image.ImagePackage;
import org.soluvas.image.S3Connector;
import org.soluvas.image.UploadedImage;
import org.soluvas.image.store.ImageRepository;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.CanonicalGrantee;
import com.amazonaws.services.s3.model.GroupGrantee;
import com.amazonaws.services.s3.model.Permission;
import com.amazonaws.services.s3.model.ProgressEvent;
import com.amazonaws.services.s3.model.ProgressListener;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.StorageClass;
import com.amazonaws.services.s3.transfer.Download;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;
import com.amazonaws.services.s3.transfer.model.UploadResult;
import com.damnhandy.uri.template.UriTemplate;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>S3 Connector</b></em>'.
 * 
 *  AWSCredentials myCredentials = new BasicAWSCredentials(...);
 TransferManager tm = new TransferManager(myCredentials);
 Transfer myUpload = tm.upload(myBucket, myFile.getName(), myFile);

 // You can keep doing work while the transfer uploads in a background thread
 while (myUpload.isDone() == false) {
     System.out.println("Transfer: " + myUpload.getDescription());
     System.out.println("  - State:    " + myUpload.getState());
     System.out.println("  - Progress: " + myUpload.getProgress().getBytesTransfered());
     // Do work while we wait for our upload to complete...
     Thread.sleep(500);
 }

 // Or you can wait for the transfer to finish if you don't need to do more work
 myUpload.waitForCompletion();
 
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class S3ConnectorImpl extends ImageConnectorImpl implements S3Connector {
	
	private static final Logger log = LoggerFactory
			.getLogger(S3ConnectorImpl.class);
	private final String hiBucket;
	private final String loBucket;
	private final String prefix;
	private final String hiOriginAlias;
	private final String loOriginAlias;
	private final TransferManager transferMgr;
	private String hiCdnAlias;
	private String loCdnAlias;
	private String canonicalUserId;
	private AmazonS3Client s3Client;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public S3ConnectorImpl() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * @param endpoint If provided, will use your own server, e.g. localhost:4567. Otherwise,
	 * 		use Amazon's S3 service.
	 * @param protocol {@link Protocol#HTTPS} is recommended for Amazon S3.
	 * @param accessKey Cannot be empty, even if fake.
	 * @param secretKey Cannot be empty, even if fake.
	 * @param hiBucket Bucket name for original images, e.g. {@literal berbatik-stg-pichi}.
	 * @param loBucket Bucket name for disposable images, e.g. {@literal berbatik-stg-piclo}.
	 * 		Images will be stored using RRS. Can be the same as hiBucket.
	 * @param prefix Application-provided prefix, this is usually "${tenantId}_${tenantEnv}/",
	 * 		e.g. "berbatik_dev/".
	 * 		Namespace will be passed by the repository during upload, so it is not needed.
	 * @param hiOriginAlias If specified, can be used as alias e.g. using CloudFront.
	 * 		Otherwise use default "berbatik-stg-pichi.s3.amazonaws.com".
	 * @param loOriginAlias If specified, can be used as alias e.g. using CloudFront.
	 * 		Otherwise use default "berbatik-stg-pichi.s3.amazonaws.com".
	 */
	public S3ConnectorImpl(String endpoint, Protocol protocol,
			String accessKey, String secretKey, String canonicalUserId,
			String hiBucket, String loBucket, String prefix, String hiOriginAlias, String loOriginAlias,
			String hiCdnAlias, String loCdnAlias) {
		super();
		this.canonicalUserId = canonicalUserId;
		if (Strings.isNullOrEmpty(canonicalUserId)) {
			log.warn("Canonical user ID should be filled, otherwise you can't control the S3 objects you uploaded.");
		}
		this.hiBucket = hiBucket;
		this.loBucket = loBucket;
		this.prefix = prefix;
		this.hiOriginAlias = hiOriginAlias;
		this.loOriginAlias = loOriginAlias;
		this.hiCdnAlias = hiCdnAlias;
		this.loCdnAlias = loCdnAlias;
		final AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
		s3Client = new AmazonS3Client(credentials,
				new ClientConfiguration().withProtocol(protocol));
		if (!Strings.isNullOrEmpty(endpoint))
			s3Client.setEndpoint(endpoint);
		transferMgr = new TransferManager(s3Client);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImagePackage.Literals.S3_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public String getHiUriTemplate() {
		String cdnAlias = Strings.isNullOrEmpty(hiCdnAlias) ? hiBucket + ".s3.amazonaws.com" : hiCdnAlias;
		return "http://" + cdnAlias + "/" + Strings.nullToEmpty(prefix) +
				"{namespace}/{styleCode}/{imageId}_{styleVariant}.{ext}";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public String getLoUriTemplate() {
		String cdnAlias = Strings.isNullOrEmpty(loCdnAlias) ? loBucket + ".s3.amazonaws.com" : loCdnAlias;
		return "http://" + cdnAlias + "/" + Strings.nullToEmpty(prefix) +
				"{namespace}/{styleCode}/{imageId}_{styleVariant}.{ext}";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public UploadedImage upload(String namespace, String imageId, String styleCode, String extension, final File file, String contentType) {
		boolean useHi = ImageRepository.ORIGINAL_CODE.equals(styleCode);
		String bucket = useHi ? hiBucket : loBucket;
		String key = String.format("%s%s/%s/%s_%s.%s",
				Strings.nullToEmpty(prefix), namespace, styleCode, imageId, styleCode, extension);
		AccessControlList acl = new AccessControlList();
		if (!Strings.isNullOrEmpty(canonicalUserId)) {
			acl.grantPermission(new CanonicalGrantee(canonicalUserId), Permission.FullControl);
		}
		acl.grantPermission(GroupGrantee.AllUsers, Permission.Read);
		PutObjectRequest putReq = new PutObjectRequest(bucket, key, file)
			.withAccessControlList(acl)
			.withStorageClass(useHi ? StorageClass.Standard : StorageClass.ReducedRedundancy);
		Upload upload = transferMgr.upload(putReq);
		final String s3Uri = "s3://" + bucket + "/" + key;
		upload.addProgressListener(new ProgressListener() {
			@Override
			public void progressChanged(ProgressEvent ev) {
				switch (ev.getEventCode()) {
				case ProgressEvent.STARTED_EVENT_CODE:
					log.debug("Starting upload {} to {}", file, s3Uri);
					break;
				case ProgressEvent.COMPLETED_EVENT_CODE:
					log.info("Completed upload {} to {}, {} bytes transferred", file, s3Uri,
							ev.getBytesTransfered());
					break;
				case ProgressEvent.FAILED_EVENT_CODE:
					log.error("Failed upload {} to {}, {} bytes transferred", file, s3Uri,
							ev.getBytesTransfered());
					break;
				case 0:
					// nothing...?
					break;
				default:
					log.error("Unknown error code {} during upload {} to {}, {} bytes transferred",
							ev.getEventCode(), file, s3Uri, ev.getBytesTransfered());
					break;
				}
			}
		});
		
		try {
			UploadResult uploadResult = upload.waitForUploadResult();
			log.info("Upload {} to {} result: etag={} versionId={} bucket={} key={}",
					uploadResult.getETag(),
					uploadResult.getVersionId(),
					uploadResult.getBucketName(),
					uploadResult.getKey() );
		} catch (Exception e) {
			throw new ImageException(e, "Cannot upload %s to %s", file, s3Uri);
		}
		
		final String originAlias;
		final String cdnAlias;
		if (useHi) {
			originAlias = Strings.isNullOrEmpty(hiOriginAlias) ? hiBucket + ".s3.amazonaws.com" : hiOriginAlias;
			cdnAlias = Strings.isNullOrEmpty(hiCdnAlias) ? hiBucket + ".s3.amazonaws.com" : hiCdnAlias;
		} else {
			originAlias = Strings.isNullOrEmpty(loOriginAlias) ? loBucket + ".s3.amazonaws.com" : loOriginAlias;
			cdnAlias = Strings.isNullOrEmpty(loCdnAlias) ? loBucket + ".s3.amazonaws.com" : loCdnAlias;
		}
		UploadedImage uploadedImage = ImageFactory.eINSTANCE.createUploadedImage();
		uploadedImage.setOriginUri("http://" + originAlias + "/" + key);
		uploadedImage.setUri("http://" + cdnAlias + "/" + key);
		return uploadedImage;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.impl.ImageConnectorImpl#delete(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void delete(String namespace, String imageId, String styleCode,
			String extension) {
		boolean useHi = ImageRepository.ORIGINAL_CODE.equals(styleCode);
		String bucket = useHi ? hiBucket : loBucket;
		String key = String.format("%s%s/%s/%s_%s.%s",
				Strings.nullToEmpty(prefix), namespace, styleCode, imageId, styleCode, extension);
		try {
			s3Client.deleteObject(bucket, key);
			log.debug("Deleted s3://{}/{}", bucket, key);
		} catch (Exception e) {
			throw new ImageException(e, "Cannot delete %s from %s", key, bucket);
		}
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.impl.ImageConnectorImpl#destroy()
	 */
	@Override
	public void destroy() {
		transferMgr.shutdownNow();
		super.destroy();
	}
	
	@Override
	public boolean download(String namespace, String imageId, String styleCode,
			String extension, File file) {
		boolean useHi = ImageRepository.ORIGINAL_CODE.equals(styleCode);
		String bucket = useHi ? hiBucket : loBucket;
		String key = String.format("%s%s/%s/%s_%s.%s",
				Strings.nullToEmpty(prefix), namespace, styleCode, imageId, styleCode, extension);
		try {
			Download download = transferMgr.download(bucket, key, file);
			download.waitForCompletion();
			log.debug("Downloaded s3://{}/{} versionId={} desc={} meta={}",
					download.getBucketName(), download.getKey(),
					download.getDescription(), download.getObjectMetadata());
			return true;
		} catch (Exception e) {
			throw new ImageException(e, "Cannot download %s from %s", key, bucket);
		}
	}
	
	@Override
	public String getOriginUri(String namespace, String imageId,
			String styleCode, String styleVariant, String extension) {
		String originAlias; 
		if ("o".equals(styleCode)) {
			originAlias = Strings.isNullOrEmpty(hiOriginAlias) ? hiBucket + ".s3.amazonaws.com" : hiOriginAlias;
		} else {
			originAlias = Strings.isNullOrEmpty(loOriginAlias) ? loBucket + ".s3.amazonaws.com" : loOriginAlias;
		}
		String uriTemplate = "http://" + originAlias + "/" + Strings.nullToEmpty(prefix) +
				"{namespace}/{styleCode}/{imageId}_{styleVariant}.{extension}";
		// namespace, styleCode, imageId, styleVariant, extension
		final Map<String, Object> uriVars = Maps.newHashMap();
		uriVars.put("namespace", namespace);
		uriVars.put("styleCode", styleCode);
		uriVars.put("imageId", imageId);
		uriVars.put("styleVariant", styleVariant);
		uriVars.put("extension", extension);
		return UriTemplate.fromTemplate(uriTemplate).expand(uriVars);
	}
	
} //S3ConnectorImpl

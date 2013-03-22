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
import com.damnhandy.uri.template.UriTemplate;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;

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
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.image.impl.S3ConnectorImpl#getCanonicalUserId <em>Canonical User Id</em>}</li>
 *   <li>{@link org.soluvas.image.impl.S3ConnectorImpl#getBucket <em>Bucket</em>}</li>
 *   <li>{@link org.soluvas.image.impl.S3ConnectorImpl#getTenantId <em>Tenant Id</em>}</li>
 *   <li>{@link org.soluvas.image.impl.S3ConnectorImpl#getTenantEnv <em>Tenant Env</em>}</li>
 *   <li>{@link org.soluvas.image.impl.S3ConnectorImpl#getOriginAlias <em>Origin Alias</em>}</li>
 *   <li>{@link org.soluvas.image.impl.S3ConnectorImpl#getCdnAlias <em>Cdn Alias</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("serial")
public class S3ConnectorImpl extends ImageConnectorImpl implements S3Connector {
	
	/**
	 * The default value of the '{@link #getCanonicalUserId() <em>Canonical User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCanonicalUserId()
	 * @generated
	 * @ordered
	 */
	protected static final String CANONICAL_USER_ID_EDEFAULT = null;
	private static final Logger log = LoggerFactory
			.getLogger(S3ConnectorImpl.class);
	private final TransferManager transferMgr;
	private String canonicalUserId;
	/**
	 * The default value of the '{@link #getBucket() <em>Bucket</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBucket()
	 * @generated
	 * @ordered
	 */
	protected static final String BUCKET_EDEFAULT = null;
	private final String bucket;
	/**
	 * The default value of the '{@link #getTenantId() <em>Tenant Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTenantId()
	 * @generated
	 * @ordered
	 */
	protected static final String TENANT_ID_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getTenantId() <em>Tenant Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTenantId()
	 * @generated
	 * @ordered
	 */
	protected String tenantId = TENANT_ID_EDEFAULT;
	/**
	 * The default value of the '{@link #getTenantEnv() <em>Tenant Env</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTenantEnv()
	 * @generated
	 * @ordered
	 */
	protected static final String TENANT_ENV_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getTenantEnv() <em>Tenant Env</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTenantEnv()
	 * @generated
	 * @ordered
	 */
	protected String tenantEnv = TENANT_ENV_EDEFAULT;
	/**
	 * The default value of the '{@link #getOriginAlias() <em>Origin Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginAlias()
	 * @generated
	 * @ordered
	 */
	protected static final String ORIGIN_ALIAS_EDEFAULT = null;
	private final String originAlias;
	/**
	 * The default value of the '{@link #getCdnAlias() <em>Cdn Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCdnAlias()
	 * @generated
	 * @ordered
	 */
	protected static final String CDN_ALIAS_EDEFAULT = null;
	private String cdnAlias;
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
	 * @param bucket Bucket name for original images, e.g. {@literal berbatik-stg-pichi}.
	 * @param loBucket Bucket name for disposable images, e.g. {@literal berbatik-stg-piclo}.
	 * 		Images will be stored using RRS. Can be the same as bucket.
	 * @param prefix Application-provided prefix, this is usually "${tenantId}_${tenantEnv}/",
	 * 		e.g. "berbatik_dev/".
	 * 		Namespace will be passed by the repository during upload, so it is not needed.
	 * @param originAlias If specified, can be used as alias e.g. using CloudFront.
	 * 		Otherwise use default "berbatik-stg-pichi.s3.amazonaws.com".
	 * @param loOriginAlias If specified, can be used as alias e.g. using CloudFront.
	 * 		Otherwise use default "berbatik-stg-pichi.s3.amazonaws.com".
	 */
	public S3ConnectorImpl(String endpoint, Protocol protocol,
			String accessKey, String secretKey, String canonicalUserId,
			String bucket, String tenantId, String tenantEnv, String originAlias,
			String cdnAlias) {
		super();
		this.canonicalUserId = canonicalUserId;
		if (Strings.isNullOrEmpty(canonicalUserId)) {
			log.warn("Canonical user ID should be filled, otherwise you can't control the S3 objects you uploaded.");
		}
		this.bucket = bucket;
		this.tenantId = tenantId;
		this.tenantEnv = tenantEnv;
		this.originAlias = originAlias;
		this.cdnAlias = cdnAlias;
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
	 * @generated
	 */
	@Override
	public String getCanonicalUserId() {
		return canonicalUserId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBucket() {
		return bucket;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTenantId() {
		return tenantId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTenantEnv() {
		return tenantEnv;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOriginAlias() {
		return originAlias;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCdnAlias() {
		return cdnAlias;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public String getUriTemplate() {
		final String realCdnAlias = Strings.isNullOrEmpty(cdnAlias) ? bucket + ".s3.amazonaws.com" : cdnAlias;
		return "http://" + realCdnAlias + "/" + tenantId + "_" + tenantEnv + "/" +
				"{namespace}/{styleCode}/{imageId}_{styleVariant}.{extension}";
	}
	
	@Override
	public ListenableFuture<UploadedImage> upload(final String namespace, final String imageId,
			final String styleCode, final String styleVariant, final String extension, final File file,
			final String contentType) {
		final SettableFuture<UploadedImage> future = SettableFuture.create();
		final boolean useHi = ImageRepository.ORIGINAL_CODE.equals(styleCode);
		final String key = String.format("%s_%s/%s/%s/%s_%s.%s",
				tenantId, tenantEnv, namespace, styleCode, imageId, styleVariant, extension);
		final AccessControlList acl = new AccessControlList();
		if (!Strings.isNullOrEmpty(canonicalUserId)) {
			acl.grantPermission(new CanonicalGrantee(canonicalUserId), Permission.FullControl);
		}
		acl.grantPermission(GroupGrantee.AllUsers, Permission.Read);
		final PutObjectRequest putReq = new PutObjectRequest(bucket, key, file)
			.withAccessControlList(acl)
			.withStorageClass(useHi ? StorageClass.Standard : StorageClass.ReducedRedundancy);
		final Upload upload = transferMgr.upload(putReq);
		final String s3Uri = "s3://" + bucket + "/" + key;
		upload.addProgressListener(new ProgressListener() {
			@Override
			public void progressChanged(ProgressEvent ev) {
				switch (ev.getEventCode()) {
				case ProgressEvent.STARTED_EVENT_CODE:
					log.debug("Starting upload {} to {} ({} bytes)", file, s3Uri,
							upload.getProgress().getTotalBytesToTransfer());
					break;
				case ProgressEvent.COMPLETED_EVENT_CODE:
					// see: https://github.com/aws/aws-sdk-java/issues/52
//						final UploadResult uploadResult = upload.waitForUploadResult();
//						final UploadResult uploadResult = (UploadResult) ((UploadImpl)upload).getMonitor().getFuture().get();
//						log.info("Uploaded {} to {}, {} bytes transferred: etag={} versionId={} bucket={} key={}",
//								file, s3Uri, ev.getBytesTransfered(),
//								uploadResult.getETag(),
//								uploadResult.getVersionId(),
//								uploadResult.getBucketName(),
//								uploadResult.getKey() );
					log.info("Uploaded {} to {}, {} bytes transferred: bucket={} key={}",
							file, s3Uri, ev.getBytesTransfered(), bucket, key );
					final String realOriginAlias = Strings.isNullOrEmpty(originAlias) ? bucket + ".s3.amazonaws.com" : originAlias;
					final String realCdnAlias = Strings.isNullOrEmpty(cdnAlias) ? bucket + ".s3.amazonaws.com" : cdnAlias;
					final UploadedImage uploadedImage = ImageFactory.eINSTANCE.createUploadedImage();
					uploadedImage.setOriginUri("http://" + realOriginAlias + "/" + key);
					uploadedImage.setUri("http://" + realCdnAlias + "/" + key);
					future.set(uploadedImage);
					break;
				case ProgressEvent.FAILED_EVENT_CODE:
					log.error("Failed upload {} to {}, {} bytes transferred", file, s3Uri,
							ev.getBytesTransfered());
					future.setException(new ImageException("Failed upload " + file + " to " + s3Uri + ". " +
							ev.getBytesTransfered() + " bytes transferred"));
					break;
				case 0:
					// nothing...?
					break;
				default:
					log.error("Unknown error code {} during upload {} to {}, {} bytes transferred",
							ev.getEventCode(), file, s3Uri, ev.getBytesTransfered());
					future.setException(new ImageException(String.format("Unknown error code %s during upload %s to %s, %s bytes transferred",
							ev.getEventCode(), file, s3Uri, ev.getBytesTransfered())));
					break;
				}
			}
		});
		return future;
	}
	
	@Override
	public void delete(String namespace, String imageId, String styleCode,
			String styleVariant, String extension) {
		final String key = String.format("%s_%s/%s/%s/%s_%s.%s",
				tenantId, tenantEnv, namespace, styleCode, imageId, styleVariant, extension);
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
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImagePackage.S3_CONNECTOR__CANONICAL_USER_ID:
				return getCanonicalUserId();
			case ImagePackage.S3_CONNECTOR__BUCKET:
				return getBucket();
			case ImagePackage.S3_CONNECTOR__TENANT_ID:
				return getTenantId();
			case ImagePackage.S3_CONNECTOR__TENANT_ENV:
				return getTenantEnv();
			case ImagePackage.S3_CONNECTOR__ORIGIN_ALIAS:
				return getOriginAlias();
			case ImagePackage.S3_CONNECTOR__CDN_ALIAS:
				return getCdnAlias();
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
			case ImagePackage.S3_CONNECTOR__CANONICAL_USER_ID:
				return CANONICAL_USER_ID_EDEFAULT == null ? canonicalUserId != null : !CANONICAL_USER_ID_EDEFAULT.equals(canonicalUserId);
			case ImagePackage.S3_CONNECTOR__BUCKET:
				return BUCKET_EDEFAULT == null ? bucket != null : !BUCKET_EDEFAULT.equals(bucket);
			case ImagePackage.S3_CONNECTOR__TENANT_ID:
				return TENANT_ID_EDEFAULT == null ? tenantId != null : !TENANT_ID_EDEFAULT.equals(tenantId);
			case ImagePackage.S3_CONNECTOR__TENANT_ENV:
				return TENANT_ENV_EDEFAULT == null ? tenantEnv != null : !TENANT_ENV_EDEFAULT.equals(tenantEnv);
			case ImagePackage.S3_CONNECTOR__ORIGIN_ALIAS:
				return ORIGIN_ALIAS_EDEFAULT == null ? originAlias != null : !ORIGIN_ALIAS_EDEFAULT.equals(originAlias);
			case ImagePackage.S3_CONNECTOR__CDN_ALIAS:
				return CDN_ALIAS_EDEFAULT == null ? cdnAlias != null : !CDN_ALIAS_EDEFAULT.equals(cdnAlias);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (canonicalUserId: ");
		result.append(canonicalUserId);
		result.append(", bucket: ");
		result.append(bucket);
		result.append(", tenantId: ");
		result.append(tenantId);
		result.append(", tenantEnv: ");
		result.append(tenantEnv);
		result.append(", originAlias: ");
		result.append(originAlias);
		result.append(", cdnAlias: ");
		result.append(cdnAlias);
		result.append(')');
		return result.toString();
	}

	@Override
	public boolean download(String namespace, String imageId, String styleCode,
			String styleVariant, String extension, File file) {
		final String key = String.format("%s_%s/%s/%s/%s_%s.%s",
				tenantId, tenantEnv, namespace, styleCode, imageId, styleVariant, extension);
		try {
			final Download download = transferMgr.download(bucket, key, file);
			download.waitForCompletion();
			log.debug("Downloaded s3://{}/{} desc={} meta={}",
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
		final String realOriginAlias = Strings.isNullOrEmpty(originAlias) ? bucket + ".s3.amazonaws.com" : originAlias;
		final String uriTemplate = "http://" + realOriginAlias + "/" + tenantId + "_" + tenantEnv + "/" +
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

/**
 */
package org.soluvas.image.impl;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.image.BlitlineTransformer;
import org.soluvas.image.ImageConnector;
import org.soluvas.image.ImagePackage;
import org.soluvas.image.ImageTransform;
import org.soluvas.image.ImageVariant;
import org.soluvas.image.UploadedImage;
import org.soluvas.image.ResizeToFill;
import org.soluvas.json.JsonUtils;

import com.damnhandy.uri.template.UriTemplate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Blitline Transformer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.image.impl.BlitlineTransformerImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.soluvas.image.impl.BlitlineTransformerImpl#getApplicationId <em>Application Id</em>}</li>
 *   <li>{@link org.soluvas.image.impl.BlitlineTransformerImpl#getBucket <em>Bucket</em>}</li>
 *   <li>{@link org.soluvas.image.impl.BlitlineTransformerImpl#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.soluvas.image.impl.BlitlineTransformerImpl#getKeyTemplate <em>Key Template</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BlitlineTransformerImpl extends EObjectImpl implements BlitlineTransformer {

	private static final Logger log = LoggerFactory
			.getLogger(BlitlineTransformerImpl.class);
	private final DefaultHttpClient client = new DefaultHttpClient(new PoolingClientConnectionManager());
	
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected ImageConnector source;
	/**
	 * The default value of the '{@link #getApplicationId() <em>Application Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationId()
	 * @generated
	 * @ordered
	 */
	protected static final String APPLICATION_ID_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getApplicationId() <em>Application Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationId()
	 * @generated
	 * @ordered
	 */
	protected String applicationId = APPLICATION_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getBucket() <em>Bucket</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBucket()
	 * @generated
	 * @ordered
	 */
	protected static final String BUCKET_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getBucket() <em>Bucket</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBucket()
	 * @generated
	 * @ordered
	 */
	protected String bucket = BUCKET_EDEFAULT;
	/**
	 * The default value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String PREFIX_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrefix()
	 * @generated
	 * @ordered
	 */
	protected String prefix = PREFIX_EDEFAULT;
	/**
	 * The default value of the '{@link #getKeyTemplate() <em>Key Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final String KEY_TEMPLATE_EDEFAULT = "{+prefix}{namespace}/{styleCode}/{imageId}_{styleVariant}.{extension}";
	/**
	 * The cached value of the '{@link #getKeyTemplate() <em>Key Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyTemplate()
	 * @generated
	 * @ordered
	 */
	protected String keyTemplate = KEY_TEMPLATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public BlitlineTransformerImpl() {
		throw new UnsupportedOperationException();
	}
	
	public BlitlineTransformerImpl(ImageConnector source, String applicationId, String bucket, String prefix) {
		super();
		this.applicationId = applicationId;
		this.source = source;
		this.bucket = bucket;
		this.prefix = prefix;
	}
	
	public void destroy() {
		client.getConnectionManager().shutdown();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImagePackage.Literals.BLITLINE_TRANSFORMER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImageConnector getSource() {
		if (source != null && ((EObject)source).eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (ImageConnector)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImagePackage.BLITLINE_TRANSFORMER__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageConnector basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getApplicationId() {
		return applicationId;
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
	public String getPrefix() {
		return prefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getKeyTemplate() {
		return keyTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void transform(String namespace, String imageId, ImageVariant sourceVariant, Map<ImageTransform, ImageVariant> transforms) {
		final String sourceUri = source.getOriginUri(namespace, imageId,
				sourceVariant.getStyleCode(), sourceVariant.getStyleVariant(), sourceVariant.getExtension());
		for (final Entry<ImageTransform, ImageVariant> entry : transforms.entrySet()) {
			final ImageTransform transform = entry.getKey();
			final ImageVariant dest = entry.getValue();
			if (transform instanceof ResizeToFill) {
				final ResizeToFill fx = (ResizeToFill) transform;
				final Map<String, Object> params = new HashMap<String, Object>();
				if (fx.getWidth() != null)
					params.put("width", fx.getWidth());
				if (fx.getHeight() != null)
					params.put("height", fx.getHeight());
				final String jobId = String.format("%s/%s/%s_%s.%s",
						namespace, imageId,
						dest.getStyleCode(), dest.getStyleVariant(), dest.getExtension());
				// namespace, styleCode, imageId, styleVariant, extension
				final Map<String, Object> uriVars = Maps.newHashMap();
				uriVars.put("prefix", prefix);
				uriVars.put("namespace", namespace);
				uriVars.put("styleCode", dest.getStyleCode());
				uriVars.put("imageId", imageId);
				uriVars.put("styleVariant", dest.getStyleVariant());
				uriVars.put("extension", dest.getExtension());
				final String key = UriTemplate.fromTemplate(keyTemplate).expand(uriVars);
				final Job job = new Job(applicationId, sourceUri, new JobFunction("resize_to_fill", params,
						new JobSave(jobId, new JobS3Destination(bucket, key))));
				final String jobJson = JsonUtils.asJson(job);
				log.debug("Sending job {}", jobJson);
				try {
					final HttpPost postReq = new HttpPost("http://api.blitline.com/job");
					postReq.setEntity(new UrlEncodedFormEntity(ImmutableList.of(new BasicNameValuePair("json", jobJson))));
					final HttpResponse response = client.execute(postReq);
					try {
						if (response.getStatusLine().getStatusCode() >= 200 && response.getStatusLine().getStatusCode() < 300)
							log.debug("Job {} returned: {}", jobId, response.getStatusLine());
						else
							log.error("Job {} returned: {}", jobId, response.getStatusLine());
					} finally {
						HttpClientUtils.closeQuietly(response);
					}
				} catch (Exception e) {
					log.error("Error processing " + sourceVariant + " as " + transform + " to " + dest, e);
				}
			} else {
				throw new UnsupportedOperationException("Transform not supported: " + transform);
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImagePackage.BLITLINE_TRANSFORMER__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case ImagePackage.BLITLINE_TRANSFORMER__APPLICATION_ID:
				return getApplicationId();
			case ImagePackage.BLITLINE_TRANSFORMER__BUCKET:
				return getBucket();
			case ImagePackage.BLITLINE_TRANSFORMER__PREFIX:
				return getPrefix();
			case ImagePackage.BLITLINE_TRANSFORMER__KEY_TEMPLATE:
				return getKeyTemplate();
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
			case ImagePackage.BLITLINE_TRANSFORMER__SOURCE:
				return source != null;
			case ImagePackage.BLITLINE_TRANSFORMER__APPLICATION_ID:
				return APPLICATION_ID_EDEFAULT == null ? applicationId != null : !APPLICATION_ID_EDEFAULT.equals(applicationId);
			case ImagePackage.BLITLINE_TRANSFORMER__BUCKET:
				return BUCKET_EDEFAULT == null ? bucket != null : !BUCKET_EDEFAULT.equals(bucket);
			case ImagePackage.BLITLINE_TRANSFORMER__PREFIX:
				return PREFIX_EDEFAULT == null ? prefix != null : !PREFIX_EDEFAULT.equals(prefix);
			case ImagePackage.BLITLINE_TRANSFORMER__KEY_TEMPLATE:
				return KEY_TEMPLATE_EDEFAULT == null ? keyTemplate != null : !KEY_TEMPLATE_EDEFAULT.equals(keyTemplate);
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
		result.append(" (applicationId: ");
		result.append(applicationId);
		result.append(", bucket: ");
		result.append(bucket);
		result.append(", prefix: ");
		result.append(prefix);
		result.append(", keyTemplate: ");
		result.append(keyTemplate);
		result.append(')');
		return result.toString();
	}

} //BlitlineTransformerImpl

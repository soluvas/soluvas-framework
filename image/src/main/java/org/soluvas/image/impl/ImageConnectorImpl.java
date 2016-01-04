/**
 */
package org.soluvas.image.impl;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ExecutorService;

import com.google.common.base.Preconditions;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.image.ImageConnector;
import org.soluvas.image.ImageException;
import org.soluvas.image.ImagePackage;
import org.soluvas.image.UploadedImage;

import com.damnhandy.uri.template.MalformedUriTemplateException;
import com.damnhandy.uri.template.UriTemplate;
import com.damnhandy.uri.template.VariableExpansionException;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.image.impl.ImageConnectorImpl#getHiUriTemplate <em>Hi Uri Template</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ImageConnectorImpl#getUriTemplate <em>Uri Template</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ImageConnectorImpl#getExecutor <em>Executor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ImageConnectorImpl extends EObjectImpl implements ImageConnector {
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
	 * The default value of the '{@link #getUriTemplate() <em>Uri Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUriTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_TEMPLATE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getExecutor() <em>Executor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutor()
	 * @ordered
	 */
	protected static final ListeningExecutorService EXECUTOR_EDEFAULT = MoreExecutors.sameThreadExecutor();
	/**
	 * The cached value of the '{@link #getExecutor() <em>Executor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutor()
	 * @generated
	 * @ordered
	 */
	protected ListeningExecutorService executor = EXECUTOR_EDEFAULT;

	protected final Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageConnectorImpl() {
		super();
	}
	
	public ImageConnectorImpl(ExecutorService executor) {
		super();
		this.executor = MoreExecutors.listeningDecorator(executor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImagePackage.Literals.IMAGE_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getHiUriTemplate() {
		// TODO: implement this method to return the 'Hi Uri Template' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public abstract String getUriTemplate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ListeningExecutorService getExecutor() {
		return executor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public abstract ListenableFuture<UploadedImage> upload(String namespace, String imageId, String styleCode, String styleVariant, String extension, File file, String contentType);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public abstract boolean download(String namespace, String imageId, String styleCode, String styleVariant, String extension, File file);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public abstract void delete(String namespace, String imageId, String styleCode, String styleVariant, String extension);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public final String getUri(String namespace, String imageId, String styleCode, String styleVariant, String extension) {
		if (null == getUriTemplate()) {
			throw new UnsupportedOperationException(getClass().getSimpleName() + " does not support getUri(), caller must understand this");
		}
		// namespace, styleCode, imageId, styleVariant, extension
		final Map<String, Object> uriVars = Maps.newHashMap();
		uriVars.put("namespace", namespace);
		uriVars.put("styleCode", styleCode);
		uriVars.put("imageId", imageId);
		uriVars.put("styleVariant", styleVariant);
		uriVars.put("extension", extension);
		try {
			return UriTemplate.fromTemplate(getUriTemplate()).expand(uriVars);
		} catch (final Exception e) {
			throw new ImageException(e, "Cannot expand URI template '%s' using %s", getUriTemplate(), uriVars);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public String getOriginUri(String namespace, String imageId, String styleCode, String styleVariant, String extension) {
		return getUri(namespace, imageId, styleCode, styleVariant, extension);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void destroy() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImagePackage.IMAGE_CONNECTOR__HI_URI_TEMPLATE:
				return getHiUriTemplate();
			case ImagePackage.IMAGE_CONNECTOR__URI_TEMPLATE:
				return getUriTemplate();
			case ImagePackage.IMAGE_CONNECTOR__EXECUTOR:
				return getExecutor();
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
			case ImagePackage.IMAGE_CONNECTOR__HI_URI_TEMPLATE:
				return HI_URI_TEMPLATE_EDEFAULT == null ? getHiUriTemplate() != null : !HI_URI_TEMPLATE_EDEFAULT.equals(getHiUriTemplate());
			case ImagePackage.IMAGE_CONNECTOR__URI_TEMPLATE:
				return URI_TEMPLATE_EDEFAULT == null ? getUriTemplate() != null : !URI_TEMPLATE_EDEFAULT.equals(getUriTemplate());
			case ImagePackage.IMAGE_CONNECTOR__EXECUTOR:
				return EXECUTOR_EDEFAULT == null ? executor != null : !EXECUTOR_EDEFAULT.equals(executor);
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
		result.append(" (executor: ");
		result.append(executor);
		result.append(')');
		return result.toString();
	}

} //ImageConnectorImpl

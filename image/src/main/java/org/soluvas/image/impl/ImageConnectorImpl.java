/**
 */
package org.soluvas.image.impl;

import java.io.File;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.soluvas.image.ImageConnector;
import org.soluvas.image.ImagePackage;
import org.soluvas.image.UploadedImage;

import com.damnhandy.uri.template.UriTemplate;
import com.google.common.collect.Maps;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.image.impl.ImageConnectorImpl#getHiUriTemplate <em>Hi Uri Template</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ImageConnectorImpl#getLoUriTemplate <em>Lo Uri Template</em>}</li>
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
	 * The default value of the '{@link #getLoUriTemplate() <em>Lo Uri Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoUriTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final String LO_URI_TEMPLATE_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageConnectorImpl() {
		super();
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
	 */
	@Override
	public abstract String getHiUriTemplate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public abstract String getLoUriTemplate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public abstract UploadedImage upload(String namespace, String imageId, String styleCode, String extension, File file, String contentType);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public abstract void delete(String namespace, String imageId, String styleCode, String extension);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void destroy() {
		// nothing
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public abstract boolean download(String namespace, String imageId, String styleCode, String extension, File file);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public final String getUri(String namespace, String imageId, String styleCode, String styleVariant, String extension) {
		String uriTemplate = "o".equals(styleCode) ? getHiUriTemplate() : getLoUriTemplate();
		// namespace, styleCode, imageId, styleVariant, extension
		final Map<String, Object> uriVars = Maps.newHashMap();
		uriVars.put("namespace", namespace);
		uriVars.put("styleCode", styleCode);
		uriVars.put("imageId", imageId);
		uriVars.put("styleVariant", styleVariant);
		uriVars.put("extension", extension);
		uriVars.put("ext", extension);
		return UriTemplate.fromTemplate(uriTemplate).expand(uriVars);
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImagePackage.IMAGE_CONNECTOR__HI_URI_TEMPLATE:
				return getHiUriTemplate();
			case ImagePackage.IMAGE_CONNECTOR__LO_URI_TEMPLATE:
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
			case ImagePackage.IMAGE_CONNECTOR__HI_URI_TEMPLATE:
				return HI_URI_TEMPLATE_EDEFAULT == null ? getHiUriTemplate() != null : !HI_URI_TEMPLATE_EDEFAULT.equals(getHiUriTemplate());
			case ImagePackage.IMAGE_CONNECTOR__LO_URI_TEMPLATE:
				return LO_URI_TEMPLATE_EDEFAULT == null ? getLoUriTemplate() != null : !LO_URI_TEMPLATE_EDEFAULT.equals(getLoUriTemplate());
		}
		return super.eIsSet(featureID);
	}

} //ImageConnectorImpl

/**
 */
package org.soluvas.social.impl;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.Describable;
import org.soluvas.social.SocialPackage;
import org.soluvas.social.Target;
import org.soluvas.social.schema.TargetType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.social.impl.TargetImpl#getNsPrefix <em>Ns Prefix</em>}</li>
 *   <li>{@link org.soluvas.social.impl.TargetImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.soluvas.social.impl.TargetImpl#getTargetType <em>Target Type</em>}</li>
 *   <li>{@link org.soluvas.social.impl.TargetImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.soluvas.social.impl.TargetImpl#getImages <em>Images</em>}</li>
 *   <li>{@link org.soluvas.social.impl.TargetImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link org.soluvas.social.impl.TargetImpl#getTypeName <em>Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TargetImpl extends EObjectImpl implements Target {
	/**
	 * The default value of the '{@link #getNsPrefix() <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String NS_PREFIX_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getNsPrefix() <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected String nsPrefix = NS_PREFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTargetType() <em>Target Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetType()
	 * @generated
	 * @ordered
	 */
	protected TargetType targetType;

	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getImages() <em>Images</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImages()
	 * @generated
	 * @ordered
	 */
	protected List<String> images;

	/**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected String uri = URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getTypeName() <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeName()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTypeName() <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeName()
	 * @generated
	 * @ordered
	 */
	protected String typeName = TYPE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SocialPackage.Literals.TARGET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNsPrefix() {
		return nsPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNsPrefix(String newNsPrefix) {
		String oldNsPrefix = nsPrefix;
		nsPrefix = newNsPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SocialPackage.TARGET__NS_PREFIX, oldNsPrefix, nsPrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SocialPackage.TARGET__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTypeName() {
		return typeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTypeName(String newTypeName) {
		String oldTypeName = typeName;
		typeName = newTypeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SocialPackage.TARGET__TYPE_NAME, oldTypeName, typeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TargetType getTargetType() {
		if (targetType != null && ((EObject)targetType).eIsProxy()) {
			InternalEObject oldTargetType = (InternalEObject)targetType;
			targetType = (TargetType)eResolveProxy(oldTargetType);
			if (targetType != oldTargetType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SocialPackage.TARGET__TARGET_TYPE, oldTargetType, targetType));
			}
		}
		return targetType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetType basicGetTargetType() {
		return targetType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void setTargetType(TargetType newTargetType) {
		TargetType oldTargetType = targetType;
		targetType = newTargetType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SocialPackage.TARGET__TARGET_TYPE, oldTargetType, targetType));
		
		// Set name and nsPrefix based on this TargetType
		if (newTargetType != null) {
			setTypeName(newTargetType.getName());
			if (newTargetType.getEClass() != null)
				setNsPrefix(newTargetType.getNsPrefix());
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SocialPackage.TARGET__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<String> getImages() {
		return images;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImages(List<String> newImages) {
		List<String> oldImages = images;
		images = newImages;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SocialPackage.TARGET__IMAGES, oldImages, images));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUri() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUri(String newUri) {
		String oldUri = uri;
		uri = newUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SocialPackage.TARGET__URI, oldUri, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SocialPackage.TARGET__NS_PREFIX:
				return getNsPrefix();
			case SocialPackage.TARGET__DESCRIPTION:
				return getDescription();
			case SocialPackage.TARGET__TARGET_TYPE:
				if (resolve) return getTargetType();
				return basicGetTargetType();
			case SocialPackage.TARGET__TITLE:
				return getTitle();
			case SocialPackage.TARGET__IMAGES:
				return getImages();
			case SocialPackage.TARGET__URI:
				return getUri();
			case SocialPackage.TARGET__TYPE_NAME:
				return getTypeName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SocialPackage.TARGET__NS_PREFIX:
				setNsPrefix((String)newValue);
				return;
			case SocialPackage.TARGET__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case SocialPackage.TARGET__TARGET_TYPE:
				setTargetType((TargetType)newValue);
				return;
			case SocialPackage.TARGET__TITLE:
				setTitle((String)newValue);
				return;
			case SocialPackage.TARGET__IMAGES:
				setImages((List<String>)newValue);
				return;
			case SocialPackage.TARGET__URI:
				setUri((String)newValue);
				return;
			case SocialPackage.TARGET__TYPE_NAME:
				setTypeName((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SocialPackage.TARGET__NS_PREFIX:
				setNsPrefix(NS_PREFIX_EDEFAULT);
				return;
			case SocialPackage.TARGET__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case SocialPackage.TARGET__TARGET_TYPE:
				setTargetType((TargetType)null);
				return;
			case SocialPackage.TARGET__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case SocialPackage.TARGET__IMAGES:
				setImages((List<String>)null);
				return;
			case SocialPackage.TARGET__URI:
				setUri(URI_EDEFAULT);
				return;
			case SocialPackage.TARGET__TYPE_NAME:
				setTypeName(TYPE_NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SocialPackage.TARGET__NS_PREFIX:
				return NS_PREFIX_EDEFAULT == null ? nsPrefix != null : !NS_PREFIX_EDEFAULT.equals(nsPrefix);
			case SocialPackage.TARGET__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case SocialPackage.TARGET__TARGET_TYPE:
				return targetType != null;
			case SocialPackage.TARGET__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case SocialPackage.TARGET__IMAGES:
				return images != null;
			case SocialPackage.TARGET__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case SocialPackage.TARGET__TYPE_NAME:
				return TYPE_NAME_EDEFAULT == null ? typeName != null : !TYPE_NAME_EDEFAULT.equals(typeName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Describable.class) {
			switch (derivedFeatureID) {
				case SocialPackage.TARGET__DESCRIPTION: return CommonsPackage.DESCRIBABLE__DESCRIPTION;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Describable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.DESCRIBABLE__DESCRIPTION: return SocialPackage.TARGET__DESCRIPTION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (nsPrefix: ");
		result.append(nsPrefix);
		result.append(", description: ");
		result.append(description);
		result.append(", title: ");
		result.append(title);
		result.append(", images: ");
		result.append(images);
		result.append(", uri: ");
		result.append(uri);
		result.append(", typeName: ");
		result.append(typeName);
		result.append(')');
		return result.toString();
	}

} //TargetImpl

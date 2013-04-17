/**
 */
package org.soluvas.commons.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.Gender;
import org.soluvas.commons.Imageable;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.Nameable;
import org.soluvas.commons.PersonInfo;
import org.soluvas.commons.PhotoIdContainer;
import org.soluvas.commons.Sluggable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PersonInfo</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.commons.impl.PersonInfoImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonInfoImpl#getPhotoId <em>Photo Id</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonInfoImpl#getSlug <em>Slug</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonInfoImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonInfoImpl#getGender <em>Gender</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonInfoImpl#getEmail <em>Email</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PersonInfoImpl extends EObjectImpl implements PersonInfo {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getPhotoId() <em>Photo Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhotoId()
	 * @generated
	 * @ordered
	 */
	protected static final String PHOTO_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPhotoId() <em>Photo Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhotoId()
	 * @generated
	 * @ordered
	 */
	protected String photoId = PHOTO_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getSlug() <em>Slug</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlug()
	 * @generated
	 * @ordered
	 */
	protected static final String SLUG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSlug() <em>Slug</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlug()
	 * @generated
	 * @ordered
	 */
	protected String slug = SLUG_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getGender() <em>Gender</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGender()
	 * @generated
	 * @ordered
	 */
	protected static final Gender GENDER_EDEFAULT = Gender.MALE;

	/**
	 * The cached value of the '{@link #getGender() <em>Gender</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGender()
	 * @generated
	 * @ordered
	 */
	protected Gender gender = GENDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getEmail() <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmail()
	 * @generated
	 * @ordered
	 */
	protected static final String EMAIL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEmail() <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmail()
	 * @generated
	 * @ordered
	 */
	protected String email = EMAIL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PersonInfoImpl() {
		super();
	}

	public PersonInfoImpl(String personId) {
		super();
		setId(personId);
		setSlug(personId);
		setName(personId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonsPackage.Literals.PERSON_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON_INFO__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSlug() {
		return slug;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSlug(String newSlug) {
		String oldSlug = slug;
		slug = newSlug;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON_INFO__SLUG, oldSlug, slug));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON_INFO__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	@JsonProperty
	public String getImageId() {
		return getPhotoId();
	}
	
	@JsonIgnore
	private void setImageId(String imageId) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPhotoId() {
		return photoId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPhotoId(String newPhotoId) {
		String oldPhotoId = photoId;
		photoId = newPhotoId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON_INFO__PHOTO_ID, oldPhotoId, photoId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Gender getGender() {
		return gender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGender(Gender newGender) {
		Gender oldGender = gender;
		gender = newGender == null ? GENDER_EDEFAULT : newGender;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON_INFO__GENDER, oldGender, gender));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEmail() {
		return email;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEmail(String newEmail) {
		String oldEmail = email;
		email = newEmail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON_INFO__EMAIL, oldEmail, email));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonsPackage.PERSON_INFO__ID:
				return getId();
			case CommonsPackage.PERSON_INFO__PHOTO_ID:
				return getPhotoId();
			case CommonsPackage.PERSON_INFO__SLUG:
				return getSlug();
			case CommonsPackage.PERSON_INFO__NAME:
				return getName();
			case CommonsPackage.PERSON_INFO__GENDER:
				return getGender();
			case CommonsPackage.PERSON_INFO__EMAIL:
				return getEmail();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CommonsPackage.PERSON_INFO__ID:
				setId((String)newValue);
				return;
			case CommonsPackage.PERSON_INFO__PHOTO_ID:
				setPhotoId((String)newValue);
				return;
			case CommonsPackage.PERSON_INFO__SLUG:
				setSlug((String)newValue);
				return;
			case CommonsPackage.PERSON_INFO__NAME:
				setName((String)newValue);
				return;
			case CommonsPackage.PERSON_INFO__GENDER:
				setGender((Gender)newValue);
				return;
			case CommonsPackage.PERSON_INFO__EMAIL:
				setEmail((String)newValue);
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
			case CommonsPackage.PERSON_INFO__ID:
				setId(ID_EDEFAULT);
				return;
			case CommonsPackage.PERSON_INFO__PHOTO_ID:
				setPhotoId(PHOTO_ID_EDEFAULT);
				return;
			case CommonsPackage.PERSON_INFO__SLUG:
				setSlug(SLUG_EDEFAULT);
				return;
			case CommonsPackage.PERSON_INFO__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CommonsPackage.PERSON_INFO__GENDER:
				setGender(GENDER_EDEFAULT);
				return;
			case CommonsPackage.PERSON_INFO__EMAIL:
				setEmail(EMAIL_EDEFAULT);
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
			case CommonsPackage.PERSON_INFO__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case CommonsPackage.PERSON_INFO__PHOTO_ID:
				return PHOTO_ID_EDEFAULT == null ? photoId != null : !PHOTO_ID_EDEFAULT.equals(photoId);
			case CommonsPackage.PERSON_INFO__SLUG:
				return SLUG_EDEFAULT == null ? slug != null : !SLUG_EDEFAULT.equals(slug);
			case CommonsPackage.PERSON_INFO__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CommonsPackage.PERSON_INFO__GENDER:
				return gender != GENDER_EDEFAULT;
			case CommonsPackage.PERSON_INFO__EMAIL:
				return EMAIL_EDEFAULT == null ? email != null : !EMAIL_EDEFAULT.equals(email);
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
		if (baseClass == Imageable.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == PhotoIdContainer.class) {
			switch (derivedFeatureID) {
				case CommonsPackage.PERSON_INFO__PHOTO_ID: return CommonsPackage.PHOTO_ID_CONTAINER__PHOTO_ID;
				default: return -1;
			}
		}
		if (baseClass == Sluggable.class) {
			switch (derivedFeatureID) {
				case CommonsPackage.PERSON_INFO__SLUG: return CommonsPackage.SLUGGABLE__SLUG;
				default: return -1;
			}
		}
		if (baseClass == Nameable.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == NameContainer.class) {
			switch (derivedFeatureID) {
				case CommonsPackage.PERSON_INFO__NAME: return CommonsPackage.NAME_CONTAINER__NAME;
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
		if (baseClass == Imageable.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == PhotoIdContainer.class) {
			switch (baseFeatureID) {
				case CommonsPackage.PHOTO_ID_CONTAINER__PHOTO_ID: return CommonsPackage.PERSON_INFO__PHOTO_ID;
				default: return -1;
			}
		}
		if (baseClass == Sluggable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.SLUGGABLE__SLUG: return CommonsPackage.PERSON_INFO__SLUG;
				default: return -1;
			}
		}
		if (baseClass == Nameable.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == NameContainer.class) {
			switch (baseFeatureID) {
				case CommonsPackage.NAME_CONTAINER__NAME: return CommonsPackage.PERSON_INFO__NAME;
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
		result.append(" (id: ");
		result.append(id);
		result.append(", photoId: ");
		result.append(photoId);
		result.append(", slug: ");
		result.append(slug);
		result.append(", name: ");
		result.append(name);
		result.append(", gender: ");
		result.append(gender);
		result.append(", email: ");
		result.append(email);
		result.append(')');
		return result.toString();
	}

} //PersonInfoImpl

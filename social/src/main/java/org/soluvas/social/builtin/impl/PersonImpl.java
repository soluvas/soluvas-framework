/**
 */
package org.soluvas.social.builtin.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.Gender;
import org.soluvas.commons.Identifiable;
import org.soluvas.commons.Imageable;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.Nameable;
import org.soluvas.commons.PhotoIdContainer;
import org.soluvas.commons.Sluggable;
import org.soluvas.social.PersonLike;
import org.soluvas.social.SocialPackage;
import org.soluvas.social.builtin.BuiltinPackage;
import org.soluvas.social.builtin.Person;
import org.soluvas.social.impl.TargetImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.social.builtin.impl.PersonImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.soluvas.social.builtin.impl.PersonImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.soluvas.social.builtin.impl.PersonImpl#getPhotoId <em>Photo Id</em>}</li>
 *   <li>{@link org.soluvas.social.builtin.impl.PersonImpl#getSlug <em>Slug</em>}</li>
 *   <li>{@link org.soluvas.social.builtin.impl.PersonImpl#getFirstName <em>First Name</em>}</li>
 *   <li>{@link org.soluvas.social.builtin.impl.PersonImpl#getLastName <em>Last Name</em>}</li>
 *   <li>{@link org.soluvas.social.builtin.impl.PersonImpl#getUsername <em>Username</em>}</li>
 *   <li>{@link org.soluvas.social.builtin.impl.PersonImpl#getGender <em>Gender</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PersonImpl extends TargetImpl implements Person {
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
	 * The default value of the '{@link #getFirstName() <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstName()
	 * @generated
	 * @ordered
	 */
	protected static final String FIRST_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFirstName() <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstName()
	 * @generated
	 * @ordered
	 */
	protected String firstName = FIRST_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastName() <em>Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastName()
	 * @generated
	 * @ordered
	 */
	protected static final String LAST_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastName() <em>Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastName()
	 * @generated
	 * @ordered
	 */
	protected String lastName = LAST_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected static final String USERNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected String username = USERNAME_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PersonImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BuiltinPackage.Literals.PERSON;
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
			eNotify(new ENotificationImpl(this, Notification.SET, BuiltinPackage.PERSON__GENDER, oldGender, gender));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BuiltinPackage.PERSON__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BuiltinPackage.PERSON__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BuiltinPackage.PERSON__PHOTO_ID, oldPhotoId, photoId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BuiltinPackage.PERSON__SLUG, oldSlug, slug));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public String getImageId() {
		return getPhotoId();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUsername() {
		return username;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUsername(String newUsername) {
		String oldUsername = username;
		username = newUsername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuiltinPackage.PERSON__USERNAME, oldUsername, username));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLastName() {
		return lastName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLastName(String newLastName) {
		String oldLastName = lastName;
		lastName = newLastName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuiltinPackage.PERSON__LAST_NAME, oldLastName, lastName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFirstName() {
		return firstName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFirstName(String newFirstName) {
		String oldFirstName = firstName;
		firstName = newFirstName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuiltinPackage.PERSON__FIRST_NAME, oldFirstName, firstName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BuiltinPackage.PERSON__ID:
				return getId();
			case BuiltinPackage.PERSON__NAME:
				return getName();
			case BuiltinPackage.PERSON__PHOTO_ID:
				return getPhotoId();
			case BuiltinPackage.PERSON__SLUG:
				return getSlug();
			case BuiltinPackage.PERSON__FIRST_NAME:
				return getFirstName();
			case BuiltinPackage.PERSON__LAST_NAME:
				return getLastName();
			case BuiltinPackage.PERSON__USERNAME:
				return getUsername();
			case BuiltinPackage.PERSON__GENDER:
				return getGender();
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
			case BuiltinPackage.PERSON__ID:
				setId((String)newValue);
				return;
			case BuiltinPackage.PERSON__NAME:
				setName((String)newValue);
				return;
			case BuiltinPackage.PERSON__PHOTO_ID:
				setPhotoId((String)newValue);
				return;
			case BuiltinPackage.PERSON__SLUG:
				setSlug((String)newValue);
				return;
			case BuiltinPackage.PERSON__FIRST_NAME:
				setFirstName((String)newValue);
				return;
			case BuiltinPackage.PERSON__LAST_NAME:
				setLastName((String)newValue);
				return;
			case BuiltinPackage.PERSON__USERNAME:
				setUsername((String)newValue);
				return;
			case BuiltinPackage.PERSON__GENDER:
				setGender((Gender)newValue);
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
			case BuiltinPackage.PERSON__ID:
				setId(ID_EDEFAULT);
				return;
			case BuiltinPackage.PERSON__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BuiltinPackage.PERSON__PHOTO_ID:
				setPhotoId(PHOTO_ID_EDEFAULT);
				return;
			case BuiltinPackage.PERSON__SLUG:
				setSlug(SLUG_EDEFAULT);
				return;
			case BuiltinPackage.PERSON__FIRST_NAME:
				setFirstName(FIRST_NAME_EDEFAULT);
				return;
			case BuiltinPackage.PERSON__LAST_NAME:
				setLastName(LAST_NAME_EDEFAULT);
				return;
			case BuiltinPackage.PERSON__USERNAME:
				setUsername(USERNAME_EDEFAULT);
				return;
			case BuiltinPackage.PERSON__GENDER:
				setGender(GENDER_EDEFAULT);
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
			case BuiltinPackage.PERSON__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case BuiltinPackage.PERSON__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case BuiltinPackage.PERSON__PHOTO_ID:
				return PHOTO_ID_EDEFAULT == null ? photoId != null : !PHOTO_ID_EDEFAULT.equals(photoId);
			case BuiltinPackage.PERSON__SLUG:
				return SLUG_EDEFAULT == null ? slug != null : !SLUG_EDEFAULT.equals(slug);
			case BuiltinPackage.PERSON__FIRST_NAME:
				return FIRST_NAME_EDEFAULT == null ? firstName != null : !FIRST_NAME_EDEFAULT.equals(firstName);
			case BuiltinPackage.PERSON__LAST_NAME:
				return LAST_NAME_EDEFAULT == null ? lastName != null : !LAST_NAME_EDEFAULT.equals(lastName);
			case BuiltinPackage.PERSON__USERNAME:
				return USERNAME_EDEFAULT == null ? username != null : !USERNAME_EDEFAULT.equals(username);
			case BuiltinPackage.PERSON__GENDER:
				return gender != GENDER_EDEFAULT;
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
		if (baseClass == Identifiable.class) {
			switch (derivedFeatureID) {
				case BuiltinPackage.PERSON__ID: return CommonsPackage.IDENTIFIABLE__ID;
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
				case BuiltinPackage.PERSON__NAME: return CommonsPackage.NAME_CONTAINER__NAME;
				default: return -1;
			}
		}
		if (baseClass == Imageable.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == PhotoIdContainer.class) {
			switch (derivedFeatureID) {
				case BuiltinPackage.PERSON__PHOTO_ID: return CommonsPackage.PHOTO_ID_CONTAINER__PHOTO_ID;
				default: return -1;
			}
		}
		if (baseClass == Sluggable.class) {
			switch (derivedFeatureID) {
				case BuiltinPackage.PERSON__SLUG: return CommonsPackage.SLUGGABLE__SLUG;
				default: return -1;
			}
		}
		if (baseClass == PersonLike.class) {
			switch (derivedFeatureID) {
				case BuiltinPackage.PERSON__FIRST_NAME: return SocialPackage.PERSON_LIKE__FIRST_NAME;
				case BuiltinPackage.PERSON__LAST_NAME: return SocialPackage.PERSON_LIKE__LAST_NAME;
				case BuiltinPackage.PERSON__USERNAME: return SocialPackage.PERSON_LIKE__USERNAME;
				case BuiltinPackage.PERSON__GENDER: return SocialPackage.PERSON_LIKE__GENDER;
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
		if (baseClass == Identifiable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.IDENTIFIABLE__ID: return BuiltinPackage.PERSON__ID;
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
				case CommonsPackage.NAME_CONTAINER__NAME: return BuiltinPackage.PERSON__NAME;
				default: return -1;
			}
		}
		if (baseClass == Imageable.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == PhotoIdContainer.class) {
			switch (baseFeatureID) {
				case CommonsPackage.PHOTO_ID_CONTAINER__PHOTO_ID: return BuiltinPackage.PERSON__PHOTO_ID;
				default: return -1;
			}
		}
		if (baseClass == Sluggable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.SLUGGABLE__SLUG: return BuiltinPackage.PERSON__SLUG;
				default: return -1;
			}
		}
		if (baseClass == PersonLike.class) {
			switch (baseFeatureID) {
				case SocialPackage.PERSON_LIKE__FIRST_NAME: return BuiltinPackage.PERSON__FIRST_NAME;
				case SocialPackage.PERSON_LIKE__LAST_NAME: return BuiltinPackage.PERSON__LAST_NAME;
				case SocialPackage.PERSON_LIKE__USERNAME: return BuiltinPackage.PERSON__USERNAME;
				case SocialPackage.PERSON_LIKE__GENDER: return BuiltinPackage.PERSON__GENDER;
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
		result.append(", name: ");
		result.append(name);
		result.append(", photoId: ");
		result.append(photoId);
		result.append(", slug: ");
		result.append(slug);
		result.append(", firstName: ");
		result.append(firstName);
		result.append(", lastName: ");
		result.append(lastName);
		result.append(", username: ");
		result.append(username);
		result.append(", gender: ");
		result.append(gender);
		result.append(')');
		return result.toString();
	}

} //PersonImpl

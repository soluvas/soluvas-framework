/**
 */
package org.soluvas.social.builtin.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.soluvas.commons.Gender;
import org.soluvas.social.PersonLike;
import org.soluvas.social.SocialPackage;
import org.soluvas.social.builtin.BuiltinPackage;
import org.soluvas.social.builtin.ExternalProfile;
import org.soluvas.social.impl.TargetImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Profile</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.social.builtin.impl.ExternalProfileImpl#getFirstName <em>First Name</em>}</li>
 *   <li>{@link org.soluvas.social.builtin.impl.ExternalProfileImpl#getLastName <em>Last Name</em>}</li>
 *   <li>{@link org.soluvas.social.builtin.impl.ExternalProfileImpl#getUsername <em>Username</em>}</li>
 *   <li>{@link org.soluvas.social.builtin.impl.ExternalProfileImpl#getGender <em>Gender</em>}</li>
 *   <li>{@link org.soluvas.social.builtin.impl.ExternalProfileImpl#getProfileId <em>Profile Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternalProfileImpl extends TargetImpl implements ExternalProfile {
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
	protected static final Gender GENDER_EDEFAULT = Gender.UNKNOWN;

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
	 * The default value of the '{@link #getProfileId() <em>Profile Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfileId()
	 * @generated
	 * @ordered
	 */
	protected static final String PROFILE_ID_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getProfileId() <em>Profile Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfileId()
	 * @generated
	 * @ordered
	 */
	protected String profileId = PROFILE_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalProfileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BuiltinPackage.Literals.EXTERNAL_PROFILE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, BuiltinPackage.EXTERNAL_PROFILE__GENDER, oldGender, gender));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BuiltinPackage.EXTERNAL_PROFILE__USERNAME, oldUsername, username));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BuiltinPackage.EXTERNAL_PROFILE__LAST_NAME, oldLastName, lastName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BuiltinPackage.EXTERNAL_PROFILE__FIRST_NAME, oldFirstName, firstName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getProfileId() {
		return profileId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProfileId(String newProfileId) {
		String oldProfileId = profileId;
		profileId = newProfileId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuiltinPackage.EXTERNAL_PROFILE__PROFILE_ID, oldProfileId, profileId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BuiltinPackage.EXTERNAL_PROFILE__FIRST_NAME:
				return getFirstName();
			case BuiltinPackage.EXTERNAL_PROFILE__LAST_NAME:
				return getLastName();
			case BuiltinPackage.EXTERNAL_PROFILE__USERNAME:
				return getUsername();
			case BuiltinPackage.EXTERNAL_PROFILE__GENDER:
				return getGender();
			case BuiltinPackage.EXTERNAL_PROFILE__PROFILE_ID:
				return getProfileId();
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
			case BuiltinPackage.EXTERNAL_PROFILE__FIRST_NAME:
				setFirstName((String)newValue);
				return;
			case BuiltinPackage.EXTERNAL_PROFILE__LAST_NAME:
				setLastName((String)newValue);
				return;
			case BuiltinPackage.EXTERNAL_PROFILE__USERNAME:
				setUsername((String)newValue);
				return;
			case BuiltinPackage.EXTERNAL_PROFILE__GENDER:
				setGender((Gender)newValue);
				return;
			case BuiltinPackage.EXTERNAL_PROFILE__PROFILE_ID:
				setProfileId((String)newValue);
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
			case BuiltinPackage.EXTERNAL_PROFILE__FIRST_NAME:
				setFirstName(FIRST_NAME_EDEFAULT);
				return;
			case BuiltinPackage.EXTERNAL_PROFILE__LAST_NAME:
				setLastName(LAST_NAME_EDEFAULT);
				return;
			case BuiltinPackage.EXTERNAL_PROFILE__USERNAME:
				setUsername(USERNAME_EDEFAULT);
				return;
			case BuiltinPackage.EXTERNAL_PROFILE__GENDER:
				setGender(GENDER_EDEFAULT);
				return;
			case BuiltinPackage.EXTERNAL_PROFILE__PROFILE_ID:
				setProfileId(PROFILE_ID_EDEFAULT);
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
			case BuiltinPackage.EXTERNAL_PROFILE__FIRST_NAME:
				return FIRST_NAME_EDEFAULT == null ? firstName != null : !FIRST_NAME_EDEFAULT.equals(firstName);
			case BuiltinPackage.EXTERNAL_PROFILE__LAST_NAME:
				return LAST_NAME_EDEFAULT == null ? lastName != null : !LAST_NAME_EDEFAULT.equals(lastName);
			case BuiltinPackage.EXTERNAL_PROFILE__USERNAME:
				return USERNAME_EDEFAULT == null ? username != null : !USERNAME_EDEFAULT.equals(username);
			case BuiltinPackage.EXTERNAL_PROFILE__GENDER:
				return gender != GENDER_EDEFAULT;
			case BuiltinPackage.EXTERNAL_PROFILE__PROFILE_ID:
				return PROFILE_ID_EDEFAULT == null ? profileId != null : !PROFILE_ID_EDEFAULT.equals(profileId);
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
		if (baseClass == PersonLike.class) {
			switch (derivedFeatureID) {
				case BuiltinPackage.EXTERNAL_PROFILE__FIRST_NAME: return SocialPackage.PERSON_LIKE__FIRST_NAME;
				case BuiltinPackage.EXTERNAL_PROFILE__LAST_NAME: return SocialPackage.PERSON_LIKE__LAST_NAME;
				case BuiltinPackage.EXTERNAL_PROFILE__USERNAME: return SocialPackage.PERSON_LIKE__USERNAME;
				case BuiltinPackage.EXTERNAL_PROFILE__GENDER: return SocialPackage.PERSON_LIKE__GENDER;
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
		if (baseClass == PersonLike.class) {
			switch (baseFeatureID) {
				case SocialPackage.PERSON_LIKE__FIRST_NAME: return BuiltinPackage.EXTERNAL_PROFILE__FIRST_NAME;
				case SocialPackage.PERSON_LIKE__LAST_NAME: return BuiltinPackage.EXTERNAL_PROFILE__LAST_NAME;
				case SocialPackage.PERSON_LIKE__USERNAME: return BuiltinPackage.EXTERNAL_PROFILE__USERNAME;
				case SocialPackage.PERSON_LIKE__GENDER: return BuiltinPackage.EXTERNAL_PROFILE__GENDER;
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
		result.append(" (firstName: ");
		result.append(firstName);
		result.append(", lastName: ");
		result.append(lastName);
		result.append(", username: ");
		result.append(username);
		result.append(", gender: ");
		result.append(gender);
		result.append(", profileId: ");
		result.append(profileId);
		result.append(')');
		return result.toString();
	}

} //ExternalProfileImpl

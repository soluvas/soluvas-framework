/**
 */
package org.soluvas.email.impl;

import java.util.HashSet;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.soluvas.email.EmailFormat;
import org.soluvas.email.EmailPackage;
import org.soluvas.email.Recipient;
import org.soluvas.email.WebSecurity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Recipient</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.email.impl.RecipientImpl#getEmail <em>Email</em>}</li>
 *   <li>{@link org.soluvas.email.impl.RecipientImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.soluvas.email.impl.RecipientImpl#getFirstName <em>First Name</em>}</li>
 *   <li>{@link org.soluvas.email.impl.RecipientImpl#getLastName <em>Last Name</em>}</li>
 *   <li>{@link org.soluvas.email.impl.RecipientImpl#getRoleName <em>Role Name</em>}</li>
 *   <li>{@link org.soluvas.email.impl.RecipientImpl#getPreferredFormat <em>Preferred Format</em>}</li>
 *   <li>{@link org.soluvas.email.impl.RecipientImpl#getPreferredWebSecurity <em>Preferred Web Security</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RecipientImpl extends EObjectImpl implements Recipient {
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
	 * The default value of the '{@link #getRoleName() <em>Role Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoleName()
	 * @generated
	 * @ordered
	 */
	protected static final String ROLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRoleName() <em>Role Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoleName()
	 * @generated
	 * @ordered
	 */
	protected String roleName = ROLE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPreferredFormat() <em>Preferred Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreferredFormat()
	 * @generated
	 * @ordered
	 */
	protected static final EmailFormat PREFERRED_FORMAT_EDEFAULT = EmailFormat.MULTIPART;

	/**
	 * The cached value of the '{@link #getPreferredFormat() <em>Preferred Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreferredFormat()
	 * @generated
	 * @ordered
	 */
	protected EmailFormat preferredFormat = PREFERRED_FORMAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPreferredWebSecurity() <em>Preferred Web Security</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreferredWebSecurity()
	 * @generated
	 * @ordered
	 */
	protected static final WebSecurity PREFERRED_WEB_SECURITY_EDEFAULT = WebSecurity.PREFER_SECURE;

	/**
	 * The cached value of the '{@link #getPreferredWebSecurity() <em>Preferred Web Security</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreferredWebSecurity()
	 * @generated
	 * @ordered
	 */
	protected WebSecurity preferredWebSecurity = PREFERRED_WEB_SECURITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecipientImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmailPackage.Literals.RECIPIENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.RECIPIENT__EMAIL, oldEmail, email));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.RECIPIENT__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.RECIPIENT__FIRST_NAME, oldFirstName, firstName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.RECIPIENT__LAST_NAME, oldLastName, lastName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EmailFormat getPreferredFormat() {
		return preferredFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPreferredFormat(EmailFormat newPreferredFormat) {
		EmailFormat oldPreferredFormat = preferredFormat;
		preferredFormat = newPreferredFormat == null ? PREFERRED_FORMAT_EDEFAULT : newPreferredFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.RECIPIENT__PREFERRED_FORMAT, oldPreferredFormat, preferredFormat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public WebSecurity getPreferredWebSecurity() {
		return preferredWebSecurity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPreferredWebSecurity(WebSecurity newPreferredWebSecurity) {
		WebSecurity oldPreferredWebSecurity = preferredWebSecurity;
		preferredWebSecurity = newPreferredWebSecurity == null ? PREFERRED_WEB_SECURITY_EDEFAULT : newPreferredWebSecurity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.RECIPIENT__PREFERRED_WEB_SECURITY, oldPreferredWebSecurity, preferredWebSecurity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRoleName() {
		return roleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRoleName(String newRoleName) {
		String oldRoleName = roleName;
		roleName = newRoleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.RECIPIENT__ROLE_NAME, oldRoleName, roleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmailPackage.RECIPIENT__EMAIL:
				return getEmail();
			case EmailPackage.RECIPIENT__NAME:
				return getName();
			case EmailPackage.RECIPIENT__FIRST_NAME:
				return getFirstName();
			case EmailPackage.RECIPIENT__LAST_NAME:
				return getLastName();
			case EmailPackage.RECIPIENT__ROLE_NAME:
				return getRoleName();
			case EmailPackage.RECIPIENT__PREFERRED_FORMAT:
				return getPreferredFormat();
			case EmailPackage.RECIPIENT__PREFERRED_WEB_SECURITY:
				return getPreferredWebSecurity();
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
			case EmailPackage.RECIPIENT__EMAIL:
				setEmail((String)newValue);
				return;
			case EmailPackage.RECIPIENT__NAME:
				setName((String)newValue);
				return;
			case EmailPackage.RECIPIENT__FIRST_NAME:
				setFirstName((String)newValue);
				return;
			case EmailPackage.RECIPIENT__LAST_NAME:
				setLastName((String)newValue);
				return;
			case EmailPackage.RECIPIENT__ROLE_NAME:
				setRoleName((String)newValue);
				return;
			case EmailPackage.RECIPIENT__PREFERRED_FORMAT:
				setPreferredFormat((EmailFormat)newValue);
				return;
			case EmailPackage.RECIPIENT__PREFERRED_WEB_SECURITY:
				setPreferredWebSecurity((WebSecurity)newValue);
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
			case EmailPackage.RECIPIENT__EMAIL:
				setEmail(EMAIL_EDEFAULT);
				return;
			case EmailPackage.RECIPIENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EmailPackage.RECIPIENT__FIRST_NAME:
				setFirstName(FIRST_NAME_EDEFAULT);
				return;
			case EmailPackage.RECIPIENT__LAST_NAME:
				setLastName(LAST_NAME_EDEFAULT);
				return;
			case EmailPackage.RECIPIENT__ROLE_NAME:
				setRoleName(ROLE_NAME_EDEFAULT);
				return;
			case EmailPackage.RECIPIENT__PREFERRED_FORMAT:
				setPreferredFormat(PREFERRED_FORMAT_EDEFAULT);
				return;
			case EmailPackage.RECIPIENT__PREFERRED_WEB_SECURITY:
				setPreferredWebSecurity(PREFERRED_WEB_SECURITY_EDEFAULT);
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
			case EmailPackage.RECIPIENT__EMAIL:
				return EMAIL_EDEFAULT == null ? email != null : !EMAIL_EDEFAULT.equals(email);
			case EmailPackage.RECIPIENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EmailPackage.RECIPIENT__FIRST_NAME:
				return FIRST_NAME_EDEFAULT == null ? firstName != null : !FIRST_NAME_EDEFAULT.equals(firstName);
			case EmailPackage.RECIPIENT__LAST_NAME:
				return LAST_NAME_EDEFAULT == null ? lastName != null : !LAST_NAME_EDEFAULT.equals(lastName);
			case EmailPackage.RECIPIENT__ROLE_NAME:
				return ROLE_NAME_EDEFAULT == null ? roleName != null : !ROLE_NAME_EDEFAULT.equals(roleName);
			case EmailPackage.RECIPIENT__PREFERRED_FORMAT:
				return preferredFormat != PREFERRED_FORMAT_EDEFAULT;
			case EmailPackage.RECIPIENT__PREFERRED_WEB_SECURITY:
				return preferredWebSecurity != PREFERRED_WEB_SECURITY_EDEFAULT;
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
		result.append(" (email: ");
		result.append(email);
		result.append(", name: ");
		result.append(name);
		result.append(", firstName: ");
		result.append(firstName);
		result.append(", lastName: ");
		result.append(lastName);
		result.append(", roleName: ");
		result.append(roleName);
		result.append(", preferredFormat: ");
		result.append(preferredFormat);
		result.append(", preferredWebSecurity: ");
		result.append(preferredWebSecurity);
		result.append(')');
		return result.toString();
	}

	/**
	 * Hash code is based on lowercased email, so can be used in a {@link HashSet}.
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : StringUtils.lowerCase(email).hashCode());
		return result;
	}

} //RecipientImpl

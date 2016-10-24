/**
 */
package org.soluvas.security;

import javax.annotation.Nullable;

import org.eclipse.emf.common.util.EList;
import org.soluvas.commons.ResourceAware;

import com.google.common.base.Function;
import com.google.common.base.Joiner;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Permission</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.security.Permission#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.soluvas.security.Permission#getDomainPermission <em>Domain Permission</em>}</li>
 *   <li>{@link org.soluvas.security.Permission#getActionPermission <em>Action Permission</em>}</li>
 *   <li>{@link org.soluvas.security.Permission#getInstancePermission <em>Instance Permission</em>}</li>
 * </ul>
 *
 * @see org.soluvas.security.SecurityPackage#getPermission()
 * @model
 * @generated
 */
public interface Permission extends ResourceAware {

	public static class ToStringPermission implements
			Function<Permission, String> {

		@Override
		@Nullable
		public String apply(@Nullable Permission input) {
			Joiner joiner = Joiner.on(',');
			return joiner.join(input.getDomainPermission()) + ":"
					+ joiner.join(input.getActionPermission()) + ":"
					+ joiner.join(input.getInstancePermission());
		}

	}

	/**
	 * Returns the value of the '<em><b>Roles</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The roles this permission apply to.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Roles</em>' attribute list.
	 * @see org.soluvas.security.SecurityPackage#getPermission_Roles()
	 * @model
	 * @generated
	 */
	EList<String> getRoles();

	/**
	 * Returns the value of the '<em><b>Domain Permission</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name(s) of the domain, can be "*".
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Domain Permission</em>' attribute list.
	 * @see org.soluvas.security.SecurityPackage#getPermission_DomainPermission()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getDomainPermission();

	/**
	 * Returns the value of the '<em><b>Action Permission</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name(s) of the action, can be "*".
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Action Permission</em>' attribute list.
	 * @see org.soluvas.security.SecurityPackage#getPermission_ActionPermission()
	 * @model default="" required="true"
	 * @generated
	 */
	EList<String> getActionPermission();

	/**
	 * Returns the value of the '<em><b>Instance Permission</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name(s) of the instance(s), can be "*".
	 * 
	 * To specify multiple parts, separate each with ":".
	 * e.g.
	 * domain=wink
	 * action=add
	 * instance=hendy:car:nana
	 * 
	 * means permit hendy to add wink for car to nana.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Instance Permission</em>' attribute list.
	 * @see org.soluvas.security.SecurityPackage#getPermission_InstancePermission()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getInstancePermission();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Format it as string usable by Shiro.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	String toStringPermission();

} // Permission

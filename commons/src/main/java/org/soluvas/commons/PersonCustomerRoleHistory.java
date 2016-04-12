package org.soluvas.commons;

import javax.annotation.Nullable;

import org.joda.time.DateTime;

import com.google.common.base.Function;

public interface PersonCustomerRoleHistory extends NameContainer, PhotoIdContainer, Identifiable, PersonLike, Informer<PersonInfo>, Timestamped, SchemaVersionable, Describable, Sluggable, CanonicalSluggable, TwitterAccessible, TwitterIdentity, FacebookIdentity, FacebookAccessible, Revisionable {
	
	public static class ToPersonInfo implements Function<PersonCustomerRoleHistory, PersonInfo> {
		@Override @Nullable
		public PersonInfo apply(@Nullable PersonCustomerRoleHistory input) {
			if (input == null)
				return null;
			final PersonInfo personInfo = CommonsFactory.eINSTANCE.createPersonInfo();
			personInfo.setId(input.getId());
			personInfo.setSlug(input.getSlug());
			personInfo.setName(input.getName());
			personInfo.setPhotoId(input.getPhotoId());
			personInfo.setGender(input.getGender());
			personInfo.setEmail(input.getEmail());
//			personInfo.setMobileNumber(input.getMobileNumber());
			return personInfo;
		}
	}
	
	@Override
	long getSchemaVersion ();

	/**
	 * Returns the value of the '<em><b>Customer Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name of Customer Role or Group, for example in Tuneeca there are 5: ag-sp, agen, biasa, drops, membr
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Customer Role</em>' attribute.
	 * @see #setCustomerRole(String)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_CustomerRole()
	 * @model
	 * @generated
	 */
	String getCustomerRole();
	
	void setCustomerRole(String value);

	/**
	 * return the value of customer role edit time
	 * mendapatkan waktu perubahan customer role
	 * @see #getCustomerRoleEditTime()
	 */	
	DateTime getCustomerRoleEditTime();
	
	/**
	 * sets the value of customer role edit time
	 * waktu perubahan customer role
	 *  
	 */
	void setCustomerRoleEditTime(DateTime value);
	
	/**
	 * Returns the value of the '<em><b>Member Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name of Member Role or Group for example : newbie, aktivis , donatur
	 * 
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Member Role</em>' attribute.
	 * @see #setMemberRole(String)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_MemberRole()
	 * @model
	 * @generated
	 */
	String getMemberRole();
	
	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getMemberRole <em>Member Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Member Role</em>' attribute.
	 * @see #getMemberRole()
	 * @generated
	 */
	void setMemberRole(String value);
	
	/**
	 * Returns the value of the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Name</em>' attribute.
	 * @see #setFirstName(String)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_FirstName()
	 * @model
	 * @generated
	 */
	String getFirstName();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getFirstName <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Name</em>' attribute.
	 * @see #getFirstName()
	 * @generated
	 */
	void setFirstName(String value);
	
	/**
	 * Returns the value of the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Name</em>' attribute.
	 * @see #setLastName(String)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_LastName()
	 * @model
	 * @generated
	 */
	String getLastName();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getLastName <em>Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Name</em>' attribute.
	 * @see #getLastName()
	 * @generated
	 */
	void setLastName(String value);
	
	/**
	 * Returns the value of the '<em><b>Manager Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name of Manager Role or Group for example : regular, moderator , administrator, sysadmin. (administrativeRole attribute OID 2.5.18.5 is already used by LDAP standard)
	 * 
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Manager Role</em>' attribute.
	 * @see #setManagerRole(String)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_ManagerRole()
	 * @model
	 * @generated
	 */
	String getManagerRole();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getManagerRole <em>Manager Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manager Role</em>' attribute.
	 * @see #getManagerRole()
	 * @generated
	 */
	void setManagerRole(String value);

	
}

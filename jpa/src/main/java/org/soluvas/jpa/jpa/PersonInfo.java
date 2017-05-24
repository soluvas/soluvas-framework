package org.soluvas.jpa.jpa;

import java.io.Serializable;
import javax.annotation.Nullable;
import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.Gender;
import org.soluvas.commons.PersonInfo2;
import org.soluvas.commons.entity.Person2;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.Preconditions;

/**
 * A representation of the model object '<em><b>PersonInfo</b></em>'. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 */
@Embeddable()
@MappedSuperclass
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String GUEST_ID = "guest";

	private static final String GUEST_NAME = "guest";

	private static final String GUEST_SLUG = "guest";

	public PersonInfo() {
		super();
	}

	public static PersonInfo getDefaultGuest() {
		final PersonInfo guest = new PersonInfo();
		guest.setId(GUEST_ID);
		guest.setName(GUEST_NAME);
		guest.setSlug(GUEST_SLUG);
		return guest;
	}

	public PersonInfo(org.soluvas.commons.PersonInfo personInfoUp) {
		Preconditions.checkNotNull(personInfoUp, "Person Info EMF must not be null!");
		setEmail(personInfoUp.getEmail());
		setGender(personInfoUp.getGender());
		setId(personInfoUp.getId());
		setName(personInfoUp.getName());
		setPhotoId(personInfoUp.getPhotoId());
		setSlug(personInfoUp.getSlug());
		setMobileNumber(personInfoUp.getMobileNumber());
	}
	
	public PersonInfo(PersonInfo2 personInfo2) {
		Preconditions.checkNotNull(personInfo2, "Person Info EMF must not be null!");
		setEmail(personInfo2.getEmail());
		setGender(personInfo2.getGender());
		setId(personInfo2.getId());
		setName(personInfo2.getName());
		setPhotoId(personInfo2.getPhotoId());
		setSlug(personInfo2.getSlug());
		setMobileNumber(personInfo2.getMobileNumber());
	}
	
	public PersonInfo2 toInfo2() {
		final PersonInfo2 info2 = new PersonInfo2();
		info2.setEmail(getEmail());
		info2.setGender(getGender());
		info2.setId(getId());
		info2.setName(getName());
		info2.setPhotoId(getPhotoId());
		info2.setSlug(getSlug());
		info2.setMobileNumber(getMobileNumber());
		return info2;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * Can be {@code null}, for not registered user, e.g. deceased person or
	 * historical figure. <!-- end-model-doc -->
	 * 
	 * @generated
	 */
	@Basic()
	private String id = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Basic()
	private String name = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 */
	@Basic()
	@Type(type = "org.soluvas.jpa.PersistentEnum", parameters = @Parameter(name = "enumClass", value = "org.soluvas.commons.Gender") )
	private Gender gender = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Basic()
	private String slug = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Basic()
	private String email = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Basic()
	private String photoId = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * Domain where this person is a registered user. Usually used by embedding
	 * this PersonInfo in a document which is then signed using the domain
	 * owner's certificate, which in turn is signed by either a trusted party or
	 * a Certificate Authority. <!-- end-model-doc -->
	 * 
	 * @generated
	 */
	@Basic()
	private String domain = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Basic()
	private String mobileNumber = null;

	/**
	 * Returns the value of '<em><b>id</b></em>' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * Can be {@code null}, for not registered user, e.g. deceased person or
	 * historical figure. <!-- end-model-doc -->
	 * 
	 * @return the value of '<em><b>id</b></em>' feature
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the '{@link PersonInfo#getId() <em>id</em>}' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * Can be {@code null}, for not registered user, e.g. deceased person or
	 * historical figure. <!-- end-model-doc -->
	 * 
	 * @param newId
	 *            the new value of the '{@link PersonInfo#getId() id}' feature.
	 * @generated
	 */
	public void setId(String newId) {
		id = newId;
	}

	/**
	 * Returns the value of '<em><b>name</b></em>' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>name</b></em>' feature
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the '{@link PersonInfo#getName() <em>name</em>}' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param newName
	 *            the new value of the '{@link PersonInfo#getName() name}'
	 *            feature.
	 * @generated
	 */
	public void setName(String newName) {
		name = newName;
	}

	/**
	 * Returns the value of '<em><b>gender</b></em>' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>gender</b></em>' feature
	 * @generated
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Sets the '{@link PersonInfo#getGender() <em>gender</em>}' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param newGender
	 *            the new value of the '{@link PersonInfo#getGender() gender}'
	 *            feature.
	 * @generated
	 */
	public void setGender(Gender newGender) {
		gender = newGender;
	}

	/**
	 * Returns the value of '<em><b>slug</b></em>' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>slug</b></em>' feature
	 * @generated
	 */
	public String getSlug() {
		return slug;
	}

	/**
	 * Sets the '{@link PersonInfo#getSlug() <em>slug</em>}' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param newSlug
	 *            the new value of the '{@link PersonInfo#getSlug() slug}'
	 *            feature.
	 * @generated
	 */
	public void setSlug(String newSlug) {
		slug = newSlug;
	}

	/**
	 * Returns the value of '<em><b>email</b></em>' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>email</b></em>' feature
	 * @generated
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the '{@link PersonInfo#getEmail() <em>email</em>}' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param newEmail
	 *            the new value of the '{@link PersonInfo#getEmail() email}'
	 *            feature.
	 * @generated
	 */
	public void setEmail(String newEmail) {
		email = newEmail;
	}

	/**
	 * Returns the value of '<em><b>photoId</b></em>' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>photoId</b></em>' feature
	 * @generated
	 */
	public String getPhotoId() {
		return photoId;
	}

	/**
	 * Sets the '{@link PersonInfo#getPhotoId() <em>photoId</em>}' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param newPhotoId
	 *            the new value of the '{@link PersonInfo#getPhotoId() photoId}'
	 *            feature.
	 * @generated
	 */
	public void setPhotoId(String newPhotoId) {
		photoId = newPhotoId;
	}

	/**
	 * Returns the value of '<em><b>domain</b></em>' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * Domain where this person is a registered user. Usually used by embedding
	 * this PersonInfo in a document which is then signed using the domain
	 * owner's certificate, which in turn is signed by either a trusted party or
	 * a Certificate Authority. <!-- end-model-doc -->
	 * 
	 * @return the value of '<em><b>domain</b></em>' feature
	 * @generated
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * Sets the '{@link PersonInfo#getDomain() <em>domain</em>}' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * Domain where this person is a registered user. Usually used by embedding
	 * this PersonInfo in a document which is then signed using the domain
	 * owner's certificate, which in turn is signed by either a trusted party or
	 * a Certificate Authority. <!-- end-model-doc -->
	 * 
	 * @param newDomain
	 *            the new value of the '{@link PersonInfo#getDomain() domain}'
	 *            feature.
	 * @generated
	 */
	public void setDomain(String newDomain) {
		domain = newDomain;
	}

	/**
	 * Returns the value of '<em><b>mobileNumber</b></em>' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>mobileNumber</b></em>' feature
	 * @generated
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * Sets the '{@link PersonInfo#getMobileNumber() <em>mobileNumber</em>}'
	 * feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param newMobileNumber
	 *            the new value of the '{@link PersonInfo#getMobileNumber()
	 *            mobileNumber}' feature.
	 * @generated
	 */
	public void setMobileNumber(String newMobileNumber) {
		mobileNumber = newMobileNumber;
	}

	/**
	 * A toString method which prints the values of all EAttributes of this
	 * instance. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return "PersonInfo " + " [id: " + getId() + "]" + " [name: " + getName() + "]" + " [gender: " + getGender()
				+ "]" + " [slug: " + getSlug() + "]" + " [email: " + getEmail() + "]" + " [photoId: " + getPhotoId()
				+ "]" + " [domain: " + getDomain() + "]" + " [mobileNumber: " + getMobileNumber() + "]";
	}

	public static PersonInfo fromPerson(Person2 person) {
		return fromPerson(person, null);
	}
	
	public static PersonInfo fromPerson2(Person2 person) {
		return fromPerson2(person, null);
	}

	public static PersonInfo fromPerson(Person2 person, @Nullable String domain) {
		final PersonInfo info = new PersonInfo();
		info.setId(person.getId());
		info.setSlug(person.getSlug());
		info.setName(person.getName());
		info.setPhotoId(person.getPhotoId());
		info.setEmail(person.getEmail());
		info.setGender(person.getGender());
		info.setDomain(domain);
		return info;
	}
	
	public static PersonInfo fromPerson2(Person2 person, @Nullable String domain) {
		final PersonInfo info = new PersonInfo();
		info.setId(person.getId());
		info.setSlug(person.getSlug());
		info.setName(person.getName());
		info.setPhotoId(person.getPhotoId());
		info.setEmail(person.getEmail());
		info.setGender(person.getGender());
		info.setDomain(domain);
		return info;
	}

	public static org.soluvas.commons.PersonInfo toCommons(PersonInfo personInfoJpa) {
		final org.soluvas.commons.PersonInfo personInfoCommons = CommonsFactory.eINSTANCE.createPersonInfo();
		personInfoCommons.setEmail(personInfoJpa.getEmail());
		personInfoCommons.setGender(personInfoJpa.getGender());
		personInfoCommons.setId(personInfoJpa.getId());
		personInfoCommons.setName(personInfoJpa.getName());
		personInfoCommons.setPhotoId(personInfoJpa.getPhotoId());
		personInfoCommons.setSlug(personInfoJpa.getSlug());
		return personInfoCommons;
	}
	
	public static org.soluvas.commons.PersonInfo2 toClasic(PersonInfo personInfoJpa) {
		final org.soluvas.commons.PersonInfo2 personInfoCommons =new PersonInfo2();
		personInfoCommons.setEmail(personInfoJpa.getEmail());
		personInfoCommons.setGender(personInfoJpa.getGender());
		personInfoCommons.setId(personInfoJpa.getId());
		personInfoCommons.setName(personInfoJpa.getName());
		personInfoCommons.setPhotoId(personInfoJpa.getPhotoId());
		personInfoCommons.setSlug(personInfoJpa.getSlug());
		return personInfoCommons;
	}

}

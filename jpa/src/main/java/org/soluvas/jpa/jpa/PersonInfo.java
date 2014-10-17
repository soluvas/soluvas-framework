package org.soluvas.jpa.jpa;

import java.io.Serializable;

import javax.annotation.Nullable;
import javax.persistence.Basic;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.Gender;
import org.soluvas.commons.Person;

/**
 * A representation of the model object '<em><b>PersonInfo</b></em>'. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 */
@Embeddable()
public class PersonInfo  implements Serializable {

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
		setEmail(personInfoUp.getEmail());
		setGender(personInfoUp.getGender());
		setId(personInfoUp.getId());
		setName(personInfoUp.getName());
		setPhotoId(personInfoUp.getPhotoId());
		setSlug(personInfoUp.getSlug());
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
	@Type(type = "org.soluvas.jpa.PersistentEnum", parameters = @Parameter(name = "enumClass", value = "org.soluvas.commons.Gender"))
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
	 * A toString method which prints the values of all EAttributes of this
	 * instance. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return "PersonInfo " + " [id: " + getId() + "]" + " [name: "
				+ getName() + "]" + " [gender: " + getGender() + "]"
				+ " [slug: " + getSlug() + "]" + " [email: " + getEmail() + "]"
				+ " [photoId: " + getPhotoId() + "]" + " [domain: "
				+ getDomain() + "]";
	}

	public static PersonInfo fromPerson(Person person) {
		return fromPerson(person, null);
	}

	public static PersonInfo fromPerson(Person person, @Nullable String domain) {
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

	public static org.soluvas.commons.PersonInfo toCommons(
			PersonInfo personInfoJpa) {
		final org.soluvas.commons.PersonInfo personInfoCommons = CommonsFactory.eINSTANCE
				.createPersonInfo();
		personInfoCommons.setEmail(personInfoJpa.getEmail());
		personInfoCommons.setGender(personInfoJpa.getGender());
		personInfoCommons.setId(personInfoJpa.getId());
		personInfoCommons.setName(personInfoJpa.getName());
		personInfoCommons.setPhotoId(personInfoJpa.getPhotoId());
		personInfoCommons.setSlug(personInfoJpa.getSlug());
		return personInfoCommons;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domain == null) ? 0 : domain.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((photoId == null) ? 0 : photoId.hashCode());
		result = prime * result + ((slug == null) ? 0 : slug.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonInfo other = (PersonInfo) obj;
		if (domain == null) {
			if (other.domain != null)
				return false;
		} else if (!domain.equals(other.domain))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gender != other.gender)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (photoId == null) {
			if (other.photoId != null)
				return false;
		} else if (!photoId.equals(other.photoId))
			return false;
		if (slug == null) {
			if (other.slug != null)
				return false;
		} else if (!slug.equals(other.slug))
			return false;
		return true;
	}
	
}

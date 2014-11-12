package org.soluvas.jpa.jpa;

import javax.persistence.Basic;
import javax.persistence.Embeddable;
import org.soluvas.commons.Gender;

/**
 * A representation of the model object '<em><b>PersonInfo</b></em>'. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
@Embeddable()
public class PersonInfo {

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
	 * @generated
	 */
	@Basic()
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
}

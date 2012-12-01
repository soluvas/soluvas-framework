/**
 */
package org.soluvas.commons;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PersonInfo</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Person partial value object that is stored in Graph database (usually Neo4j) or embedded in a MongoDB document.
 * 
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.PersonInfo#getId <em>Id</em>}</li>
 *   <li>{@link org.soluvas.commons.PersonInfo#getSlug <em>Slug</em>}</li>
 *   <li>{@link org.soluvas.commons.PersonInfo#getName <em>Name</em>}</li>
 *   <li>{@link org.soluvas.commons.PersonInfo#getPhotoId <em>Photo Id</em>}</li>
 *   <li>{@link org.soluvas.commons.PersonInfo#getGender <em>Gender</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getPersonInfo()
 * @model
 * @extends SerializableEObject
 * @generated
 */
public interface PersonInfo extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Directory entry uid attribute.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.soluvas.commons.CommonsPackage#getPersonInfo_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PersonInfo#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Slug</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slug</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Slug (aka Directory uniqueIdentifier) used in SEO-friendly URIs.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Slug</em>' attribute.
	 * @see #setSlug(String)
	 * @see org.soluvas.commons.CommonsPackage#getPersonInfo_Slug()
	 * @model required="true"
	 * @generated
	 */
	String getSlug();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PersonInfo#getSlug <em>Slug</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slug</em>' attribute.
	 * @see #getSlug()
	 * @generated
	 */
	void setSlug(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Display name (can be full name, nickname, slug, screen name, etc. whatever is commonly used by the particular app).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.soluvas.commons.CommonsPackage#getPersonInfo_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PersonInfo#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Photo Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Photo Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Avatar Photo ID directly usable by Image Store.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Photo Id</em>' attribute.
	 * @see #setPhotoId(String)
	 * @see org.soluvas.commons.CommonsPackage#getPersonInfo_PhotoId()
	 * @model
	 * @generated
	 */
	String getPhotoId();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PersonInfo#getPhotoId <em>Photo Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Photo Id</em>' attribute.
	 * @see #getPhotoId()
	 * @generated
	 */
	void setPhotoId(String value);

	/**
	 * Returns the value of the '<em><b>Gender</b></em>' attribute.
	 * The literals are from the enumeration {@link org.soluvas.commons.Gender}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gender</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gender</em>' attribute.
	 * @see org.soluvas.commons.Gender
	 * @see #setGender(Gender)
	 * @see org.soluvas.commons.CommonsPackage#getPersonInfo_Gender()
	 * @model
	 * @generated
	 */
	Gender getGender();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PersonInfo#getGender <em>Gender</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gender</em>' attribute.
	 * @see org.soluvas.commons.Gender
	 * @see #getGender()
	 * @generated
	 */
	void setGender(Gender value);

} // PersonInfo

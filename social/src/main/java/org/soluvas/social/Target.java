/**
 */
package org.soluvas.social;

import java.util.List;

import org.soluvas.commons.Describable;
import org.soluvas.commons.NsPrefixable;
import org.soluvas.social.schema.TargetType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Objects
 * 
 * Objects represent "entities" that users can act on in your app. Most Open Graph objects are web pages hosted on a public website, with Open Graph-specific meta tags embedded within the page. Facebook routinely scrapes these web pages, extracting the data contained in the meta tags in order to generate stories that it displays on peoples' News Feeds and Timelines.
 * 
 * Previously, users were able to connect to objects in your app via the like action. Now, you can model user interactions with custom actions and objects for richer connections with your users.
 * Types
 * Built-in Objects
 * 
 * Facebook has defined a set of objects that can be used without any further customization on your part.
 * 
 *     Article
 *     Blog
 *     Book
 *     Profile (External)
 *     Movie
 *     TV Episode
 *     TV Show
 *     Video
 *     Website
 * 
 * Custom Objects
 * 
 * You have the ability to create your own objects and define all properties of those objects.
 * Privacy Model
 * 
 * Objects are public entities that reside on the internet and must be available to Facebook's "scraper". All information defined in an object should be considered as public. You should anticipate that all information is easily accessible to anyone on the internet and therefore, no sensitive information or information that is exclusive for a user or set of users is stored.
 * 
 * ______________________
 * 
 * Direct and Indirect Objects
 * 
 * A direct object is the receiver of action within a sentence, as in "He hit the ball." Be careful to distinguish between a direct object and an object complement:
 * 
 *     They named their daughter Natasha.
 * 
 * In that sentence, "daughter" is the direct object and "Natasha" is the object complement, which renames or describes the direct object.
 * 
 * The indirect object identifies to or for whom or what the action of the verb is performed. The direct object and indirect object are different people or places or things. The direct objects in the sentences below are in boldface; the indirect objects are in italics.
 * 
 *     The instructor gave his students A's.
 *     Grandfather left Rosalita and Raoul all his money.
 *     Jo-Bob sold me her boat.
 * 
 * Incidentally, the word me (and similar object-form pronouns such as him, us, them) is not always an indirect object; it will also serve, sometimes, as a direct object.
 * 
 *     Bless me/her/us!
 *     Call me/him/them if you have questions.
 * 
 * In English, nouns and their accompanying modifiers (articles and adjectives) do not change form when they are used as objects or indirect objects, as they do in many other languages. "The radio is on the desk" and "I borrowed the radio" contain exactly the same word form used for quite different functions. This is not true of pronouns, however, which use different forms for different functions. (He [subject] loves his grandmother. His grandmother loves him [object].) (See, also, pronoun cases.)
 * 
 * Reference: http://grammar.ccc.commnet.edu/grammar/objects.htm
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.social.Target#getTargetType <em>Target Type</em>}</li>
 *   <li>{@link org.soluvas.social.Target#getTitle <em>Title</em>}</li>
 *   <li>{@link org.soluvas.social.Target#getImages <em>Images</em>}</li>
 *   <li>{@link org.soluvas.social.Target#getUri <em>Uri</em>}</li>
 *   <li>{@link org.soluvas.social.Target#getTypeName <em>Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.social.SocialPackage#getTarget()
 * @model abstract="true"
 * @generated
 */
public interface Target extends NsPrefixable, Describable {

	/**
	 * Returns the value of the '<em><b>Target Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Type</em>' reference.
	 * @see #setTargetType(TargetType)
	 * @see org.soluvas.social.SocialPackage#getTarget_TargetType()
	 * @model
	 * @generated
	 */
	TargetType getTargetType();

	/**
	 * Sets the value of the '{@link org.soluvas.social.Target#getTargetType <em>Target Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Type</em>' reference.
	 * @see #getTargetType()
	 * @generated
	 */
	void setTargetType(TargetType value);

	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Object Name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see org.soluvas.social.SocialPackage#getTarget_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link org.soluvas.social.Target#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Images</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Array of images
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Images</em>' attribute.
	 * @see #setImages(List)
	 * @see org.soluvas.social.SocialPackage#getTarget_Images()
	 * @model dataType="org.soluvas.commons.List<org.eclipse.emf.ecore.EString>" many="false"
	 * @generated
	 */
	List<String> getImages();

	/**
	 * Sets the value of the '{@link org.soluvas.social.Target#getImages <em>Images</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Images</em>' attribute.
	 * @see #getImages()
	 * @generated
	 */
	void setImages(List<String> value);

	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Open Graph URL of the Profile
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see org.soluvas.social.SocialPackage#getTarget_Uri()
	 * @model
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.soluvas.social.Target#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

	/**
	 * Returns the value of the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Name</em>' attribute.
	 * @see #setTypeName(String)
	 * @see org.soluvas.social.SocialPackage#getTarget_TypeName()
	 * @model
	 * @generated
	 */
	String getTypeName();

	/**
	 * Sets the value of the '{@link org.soluvas.social.Target#getTypeName <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Name</em>' attribute.
	 * @see #getTypeName()
	 * @generated
	 */
	void setTypeName(String value);
} // Target

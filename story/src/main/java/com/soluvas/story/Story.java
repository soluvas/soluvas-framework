/**
 */
package com.soluvas.story;

import org.eclipse.emf.common.util.EList;
import org.soluvas.commons.Identifiable;
import org.soluvas.commons.SchemaVersionable;
import org.soluvas.commons.Timestamped;
import org.soluvas.social.Target;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Story</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.soluvas.story.Story#getSchemaVersion <em>Schema Version</em>}</li>
 *   <li>{@link com.soluvas.story.Story#getStatus <em>Status</em>}</li>
 *   <li>{@link com.soluvas.story.Story#getAction <em>Action</em>}</li>
 *   <li>{@link com.soluvas.story.Story#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.soluvas.story.Story#getSubjects <em>Subjects</em>}</li>
 *   <li>{@link com.soluvas.story.Story#getReceivers <em>Receivers</em>}</li>
 *   <li>{@link com.soluvas.story.Story#getAttachments <em>Attachments</em>}</li>
 *   <li>{@link com.soluvas.story.Story#getSubject <em>Subject</em>}</li>
 *   <li>{@link com.soluvas.story.Story#getReceiver <em>Receiver</em>}</li>
 *   <li>{@link com.soluvas.story.Story#getAttachment <em>Attachment</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.soluvas.story.StoryPackage#getStory()
 * @model
 * @generated
 */
public interface Story extends Identifiable, Timestamped, SchemaVersionable {
	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The literals are from the enumeration {@link com.soluvas.story.StoryStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see com.soluvas.story.StoryStatus
	 * @see #setStatus(StoryStatus)
	 * @see com.soluvas.story.StoryPackage#getStory_Status()
	 * @model
	 * @generated
	 */
	StoryStatus getStatus();

	/**
	 * Sets the value of the '{@link com.soluvas.story.Story#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see com.soluvas.story.StoryStatus
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(StoryStatus value);

	/**
	 * Returns the value of the '<em><b>Receiver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get the primary receiver.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Receiver</em>' reference.
	 * @see #setReceiver(Target)
	 * @see com.soluvas.story.StoryPackage#getStory_Receiver()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	Target getReceiver();

	/**
	 * Sets the value of the '{@link com.soluvas.story.Story#getReceiver <em>Receiver</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Receiver</em>' reference.
	 * @see #getReceiver()
	 * @generated
	 */
	void setReceiver(Target value);

	/**
	 * Returns the value of the '<em><b>Attachment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get the primary attachment.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attachment</em>' reference.
	 * @see #setAttachment(Target)
	 * @see com.soluvas.story.StoryPackage#getStory_Attachment()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	Target getAttachment();

	/**
	 * Sets the value of the '{@link com.soluvas.story.Story#getAttachment <em>Attachment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attachment</em>' reference.
	 * @see #getAttachment()
	 * @generated
	 */
	void setAttachment(Target value);

	/**
	 * Returns the value of the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A predicate is the completer of a sentence. The subject names the "do-er" or "be-er" of the sentence; the predicate does the rest of the work. A simple predicate consists of only a verb, verb string, or compound verb:
	 * 
	 *     The glacier melted.
	 *     The glacier has been melting.
	 *     The glacier melted, broke apart, and slipped into the sea.
	 * 
	 * A compound predicate consists of two (or more) such predicates connected:
	 * 
	 *     The glacier began to slip down the mountainside and eventually crushed some of the village's outlying buildings.
	 * 
	 * A complete predicate consists of the verb and all accompanying modifiers and other words that receive the action of a transitive verb or complete its meaning. The following description of predicates comes from The Longman Handbook for Writers and Readers (examples our own):
	 * 
	 *     With an intransitive verb, objects and complements are included in the predicate. (The glacier is melting.) With a transitive verb, objects and object complements are said to be part of the predicate. (The slow moving glacier wiped out an entire forest. It gave the villagers a lot of problems.) With a linking verb, the subject is connected to a subject complement. (The mayor doesn't feel good.) 
	 * 
	 * A predicate adjective follows a linking verb and tells us something about the subject:
	 * 
	 *     Ramonita is beautiful.
	 *     His behavior has been outrageous.
	 *     That garbage on the street smells bad.
	 * 
	 * A predicate nominative follows a linking verb and tells us what the subject is:
	 * 
	 *     Dr. Couchworthy is acting president of the university.
	 *     She used to be the tallest girl on the team.
	 * 
	 * Reference: http://grammar.ccc.commnet.edu/grammar/objects.htm
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Action</em>' reference.
	 * @see #setAction(Action)
	 * @see com.soluvas.story.StoryPackage#getStory_Action()
	 * @model required="true"
	 * @generated
	 */
	Action getAction();

	/**
	 * Sets the value of the '{@link com.soluvas.story.Story#getAction <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' reference.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(Action value);

	/**
	 * Returns the value of the '<em><b>Subject</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get the primary subject.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Subject</em>' reference.
	 * @see #setSubject(Target)
	 * @see com.soluvas.story.StoryPackage#getStory_Subject()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	Target getSubject();

	/**
	 * Sets the value of the '{@link com.soluvas.story.Story#getSubject <em>Subject</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subject</em>' reference.
	 * @see #getSubject()
	 * @generated
	 */
	void setSubject(Target value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see #setOwner(Identifiable)
	 * @see com.soluvas.story.StoryPackage#getStory_Owner()
	 * @model
	 * @generated
	 */
	Identifiable getOwner();

	/**
	 * Sets the value of the '{@link com.soluvas.story.Story#getOwner <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Identifiable value);

	/**
	 * Returns the value of the '<em><b>Schema Version</b></em>' attribute.
	 * The default value is <code>"3"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schema Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema Version</em>' attribute.
	 * @see com.soluvas.story.StoryPackage#getStory_SchemaVersion()
	 * @model default="3" required="true" changeable="false"
	 * @generated
	 */
	long getSchemaVersion();

	/**
	 * Returns the value of the '<em><b>Subjects</b></em>' reference list.
	 * The list contents are of type {@link org.soluvas.social.Target}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subjects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subjects</em>' reference list.
	 * @see com.soluvas.story.StoryPackage#getStory_Subjects()
	 * @model required="true"
	 * @generated
	 */
	EList<Target> getSubjects();

	/**
	 * Returns the value of the '<em><b>Receivers</b></em>' reference list.
	 * The list contents are of type {@link org.soluvas.social.Target}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Receivers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Receivers</em>' reference list.
	 * @see #isSetReceivers()
	 * @see #unsetReceivers()
	 * @see com.soluvas.story.StoryPackage#getStory_Receivers()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<Target> getReceivers();

	/**
	 * Unsets the value of the '{@link com.soluvas.story.Story#getReceivers <em>Receivers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetReceivers()
	 * @see #getReceivers()
	 * @generated
	 */
	void unsetReceivers();

	/**
	 * Returns whether the value of the '{@link com.soluvas.story.Story#getReceivers <em>Receivers</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Receivers</em>' reference list is set.
	 * @see #unsetReceivers()
	 * @see #getReceivers()
	 * @generated
	 */
	boolean isSetReceivers();

	/**
	 * Returns the value of the '<em><b>Attachments</b></em>' reference list.
	 * The list contents are of type {@link org.soluvas.social.Target}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attachments</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attachments</em>' reference list.
	 * @see com.soluvas.story.StoryPackage#getStory_Attachments()
	 * @model
	 * @generated
	 */
	EList<Target> getAttachments();

} // Story

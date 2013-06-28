/**
 */
package com.soluvas.story.schema;

import org.soluvas.commons.BundleAware;
import org.soluvas.commons.EClassLinked;
import org.soluvas.commons.EFactoryLinked;
import org.soluvas.commons.JavaClassLinked;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.NsPrefixable;
import org.soluvas.commons.ResourceAware;
import org.soluvas.social.schema.TargetType;

import com.soluvas.story.Action;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Before your application can publish actions, you must first define and register Action Types through the Open Graph Tool within the App Dashboard.
 * 
 *     Define Action Types for your app
 *     Utilize Built-In Action Types in your app
 *     Configure Custom Action Types with default properties
 *     Define Custom Properties for Custom Action Types
 *     Utilize Custom Action Types with Built-In Object Types in your app
 * 
 * Define Action Types
 * 
 * To define an Action Type, click on the "Create New Action Type" button in the Dashboard view and enter an action which describes a high-level social action users can do in your app.
 * 
 * 
 * Start typing the action into the action dialog to get started:
 * 
 * Configure Custom Action Types
 * 
 * Once you have defined the name of a custom action type, you are ready to configure its properties:
 * Define Action Type
 * 
 * 
 *     Basic:
 *         Name field is pre-filled with the action you defined in the initial step. For example: read, bake, run.
 *         Connected Object Types indicates the object types that this action can act upon. If you have previously defined custom object types for this app, you can add these here. You may also add Built-In Object Types to this list.
 *     Properties: These are the instance specific properties you can set when you publish an action.
 *         Any object types that are connected to this action type will be listed first. These are required when publishing an action.
 *         start_time an optional field specifies a start time for a published action. This is used to control the tense of of the action displayed in the News Feed story. string containing ISO-8601 date-time
 *         end_time an optional field specifies an end time for a published action. This is used to control the tense of of the action displayed in the News Feed story. string containing ISO-8601 date-time
 *         expires_in an optional field specifies when a published action will expire. This is used to control the tense of of the action displayed in the News Feed story.
 *         place an optional field specifies a place for a published action. This is used to set additional location information displayed the News Feed story. Location is an important part of a story that helps convey rich information about the action or event taking place. Open Graph stories that include the place field will be considered for additional News Feed and Timeline distribution. See the Location Tagging documentation for more information.
 *         tags an optional field specifies one or more Facebook users to tag in a published action. This is used to set additional tagging information displayed in the News Feed story. The information entered should be a comma-separated list of one or more Facebook user ids. Read more information about how to use this field.
 *         image an optional field specifies the image for a published action. This is used to control the image that is displayed in News Feed and Timeline stories. If no image is specified the image corresponding to the object is displayed. Images that are 200x200px or higher tend to get more distribution through News Feed and Timeline as the stories generated leverage deeper story formats.
 *         ref an optional field specifies a reference for a published action. This parameter will be associated with your published action and can then be used to track analytics in App Insights.
 *         message an optional field specifies the message that will be attached to the action when it is displayed in the News Feed story. Read more information about how to use this field.
 *         Add Custom Property as needed. This allows you to add additional action type properties, allowing you to specify the property type and property rules.
 * 
 * Configure Story Text
 * 
 * 
 *     Tenses Supported: Allows you to select the tenses that will be used in News Feed stories. For example, you may wish to always display stories in present tense, in which case you would select the ''only the present tense'' option.
 *     Configure Tenses: Configure how the stories will appear in the News Feed. By default, all actions are displayed in the past tense form, unless specified for a period of time in the present tense.
 *         Past Tense field is pre-filled with an initial past tense action corresponding to your initial action type. You can edit this field. You can also edit the preposition that defines how the News Feed story is displayed. You can preview the various sentences that may be generated using the Sentence Previews box.
 *         Plural Past Tense field is pre-filled with an initial past tense action corresponding to your initial action when more than one friend is involved. Similar to the Past Tense field, you can make changes and preview them using the 'Sentence Previews` box.
 *         Present Tense field is pre-filled with an initial present tense action corresponding to your initial action type. You can edit this field. You can also edit the preposition that defines how the News Feed story is displayed. You can preview the various sentences that may be generated using the Sentence Previews box.
 *         Plural Present Tense field is pre-filled with an initial present tense action corresponding to your initial action when more than one friend is involved. Similar to the Past Tense field, you can make changes and preview them using the Sentence Previews box.
 *         Imperative Tense field is pre-filled with an initial present tense action corresponding to your initial action type. This field controls the display for action links. You can edit this field. You can preview the various sentences that may be generated using the Sentence Previews box.
 *     Sentence Previews: The preview box displays the various stories that can be generated for the different tenses. This enables you to see how your stories will appear in News Feed, notifications, Timeline headers, etc. Use this to help you define your tenses. You may have to save the action type at least once for the sentence previews to display.
 *         Singular Present displays the various stories for an individual actor and a present tense action.
 *         Plural Present displays the various stories for an multiple actors and a present tense action.
 *         Singular Past displays the various stories for an individual actor and a past tense action.
 *         Singular Past displays the various stories for an multiple actors and a past tense action.
 *         Imperative displays the various stories for an action link.
 * 
 * Configure Story Attachment
 * 
 * 
 *     Attachment Layout: Configure the way the action attachment renders in the News Feed, Ticker (when a user clicks on the one line story), and in Timeline.
 *         Item select this option for caption next to an image
 *         Numberselect this option for displaying a number with caption underneath
 *         Map select this option for map view of your action
 *     Caption: Create a caption for your story with a combination of text, action and object property values and a simple text template syntax for formatting these property values. See Using Text Templates for details.
 *     Note: Do not repeat text of the form [user] [action] [object] in the captions, as this will be automatically generated and added to each published Open Graph story.
 *     Advanced:
 *         Graph API URL field allows you to set the endpoint URL you will use to call your action. You can only change the action part of this URL. The action is pre-filled with the one you set initially.
 *         Unique Action field allows you to select whether you will support unique actions or not. By default you will support multiple actions. Only select this option if there can only be one instance of the action -> object pair. For example, a valid use case of this is if a user can only vote once for an entry.
 *         Requires App Access Token to Publish field specifies if the app secret is required to publish activity. For example, some games want enforce that actions like score or achieve can only be written from the app's servers and can't be written by trapping a normal access token and writing to the graph. To do this, do Graph writes using /{user-id}/{action}?access_token={token} where token is an app access token and the user id is a #. By default an app access_token is not required.
 *         Geographic Restrictions field allows you to list countries where you either want to show or hide published actions.
 *         Linked Action field allows you to tie an existing action type to this action type as part of configuring action links.
 *         Action Link Preview box allows you to view how an action link will be displayed in News Feed or Timeline. This preview is only visible when a Linked Action has been specified.
 *         Action Link URL field specifies the end point that Facebook will call when a user clicks on an action link. This must be a secure link.
 * 
 * Preview
 * 
 * 
 * This preview box allows you to see how your action instance story will appear in the News Feed and Timeline.
 * 
 * Define Custom Properties
 * 
 * Custom properties are additional attributes used to describe a custom action instance. Actions, by default, are only visible to a user's friends. Apps can specify a broader (everyone) or narrower (user only) visibility setting for actions generated by the app. Additionally, a user can also edit the action visibility settings on her Timeline. More details on app permissions and settings here.
 * 
 * Custom properties of a custom action are used to store personal and instance-specific data. Examples of custom action instance properties include: Duration for a run action, Score for a game-play action, or Rating for a review action.
 * 
 * A custom property can also be defined to refer to other objects. For example, when a user reviewed a dish, "review" is the action and "dish" is the object. A "restaurant" object can be a custom property associated with the "review" action.
 * 
 * If an image was specified when publishing an action, News Feed will prioritize the action image over the object image.
 * Next Steps
 * 
 *     Define Objects
 *     Define Timeline Aggregations
 *     Publish Actions
 *     Configure Action Links
 * 
 * Reference: https://developers.facebook.com/docs/technical-guides/opengraph/defining-an-action-type/#define
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.soluvas.story.schema.ActionType#getResolvedSubjectTypes <em>Resolved Subject Types</em>}</li>
 *   <li>{@link com.soluvas.story.schema.ActionType#getStatus <em>Status</em>}</li>
 *   <li>{@link com.soluvas.story.schema.ActionType#getSubjectTypes <em>Subject Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.soluvas.story.schema.SchemaPackage#getActionType()
 * @model superTypes="org.soluvas.commons.NameContainer org.soluvas.commons.BundleAware org.soluvas.commons.ResourceAware org.soluvas.commons.JavaClassLinked<com.soluvas.story.schema.Action> org.soluvas.commons.EClassLinked org.soluvas.commons.EFactoryLinked com.soluvas.story.schema.ActionLike org.soluvas.commons.NsPrefixable"
 * @generated
 */
public interface ActionType extends NameContainer, BundleAware, ResourceAware, JavaClassLinked<Action>, EClassLinked, EFactoryLinked, ActionLike, NsPrefixable {

	/**
	 * Returns the value of the '<em><b>Resolved Subject Types</b></em>' reference list.
	 * The list contents are of type {@link org.soluvas.social.schema.TargetType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Connected Object Types indicates the object types that this action can act upon. If you have previously defined custom object types for this app, you can add these here. You may also add Built-In Object Types to this list.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resolved Subject Types</em>' reference list.
	 * @see com.soluvas.story.schema.SchemaPackage#getActionType_ResolvedSubjectTypes()
	 * @model
	 * @generated
	 */
	EList<TargetType> getResolvedSubjectTypes();

	/**
	 * Returns the value of the '<em><b>Subject Types</b></em>' containment reference list.
	 * The list contents are of type {@link com.soluvas.story.schema.TargetTypeRef}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Connected Object Types indicates the object types that this action can act upon. If you have previously defined custom object types for this app, you can add these here. You may also add Built-In Object Types to this list.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Subject Types</em>' containment reference list.
	 * @see com.soluvas.story.schema.SchemaPackage#getActionType_SubjectTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<TargetTypeRef> getSubjectTypes();

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The literals are from the enumeration {@link com.soluvas.story.schema.ActionTypeStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see com.soluvas.story.schema.ActionTypeStatus
	 * @see #setStatus(ActionTypeStatus)
	 * @see com.soluvas.story.schema.SchemaPackage#getActionType_Status()
	 * @model
	 * @generated
	 */
	ActionTypeStatus getStatus();

	/**
	 * Sets the value of the '{@link com.soluvas.story.schema.ActionType#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see com.soluvas.story.schema.ActionTypeStatus
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(ActionTypeStatus value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Create Action with proper nsPrefix and actionType attributes.
	 * <!-- end-model-doc -->
	 * @model dataType="com.soluvas.story.schema.Action"
	 * @generated
	 */
	Action create();

} // ActionType

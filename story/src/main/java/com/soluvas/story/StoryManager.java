/**
 */
package com.soluvas.story;

import org.eclipse.emf.ecore.EObject;
import org.soluvas.commons.Identifiable;
import org.soluvas.commons.PersonInfo;
import org.soluvas.social.Target;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Actions are the high-level "interactions" users can perform in your app. Before publishing an Action instance to Open Graph, define its Action Type and its connected Object Type through the App Dashboard.
 * 
 *     Publishing Actions
 *     Retrieving Actions
 *     Updating an Action
 *     Deleting an Action
 *     Commenting on an Action
 *     Liking an Action
 *     Configure Action Timestamps
 * 
 * Publishing Actions
 * 
 * Actions are defined through the App Dashboard. Once an application has defined the types of actions that it publishes, the application can invoke the Graph API to publish action instances to Open Graph -- this connects the current user with an appropriate object instance via the action.
 * 
 * POST /me/{namespace}:{action-type-name}
 * 
 * with the request body
 * 
 * {object-type-name}={object-instance-url}
 * 
 * The following call sees the recipebox app establishing a Cook action instance connection between the current user and a Pumpkin Pie (an instance of the Recipe object type):
 * 
 * curl -X POST \
 *      -F 'access_token=USER_ACCESS_TOKEN' \
 *      -F 'recipe=http://www.example.com/pumpkinpie.html' \
 *      https://graph.facebook.com/me/recipebox:cook
 * 
 * Here is another example using the Javascript SDK:
 * 
 * FB.api('/me/recipebox:cook', 'post', 
 *   { recipe : 'http://www.example.com/pumpkinpie.html' });
 * 
 * Note - Apps can also use an App Access Token to publish actions for authenticated users.
 * 
 * Once an action is published, friends may see a News Feed and Ticker story:
 * 
 * In News Feed
 * 
 * In Ticker
 * 
 * Previewing Stories from Published Actions
 * 
 * You can preview News Feed stories created when publishing actions by going to https://www.facebook.com/USER_ID/activity/STORY_ID, where USER_ID is the user's Facebook ID or username, and STORY_ID is the action-instance-id as described below. For example:
 * 
 * https://www.facebook.com/dhirenp/activity/10100657260775943
 * 
 * The user must have appropriate permissions in order to view the preview.
 * 
 * Required Parameters
 * Name 	Value 	Type
 * Type Name of Connected Object 	The object URL or object ID of an appropriate object instance.
 * 
 * If the object represented by the URL is not in the graph, it will be scraped. 	string
 * Optional Parameters Requiring Review
 * 
 * You must request these optional properties during the Open Graph submission flow.
 * Name 	Value 	Type
 * message 	Allows users to write a personalized message attached to this action. You can only use user message when the text is entered by the user (not pre-populated). You can mention users and pages inline with the message (see mention tagging).	string
 * fb:explicitly_shared 	Value specifying that the published action is explicitly shared by the user.	boolean
 * place 	ID referencing a place where the action occurred. For example: "Simon ate Pizza at Facebook HQ"	id
 * user_generated (image) 	Allows user generated, large photos to be displayed in stories - see docs	boolean
 * tags 	Allows an app user to tag other users in a story. For example: Carl visited Dolores Park. - with Mike and Austin.	a string of comma separated ids
 * 
 * Optional Parameters
 * Name 	Value 	Type
 * start_time 	The time this action started.	ISO-8601 date-time
 * end_time 	The time this action ended.	ISO-8601 date-time
 * expires_in 	The number of seconds before this action is considered “old”. From the time the action until expires_in seconds have elapsed, the action is considered “present tense”, and afterwards, it is considered “past tense”.
 * 
 * expires_in is a shortcut for specifying end_time when it’s more convenient to provide a delta in seconds between when an action started and when it ends. For example, when a user starts watching a movie, when you post a watch action, expires_in should be the length of the movie in seconds.	integer
 * notify 	If set to false we will suppress notifications resulting from the published action. Currently this is only applicable to likes published on actions and Open Graph likes.	bool
 * privacy 	A JSON-encoded object that defines the privacy setting for the action. Its fields are described here. 	object
 * image	Ability to add an image to the story and override the image that is associated with the object properties. If you would like to include a user generated image, that will be saved in the user's albums, please see the docs on User Generated Photos	URL
 * ref 	When users click through to your site from an Open Graph action displayed in Facebook, this value will be passed in the fb_ref query parameter which Facebook will add to external links to your objects. This is useful for A/B tests and tracking other data associated with the action.
 * 
 * By default, the ref parameter will accept 500 unique values for ref in a 7 day period. These values will be used to display graphs grouped by each unique value of ref in your application's insights.
 * 
 * If you need more values 500 per 7 days, for example if you are passing globally unique IDs via the ref parameter, you may use the "__" separator. Text to the left of the separator will be used as indexes in Insights and used to help you analyze A/B test results. Text to the right of the separator will be ignored for insights purposes, will not form part of the 500 by 7 quota, but will still be passed in the fb_ref parameter the user follows a link to from the Open Graph action.	string
 * scrape 	If set to true we will scrape your object and update its properties prior to creating the action. Scraping will slow down the request and has the potential to hit rate limits so only scrape when the object has been updated.	bool
 * Response
 * 
 * {
 *   id: “{action-instance-id}”
 * }
 * 
 * If extra properties are sent in a request but not defined on an Action type, an error is thrown.
 * 
 * Setting custom action instance properties
 * 
 * Custom action properties must be set when an action instance is published. They are assigned by passing URL parameters in the form:
 * 
 * {custom-property-name}={value}
 * 
 * The following shows how to set a custom property, rating, on the recipebox:cook action:
 * 
 * https://graph.facebook.com/me/recipebox:cook?
 *   book=http://www.example.com/pumpkinpie.html&rating=10
 * 
 * Explicit Sharing
 * 
 * Explicitly shared actions let apps notify us when a user wants to share something prominently, like they would on Facebook. For example, when people choose to share a run they took with a fitness app, they expect the content to appear as if they had posted it directly to Facebook. You mark Open Graph actions as explicitly shared by adding the fb:explicitly_shared parameter when publishing actions:
 * 
 * curl -X POST https://graph.dev.facebook.com/me/nyccookbook:cook \
 *      -F "access_token=<valid access_token>"  \
 *      -F "recipe=http://www.sugarmedia.com/nyccookbook/cookie.html" \
 *      -F "fb:explicitly_shared=true"
 * 
 * See the guide on Explicit Sharing for the full details.
 * Retrieving an Action
 * 
 * Apps can retrieve actions published for the authorized user. For example, a Recipe app can retrieve all the recipes I've cooked or plan on cooking and customize the app experience based the data.
 * 
 * This API returns the action’s metadata including timestamps along with custom properties and their values. Objects referenced from an action are returned a single level deep.
 * 
 * GET /{action-instance-id}
 * 
 * The following retrieves a specific action instance
 * 
 * https://graph.facebook.com/1538292028372
 *       ?access_token=USER_ACCESS_TOKEN
 * 
 * Response
 * 
 * {
 *     "id": "1538292028372"
 *     "start_time": 1303502229, 
 *     "end_time": 1303513029, 
 *     "data": {
 *         "type": "recipebox:recipe", 
 *         "url": "http://www.example.com/pumpkinpie.html", 
 *         "id": "1234567890", 
 *         "title": "Pumpkin Pie"
 *     }, 
 * }
 * 
 * Updating an Action
 * 
 * Apps can update properties of an action instance by:
 * 
 * POST /{action-instance-id}
 * 
 * The following updates the end_time of an action
 * 
 * https://graph.facebook.com/1538292028372?expires_in=300
 *       &access_token=YOUR_ACCESS_TOKEN
 * 
 * Here is the same example using the JS SDK:
 * 
 * FB.api('/1538292028372', 'post', { expires_in : '300' });
 * 
 * Response
 * 
 * true
 * 
 * Deleting an Action
 * 
 * Apps can also remove actions published for authorized users. You may use this feature if a user retroactively decides to un-publish the activity.
 * 
 * DELETE /{action-instance-id}
 * 
 * The following deletes action instance 1538292028372
 * 
 * https://graph.facebook.com/1538292028372?access_token=YOUR_ACCESS_TOKEN
 * 
 * Here is the same example using the JS SDK:
 * 
 * FB.api('/1538292028372', 'delete');
 * 
 * Response
 * 
 * true 
 * 
 * Liking an Action
 * 
 * Create a Like connection between the current user and the specified action. This requires the publish_actions permission from the user.
 * 
 * POST /{action-instance-id}/likes
 * 
 * The following creates a like between the current user and action instance 1538292028372
 * 
 * https://graph.facebook.com/1538292028372/likes
 *       ?access_token=YOUR_ACCESS_TOKEN
 * 
 * Here is the same example using the JS SDK:
 * 
 * FB.api('/1538292028372/likes', 'post');
 * 
 * To get likes associated with an action instance
 * 
 * GET /{action-instance-id}/likes
 * 
 * Liking an action with an App Access Token
 * 
 * Create a like connection between the user and the action using an app access token. When using the app access token, pass in the user id of the user "liking" the action in the "user" parameter.
 * 
 * https://graph.facebook.com/1538292028372/likes
 *       ?access_token=YOUR_APP_ACCESS_TOKEN
 *       &user=499804870
 * 
 * Suppressing notifications
 * 
 * When publishing a like from your app, there are scenarios where notifications might be duplicated between your app and Facebook. To suppress the notification from liking an action, pass in the notify parameter with a value of false.
 * 
 * https://graph.facebook.com/1538292028372/likes
 *       ?access_token=YOUR_ACCESS_TOKEN
 *       &notify=false
 * 
 * Commenting on an Action
 * 
 * Add a comment for the current user and the specified action.
 * 
 * POST /{action-instance-id}/comments
 * 
 * The following creates a comment on the action instance 1538292028372
 * 
 * https://graph.facebook.com/1538292028372/comments
 *       ?message=test+comment&access_token=YOUR_ACCESS_TOKEN
 * 
 * Here is the same example using the JS SDK:
 * 
 * FB.api('/1538292028372/comments', 'post', { message : 'test comment' });
 * 
 * Get comments for the current user and the specified action
 * 
 * GET /{action-instance-id}/comments
 * 
 * Retrieve the comments on an Action. Use the request parameters that are described for retrieving Comments on a Post. Described here.
 * 
 * Timestamps
 * 
 * Action’s timestamps can be configured to describe actions that occur at different times and how actions appear on the user's profile and News Feed.
 * 
 * Supported configurations for timestamps are:
 * 
 *     Point in time when the API call is made (default. example: voted for a poll)
 *     Start in the past / end in the past (example: soccer team I played on last summer)
 *     Start in the past / end in the future (example: courses a student takes over a semester
 *     Start now / end in the future (example: a relationship status)
 *     Start now / end indefinite (example: like or want actions)
 * 
 * In all cases, an expires_in value provided in seconds can be used to specify the end_time relative to the start_time. It is not acceptable to provide expires_in and end_time for the same action instance. When an app provides expires_in, we calculate end_time as follows:
 * 
 * end_time = start_time + expires_in
 * 
 * To alter the end_time of an action -- because a trip is running long or because a student drops a college course -- the end_time can be updated.
 * Timestamps and collections
 * 
 * Timestamps can be used to model collections by testing the liveness of an action. For example, the set of Courses a student is currently taking can be calculated by looking at the which “enrolled” actions that point to Course objects have a start_date in the past and an end_date in the future.
 * 
 * Similarly, the college courses I was taking in the March of 1998 can be determined by looking at the Enrolled actions with a start_date before March 1, 1998 and an end_date after March 31, 1998. This supports pinning my “Class Schedule” Aggregation to March 1998.
 * 
 * Using this method, it is possible to build Aggregations for perpetual actions including “like” and “want”.
 * 
 * Reference: https://developers.facebook.com/docs/technical-guides/opengraph/publish-action/
 * <!-- end-model-doc -->
 *
 *
 * @see com.soluvas.story.StoryPackage#getStoryManager()
 * @model
 * @generated
 */
public interface StoryManager extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="com.soluvas.story.schema.Story" subjectDataType="org.soluvas.social.schema.Target" receiverDataType="org.soluvas.social.schema.Target"
	 * @generated
	 */
	Story publish(PersonInfo owner, Target subject, Action action, Target receiver, String trackingId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="com.soluvas.story.schema.Story" subjectDataType="org.soluvas.social.schema.Target" receiverDataType="org.soluvas.social.schema.Target"
	 * @generated
	 */
	Story publish(String namespace, Identifiable owner, Target subject, Action action, Target receiver, String trackingId);

} // StoryManager

/**
 */
package com.soluvas.story.schema;

import com.soluvas.story.Aggregation;

import org.soluvas.commons.BundleAware;
import org.soluvas.commons.EClassLinked;
import org.soluvas.commons.JavaClassLinked;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.ResourceAware;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aggregation Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Timeline Aggregations are aggregated stories that are defined by an application to showcase actions and objects on a user's Timeline in a structured and interesting way.
 * 
 * When a user installs an application that publishes back to Open Graph, an Aggregation defined by the application will appear on the user's Timeline based on two key factors:
 * 
 *     Data availability - Sufficient actions and objects were published to generate an Aggregation in a given time period.
 *     Feedback - Calculated based on how engaged users are with the Aggregation on their Timelines, covering both positive actions (liking, commenting, pinning) and negative ones (removing/hiding the aggregation, removing the application that generated the aggregation).
 * 
 * When an application defines multiple aggregations, these may appear on Timeline as Reports. Reports are collections of aggregations and are shown for each time period in which a user has published activity back to the Open Graph. This provides a consistent viewing experience and makes it easier for a user to digest data from an application. When configuring multiple aggregations for an application through the Facebook App Dashboard, ensure that these aggregations are ordered by priority - with the most important aggregation first. When a report is generated for your app, the primary aggregation is in the top position, and the other aggregations (if sufficient data is available to generate these aggregations) are displayed in their respective order in the report.
 * 
 * Here is an example of a Report for a recipe app with 2 aggregated stories with 'Recipes I've Made' as the primary story.
 * 
 * Overview
 * 
 * Within the App Dashboard under Open Graph > Dashboard tab, click on "Create New Aggregation" to get started.
 * 
 * An Aggregation can be configured by the following fields:
 * 
 *     Data to Display - Specify whether an Aggregation should surface a user's actions or objects.
 *     Layout Style - The style of the Aggregation display.
 *     Sort By - Chooses how the ''Data to Display'' will be ordered in the Aggregation. The current choices are ''Most Recent'', ''Favorite'', and a ''Custom'' selection.
 *     Aggregation Title - Sets the user-facing title of an Aggregation. Preview any changes through the Timeline Preview box.
 *     Caption Lines - Sets the caption shown in an Aggregation. A combination of text and syntax from the in-built Text Template language can be used to create the caption.
 *     Advanced - Provides additional optional aggregation parameters: Group By (not available for Aggregations showing actions) and Filters.
 * 
 * Data to Display
 * 
 * An Aggregation can display any action type or object type that your application has configured.
 * 
 * Object Type
 * To configure an Aggregation to show "Most [Action Type] [Object Types]", such as: "Most Ran Routes", or "Restaurants Visited Most", choose the object type (e.g. Route) as the ''Data to Display''. Then, select a connected action type (e.g. Run) as the ''Action Type''.
 * 
 * Such an aggregation in effect does a group by on the Route object and accesses its in-built {count} property, which is the number of times a user has taken the connected action on the object, in this case, the number of times the user has ran on the route.
 * 
 * Action Type
 * To configure an Aggregation to show "Most Recent [Action Type]", such as: "Most Recent Runs" or "Most Recent Books Read", choose the action type (e.g. Read) as the ''Data to Display''. This aggregation will be able to access individual instances of the chosen action, such as all "Read" actions of the current user published by the app back to Open Graph. The {count} for action-based aggregations will always be 1.
 * 
 * Examples
 * Consider a Cookbook app that has the Actions: "Cook", "Plan to Make" and the Objects: "Recipe", "Meal"
 * 
 *     Configure an aggregation grouped by the "Recipe" object, this gives access to the number of times a connected action occurred for the object. For example, to create a Most Cooked Recipes aggregation, select the "Recipe" object as the ''Data to Display'' and "Cook" as the connected ''Action Type''.
 *     Configure an aggregation with an action as the ''Data to Display''. For example, setting the "Plan to Make" action as the ''Data to Display'' helps create the Latest Planning to Make aggregation that shows the most recent recipes that the user has taken the "Plan to Make" action on. The configured aggregation could also focus on particular properties of an action. For example, if the "Cook" action had a custom property called "Duration" that tracks how long it takes to cook each time, and if a Longest Cooking aggregation was created, then the "Cook" action is the ''Data to Display'', with a custom ''Sort By'' on the action property called "Duration". The aggregation will have access to action instance-specific information and properties, which would not be available had the "Recipe" object been the ''Data to Display''.
 * 
 * Layout Style
 * 
 * Layout styles define how your aggregation looks on the user’s Timeline.
 * 
 * The following layout templates, including suggested use-cases, are available for you to choose from:
 * 
 *     List: Help highlight a user's recent activity or favorite objects. Lists also have an associated histogram, shaded grey, that will automatically appear for each row displayed in the list.
 *     Gallery: Help when Object images are meaningful. Example, the cover art for my favorite albums or the course photos from my runs.
 *     Table: Help highlight a mixture of interesting statistical and qualitative attributes of a user's actions or objects.
 *     Item: Help highlight a single, interesting action or object with a compelling visual representation. Image size will be 90x90px in Timeline, and 379x284px on App Tabs (if a larger image is provided). To get larger images, you should specify multiply images with your objects and include the height and width attributes. Images with larger sizes will be chosen for the larger format.
 *     Number: Help highlight a single, meaningful number from a macro view. For example, a user's total miles ran in a time period or the number of restaurant reviews a user has posted.
 *     Map: Help highlight geolocation attributes of a user's actions and objects. For example, use the Map layout to plot the geo-coordinates of a user's "longest run" or "path travelled" from a lifestyle app.
 * 
 * Map Layout Style
 * 
 * To take advantage of the Map layout, your objects need to have at least one GeoPoint property. GeoPoint is a complex type that can be described with latitude, longitude, and altitude; altitude being optional here.
 * 
 * There are two styles of maps to choose from, and each have their own set of parameters:
 * 
 * Single Action: this style renders one action or object only (using the highest or lowest rank depending on the configured sort order), but can highlight multiple pins on the map and trace a route between several points. One example would be to display a travel action with multiple stops, or a run action that follows multiple paths.
 * 
 * The parameters the Single Action map takes are:
 * 
 *     Numbers: Specify number values that will be highlighted in the header of this aggregation.
 *     Highlighted Points: Specify object or action properties of type GeoPoint that will be rendered as pins on the map. You can specify multiple properties.
 *     Route: Specify an array property of type GeoPoint. These points will be rendered on the map as a route.
 * 
 * Multiple Actions: this style renders multiple objects or actions, except that each item is rendered as a point of the map instead of a caption text with a picture within a gallery layout.
 * 
 * This map style accepts one parameter only:
 * 
 *     Contributing points: Specify an object or action property of type GeoPoint. Only one property is accepted here.
 * 
 * Sort By
 * 
 * Configures the ordering and display for the Aggregation. You have the ability to choose from the following:
 * 
 *     Most Recent: Displays actions ordered by the action's start_time property
 *     Favorite: Displays objects ordered by the number of times a user has taken a specific action against an object. For example, a "favorite songs" Aggregation shows song objects that I'm connected to via listen actions ordered by the number of listen actions per song.
 *     Custom: Sort by properties on an action or object, such as the end time of an action, the number of counts or the highest or lowest numerical value of a property. Examples: Distance or Pace of a run action, the Rating of a movie object.
 * 
 * Aggregation Title
 * 
 * Users will see the title for every aggregation on their Timeline. Avoid using a title that could confuse the another viewer of a user's Timeline about the ownership of the actions and objects in the aggregation such as "My Most Visited Places" or "Routes I Ran". Instead, use identity-agnostic titles such as "Most Visited Places" or titles which explicitly articulate ownership such as "Routes Diana Ran".
 * 
 * The title should also honestly reflect the content being displayed. For example, if an application defines a "Favorite Runs" aggregation, the application should provide runs that were explicitly made "favorites" by the user, versus the most popular runs, which should be titled as "Most Popular Runs".
 * 
 * Caption Lines
 * 
 * Aggregations support a simple text template syntax for formatting Open Graph action / object properties into strings that a user sees. This template syntax supports formatters for different data types such as dates, times, currencies, etc., pluralization of display text and operators for simple mathematical computations. Text templates are specified between the “{...}” characters.
 * 
 * Example:
 * A Run action connects to a Course object via a “course” custom property. To show the run’s distance and pace, use:
 * Ran {course.distance} miles in {time | duration}
 * which would be formatted into: “Ran 7.48 miles in 42:37”.
 * 
 * See Using Text Templates to take full advantage of its capabilities.
 * 
 * Advanced
 * 
 * Filters - Option allows the aggregation to only display if this is true. For example, you can filter by the type of movie (type is a custom property on movie object).
 * 
 * Group by - Option is only available if your Aggregation is displaying Objects. This option allows the aggregation to group by a property of the object. For example, you can group by Movie object's type, to show how many times you've watched a certain type of movie.
 * 
 * Effects when Updating the Definition of Existing Aggregations
 * 
 * When making changes to the definition of of an existing aggregation definition, you should be aware that some types of changes may wipe out (destructive) aggregation and stories for previously published actions.
 * 
 * Destructive changes (ie: previously published actions will not appear):
 * 
 *     Changing the "group by" property
 *     Changing the "action type" property (if grouping by an object)
 *     Changing the "sort-by" property
 *     Adding a new, previously unused selector to a caption to use / display a property from an action or object
 *     Adding a function (sum, max, avg) on an existing selector. Note: we are planning to fix this behavior soon.
 *     Adding a filter that uses a function (sum, max, avg).
 * 
 * Non-destructive changes (ie: previously published actions continue to appear):
 * 
 *     Changing the title
 *     Changing the layout
 *     Changing a caption without adding a new selector or function. i.e. it's okay to rearrange text and selectors, just not to add ones that read new properties from an action / object
 *     Using a formatter on an existing selector i.e. formatting a date or a number
 *     Starting or stopping use of {count}in a filter, selector, etc [fixed week of 12/12]
 *     Using an existing selector as a filter
 * 
 * Reference: https://developers.facebook.com/docs/technical-guides/opengraph/defining-an-aggregation/
 * <!-- end-model-doc -->
 *
 *
 * @see com.soluvas.story.schema.SchemaPackage#getAggregationType()
 * @model superTypes="org.soluvas.commons.ResourceAware org.soluvas.commons.NameContainer org.soluvas.commons.BundleAware org.soluvas.commons.JavaClassLinked<com.soluvas.story.schema.Aggregation> org.soluvas.commons.EClassLinked"
 * @generated
 */
public interface AggregationType extends ResourceAware, NameContainer, BundleAware, JavaClassLinked<Aggregation>, EClassLinked {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Create Target with proper nsPrefix and aggregationType attributes.
	 * <!-- end-model-doc -->
	 * @model dataType="com.soluvas.story.schema.Aggregation"
	 * @generated
	 */
	Aggregation create();
} // AggregationType

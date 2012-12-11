/**
 */
package org.soluvas.social.builtin;

import org.soluvas.social.PersonLike;
import org.soluvas.social.SocialPackage;
import org.soluvas.social.Target;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Profile</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * name = Profile Name.
 * 
 *     Getting Started
 *     Core Concepts
 *     Advanced Topics
 *     Technical Guides
 *         Login
 *         Open Graph
 *         FQL
 *         Mobile App Install Ads
 *         Samples & How Tos
 *     API Reference
 *     SDK Reference
 * 
 *     Getting Started
 *         Open Graph Insights
 *         Open Graph Tutorial
 *         Open Graph Video Tutorials
 *     Actions
 *         How-To: Built-In Actions
 *         How-To: Built-In Like
 *         How-To: Define an Action Type
 *         How-To: Publish Watch Actions
 *         How-To: Publish an Action
 *         Introduction to the Built-In Watch Action
 *     Objects
 *         How-To: Complex Object Types
 *         How-To: Custom Object Properties
 *         How-To: Defining an Object
 *         How-To: Defining an Object (Using the Online Tool)
 *         How-To: Simple Object Types
 *         How-To: Using Built-In Objects
 *     Aggregations
 *         How-To: Defining an Aggregation
 *         How-To: Using Templates to Build Aggregations
 *     Advanced
 *         How To: Customize Per-Post Privacy
 *         How-To: Action Links
 *         How-To: Explicit Sharing
 *         How-To: Follows (on Open Graph)
 *         How-To: Mention Tagging
 *         How-To: Open Graph Internationalization
 *         How-To: Parse Parameters from Open Graph Links
 *         How-To: Posting Past Actions
 *         How-To: Publishing With an App Token
 *         How-To: Title-less Objects
 *         How-To: User Restrictions
 *         Introduction to Tagging People & Places
 *     Authentication
 *         How-To: Open Graph Auth Referrals
 *         How-To: Open Graph Authentication Dialogs and Permissions
 *     Submission Process
 *         Open Graph Guidelines
 *         Understanding the Open Graph Submission Process
 *     Best Practices
 *         Best Practices: Creating Open Graph Stories
 *         Best Practices: Creating Timeline Aggregations
 *         Best Practices: Creating Usage Instructions
 *         Best Practices: Grow Your App With Open Graph
 *         Best Practices: Working With Custom Properties
 *         Best Practices: Working With Multiple Objects
 *         Tips & Tricks for Using Open Graph
 * 
 * How-To: Using Built-In Objects
 * Technical Guides › Open Graph › How-To: Using Built-In Objects
 * 
 * Facebook has defined a set of common object types for use in your apps. Certain Built-in Object Types are designed to work with Built-in Action Types. However, you can also define Custom Action Types to act on any Built-in Object Type. In order to use Built-in Objects in your app, you will need to register them in the App Dashboard. The following Built-in Object Types are available:
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
 * Built-in Object Types are defined with object properties, represented as Open Graph meta tags with Simple Types. In addition, we have created a set of predefined groups of meta tags that can be used as a property of any Open Graph object, called Complex Types.
 * 
 * Article
 * Property Name	Description	Type
 * Title	Article Name	String
 * Description	Description of Article	String
 * Image	Array of images.
 * The images must be at least 50px by 50px (though minimum 200px by 200px is preferred) and have a maximum aspect ratio of 3:1. We support PNG, JPEG and GIF formats.	Image[]
 * URL	Open Graph URL for the article	URL
 * Site Name	Human-readable name of site hosting the article	String
 * Published Time	Time when article was published	DateTime
 * Modified Time	Time when article was last updated	DateTime
 * Expiration Time 	Time when the article should expire.
 * 
 * The expiration time is used as a signal to determine when stories are promoted and for how long. Stories will be naturally expired. 	DateTime
 * Author	Array of authors of the article	Profile[]
 * Section	Section this article belongs to
 * (e.g. Sports, Lifestyle)	String
 * Tag	Key words for the article	String[]
 * Example
 * 
 * <html>
 *     <head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# 
 *                   article: http://ogp.me/ns/article#">
 *      <meta property="fb:app_id"               content="YOUR_APP_ID"> 
 *      <meta property="og:type"                 content="article"> 
 *      <meta property="og:url"                  content="URL of this object">
 *      <meta property="og:site_name"            content="Name of site hosting article">
 *      <meta property="og:image"                content="URL to an image">
 *      <meta property="og:title"                content="Name of article">
 *      <meta property="og:description"          content="Description of object"> 
 *      <meta property="article:published_time"  content="DateTime"> 
 *      <meta property="article:modified_time"   content="DateTime"> 
 *      <meta property="article:expiration_time" content="DateTime">
 *      <meta property="article:author"          content="URL to Author object">
 *      <meta property="article:section"         content="Section of article">
 *      <meta property="article:tag"             content="Keyword">
 *     </head>
 * <body>
 *     <!-- main article body -->
 * </body>
 * </html>
 * 
 * 
 * Example OG markup of http://www.stanforddaily.com/2011/01/24/card-trounces-trojans/
 * 
 * <html>
 *     <head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# 
 *                   article: http://ogp.me/ns/article#">
 *      <meta property="fb:app_id"               content="YOUR_APP_ID"> 
 *      <meta property="og:type"                 content="article"> 
 *      <meta property="og:url"                  content="http://www.stanforddaily.com/2011/01/24/card-trounces-trojans/">
 *      <meta property="og:site_name"            content="The Stanford Daily"/>
 *      <meta property="og:image"                content="http://www.stanforddaily.com/wp-content/uploads/2011/01/SPO.012411.wbb_.jpg">
 *      <meta property="og:title"                content="W. Basketball: Trojans trounced">
 *      <meta property="og:description"          content="It might be a little early to give Stanford the national trophy, but that didn't stop USC head coach Michael Cooper from making a firm prediction following his team's 95-51 loss to No. 4 Stanford women's basketball on Saturday afternoon."> 
 *      <meta property="article:published_time"  content="2010-01-24">
 *      <meta property="article:expiration_time" content="2010-01-26">
 *      <meta property="article:author"          content="http://www.stanforddaily.com/author/ivynguyen/">
 *      <meta property="article:section"         content="Sports">
 *      <meta property="article:tag"             content="Stanford women's basketball">
 *      <meta property="article:tag"             content="USC">
 *      <meta property="article:tag"             content="Jeanette Pohlen">
 *     </head>
 * <body>
 *     <!--main article body -->
 * </body>
 * </html>
 * 
 * Blog
 * Property Name	Description	Type
 * Title	Blog Name	String
 * Description	Description of Blog	String
 * Image	Array of images	Image[]
 * URL	Open Graph URL for the blog	URL
 * Example
 * 
 * <html>
 *     <head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# 
 *                   blog: http://ogp.me/ns/blog#">
 *      <meta property="fb:app_id"               content="YOUR_APP_ID"> 
 *      <meta property="og:type"                 content="blog"> 
 *      <meta property="og:url"                  content="URL of this object"> 
 *      <meta property="og:image"                content="URL to an image">
 *      <meta property="og:title"                content="Name of blog">
 *      <meta property="og:description"          content="Description of object"> 
 *     </head>
 * <body>
 *     <!--a wonderful blog  -->
 * </body>
 * </html>
 * 
 * Book
 * Property Name	Description	Type
 * Title	Book Name	String
 * Description	Description of Book	String
 * Image	Array of images	Image[]
 * URL	Open Graph URL for the book	URL
 * Author	Array of authors of the book	Profile[]
 * ISBN	ISBN of book	String
 * Release Date	When the book was published	DateTime
 * Tag	Key words for the book	String[]
 * Example
 * 
 * <html>
 *     <head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# 
 *                   book: http://ogp.me/ns/book#">
 *      <meta property="fb:app_id"               content="YOUR_APP_ID"> 
 *      <meta property="og:type"                 content="book"> 
 *      <meta property="og:url"                  content="URL of this object">
 *      <meta property="og:image"                content="URL to an image">
 *      <meta property="og:description"          content="Description of content">
 *      <meta property="og:title"                content="Name of book">
 *      <meta property="book:release_date"       content="DateTime">
 *      <meta property="book:author"             content="Who wrote this">
 *      <meta property="book:isbn"               content="ISBN Number">
 *      <meta property="book:tag"                content="keywords">
 *     </head>
 * <body>
 *     <!--a wonderful book -->
 * </body>
 * </html>
 * 
 * Profile (External)
 * Property Name	Description	Type
 * Title	Profile Name	String
 * Description	Description of Profile Object	String
 * Image	Array of images	Image[]
 * URL	Open Graph URL of the Profile	URL
 * First Name	First Name of Profile	String
 * Last Name	Last Name of Profile	String
 * Username	Username of Profile, if applicable	String
 * Gender	male or female	Enum
 * Profile ID	The equivalent Facebook User ID of this user profile, if known. We strongly recommend using the encrypted version of the Facebook User ID, known as the Third-Party FB UID	String
 * Example
 * 
 * <html>
 *     <head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# 
 *                   profile: http://ogp.me/ns/profile#">
 *      <meta property="fb:app_id"               content="YOUR_APP_ID"> 
 *      <meta property="og:type"                 content="profile"> 
 *      <meta property="og:url"                  content="URL of this object">
 *      <meta property="og:image"                content="URL to an image">
 *      <meta property="og:title"                content="Name of User">
 *      <meta property="og:description"          content="Description of content">
 *      <meta property="profile:first_name"      content="First Name">
 *      <meta property="profile:last_name"       content="Last Name">
 *      <meta property="profile:username"        content="UserName">
 *      <meta property="profile:gender"          content="male | female">
 *      <meta property="fb:profile_id"           content="THIRD_PARTY_FB_UID">
 *     </head>
 * <body>
 *     <!--a wonderful user profile -->
 * </body>
 * </html>
 * 
 * Reference: http://developers.facebook.com/docs/technical-guides/opengraph/built-in-objects/#external_profile
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.social.builtin.ExternalProfile#getProfileId <em>Profile Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.social.builtin.BuiltinPackage#getExternalProfile()
 * @model
 * @generated
 */
public interface ExternalProfile extends Target, PersonLike {

	/**
	 * Returns the value of the '<em><b>Profile Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The equivalent Facebook User ID of this user profile, if known. We strongly recommend using the encrypted version of the Facebook User ID, known as the Third-Party FB UID
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Profile Id</em>' attribute.
	 * @see #setProfileId(String)
	 * @see org.soluvas.social.builtin.BuiltinPackage#getExternalProfile_ProfileId()
	 * @model
	 * @generated
	 */
	String getProfileId();

	/**
	 * Sets the value of the '{@link org.soluvas.social.builtin.ExternalProfile#getProfileId <em>Profile Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile Id</em>' attribute.
	 * @see #getProfileId()
	 * @generated
	 */
	void setProfileId(String value);
} // ExternalProfile

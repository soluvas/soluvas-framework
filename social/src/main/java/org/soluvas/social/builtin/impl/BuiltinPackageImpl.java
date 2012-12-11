/**
 */
package org.soluvas.social.builtin.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.soluvas.commons.CommonsPackage;

import org.soluvas.social.SocialPackage;

import org.soluvas.social.builtin.Activity;
import org.soluvas.social.builtin.Article;
import org.soluvas.social.builtin.Blog;
import org.soluvas.social.builtin.Book;
import org.soluvas.social.builtin.BuiltinFactory;
import org.soluvas.social.builtin.BuiltinPackage;
import org.soluvas.social.builtin.ExternalProfile;
import org.soluvas.social.builtin.Movie;
import org.soluvas.social.builtin.Person;
import org.soluvas.social.builtin.TvEpisode;
import org.soluvas.social.builtin.TvShow;
import org.soluvas.social.builtin.Video;
import org.soluvas.social.builtin.Website;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BuiltinPackageImpl extends EPackageImpl implements BuiltinPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass personEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass articleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blogEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bookEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalProfileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass movieEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tvEpisodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tvShowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass videoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass websiteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activityEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.soluvas.social.builtin.BuiltinPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BuiltinPackageImpl() {
		super(eNS_URI, BuiltinFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link BuiltinPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BuiltinPackage init() {
		if (isInited) return (BuiltinPackage)EPackage.Registry.INSTANCE.getEPackage(BuiltinPackage.eNS_URI);

		// Obtain or create and register package
		BuiltinPackageImpl theBuiltinPackage = (BuiltinPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BuiltinPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BuiltinPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		SocialPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theBuiltinPackage.createPackageContents();

		// Initialize created meta-data
		theBuiltinPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBuiltinPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BuiltinPackage.eNS_URI, theBuiltinPackage);
		return theBuiltinPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPerson() {
		return personEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArticle() {
		return articleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlog() {
		return blogEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBook() {
		return bookEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalProfile() {
		return externalProfileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExternalProfile_ProfileId() {
		return (EAttribute)externalProfileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMovie() {
		return movieEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTvEpisode() {
		return tvEpisodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTvShow() {
		return tvShowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVideo() {
		return videoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWebsite() {
		return websiteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActivity() {
		return activityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuiltinFactory getBuiltinFactory() {
		return (BuiltinFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		personEClass = createEClass(PERSON);

		articleEClass = createEClass(ARTICLE);

		blogEClass = createEClass(BLOG);

		bookEClass = createEClass(BOOK);

		externalProfileEClass = createEClass(EXTERNAL_PROFILE);
		createEAttribute(externalProfileEClass, EXTERNAL_PROFILE__PROFILE_ID);

		movieEClass = createEClass(MOVIE);

		tvEpisodeEClass = createEClass(TV_EPISODE);

		tvShowEClass = createEClass(TV_SHOW);

		videoEClass = createEClass(VIDEO);

		websiteEClass = createEClass(WEBSITE);

		activityEClass = createEClass(ACTIVITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		SocialPackage theSocialPackage = (SocialPackage)EPackage.Registry.INSTANCE.getEPackage(SocialPackage.eNS_URI);
		CommonsPackage theCommonsPackage = (CommonsPackage)EPackage.Registry.INSTANCE.getEPackage(CommonsPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		personEClass.getESuperTypes().add(theSocialPackage.getTarget());
		personEClass.getESuperTypes().add(theCommonsPackage.getIdentifiable());
		personEClass.getESuperTypes().add(theCommonsPackage.getNameContainer());
		personEClass.getESuperTypes().add(theCommonsPackage.getPhotoIdContainer());
		personEClass.getESuperTypes().add(theCommonsPackage.getSluggable());
		personEClass.getESuperTypes().add(theSocialPackage.getPersonLike());
		articleEClass.getESuperTypes().add(theSocialPackage.getTarget());
		blogEClass.getESuperTypes().add(theSocialPackage.getTarget());
		bookEClass.getESuperTypes().add(theSocialPackage.getTarget());
		externalProfileEClass.getESuperTypes().add(theSocialPackage.getTarget());
		externalProfileEClass.getESuperTypes().add(theSocialPackage.getPersonLike());
		movieEClass.getESuperTypes().add(theSocialPackage.getTarget());
		tvEpisodeEClass.getESuperTypes().add(theSocialPackage.getTarget());
		tvShowEClass.getESuperTypes().add(theSocialPackage.getTarget());
		videoEClass.getESuperTypes().add(theSocialPackage.getTarget());
		websiteEClass.getESuperTypes().add(theSocialPackage.getTarget());
		activityEClass.getESuperTypes().add(theSocialPackage.getTarget());

		// Initialize classes and features; add operations and parameters
		initEClass(personEClass, Person.class, "Person", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(articleEClass, Article.class, "Article", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(blogEClass, Blog.class, "Blog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bookEClass, Book.class, "Book", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(externalProfileEClass, ExternalProfile.class, "ExternalProfile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExternalProfile_ProfileId(), theEcorePackage.getEString(), "profileId", null, 0, 1, ExternalProfile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(movieEClass, Movie.class, "Movie", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tvEpisodeEClass, TvEpisode.class, "TvEpisode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tvShowEClass, TvShow.class, "TvShow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(videoEClass, Video.class, "Video", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(websiteEClass, Website.class, "Website", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(activityEClass, Activity.class, "Activity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/GenModel</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGenModelAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/GenModel";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "documentation", "Can comment on a Target, or even another activity."
		   });		
		addAnnotation
		  (personEClass, 
		   source, 
		   new String[] {
			 "documentation", "Internal Person profile."
		   });		
		addAnnotation
		  (externalProfileEClass, 
		   source, 
		   new String[] {
			 "documentation", "name = Profile Name.\n\n    Getting Started\n    Core Concepts\n    Advanced Topics\n    Technical Guides\n        Login\n        Open Graph\n        FQL\n        Mobile App Install Ads\n        Samples & How Tos\n    API Reference\n    SDK Reference\n\n    Getting Started\n        Open Graph Insights\n        Open Graph Tutorial\n        Open Graph Video Tutorials\n    Actions\n        How-To: Built-In Actions\n        How-To: Built-In Like\n        How-To: Define an Action Type\n        How-To: Publish Watch Actions\n        How-To: Publish an Action\n        Introduction to the Built-In Watch Action\n    Objects\n        How-To: Complex Object Types\n        How-To: Custom Object Properties\n        How-To: Defining an Object\n        How-To: Defining an Object (Using the Online Tool)\n        How-To: Simple Object Types\n        How-To: Using Built-In Objects\n    Aggregations\n        How-To: Defining an Aggregation\n        How-To: Using Templates to Build Aggregations\n    Advanced\n        How To: Customize Per-Post Privacy\n        How-To: Action Links\n        How-To: Explicit Sharing\n        How-To: Follows (on Open Graph)\n        How-To: Mention Tagging\n        How-To: Open Graph Internationalization\n        How-To: Parse Parameters from Open Graph Links\n        How-To: Posting Past Actions\n        How-To: Publishing With an App Token\n        How-To: Title-less Objects\n        How-To: User Restrictions\n        Introduction to Tagging People & Places\n    Authentication\n        How-To: Open Graph Auth Referrals\n        How-To: Open Graph Authentication Dialogs and Permissions\n    Submission Process\n        Open Graph Guidelines\n        Understanding the Open Graph Submission Process\n    Best Practices\n        Best Practices: Creating Open Graph Stories\n        Best Practices: Creating Timeline Aggregations\n        Best Practices: Creating Usage Instructions\n        Best Practices: Grow Your App With Open Graph\n        Best Practices: Working With Custom Properties\n        Best Practices: Working With Multiple Objects\n        Tips & Tricks for Using Open Graph\n\nHow-To: Using Built-In Objects\nTechnical Guides \u203a Open Graph \u203a How-To: Using Built-In Objects\n\nFacebook has defined a set of common object types for use in your apps. Certain Built-in Object Types are designed to work with Built-in Action Types. However, you can also define Custom Action Types to act on any Built-in Object Type. In order to use Built-in Objects in your app, you will need to register them in the App Dashboard. The following Built-in Object Types are available:\n\n    Article\n    Blog\n    Book\n    Profile (External)\n    Movie\n    TV Episode\n    TV Show\n    Video\n    Website\n\nBuilt-in Object Types are defined with object properties, represented as Open Graph meta tags with Simple Types. In addition, we have created a set of predefined groups of meta tags that can be used as a property of any Open Graph object, called Complex Types.\n\nArticle\nProperty Name\tDescription\tType\nTitle\tArticle Name\tString\nDescription\tDescription of Article\tString\nImage\tArray of images.\nThe images must be at least 50px by 50px (though minimum 200px by 200px is preferred) and have a maximum aspect ratio of 3:1. We support PNG, JPEG and GIF formats.\tImage[]\nURL\tOpen Graph URL for the article\tURL\nSite Name\tHuman-readable name of site hosting the article\tString\nPublished Time\tTime when article was published\tDateTime\nModified Time\tTime when article was last updated\tDateTime\nExpiration Time \tTime when the article should expire.\n\nThe expiration time is used as a signal to determine when stories are promoted and for how long. Stories will be naturally expired. \tDateTime\nAuthor\tArray of authors of the article\tProfile[]\nSection\tSection this article belongs to\n(e.g. Sports, Lifestyle)\tString\nTag\tKey words for the article\tString[]\nExample\n\n<html>\n    <head prefix=\"og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# \n                  article: http://ogp.me/ns/article#\">\n     <meta property=\"fb:app_id\"               content=\"YOUR_APP_ID\"> \n     <meta property=\"og:type\"                 content=\"article\"> \n     <meta property=\"og:url\"                  content=\"URL of this object\">\n     <meta property=\"og:site_name\"            content=\"Name of site hosting article\">\n     <meta property=\"og:image\"                content=\"URL to an image\">\n     <meta property=\"og:title\"                content=\"Name of article\">\n     <meta property=\"og:description\"          content=\"Description of object\"> \n     <meta property=\"article:published_time\"  content=\"DateTime\"> \n     <meta property=\"article:modified_time\"   content=\"DateTime\"> \n     <meta property=\"article:expiration_time\" content=\"DateTime\">\n     <meta property=\"article:author\"          content=\"URL to Author object\">\n     <meta property=\"article:section\"         content=\"Section of article\">\n     <meta property=\"article:tag\"             content=\"Keyword\">\n    </head>\n<body>\n    <!-- main article body -->\n</body>\n</html>\n\n\nExample OG markup of http://www.stanforddaily.com/2011/01/24/card-trounces-trojans/\n\n<html>\n    <head prefix=\"og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# \n                  article: http://ogp.me/ns/article#\">\n     <meta property=\"fb:app_id\"               content=\"YOUR_APP_ID\"> \n     <meta property=\"og:type\"                 content=\"article\"> \n     <meta property=\"og:url\"                  content=\"http://www.stanforddaily.com/2011/01/24/card-trounces-trojans/\">\n     <meta property=\"og:site_name\"            content=\"The Stanford Daily\"/>\n     <meta property=\"og:image\"                content=\"http://www.stanforddaily.com/wp-content/uploads/2011/01/SPO.012411.wbb_.jpg\">\n     <meta property=\"og:title\"                content=\"W. Basketball: Trojans trounced\">\n     <meta property=\"og:description\"          content=\"It might be a little early to give Stanford the national trophy, but that didn\'t stop USC head coach Michael Cooper from making a firm prediction following his team\'s 95-51 loss to No. 4 Stanford women\'s basketball on Saturday afternoon.\"> \n     <meta property=\"article:published_time\"  content=\"2010-01-24\">\n     <meta property=\"article:expiration_time\" content=\"2010-01-26\">\n     <meta property=\"article:author\"          content=\"http://www.stanforddaily.com/author/ivynguyen/\">\n     <meta property=\"article:section\"         content=\"Sports\">\n     <meta property=\"article:tag\"             content=\"Stanford women\'s basketball\">\n     <meta property=\"article:tag\"             content=\"USC\">\n     <meta property=\"article:tag\"             content=\"Jeanette Pohlen\">\n    </head>\n<body>\n    <!--main article body -->\n</body>\n</html>\n\nBlog\nProperty Name\tDescription\tType\nTitle\tBlog Name\tString\nDescription\tDescription of Blog\tString\nImage\tArray of images\tImage[]\nURL\tOpen Graph URL for the blog\tURL\nExample\n\n<html>\n    <head prefix=\"og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# \n                  blog: http://ogp.me/ns/blog#\">\n     <meta property=\"fb:app_id\"               content=\"YOUR_APP_ID\"> \n     <meta property=\"og:type\"                 content=\"blog\"> \n     <meta property=\"og:url\"                  content=\"URL of this object\"> \n     <meta property=\"og:image\"                content=\"URL to an image\">\n     <meta property=\"og:title\"                content=\"Name of blog\">\n     <meta property=\"og:description\"          content=\"Description of object\"> \n    </head>\n<body>\n    <!--a wonderful blog  -->\n</body>\n</html>\n\nBook\nProperty Name\tDescription\tType\nTitle\tBook Name\tString\nDescription\tDescription of Book\tString\nImage\tArray of images\tImage[]\nURL\tOpen Graph URL for the book\tURL\nAuthor\tArray of authors of the book\tProfile[]\nISBN\tISBN of book\tString\nRelease Date\tWhen the book was published\tDateTime\nTag\tKey words for the book\tString[]\nExample\n\n<html>\n    <head prefix=\"og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# \n                  book: http://ogp.me/ns/book#\">\n     <meta property=\"fb:app_id\"               content=\"YOUR_APP_ID\"> \n     <meta property=\"og:type\"                 content=\"book\"> \n     <meta property=\"og:url\"                  content=\"URL of this object\">\n     <meta property=\"og:image\"                content=\"URL to an image\">\n     <meta property=\"og:description\"          content=\"Description of content\">\n     <meta property=\"og:title\"                content=\"Name of book\">\n     <meta property=\"book:release_date\"       content=\"DateTime\">\n     <meta property=\"book:author\"             content=\"Who wrote this\">\n     <meta property=\"book:isbn\"               content=\"ISBN Number\">\n     <meta property=\"book:tag\"                content=\"keywords\">\n    </head>\n<body>\n    <!--a wonderful book -->\n</body>\n</html>\n\nProfile (External)\nProperty Name\tDescription\tType\nTitle\tProfile Name\tString\nDescription\tDescription of Profile Object\tString\nImage\tArray of images\tImage[]\nURL\tOpen Graph URL of the Profile\tURL\nFirst Name\tFirst Name of Profile\tString\nLast Name\tLast Name of Profile\tString\nUsername\tUsername of Profile, if applicable\tString\nGender\tmale or female\tEnum\nProfile ID\tThe equivalent Facebook User ID of this user profile, if known. We strongly recommend using the encrypted version of the Facebook User ID, known as the Third-Party FB UID\tString\nExample\n\n<html>\n    <head prefix=\"og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# \n                  profile: http://ogp.me/ns/profile#\">\n     <meta property=\"fb:app_id\"               content=\"YOUR_APP_ID\"> \n     <meta property=\"og:type\"                 content=\"profile\"> \n     <meta property=\"og:url\"                  content=\"URL of this object\">\n     <meta property=\"og:image\"                content=\"URL to an image\">\n     <meta property=\"og:title\"                content=\"Name of User\">\n     <meta property=\"og:description\"          content=\"Description of content\">\n     <meta property=\"profile:first_name\"      content=\"First Name\">\n     <meta property=\"profile:last_name\"       content=\"Last Name\">\n     <meta property=\"profile:username\"        content=\"UserName\">\n     <meta property=\"profile:gender\"          content=\"male | female\">\n     <meta property=\"fb:profile_id\"           content=\"THIRD_PARTY_FB_UID\">\n    </head>\n<body>\n    <!--a wonderful user profile -->\n</body>\n</html>\n\nReference: http://developers.facebook.com/docs/technical-guides/opengraph/built-in-objects/#external_profile"
		   });		
		addAnnotation
		  (getExternalProfile_ProfileId(), 
		   source, 
		   new String[] {
			 "documentation", "The equivalent Facebook User ID of this user profile, if known. We strongly recommend using the encrypted version of the Facebook User ID, known as the Third-Party FB UID"
		   });		
		addAnnotation
		  (activityEClass, 
		   source, 
		   new String[] {
			 "documentation", "Another action."
		   });
	}

} //BuiltinPackageImpl

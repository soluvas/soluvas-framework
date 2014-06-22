/**
 */
package org.soluvas.socmed.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.soluvas.socmed.FacebookSysConfig;
import org.soluvas.socmed.InstagramSysConfig;
import org.soluvas.socmed.PinterestSysConfig;
import org.soluvas.socmed.SocmedFactory;
import org.soluvas.socmed.SocmedPackage;
import org.soluvas.socmed.TwitterSysConfig;
import org.soluvas.socmed.YouTubeSysConfig;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SocmedPackageImpl extends EPackageImpl implements SocmedPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass facebookSysConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass twitterSysConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass youTubeSysConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pinterestSysConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instagramSysConfigEClass = null;

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
	 * @see org.soluvas.socmed.SocmedPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SocmedPackageImpl() {
		super(eNS_URI, SocmedFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SocmedPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SocmedPackage init() {
		if (isInited) return (SocmedPackage)EPackage.Registry.INSTANCE.getEPackage(SocmedPackage.eNS_URI);

		// Obtain or create and register package
		SocmedPackageImpl theSocmedPackage = (SocmedPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SocmedPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SocmedPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theSocmedPackage.createPackageContents();

		// Initialize created meta-data
		theSocmedPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSocmedPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SocmedPackage.eNS_URI, theSocmedPackage);
		return theSocmedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFacebookSysConfig() {
		return facebookSysConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacebookSysConfig_FacebookAppId() {
		return (EAttribute)facebookSysConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacebookSysConfig_FacebookAppSecret() {
		return (EAttribute)facebookSysConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacebookSysConfig_FacebookTenantAccessToken() {
		return (EAttribute)facebookSysConfigEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacebookSysConfig_FacebookProfileId() {
		return (EAttribute)facebookSysConfigEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacebookSysConfig_FacebookProfileUsername() {
		return (EAttribute)facebookSysConfigEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacebookSysConfig_FacebookProfileName() {
		return (EAttribute)facebookSysConfigEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacebookSysConfig_FacebookTenantPageId() {
		return (EAttribute)facebookSysConfigEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacebookSysConfig_FacebookTenantPageUsername() {
		return (EAttribute)facebookSysConfigEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacebookSysConfig_FacebookTenantPublishEnabled() {
		return (EAttribute)facebookSysConfigEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacebookSysConfig_FacebookExplicitlyShared() {
		return (EAttribute)facebookSysConfigEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTwitterSysConfig() {
		return twitterSysConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTwitterSysConfig_TwitterConsumerKey() {
		return (EAttribute)twitterSysConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTwitterSysConfig_TwitterConsumerSecret() {
		return (EAttribute)twitterSysConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTwitterSysConfig_TwitterTenantScreenName() {
		return (EAttribute)twitterSysConfigEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTwitterSysConfig_TwitterTenantAccessToken() {
		return (EAttribute)twitterSysConfigEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTwitterSysConfig_TwitterTenantAccessTokenSecret() {
		return (EAttribute)twitterSysConfigEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getYouTubeSysConfig() {
		return youTubeSysConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getYouTubeSysConfig_YouTubeTenantScreenName() {
		return (EAttribute)youTubeSysConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPinterestSysConfig() {
		return pinterestSysConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPinterestSysConfig_PinterestTenantScreenName() {
		return (EAttribute)pinterestSysConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstagramSysConfig() {
		return instagramSysConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstagramSysConfig_InstagramScreenName() {
		return (EAttribute)instagramSysConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SocmedFactory getSocmedFactory() {
		return (SocmedFactory)getEFactoryInstance();
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
		facebookSysConfigEClass = createEClass(FACEBOOK_SYS_CONFIG);
		createEAttribute(facebookSysConfigEClass, FACEBOOK_SYS_CONFIG__FACEBOOK_APP_ID);
		createEAttribute(facebookSysConfigEClass, FACEBOOK_SYS_CONFIG__FACEBOOK_APP_SECRET);
		createEAttribute(facebookSysConfigEClass, FACEBOOK_SYS_CONFIG__FACEBOOK_TENANT_ACCESS_TOKEN);
		createEAttribute(facebookSysConfigEClass, FACEBOOK_SYS_CONFIG__FACEBOOK_PROFILE_ID);
		createEAttribute(facebookSysConfigEClass, FACEBOOK_SYS_CONFIG__FACEBOOK_PROFILE_USERNAME);
		createEAttribute(facebookSysConfigEClass, FACEBOOK_SYS_CONFIG__FACEBOOK_PROFILE_NAME);
		createEAttribute(facebookSysConfigEClass, FACEBOOK_SYS_CONFIG__FACEBOOK_TENANT_PAGE_ID);
		createEAttribute(facebookSysConfigEClass, FACEBOOK_SYS_CONFIG__FACEBOOK_TENANT_PAGE_USERNAME);
		createEAttribute(facebookSysConfigEClass, FACEBOOK_SYS_CONFIG__FACEBOOK_TENANT_PUBLISH_ENABLED);
		createEAttribute(facebookSysConfigEClass, FACEBOOK_SYS_CONFIG__FACEBOOK_EXPLICITLY_SHARED);

		twitterSysConfigEClass = createEClass(TWITTER_SYS_CONFIG);
		createEAttribute(twitterSysConfigEClass, TWITTER_SYS_CONFIG__TWITTER_CONSUMER_KEY);
		createEAttribute(twitterSysConfigEClass, TWITTER_SYS_CONFIG__TWITTER_CONSUMER_SECRET);
		createEAttribute(twitterSysConfigEClass, TWITTER_SYS_CONFIG__TWITTER_TENANT_SCREEN_NAME);
		createEAttribute(twitterSysConfigEClass, TWITTER_SYS_CONFIG__TWITTER_TENANT_ACCESS_TOKEN);
		createEAttribute(twitterSysConfigEClass, TWITTER_SYS_CONFIG__TWITTER_TENANT_ACCESS_TOKEN_SECRET);

		youTubeSysConfigEClass = createEClass(YOU_TUBE_SYS_CONFIG);
		createEAttribute(youTubeSysConfigEClass, YOU_TUBE_SYS_CONFIG__YOU_TUBE_TENANT_SCREEN_NAME);

		pinterestSysConfigEClass = createEClass(PINTEREST_SYS_CONFIG);
		createEAttribute(pinterestSysConfigEClass, PINTEREST_SYS_CONFIG__PINTEREST_TENANT_SCREEN_NAME);

		instagramSysConfigEClass = createEClass(INSTAGRAM_SYS_CONFIG);
		createEAttribute(instagramSysConfigEClass, INSTAGRAM_SYS_CONFIG__INSTAGRAM_SCREEN_NAME);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(facebookSysConfigEClass, FacebookSysConfig.class, "FacebookSysConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFacebookSysConfig_FacebookAppId(), ecorePackage.getELongObject(), "facebookAppId", null, 0, 1, FacebookSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFacebookSysConfig_FacebookAppSecret(), ecorePackage.getEString(), "facebookAppSecret", null, 0, 1, FacebookSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFacebookSysConfig_FacebookTenantAccessToken(), ecorePackage.getEString(), "facebookTenantAccessToken", null, 0, 1, FacebookSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFacebookSysConfig_FacebookProfileId(), ecorePackage.getELongObject(), "facebookProfileId", null, 0, 1, FacebookSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFacebookSysConfig_FacebookProfileUsername(), ecorePackage.getEString(), "facebookProfileUsername", null, 0, 1, FacebookSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFacebookSysConfig_FacebookProfileName(), ecorePackage.getEString(), "facebookProfileName", null, 0, 1, FacebookSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFacebookSysConfig_FacebookTenantPageId(), ecorePackage.getELongObject(), "facebookTenantPageId", null, 0, 1, FacebookSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFacebookSysConfig_FacebookTenantPageUsername(), ecorePackage.getEString(), "facebookTenantPageUsername", null, 0, 1, FacebookSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFacebookSysConfig_FacebookTenantPublishEnabled(), ecorePackage.getEBooleanObject(), "facebookTenantPublishEnabled", "false", 0, 1, FacebookSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFacebookSysConfig_FacebookExplicitlyShared(), ecorePackage.getEBooleanObject(), "facebookExplicitlyShared", "false", 0, 1, FacebookSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(twitterSysConfigEClass, TwitterSysConfig.class, "TwitterSysConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTwitterSysConfig_TwitterConsumerKey(), ecorePackage.getEString(), "twitterConsumerKey", null, 0, 1, TwitterSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTwitterSysConfig_TwitterConsumerSecret(), ecorePackage.getEString(), "twitterConsumerSecret", null, 0, 1, TwitterSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTwitterSysConfig_TwitterTenantScreenName(), ecorePackage.getEString(), "twitterTenantScreenName", null, 0, 1, TwitterSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTwitterSysConfig_TwitterTenantAccessToken(), ecorePackage.getEString(), "twitterTenantAccessToken", null, 0, 1, TwitterSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTwitterSysConfig_TwitterTenantAccessTokenSecret(), ecorePackage.getEString(), "twitterTenantAccessTokenSecret", null, 0, 1, TwitterSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(youTubeSysConfigEClass, YouTubeSysConfig.class, "YouTubeSysConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getYouTubeSysConfig_YouTubeTenantScreenName(), ecorePackage.getEString(), "youTubeTenantScreenName", null, 0, 1, YouTubeSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pinterestSysConfigEClass, PinterestSysConfig.class, "PinterestSysConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPinterestSysConfig_PinterestTenantScreenName(), ecorePackage.getEString(), "pinterestTenantScreenName", null, 0, 1, PinterestSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(instagramSysConfigEClass, InstagramSysConfig.class, "InstagramSysConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInstagramSysConfig_InstagramScreenName(), ecorePackage.getEString(), "instagramScreenName", null, 0, 1, InstagramSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		  (facebookSysConfigEClass, 
		   source, 
		   new String[] {
			 "documentation", "Facebook SysConfig for tenant."
		   });		
		addAnnotation
		  (getFacebookSysConfig_FacebookAppId(), 
		   source, 
		   new String[] {
			 "documentation", "Facebook App ID for this tenant, it\'s used for Facebook-based login/authentication and also for publishing actions using Facebook OpenGraph APIs."
		   });		
		addAnnotation
		  (getFacebookSysConfig_FacebookAppSecret(), 
		   source, 
		   new String[] {
			 "documentation", "Facebook App Secret for this tenant, it\'s used for Facebook-based login/authentication and also for publishing actions using Facebook OpenGraph APIs."
		   });		
		addAnnotation
		  (getFacebookSysConfig_FacebookTenantAccessToken(), 
		   source, 
		   new String[] {
			 "documentation", "Facebook access token for the tenant/mall Facebook Page. This is a Page token, not a User token."
		   });		
		addAnnotation
		  (getFacebookSysConfig_FacebookProfileId(), 
		   source, 
		   new String[] {
			 "documentation", "Facebook (User) Profile ID, if exists."
		   });		
		addAnnotation
		  (getFacebookSysConfig_FacebookProfileUsername(), 
		   source, 
		   new String[] {
			 "documentation", "Facebook (User) Profile username, if exists."
		   });		
		addAnnotation
		  (getFacebookSysConfig_FacebookProfileName(), 
		   source, 
		   new String[] {
			 "documentation", "For some strange reason, Facebook ID is not unique, a user can have 2 different IDs. :(\nSo this is additional way to check for posts/comments by self."
		   });		
		addAnnotation
		  (getFacebookSysConfig_FacebookTenantPageId(), 
		   source, 
		   new String[] {
			 "documentation", "Facebook Page ID for the tenant/mall Facebook Page. This is a Page ID, not a User ID."
		   });		
		addAnnotation
		  (getFacebookSysConfig_FacebookTenantPageUsername(), 
		   source, 
		   new String[] {
			 "documentation", "Facebook Page username for the tenant/mall Facebook Page. This is a Page username, not a User ID.\nIf unknown, this should be the same as {@literal facebookTenantPageId}."
		   });		
		addAnnotation
		  (getFacebookSysConfig_FacebookTenantPublishEnabled(), 
		   source, 
		   new String[] {
			 "documentation", "Whether features to publish to tenant\'s Facebook Page are enabled. This requires both the {@code facebookTenantAccessToken} and {@code facebookTenantPageId} to be filled properly."
		   });		
		addAnnotation
		  (getFacebookSysConfig_FacebookExplicitlyShared(), 
		   source, 
		   new String[] {
			 "documentation", "Whether publishing will use the \"explicitly_shared\" flag. Note: The Facebook App ID used must be prepared to support explicitly_shared, which requires additional approval from Facebook."
		   });		
		addAnnotation
		  (twitterSysConfigEClass, 
		   source, 
		   new String[] {
			 "documentation", "Twitter SysConfig for tenant."
		   });		
		addAnnotation
		  (getTwitterSysConfig_TwitterConsumerKey(), 
		   source, 
		   new String[] {
			 "documentation", "Twitter consumer key for this tenant."
		   });		
		addAnnotation
		  (getTwitterSysConfig_TwitterConsumerSecret(), 
		   source, 
		   new String[] {
			 "documentation", "Twitter consumer key for this tenant."
		   });		
		addAnnotation
		  (getTwitterSysConfig_TwitterTenantScreenName(), 
		   source, 
		   new String[] {
			 "documentation", "Twitter account screen name for this tenant."
		   });		
		addAnnotation
		  (getTwitterSysConfig_TwitterTenantAccessToken(), 
		   source, 
		   new String[] {
			 "documentation", "Access token that has access to this tenant\'s Twitter account, referred by {@link #getTwitterTenantScreenName()}."
		   });		
		addAnnotation
		  (getTwitterSysConfig_TwitterTenantAccessTokenSecret(), 
		   source, 
		   new String[] {
			 "documentation", "Access token secret that has access to this tenant\'s Twitter account, referred by {@link #getTwitterTenantScreenName()}."
		   });		
		addAnnotation
		  (youTubeSysConfigEClass, 
		   source, 
		   new String[] {
			 "documentation", "YouTube SysConfig for tenant."
		   });		
		addAnnotation
		  (getYouTubeSysConfig_YouTubeTenantScreenName(), 
		   source, 
		   new String[] {
			 "documentation", "YouTube user screen name for the tenant, e.g. <a href=\"http://www.youtube.com/user/BippoID\">bippoID</a>."
		   });		
		addAnnotation
		  (getPinterestSysConfig_PinterestTenantScreenName(), 
		   source, 
		   new String[] {
			 "documentation", "Pinterest Business screen name for the tenant/mall."
		   });		
		addAnnotation
		  (instagramSysConfigEClass, 
		   source, 
		   new String[] {
			 "documentation", "Instagram SysConfig for tenant."
		   });		
		addAnnotation
		  (getInstagramSysConfig_InstagramScreenName(), 
		   source, 
		   new String[] {
			 "documentation", "Instagram screen name for tenant, usable in Instagram URI e.g. <a href=\"http://instagram.com/mamadanbayi\">http://instagram.com/mamadanbayi</a>."
		   });
	}

} //SocmedPackageImpl

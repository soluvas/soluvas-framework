/**
 */
package com.soluvas.story.builtin.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.soluvas.commons.CommonsPackage;

import com.soluvas.story.StoryPackage;
import com.soluvas.story.builtin.BuiltinFactory;
import com.soluvas.story.builtin.BuiltinPackage;
import com.soluvas.story.builtin.Comment;
import com.soluvas.story.builtin.Follow;
import com.soluvas.story.builtin.Like;
import com.soluvas.story.builtin.Listen;
import com.soluvas.story.builtin.Read;
import com.soluvas.story.builtin.Share;
import com.soluvas.story.builtin.TimeTrackable;
import com.soluvas.story.builtin.Watch;

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
	private EClass followEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass likeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass readEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass watchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timeTrackableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shareEClass = null;

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
	 * @see com.soluvas.story.builtin.BuiltinPackage#eNS_URI
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
		StoryPackage.eINSTANCE.eClass();

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
	@Override
	public EClass getFollow() {
		return followEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLike() {
		return likeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getListen() {
		return listenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRead() {
		return readEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getWatch() {
		return watchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getComment() {
		return commentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTimeTrackable() {
		return timeTrackableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTimeTrackable_StartTime() {
		return (EAttribute)timeTrackableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTimeTrackable_EndTime() {
		return (EAttribute)timeTrackableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getShare() {
		return shareEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
		followEClass = createEClass(FOLLOW);

		likeEClass = createEClass(LIKE);

		listenEClass = createEClass(LISTEN);

		readEClass = createEClass(READ);

		watchEClass = createEClass(WATCH);

		commentEClass = createEClass(COMMENT);

		timeTrackableEClass = createEClass(TIME_TRACKABLE);
		createEAttribute(timeTrackableEClass, TIME_TRACKABLE__START_TIME);
		createEAttribute(timeTrackableEClass, TIME_TRACKABLE__END_TIME);

		shareEClass = createEClass(SHARE);
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
		StoryPackage theStoryPackage = (StoryPackage)EPackage.Registry.INSTANCE.getEPackage(StoryPackage.eNS_URI);
		CommonsPackage theCommonsPackage = (CommonsPackage)EPackage.Registry.INSTANCE.getEPackage(CommonsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		followEClass.getESuperTypes().add(theStoryPackage.getAction());
		likeEClass.getESuperTypes().add(theStoryPackage.getAction());
		listenEClass.getESuperTypes().add(theStoryPackage.getAction());
		readEClass.getESuperTypes().add(theStoryPackage.getAction());
		readEClass.getESuperTypes().add(this.getTimeTrackable());
		watchEClass.getESuperTypes().add(theStoryPackage.getAction());
		watchEClass.getESuperTypes().add(this.getTimeTrackable());
		commentEClass.getESuperTypes().add(theStoryPackage.getAction());
		commentEClass.getESuperTypes().add(theStoryPackage.getMessageable());
		shareEClass.getESuperTypes().add(theStoryPackage.getAction());
		shareEClass.getESuperTypes().add(theStoryPackage.getMessageable());

		// Initialize classes and features; add operations and parameters
		initEClass(followEClass, Follow.class, "Follow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(likeEClass, Like.class, "Like", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(listenEClass, Listen.class, "Listen", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(readEClass, Read.class, "Read", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(watchEClass, Watch.class, "Watch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(commentEClass, Comment.class, "Comment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(timeTrackableEClass, TimeTrackable.class, "TimeTrackable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTimeTrackable_StartTime(), theCommonsPackage.getDateTime(), "startTime", null, 0, 1, TimeTrackable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimeTrackable_EndTime(), theCommonsPackage.getDateTime(), "endTime", null, 0, 1, TimeTrackable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(shareEClass, Share.class, "Share", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

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
		  (getTimeTrackable_StartTime(), 
		   source, 
		   new String[] {
			 "documentation", "When the action begins"
		   });		
		addAnnotation
		  (getTimeTrackable_EndTime(), 
		   source, 
		   new String[] {
			 "documentation", "When the action finishes"
		   });		
		addAnnotation
		  (shareEClass, 
		   source, 
		   new String[] {
			 "documentation", "Similar to comment, but it must have an attachment."
		   });
	}

} //BuiltinPackageImpl

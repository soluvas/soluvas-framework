/**
 */
package com.soluvas.story.schema.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osgi.framework.Bundle;
import org.soluvas.commons.BundleAware;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.EClassLinked;
import org.soluvas.commons.EClassStatus;
import org.soluvas.commons.EFactoryLinked;
import org.soluvas.commons.JavaClassLinked;
import org.soluvas.commons.JavaClassStatus;
import org.soluvas.commons.NsPrefixable;
import org.soluvas.commons.ResourceAware;
import org.soluvas.commons.ResourceType;
import org.soluvas.social.schema.TargetType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Preconditions;
import com.soluvas.story.Action;
import com.soluvas.story.schema.ActionLike;
import com.soluvas.story.schema.ActionType;
import com.soluvas.story.schema.ActionTypeStatus;
import com.soluvas.story.schema.SchemaPackage;
import com.soluvas.story.schema.TargetTypeRef;
import com.soluvas.story.schema.Tenses;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.soluvas.story.schema.impl.ActionTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.soluvas.story.schema.impl.ActionTypeImpl#getBundle <em>Bundle</em>}</li>
 *   <li>{@link com.soluvas.story.schema.impl.ActionTypeImpl#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link com.soluvas.story.schema.impl.ActionTypeImpl#getResourceUri <em>Resource Uri</em>}</li>
 *   <li>{@link com.soluvas.story.schema.impl.ActionTypeImpl#getResourceName <em>Resource Name</em>}</li>
 *   <li>{@link com.soluvas.story.schema.impl.ActionTypeImpl#getJavaClassName <em>Java Class Name</em>}</li>
 *   <li>{@link com.soluvas.story.schema.impl.ActionTypeImpl#getJavaClass <em>Java Class</em>}</li>
 *   <li>{@link com.soluvas.story.schema.impl.ActionTypeImpl#getJavaClassStatus <em>Java Class Status</em>}</li>
 *   <li>{@link com.soluvas.story.schema.impl.ActionTypeImpl#getEClass <em>EClass</em>}</li>
 *   <li>{@link com.soluvas.story.schema.impl.ActionTypeImpl#getEClassStatus <em>EClass Status</em>}</li>
 *   <li>{@link com.soluvas.story.schema.impl.ActionTypeImpl#getEPackageNsPrefix <em>EPackage Ns Prefix</em>}</li>
 *   <li>{@link com.soluvas.story.schema.impl.ActionTypeImpl#getEClassName <em>EClass Name</em>}</li>
 *   <li>{@link com.soluvas.story.schema.impl.ActionTypeImpl#getEPackageName <em>EPackage Name</em>}</li>
 *   <li>{@link com.soluvas.story.schema.impl.ActionTypeImpl#getEFactory <em>EFactory</em>}</li>
 *   <li>{@link com.soluvas.story.schema.impl.ActionTypeImpl#getTenses <em>Tenses</em>}</li>
 *   <li>{@link com.soluvas.story.schema.impl.ActionTypeImpl#getPastTense <em>Past Tense</em>}</li>
 *   <li>{@link com.soluvas.story.schema.impl.ActionTypeImpl#getPluralPastTense <em>Plural Past Tense</em>}</li>
 *   <li>{@link com.soluvas.story.schema.impl.ActionTypeImpl#getPresentTense <em>Present Tense</em>}</li>
 *   <li>{@link com.soluvas.story.schema.impl.ActionTypeImpl#getPluralPresentTense <em>Plural Present Tense</em>}</li>
 *   <li>{@link com.soluvas.story.schema.impl.ActionTypeImpl#getImperativeTense <em>Imperative Tense</em>}</li>
 *   <li>{@link com.soluvas.story.schema.impl.ActionTypeImpl#getNsPrefix <em>Ns Prefix</em>}</li>
 *   <li>{@link com.soluvas.story.schema.impl.ActionTypeImpl#getResolvedSubjectTypes <em>Resolved Subject Types</em>}</li>
 *   <li>{@link com.soluvas.story.schema.impl.ActionTypeImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link com.soluvas.story.schema.impl.ActionTypeImpl#getSubjectTypes <em>Subject Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActionTypeImpl extends EObjectImpl implements ActionType {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getBundle() <em>Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundle()
	 * @generated
	 * @ordered
	 */
	protected static final Bundle BUNDLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBundle() <em>Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundle()
	 * @generated
	 * @ordered
	 */
	protected Bundle bundle = BUNDLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getResourceType() <em>Resource Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceType()
	 * @generated
	 * @ordered
	 */
	protected static final ResourceType RESOURCE_TYPE_EDEFAULT = ResourceType.BUNDLE;

	/**
	 * The cached value of the '{@link #getResourceType() <em>Resource Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceType()
	 * @generated
	 * @ordered
	 */
	protected ResourceType resourceType = RESOURCE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getResourceUri() <em>Resource Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceUri()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOURCE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResourceUri() <em>Resource Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceUri()
	 * @generated
	 * @ordered
	 */
	protected String resourceUri = RESOURCE_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getResourceName() <em>Resource Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceName()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOURCE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResourceName() <em>Resource Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceName()
	 * @generated
	 * @ordered
	 */
	protected String resourceName = RESOURCE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getJavaClassName() <em>Java Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJavaClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String JAVA_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJavaClassName() <em>Java Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJavaClassName()
	 * @generated
	 * @ordered
	 */
	protected String javaClassName = JAVA_CLASS_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getJavaClass() <em>Java Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJavaClass()
	 * @generated
	 * @ordered
	 */
	protected Class<Action> javaClass;

	/**
	 * The default value of the '{@link #getJavaClassStatus() <em>Java Class Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJavaClassStatus()
	 * @generated
	 * @ordered
	 */
	protected static final JavaClassStatus JAVA_CLASS_STATUS_EDEFAULT = JavaClassStatus.UNRESOLVED;

	/**
	 * The cached value of the '{@link #getJavaClassStatus() <em>Java Class Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJavaClassStatus()
	 * @generated
	 * @ordered
	 */
	protected JavaClassStatus javaClassStatus = JAVA_CLASS_STATUS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEClass() <em>EClass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEClass()
	 * @generated
	 * @ordered
	 */
	protected EClass eClass;

	/**
	 * The default value of the '{@link #getEClassStatus() <em>EClass Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEClassStatus()
	 * @generated
	 * @ordered
	 */
	protected static final EClassStatus ECLASS_STATUS_EDEFAULT = EClassStatus.UNRESOLVED;

	/**
	 * The cached value of the '{@link #getEClassStatus() <em>EClass Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEClassStatus()
	 * @generated
	 * @ordered
	 */
	protected EClassStatus eClassStatus = ECLASS_STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getEPackageNsPrefix() <em>EPackage Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEPackageNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String EPACKAGE_NS_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEPackageNsPrefix() <em>EPackage Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEPackageNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected String ePackageNsPrefix = EPACKAGE_NS_PREFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getEClassName() <em>EClass Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String ECLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEClassName() <em>EClass Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEClassName()
	 * @generated
	 * @ordered
	 */
	protected String eClassName = ECLASS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getEPackageName() <em>EPackage Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEPackageName()
	 * @generated
	 * @ordered
	 */
	protected static final String EPACKAGE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEPackageName() <em>EPackage Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEPackageName()
	 * @generated
	 * @ordered
	 */
	protected String ePackageName = EPACKAGE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEFactory() <em>EFactory</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEFactory()
	 * @generated
	 * @ordered
	 */
	protected EFactory eFactory;

	/**
	 * The default value of the '{@link #getTenses() <em>Tenses</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTenses()
	 * @generated
	 * @ordered
	 */
	protected static final Tenses TENSES_EDEFAULT = Tenses.BOTH;

	/**
	 * The cached value of the '{@link #getTenses() <em>Tenses</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTenses()
	 * @generated
	 * @ordered
	 */
	protected Tenses tenses = TENSES_EDEFAULT;

	/**
	 * The default value of the '{@link #getPastTense() <em>Past Tense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPastTense()
	 * @generated
	 * @ordered
	 */
	protected static final String PAST_TENSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPastTense() <em>Past Tense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPastTense()
	 * @generated
	 * @ordered
	 */
	protected String pastTense = PAST_TENSE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPluralPastTense() <em>Plural Past Tense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPluralPastTense()
	 * @generated
	 * @ordered
	 */
	protected static final String PLURAL_PAST_TENSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPluralPastTense() <em>Plural Past Tense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPluralPastTense()
	 * @generated
	 * @ordered
	 */
	protected String pluralPastTense = PLURAL_PAST_TENSE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPresentTense() <em>Present Tense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresentTense()
	 * @generated
	 * @ordered
	 */
	protected static final String PRESENT_TENSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPresentTense() <em>Present Tense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresentTense()
	 * @generated
	 * @ordered
	 */
	protected String presentTense = PRESENT_TENSE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPluralPresentTense() <em>Plural Present Tense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPluralPresentTense()
	 * @generated
	 * @ordered
	 */
	protected static final String PLURAL_PRESENT_TENSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPluralPresentTense() <em>Plural Present Tense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPluralPresentTense()
	 * @generated
	 * @ordered
	 */
	protected String pluralPresentTense = PLURAL_PRESENT_TENSE_EDEFAULT;

	/**
	 * The default value of the '{@link #getImperativeTense() <em>Imperative Tense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImperativeTense()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPERATIVE_TENSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImperativeTense() <em>Imperative Tense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImperativeTense()
	 * @generated
	 * @ordered
	 */
	protected String imperativeTense = IMPERATIVE_TENSE_EDEFAULT;

	/**
	 * The default value of the '{@link #getNsPrefix() <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String NS_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNsPrefix() <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected String nsPrefix = NS_PREFIX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResolvedSubjectTypes() <em>Resolved Subject Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolvedSubjectTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetType> resolvedSubjectTypes;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final ActionTypeStatus STATUS_EDEFAULT = ActionTypeStatus.UNRESOLVED;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected ActionTypeStatus status = STATUS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSubjectTypes() <em>Subject Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubjectTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetTypeRef> subjectTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchemaPackage.Literals.ACTION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.ACTION_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override @JsonIgnore
	public Bundle getBundle() {
		return bundle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBundle(Bundle newBundle) {
		Bundle oldBundle = bundle;
		bundle = newBundle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.ACTION_TYPE__BUNDLE, oldBundle, bundle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceType getResourceType() {
		return resourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourceType(ResourceType newResourceType) {
		ResourceType oldResourceType = resourceType;
		resourceType = newResourceType == null ? RESOURCE_TYPE_EDEFAULT : newResourceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.ACTION_TYPE__RESOURCE_TYPE, oldResourceType, resourceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getResourceUri() {
		return resourceUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourceUri(String newResourceUri) {
		String oldResourceUri = resourceUri;
		resourceUri = newResourceUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.ACTION_TYPE__RESOURCE_URI, oldResourceUri, resourceUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourceName(String newResourceName) {
		String oldResourceName = resourceName;
		resourceName = newResourceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.ACTION_TYPE__RESOURCE_NAME, oldResourceName, resourceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getJavaClassName() {
		return javaClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setJavaClassName(String newJavaClassName) {
		String oldJavaClassName = javaClassName;
		javaClassName = newJavaClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.ACTION_TYPE__JAVA_CLASS_NAME, oldJavaClassName, javaClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override @JsonIgnore
	public Class<Action> getJavaClass() {
		return javaClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setJavaClass(Class<Action> newJavaClass) {
		Class<Action> oldJavaClass = javaClass;
		javaClass = newJavaClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.ACTION_TYPE__JAVA_CLASS, oldJavaClass, javaClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JavaClassStatus getJavaClassStatus() {
		return javaClassStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setJavaClassStatus(JavaClassStatus newJavaClassStatus) {
		JavaClassStatus oldJavaClassStatus = javaClassStatus;
		javaClassStatus = newJavaClassStatus == null ? JAVA_CLASS_STATUS_EDEFAULT : newJavaClassStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.ACTION_TYPE__JAVA_CLASS_STATUS, oldJavaClassStatus, javaClassStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override @JsonIgnore
	public EClass getEClass() {
		if (eClass != null && eClass.eIsProxy()) {
			InternalEObject oldEClass = (InternalEObject)eClass;
			eClass = (EClass)eResolveProxy(oldEClass);
			if (eClass != oldEClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchemaPackage.ACTION_TYPE__ECLASS, oldEClass, eClass));
			}
		}
		return eClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetEClass() {
		return eClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEClass(EClass newEClass) {
		EClass oldEClass = eClass;
		eClass = newEClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.ACTION_TYPE__ECLASS, oldEClass, eClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClassStatus getEClassStatus() {
		return eClassStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEClassStatus(EClassStatus newEClassStatus) {
		EClassStatus oldEClassStatus = eClassStatus;
		eClassStatus = newEClassStatus == null ? ECLASS_STATUS_EDEFAULT : newEClassStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.ACTION_TYPE__ECLASS_STATUS, oldEClassStatus, eClassStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEPackageNsPrefix() {
		return ePackageNsPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEPackageNsPrefix(String newEPackageNsPrefix) {
		String oldEPackageNsPrefix = ePackageNsPrefix;
		ePackageNsPrefix = newEPackageNsPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.ACTION_TYPE__EPACKAGE_NS_PREFIX, oldEPackageNsPrefix, ePackageNsPrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEClassName() {
		return eClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEClassName(String newEClassName) {
		String oldEClassName = eClassName;
		eClassName = newEClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.ACTION_TYPE__ECLASS_NAME, oldEClassName, eClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEPackageName() {
		return ePackageName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEPackageName(String newEPackageName) {
		String oldEPackageName = ePackageName;
		ePackageName = newEPackageName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.ACTION_TYPE__EPACKAGE_NAME, oldEPackageName, ePackageName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TargetTypeRef> getSubjectTypes() {
		if (subjectTypes == null) {
			subjectTypes = new EObjectContainmentEList<TargetTypeRef>(TargetTypeRef.class, this, SchemaPackage.ACTION_TYPE__SUBJECT_TYPES);
		}
		return subjectTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ActionTypeStatus getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStatus(ActionTypeStatus newStatus) {
		ActionTypeStatus oldStatus = status;
		status = newStatus == null ? STATUS_EDEFAULT : newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.ACTION_TYPE__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tenses getTenses() {
		return tenses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTenses(Tenses newTenses) {
		Tenses oldTenses = tenses;
		tenses = newTenses == null ? TENSES_EDEFAULT : newTenses;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.ACTION_TYPE__TENSES, oldTenses, tenses));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPastTense() {
		return pastTense;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPastTense(String newPastTense) {
		String oldPastTense = pastTense;
		pastTense = newPastTense;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.ACTION_TYPE__PAST_TENSE, oldPastTense, pastTense));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPluralPastTense() {
		return pluralPastTense;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPluralPastTense(String newPluralPastTense) {
		String oldPluralPastTense = pluralPastTense;
		pluralPastTense = newPluralPastTense;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.ACTION_TYPE__PLURAL_PAST_TENSE, oldPluralPastTense, pluralPastTense));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPresentTense() {
		return presentTense;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPresentTense(String newPresentTense) {
		String oldPresentTense = presentTense;
		presentTense = newPresentTense;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.ACTION_TYPE__PRESENT_TENSE, oldPresentTense, presentTense));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPluralPresentTense() {
		return pluralPresentTense;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPluralPresentTense(String newPluralPresentTense) {
		String oldPluralPresentTense = pluralPresentTense;
		pluralPresentTense = newPluralPresentTense;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.ACTION_TYPE__PLURAL_PRESENT_TENSE, oldPluralPresentTense, pluralPresentTense));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getImperativeTense() {
		return imperativeTense;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImperativeTense(String newImperativeTense) {
		String oldImperativeTense = imperativeTense;
		imperativeTense = newImperativeTense;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.ACTION_TYPE__IMPERATIVE_TENSE, oldImperativeTense, imperativeTense));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNsPrefix() {
		return nsPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNsPrefix(String newNsPrefix) {
		String oldNsPrefix = nsPrefix;
		nsPrefix = newNsPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.ACTION_TYPE__NS_PREFIX, oldNsPrefix, nsPrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TargetType> getResolvedSubjectTypes() {
		if (resolvedSubjectTypes == null) {
			resolvedSubjectTypes = new EObjectResolvingEList<TargetType>(TargetType.class, this, SchemaPackage.ACTION_TYPE__RESOLVED_SUBJECT_TYPES);
		}
		return resolvedSubjectTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override @JsonIgnore
	public EFactory getEFactory() {
		if (eFactory != null && eFactory.eIsProxy()) {
			InternalEObject oldEFactory = (InternalEObject)eFactory;
			eFactory = (EFactory)eResolveProxy(oldEFactory);
			if (eFactory != oldEFactory) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchemaPackage.ACTION_TYPE__EFACTORY, oldEFactory, eFactory));
			}
		}
		return eFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EFactory basicGetEFactory() {
		return eFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEFactory(EFactory newEFactory) {
		EFactory oldEFactory = eFactory;
		eFactory = newEFactory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.ACTION_TYPE__EFACTORY, oldEFactory, eFactory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public Action create() {
		Preconditions.checkNotNull(getEFactory(), "Cannot create Action %s because eFactory is null", getName());
		final Action action = (Action) getEFactory().create(getEClass());
		action.setActionType(this);
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void resolveEClass(Map<String, EClass> eClassMap) {
		EClassLinked.Trait.resolveEClass(this, eClassMap);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void resolveJavaClass(Bundle bundle) {
		JavaClassLinked.Trait.resolveJavaClass(this, bundle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchemaPackage.ACTION_TYPE__SUBJECT_TYPES:
				return ((InternalEList<?>)getSubjectTypes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchemaPackage.ACTION_TYPE__NAME:
				return getName();
			case SchemaPackage.ACTION_TYPE__BUNDLE:
				return getBundle();
			case SchemaPackage.ACTION_TYPE__RESOURCE_TYPE:
				return getResourceType();
			case SchemaPackage.ACTION_TYPE__RESOURCE_URI:
				return getResourceUri();
			case SchemaPackage.ACTION_TYPE__RESOURCE_NAME:
				return getResourceName();
			case SchemaPackage.ACTION_TYPE__JAVA_CLASS_NAME:
				return getJavaClassName();
			case SchemaPackage.ACTION_TYPE__JAVA_CLASS:
				return getJavaClass();
			case SchemaPackage.ACTION_TYPE__JAVA_CLASS_STATUS:
				return getJavaClassStatus();
			case SchemaPackage.ACTION_TYPE__ECLASS:
				if (resolve) return getEClass();
				return basicGetEClass();
			case SchemaPackage.ACTION_TYPE__ECLASS_STATUS:
				return getEClassStatus();
			case SchemaPackage.ACTION_TYPE__EPACKAGE_NS_PREFIX:
				return getEPackageNsPrefix();
			case SchemaPackage.ACTION_TYPE__ECLASS_NAME:
				return getEClassName();
			case SchemaPackage.ACTION_TYPE__EPACKAGE_NAME:
				return getEPackageName();
			case SchemaPackage.ACTION_TYPE__EFACTORY:
				if (resolve) return getEFactory();
				return basicGetEFactory();
			case SchemaPackage.ACTION_TYPE__TENSES:
				return getTenses();
			case SchemaPackage.ACTION_TYPE__PAST_TENSE:
				return getPastTense();
			case SchemaPackage.ACTION_TYPE__PLURAL_PAST_TENSE:
				return getPluralPastTense();
			case SchemaPackage.ACTION_TYPE__PRESENT_TENSE:
				return getPresentTense();
			case SchemaPackage.ACTION_TYPE__PLURAL_PRESENT_TENSE:
				return getPluralPresentTense();
			case SchemaPackage.ACTION_TYPE__IMPERATIVE_TENSE:
				return getImperativeTense();
			case SchemaPackage.ACTION_TYPE__NS_PREFIX:
				return getNsPrefix();
			case SchemaPackage.ACTION_TYPE__RESOLVED_SUBJECT_TYPES:
				return getResolvedSubjectTypes();
			case SchemaPackage.ACTION_TYPE__STATUS:
				return getStatus();
			case SchemaPackage.ACTION_TYPE__SUBJECT_TYPES:
				return getSubjectTypes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SchemaPackage.ACTION_TYPE__NAME:
				setName((String)newValue);
				return;
			case SchemaPackage.ACTION_TYPE__BUNDLE:
				setBundle((Bundle)newValue);
				return;
			case SchemaPackage.ACTION_TYPE__RESOURCE_TYPE:
				setResourceType((ResourceType)newValue);
				return;
			case SchemaPackage.ACTION_TYPE__RESOURCE_URI:
				setResourceUri((String)newValue);
				return;
			case SchemaPackage.ACTION_TYPE__RESOURCE_NAME:
				setResourceName((String)newValue);
				return;
			case SchemaPackage.ACTION_TYPE__JAVA_CLASS_NAME:
				setJavaClassName((String)newValue);
				return;
			case SchemaPackage.ACTION_TYPE__JAVA_CLASS:
				setJavaClass((Class<Action>)newValue);
				return;
			case SchemaPackage.ACTION_TYPE__JAVA_CLASS_STATUS:
				setJavaClassStatus((JavaClassStatus)newValue);
				return;
			case SchemaPackage.ACTION_TYPE__ECLASS:
				setEClass((EClass)newValue);
				return;
			case SchemaPackage.ACTION_TYPE__ECLASS_STATUS:
				setEClassStatus((EClassStatus)newValue);
				return;
			case SchemaPackage.ACTION_TYPE__EPACKAGE_NS_PREFIX:
				setEPackageNsPrefix((String)newValue);
				return;
			case SchemaPackage.ACTION_TYPE__ECLASS_NAME:
				setEClassName((String)newValue);
				return;
			case SchemaPackage.ACTION_TYPE__EPACKAGE_NAME:
				setEPackageName((String)newValue);
				return;
			case SchemaPackage.ACTION_TYPE__EFACTORY:
				setEFactory((EFactory)newValue);
				return;
			case SchemaPackage.ACTION_TYPE__TENSES:
				setTenses((Tenses)newValue);
				return;
			case SchemaPackage.ACTION_TYPE__PAST_TENSE:
				setPastTense((String)newValue);
				return;
			case SchemaPackage.ACTION_TYPE__PLURAL_PAST_TENSE:
				setPluralPastTense((String)newValue);
				return;
			case SchemaPackage.ACTION_TYPE__PRESENT_TENSE:
				setPresentTense((String)newValue);
				return;
			case SchemaPackage.ACTION_TYPE__PLURAL_PRESENT_TENSE:
				setPluralPresentTense((String)newValue);
				return;
			case SchemaPackage.ACTION_TYPE__IMPERATIVE_TENSE:
				setImperativeTense((String)newValue);
				return;
			case SchemaPackage.ACTION_TYPE__NS_PREFIX:
				setNsPrefix((String)newValue);
				return;
			case SchemaPackage.ACTION_TYPE__RESOLVED_SUBJECT_TYPES:
				getResolvedSubjectTypes().clear();
				getResolvedSubjectTypes().addAll((Collection<? extends TargetType>)newValue);
				return;
			case SchemaPackage.ACTION_TYPE__STATUS:
				setStatus((ActionTypeStatus)newValue);
				return;
			case SchemaPackage.ACTION_TYPE__SUBJECT_TYPES:
				getSubjectTypes().clear();
				getSubjectTypes().addAll((Collection<? extends TargetTypeRef>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SchemaPackage.ACTION_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SchemaPackage.ACTION_TYPE__BUNDLE:
				setBundle(BUNDLE_EDEFAULT);
				return;
			case SchemaPackage.ACTION_TYPE__RESOURCE_TYPE:
				setResourceType(RESOURCE_TYPE_EDEFAULT);
				return;
			case SchemaPackage.ACTION_TYPE__RESOURCE_URI:
				setResourceUri(RESOURCE_URI_EDEFAULT);
				return;
			case SchemaPackage.ACTION_TYPE__RESOURCE_NAME:
				setResourceName(RESOURCE_NAME_EDEFAULT);
				return;
			case SchemaPackage.ACTION_TYPE__JAVA_CLASS_NAME:
				setJavaClassName(JAVA_CLASS_NAME_EDEFAULT);
				return;
			case SchemaPackage.ACTION_TYPE__JAVA_CLASS:
				setJavaClass((Class<Action>)null);
				return;
			case SchemaPackage.ACTION_TYPE__JAVA_CLASS_STATUS:
				setJavaClassStatus(JAVA_CLASS_STATUS_EDEFAULT);
				return;
			case SchemaPackage.ACTION_TYPE__ECLASS:
				setEClass((EClass)null);
				return;
			case SchemaPackage.ACTION_TYPE__ECLASS_STATUS:
				setEClassStatus(ECLASS_STATUS_EDEFAULT);
				return;
			case SchemaPackage.ACTION_TYPE__EPACKAGE_NS_PREFIX:
				setEPackageNsPrefix(EPACKAGE_NS_PREFIX_EDEFAULT);
				return;
			case SchemaPackage.ACTION_TYPE__ECLASS_NAME:
				setEClassName(ECLASS_NAME_EDEFAULT);
				return;
			case SchemaPackage.ACTION_TYPE__EPACKAGE_NAME:
				setEPackageName(EPACKAGE_NAME_EDEFAULT);
				return;
			case SchemaPackage.ACTION_TYPE__EFACTORY:
				setEFactory((EFactory)null);
				return;
			case SchemaPackage.ACTION_TYPE__TENSES:
				setTenses(TENSES_EDEFAULT);
				return;
			case SchemaPackage.ACTION_TYPE__PAST_TENSE:
				setPastTense(PAST_TENSE_EDEFAULT);
				return;
			case SchemaPackage.ACTION_TYPE__PLURAL_PAST_TENSE:
				setPluralPastTense(PLURAL_PAST_TENSE_EDEFAULT);
				return;
			case SchemaPackage.ACTION_TYPE__PRESENT_TENSE:
				setPresentTense(PRESENT_TENSE_EDEFAULT);
				return;
			case SchemaPackage.ACTION_TYPE__PLURAL_PRESENT_TENSE:
				setPluralPresentTense(PLURAL_PRESENT_TENSE_EDEFAULT);
				return;
			case SchemaPackage.ACTION_TYPE__IMPERATIVE_TENSE:
				setImperativeTense(IMPERATIVE_TENSE_EDEFAULT);
				return;
			case SchemaPackage.ACTION_TYPE__NS_PREFIX:
				setNsPrefix(NS_PREFIX_EDEFAULT);
				return;
			case SchemaPackage.ACTION_TYPE__RESOLVED_SUBJECT_TYPES:
				getResolvedSubjectTypes().clear();
				return;
			case SchemaPackage.ACTION_TYPE__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case SchemaPackage.ACTION_TYPE__SUBJECT_TYPES:
				getSubjectTypes().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SchemaPackage.ACTION_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SchemaPackage.ACTION_TYPE__BUNDLE:
				return BUNDLE_EDEFAULT == null ? bundle != null : !BUNDLE_EDEFAULT.equals(bundle);
			case SchemaPackage.ACTION_TYPE__RESOURCE_TYPE:
				return resourceType != RESOURCE_TYPE_EDEFAULT;
			case SchemaPackage.ACTION_TYPE__RESOURCE_URI:
				return RESOURCE_URI_EDEFAULT == null ? resourceUri != null : !RESOURCE_URI_EDEFAULT.equals(resourceUri);
			case SchemaPackage.ACTION_TYPE__RESOURCE_NAME:
				return RESOURCE_NAME_EDEFAULT == null ? resourceName != null : !RESOURCE_NAME_EDEFAULT.equals(resourceName);
			case SchemaPackage.ACTION_TYPE__JAVA_CLASS_NAME:
				return JAVA_CLASS_NAME_EDEFAULT == null ? javaClassName != null : !JAVA_CLASS_NAME_EDEFAULT.equals(javaClassName);
			case SchemaPackage.ACTION_TYPE__JAVA_CLASS:
				return javaClass != null;
			case SchemaPackage.ACTION_TYPE__JAVA_CLASS_STATUS:
				return javaClassStatus != JAVA_CLASS_STATUS_EDEFAULT;
			case SchemaPackage.ACTION_TYPE__ECLASS:
				return eClass != null;
			case SchemaPackage.ACTION_TYPE__ECLASS_STATUS:
				return eClassStatus != ECLASS_STATUS_EDEFAULT;
			case SchemaPackage.ACTION_TYPE__EPACKAGE_NS_PREFIX:
				return EPACKAGE_NS_PREFIX_EDEFAULT == null ? ePackageNsPrefix != null : !EPACKAGE_NS_PREFIX_EDEFAULT.equals(ePackageNsPrefix);
			case SchemaPackage.ACTION_TYPE__ECLASS_NAME:
				return ECLASS_NAME_EDEFAULT == null ? eClassName != null : !ECLASS_NAME_EDEFAULT.equals(eClassName);
			case SchemaPackage.ACTION_TYPE__EPACKAGE_NAME:
				return EPACKAGE_NAME_EDEFAULT == null ? ePackageName != null : !EPACKAGE_NAME_EDEFAULT.equals(ePackageName);
			case SchemaPackage.ACTION_TYPE__EFACTORY:
				return eFactory != null;
			case SchemaPackage.ACTION_TYPE__TENSES:
				return tenses != TENSES_EDEFAULT;
			case SchemaPackage.ACTION_TYPE__PAST_TENSE:
				return PAST_TENSE_EDEFAULT == null ? pastTense != null : !PAST_TENSE_EDEFAULT.equals(pastTense);
			case SchemaPackage.ACTION_TYPE__PLURAL_PAST_TENSE:
				return PLURAL_PAST_TENSE_EDEFAULT == null ? pluralPastTense != null : !PLURAL_PAST_TENSE_EDEFAULT.equals(pluralPastTense);
			case SchemaPackage.ACTION_TYPE__PRESENT_TENSE:
				return PRESENT_TENSE_EDEFAULT == null ? presentTense != null : !PRESENT_TENSE_EDEFAULT.equals(presentTense);
			case SchemaPackage.ACTION_TYPE__PLURAL_PRESENT_TENSE:
				return PLURAL_PRESENT_TENSE_EDEFAULT == null ? pluralPresentTense != null : !PLURAL_PRESENT_TENSE_EDEFAULT.equals(pluralPresentTense);
			case SchemaPackage.ACTION_TYPE__IMPERATIVE_TENSE:
				return IMPERATIVE_TENSE_EDEFAULT == null ? imperativeTense != null : !IMPERATIVE_TENSE_EDEFAULT.equals(imperativeTense);
			case SchemaPackage.ACTION_TYPE__NS_PREFIX:
				return NS_PREFIX_EDEFAULT == null ? nsPrefix != null : !NS_PREFIX_EDEFAULT.equals(nsPrefix);
			case SchemaPackage.ACTION_TYPE__RESOLVED_SUBJECT_TYPES:
				return resolvedSubjectTypes != null && !resolvedSubjectTypes.isEmpty();
			case SchemaPackage.ACTION_TYPE__STATUS:
				return status != STATUS_EDEFAULT;
			case SchemaPackage.ACTION_TYPE__SUBJECT_TYPES:
				return subjectTypes != null && !subjectTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == BundleAware.class) {
			switch (derivedFeatureID) {
				case SchemaPackage.ACTION_TYPE__BUNDLE: return CommonsPackage.BUNDLE_AWARE__BUNDLE;
				default: return -1;
			}
		}
		if (baseClass == ResourceAware.class) {
			switch (derivedFeatureID) {
				case SchemaPackage.ACTION_TYPE__RESOURCE_TYPE: return CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE;
				case SchemaPackage.ACTION_TYPE__RESOURCE_URI: return CommonsPackage.RESOURCE_AWARE__RESOURCE_URI;
				case SchemaPackage.ACTION_TYPE__RESOURCE_NAME: return CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME;
				default: return -1;
			}
		}
		if (baseClass == JavaClassLinked.class) {
			switch (derivedFeatureID) {
				case SchemaPackage.ACTION_TYPE__JAVA_CLASS_NAME: return CommonsPackage.JAVA_CLASS_LINKED__JAVA_CLASS_NAME;
				case SchemaPackage.ACTION_TYPE__JAVA_CLASS: return CommonsPackage.JAVA_CLASS_LINKED__JAVA_CLASS;
				case SchemaPackage.ACTION_TYPE__JAVA_CLASS_STATUS: return CommonsPackage.JAVA_CLASS_LINKED__JAVA_CLASS_STATUS;
				default: return -1;
			}
		}
		if (baseClass == EClassLinked.class) {
			switch (derivedFeatureID) {
				case SchemaPackage.ACTION_TYPE__ECLASS: return CommonsPackage.ECLASS_LINKED__ECLASS;
				case SchemaPackage.ACTION_TYPE__ECLASS_STATUS: return CommonsPackage.ECLASS_LINKED__ECLASS_STATUS;
				case SchemaPackage.ACTION_TYPE__EPACKAGE_NS_PREFIX: return CommonsPackage.ECLASS_LINKED__EPACKAGE_NS_PREFIX;
				case SchemaPackage.ACTION_TYPE__ECLASS_NAME: return CommonsPackage.ECLASS_LINKED__ECLASS_NAME;
				case SchemaPackage.ACTION_TYPE__EPACKAGE_NAME: return CommonsPackage.ECLASS_LINKED__EPACKAGE_NAME;
				default: return -1;
			}
		}
		if (baseClass == EFactoryLinked.class) {
			switch (derivedFeatureID) {
				case SchemaPackage.ACTION_TYPE__EFACTORY: return CommonsPackage.EFACTORY_LINKED__EFACTORY;
				default: return -1;
			}
		}
		if (baseClass == ActionLike.class) {
			switch (derivedFeatureID) {
				case SchemaPackage.ACTION_TYPE__TENSES: return SchemaPackage.ACTION_LIKE__TENSES;
				case SchemaPackage.ACTION_TYPE__PAST_TENSE: return SchemaPackage.ACTION_LIKE__PAST_TENSE;
				case SchemaPackage.ACTION_TYPE__PLURAL_PAST_TENSE: return SchemaPackage.ACTION_LIKE__PLURAL_PAST_TENSE;
				case SchemaPackage.ACTION_TYPE__PRESENT_TENSE: return SchemaPackage.ACTION_LIKE__PRESENT_TENSE;
				case SchemaPackage.ACTION_TYPE__PLURAL_PRESENT_TENSE: return SchemaPackage.ACTION_LIKE__PLURAL_PRESENT_TENSE;
				case SchemaPackage.ACTION_TYPE__IMPERATIVE_TENSE: return SchemaPackage.ACTION_LIKE__IMPERATIVE_TENSE;
				default: return -1;
			}
		}
		if (baseClass == NsPrefixable.class) {
			switch (derivedFeatureID) {
				case SchemaPackage.ACTION_TYPE__NS_PREFIX: return CommonsPackage.NS_PREFIXABLE__NS_PREFIX;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == BundleAware.class) {
			switch (baseFeatureID) {
				case CommonsPackage.BUNDLE_AWARE__BUNDLE: return SchemaPackage.ACTION_TYPE__BUNDLE;
				default: return -1;
			}
		}
		if (baseClass == ResourceAware.class) {
			switch (baseFeatureID) {
				case CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE: return SchemaPackage.ACTION_TYPE__RESOURCE_TYPE;
				case CommonsPackage.RESOURCE_AWARE__RESOURCE_URI: return SchemaPackage.ACTION_TYPE__RESOURCE_URI;
				case CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME: return SchemaPackage.ACTION_TYPE__RESOURCE_NAME;
				default: return -1;
			}
		}
		if (baseClass == JavaClassLinked.class) {
			switch (baseFeatureID) {
				case CommonsPackage.JAVA_CLASS_LINKED__JAVA_CLASS_NAME: return SchemaPackage.ACTION_TYPE__JAVA_CLASS_NAME;
				case CommonsPackage.JAVA_CLASS_LINKED__JAVA_CLASS: return SchemaPackage.ACTION_TYPE__JAVA_CLASS;
				case CommonsPackage.JAVA_CLASS_LINKED__JAVA_CLASS_STATUS: return SchemaPackage.ACTION_TYPE__JAVA_CLASS_STATUS;
				default: return -1;
			}
		}
		if (baseClass == EClassLinked.class) {
			switch (baseFeatureID) {
				case CommonsPackage.ECLASS_LINKED__ECLASS: return SchemaPackage.ACTION_TYPE__ECLASS;
				case CommonsPackage.ECLASS_LINKED__ECLASS_STATUS: return SchemaPackage.ACTION_TYPE__ECLASS_STATUS;
				case CommonsPackage.ECLASS_LINKED__EPACKAGE_NS_PREFIX: return SchemaPackage.ACTION_TYPE__EPACKAGE_NS_PREFIX;
				case CommonsPackage.ECLASS_LINKED__ECLASS_NAME: return SchemaPackage.ACTION_TYPE__ECLASS_NAME;
				case CommonsPackage.ECLASS_LINKED__EPACKAGE_NAME: return SchemaPackage.ACTION_TYPE__EPACKAGE_NAME;
				default: return -1;
			}
		}
		if (baseClass == EFactoryLinked.class) {
			switch (baseFeatureID) {
				case CommonsPackage.EFACTORY_LINKED__EFACTORY: return SchemaPackage.ACTION_TYPE__EFACTORY;
				default: return -1;
			}
		}
		if (baseClass == ActionLike.class) {
			switch (baseFeatureID) {
				case SchemaPackage.ACTION_LIKE__TENSES: return SchemaPackage.ACTION_TYPE__TENSES;
				case SchemaPackage.ACTION_LIKE__PAST_TENSE: return SchemaPackage.ACTION_TYPE__PAST_TENSE;
				case SchemaPackage.ACTION_LIKE__PLURAL_PAST_TENSE: return SchemaPackage.ACTION_TYPE__PLURAL_PAST_TENSE;
				case SchemaPackage.ACTION_LIKE__PRESENT_TENSE: return SchemaPackage.ACTION_TYPE__PRESENT_TENSE;
				case SchemaPackage.ACTION_LIKE__PLURAL_PRESENT_TENSE: return SchemaPackage.ACTION_TYPE__PLURAL_PRESENT_TENSE;
				case SchemaPackage.ACTION_LIKE__IMPERATIVE_TENSE: return SchemaPackage.ACTION_TYPE__IMPERATIVE_TENSE;
				default: return -1;
			}
		}
		if (baseClass == NsPrefixable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.NS_PREFIXABLE__NS_PREFIX: return SchemaPackage.ACTION_TYPE__NS_PREFIX;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", bundle: ");
		result.append(bundle);
		result.append(", resourceType: ");
		result.append(resourceType);
		result.append(", resourceUri: ");
		result.append(resourceUri);
		result.append(", resourceName: ");
		result.append(resourceName);
		result.append(", javaClassName: ");
		result.append(javaClassName);
		result.append(", javaClass: ");
		result.append(javaClass);
		result.append(", javaClassStatus: ");
		result.append(javaClassStatus);
		result.append(", eClassStatus: ");
		result.append(eClassStatus);
		result.append(", ePackageNsPrefix: ");
		result.append(ePackageNsPrefix);
		result.append(", eClassName: ");
		result.append(eClassName);
		result.append(", ePackageName: ");
		result.append(ePackageName);
		result.append(", tenses: ");
		result.append(tenses);
		result.append(", pastTense: ");
		result.append(pastTense);
		result.append(", pluralPastTense: ");
		result.append(pluralPastTense);
		result.append(", presentTense: ");
		result.append(presentTense);
		result.append(", pluralPresentTense: ");
		result.append(pluralPresentTense);
		result.append(", imperativeTense: ");
		result.append(imperativeTense);
		result.append(", nsPrefix: ");
		result.append(nsPrefix);
		result.append(", status: ");
		result.append(status);
		result.append(')');
		return result.toString();
	}
	
} //ActionTypeImpl

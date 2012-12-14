/**
 */
package org.soluvas.email.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.osgi.framework.Bundle;

import org.soluvas.commons.BundleAware;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.EClassLinked;
import org.soluvas.commons.EClassStatus;
import org.soluvas.commons.EFactoryLinked;
import org.soluvas.commons.JavaClassLinked;
import org.soluvas.commons.JavaClassStatus;
import org.soluvas.commons.NsPrefixable;

import org.soluvas.email.EmailPackage;
import org.soluvas.email.Sender;
import org.soluvas.email.SenderLike;
import org.soluvas.email.SenderType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sender Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.email.impl.SenderTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.soluvas.email.impl.SenderTypeImpl#getBundle <em>Bundle</em>}</li>
 *   <li>{@link org.soluvas.email.impl.SenderTypeImpl#getNsPrefix <em>Ns Prefix</em>}</li>
 *   <li>{@link org.soluvas.email.impl.SenderTypeImpl#getEClass <em>EClass</em>}</li>
 *   <li>{@link org.soluvas.email.impl.SenderTypeImpl#getEClassStatus <em>EClass Status</em>}</li>
 *   <li>{@link org.soluvas.email.impl.SenderTypeImpl#getEPackageNsPrefix <em>EPackage Ns Prefix</em>}</li>
 *   <li>{@link org.soluvas.email.impl.SenderTypeImpl#getEClassName <em>EClass Name</em>}</li>
 *   <li>{@link org.soluvas.email.impl.SenderTypeImpl#getEPackageName <em>EPackage Name</em>}</li>
 *   <li>{@link org.soluvas.email.impl.SenderTypeImpl#getJavaClassName <em>Java Class Name</em>}</li>
 *   <li>{@link org.soluvas.email.impl.SenderTypeImpl#getJavaClass <em>Java Class</em>}</li>
 *   <li>{@link org.soluvas.email.impl.SenderTypeImpl#getJavaClassStatus <em>Java Class Status</em>}</li>
 *   <li>{@link org.soluvas.email.impl.SenderTypeImpl#getEFactory <em>EFactory</em>}</li>
 *   <li>{@link org.soluvas.email.impl.SenderTypeImpl#getFrom <em>From</em>}</li>
 *   <li>{@link org.soluvas.email.impl.SenderTypeImpl#getEmail <em>Email</em>}</li>
 *   <li>{@link org.soluvas.email.impl.SenderTypeImpl#getReplyTo <em>Reply To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SenderTypeImpl extends EObjectImpl implements SenderType {
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
	protected Class<Sender> javaClass;

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
	 * The cached value of the '{@link #getEFactory() <em>EFactory</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEFactory()
	 * @generated
	 * @ordered
	 */
	protected EFactory eFactory;

	/**
	 * The default value of the '{@link #getFrom() <em>From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected static final String FROM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFrom() <em>From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected String from = FROM_EDEFAULT;

	/**
	 * The default value of the '{@link #getEmail() <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmail()
	 * @generated
	 * @ordered
	 */
	protected static final String EMAIL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEmail() <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmail()
	 * @generated
	 * @ordered
	 */
	protected String email = EMAIL_EDEFAULT;

	/**
	 * The default value of the '{@link #getReplyTo() <em>Reply To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplyTo()
	 * @generated
	 * @ordered
	 */
	protected static final String REPLY_TO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReplyTo() <em>Reply To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplyTo()
	 * @generated
	 * @ordered
	 */
	protected String replyTo = REPLY_TO_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SenderTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmailPackage.Literals.SENDER_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.SENDER_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bundle getBundle() {
		return bundle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBundle(Bundle newBundle) {
		Bundle oldBundle = bundle;
		bundle = newBundle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.SENDER_TYPE__BUNDLE, oldBundle, bundle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNsPrefix() {
		return nsPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNsPrefix(String newNsPrefix) {
		String oldNsPrefix = nsPrefix;
		nsPrefix = newNsPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.SENDER_TYPE__NS_PREFIX, oldNsPrefix, nsPrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEClass() {
		if (eClass != null && eClass.eIsProxy()) {
			InternalEObject oldEClass = (InternalEObject)eClass;
			eClass = (EClass)eResolveProxy(oldEClass);
			if (eClass != oldEClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmailPackage.SENDER_TYPE__ECLASS, oldEClass, eClass));
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
	public void setEClass(EClass newEClass) {
		EClass oldEClass = eClass;
		eClass = newEClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.SENDER_TYPE__ECLASS, oldEClass, eClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassStatus getEClassStatus() {
		return eClassStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEClassStatus(EClassStatus newEClassStatus) {
		EClassStatus oldEClassStatus = eClassStatus;
		eClassStatus = newEClassStatus == null ? ECLASS_STATUS_EDEFAULT : newEClassStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.SENDER_TYPE__ECLASS_STATUS, oldEClassStatus, eClassStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEPackageNsPrefix() {
		return ePackageNsPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEPackageNsPrefix(String newEPackageNsPrefix) {
		String oldEPackageNsPrefix = ePackageNsPrefix;
		ePackageNsPrefix = newEPackageNsPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.SENDER_TYPE__EPACKAGE_NS_PREFIX, oldEPackageNsPrefix, ePackageNsPrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEClassName() {
		return eClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEClassName(String newEClassName) {
		String oldEClassName = eClassName;
		eClassName = newEClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.SENDER_TYPE__ECLASS_NAME, oldEClassName, eClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEPackageName() {
		return ePackageName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEPackageName(String newEPackageName) {
		String oldEPackageName = ePackageName;
		ePackageName = newEPackageName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.SENDER_TYPE__EPACKAGE_NAME, oldEPackageName, ePackageName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getJavaClassName() {
		return javaClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJavaClassName(String newJavaClassName) {
		String oldJavaClassName = javaClassName;
		javaClassName = newJavaClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.SENDER_TYPE__JAVA_CLASS_NAME, oldJavaClassName, javaClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Class<Sender> getJavaClass() {
		return javaClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJavaClass(Class<Sender> newJavaClass) {
		Class<Sender> oldJavaClass = javaClass;
		javaClass = newJavaClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.SENDER_TYPE__JAVA_CLASS, oldJavaClass, javaClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaClassStatus getJavaClassStatus() {
		return javaClassStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJavaClassStatus(JavaClassStatus newJavaClassStatus) {
		JavaClassStatus oldJavaClassStatus = javaClassStatus;
		javaClassStatus = newJavaClassStatus == null ? JAVA_CLASS_STATUS_EDEFAULT : newJavaClassStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.SENDER_TYPE__JAVA_CLASS_STATUS, oldJavaClassStatus, javaClassStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EFactory getEFactory() {
		if (eFactory != null && eFactory.eIsProxy()) {
			InternalEObject oldEFactory = (InternalEObject)eFactory;
			eFactory = (EFactory)eResolveProxy(oldEFactory);
			if (eFactory != oldEFactory) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmailPackage.SENDER_TYPE__EFACTORY, oldEFactory, eFactory));
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
	public void setEFactory(EFactory newEFactory) {
		EFactory oldEFactory = eFactory;
		eFactory = newEFactory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.SENDER_TYPE__EFACTORY, oldEFactory, eFactory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrom(String newFrom) {
		String oldFrom = from;
		from = newFrom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.SENDER_TYPE__FROM, oldFrom, from));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmail(String newEmail) {
		String oldEmail = email;
		email = newEmail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.SENDER_TYPE__EMAIL, oldEmail, email));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReplyTo() {
		return replyTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReplyTo(String newReplyTo) {
		String oldReplyTo = replyTo;
		replyTo = newReplyTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.SENDER_TYPE__REPLY_TO, oldReplyTo, replyTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void resolveJavaClass(Bundle bundle) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void resolveEClass(Map<String, EClass> eClassMap) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmailPackage.SENDER_TYPE__NAME:
				return getName();
			case EmailPackage.SENDER_TYPE__BUNDLE:
				return getBundle();
			case EmailPackage.SENDER_TYPE__NS_PREFIX:
				return getNsPrefix();
			case EmailPackage.SENDER_TYPE__ECLASS:
				if (resolve) return getEClass();
				return basicGetEClass();
			case EmailPackage.SENDER_TYPE__ECLASS_STATUS:
				return getEClassStatus();
			case EmailPackage.SENDER_TYPE__EPACKAGE_NS_PREFIX:
				return getEPackageNsPrefix();
			case EmailPackage.SENDER_TYPE__ECLASS_NAME:
				return getEClassName();
			case EmailPackage.SENDER_TYPE__EPACKAGE_NAME:
				return getEPackageName();
			case EmailPackage.SENDER_TYPE__JAVA_CLASS_NAME:
				return getJavaClassName();
			case EmailPackage.SENDER_TYPE__JAVA_CLASS:
				return getJavaClass();
			case EmailPackage.SENDER_TYPE__JAVA_CLASS_STATUS:
				return getJavaClassStatus();
			case EmailPackage.SENDER_TYPE__EFACTORY:
				if (resolve) return getEFactory();
				return basicGetEFactory();
			case EmailPackage.SENDER_TYPE__FROM:
				return getFrom();
			case EmailPackage.SENDER_TYPE__EMAIL:
				return getEmail();
			case EmailPackage.SENDER_TYPE__REPLY_TO:
				return getReplyTo();
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
			case EmailPackage.SENDER_TYPE__NAME:
				setName((String)newValue);
				return;
			case EmailPackage.SENDER_TYPE__BUNDLE:
				setBundle((Bundle)newValue);
				return;
			case EmailPackage.SENDER_TYPE__NS_PREFIX:
				setNsPrefix((String)newValue);
				return;
			case EmailPackage.SENDER_TYPE__ECLASS:
				setEClass((EClass)newValue);
				return;
			case EmailPackage.SENDER_TYPE__ECLASS_STATUS:
				setEClassStatus((EClassStatus)newValue);
				return;
			case EmailPackage.SENDER_TYPE__EPACKAGE_NS_PREFIX:
				setEPackageNsPrefix((String)newValue);
				return;
			case EmailPackage.SENDER_TYPE__ECLASS_NAME:
				setEClassName((String)newValue);
				return;
			case EmailPackage.SENDER_TYPE__EPACKAGE_NAME:
				setEPackageName((String)newValue);
				return;
			case EmailPackage.SENDER_TYPE__JAVA_CLASS_NAME:
				setJavaClassName((String)newValue);
				return;
			case EmailPackage.SENDER_TYPE__JAVA_CLASS:
				setJavaClass((Class<Sender>)newValue);
				return;
			case EmailPackage.SENDER_TYPE__JAVA_CLASS_STATUS:
				setJavaClassStatus((JavaClassStatus)newValue);
				return;
			case EmailPackage.SENDER_TYPE__EFACTORY:
				setEFactory((EFactory)newValue);
				return;
			case EmailPackage.SENDER_TYPE__FROM:
				setFrom((String)newValue);
				return;
			case EmailPackage.SENDER_TYPE__EMAIL:
				setEmail((String)newValue);
				return;
			case EmailPackage.SENDER_TYPE__REPLY_TO:
				setReplyTo((String)newValue);
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
			case EmailPackage.SENDER_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EmailPackage.SENDER_TYPE__BUNDLE:
				setBundle(BUNDLE_EDEFAULT);
				return;
			case EmailPackage.SENDER_TYPE__NS_PREFIX:
				setNsPrefix(NS_PREFIX_EDEFAULT);
				return;
			case EmailPackage.SENDER_TYPE__ECLASS:
				setEClass((EClass)null);
				return;
			case EmailPackage.SENDER_TYPE__ECLASS_STATUS:
				setEClassStatus(ECLASS_STATUS_EDEFAULT);
				return;
			case EmailPackage.SENDER_TYPE__EPACKAGE_NS_PREFIX:
				setEPackageNsPrefix(EPACKAGE_NS_PREFIX_EDEFAULT);
				return;
			case EmailPackage.SENDER_TYPE__ECLASS_NAME:
				setEClassName(ECLASS_NAME_EDEFAULT);
				return;
			case EmailPackage.SENDER_TYPE__EPACKAGE_NAME:
				setEPackageName(EPACKAGE_NAME_EDEFAULT);
				return;
			case EmailPackage.SENDER_TYPE__JAVA_CLASS_NAME:
				setJavaClassName(JAVA_CLASS_NAME_EDEFAULT);
				return;
			case EmailPackage.SENDER_TYPE__JAVA_CLASS:
				setJavaClass((Class<Sender>)null);
				return;
			case EmailPackage.SENDER_TYPE__JAVA_CLASS_STATUS:
				setJavaClassStatus(JAVA_CLASS_STATUS_EDEFAULT);
				return;
			case EmailPackage.SENDER_TYPE__EFACTORY:
				setEFactory((EFactory)null);
				return;
			case EmailPackage.SENDER_TYPE__FROM:
				setFrom(FROM_EDEFAULT);
				return;
			case EmailPackage.SENDER_TYPE__EMAIL:
				setEmail(EMAIL_EDEFAULT);
				return;
			case EmailPackage.SENDER_TYPE__REPLY_TO:
				setReplyTo(REPLY_TO_EDEFAULT);
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
			case EmailPackage.SENDER_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EmailPackage.SENDER_TYPE__BUNDLE:
				return BUNDLE_EDEFAULT == null ? bundle != null : !BUNDLE_EDEFAULT.equals(bundle);
			case EmailPackage.SENDER_TYPE__NS_PREFIX:
				return NS_PREFIX_EDEFAULT == null ? nsPrefix != null : !NS_PREFIX_EDEFAULT.equals(nsPrefix);
			case EmailPackage.SENDER_TYPE__ECLASS:
				return eClass != null;
			case EmailPackage.SENDER_TYPE__ECLASS_STATUS:
				return eClassStatus != ECLASS_STATUS_EDEFAULT;
			case EmailPackage.SENDER_TYPE__EPACKAGE_NS_PREFIX:
				return EPACKAGE_NS_PREFIX_EDEFAULT == null ? ePackageNsPrefix != null : !EPACKAGE_NS_PREFIX_EDEFAULT.equals(ePackageNsPrefix);
			case EmailPackage.SENDER_TYPE__ECLASS_NAME:
				return ECLASS_NAME_EDEFAULT == null ? eClassName != null : !ECLASS_NAME_EDEFAULT.equals(eClassName);
			case EmailPackage.SENDER_TYPE__EPACKAGE_NAME:
				return EPACKAGE_NAME_EDEFAULT == null ? ePackageName != null : !EPACKAGE_NAME_EDEFAULT.equals(ePackageName);
			case EmailPackage.SENDER_TYPE__JAVA_CLASS_NAME:
				return JAVA_CLASS_NAME_EDEFAULT == null ? javaClassName != null : !JAVA_CLASS_NAME_EDEFAULT.equals(javaClassName);
			case EmailPackage.SENDER_TYPE__JAVA_CLASS:
				return javaClass != null;
			case EmailPackage.SENDER_TYPE__JAVA_CLASS_STATUS:
				return javaClassStatus != JAVA_CLASS_STATUS_EDEFAULT;
			case EmailPackage.SENDER_TYPE__EFACTORY:
				return eFactory != null;
			case EmailPackage.SENDER_TYPE__FROM:
				return FROM_EDEFAULT == null ? from != null : !FROM_EDEFAULT.equals(from);
			case EmailPackage.SENDER_TYPE__EMAIL:
				return EMAIL_EDEFAULT == null ? email != null : !EMAIL_EDEFAULT.equals(email);
			case EmailPackage.SENDER_TYPE__REPLY_TO:
				return REPLY_TO_EDEFAULT == null ? replyTo != null : !REPLY_TO_EDEFAULT.equals(replyTo);
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
				case EmailPackage.SENDER_TYPE__BUNDLE: return CommonsPackage.BUNDLE_AWARE__BUNDLE;
				default: return -1;
			}
		}
		if (baseClass == NsPrefixable.class) {
			switch (derivedFeatureID) {
				case EmailPackage.SENDER_TYPE__NS_PREFIX: return CommonsPackage.NS_PREFIXABLE__NS_PREFIX;
				default: return -1;
			}
		}
		if (baseClass == EClassLinked.class) {
			switch (derivedFeatureID) {
				case EmailPackage.SENDER_TYPE__ECLASS: return CommonsPackage.ECLASS_LINKED__ECLASS;
				case EmailPackage.SENDER_TYPE__ECLASS_STATUS: return CommonsPackage.ECLASS_LINKED__ECLASS_STATUS;
				case EmailPackage.SENDER_TYPE__EPACKAGE_NS_PREFIX: return CommonsPackage.ECLASS_LINKED__EPACKAGE_NS_PREFIX;
				case EmailPackage.SENDER_TYPE__ECLASS_NAME: return CommonsPackage.ECLASS_LINKED__ECLASS_NAME;
				case EmailPackage.SENDER_TYPE__EPACKAGE_NAME: return CommonsPackage.ECLASS_LINKED__EPACKAGE_NAME;
				default: return -1;
			}
		}
		if (baseClass == JavaClassLinked.class) {
			switch (derivedFeatureID) {
				case EmailPackage.SENDER_TYPE__JAVA_CLASS_NAME: return CommonsPackage.JAVA_CLASS_LINKED__JAVA_CLASS_NAME;
				case EmailPackage.SENDER_TYPE__JAVA_CLASS: return CommonsPackage.JAVA_CLASS_LINKED__JAVA_CLASS;
				case EmailPackage.SENDER_TYPE__JAVA_CLASS_STATUS: return CommonsPackage.JAVA_CLASS_LINKED__JAVA_CLASS_STATUS;
				default: return -1;
			}
		}
		if (baseClass == EFactoryLinked.class) {
			switch (derivedFeatureID) {
				case EmailPackage.SENDER_TYPE__EFACTORY: return CommonsPackage.EFACTORY_LINKED__EFACTORY;
				default: return -1;
			}
		}
		if (baseClass == SenderLike.class) {
			switch (derivedFeatureID) {
				case EmailPackage.SENDER_TYPE__FROM: return EmailPackage.SENDER_LIKE__FROM;
				case EmailPackage.SENDER_TYPE__EMAIL: return EmailPackage.SENDER_LIKE__EMAIL;
				case EmailPackage.SENDER_TYPE__REPLY_TO: return EmailPackage.SENDER_LIKE__REPLY_TO;
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
				case CommonsPackage.BUNDLE_AWARE__BUNDLE: return EmailPackage.SENDER_TYPE__BUNDLE;
				default: return -1;
			}
		}
		if (baseClass == NsPrefixable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.NS_PREFIXABLE__NS_PREFIX: return EmailPackage.SENDER_TYPE__NS_PREFIX;
				default: return -1;
			}
		}
		if (baseClass == EClassLinked.class) {
			switch (baseFeatureID) {
				case CommonsPackage.ECLASS_LINKED__ECLASS: return EmailPackage.SENDER_TYPE__ECLASS;
				case CommonsPackage.ECLASS_LINKED__ECLASS_STATUS: return EmailPackage.SENDER_TYPE__ECLASS_STATUS;
				case CommonsPackage.ECLASS_LINKED__EPACKAGE_NS_PREFIX: return EmailPackage.SENDER_TYPE__EPACKAGE_NS_PREFIX;
				case CommonsPackage.ECLASS_LINKED__ECLASS_NAME: return EmailPackage.SENDER_TYPE__ECLASS_NAME;
				case CommonsPackage.ECLASS_LINKED__EPACKAGE_NAME: return EmailPackage.SENDER_TYPE__EPACKAGE_NAME;
				default: return -1;
			}
		}
		if (baseClass == JavaClassLinked.class) {
			switch (baseFeatureID) {
				case CommonsPackage.JAVA_CLASS_LINKED__JAVA_CLASS_NAME: return EmailPackage.SENDER_TYPE__JAVA_CLASS_NAME;
				case CommonsPackage.JAVA_CLASS_LINKED__JAVA_CLASS: return EmailPackage.SENDER_TYPE__JAVA_CLASS;
				case CommonsPackage.JAVA_CLASS_LINKED__JAVA_CLASS_STATUS: return EmailPackage.SENDER_TYPE__JAVA_CLASS_STATUS;
				default: return -1;
			}
		}
		if (baseClass == EFactoryLinked.class) {
			switch (baseFeatureID) {
				case CommonsPackage.EFACTORY_LINKED__EFACTORY: return EmailPackage.SENDER_TYPE__EFACTORY;
				default: return -1;
			}
		}
		if (baseClass == SenderLike.class) {
			switch (baseFeatureID) {
				case EmailPackage.SENDER_LIKE__FROM: return EmailPackage.SENDER_TYPE__FROM;
				case EmailPackage.SENDER_LIKE__EMAIL: return EmailPackage.SENDER_TYPE__EMAIL;
				case EmailPackage.SENDER_LIKE__REPLY_TO: return EmailPackage.SENDER_TYPE__REPLY_TO;
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
		result.append(", nsPrefix: ");
		result.append(nsPrefix);
		result.append(", eClassStatus: ");
		result.append(eClassStatus);
		result.append(", ePackageNsPrefix: ");
		result.append(ePackageNsPrefix);
		result.append(", eClassName: ");
		result.append(eClassName);
		result.append(", ePackageName: ");
		result.append(ePackageName);
		result.append(", javaClassName: ");
		result.append(javaClassName);
		result.append(", javaClass: ");
		result.append(javaClass);
		result.append(", javaClassStatus: ");
		result.append(javaClassStatus);
		result.append(", from: ");
		result.append(from);
		result.append(", email: ");
		result.append(email);
		result.append(", replyTo: ");
		result.append(replyTo);
		result.append(')');
		return result.toString();
	}

} //SenderTypeImpl

/**
 */
package org.soluvas.security.impl;

import java.util.Collection;
import java.util.List;
import java.util.Locale;

import org.apache.shiro.session.Session;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.PersonInfo;
import org.soluvas.commons.SchemaVersionable;
import org.soluvas.commons.Timestamped;
import org.soluvas.commons.mongo.BigDecimalConverter;
import org.soluvas.commons.mongo.CurrencyUnitConverter;
import org.soluvas.commons.mongo.DateTimeConverter;
import org.soluvas.commons.mongo.UnitConverter;
import org.soluvas.security.AppSession;
import org.soluvas.security.AppSessionStatus;
import org.soluvas.security.SecurityPackage;

import com.google.code.morphia.annotations.Converters;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>App Session</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.security.impl.AppSessionImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.soluvas.security.impl.AppSessionImpl#getCreationTime <em>Creation Time</em>}</li>
 *   <li>{@link org.soluvas.security.impl.AppSessionImpl#getModificationTime <em>Modification Time</em>}</li>
 *   <li>{@link org.soluvas.security.impl.AppSessionImpl#getPerson <em>Person</em>}</li>
 *   <li>{@link org.soluvas.security.impl.AppSessionImpl#getSchemaVersion <em>Schema Version</em>}</li>
 *   <li>{@link org.soluvas.security.impl.AppSessionImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.soluvas.security.impl.AppSessionImpl#getIpAddress <em>Ip Address</em>}</li>
 *   <li>{@link org.soluvas.security.impl.AppSessionImpl#getIpv6Address <em>Ipv6 Address</em>}</li>
 *   <li>{@link org.soluvas.security.impl.AppSessionImpl#getIpAddresses <em>Ip Addresses</em>}</li>
 *   <li>{@link org.soluvas.security.impl.AppSessionImpl#getIpv6Addresses <em>Ipv6 Addresses</em>}</li>
 *   <li>{@link org.soluvas.security.impl.AppSessionImpl#getUserAgent <em>User Agent</em>}</li>
 *   <li>{@link org.soluvas.security.impl.AppSessionImpl#getUserAgents <em>User Agents</em>}</li>
 *   <li>{@link org.soluvas.security.impl.AppSessionImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.soluvas.security.impl.AppSessionImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link org.soluvas.security.impl.AppSessionImpl#getAccessTime <em>Access Time</em>}</li>
 *   <li>{@link org.soluvas.security.impl.AppSessionImpl#getExpiryTime <em>Expiry Time</em>}</li>
 *   <li>{@link org.soluvas.security.impl.AppSessionImpl#getTimeZone <em>Time Zone</em>}</li>
 *   <li>{@link org.soluvas.security.impl.AppSessionImpl#getLocale <em>Locale</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@Entity
@Converters({BigDecimalConverter.class, DateTimeConverter.class,
	CurrencyUnitConverter.class, UnitConverter.class})
public class AppSessionImpl extends EObjectImpl implements AppSession {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	@Id
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreationTime() <em>Creation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationTime()
	 * @generated
	 * @ordered
	 */
	protected static final DateTime CREATION_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreationTime() <em>Creation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationTime()
	 * @generated
	 * @ordered
	 */
	protected DateTime creationTime = CREATION_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getModificationTime() <em>Modification Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModificationTime()
	 * @generated
	 * @ordered
	 */
	protected static final DateTime MODIFICATION_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModificationTime() <em>Modification Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModificationTime()
	 * @generated
	 * @ordered
	 */
	protected DateTime modificationTime = MODIFICATION_TIME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPerson() <em>Person</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPerson()
	 * @generated
	 * @ordered
	 */
	protected PersonInfo person;

	/**
	 * The default value of the '{@link #getSchemaVersion() <em>Schema Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchemaVersion()
	 * @generated
	 * @ordered
	 */
	protected static final long SCHEMA_VERSION_EDEFAULT = 2L;

	/**
	 * The cached value of the '{@link #getSchemaVersion() <em>Schema Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchemaVersion()
	 * @generated
	 * @ordered
	 */
	protected long schemaVersion = SCHEMA_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final AppSessionStatus STATUS_EDEFAULT = AppSessionStatus.ACTIVE;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected AppSessionStatus status = STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getIpAddress() <em>Ip Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIpAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String IP_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIpAddress() <em>Ip Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIpAddress()
	 * @generated
	 * @ordered
	 */
	protected String ipAddress = IP_ADDRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getIpv6Address() <em>Ipv6 Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIpv6Address()
	 * @generated
	 * @ordered
	 */
	protected static final String IPV6_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIpv6Address() <em>Ipv6 Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIpv6Address()
	 * @generated
	 * @ordered
	 */
	protected String ipv6Address = IPV6_ADDRESS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIpAddresses() <em>Ip Addresses</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIpAddresses()
	 * @generated
	 * @ordered
	 */
	protected EList<String> ipAddresses;

	/**
	 * The cached value of the '{@link #getIpv6Addresses() <em>Ipv6 Addresses</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIpv6Addresses()
	 * @generated
	 * @ordered
	 */
	protected EList<String> ipv6Addresses;

	/**
	 * The default value of the '{@link #getUserAgent() <em>User Agent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserAgent()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_AGENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserAgent() <em>User Agent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserAgent()
	 * @generated
	 * @ordered
	 */
	protected String userAgent = USER_AGENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUserAgents() <em>User Agents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserAgents()
	 * @generated
	 * @ordered
	 */
	protected List<String> userAgents;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @ordered
	 */
//	@Transient
	protected EMap<String, Object> attributes;

	/**
	 * The default value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final Long TIMEOUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
	protected Long timeout = TIMEOUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getAccessTime() <em>Access Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessTime()
	 * @generated
	 * @ordered
	 */
	protected static final DateTime ACCESS_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAccessTime() <em>Access Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessTime()
	 * @generated
	 * @ordered
	 */
	protected DateTime accessTime = ACCESS_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getExpiryTime() <em>Expiry Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpiryTime()
	 * @generated
	 * @ordered
	 */
	protected static final DateTime EXPIRY_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExpiryTime() <em>Expiry Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpiryTime()
	 * @generated
	 * @ordered
	 */
	protected DateTime expiryTime = EXPIRY_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimeZone() <em>Time Zone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeZone()
	 * @generated
	 * @ordered
	 */
	protected static final DateTimeZone TIME_ZONE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTimeZone() <em>Time Zone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeZone()
	 * @generated
	 * @ordered
	 */
	protected DateTimeZone timeZone = TIME_ZONE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLocale() <em>Locale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocale()
	 * @generated
	 * @ordered
	 */
	protected static final Locale LOCALE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocale() <em>Locale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocale()
	 * @generated
	 * @ordered
	 */
	protected Locale locale = LOCALE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppSessionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SecurityPackage.Literals.APP_SESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityPackage.APP_SESSION__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DateTime getCreationTime() {
		return creationTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCreationTime(DateTime newCreationTime) {
		DateTime oldCreationTime = creationTime;
		creationTime = newCreationTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityPackage.APP_SESSION__CREATION_TIME, oldCreationTime, creationTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DateTime getModificationTime() {
		return modificationTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModificationTime(DateTime newModificationTime) {
		DateTime oldModificationTime = modificationTime;
		modificationTime = newModificationTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityPackage.APP_SESSION__MODIFICATION_TIME, oldModificationTime, modificationTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PersonInfo getPerson() {
		if (person != null && ((EObject)person).eIsProxy()) {
			InternalEObject oldPerson = (InternalEObject)person;
			person = (PersonInfo)eResolveProxy(oldPerson);
			if (person != oldPerson) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SecurityPackage.APP_SESSION__PERSON, oldPerson, person));
			}
		}
		return person;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PersonInfo basicGetPerson() {
		return person;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPerson(PersonInfo newPerson) {
		PersonInfo oldPerson = person;
		person = newPerson;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityPackage.APP_SESSION__PERSON, oldPerson, person));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getSchemaVersion() {
		return schemaVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSchemaVersion(long newSchemaVersion) {
		long oldSchemaVersion = schemaVersion;
		schemaVersion = newSchemaVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityPackage.APP_SESSION__SCHEMA_VERSION, oldSchemaVersion, schemaVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AppSessionStatus getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStatus(AppSessionStatus newStatus) {
		AppSessionStatus oldStatus = status;
		status = newStatus == null ? STATUS_EDEFAULT : newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityPackage.APP_SESSION__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIpAddress(String newIpAddress) {
		String oldIpAddress = ipAddress;
		ipAddress = newIpAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityPackage.APP_SESSION__IP_ADDRESS, oldIpAddress, ipAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getIpv6Address() {
		return ipv6Address;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIpv6Address(String newIpv6Address) {
		String oldIpv6Address = ipv6Address;
		ipv6Address = newIpv6Address;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityPackage.APP_SESSION__IPV6_ADDRESS, oldIpv6Address, ipv6Address));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getIpAddresses() {
		if (ipAddresses == null) {
			ipAddresses = new EDataTypeUniqueEList<String>(String.class, this, SecurityPackage.APP_SESSION__IP_ADDRESSES);
		}
		return ipAddresses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getIpv6Addresses() {
		if (ipv6Addresses == null) {
			ipv6Addresses = new EDataTypeUniqueEList<String>(String.class, this, SecurityPackage.APP_SESSION__IPV6_ADDRESSES);
		}
		return ipv6Addresses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUserAgent() {
		return userAgent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUserAgent(String newUserAgent) {
		String oldUserAgent = userAgent;
		userAgent = newUserAgent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityPackage.APP_SESSION__USER_AGENT, oldUserAgent, userAgent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<String> getUserAgents() {
		return userAgents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUserAgents(List<String> newUserAgents) {
		List<String> oldUserAgents = userAgents;
		userAgents = newUserAgents;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityPackage.APP_SESSION__USER_AGENTS, oldUserAgents, userAgents));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, Object> getAttributes() {
		if (attributes == null) {
			attributes = new EcoreEMap<String,Object>(SecurityPackage.Literals.APP_SESSION_ATTRIBUTE_ENTRY, AppSessionAttributeEntryImpl.class, this, SecurityPackage.APP_SESSION__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getTimeout() {
		return timeout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTimeout(Long newTimeout) {
		Long oldTimeout = timeout;
		timeout = newTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityPackage.APP_SESSION__TIMEOUT, oldTimeout, timeout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DateTime getAccessTime() {
		return accessTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAccessTime(DateTime newAccessTime) {
		DateTime oldAccessTime = accessTime;
		accessTime = newAccessTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityPackage.APP_SESSION__ACCESS_TIME, oldAccessTime, accessTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DateTime getExpiryTime() {
		return expiryTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExpiryTime(DateTime newExpiryTime) {
		DateTime oldExpiryTime = expiryTime;
		expiryTime = newExpiryTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityPackage.APP_SESSION__EXPIRY_TIME, oldExpiryTime, expiryTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DateTimeZone getTimeZone() {
		return timeZone;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTimeZone(DateTimeZone newTimeZone) {
		DateTimeZone oldTimeZone = timeZone;
		timeZone = newTimeZone;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityPackage.APP_SESSION__TIME_ZONE, oldTimeZone, timeZone));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Locale getLocale() {
		return locale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLocale(Locale newLocale) {
		Locale oldLocale = locale;
		locale = newLocale;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityPackage.APP_SESSION__LOCALE, oldLocale, locale));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public Session toSession() {
		return new ToSession().apply(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SecurityPackage.APP_SESSION__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
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
			case SecurityPackage.APP_SESSION__ID:
				return getId();
			case SecurityPackage.APP_SESSION__CREATION_TIME:
				return getCreationTime();
			case SecurityPackage.APP_SESSION__MODIFICATION_TIME:
				return getModificationTime();
			case SecurityPackage.APP_SESSION__PERSON:
				if (resolve) return getPerson();
				return basicGetPerson();
			case SecurityPackage.APP_SESSION__SCHEMA_VERSION:
				return getSchemaVersion();
			case SecurityPackage.APP_SESSION__STATUS:
				return getStatus();
			case SecurityPackage.APP_SESSION__IP_ADDRESS:
				return getIpAddress();
			case SecurityPackage.APP_SESSION__IPV6_ADDRESS:
				return getIpv6Address();
			case SecurityPackage.APP_SESSION__IP_ADDRESSES:
				return getIpAddresses();
			case SecurityPackage.APP_SESSION__IPV6_ADDRESSES:
				return getIpv6Addresses();
			case SecurityPackage.APP_SESSION__USER_AGENT:
				return getUserAgent();
			case SecurityPackage.APP_SESSION__USER_AGENTS:
				return getUserAgents();
			case SecurityPackage.APP_SESSION__ATTRIBUTES:
				if (coreType) return getAttributes();
				else return getAttributes().map();
			case SecurityPackage.APP_SESSION__TIMEOUT:
				return getTimeout();
			case SecurityPackage.APP_SESSION__ACCESS_TIME:
				return getAccessTime();
			case SecurityPackage.APP_SESSION__EXPIRY_TIME:
				return getExpiryTime();
			case SecurityPackage.APP_SESSION__TIME_ZONE:
				return getTimeZone();
			case SecurityPackage.APP_SESSION__LOCALE:
				return getLocale();
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
			case SecurityPackage.APP_SESSION__ID:
				setId((String)newValue);
				return;
			case SecurityPackage.APP_SESSION__CREATION_TIME:
				setCreationTime((DateTime)newValue);
				return;
			case SecurityPackage.APP_SESSION__MODIFICATION_TIME:
				setModificationTime((DateTime)newValue);
				return;
			case SecurityPackage.APP_SESSION__PERSON:
				setPerson((PersonInfo)newValue);
				return;
			case SecurityPackage.APP_SESSION__SCHEMA_VERSION:
				setSchemaVersion((Long)newValue);
				return;
			case SecurityPackage.APP_SESSION__STATUS:
				setStatus((AppSessionStatus)newValue);
				return;
			case SecurityPackage.APP_SESSION__IP_ADDRESS:
				setIpAddress((String)newValue);
				return;
			case SecurityPackage.APP_SESSION__IPV6_ADDRESS:
				setIpv6Address((String)newValue);
				return;
			case SecurityPackage.APP_SESSION__IP_ADDRESSES:
				getIpAddresses().clear();
				getIpAddresses().addAll((Collection<? extends String>)newValue);
				return;
			case SecurityPackage.APP_SESSION__IPV6_ADDRESSES:
				getIpv6Addresses().clear();
				getIpv6Addresses().addAll((Collection<? extends String>)newValue);
				return;
			case SecurityPackage.APP_SESSION__USER_AGENT:
				setUserAgent((String)newValue);
				return;
			case SecurityPackage.APP_SESSION__USER_AGENTS:
				setUserAgents((List<String>)newValue);
				return;
			case SecurityPackage.APP_SESSION__ATTRIBUTES:
				((EStructuralFeature.Setting)getAttributes()).set(newValue);
				return;
			case SecurityPackage.APP_SESSION__TIMEOUT:
				setTimeout((Long)newValue);
				return;
			case SecurityPackage.APP_SESSION__ACCESS_TIME:
				setAccessTime((DateTime)newValue);
				return;
			case SecurityPackage.APP_SESSION__EXPIRY_TIME:
				setExpiryTime((DateTime)newValue);
				return;
			case SecurityPackage.APP_SESSION__TIME_ZONE:
				setTimeZone((DateTimeZone)newValue);
				return;
			case SecurityPackage.APP_SESSION__LOCALE:
				setLocale((Locale)newValue);
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
			case SecurityPackage.APP_SESSION__ID:
				setId(ID_EDEFAULT);
				return;
			case SecurityPackage.APP_SESSION__CREATION_TIME:
				setCreationTime(CREATION_TIME_EDEFAULT);
				return;
			case SecurityPackage.APP_SESSION__MODIFICATION_TIME:
				setModificationTime(MODIFICATION_TIME_EDEFAULT);
				return;
			case SecurityPackage.APP_SESSION__PERSON:
				setPerson((PersonInfo)null);
				return;
			case SecurityPackage.APP_SESSION__SCHEMA_VERSION:
				setSchemaVersion(SCHEMA_VERSION_EDEFAULT);
				return;
			case SecurityPackage.APP_SESSION__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case SecurityPackage.APP_SESSION__IP_ADDRESS:
				setIpAddress(IP_ADDRESS_EDEFAULT);
				return;
			case SecurityPackage.APP_SESSION__IPV6_ADDRESS:
				setIpv6Address(IPV6_ADDRESS_EDEFAULT);
				return;
			case SecurityPackage.APP_SESSION__IP_ADDRESSES:
				getIpAddresses().clear();
				return;
			case SecurityPackage.APP_SESSION__IPV6_ADDRESSES:
				getIpv6Addresses().clear();
				return;
			case SecurityPackage.APP_SESSION__USER_AGENT:
				setUserAgent(USER_AGENT_EDEFAULT);
				return;
			case SecurityPackage.APP_SESSION__USER_AGENTS:
				setUserAgents((List<String>)null);
				return;
			case SecurityPackage.APP_SESSION__ATTRIBUTES:
				getAttributes().clear();
				return;
			case SecurityPackage.APP_SESSION__TIMEOUT:
				setTimeout(TIMEOUT_EDEFAULT);
				return;
			case SecurityPackage.APP_SESSION__ACCESS_TIME:
				setAccessTime(ACCESS_TIME_EDEFAULT);
				return;
			case SecurityPackage.APP_SESSION__EXPIRY_TIME:
				setExpiryTime(EXPIRY_TIME_EDEFAULT);
				return;
			case SecurityPackage.APP_SESSION__TIME_ZONE:
				setTimeZone(TIME_ZONE_EDEFAULT);
				return;
			case SecurityPackage.APP_SESSION__LOCALE:
				setLocale(LOCALE_EDEFAULT);
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
			case SecurityPackage.APP_SESSION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SecurityPackage.APP_SESSION__CREATION_TIME:
				return CREATION_TIME_EDEFAULT == null ? creationTime != null : !CREATION_TIME_EDEFAULT.equals(creationTime);
			case SecurityPackage.APP_SESSION__MODIFICATION_TIME:
				return MODIFICATION_TIME_EDEFAULT == null ? modificationTime != null : !MODIFICATION_TIME_EDEFAULT.equals(modificationTime);
			case SecurityPackage.APP_SESSION__PERSON:
				return person != null;
			case SecurityPackage.APP_SESSION__SCHEMA_VERSION:
				return schemaVersion != SCHEMA_VERSION_EDEFAULT;
			case SecurityPackage.APP_SESSION__STATUS:
				return status != STATUS_EDEFAULT;
			case SecurityPackage.APP_SESSION__IP_ADDRESS:
				return IP_ADDRESS_EDEFAULT == null ? ipAddress != null : !IP_ADDRESS_EDEFAULT.equals(ipAddress);
			case SecurityPackage.APP_SESSION__IPV6_ADDRESS:
				return IPV6_ADDRESS_EDEFAULT == null ? ipv6Address != null : !IPV6_ADDRESS_EDEFAULT.equals(ipv6Address);
			case SecurityPackage.APP_SESSION__IP_ADDRESSES:
				return ipAddresses != null && !ipAddresses.isEmpty();
			case SecurityPackage.APP_SESSION__IPV6_ADDRESSES:
				return ipv6Addresses != null && !ipv6Addresses.isEmpty();
			case SecurityPackage.APP_SESSION__USER_AGENT:
				return USER_AGENT_EDEFAULT == null ? userAgent != null : !USER_AGENT_EDEFAULT.equals(userAgent);
			case SecurityPackage.APP_SESSION__USER_AGENTS:
				return userAgents != null;
			case SecurityPackage.APP_SESSION__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case SecurityPackage.APP_SESSION__TIMEOUT:
				return TIMEOUT_EDEFAULT == null ? timeout != null : !TIMEOUT_EDEFAULT.equals(timeout);
			case SecurityPackage.APP_SESSION__ACCESS_TIME:
				return ACCESS_TIME_EDEFAULT == null ? accessTime != null : !ACCESS_TIME_EDEFAULT.equals(accessTime);
			case SecurityPackage.APP_SESSION__EXPIRY_TIME:
				return EXPIRY_TIME_EDEFAULT == null ? expiryTime != null : !EXPIRY_TIME_EDEFAULT.equals(expiryTime);
			case SecurityPackage.APP_SESSION__TIME_ZONE:
				return TIME_ZONE_EDEFAULT == null ? timeZone != null : !TIME_ZONE_EDEFAULT.equals(timeZone);
			case SecurityPackage.APP_SESSION__LOCALE:
				return LOCALE_EDEFAULT == null ? locale != null : !LOCALE_EDEFAULT.equals(locale);
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
		if (baseClass == Timestamped.class) {
			switch (derivedFeatureID) {
				case SecurityPackage.APP_SESSION__CREATION_TIME: return CommonsPackage.TIMESTAMPED__CREATION_TIME;
				case SecurityPackage.APP_SESSION__MODIFICATION_TIME: return CommonsPackage.TIMESTAMPED__MODIFICATION_TIME;
				default: return -1;
			}
		}
		if (baseClass == SchemaVersionable.class) {
			switch (derivedFeatureID) {
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
		if (baseClass == Timestamped.class) {
			switch (baseFeatureID) {
				case CommonsPackage.TIMESTAMPED__CREATION_TIME: return SecurityPackage.APP_SESSION__CREATION_TIME;
				case CommonsPackage.TIMESTAMPED__MODIFICATION_TIME: return SecurityPackage.APP_SESSION__MODIFICATION_TIME;
				default: return -1;
			}
		}
		if (baseClass == SchemaVersionable.class) {
			switch (baseFeatureID) {
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
		result.append(" (id: ");
		result.append(id);
		result.append(", creationTime: ");
		result.append(creationTime);
		result.append(", modificationTime: ");
		result.append(modificationTime);
		result.append(", schemaVersion: ");
		result.append(schemaVersion);
		result.append(", status: ");
		result.append(status);
		result.append(", ipAddress: ");
		result.append(ipAddress);
		result.append(", ipv6Address: ");
		result.append(ipv6Address);
		result.append(", ipAddresses: ");
		result.append(ipAddresses);
		result.append(", ipv6Addresses: ");
		result.append(ipv6Addresses);
		result.append(", userAgent: ");
		result.append(userAgent);
		result.append(", userAgents: ");
		result.append(userAgents);
		result.append(", timeout: ");
		result.append(timeout);
		result.append(", accessTime: ");
		result.append(accessTime);
		result.append(", expiryTime: ");
		result.append(expiryTime);
		result.append(", timeZone: ");
		result.append(timeZone);
		result.append(", locale: ");
		result.append(locale);
		result.append(')');
		return result.toString();
	}

} //AppSessionImpl

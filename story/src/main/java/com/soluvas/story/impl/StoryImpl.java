/**
 */
package com.soluvas.story.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.joda.time.DateTime;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.Identifiable;
import org.soluvas.commons.SchemaVersionable;
import org.soluvas.commons.Timestamped;
import org.soluvas.commons.mongo.BigDecimalConverter;
import org.soluvas.commons.mongo.CurrencyUnitConverter;
import org.soluvas.commons.mongo.DateTimeConverter;
import org.soluvas.commons.mongo.UnitConverter;
import org.soluvas.social.Target;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.code.morphia.annotations.Converters;
import com.google.code.morphia.annotations.Id;
import com.google.common.collect.Iterables;
import com.soluvas.story.Action;
import com.soluvas.story.Story;
import com.soluvas.story.StoryPackage;
import com.soluvas.story.StoryStatus;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Story</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.soluvas.story.impl.StoryImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.soluvas.story.impl.StoryImpl#getCreationTime <em>Creation Time</em>}</li>
 *   <li>{@link com.soluvas.story.impl.StoryImpl#getModificationTime <em>Modification Time</em>}</li>
 *   <li>{@link com.soluvas.story.impl.StoryImpl#getSchemaVersion <em>Schema Version</em>}</li>
 *   <li>{@link com.soluvas.story.impl.StoryImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link com.soluvas.story.impl.StoryImpl#getAction <em>Action</em>}</li>
 *   <li>{@link com.soluvas.story.impl.StoryImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.soluvas.story.impl.StoryImpl#getSubjects <em>Subjects</em>}</li>
 *   <li>{@link com.soluvas.story.impl.StoryImpl#getReceivers <em>Receivers</em>}</li>
 *   <li>{@link com.soluvas.story.impl.StoryImpl#getAttachments <em>Attachments</em>}</li>
 *   <li>{@link com.soluvas.story.impl.StoryImpl#getSubject <em>Subject</em>}</li>
 *   <li>{@link com.soluvas.story.impl.StoryImpl#getReceiver <em>Receiver</em>}</li>
 *   <li>{@link com.soluvas.story.impl.StoryImpl#getAttachment <em>Attachment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("serial")
@Converters({BigDecimalConverter.class, DateTimeConverter.class,
	UnitConverter.class, CurrencyUnitConverter.class})
public class StoryImpl extends EObjectImpl implements Story {
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
	 * The default value of the '{@link #getSchemaVersion() <em>Schema Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchemaVersion()
	 * @generated
	 * @ordered
	 */
	protected static final long SCHEMA_VERSION_EDEFAULT = 3L;

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
	protected static final StoryStatus STATUS_EDEFAULT = StoryStatus.DRAFT;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected StoryStatus status = STATUS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected Action action;

	/**
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected Identifiable owner;

	/**
	 * The cached value of the '{@link #getSubjects() <em>Subjects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubjects()
	 * @generated
	 * @ordered
	 */
	protected EList<Target> subjects;

	/**
	 * The cached value of the '{@link #getReceivers() <em>Receivers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceivers()
	 * @generated
	 * @ordered
	 */
	protected EList<Target> receivers;

	/**
	 * The cached value of the '{@link #getAttachments() <em>Attachments</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttachments()
	 * @generated
	 * @ordered
	 */
	protected EList<Target> attachments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StoryPackage.Literals.STORY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, StoryPackage.STORY__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StoryPackage.STORY__CREATION_TIME, oldCreationTime, creationTime));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StoryPackage.STORY__MODIFICATION_TIME, oldModificationTime, modificationTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Target> getSubjects() {
		if (subjects == null) {
			subjects = new EObjectResolvingEList<Target>(Target.class, this, StoryPackage.STORY__SUBJECTS);
		}
		return subjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Target> getReceivers() {
		if (receivers == null) {
			receivers = new EObjectResolvingEList.Unsettable<Target>(Target.class, this, StoryPackage.STORY__RECEIVERS);
		}
		return receivers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetReceivers() {
		if (receivers != null) ((InternalEList.Unsettable<?>)receivers).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetReceivers() {
		return receivers != null && ((InternalEList.Unsettable<?>)receivers).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Target> getAttachments() {
		if (attachments == null) {
			attachments = new EObjectResolvingEList<Target>(Target.class, this, StoryPackage.STORY__ATTACHMENTS);
		}
		return attachments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override @JsonIgnore
	public Target getSubject() {
		Target subject = basicGetSubject();
		return subject != null && ((EObject)subject).eIsProxy() ? (Target)eResolveProxy((InternalEObject)subject) : subject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Target basicGetSubject() {
		return Iterables.getFirst(getSubjects(), null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StoryStatus getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStatus(StoryStatus newStatus) {
		StoryStatus oldStatus = status;
		status = newStatus == null ? STATUS_EDEFAULT : newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoryPackage.STORY__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Target basicGetReceiver() {
		return Iterables.getFirst(getReceivers(), null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void setReceiver(Target newReceiver) {
		getReceivers().clear();
		if (newReceiver != null)
			getReceivers().add(newReceiver);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	@JsonIgnore
	public Target getAttachment() {
		Target attachment = basicGetAttachment();
		return attachment != null && ((EObject)attachment).eIsProxy() ? (Target)eResolveProxy((InternalEObject)attachment) : attachment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Target basicGetAttachment() {
		return Iterables.getFirst(getAttachments(), null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void setAttachment(Target newAttachment) {
		getAttachments().clear();
		if (newAttachment != null)
			getAttachments().add(newAttachment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Action getAction() {
		if (action != null && action.eIsProxy()) {
			InternalEObject oldAction = (InternalEObject)action;
			action = (Action)eResolveProxy(oldAction);
			if (action != oldAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StoryPackage.STORY__ACTION, oldAction, action));
			}
		}
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action basicGetAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAction(Action newAction) {
		Action oldAction = action;
		action = newAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoryPackage.STORY__ACTION, oldAction, action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void setSubject(Target newSubject) {
		getSubjects().clear();
		if (newSubject != null) {
			getSubjects().add(newSubject);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	@JsonIgnore
	public Target getReceiver() {
		Target receiver = basicGetReceiver();
		return receiver != null && ((EObject)receiver).eIsProxy() ? (Target)eResolveProxy((InternalEObject)receiver) : receiver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Identifiable getOwner() {
		if (owner != null && owner.eIsProxy()) {
			InternalEObject oldOwner = (InternalEObject)owner;
			owner = (Identifiable)eResolveProxy(oldOwner);
			if (owner != oldOwner) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StoryPackage.STORY__OWNER, oldOwner, owner));
			}
		}
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifiable basicGetOwner() {
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwner(Identifiable newOwner) {
		Identifiable oldOwner = owner;
		owner = newOwner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoryPackage.STORY__OWNER, oldOwner, owner));
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StoryPackage.STORY__ID:
				return getId();
			case StoryPackage.STORY__CREATION_TIME:
				return getCreationTime();
			case StoryPackage.STORY__MODIFICATION_TIME:
				return getModificationTime();
			case StoryPackage.STORY__SCHEMA_VERSION:
				return getSchemaVersion();
			case StoryPackage.STORY__STATUS:
				return getStatus();
			case StoryPackage.STORY__ACTION:
				if (resolve) return getAction();
				return basicGetAction();
			case StoryPackage.STORY__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case StoryPackage.STORY__SUBJECTS:
				return getSubjects();
			case StoryPackage.STORY__RECEIVERS:
				return getReceivers();
			case StoryPackage.STORY__ATTACHMENTS:
				return getAttachments();
			case StoryPackage.STORY__SUBJECT:
				if (resolve) return getSubject();
				return basicGetSubject();
			case StoryPackage.STORY__RECEIVER:
				if (resolve) return getReceiver();
				return basicGetReceiver();
			case StoryPackage.STORY__ATTACHMENT:
				if (resolve) return getAttachment();
				return basicGetAttachment();
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
			case StoryPackage.STORY__ID:
				setId((String)newValue);
				return;
			case StoryPackage.STORY__CREATION_TIME:
				setCreationTime((DateTime)newValue);
				return;
			case StoryPackage.STORY__MODIFICATION_TIME:
				setModificationTime((DateTime)newValue);
				return;
			case StoryPackage.STORY__STATUS:
				setStatus((StoryStatus)newValue);
				return;
			case StoryPackage.STORY__ACTION:
				setAction((Action)newValue);
				return;
			case StoryPackage.STORY__OWNER:
				setOwner((Identifiable)newValue);
				return;
			case StoryPackage.STORY__SUBJECTS:
				getSubjects().clear();
				getSubjects().addAll((Collection<? extends Target>)newValue);
				return;
			case StoryPackage.STORY__RECEIVERS:
				getReceivers().clear();
				getReceivers().addAll((Collection<? extends Target>)newValue);
				return;
			case StoryPackage.STORY__ATTACHMENTS:
				getAttachments().clear();
				getAttachments().addAll((Collection<? extends Target>)newValue);
				return;
			case StoryPackage.STORY__SUBJECT:
				setSubject((Target)newValue);
				return;
			case StoryPackage.STORY__RECEIVER:
				setReceiver((Target)newValue);
				return;
			case StoryPackage.STORY__ATTACHMENT:
				setAttachment((Target)newValue);
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
			case StoryPackage.STORY__ID:
				setId(ID_EDEFAULT);
				return;
			case StoryPackage.STORY__CREATION_TIME:
				setCreationTime(CREATION_TIME_EDEFAULT);
				return;
			case StoryPackage.STORY__MODIFICATION_TIME:
				setModificationTime(MODIFICATION_TIME_EDEFAULT);
				return;
			case StoryPackage.STORY__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case StoryPackage.STORY__ACTION:
				setAction((Action)null);
				return;
			case StoryPackage.STORY__OWNER:
				setOwner((Identifiable)null);
				return;
			case StoryPackage.STORY__SUBJECTS:
				getSubjects().clear();
				return;
			case StoryPackage.STORY__RECEIVERS:
				unsetReceivers();
				return;
			case StoryPackage.STORY__ATTACHMENTS:
				getAttachments().clear();
				return;
			case StoryPackage.STORY__SUBJECT:
				setSubject((Target)null);
				return;
			case StoryPackage.STORY__RECEIVER:
				setReceiver((Target)null);
				return;
			case StoryPackage.STORY__ATTACHMENT:
				setAttachment((Target)null);
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
			case StoryPackage.STORY__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case StoryPackage.STORY__CREATION_TIME:
				return CREATION_TIME_EDEFAULT == null ? creationTime != null : !CREATION_TIME_EDEFAULT.equals(creationTime);
			case StoryPackage.STORY__MODIFICATION_TIME:
				return MODIFICATION_TIME_EDEFAULT == null ? modificationTime != null : !MODIFICATION_TIME_EDEFAULT.equals(modificationTime);
			case StoryPackage.STORY__SCHEMA_VERSION:
				return schemaVersion != SCHEMA_VERSION_EDEFAULT;
			case StoryPackage.STORY__STATUS:
				return status != STATUS_EDEFAULT;
			case StoryPackage.STORY__ACTION:
				return action != null;
			case StoryPackage.STORY__OWNER:
				return owner != null;
			case StoryPackage.STORY__SUBJECTS:
				return subjects != null && !subjects.isEmpty();
			case StoryPackage.STORY__RECEIVERS:
				return isSetReceivers();
			case StoryPackage.STORY__ATTACHMENTS:
				return attachments != null && !attachments.isEmpty();
			case StoryPackage.STORY__SUBJECT:
				return basicGetSubject() != null;
			case StoryPackage.STORY__RECEIVER:
				return basicGetReceiver() != null;
			case StoryPackage.STORY__ATTACHMENT:
				return basicGetAttachment() != null;
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
				case StoryPackage.STORY__CREATION_TIME: return CommonsPackage.TIMESTAMPED__CREATION_TIME;
				case StoryPackage.STORY__MODIFICATION_TIME: return CommonsPackage.TIMESTAMPED__MODIFICATION_TIME;
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
				case CommonsPackage.TIMESTAMPED__CREATION_TIME: return StoryPackage.STORY__CREATION_TIME;
				case CommonsPackage.TIMESTAMPED__MODIFICATION_TIME: return StoryPackage.STORY__MODIFICATION_TIME;
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
		result.append(')');
		return result.toString();
	}

} //StoryImpl

/**
 */
package com.soluvas.story.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.NsPrefixable;

import com.google.code.morphia.annotations.Transient;
import com.soluvas.story.Action;
import com.soluvas.story.StoryPackage;
import com.soluvas.story.schema.ActionLike;
import com.soluvas.story.schema.ActionType;
import com.soluvas.story.schema.SchemaPackage;
import com.soluvas.story.schema.Tenses;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.soluvas.story.impl.ActionImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.soluvas.story.impl.ActionImpl#getTenses <em>Tenses</em>}</li>
 *   <li>{@link com.soluvas.story.impl.ActionImpl#getPastTense <em>Past Tense</em>}</li>
 *   <li>{@link com.soluvas.story.impl.ActionImpl#getPluralPastTense <em>Plural Past Tense</em>}</li>
 *   <li>{@link com.soluvas.story.impl.ActionImpl#getPresentTense <em>Present Tense</em>}</li>
 *   <li>{@link com.soluvas.story.impl.ActionImpl#getPluralPresentTense <em>Plural Present Tense</em>}</li>
 *   <li>{@link com.soluvas.story.impl.ActionImpl#getImperativeTense <em>Imperative Tense</em>}</li>
 *   <li>{@link com.soluvas.story.impl.ActionImpl#getNsPrefix <em>Ns Prefix</em>}</li>
 *   <li>{@link com.soluvas.story.impl.ActionImpl#getActionType <em>Action Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ActionImpl extends EObjectImpl implements Action {
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
	 * The cached value of the '{@link #getActionType() <em>Action Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionType()
	 * @ordered
	 */
	@Transient
	protected ActionType actionType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionImpl() {
		super();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StoryPackage.Literals.ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ActionType getActionType() {
		if (actionType != null && actionType.eIsProxy()) {
			InternalEObject oldActionType = (InternalEObject)actionType;
			actionType = (ActionType)eResolveProxy(oldActionType);
			if (actionType != oldActionType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StoryPackage.ACTION__ACTION_TYPE, oldActionType, actionType));
			}
		}
		return actionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionType basicGetActionType() {
		return actionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void setActionType(ActionType newActionType) {
		ActionType oldActionType = actionType;
		actionType = newActionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoryPackage.ACTION__ACTION_TYPE, oldActionType, actionType));

		// Set name and nsPrefix based on this ActionType
		if (newActionType != null) {
			setName(newActionType.getName());
			if (newActionType.getEClass() != null)
				setNsPrefix(newActionType.getNsPrefix());
			setTenses(newActionType.getTenses());
			setPastTense(newActionType.getPastTense());
			setPluralPastTense(newActionType.getPluralPastTense());
			setPresentTense(newActionType.getPresentTense());
			setPluralPresentTense(newActionType.getPluralPresentTense());
			setImperativeTense(newActionType.getImperativeTense());
		}
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
			eNotify(new ENotificationImpl(this, Notification.SET, StoryPackage.ACTION__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StoryPackage.ACTION__TENSES, oldTenses, tenses));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StoryPackage.ACTION__PAST_TENSE, oldPastTense, pastTense));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StoryPackage.ACTION__PLURAL_PAST_TENSE, oldPluralPastTense, pluralPastTense));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StoryPackage.ACTION__PRESENT_TENSE, oldPresentTense, presentTense));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StoryPackage.ACTION__PLURAL_PRESENT_TENSE, oldPluralPresentTense, pluralPresentTense));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StoryPackage.ACTION__IMPERATIVE_TENSE, oldImperativeTense, imperativeTense));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StoryPackage.ACTION__NS_PREFIX, oldNsPrefix, nsPrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StoryPackage.ACTION__NAME:
				return getName();
			case StoryPackage.ACTION__TENSES:
				return getTenses();
			case StoryPackage.ACTION__PAST_TENSE:
				return getPastTense();
			case StoryPackage.ACTION__PLURAL_PAST_TENSE:
				return getPluralPastTense();
			case StoryPackage.ACTION__PRESENT_TENSE:
				return getPresentTense();
			case StoryPackage.ACTION__PLURAL_PRESENT_TENSE:
				return getPluralPresentTense();
			case StoryPackage.ACTION__IMPERATIVE_TENSE:
				return getImperativeTense();
			case StoryPackage.ACTION__NS_PREFIX:
				return getNsPrefix();
			case StoryPackage.ACTION__ACTION_TYPE:
				if (resolve) return getActionType();
				return basicGetActionType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StoryPackage.ACTION__NAME:
				setName((String)newValue);
				return;
			case StoryPackage.ACTION__TENSES:
				setTenses((Tenses)newValue);
				return;
			case StoryPackage.ACTION__PAST_TENSE:
				setPastTense((String)newValue);
				return;
			case StoryPackage.ACTION__PLURAL_PAST_TENSE:
				setPluralPastTense((String)newValue);
				return;
			case StoryPackage.ACTION__PRESENT_TENSE:
				setPresentTense((String)newValue);
				return;
			case StoryPackage.ACTION__PLURAL_PRESENT_TENSE:
				setPluralPresentTense((String)newValue);
				return;
			case StoryPackage.ACTION__IMPERATIVE_TENSE:
				setImperativeTense((String)newValue);
				return;
			case StoryPackage.ACTION__NS_PREFIX:
				setNsPrefix((String)newValue);
				return;
			case StoryPackage.ACTION__ACTION_TYPE:
				setActionType((ActionType)newValue);
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
			case StoryPackage.ACTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case StoryPackage.ACTION__TENSES:
				setTenses(TENSES_EDEFAULT);
				return;
			case StoryPackage.ACTION__PAST_TENSE:
				setPastTense(PAST_TENSE_EDEFAULT);
				return;
			case StoryPackage.ACTION__PLURAL_PAST_TENSE:
				setPluralPastTense(PLURAL_PAST_TENSE_EDEFAULT);
				return;
			case StoryPackage.ACTION__PRESENT_TENSE:
				setPresentTense(PRESENT_TENSE_EDEFAULT);
				return;
			case StoryPackage.ACTION__PLURAL_PRESENT_TENSE:
				setPluralPresentTense(PLURAL_PRESENT_TENSE_EDEFAULT);
				return;
			case StoryPackage.ACTION__IMPERATIVE_TENSE:
				setImperativeTense(IMPERATIVE_TENSE_EDEFAULT);
				return;
			case StoryPackage.ACTION__NS_PREFIX:
				setNsPrefix(NS_PREFIX_EDEFAULT);
				return;
			case StoryPackage.ACTION__ACTION_TYPE:
				setActionType((ActionType)null);
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
			case StoryPackage.ACTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case StoryPackage.ACTION__TENSES:
				return tenses != TENSES_EDEFAULT;
			case StoryPackage.ACTION__PAST_TENSE:
				return PAST_TENSE_EDEFAULT == null ? pastTense != null : !PAST_TENSE_EDEFAULT.equals(pastTense);
			case StoryPackage.ACTION__PLURAL_PAST_TENSE:
				return PLURAL_PAST_TENSE_EDEFAULT == null ? pluralPastTense != null : !PLURAL_PAST_TENSE_EDEFAULT.equals(pluralPastTense);
			case StoryPackage.ACTION__PRESENT_TENSE:
				return PRESENT_TENSE_EDEFAULT == null ? presentTense != null : !PRESENT_TENSE_EDEFAULT.equals(presentTense);
			case StoryPackage.ACTION__PLURAL_PRESENT_TENSE:
				return PLURAL_PRESENT_TENSE_EDEFAULT == null ? pluralPresentTense != null : !PLURAL_PRESENT_TENSE_EDEFAULT.equals(pluralPresentTense);
			case StoryPackage.ACTION__IMPERATIVE_TENSE:
				return IMPERATIVE_TENSE_EDEFAULT == null ? imperativeTense != null : !IMPERATIVE_TENSE_EDEFAULT.equals(imperativeTense);
			case StoryPackage.ACTION__NS_PREFIX:
				return NS_PREFIX_EDEFAULT == null ? nsPrefix != null : !NS_PREFIX_EDEFAULT.equals(nsPrefix);
			case StoryPackage.ACTION__ACTION_TYPE:
				return actionType != null;
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
		if (baseClass == ActionLike.class) {
			switch (derivedFeatureID) {
				case StoryPackage.ACTION__TENSES: return SchemaPackage.ACTION_LIKE__TENSES;
				case StoryPackage.ACTION__PAST_TENSE: return SchemaPackage.ACTION_LIKE__PAST_TENSE;
				case StoryPackage.ACTION__PLURAL_PAST_TENSE: return SchemaPackage.ACTION_LIKE__PLURAL_PAST_TENSE;
				case StoryPackage.ACTION__PRESENT_TENSE: return SchemaPackage.ACTION_LIKE__PRESENT_TENSE;
				case StoryPackage.ACTION__PLURAL_PRESENT_TENSE: return SchemaPackage.ACTION_LIKE__PLURAL_PRESENT_TENSE;
				case StoryPackage.ACTION__IMPERATIVE_TENSE: return SchemaPackage.ACTION_LIKE__IMPERATIVE_TENSE;
				default: return -1;
			}
		}
		if (baseClass == NsPrefixable.class) {
			switch (derivedFeatureID) {
				case StoryPackage.ACTION__NS_PREFIX: return CommonsPackage.NS_PREFIXABLE__NS_PREFIX;
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
		if (baseClass == ActionLike.class) {
			switch (baseFeatureID) {
				case SchemaPackage.ACTION_LIKE__TENSES: return StoryPackage.ACTION__TENSES;
				case SchemaPackage.ACTION_LIKE__PAST_TENSE: return StoryPackage.ACTION__PAST_TENSE;
				case SchemaPackage.ACTION_LIKE__PLURAL_PAST_TENSE: return StoryPackage.ACTION__PLURAL_PAST_TENSE;
				case SchemaPackage.ACTION_LIKE__PRESENT_TENSE: return StoryPackage.ACTION__PRESENT_TENSE;
				case SchemaPackage.ACTION_LIKE__PLURAL_PRESENT_TENSE: return StoryPackage.ACTION__PLURAL_PRESENT_TENSE;
				case SchemaPackage.ACTION_LIKE__IMPERATIVE_TENSE: return StoryPackage.ACTION__IMPERATIVE_TENSE;
				default: return -1;
			}
		}
		if (baseClass == NsPrefixable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.NS_PREFIXABLE__NS_PREFIX: return StoryPackage.ACTION__NS_PREFIX;
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
		result.append(')');
		return result.toString();
	}

} //ActionImpl

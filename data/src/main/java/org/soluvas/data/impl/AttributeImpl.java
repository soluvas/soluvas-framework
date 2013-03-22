/**
 */
package org.soluvas.data.impl;

import javax.measure.unit.Unit;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.Describable;
import org.soluvas.commons.Imageable;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.Nameable;
import org.soluvas.commons.Positionable;
import org.soluvas.data.Attribute;
import org.soluvas.data.DataPackage;
import org.soluvas.data.InputMethod;
import org.soluvas.data.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.data.impl.AttributeImpl#getNsPrefix <em>Ns Prefix</em>}</li>
 *   <li>{@link org.soluvas.data.impl.AttributeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.soluvas.data.impl.AttributeImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.soluvas.data.impl.AttributeImpl#getPositioner <em>Positioner</em>}</li>
 *   <li>{@link org.soluvas.data.impl.AttributeImpl#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link org.soluvas.data.impl.AttributeImpl#getMinValues <em>Min Values</em>}</li>
 *   <li>{@link org.soluvas.data.impl.AttributeImpl#getMaxValues <em>Max Values</em>}</li>
 *   <li>{@link org.soluvas.data.impl.AttributeImpl#getDataTypeName <em>Data Type Name</em>}</li>
 *   <li>{@link org.soluvas.data.impl.AttributeImpl#getKindNsPrefix <em>Kind Ns Prefix</em>}</li>
 *   <li>{@link org.soluvas.data.impl.AttributeImpl#getKindName <em>Kind Name</em>}</li>
 *   <li>{@link org.soluvas.data.impl.AttributeImpl#getInputMethod <em>Input Method</em>}</li>
 *   <li>{@link org.soluvas.data.impl.AttributeImpl#getInputUnitName <em>Input Unit Name</em>}</li>
 *   <li>{@link org.soluvas.data.impl.AttributeImpl#isVisibleInSimple <em>Visible In Simple</em>}</li>
 *   <li>{@link org.soluvas.data.impl.AttributeImpl#isSearchableInQuick <em>Searchable In Quick</em>}</li>
 *   <li>{@link org.soluvas.data.impl.AttributeImpl#getImageId <em>Image Id</em>}</li>
 *   <li>{@link org.soluvas.data.impl.AttributeImpl#getFieldWidth <em>Field Width</em>}</li>
 *   <li>{@link org.soluvas.data.impl.AttributeImpl#isPrincipal <em>Principal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeImpl extends EObjectImpl implements Attribute {
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
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getPositioner() <em>Positioner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPositioner()
	 * @generated
	 * @ordered
	 */
	protected static final Integer POSITIONER_EDEFAULT = new Integer(0);

	/**
	 * The cached value of the '{@link #getPositioner() <em>Positioner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPositioner()
	 * @generated
	 * @ordered
	 */
	protected Integer positioner = POSITIONER_EDEFAULT;

	/**
	 * The default value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected static final String DISPLAY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected String displayName = DISPLAY_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinValues() <em>Min Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinValues()
	 * @generated
	 * @ordered
	 */
	protected static final long MIN_VALUES_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getMinValues() <em>Min Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinValues()
	 * @generated
	 * @ordered
	 */
	protected long minValues = MIN_VALUES_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxValues() <em>Max Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxValues()
	 * @generated
	 * @ordered
	 */
	protected static final long MAX_VALUES_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getMaxValues() <em>Max Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxValues()
	 * @generated
	 * @ordered
	 */
	protected long maxValues = MAX_VALUES_EDEFAULT;

	/**
	 * The default value of the '{@link #getDataTypeName() <em>Data Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataTypeName()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_TYPE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataTypeName() <em>Data Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataTypeName()
	 * @generated
	 * @ordered
	 */
	protected String dataTypeName = DATA_TYPE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getKindNsPrefix() <em>Kind Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKindNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String KIND_NS_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKindNsPrefix() <em>Kind Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKindNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected String kindNsPrefix = KIND_NS_PREFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getKindName() <em>Kind Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKindName()
	 * @generated
	 * @ordered
	 */
	protected static final String KIND_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKindName() <em>Kind Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKindName()
	 * @generated
	 * @ordered
	 */
	protected String kindName = KIND_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getInputMethod() <em>Input Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputMethod()
	 * @generated
	 * @ordered
	 */
	protected static final InputMethod INPUT_METHOD_EDEFAULT = InputMethod.STRING;

	/**
	 * The cached value of the '{@link #getInputMethod() <em>Input Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputMethod()
	 * @generated
	 * @ordered
	 */
	protected InputMethod inputMethod = INPUT_METHOD_EDEFAULT;

	/**
	 * The default value of the '{@link #getInputUnitName() <em>Input Unit Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputUnitName()
	 * @generated
	 * @ordered
	 */
	protected static final String INPUT_UNIT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInputUnitName() <em>Input Unit Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputUnitName()
	 * @generated
	 * @ordered
	 */
	protected String inputUnitName = INPUT_UNIT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isVisibleInSimple() <em>Visible In Simple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVisibleInSimple()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VISIBLE_IN_SIMPLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isVisibleInSimple() <em>Visible In Simple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVisibleInSimple()
	 * @generated
	 * @ordered
	 */
	protected boolean visibleInSimple = VISIBLE_IN_SIMPLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isSearchableInQuick() <em>Searchable In Quick</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSearchableInQuick()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SEARCHABLE_IN_QUICK_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSearchableInQuick() <em>Searchable In Quick</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSearchableInQuick()
	 * @generated
	 * @ordered
	 */
	protected boolean searchableInQuick = SEARCHABLE_IN_QUICK_EDEFAULT;

	/**
	 * The default value of the '{@link #getImageId() <em>Image Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageId()
	 * @generated
	 * @ordered
	 */
	protected static final String IMAGE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImageId() <em>Image Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageId()
	 * @generated
	 * @ordered
	 */
	protected String imageId = IMAGE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getFieldWidth() <em>Field Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int FIELD_WIDTH_EDEFAULT = 20;

	/**
	 * The cached value of the '{@link #getFieldWidth() <em>Field Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldWidth()
	 * @generated
	 * @ordered
	 */
	protected int fieldWidth = FIELD_WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #isPrincipal() <em>Principal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrincipal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PRINCIPAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPrincipal() <em>Principal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrincipal()
	 * @generated
	 * @ordered
	 */
	protected boolean principal = PRINCIPAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.ATTRIBUTE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ATTRIBUTE__NS_PREFIX, oldNsPrefix, nsPrefix));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ATTRIBUTE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ATTRIBUTE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getPositioner() {
		return positioner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPositioner(Integer newPositioner) {
		Integer oldPositioner = positioner;
		positioner = newPositioner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ATTRIBUTE__POSITIONER, oldPositioner, positioner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDisplayName(String newDisplayName) {
		String oldDisplayName = displayName;
		displayName = newDisplayName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ATTRIBUTE__DISPLAY_NAME, oldDisplayName, displayName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getMinValues() {
		return minValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMinValues(long newMinValues) {
		long oldMinValues = minValues;
		minValues = newMinValues;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ATTRIBUTE__MIN_VALUES, oldMinValues, minValues));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getMaxValues() {
		return maxValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaxValues(long newMaxValues) {
		long oldMaxValues = maxValues;
		maxValues = newMaxValues;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ATTRIBUTE__MAX_VALUES, oldMaxValues, maxValues));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDataTypeName() {
		return dataTypeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataTypeName(String newDataTypeName) {
		String oldDataTypeName = dataTypeName;
		dataTypeName = newDataTypeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ATTRIBUTE__DATA_TYPE_NAME, oldDataTypeName, dataTypeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getKindNsPrefix() {
		return kindNsPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKindNsPrefix(String newKindNsPrefix) {
		String oldKindNsPrefix = kindNsPrefix;
		kindNsPrefix = newKindNsPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ATTRIBUTE__KIND_NS_PREFIX, oldKindNsPrefix, kindNsPrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getKindName() {
		return kindName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKindName(String newKindName) {
		String oldKindName = kindName;
		kindName = newKindName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ATTRIBUTE__KIND_NAME, oldKindName, kindName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InputMethod getInputMethod() {
		return inputMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInputMethod(InputMethod newInputMethod) {
		InputMethod oldInputMethod = inputMethod;
		inputMethod = newInputMethod == null ? INPUT_METHOD_EDEFAULT : newInputMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ATTRIBUTE__INPUT_METHOD, oldInputMethod, inputMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getInputUnitName() {
		return inputUnitName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInputUnitName(String newInputUnitName) {
		String oldInputUnitName = inputUnitName;
		inputUnitName = newInputUnitName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ATTRIBUTE__INPUT_UNIT_NAME, oldInputUnitName, inputUnitName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVisibleInSimple() {
		return visibleInSimple;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibleInSimple(boolean newVisibleInSimple) {
		boolean oldVisibleInSimple = visibleInSimple;
		visibleInSimple = newVisibleInSimple;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ATTRIBUTE__VISIBLE_IN_SIMPLE, oldVisibleInSimple, visibleInSimple));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSearchableInQuick() {
		return searchableInQuick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSearchableInQuick(boolean newSearchableInQuick) {
		boolean oldSearchableInQuick = searchableInQuick;
		searchableInQuick = newSearchableInQuick;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ATTRIBUTE__SEARCHABLE_IN_QUICK, oldSearchableInQuick, searchableInQuick));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImageId() {
		return imageId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImageId(String newImageId) {
		String oldImageId = imageId;
		imageId = newImageId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ATTRIBUTE__IMAGE_ID, oldImageId, imageId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFieldWidth() {
		return fieldWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFieldWidth(int newFieldWidth) {
		int oldFieldWidth = fieldWidth;
		fieldWidth = newFieldWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ATTRIBUTE__FIELD_WIDTH, oldFieldWidth, fieldWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPrincipal() {
		return principal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrincipal(boolean newPrincipal) {
		boolean oldPrincipal = principal;
		principal = newPrincipal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ATTRIBUTE__PRINCIPAL, oldPrincipal, principal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override @JsonIgnore
	public Unit getInputUnit() {
		return getInputUnitName() != null ? Unit.valueOf(getInputUnitName()) : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Value valueOf(String stringValue) {
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
	public Value create() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public boolean isRequired() {
		return getMinValues() > 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public boolean isMultiple() {
		return getMaxValues() > 1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataPackage.ATTRIBUTE__NS_PREFIX:
				return getNsPrefix();
			case DataPackage.ATTRIBUTE__NAME:
				return getName();
			case DataPackage.ATTRIBUTE__DESCRIPTION:
				return getDescription();
			case DataPackage.ATTRIBUTE__POSITIONER:
				return getPositioner();
			case DataPackage.ATTRIBUTE__DISPLAY_NAME:
				return getDisplayName();
			case DataPackage.ATTRIBUTE__MIN_VALUES:
				return getMinValues();
			case DataPackage.ATTRIBUTE__MAX_VALUES:
				return getMaxValues();
			case DataPackage.ATTRIBUTE__DATA_TYPE_NAME:
				return getDataTypeName();
			case DataPackage.ATTRIBUTE__KIND_NS_PREFIX:
				return getKindNsPrefix();
			case DataPackage.ATTRIBUTE__KIND_NAME:
				return getKindName();
			case DataPackage.ATTRIBUTE__INPUT_METHOD:
				return getInputMethod();
			case DataPackage.ATTRIBUTE__INPUT_UNIT_NAME:
				return getInputUnitName();
			case DataPackage.ATTRIBUTE__VISIBLE_IN_SIMPLE:
				return isVisibleInSimple();
			case DataPackage.ATTRIBUTE__SEARCHABLE_IN_QUICK:
				return isSearchableInQuick();
			case DataPackage.ATTRIBUTE__IMAGE_ID:
				return getImageId();
			case DataPackage.ATTRIBUTE__FIELD_WIDTH:
				return getFieldWidth();
			case DataPackage.ATTRIBUTE__PRINCIPAL:
				return isPrincipal();
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
			case DataPackage.ATTRIBUTE__NS_PREFIX:
				setNsPrefix((String)newValue);
				return;
			case DataPackage.ATTRIBUTE__NAME:
				setName((String)newValue);
				return;
			case DataPackage.ATTRIBUTE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case DataPackage.ATTRIBUTE__POSITIONER:
				setPositioner((Integer)newValue);
				return;
			case DataPackage.ATTRIBUTE__DISPLAY_NAME:
				setDisplayName((String)newValue);
				return;
			case DataPackage.ATTRIBUTE__MIN_VALUES:
				setMinValues((Long)newValue);
				return;
			case DataPackage.ATTRIBUTE__MAX_VALUES:
				setMaxValues((Long)newValue);
				return;
			case DataPackage.ATTRIBUTE__DATA_TYPE_NAME:
				setDataTypeName((String)newValue);
				return;
			case DataPackage.ATTRIBUTE__KIND_NS_PREFIX:
				setKindNsPrefix((String)newValue);
				return;
			case DataPackage.ATTRIBUTE__KIND_NAME:
				setKindName((String)newValue);
				return;
			case DataPackage.ATTRIBUTE__INPUT_METHOD:
				setInputMethod((InputMethod)newValue);
				return;
			case DataPackage.ATTRIBUTE__INPUT_UNIT_NAME:
				setInputUnitName((String)newValue);
				return;
			case DataPackage.ATTRIBUTE__VISIBLE_IN_SIMPLE:
				setVisibleInSimple((Boolean)newValue);
				return;
			case DataPackage.ATTRIBUTE__SEARCHABLE_IN_QUICK:
				setSearchableInQuick((Boolean)newValue);
				return;
			case DataPackage.ATTRIBUTE__IMAGE_ID:
				setImageId((String)newValue);
				return;
			case DataPackage.ATTRIBUTE__FIELD_WIDTH:
				setFieldWidth((Integer)newValue);
				return;
			case DataPackage.ATTRIBUTE__PRINCIPAL:
				setPrincipal((Boolean)newValue);
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
			case DataPackage.ATTRIBUTE__NS_PREFIX:
				setNsPrefix(NS_PREFIX_EDEFAULT);
				return;
			case DataPackage.ATTRIBUTE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DataPackage.ATTRIBUTE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case DataPackage.ATTRIBUTE__POSITIONER:
				setPositioner(POSITIONER_EDEFAULT);
				return;
			case DataPackage.ATTRIBUTE__DISPLAY_NAME:
				setDisplayName(DISPLAY_NAME_EDEFAULT);
				return;
			case DataPackage.ATTRIBUTE__MIN_VALUES:
				setMinValues(MIN_VALUES_EDEFAULT);
				return;
			case DataPackage.ATTRIBUTE__MAX_VALUES:
				setMaxValues(MAX_VALUES_EDEFAULT);
				return;
			case DataPackage.ATTRIBUTE__DATA_TYPE_NAME:
				setDataTypeName(DATA_TYPE_NAME_EDEFAULT);
				return;
			case DataPackage.ATTRIBUTE__KIND_NS_PREFIX:
				setKindNsPrefix(KIND_NS_PREFIX_EDEFAULT);
				return;
			case DataPackage.ATTRIBUTE__KIND_NAME:
				setKindName(KIND_NAME_EDEFAULT);
				return;
			case DataPackage.ATTRIBUTE__INPUT_METHOD:
				setInputMethod(INPUT_METHOD_EDEFAULT);
				return;
			case DataPackage.ATTRIBUTE__INPUT_UNIT_NAME:
				setInputUnitName(INPUT_UNIT_NAME_EDEFAULT);
				return;
			case DataPackage.ATTRIBUTE__VISIBLE_IN_SIMPLE:
				setVisibleInSimple(VISIBLE_IN_SIMPLE_EDEFAULT);
				return;
			case DataPackage.ATTRIBUTE__SEARCHABLE_IN_QUICK:
				setSearchableInQuick(SEARCHABLE_IN_QUICK_EDEFAULT);
				return;
			case DataPackage.ATTRIBUTE__IMAGE_ID:
				setImageId(IMAGE_ID_EDEFAULT);
				return;
			case DataPackage.ATTRIBUTE__FIELD_WIDTH:
				setFieldWidth(FIELD_WIDTH_EDEFAULT);
				return;
			case DataPackage.ATTRIBUTE__PRINCIPAL:
				setPrincipal(PRINCIPAL_EDEFAULT);
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
			case DataPackage.ATTRIBUTE__NS_PREFIX:
				return NS_PREFIX_EDEFAULT == null ? nsPrefix != null : !NS_PREFIX_EDEFAULT.equals(nsPrefix);
			case DataPackage.ATTRIBUTE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DataPackage.ATTRIBUTE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case DataPackage.ATTRIBUTE__POSITIONER:
				return POSITIONER_EDEFAULT == null ? positioner != null : !POSITIONER_EDEFAULT.equals(positioner);
			case DataPackage.ATTRIBUTE__DISPLAY_NAME:
				return DISPLAY_NAME_EDEFAULT == null ? displayName != null : !DISPLAY_NAME_EDEFAULT.equals(displayName);
			case DataPackage.ATTRIBUTE__MIN_VALUES:
				return minValues != MIN_VALUES_EDEFAULT;
			case DataPackage.ATTRIBUTE__MAX_VALUES:
				return maxValues != MAX_VALUES_EDEFAULT;
			case DataPackage.ATTRIBUTE__DATA_TYPE_NAME:
				return DATA_TYPE_NAME_EDEFAULT == null ? dataTypeName != null : !DATA_TYPE_NAME_EDEFAULT.equals(dataTypeName);
			case DataPackage.ATTRIBUTE__KIND_NS_PREFIX:
				return KIND_NS_PREFIX_EDEFAULT == null ? kindNsPrefix != null : !KIND_NS_PREFIX_EDEFAULT.equals(kindNsPrefix);
			case DataPackage.ATTRIBUTE__KIND_NAME:
				return KIND_NAME_EDEFAULT == null ? kindName != null : !KIND_NAME_EDEFAULT.equals(kindName);
			case DataPackage.ATTRIBUTE__INPUT_METHOD:
				return inputMethod != INPUT_METHOD_EDEFAULT;
			case DataPackage.ATTRIBUTE__INPUT_UNIT_NAME:
				return INPUT_UNIT_NAME_EDEFAULT == null ? inputUnitName != null : !INPUT_UNIT_NAME_EDEFAULT.equals(inputUnitName);
			case DataPackage.ATTRIBUTE__VISIBLE_IN_SIMPLE:
				return visibleInSimple != VISIBLE_IN_SIMPLE_EDEFAULT;
			case DataPackage.ATTRIBUTE__SEARCHABLE_IN_QUICK:
				return searchableInQuick != SEARCHABLE_IN_QUICK_EDEFAULT;
			case DataPackage.ATTRIBUTE__IMAGE_ID:
				return IMAGE_ID_EDEFAULT == null ? imageId != null : !IMAGE_ID_EDEFAULT.equals(imageId);
			case DataPackage.ATTRIBUTE__FIELD_WIDTH:
				return fieldWidth != FIELD_WIDTH_EDEFAULT;
			case DataPackage.ATTRIBUTE__PRINCIPAL:
				return principal != PRINCIPAL_EDEFAULT;
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
		if (baseClass == Nameable.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == NameContainer.class) {
			switch (derivedFeatureID) {
				case DataPackage.ATTRIBUTE__NAME: return CommonsPackage.NAME_CONTAINER__NAME;
				default: return -1;
			}
		}
		if (baseClass == Imageable.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Describable.class) {
			switch (derivedFeatureID) {
				case DataPackage.ATTRIBUTE__DESCRIPTION: return CommonsPackage.DESCRIBABLE__DESCRIPTION;
				default: return -1;
			}
		}
		if (baseClass == Positionable.class) {
			switch (derivedFeatureID) {
				case DataPackage.ATTRIBUTE__POSITIONER: return CommonsPackage.POSITIONABLE__POSITIONER;
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
		if (baseClass == Nameable.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == NameContainer.class) {
			switch (baseFeatureID) {
				case CommonsPackage.NAME_CONTAINER__NAME: return DataPackage.ATTRIBUTE__NAME;
				default: return -1;
			}
		}
		if (baseClass == Imageable.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Describable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.DESCRIBABLE__DESCRIPTION: return DataPackage.ATTRIBUTE__DESCRIPTION;
				default: return -1;
			}
		}
		if (baseClass == Positionable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.POSITIONABLE__POSITIONER: return DataPackage.ATTRIBUTE__POSITIONER;
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
		result.append(" (nsPrefix: ");
		result.append(nsPrefix);
		result.append(", name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", positioner: ");
		result.append(positioner);
		result.append(", displayName: ");
		result.append(displayName);
		result.append(", minValues: ");
		result.append(minValues);
		result.append(", maxValues: ");
		result.append(maxValues);
		result.append(", dataTypeName: ");
		result.append(dataTypeName);
		result.append(", kindNsPrefix: ");
		result.append(kindNsPrefix);
		result.append(", kindName: ");
		result.append(kindName);
		result.append(", inputMethod: ");
		result.append(inputMethod);
		result.append(", inputUnitName: ");
		result.append(inputUnitName);
		result.append(", visibleInSimple: ");
		result.append(visibleInSimple);
		result.append(", searchableInQuick: ");
		result.append(searchableInQuick);
		result.append(", imageId: ");
		result.append(imageId);
		result.append(", fieldWidth: ");
		result.append(fieldWidth);
		result.append(", principal: ");
		result.append(principal);
		result.append(')');
		return result.toString();
	}

} //AttributeImpl

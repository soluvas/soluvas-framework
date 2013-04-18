/**
 */
package org.soluvas.image.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.joda.time.DateTime;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.Nameable;
import org.soluvas.commons.Timestamped;
import org.soluvas.image.DimensionLike;
import org.soluvas.image.ImagePackage;
import org.soluvas.image.StyledImage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Styled Image</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.image.impl.StyledImageImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.soluvas.image.impl.StyledImageImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.soluvas.image.impl.StyledImageImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.soluvas.image.impl.StyledImageImpl#getCreationTime <em>Creation Time</em>}</li>
 *   <li>{@link org.soluvas.image.impl.StyledImageImpl#getModificationTime <em>Modification Time</em>}</li>
 *   <li>{@link org.soluvas.image.impl.StyledImageImpl#getSchemaVersion <em>Schema Version</em>}</li>
 *   <li>{@link org.soluvas.image.impl.StyledImageImpl#getCode <em>Code</em>}</li>
 *   <li>{@link org.soluvas.image.impl.StyledImageImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link org.soluvas.image.impl.StyledImageImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.soluvas.image.impl.StyledImageImpl#getVariant <em>Variant</em>}</li>
 *   <li>{@link org.soluvas.image.impl.StyledImageImpl#getExtension <em>Extension</em>}</li>
 *   <li>{@link org.soluvas.image.impl.StyledImageImpl#getOriginUri <em>Origin Uri</em>}</li>
 *   <li>{@link org.soluvas.image.impl.StyledImageImpl#getContentType <em>Content Type</em>}</li>
 *   <li>{@link org.soluvas.image.impl.StyledImageImpl#getLinkedFile <em>Linked File</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StyledImageImpl extends EObjectImpl implements StyledImage {
	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final Integer WIDTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected Integer width = WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected static final Integer HEIGHT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected Integer height = HEIGHT_EDEFAULT;

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
	 * The default value of the '{@link #getCode() <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCode()
	 * @generated
	 * @ordered
	 */
	protected static final String CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCode() <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCode()
	 * @generated
	 * @ordered
	 */
	protected String code = CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected String uri = URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final Long SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected Long size = SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getVariant() <em>Variant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariant()
	 * @generated
	 * @ordered
	 */
	protected static final String VARIANT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVariant() <em>Variant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariant()
	 * @generated
	 * @ordered
	 */
	protected String variant = VARIANT_EDEFAULT;

	/**
	 * The default value of the '{@link #getExtension() <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtension()
	 * @generated
	 * @ordered
	 */
	protected static final String EXTENSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExtension() <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtension()
	 * @generated
	 * @ordered
	 */
	protected String extension = EXTENSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getOriginUri() <em>Origin Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginUri()
	 * @generated
	 * @ordered
	 */
	protected static final String ORIGIN_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOriginUri() <em>Origin Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginUri()
	 * @generated
	 * @ordered
	 */
	protected String originUri = ORIGIN_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getContentType() <em>Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentType()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTENT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContentType() <em>Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentType()
	 * @generated
	 * @ordered
	 */
	protected String contentType = CONTENT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLinkedFile() <em>Linked File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkedFile()
	 * @generated
	 * @ordered
	 */
	protected static final String LINKED_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLinkedFile() <em>Linked File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkedFile()
	 * @generated
	 * @ordered
	 */
	protected String linkedFile = LINKED_FILE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StyledImageImpl() {
		super();
	}

	public StyledImageImpl(String code, String uri,
			String contentType, Long size, int width, int height) {
		super();
		this.code = code;
		this.uri = uri;
		this.contentType = contentType;
		this.size = size;
		this.width = width;
		this.height = height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImagePackage.Literals.STYLED_IMAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getWidth() {
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWidth(Integer newWidth) {
		Integer oldWidth = width;
		width = newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.STYLED_IMAGE__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getHeight() {
		return height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHeight(Integer newHeight) {
		Integer oldHeight = height;
		height = newHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.STYLED_IMAGE__HEIGHT, oldHeight, height));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.STYLED_IMAGE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.STYLED_IMAGE__CREATION_TIME, oldCreationTime, creationTime));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.STYLED_IMAGE__MODIFICATION_TIME, oldModificationTime, modificationTime));
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
	public String getCode() {
		return code;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCode(String newCode) {
		String oldCode = code;
		code = newCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.STYLED_IMAGE__CODE, oldCode, code));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUri() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUri(String newUri) {
		String oldUri = uri;
		uri = newUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.STYLED_IMAGE__URI, oldUri, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSize(Long newSize) {
		Long oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.STYLED_IMAGE__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVariant() {
		return variant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVariant(String newVariant) {
		String oldVariant = variant;
		variant = newVariant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.STYLED_IMAGE__VARIANT, oldVariant, variant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getExtension() {
		return extension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExtension(String newExtension) {
		String oldExtension = extension;
		extension = newExtension;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.STYLED_IMAGE__EXTENSION, oldExtension, extension));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOriginUri() {
		return originUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOriginUri(String newOriginUri) {
		String oldOriginUri = originUri;
		originUri = newOriginUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.STYLED_IMAGE__ORIGIN_URI, oldOriginUri, originUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getContentType() {
		return contentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContentType(String newContentType) {
		String oldContentType = contentType;
		contentType = newContentType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.STYLED_IMAGE__CONTENT_TYPE, oldContentType, contentType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLinkedFile() {
		return linkedFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLinkedFile(String newLinkedFile) {
		String oldLinkedFile = linkedFile;
		linkedFile = newLinkedFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.STYLED_IMAGE__LINKED_FILE, oldLinkedFile, linkedFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImagePackage.STYLED_IMAGE__WIDTH:
				return getWidth();
			case ImagePackage.STYLED_IMAGE__HEIGHT:
				return getHeight();
			case ImagePackage.STYLED_IMAGE__NAME:
				return getName();
			case ImagePackage.STYLED_IMAGE__CREATION_TIME:
				return getCreationTime();
			case ImagePackage.STYLED_IMAGE__MODIFICATION_TIME:
				return getModificationTime();
			case ImagePackage.STYLED_IMAGE__SCHEMA_VERSION:
				return getSchemaVersion();
			case ImagePackage.STYLED_IMAGE__CODE:
				return getCode();
			case ImagePackage.STYLED_IMAGE__URI:
				return getUri();
			case ImagePackage.STYLED_IMAGE__SIZE:
				return getSize();
			case ImagePackage.STYLED_IMAGE__VARIANT:
				return getVariant();
			case ImagePackage.STYLED_IMAGE__EXTENSION:
				return getExtension();
			case ImagePackage.STYLED_IMAGE__ORIGIN_URI:
				return getOriginUri();
			case ImagePackage.STYLED_IMAGE__CONTENT_TYPE:
				return getContentType();
			case ImagePackage.STYLED_IMAGE__LINKED_FILE:
				return getLinkedFile();
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
			case ImagePackage.STYLED_IMAGE__WIDTH:
				setWidth((Integer)newValue);
				return;
			case ImagePackage.STYLED_IMAGE__HEIGHT:
				setHeight((Integer)newValue);
				return;
			case ImagePackage.STYLED_IMAGE__NAME:
				setName((String)newValue);
				return;
			case ImagePackage.STYLED_IMAGE__CREATION_TIME:
				setCreationTime((DateTime)newValue);
				return;
			case ImagePackage.STYLED_IMAGE__MODIFICATION_TIME:
				setModificationTime((DateTime)newValue);
				return;
			case ImagePackage.STYLED_IMAGE__CODE:
				setCode((String)newValue);
				return;
			case ImagePackage.STYLED_IMAGE__URI:
				setUri((String)newValue);
				return;
			case ImagePackage.STYLED_IMAGE__SIZE:
				setSize((Long)newValue);
				return;
			case ImagePackage.STYLED_IMAGE__VARIANT:
				setVariant((String)newValue);
				return;
			case ImagePackage.STYLED_IMAGE__EXTENSION:
				setExtension((String)newValue);
				return;
			case ImagePackage.STYLED_IMAGE__ORIGIN_URI:
				setOriginUri((String)newValue);
				return;
			case ImagePackage.STYLED_IMAGE__CONTENT_TYPE:
				setContentType((String)newValue);
				return;
			case ImagePackage.STYLED_IMAGE__LINKED_FILE:
				setLinkedFile((String)newValue);
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
			case ImagePackage.STYLED_IMAGE__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case ImagePackage.STYLED_IMAGE__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case ImagePackage.STYLED_IMAGE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ImagePackage.STYLED_IMAGE__CREATION_TIME:
				setCreationTime(CREATION_TIME_EDEFAULT);
				return;
			case ImagePackage.STYLED_IMAGE__MODIFICATION_TIME:
				setModificationTime(MODIFICATION_TIME_EDEFAULT);
				return;
			case ImagePackage.STYLED_IMAGE__CODE:
				setCode(CODE_EDEFAULT);
				return;
			case ImagePackage.STYLED_IMAGE__URI:
				setUri(URI_EDEFAULT);
				return;
			case ImagePackage.STYLED_IMAGE__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case ImagePackage.STYLED_IMAGE__VARIANT:
				setVariant(VARIANT_EDEFAULT);
				return;
			case ImagePackage.STYLED_IMAGE__EXTENSION:
				setExtension(EXTENSION_EDEFAULT);
				return;
			case ImagePackage.STYLED_IMAGE__ORIGIN_URI:
				setOriginUri(ORIGIN_URI_EDEFAULT);
				return;
			case ImagePackage.STYLED_IMAGE__CONTENT_TYPE:
				setContentType(CONTENT_TYPE_EDEFAULT);
				return;
			case ImagePackage.STYLED_IMAGE__LINKED_FILE:
				setLinkedFile(LINKED_FILE_EDEFAULT);
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
			case ImagePackage.STYLED_IMAGE__WIDTH:
				return WIDTH_EDEFAULT == null ? width != null : !WIDTH_EDEFAULT.equals(width);
			case ImagePackage.STYLED_IMAGE__HEIGHT:
				return HEIGHT_EDEFAULT == null ? height != null : !HEIGHT_EDEFAULT.equals(height);
			case ImagePackage.STYLED_IMAGE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ImagePackage.STYLED_IMAGE__CREATION_TIME:
				return CREATION_TIME_EDEFAULT == null ? creationTime != null : !CREATION_TIME_EDEFAULT.equals(creationTime);
			case ImagePackage.STYLED_IMAGE__MODIFICATION_TIME:
				return MODIFICATION_TIME_EDEFAULT == null ? modificationTime != null : !MODIFICATION_TIME_EDEFAULT.equals(modificationTime);
			case ImagePackage.STYLED_IMAGE__SCHEMA_VERSION:
				return schemaVersion != SCHEMA_VERSION_EDEFAULT;
			case ImagePackage.STYLED_IMAGE__CODE:
				return CODE_EDEFAULT == null ? code != null : !CODE_EDEFAULT.equals(code);
			case ImagePackage.STYLED_IMAGE__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case ImagePackage.STYLED_IMAGE__SIZE:
				return SIZE_EDEFAULT == null ? size != null : !SIZE_EDEFAULT.equals(size);
			case ImagePackage.STYLED_IMAGE__VARIANT:
				return VARIANT_EDEFAULT == null ? variant != null : !VARIANT_EDEFAULT.equals(variant);
			case ImagePackage.STYLED_IMAGE__EXTENSION:
				return EXTENSION_EDEFAULT == null ? extension != null : !EXTENSION_EDEFAULT.equals(extension);
			case ImagePackage.STYLED_IMAGE__ORIGIN_URI:
				return ORIGIN_URI_EDEFAULT == null ? originUri != null : !ORIGIN_URI_EDEFAULT.equals(originUri);
			case ImagePackage.STYLED_IMAGE__CONTENT_TYPE:
				return CONTENT_TYPE_EDEFAULT == null ? contentType != null : !CONTENT_TYPE_EDEFAULT.equals(contentType);
			case ImagePackage.STYLED_IMAGE__LINKED_FILE:
				return LINKED_FILE_EDEFAULT == null ? linkedFile != null : !LINKED_FILE_EDEFAULT.equals(linkedFile);
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
		if (baseClass == DimensionLike.class) {
			switch (derivedFeatureID) {
				case ImagePackage.STYLED_IMAGE__WIDTH: return ImagePackage.DIMENSION_LIKE__WIDTH;
				case ImagePackage.STYLED_IMAGE__HEIGHT: return ImagePackage.DIMENSION_LIKE__HEIGHT;
				default: return -1;
			}
		}
		if (baseClass == Nameable.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == NameContainer.class) {
			switch (derivedFeatureID) {
				case ImagePackage.STYLED_IMAGE__NAME: return CommonsPackage.NAME_CONTAINER__NAME;
				default: return -1;
			}
		}
		if (baseClass == Timestamped.class) {
			switch (derivedFeatureID) {
				case ImagePackage.STYLED_IMAGE__CREATION_TIME: return CommonsPackage.TIMESTAMPED__CREATION_TIME;
				case ImagePackage.STYLED_IMAGE__MODIFICATION_TIME: return CommonsPackage.TIMESTAMPED__MODIFICATION_TIME;
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
		if (baseClass == DimensionLike.class) {
			switch (baseFeatureID) {
				case ImagePackage.DIMENSION_LIKE__WIDTH: return ImagePackage.STYLED_IMAGE__WIDTH;
				case ImagePackage.DIMENSION_LIKE__HEIGHT: return ImagePackage.STYLED_IMAGE__HEIGHT;
				default: return -1;
			}
		}
		if (baseClass == Nameable.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == NameContainer.class) {
			switch (baseFeatureID) {
				case CommonsPackage.NAME_CONTAINER__NAME: return ImagePackage.STYLED_IMAGE__NAME;
				default: return -1;
			}
		}
		if (baseClass == Timestamped.class) {
			switch (baseFeatureID) {
				case CommonsPackage.TIMESTAMPED__CREATION_TIME: return ImagePackage.STYLED_IMAGE__CREATION_TIME;
				case CommonsPackage.TIMESTAMPED__MODIFICATION_TIME: return ImagePackage.STYLED_IMAGE__MODIFICATION_TIME;
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
		result.append(" (width: ");
		result.append(width);
		result.append(", height: ");
		result.append(height);
		result.append(", name: ");
		result.append(name);
		result.append(", creationTime: ");
		result.append(creationTime);
		result.append(", modificationTime: ");
		result.append(modificationTime);
		result.append(", schemaVersion: ");
		result.append(schemaVersion);
		result.append(", code: ");
		result.append(code);
		result.append(", uri: ");
		result.append(uri);
		result.append(", size: ");
		result.append(size);
		result.append(", variant: ");
		result.append(variant);
		result.append(", extension: ");
		result.append(extension);
		result.append(", originUri: ");
		result.append(originUri);
		result.append(", contentType: ");
		result.append(contentType);
		result.append(", linkedFile: ");
		result.append(linkedFile);
		result.append(')');
		return result.toString();
	}

} //StyledImageImpl

/**
 */
package org.soluvas.image.impl;

import java.io.File;

import org.bson.BasicBSONObject;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.Nameable;
import org.soluvas.commons.SchemaVersionable;
import org.soluvas.commons.Timestamped;
import org.soluvas.image.DimensionLike;
import org.soluvas.image.Image;
import org.soluvas.image.ImagePackage;
import org.soluvas.image.StyledImage;
import org.soluvas.image.store.ImageRepository;
import org.soluvas.image.store.MongoImageRepository;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps.EntryTransformer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Image</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.image.impl.ImageImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ImageImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ImageImpl#getCreationTime <em>Creation Time</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ImageImpl#getModificationTime <em>Modification Time</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ImageImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ImageImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ImageImpl#getStyles <em>Styles</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ImageImpl#getSchemaVersion <em>Schema Version</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ImageImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ImageImpl#getFileName <em>File Name</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ImageImpl#getContentType <em>Content Type</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ImageImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ImageImpl#getCreated <em>Created</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ImageImpl#getOriginUri <em>Origin Uri</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ImageImpl#getExtension <em>Extension</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ImageImpl#getLinkedFile <em>Linked File</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ImageImpl#getOriginalFile <em>Original File</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImageImpl extends EObjectImpl implements Image {
	private static final Logger log = LoggerFactory.getLogger(ImageImpl.class);
	
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
	protected String id = ID_EDEFAULT;

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
	 * The cached value of the '{@link #getStyles() <em>Styles</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStyles()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, StyledImage> styles;

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
	 * The default value of the '{@link #getFileName() <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileName()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFileName() <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileName()
	 * @generated
	 * @ordered
	 */
	protected String fileName = FILE_NAME_EDEFAULT;

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
	 * The default value of the '{@link #getCreated() <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreated()
	 * @generated
	 * @ordered
	 */
	protected static final DateTime CREATED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreated() <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreated()
	 * @generated
	 * @ordered
	 */
	protected DateTime created = CREATED_EDEFAULT;

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
	 * The default value of the '{@link #getOriginalFile() <em>Original File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalFile()
	 * @generated
	 * @ordered
	 */
	protected static final File ORIGINAL_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOriginalFile() <em>Original File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalFile()
	 * @generated
	 * @ordered
	 */
	protected File originalFile = ORIGINAL_FILE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageImpl() {
		super();
	}

	/**
	 * Convenience constructor for passing to {@link MongoImageRepository#add(Image)}.
	 * @param originalFile
	 * @param contentType
	 * @param name
	 */
	public ImageImpl(String id, File originalFile, String contentType, String name) {
		super();
		this.id = id;
		this.originalFile = originalFile;
		this.contentType = contentType;
		this.name = name;
	}

	/**
	 * Convenience constructor for passing to {@link MongoImageRepository#add(Image)}.
	 * @param originalFile
	 * @param contentType
	 * @param name
	 */
	public ImageImpl(File originalFile, String contentType, String name) {
		this(null, originalFile, contentType, name);
	}

	public ImageImpl(ImageRepository imageStore, BasicBSONObject dbo) {
		super();
		id = dbo.getString("_id");
		name = dbo.getString("name");
		extension = dbo.getString("extension", "jpg");
//		uri = imageStore.getImageUri(id, MongoImageRepository.ORIGINAL_NAME, extension);
		uri = dbo.getString("uri");
		contentType = dbo.getString("contentType");
		fileName = dbo.getString("fileName");
		size = dbo.get("size") != null ? dbo.getLong("size") : null;
//		width = dbo.getInt("width");
//		height = dbo.getInt("height");
		BasicBSONObject stylesBson = (BasicBSONObject) dbo.get("styles");
		if (stylesBson == null) {
			log.warn("Image {} has null styles", id);
			stylesBson = new BasicBSONObject();
		}
		getStyles().putAll( ImmutableMap.copyOf(Maps.transformEntries(
				stylesBson, new EntryTransformer<String, Object, StyledImage>() {
			@Override
			public StyledImage transformEntry(String key, Object value) {
				BasicBSONObject styleBson = (BasicBSONObject)value;
				final Long size = styleBson.get("size") != null ? styleBson.getLong("size") : null;
				return new StyledImageImpl(styleBson.getString("code"),
						styleBson.getString("uri"),
						styleBson.getString("contentType"), size,
						styleBson.getInt("width"), styleBson.getInt("height"));
			}
		})) );
		
		// v1 field but forgotten in API
		created = dbo.get("created") != null ? new DateTime(dbo.get("created")) : null;
		// v2 field
		originUri = dbo.get("originUri") != null ? dbo.getString("originUri") : uri.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImagePackage.Literals.IMAGE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE__CREATION_TIME, oldCreationTime, creationTime));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE__MODIFICATION_TIME, oldModificationTime, modificationTime));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE__WIDTH, oldWidth, width));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<String, StyledImage> getStyles() {
		if (styles == null) {
			styles = new EcoreEMap<String,StyledImage>(ImagePackage.Literals.STYLED_IMAGE_ENTRY, StyledImageEntryImpl.class, this, ImagePackage.IMAGE__STYLES);
		}
		return styles;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE__URI, oldUri, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFileName() {
		return fileName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFileName(String newFileName) {
		String oldFileName = fileName;
		fileName = newFileName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE__FILE_NAME, oldFileName, fileName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE__CONTENT_TYPE, oldContentType, contentType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DateTime getCreated() {
		return created;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCreated(DateTime newCreated) {
		DateTime oldCreated = created;
		created = newCreated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE__CREATED, oldCreated, created));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE__ORIGIN_URI, oldOriginUri, originUri));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE__EXTENSION, oldExtension, extension));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE__LINKED_FILE, oldLinkedFile, linkedFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public File getOriginalFile() {
		return originalFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOriginalFile(File newOriginalFile) {
		File oldOriginalFile = originalFile;
		originalFile = newOriginalFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE__ORIGINAL_FILE, oldOriginalFile, originalFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImagePackage.IMAGE__STYLES:
				return ((InternalEList<?>)getStyles()).basicRemove(otherEnd, msgs);
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
			case ImagePackage.IMAGE__ID:
				return getId();
			case ImagePackage.IMAGE__NAME:
				return getName();
			case ImagePackage.IMAGE__CREATION_TIME:
				return getCreationTime();
			case ImagePackage.IMAGE__MODIFICATION_TIME:
				return getModificationTime();
			case ImagePackage.IMAGE__WIDTH:
				return getWidth();
			case ImagePackage.IMAGE__HEIGHT:
				return getHeight();
			case ImagePackage.IMAGE__STYLES:
				if (coreType) return getStyles();
				else return getStyles().map();
			case ImagePackage.IMAGE__SCHEMA_VERSION:
				return getSchemaVersion();
			case ImagePackage.IMAGE__URI:
				return getUri();
			case ImagePackage.IMAGE__FILE_NAME:
				return getFileName();
			case ImagePackage.IMAGE__CONTENT_TYPE:
				return getContentType();
			case ImagePackage.IMAGE__SIZE:
				return getSize();
			case ImagePackage.IMAGE__CREATED:
				return getCreated();
			case ImagePackage.IMAGE__ORIGIN_URI:
				return getOriginUri();
			case ImagePackage.IMAGE__EXTENSION:
				return getExtension();
			case ImagePackage.IMAGE__LINKED_FILE:
				return getLinkedFile();
			case ImagePackage.IMAGE__ORIGINAL_FILE:
				return getOriginalFile();
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
			case ImagePackage.IMAGE__ID:
				setId((String)newValue);
				return;
			case ImagePackage.IMAGE__NAME:
				setName((String)newValue);
				return;
			case ImagePackage.IMAGE__CREATION_TIME:
				setCreationTime((DateTime)newValue);
				return;
			case ImagePackage.IMAGE__MODIFICATION_TIME:
				setModificationTime((DateTime)newValue);
				return;
			case ImagePackage.IMAGE__WIDTH:
				setWidth((Integer)newValue);
				return;
			case ImagePackage.IMAGE__HEIGHT:
				setHeight((Integer)newValue);
				return;
			case ImagePackage.IMAGE__STYLES:
				((EStructuralFeature.Setting)getStyles()).set(newValue);
				return;
			case ImagePackage.IMAGE__URI:
				setUri((String)newValue);
				return;
			case ImagePackage.IMAGE__FILE_NAME:
				setFileName((String)newValue);
				return;
			case ImagePackage.IMAGE__CONTENT_TYPE:
				setContentType((String)newValue);
				return;
			case ImagePackage.IMAGE__SIZE:
				setSize((Long)newValue);
				return;
			case ImagePackage.IMAGE__CREATED:
				setCreated((DateTime)newValue);
				return;
			case ImagePackage.IMAGE__ORIGIN_URI:
				setOriginUri((String)newValue);
				return;
			case ImagePackage.IMAGE__EXTENSION:
				setExtension((String)newValue);
				return;
			case ImagePackage.IMAGE__LINKED_FILE:
				setLinkedFile((String)newValue);
				return;
			case ImagePackage.IMAGE__ORIGINAL_FILE:
				setOriginalFile((File)newValue);
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
			case ImagePackage.IMAGE__ID:
				setId(ID_EDEFAULT);
				return;
			case ImagePackage.IMAGE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ImagePackage.IMAGE__CREATION_TIME:
				setCreationTime(CREATION_TIME_EDEFAULT);
				return;
			case ImagePackage.IMAGE__MODIFICATION_TIME:
				setModificationTime(MODIFICATION_TIME_EDEFAULT);
				return;
			case ImagePackage.IMAGE__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case ImagePackage.IMAGE__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case ImagePackage.IMAGE__STYLES:
				getStyles().clear();
				return;
			case ImagePackage.IMAGE__URI:
				setUri(URI_EDEFAULT);
				return;
			case ImagePackage.IMAGE__FILE_NAME:
				setFileName(FILE_NAME_EDEFAULT);
				return;
			case ImagePackage.IMAGE__CONTENT_TYPE:
				setContentType(CONTENT_TYPE_EDEFAULT);
				return;
			case ImagePackage.IMAGE__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case ImagePackage.IMAGE__CREATED:
				setCreated(CREATED_EDEFAULT);
				return;
			case ImagePackage.IMAGE__ORIGIN_URI:
				setOriginUri(ORIGIN_URI_EDEFAULT);
				return;
			case ImagePackage.IMAGE__EXTENSION:
				setExtension(EXTENSION_EDEFAULT);
				return;
			case ImagePackage.IMAGE__LINKED_FILE:
				setLinkedFile(LINKED_FILE_EDEFAULT);
				return;
			case ImagePackage.IMAGE__ORIGINAL_FILE:
				setOriginalFile(ORIGINAL_FILE_EDEFAULT);
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
			case ImagePackage.IMAGE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ImagePackage.IMAGE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ImagePackage.IMAGE__CREATION_TIME:
				return CREATION_TIME_EDEFAULT == null ? creationTime != null : !CREATION_TIME_EDEFAULT.equals(creationTime);
			case ImagePackage.IMAGE__MODIFICATION_TIME:
				return MODIFICATION_TIME_EDEFAULT == null ? modificationTime != null : !MODIFICATION_TIME_EDEFAULT.equals(modificationTime);
			case ImagePackage.IMAGE__WIDTH:
				return WIDTH_EDEFAULT == null ? width != null : !WIDTH_EDEFAULT.equals(width);
			case ImagePackage.IMAGE__HEIGHT:
				return HEIGHT_EDEFAULT == null ? height != null : !HEIGHT_EDEFAULT.equals(height);
			case ImagePackage.IMAGE__STYLES:
				return styles != null && !styles.isEmpty();
			case ImagePackage.IMAGE__SCHEMA_VERSION:
				return schemaVersion != SCHEMA_VERSION_EDEFAULT;
			case ImagePackage.IMAGE__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case ImagePackage.IMAGE__FILE_NAME:
				return FILE_NAME_EDEFAULT == null ? fileName != null : !FILE_NAME_EDEFAULT.equals(fileName);
			case ImagePackage.IMAGE__CONTENT_TYPE:
				return CONTENT_TYPE_EDEFAULT == null ? contentType != null : !CONTENT_TYPE_EDEFAULT.equals(contentType);
			case ImagePackage.IMAGE__SIZE:
				return SIZE_EDEFAULT == null ? size != null : !SIZE_EDEFAULT.equals(size);
			case ImagePackage.IMAGE__CREATED:
				return CREATED_EDEFAULT == null ? created != null : !CREATED_EDEFAULT.equals(created);
			case ImagePackage.IMAGE__ORIGIN_URI:
				return ORIGIN_URI_EDEFAULT == null ? originUri != null : !ORIGIN_URI_EDEFAULT.equals(originUri);
			case ImagePackage.IMAGE__EXTENSION:
				return EXTENSION_EDEFAULT == null ? extension != null : !EXTENSION_EDEFAULT.equals(extension);
			case ImagePackage.IMAGE__LINKED_FILE:
				return LINKED_FILE_EDEFAULT == null ? linkedFile != null : !LINKED_FILE_EDEFAULT.equals(linkedFile);
			case ImagePackage.IMAGE__ORIGINAL_FILE:
				return ORIGINAL_FILE_EDEFAULT == null ? originalFile != null : !ORIGINAL_FILE_EDEFAULT.equals(originalFile);
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
				case ImagePackage.IMAGE__NAME: return CommonsPackage.NAME_CONTAINER__NAME;
				default: return -1;
			}
		}
		if (baseClass == SchemaVersionable.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Timestamped.class) {
			switch (derivedFeatureID) {
				case ImagePackage.IMAGE__CREATION_TIME: return CommonsPackage.TIMESTAMPED__CREATION_TIME;
				case ImagePackage.IMAGE__MODIFICATION_TIME: return CommonsPackage.TIMESTAMPED__MODIFICATION_TIME;
				default: return -1;
			}
		}
		if (baseClass == DimensionLike.class) {
			switch (derivedFeatureID) {
				case ImagePackage.IMAGE__WIDTH: return ImagePackage.DIMENSION_LIKE__WIDTH;
				case ImagePackage.IMAGE__HEIGHT: return ImagePackage.DIMENSION_LIKE__HEIGHT;
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
				case CommonsPackage.NAME_CONTAINER__NAME: return ImagePackage.IMAGE__NAME;
				default: return -1;
			}
		}
		if (baseClass == SchemaVersionable.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Timestamped.class) {
			switch (baseFeatureID) {
				case CommonsPackage.TIMESTAMPED__CREATION_TIME: return ImagePackage.IMAGE__CREATION_TIME;
				case CommonsPackage.TIMESTAMPED__MODIFICATION_TIME: return ImagePackage.IMAGE__MODIFICATION_TIME;
				default: return -1;
			}
		}
		if (baseClass == DimensionLike.class) {
			switch (baseFeatureID) {
				case ImagePackage.DIMENSION_LIKE__WIDTH: return ImagePackage.IMAGE__WIDTH;
				case ImagePackage.DIMENSION_LIKE__HEIGHT: return ImagePackage.IMAGE__HEIGHT;
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
		result.append(", name: ");
		result.append(name);
		result.append(", creationTime: ");
		result.append(creationTime);
		result.append(", modificationTime: ");
		result.append(modificationTime);
		result.append(", width: ");
		result.append(width);
		result.append(", height: ");
		result.append(height);
		result.append(", schemaVersion: ");
		result.append(schemaVersion);
		result.append(", uri: ");
		result.append(uri);
		result.append(", fileName: ");
		result.append(fileName);
		result.append(", contentType: ");
		result.append(contentType);
		result.append(", size: ");
		result.append(size);
		result.append(", created: ");
		result.append(created);
		result.append(", originUri: ");
		result.append(originUri);
		result.append(", extension: ");
		result.append(extension);
		result.append(", linkedFile: ");
		result.append(linkedFile);
		result.append(", originalFile: ");
		result.append(originalFile);
		result.append(')');
		return result.toString();
	}

} //ImageImpl

package org.soluvas.image.store;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

import javax.annotation.Nullable;
import javax.annotation.PreDestroy;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.bson.BasicBSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.ProgressMonitor;
import org.soluvas.commons.ProgressStatus;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.impl.ProgressMonitorImpl;
import org.soluvas.image.DavConnector;
import org.soluvas.image.ImageConnector;
import org.soluvas.image.ImageException;
import org.soluvas.image.ImageFactory;
import org.soluvas.image.ImageTransform;
import org.soluvas.image.ImageTransformer;
import org.soluvas.image.ImageVariant;
import org.soluvas.image.ResizeToFill;
import org.soluvas.image.UploadedImage;
import org.soluvas.image.impl.DavConnectorImpl;
import org.soluvas.image.impl.ThumbnailatorTransformerImpl;
import org.soluvas.image.util.ImageUtils;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoURI;

/**
 * @author ceefour
 * Stores images using WebDAV protocol and MongoDB.
 * 
 * Requirements:
 * - Uniquely identifiable
 * - SEO friendly
 * 
 * The image metadata are stored in MongoDB with a namespace.
 * 
 * Scheme is:
 * ${publicUri}/${namespace}/${shortCode}/${id}_${shortCode}.${extension}
 * ${safeDavUri}/${namespace}/${shortCode}/${id}_${shortCode}.${extension}
 *
 * Usage:
 * 1. Set the following 4 properties: namespace, safeDavUri, publicUri, mongoUri
 * 2. addStyle() as needed
 * 3. Additional 2 passwords during init().
 * 
 * @todo Make the name SEO friendly: prefix the UUID with the original name/title but slugged.
 */
public class MongoImageRepository implements ImageRepository {

	private static final Logger log = LoggerFactory.getLogger(MongoImageRepository.class);
	
	private String namespace;
	private String mongoUri;
	private DBCollection mongoColl;
	private final Map<String, ImageStyle> styles = new ConcurrentHashMap<String, ImageStyle>();
	
	private DavConnector innerConnector;
	private ImageConnector connector;
	private ImageTransformer transformer;
	
	public class DBObjectToImage implements Function<DBObject, Image> {
		@Override
		public Image apply(DBObject input) {
			return new Image(MongoImageRepository.this, (BasicBSONObject)input);
		}
	}

	//	private ActorSystem system;
	/**
	 * If true, means the {@link ActorSystem} is owned by {@link MongoImageRepository},
	 * and should be shutdown when MongoImageRepository is destroyed.
	 */
//	private boolean shutdownActorSystem = false;

	public static class ResizeResult {
		String styleName;
		String contentType;
		String extension;
		long length;
		byte[] content;
		protected int width;
		protected int height;
		
		public ResizeResult(String styleName, String contentType,
				String extension, long length, byte[] content, int width, int height) {
			super();
			this.styleName = styleName;
			this.contentType = contentType;
			this.extension = extension;
			this.length = length;
			this.content = content;
			this.width = width;
			this.height = height;
		}
		
	}
	
	/**
	 * Required by CDI apps i.e. LDAP Tools CLI.
	 */
	public MongoImageRepository() {
		super();
	}
	
	/**
	 * Create image repository powered by {@link DavConnector}.
	 * @param namespace
	 * @param davUri
	 * @param publicUri
	 * @param mongoUri
	 * @deprecated Use {@link #MongoImageRepository(String, String, ImageConnector, Collection)}.
	 */
	@Deprecated
	public MongoImageRepository(String namespace, String davUri, String publicUri,
			String mongoUri) {
		super();
		this.namespace = namespace;
		this.mongoUri = mongoUri;
		this.innerConnector = new DavConnectorImpl(davUri, publicUri); 
		this.connector = innerConnector;
		this.transformer = new ThumbnailatorTransformerImpl(innerConnector);
	}
	
	// URI: ~repo.publicUri~{namespace}/{styleCode}/{imageId}_{styleVariant}.{extension}
	public MongoImageRepository(String namespace, String mongoUri, ImageConnector connector,
			ImageTransformer transformer, List<ImageStyle> imageStyles) {
		super();
		this.namespace = namespace;
		this.mongoUri = mongoUri;
		this.connector = connector;
		this.transformer = transformer;
		setStyles(imageStyles);
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#init()
	 */
	public void init() {
		log.info("Starting MongoImageRepository {} with {} styles", namespace, styles.size());
		
		// Sanity checks
		if (mongoUri == null || mongoUri.isEmpty())
			throw new ImageException("MongoDB URI for " + namespace + " Image Store cannot be empty");

		MongoURI mongoUriDetail = new MongoURI(mongoUri);
		try {
			log.info("Connecting to MongoDB {} database {}", mongoUriDetail.getHosts(), mongoUriDetail.getDatabase());
			DB db = mongoUriDetail.connectDB();
			if (mongoUriDetail.getUsername() != null)
				db.authenticate(mongoUriDetail.getUsername(), mongoUriDetail.getPassword());
			String collName = namespace + "Image";
			log.info("Authenticated to MongoDB. Collection name is {}", collName);
			mongoColl = db.getCollection(collName);
			mongoColl.ensureIndex(new BasicDBObject("created", -1));
		} catch (Exception e) {
			throw new ImageException("Cannot connect to MongoDB "+ mongoUriDetail.getHosts() + " database " + mongoUriDetail.getDatabase(), e);
		}
		
		createFolders();
		
		// Start actors
//		if (system == null) {
//			shutdownActorSystem = true;
//			system = ActorSystem.create("MongoImageRepository");
//		}
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#destroy()
	 */
	@PreDestroy
	public void destroy() {
		log.info("Shutting down MongoImageRepository {}", namespace);
//		if (shutdownActorSystem && system != null) {
//			system.shutdown();
//			system.awaitTermination();
//		}
		if (innerConnector != null)
			innerConnector.destroy();
		if (mongoColl != null) {
			mongoColl.getDB().cleanCursors(false);
			mongoColl.getDB().getMongo().close();
		}
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#createFolders()
	 */
	@Override
	public void createFolders() {
		// TODO: Implement createFolderS()
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#addStyle(java.lang.String, java.lang.String, int, int)
	 */
	@Override
	@Deprecated
	public void addStyle(String name, String code, int maxWidth, int maxHeight) {
		if (ORIGINAL_CODE.equals(code))
			throw new ImageException("Cannot use code 'o' for image style");
		log.info("Added image style {}:{} {}x{}", 
				code, name, maxWidth, maxHeight );
		ImageStyle style = new ImageStyle(name, code, maxWidth, maxHeight);
		styles.put(name, style);
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#getStyles()
	 */
	@Override
	public List<ImageStyle> getStyles() {
		return ImmutableList.copyOf(styles.values());
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#setStyles(java.util.List)
	 */
	@Override
	public void setStyles(List<ImageStyle> styles) {
		this.styles.clear();
		for (ImageStyle style : styles) {
			addStyle(style.getName(), style.getCode(), style.getMaxWidth(), style.getMaxHeight());
		}
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#getImagePublicUri(java.lang.String, java.lang.String)
	 */
	@Override
	public String getImageUri(String id, String styleName) {
		// TODO: don't hardcode extension
		String extension = "jpg";
		String styleCode;
		if (ORIGINAL_NAME.equals(styleName)) {
			styleCode = ORIGINAL_CODE;
		} else {
			styleCode = styles.get(styleName).getCode();
		}
		String styleVariant = styleCode;
		return connector.getUri(namespace, id, styleCode, styleVariant, extension);
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#create(java.lang.String, java.io.InputStream, java.lang.String, long, java.lang.String)
	 */
	@Override
	public String create(String fileName, InputStream content, final String contentType, final long length, String name) throws IOException {
		final File originalFile = File.createTempFile(getNamespace() + "_", "_" + fileName);
		try {
			log.info("Saving original image ({} {} bytes) to temporary file {}", new Object[] { 
					contentType, length, originalFile });
			FileUtils.copyInputStreamToFile(content, originalFile);
			
			return doCreate(null, originalFile, contentType, originalFile.length(), name, fileName, true);
		} finally {
			log.info("Deleting temporary original image {}", originalFile);
			originalFile.delete();
		}
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#create(java.io.File, java.lang.String, java.lang.String)
	 */
	@Override
	public String create(String imageId, File originalFile, final String contentType, String name) throws IOException {
		Preconditions.checkNotNull(originalFile, "Original file to be added must not be null");
		return doCreate(null, originalFile, contentType, originalFile.length(), name, originalFile.getName(), true);
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#add(org.soluvas.image.store.Image)
	 */
	@Override
	public String add(Image newImage) {
		try {
			return create(newImage.getId(), newImage.getOriginalFile(), newImage.getContentType(), newImage.getName());
		} catch (IOException e) {
			throw new ImageException("Error adding image " + newImage, e);
		}
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#doCreate(java.lang.String, java.io.File, java.lang.String, long, java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public String doCreate(String existingImageId, final File originalFile, final String contentType,
			final long length, final String name, final String originalName, boolean alsoUploadOriginal) throws IOException {
//		final String seoName = name + " " + FilenameUtils.getBaseName(fileName);
		final String seoName1 = SlugUtils.generateId(name, 0);
		final String seoName2 = SlugUtils.generateId(FilenameUtils.getBaseName(originalName), 0);
		final String imageId = Optional.fromNullable(existingImageId).or( seoName1.equals(seoName2) ? seoName1 : seoName1 + "_" + seoName2 );
		final String extension = FilenameUtils.getExtension(originalName);
		
		log.debug("Adding image from {} ({} {} bytes) as {}",
				originalFile.getName(), contentType, length, imageId );
		
		try {
			// <del>Upload originals last, so that unreadable images aren't uploaded at all</del>
			// Originals must be uploaded first, because Blitline transformer requires them!
			
			final String originalUri;
			final String originalOriginUri;
			if (alsoUploadOriginal) {
				try {
					final UploadedImage originalUpload = connector.upload(namespace, imageId, ORIGINAL_CODE, ORIGINAL_CODE, extension,
							originalFile, contentType);
					originalUri = originalUpload.getUri();
					originalOriginUri = originalUpload.getOriginUri();
				} catch (Exception e) {
					throw new ImageException("Error uploading original " + imageId + " using " + connector.getClass().getName(), e);
				}
			} else {
				log.info("Not uploading original {} using {} because requested by caller (probably for reprocess)",
						imageId, connector.getClass().getName());
				originalUri = connector.getUri(namespace, imageId, ORIGINAL_CODE, ORIGINAL_CODE, extension);
				originalOriginUri = connector.getOriginUri(namespace, imageId, ORIGINAL_CODE, ORIGINAL_CODE, extension);
			}
//			Future<Object> originalFuture = Futures.future(uploadOriginal, system.dispatcher());

			// Create styles and upload
//			final Collection<StyledImage> styledImages = Collections2.transform(styles.values(), new com.google.common.base.Function<ImageStyle, StyledImage>() {
//				@Override
//				public StyledImage apply(final ImageStyle style) {
//				}
//			});
			final ImageVariant sourceVariant = ImageFactory.eINSTANCE.createImageVariant();
			sourceVariant.setStyleCode(ORIGINAL_CODE);
			sourceVariant.setStyleVariant(ORIGINAL_CODE);
			sourceVariant.setExtension(extension);
			final ImmutableMap.Builder<ImageTransform, ImageVariant> transformsBuilder = ImmutableMap.builder();
			for (final ImageStyle style : styles.values()) {
				final ResizeToFill fx = ImageFactory.eINSTANCE.createResizeToFill();
				fx.setWidth(style.getMaxWidth());
				fx.setHeight(style.getMaxHeight());
				final ImageVariant dest = ImageFactory.eINSTANCE.createImageVariant();
				dest.setStyleCode(style.getCode());
				// TODO: support variant
				dest.setStyleVariant(style.getCode());
				// TODO: don't hardcode extension
				dest.setExtension("jpg");
				transformsBuilder.put(fx, dest);
			}
			final Map<ImageTransform, ImageVariant> transforms = transformsBuilder.build();
			// FIXME: transform and upload
			log.debug("Transforming {} into {} variants using {}", imageId, transforms.size(), transformer.getClass().getName());
			final List<UploadedImage> transformeds = transformer.transform(connector, namespace, imageId, sourceVariant, transforms);
			log.info("Got {} transformed images of {} from {}", transformeds.size(), imageId, transformer.getClass().getName());

//			// Upload these thumbnails
//			List<Future<StyledImage>> uploadedFutures = Lists.transform(styledFutures, new com.google.common.base.Function<Future<ResizeResult>, Future<StyledImage>>() {
//				@Override
//				public Future<StyledImage> apply(final Future<ResizeResult> styledFuture) {
//					return styledFuture.flatMap(new Mapper<ResizeResult, Future<StyledImage>>() {
//						@Override
//						public Future<StyledImage> apply(final ResizeResult resized) {
//							return Futures.future(new Callable<StyledImage>() {
//								@Override public StyledImage call() throws Exception {
//									URI styledDavUri = getImageDavUri(imageId, resized.styleName);
//									try {
//										log.info("Uploading {} {} to {}", new Object[] { resized.styleName, imageId, styledDavUri });
//										uploadFile(styledDavUri, new ByteArrayInputStream(resized.content), resized.contentType, resized.length);
//										URI styledPublicUri = getImagePublicUri(imageId, resized.styleName);
//										ImageStyle style = styles.get(resized.styleName);
//										StyledImage styled = new StyledImage(resized.styleName, style.getCode(), styledPublicUri, resized.contentType,
//												(int)resized.length, resized.width, resized.height);
//										return styled;
//									} catch (Exception e) {
//										throw new ImageException("Error uploading " + resized.styleName + " " + imageId + " to " + styledDavUri, e);
//									}
//								}
//							}, system.dispatcher());
//						}
//					});
//				}
//			});

//			Await.result(originalFuture, Timeout.never().duration());
			
			final BasicBSONObject stylesObj = new BasicBSONObject();
			for (final UploadedImage transformed : transformeds) {
//				StyledImage styled = Await.result(future, Timeout.never().duration());
				final ImageStyle style = Iterables.find(styles.values(), new Predicate<ImageStyle>() {
					@Override
					public boolean apply(@Nullable ImageStyle input) {
						return transformed.getStyleCode().equals(input.getCode());
					}
				});
				final Map<String, Object> bson = new HashMap<String, Object>();
				bson.put("className", StyledImage.class.getName());
				bson.put("name", style.getName());
				bson.put("code", transformed.getStyleCode());
				bson.put("styleCode", transformed.getStyleCode());
				bson.put("styleVariant", transformed.getStyleVariant());
				bson.put("extension", transformed.getExtension());
				bson.put("uri", transformed.getUri());
				bson.put("originUri", transformed.getOriginUri());
				bson.put("contentType", "image/jpeg"); // TODO: don't hardcode content type
				bson.put("size", transformed.getSize());
				bson.put("width", transformed.getWidth());
				bson.put("height", transformed.getHeight());
				stylesObj.put(style.getName(), bson);
			}
			
			// Create mongoDB
			final BasicDBObject dbo = new BasicDBObject();
			dbo.put("_id", imageId);
			dbo.put("name", name);
			dbo.put("uri", originalUri);
			dbo.put("originUri", originalOriginUri);
			dbo.put("fileName", originalName);
			dbo.put("contentType", contentType);
			dbo.put("extension", extension);
			dbo.put("size", (int)length);
			final Date creationTime = new Date();
			dbo.put("created", creationTime);
			dbo.put("creationTime", creationTime);
			dbo.put("styles", stylesObj);
			
			log.info("Upserting image {} ({}) metadata into MongoDB collection {}", 
					imageId, name, mongoColl.getName() );
			mongoColl.update(new BasicDBObject("_id", imageId), dbo, true, false);
			
			return imageId;
		} catch (final Exception e) {
			throw new ImageException("Error processing image " + imageId, e);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#delete(java.lang.String)
	 */
	@Override
	public boolean delete(final String id) {
		final Image image = findOne(id);
		if (image == null) {
			log.warn("Not deleting non-existing {} image {}", namespace, id);
			return false;
		}

		// --------- Delete styleds --------
//		Future<Iterable<StatusLine>> styledsFuture = Futures.traverse(image.getStyles().values(), new Function<StyledImage, Future<StatusLine>>() {
//		@Override
//		public Future<StatusLine> apply(final StyledImage styled) {
//			return Futures.future(new Callable<StatusLine>() {
//				@Override
//				public StatusLine call() throws Exception {
//					log.info("Deleting {} image {} - {}: {}", new Object[] { 
//							namespace, id, styled.getStyleName(), styled.getUri() });
//					HttpDelete deleteThumb = new HttpDelete(styled.getUri());
//					try {
//						HttpResponse response = client.execute(davHost, deleteThumb, createHttpContext());
//						final StatusLine statusLine = response.getStatusLine();
//						HttpClientUtils.closeQuietly(response);
//						log.info("Delete {} returned: {}", styled.getUri(), statusLine);
//						return statusLine;
//					} catch (Exception e) {
//						log.error("Error deleting "+ styled.getUri(), e);
//						return null;
//					}
//				}
//			}, system.dispatcher());
//		}
//	}, system.dispatcher());

		for (StyledImage styled : image.getStyles().values()) {
			log.info("Deleting {} image {} - {}: {}",
					namespace, id, styled.getStyleName(), styled.getUri() );
			try {
				// TODO: don't hardcode extension
				String styledExtension = "jpg";
				// TODO: support variant
				connector.delete(namespace, id, styled.getCode(), styled.getCode(), styledExtension);
			} catch (Exception e) {
				log.error("Cannot delete " + namespace + " image " + id + ": " + styled.getStyleName() + " at " + styled.getUri(), e);
			}
		}
	
		try {
	//		Iterable<StatusLine> statuses = Await.result(styledsFuture, Duration.create(60, TimeUnit.SECONDS));
	//		log.info("Delete styled {} image {} status codes: {}", new Object[] { namespace, id, statuses });
	//		StatusLine status = Await.result(originalFuture, Duration.create(60, TimeUnit.SECONDS));
	//		log.info("Delete original {} image {} status code: {}", new Object[] { namespace, id, status });
		} catch (Exception e) {
			log.error("Error deleting " + namespace + " image " + id + " from WebDAV", e);
		}

	// -------- Delete originals -------
//		Future<StatusLine> originalFuture = Futures.future(new Callable<StatusLine>() {
//			@Override
//			public StatusLine call() throws Exception {
//				URI originalUri = image.getUri();
//				log.info("Deleting {} image {} - original: {}", new Object[] { 
//						namespace, id, originalUri });
//				HttpDelete deleteOriginal = new HttpDelete(originalUri);
//				try {
//					HttpResponse response = client.execute(davHost, deleteOriginal, createHttpContext());
//					final StatusLine statusLine = response.getStatusLine();
//					log.info("Delete {} returned: {}", originalUri, statusLine);
//					HttpClientUtils.closeQuietly(response);
//					return statusLine;
//				} catch (Exception e) {
//					log.error("Error deleting "+ originalUri, e);
//					return null;
//				}
//			}
//		}, system.dispatcher());

		URI originalUri = image.getUri();
		log.info("Deleting {} image {} - original: {}", 
				namespace, id, originalUri);
		// TODO: should store extension of original, also the styleds
		String fileName = image.getFileName();
		String originalExtension = !Strings.isNullOrEmpty(fileName) ? FilenameUtils.getExtension(fileName) : "jpg";
		connector.delete(namespace, id, ImageRepository.ORIGINAL_CODE, ImageRepository.ORIGINAL_CODE, originalExtension);
		
		log.debug("Deleting {} image metadata {}", namespace, id);
		try {
			mongoColl.remove(new BasicDBObject("_id", id));
		} catch (Exception e) {
			log.error("Error deleting " + namespace + " image metadata " + id, e);
		}
		
		return true;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#findOne(java.lang.String)
	 */
	@Override
	public Image findOne(String id) {
		log.trace("Get {} Image {}", namespace, id);
		if (id == null)
			return null;
		final DBObject dbo = mongoColl.findOne(new BasicDBObject("_id", id));
		if (dbo == null)
			return null;
		return new Image(this, (BasicBSONObject)dbo);
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#findAllByIds(java.lang.Iterable)
	 */
	@Override
	public Map<String, Image> findAllByIds(Iterable<String> ids) {
		log.trace("Get {} Image with IDs {}", namespace, ids);
		DBCursor dbCursor = mongoColl.find(
				new BasicDBObject("_id", new BasicDBObject("$in", Iterables.toArray(ids, String.class))));
		try {
			ImmutableMap<String, Image> images = Maps.uniqueIndex( Iterables.transform(dbCursor, new DBObjectToImage()), new Function<Image, String>() {
				@Override
				public String apply(Image input) {
					return input.getId();
				}
			});
			log.debug("Got {} {} images with IDs {}", new Object[] {
					images.size(), namespace, ids });
			return images;
		} finally {
			dbCursor.close();
		}
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#findAll()
	 */
	@Override
	public List<Image> findAll() {
		DBCursor cursor = mongoColl.find().sort(new BasicDBObject("_id", "1"));
		try {
			ImmutableList<Image> images = ImmutableList.copyOf( Iterables.transform(cursor, new DBObjectToImage()) );
			return images;
		} finally {
			cursor.close();
		}
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#search(java.lang.String)
	 */
	@Override
	public List<Image> search(String searchText) {
		log.debug("Searching {}", searchText);
		DBCursor cursor = mongoColl.find(new BasicDBObject("$or", new Map[] {
				ImmutableMap.of("_id", Pattern.compile(".*" + Pattern.quote(searchText) + ".*", Pattern.CASE_INSENSITIVE)),
				ImmutableMap.of("fileName", Pattern.compile(".*" + Pattern.quote(searchText) + ".*", Pattern.CASE_INSENSITIVE)),
				ImmutableMap.of("uri", Pattern.compile(".*" + Pattern.quote(searchText) + ".*", Pattern.CASE_INSENSITIVE))
		})).sort(new BasicDBObject("_id", "1"));
		try {
			List<Image> images = ImmutableList.copyOf( Iterables.transform(cursor, new Function<DBObject, Image>() {
				@Override
				public Image apply(DBObject input) {
					return new Image(MongoImageRepository.this, (BasicBSONObject)input);
				}
			}) );
			return images;
		} finally {
			cursor.close();
		}
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#reprocess(java.lang.Iterable)
	 */
	@Override
	public void reprocess(Iterable<String> ids, ProgressMonitor monitor) {
		Map<String, Image> images = findAllByIds(ids);
		doReprocess(images.values(), monitor);
	}
	
	/**
	 * @param images
	 */
	protected void doReprocess(Collection<Image> images, ProgressMonitor monitor) {
		final ProgressMonitor submon = ProgressMonitorImpl.convert(monitor, images.size());
		log.info("Reprocessing {} images", images.size());
		submon.beginTask("Reprocessing " + images.size() + " images", images.size());
		ProgressStatus finalStatus = ProgressStatus.OK;
		for (final Image image : images) {
			final String extension = ImageUtils.getExtensionOrJpg(image.getFileName());
			try {
				// TODO: reprocessing should not require download (esp. for blitline transformer) 
				final File tempFile = File.createTempFile(image.getId(), "." + extension);
//				submon.beginTask("Fetching " + image.getId() + " from " + image.getUri() + " to " + tempFile, 1);
				log.info("Downloading {} from {} to {}", image.getId(), image.getUri(), tempFile);
				try {
					final boolean downloaded = connector.download(namespace, image.getId(), ORIGINAL_CODE, ORIGINAL_CODE,
							extension, tempFile);
					if (downloaded) {
						doCreate(image.getId(), tempFile, image.getContentType(), tempFile.length(), image.getFileName(),
								image.getFileName(), false);
					} else {
						log.error("Cannot download {} because connector {} returned false",
								image.getId(), connector.getClass().getName());
						finalStatus = ProgressStatus.WARNING;
					}
					submon.worked(1);
				} finally {
					log.trace("Deleting temporary file {} (image {})", tempFile, image.getId());
					tempFile.delete();
				}
			} catch (Exception e) {
				// log, but continue
				log.error("Cannot reprocess image " + image.getId(), e);
				submon.worked(1, ProgressStatus.ERROR);
				finalStatus = ProgressStatus.ERROR;
			}
		}
		submon.done(finalStatus); // TODO: shouldn't be done in proper implementation
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#reprocessAll()
	 */
	@Override
	public void reprocessAll(ProgressMonitor monitor) {
		final ProgressMonitor submon = ProgressMonitorImpl.convert(monitor, 2);
		submon.beginTask("Finding all " + namespace + " images", 1);
		final List<Image> images = findAll();
		submon.worked(1);
		submon.done(); // TODO: shouldn't be done in proper implementation
		doReprocess(images, monitor);
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#getNamespace()
	 */
	@Override
	public String getNamespace() {
		return namespace;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#getMongoUri()
	 */
	@Override
	public String getMongoUri() {
		return mongoUri;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#setSystem(java.lang.Object)
	 */
//	public void setSystem(ActorSystem system) {
//		this.system = system;
//	}
	@Override
	public void setSystem(Object system) {
	}

	@Override
	public void deleteMultiple(Set<String> ids) {
		log.info("Multiple deleting images {}", ids);
		for (String id : ids) {
			delete(id);
		}
	}

	@Override
	public void updateUriAll(ProgressMonitor monitor) {
		final ProgressMonitor submon = ProgressMonitorImpl.convert(monitor, 2);
		submon.beginTask("Finding all " + namespace + " images", 1);
		final List<Image> images = findAll();
		submon.worked(1);
		submon.done(); // TODO: shouldn't be done in proper implementation
		doUpdateUri(images, submon);
	}

	protected void doUpdateUri(final Collection<Image> images, ProgressMonitor monitor) {
		log.info("Updating {} {} image URIs", images.size(), namespace);
		final ProgressMonitor submon = ProgressMonitorImpl.convert(monitor, 2);
		submon.beginTask("Updating URIs for " + images.size() + " images", images.size());
		for (Image image : images) {
			final String newUri = getImageUri(image.getId(), ORIGINAL_NAME);
			final BasicDBObject dbo = new BasicDBObject();
			dbo.put("uri", newUri.toString());
			log.debug("Updating {} image {} to {}", namespace, image.getId(), newUri);
			mongoColl.update(new BasicDBObject("_id", image.getId()), new BasicDBObject("$set", dbo));
			
			final Map<String, StyledImage> imageStyles = image.getStyles();
			for (Entry<String, StyledImage> styleImage : imageStyles.entrySet()) {
				final String styleName = styleImage.getKey();
				final String newStyleUri = getImageUri(image.getId(), styleName);
				final BasicDBObject updatedStyleUri = new BasicDBObject("styles."+ styleName +".uri", newStyleUri.toString());
				log.debug("Updating {} image id {} to {} with style {}", namespace, image.getId(), newStyleUri, styleName);
				mongoColl.update(new BasicDBObject("_id", image.getId()), new BasicDBObject("$set", updatedStyleUri));
			}
			submon.worked(1);
		}
		submon.done(); // TODO: shouldn't be done in proper implementation
	}

	@Override
	public void updateUri(Collection<String> imageIds, ProgressMonitor monitor) {
		final Collection<Image> images = Collections2.transform(imageIds, new Function<String, Image>() {
			@Override @Nullable
			public Image apply(@Nullable String imageId) {
				final Image image = findOne(imageId);
				Preconditions.checkNotNull(image, "Cannot find %s image with imageId %s", namespace, imageId);
				return image;
			}
		});
		doUpdateUri(images, monitor);
	}

	@Override
	public String getUriTemplate() {
		return connector.getUriTemplate();
	}

	@Override
	public ImageConnector getConnector() {
		return connector;
	}
	
	@Override
	public boolean exists(String id) {
		log.trace("Exists {} Image {}?", namespace, id);
		if (id == null)
			return false;
		final long count = mongoColl.count(new BasicDBObject("_id", id));
		return count >= 1;
	}

}

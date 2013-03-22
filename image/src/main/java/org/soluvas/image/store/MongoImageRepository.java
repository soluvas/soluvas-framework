package org.soluvas.image.store;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.PreDestroy;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.bson.BasicBSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.ProgressMonitor;
import org.soluvas.commons.ProgressStatus;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.impl.ProgressMonitorImpl;
import org.soluvas.commons.impl.ProgressMonitorWrapperImpl;
import org.soluvas.image.DavConnector;
import org.soluvas.image.ImageConnector;
import org.soluvas.image.ImageException;
import org.soluvas.image.ImageFactory;
import org.soluvas.image.ImageTransform;
import org.soluvas.image.ImageTransformer;
import org.soluvas.image.ImageVariant;
import org.soluvas.image.UploadedImage;
import org.soluvas.image.impl.DavConnectorImpl;
import org.soluvas.image.impl.ImageMagickTransformerImpl;
import org.soluvas.image.impl.ResizeToFillImpl;
import org.soluvas.image.impl.ResizeToFitImpl;
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
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
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
	
	private static final Logger log = LoggerFactory.getLogger(MongoImageRepository.class);
	
	private String namespace;
	private String mongoUri;
	private DBCollection mongoColl;
	private final Map<String, ImageStyle> styles = new ConcurrentHashMap<String, ImageStyle>();
	
	private DavConnector innerConnector;
	private ImageConnector connector;
	private ImageTransformer transformer;

	private List<String> mongoHosts;
	private String mongoDatabase;
	
	/**
	 * Map between content type (image/jpeg) to extension (jpg); 
	 */
	private static final Map<String, String> supportedContentTypes = ImmutableMap.of(
			"image/jpeg", "jpg",
			"image/png", "png",
			"image/gif", "gif");

	// should be network executor, to perform mongodb operations concurrently
	// although probably better to do it in bulk instead, or both (i.e. 32 bulk inserts in the executor, of 10 documents each)
	private final ListeningExecutorService executor = MoreExecutors.sameThreadExecutor();
	
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
//		this.transformer = new ThumbnailatorTransformerImpl(innerConnector);
		this.transformer = new ImageMagickTransformerImpl(innerConnector);
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
		mongoHosts = mongoUriDetail.getHosts();
		mongoDatabase = mongoUriDetail.getDatabase();
		try {
			log.info("Connecting to MongoDB {} database {}", mongoHosts, mongoDatabase);
			DB db = mongoUriDetail.connectDB();
			if (mongoUriDetail.getUsername() != null)
				db.authenticate(mongoUriDetail.getUsername(), mongoUriDetail.getPassword());
			String collName = namespace + "Image";
			log.info("Authenticated to MongoDB. Collection name is {}", collName);
			mongoColl = db.getCollection(collName);
			mongoColl.ensureIndex(new BasicDBObject("created", -1));
			mongoColl.ensureIndex(new BasicDBObject("creationTime", -1));
		} catch (Exception e) {
			throw new ImageException("Cannot connect to MongoDB "+ mongoHosts + " database " + mongoDatabase, e);
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
		final ImageStyle style = new ImageStyle(name, code, maxWidth, maxHeight);
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
			this.styles.put(style.getName(), style);
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
	
	/**
	 * @deprecated use {@link #add(Image)}.
	 * @see org.soluvas.image.store.ImageRepository#create(java.lang.String, java.io.InputStream, java.lang.String, long, java.lang.String)
	 */
	@Override @Deprecated
	public String create(String fileName, InputStream content, final String contentType, final long length, String name) throws IOException {
		final File originalFile = File.createTempFile(getNamespace() + "_", "_" + fileName);
		try {
			log.info("Saving original image ({} {} bytes) to temporary file {}", new Object[] { 
					contentType, length, originalFile });
			FileUtils.copyInputStreamToFile(content, originalFile);
			
			final ListenableFuture<String> imageIdFuture = doCreate(null, originalFile, contentType, originalFile.length(), name, fileName, true);
			return Futures.getUnchecked(imageIdFuture);
		} finally {
			log.info("Deleting temporary original image {}", originalFile);
			originalFile.delete();
		}
	}
	
	/**
	 * @see org.soluvas.image.store.ImageRepository#create(java.io.File, java.lang.String, java.lang.String)
	 * @deprecated Use {@link #add(Image)}. 
	 */
	@Override @Deprecated
	public String create(String imageId, File originalFile, final String contentType, String name) throws IOException {
		final ListenableFuture<String> imageIdFuture = doCreate(imageId, originalFile, contentType, originalFile.length(), name,
				originalFile.getName(), true);
		return Futures.getUnchecked(imageIdFuture);
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#add(org.soluvas.image.store.Image)
	 */
	@Override
	public String add(Image newImage) {
		return add(ImmutableList.of(newImage), new ProgressMonitorWrapperImpl(null)).get(0);
	}
	
	private static class OriginalUpload {
		final public File file;
		final public String imageId;
		final public String uri;
		final public String originUri;
		final public String fileName;
		final public String extension;
		final public String name;
		final public String contentType;
		final public long fileSize;
		public List<UploadedImage> transformeds;
		
		public OriginalUpload(File file, String imageId, String uri, String originUri,
				String fileName, String extension, String name,
				String contentType, long fileSize) {
			super();
			this.file = file;
			this.imageId = imageId;
			this.uri = uri;
			this.originUri = originUri;
			this.fileName = fileName;
			this.extension = extension;
			this.name = name;
			this.contentType = contentType;
			this.fileSize = fileSize;
		}
	}
	
	@Override
	public List<String> add(@Nonnull List<Image> newImages, final ProgressMonitor monitor) {
		// 1. Upload original images
		final List<ListenableFuture<OriginalUpload>> originalFutures = Lists.newArrayList();
		monitor.beginTask("Uploading " + newImages.size() + " original images", newImages.size());
		for (final Image newImage : newImages) {
			final ListenableFuture<OriginalUpload> imageIdFuture = doCreateOriginal(newImage.getId(), newImage.getOriginalFile(), newImage.getContentType(),
					newImage.getOriginalFile().length(), newImage.getName(),
					newImage.getOriginalFile().getName(), true);
			Futures.addCallback(imageIdFuture, new FutureCallback<OriginalUpload>() {
				@Override
				public void onSuccess(OriginalUpload original) {
					log.info("Added original image {} from {}", original.imageId, newImage);
					monitor.worked(1);
				}
				
				@Override
				public void onFailure(Throwable t) {
					log.error("Error adding original image " + newImage, t);
					monitor.worked(1, ProgressStatus.ERROR);
				}
			});
			originalFutures.add(imageIdFuture);
		}
		// use ArrayList because can contain nulls
		final ListenableFuture<List<OriginalUpload>> originalsFuture = Futures.successfulAsList(originalFutures);
		Futures.addCallback(originalsFuture, new FutureCallback<List<OriginalUpload>>() {
			@Override
			public void onSuccess(List<OriginalUpload> result) {
				log.info("Uploaded {} original images: {}", result.size(), result);
				monitor.done();
			}

			@Override
			public void onFailure(Throwable t) {
				monitor.done(ProgressStatus.ERROR);
				throw new ImageException("Cannot add " + originalFutures.size() + " images", t);
			}
		});
		
		// 2. Transform those original images (a local transformer may actually download the originals first,
		// please avoid!)
		final ListenableFuture<List<OriginalUpload>> transformedsFuture = Futures.transform(originalsFuture, new AsyncFunction<List<OriginalUpload>, List<OriginalUpload>>() {
			@Override
			public ListenableFuture<List<OriginalUpload>> apply(
					List<OriginalUpload> input) throws Exception {
				monitor.beginTask("Transforming " + input.size() + " images", input.size());
				final List<ListenableFuture<OriginalUpload>> transformedFutures = Lists.transform(input, new Function<OriginalUpload, ListenableFuture<OriginalUpload>>() {
					@Override @Nullable
					public ListenableFuture<OriginalUpload> apply(@Nullable final OriginalUpload input) {
						if (input == null) {
							monitor.worked(1, ProgressStatus.SKIPPED);
							return Futures.immediateFailedFuture(new ImageException("Null input"));
						}
						final ListenableFuture<OriginalUpload> transformFuture = doTransform(input);
						Futures.addCallback(transformFuture, new FutureCallback<OriginalUpload>() {
							@Override
							public void onSuccess(OriginalUpload transformed) {
								log.info("Transformed {} variants for {}", transformed.transformeds.size(), input.imageId);
								monitor.worked(1);
							}
							
							@Override
							public void onFailure(Throwable t) {
								log.error("Error transforming image " + input.imageId, t);
								monitor.worked(1, ProgressStatus.ERROR);
							}
						});
						return transformFuture;
					}
				});
				return Futures.successfulAsList(transformedFutures);
			}
		});
		Futures.addCallback(transformedsFuture, new FutureCallback<List<OriginalUpload>>() {
			@Override
			public void onSuccess(List<OriginalUpload> result) {
				log.info("Transformed {} images", result.size());
				monitor.done();
			}

			@Override
			public void onFailure(Throwable t) {
				monitor.done(ProgressStatus.ERROR);
				throw new ImageException("Cannot transform " + originalFutures.size() + " images", t);
			}
		});

		// 3. Insert to MongoDB
		final ListenableFuture<List<String>> imageIdsFuture = Futures.transform(transformedsFuture,
				new AsyncFunction<List<OriginalUpload>, List<String>>() {
			@Override
			public ListenableFuture<List<String>> apply(
					List<OriginalUpload> input) throws Exception {
				monitor.beginTask("Inserting " + input.size() + " MongoDB documents", input.size());
				final List<ListenableFuture<String>> imageIdFutures = Lists.transform(input, new Function<OriginalUpload, ListenableFuture<String>>() {
					@Override @Nullable
					public ListenableFuture<String> apply(@Nullable final OriginalUpload input) {
						if (input == null) {
							monitor.worked(1, ProgressStatus.SKIPPED);
							return Futures.immediateFailedFuture(new ImageException("Null input"));
						}
						final ListenableFuture<String> imageIdFuture = doInsertMongo(input);
						Futures.addCallback(imageIdFuture, new FutureCallback<String>() {
							@Override
							public void onSuccess(String imageId) {
								log.trace("Inserted image document {}", input.imageId);
								monitor.worked(1);
							}
							
							@Override
							public void onFailure(Throwable t) {
								log.error("Error inserting image document " + input.imageId, t);
								monitor.worked(1, ProgressStatus.ERROR);
							}
						});
						return imageIdFuture;
					}
				});
				return Futures.successfulAsList(imageIdFutures);
			}
		});
		Futures.addCallback(imageIdsFuture, new FutureCallback<List<String>>() {
			@Override
			public void onSuccess(List<String> result) {
				log.info("Inserted {} image documents: {}", result.size(),
						result);
				monitor.done();
			}

			@Override
			public void onFailure(Throwable t) {
				monitor.done(ProgressStatus.ERROR);
				throw new ImageException("Cannot insert " + originalFutures.size() + " documents", t);
			}
		});
		return Futures.getUnchecked(imageIdsFuture);
	}
	
	/**
	 * Performs the 1. upload original, 2. transform, 3. save to MongoDB, for one image, all in one {@link ListenableFuture} chain.
	 * @param existingImageId
	 * @param originalFile
	 * @param contentType
	 * @param length
	 * @param name
	 * @param originalName
	 * @param alsoUploadOriginal
	 * @return
	 */
	protected ListenableFuture<String> doCreate(String existingImageId, final File originalFile, final String contentType,
			final long length, final String name, final String originalName, boolean alsoUploadOriginal) {
		final ListenableFuture<OriginalUpload> originalFuture = doCreateOriginal(existingImageId, originalFile, contentType, length, name, originalName, alsoUploadOriginal);
		final ListenableFuture<OriginalUpload> transformedsFuture = Futures.transform(originalFuture, new AsyncFunction<OriginalUpload, OriginalUpload>() {
			@Override
			public ListenableFuture<OriginalUpload> apply(
					OriginalUpload original) throws Exception {
				return doTransform(original);
			}
		});
		final ListenableFuture<String> imageIdFuture = Futures.transform(transformedsFuture, new AsyncFunction<OriginalUpload, String>() {
			@Override
			public ListenableFuture<String> apply(OriginalUpload input)
					throws Exception {
				return doInsertMongo(input);
			}
		});
		return imageIdFuture;
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#doCreate(java.lang.String, java.io.File, java.lang.String, long, java.lang.String, java.lang.String, boolean)
	 */
	protected ListenableFuture<OriginalUpload> doCreateOriginal(String existingImageId, final File originalFile, final String contentType,
			final long length, final String name, final String originalName, boolean alsoUploadOriginal) {
		Preconditions.checkNotNull(originalFile, "Original file to be added must not be null");
		if (!originalFile.exists()) {
			return Futures.immediateFailedFuture(new FileNotFoundException("Original file " + originalFile + " not found"));
		}
		
//		final String seoName = name + " " + FilenameUtils.getBaseName(fileName);
		final String seoName1 = SlugUtils.generateId(name, 0);
		final String seoName2 = SlugUtils.generateId(FilenameUtils.getBaseName(originalName), 0);
		final String imageId = Optional.fromNullable(existingImageId).or( seoName1.equals(seoName2) ? seoName1 : seoName1 + "_" + seoName2 );
		String tmpExtension = StringUtils.lowerCase(FilenameUtils.getExtension(originalName));
		final String extension;
		if (Strings.isNullOrEmpty(tmpExtension)) {
			extension = supportedContentTypes.get(contentType);
			if (Strings.isNullOrEmpty(extension)) {
				throw new ImageException(String.format("Cannot get extension from originalName=%s for existingImageId=%s originalFile=%s, with unsupported content type %s, supported content types are: %s",
						originalName, existingImageId, originalFile, contentType, supportedContentTypes.keySet()));
			}
		} else {
			extension = tmpExtension;
		}
		
		log.debug("Adding image from {} ({} {} bytes) as {}, originalName={} extension={}",
				originalFile.getName(), contentType, length, imageId,
				originalName, extension);
		
		// <del>Upload originals last, so that unreadable images aren't uploaded at all</del>
		// Originals must be uploaded first, because Blitline transformer requires them!
		
		final ListenableFuture<OriginalUpload> original;
		
		if (alsoUploadOriginal) {
			final ListenableFuture<UploadedImage> originalUploadFuture = connector.upload(namespace, imageId, ORIGINAL_CODE, ORIGINAL_CODE, extension,
					originalFile, contentType);
			original = Futures.transform(originalUploadFuture, new Function<UploadedImage, OriginalUpload>() {
				@Override @Nullable
				public OriginalUpload apply(@Nullable UploadedImage originalUpload) {
					return new OriginalUpload(originalFile, imageId, originalUpload.getUri(), originalUpload.getOriginUri(),
							originalName, extension, name, contentType, length);
				}
			});
		} else {
			log.info("Not uploading original {} using {} because requested by caller (probably for reprocess)",
					imageId, connector.getClass().getName());
			original = Futures.immediateFuture(new OriginalUpload(
					originalFile, imageId,
					connector.getUri(namespace, imageId, ORIGINAL_CODE, ORIGINAL_CODE, extension),
					connector.getOriginUri(namespace, imageId, ORIGINAL_CODE, ORIGINAL_CODE, extension),
					originalName, extension, name, contentType, length));
		}
		
		return original;
	}
	
	protected ListenableFuture<OriginalUpload> doTransform(final OriginalUpload original) {
		final ImageVariant sourceVariant = ImageFactory.eINSTANCE.createImageVariant();
		sourceVariant.setStyleCode(ORIGINAL_CODE);
		sourceVariant.setStyleVariant(ORIGINAL_CODE);
		sourceVariant.setExtension(original.extension);
		final ImmutableMap.Builder<ImageTransform, ImageVariant> transformsBuilder = ImmutableMap.builder();
		for (final ImageStyle style : styles.values()) {
			final ImageTransform fx;
			if (style.getMaxWidth() != null && style.getMaxHeight() != null) {
				// create ResizeToFill if both maxWidth and maxHeight is filled
				fx = new ResizeToFillImpl(style.getMaxWidth(), style.getMaxHeight(), style.getGravity());
			} else {
				// otherwise assume ResizeToFit
				fx = new ResizeToFitImpl(style.getMaxWidth(), style.getMaxHeight());
			}
			final ImageVariant dest = ImageFactory.eINSTANCE.createImageVariant();
			dest.setStyleCode(style.getCode());
			// TODO: support variant
			dest.setStyleVariant(style.getCode());
			// TODO: don't hardcode extension
			dest.setExtension("jpg");
			transformsBuilder.put(fx, dest);
		}
		final Map<ImageTransform, ImageVariant> transforms = transformsBuilder.build();
		
//		final ListenableFuture<List<UploadedImage>> transformedsFuture = Futures.transform(original, new AsyncFunction<OriginalUpload, List<UploadedImage>>() {
//			@Override @Nullable
//			public ListenableFuture<List<UploadedImage>> apply(@Nullable OriginalUpload input) {
				// at this point, the original will have been uploaded, so Blitline can transform
		log.debug("Transforming {} into {} variants using {}", original.imageId,
				transforms.size(), transformer.getClass().getName());
		final ListenableFuture<List<UploadedImage>> transformedsFuture = transformer.transform(
				connector, original.file, namespace, original.imageId, sourceVariant, transforms);
		final ListenableFuture<OriginalUpload> updatedWipFuture = Futures.transform(transformedsFuture, new Function<List<UploadedImage>, OriginalUpload>() {
			@Override @Nullable
			public OriginalUpload apply(@Nullable List<UploadedImage> input) {
				original.transformeds = input;
				return original;
			}
		});
		return updatedWipFuture;
	}
	
	protected ListenableFuture<String> doInsertMongo(final OriginalUpload original) {
		// it's not possible to do it in bulk because it's an upsert, not insert, operation
		// although we definitely can use insert (or bulk remove first then bulk insert)
		// but image mongo is very fast anyway and also few documents, doesn't matter
		final ListenableFuture<String> imageIdFuture = executor.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				log.info("Got {} transformed images of {} from {}", original.transformeds.size(), original.imageId,
						transformer.getClass().getName());
				final BasicBSONObject stylesObj = new BasicBSONObject();
				for (final UploadedImage transformed : original.transformeds) {
//						StyledImage styled = Await.result(future, Timeout.never().duration());
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
				dbo.put("_id", original.imageId);
				dbo.put("name", original.name);
				dbo.put("uri", original.uri);
				dbo.put("originUri", original.originUri);
				dbo.put("fileName", original.fileName);
				dbo.put("contentType", original.contentType);
				dbo.put("extension", original.extension);
				dbo.put("size", original.fileSize);
				final Date creationTime = new Date();
				dbo.put("created", creationTime);
				dbo.put("creationTime", creationTime);
				dbo.put("styles", stylesObj);
				
				log.info("Upserting image {} ({}) metadata into MongoDB collection {}", 
						original.imageId, original.name, mongoColl.getName() );
				mongoColl.update(new BasicDBObject("_id", original.imageId), dbo, true, false);
				
				return original.imageId;
			}
		});
		return imageIdFuture;
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
		final DBCursor cursor = mongoColl.find().sort(new BasicDBObject("_id", "1"));
		try {
			final List<Image> images = ImmutableList.copyOf( Iterables.transform(cursor, new DBObjectToImage()) );
			return images;
		} finally {
			cursor.close();
		}
	}
	
	@Override
	public List<String> findAllIds() {
		final DBCursor cursor = mongoColl.find(new BasicDBObject(), new BasicDBObject("_id", 1))
				.sort(new BasicDBObject("_id", "1"));
		try {
			final List<String> imageIds = ImmutableList.copyOf( Iterables.transform(cursor, new Function<DBObject, String>() {
				@Override @Nullable
				public String apply(@Nullable DBObject input) {
					return (String) input.get("_id");
				}
			}));
			return imageIds;
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
		final List<ListenableFuture<String>> imageIdFutures = new ArrayList<>();
		for (final Image image : images) {
			final String extension = ImageUtils.getExtensionOrJpg(image.getFileName());
			try {
				// TODO: reprocessing should not require download (esp. for blitline transformer) 
				final File tempFile = File.createTempFile(image.getId(), "." + extension);
//				submon.beginTask("Fetching " + image.getId() + " from " + image.getUri() + " to " + tempFile, 1);
				log.info("Downloading {} from {} to {}", image.getId(), image.getUri(), tempFile);
				final boolean downloaded = connector.download(namespace, image.getId(), ORIGINAL_CODE, ORIGINAL_CODE,
						extension, tempFile);
				if (downloaded) {
					final ListenableFuture<String> imageIdFuture = doCreate(image.getId(), tempFile, image.getContentType(), tempFile.length(), image.getFileName(),
							image.getFileName(), false);
					Futures.addCallback(imageIdFuture, new FutureCallback<String>() {
						@Override
						public void onSuccess(String result) {
							deleteOriginal();
							log.info("Reprocessed {}", result);
							submon.worked(1);
						}

						@Override
						public void onFailure(Throwable t) {
							deleteOriginal();
							log.error("Cannot reprocess " + image.getId(), t);
							submon.worked(1, ProgressStatus.ERROR);
						}

						/**
						 * @param image
						 * @param tempFile
						 */
						protected void deleteOriginal() {
							log.trace("Deleting temporary file {} (image {})", tempFile, image.getId());
							tempFile.delete();
						}
					});
					imageIdFutures.add(imageIdFuture);
				} else {
					log.error("Cannot download {} because connector {} returned false",
							image.getId(), connector.getClass().getName());
					finalStatus = ProgressStatus.WARNING;
					submon.worked(1, ProgressStatus.ERROR);
				}
			} catch (Exception e) {
				// log, but continue
				log.error("Cannot reprocess image " + image.getId(), e);
				submon.worked(1, ProgressStatus.ERROR);
				finalStatus = ProgressStatus.ERROR;
			}
		}
		
		final ListenableFuture<List<String>> imageIdsFuture = Futures.successfulAsList(imageIdFutures);
		try {
			final List<String> imageIds = imageIdsFuture.get();
			log.info("Reprocessed {} images successfully out of {} requested: {}", imageIds.size(),
					images.size(), imageIds);
		} catch (InterruptedException | ExecutionException e) {
			log.error("Cannot reprocess {} images", images.size());
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
	
	@Override
	public String toString() {
		return "MongoImageRepository " + mongoHosts + "/" + mongoDatabase;
	}

}

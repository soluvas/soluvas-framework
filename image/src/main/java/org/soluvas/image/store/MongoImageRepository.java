package org.soluvas.image.store;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
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

import javax.annotation.Nullable;
import javax.annotation.PreDestroy;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.BasicBSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.ProgressMonitor;
import org.soluvas.commons.ProgressStatus;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.impl.ProgressMonitorImpl;
import org.soluvas.commons.impl.ProgressMonitorWrapperImpl;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.repository.PagingAndSortingRepositoryBase;
import org.soluvas.image.DavConnector;
import org.soluvas.image.ImageConnector;
import org.soluvas.image.ImageException;
import org.soluvas.image.ImageFactory;
import org.soluvas.image.ImageTransform;
import org.soluvas.image.ImageTransformer;
import org.soluvas.image.ImageVariant;
import org.soluvas.image.UploadedImage;
import org.soluvas.image.util.ImageUtils;
import org.soluvas.mongo.MongoUtils;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
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
public class MongoImageRepository extends PagingAndSortingRepositoryBase<Image, String> 
	implements ImageRepository {

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
	
	private final Logger log;
	
	private final String namespace;
	private final String mongoUri;
	private DBCollection mongoColl;
	private final Map<String, ImageStyle> styles = new ConcurrentHashMap<>();
	
	private DavConnector innerConnector;
	private final ImageConnector connector;
	private final ImageTransformer transformer;

	private final List<String> mongoHosts;
	private final String mongoDatabase;
	
	// should be network executor, to perform mongodb operations concurrently
	// although probably better to do it in bulk instead, or both (i.e. 32 bulk inserts in the executor, of 10 documents each)
	private final ListeningExecutorService executor = MoreExecutors.sameThreadExecutor();
	
	// URI: ~repo.publicUri~{namespace}/{styleCode}/{imageId}_{styleVariant}.{extension}
	public MongoImageRepository(String namespace, String mongoUri, ImageConnector connector,
			ImageTransformer transformer, List<ImageStyle> imageStyles) {
		super();
		this.namespace = namespace;
		this.mongoUri = mongoUri;
		this.connector = connector;
		this.transformer = transformer;
		setStyles(imageStyles);
		
		final MongoURI mongoUriDetail = new MongoURI(mongoUri);
		String collName = namespace + "Image";
		log = LoggerFactory.getLogger(MongoImageRepository.class.getName() + "/" + mongoUriDetail.getDatabase() + "/" + collName);
		log.info("Starting MongoImageRepository {} with {} styles", namespace, styles.size());
		
		// Sanity checks
		if (mongoUri == null || mongoUri.isEmpty())
			throw new ImageException("MongoDB URI for " + namespace + " Image Store cannot be empty");

		mongoHosts = mongoUriDetail.getHosts();
		mongoDatabase = mongoUriDetail.getDatabase();
		try {
			log.info("Connecting to MongoDB {} database {}", mongoHosts, mongoDatabase);
			DB db = mongoUriDetail.connectDB();
			if (mongoUriDetail.getUsername() != null)
				db.authenticate(mongoUriDetail.getUsername(), mongoUriDetail.getPassword());
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
	
	/**
	 * Ensure folders exists based on namespace and image styles.
	 * @todo Implement
	 */
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
	public Image create(String fileName, InputStream content, final String contentType, final long length, String name) throws IOException {
		final File originalFile = File.createTempFile(getNamespace() + "_", "_" + fileName);
		try {
			log.info("Saving original image ({} {} bytes) to temporary file {}",  
					contentType, length, originalFile );
			FileUtils.copyInputStreamToFile(content, originalFile);
			
			final ListenableFuture<Image> addedImageFuture = doCreate(null, originalFile, contentType, originalFile.length(), name, fileName, true);
			return Futures.getUnchecked(addedImageFuture);
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
	public Image create(String imageId, File originalFile, final String contentType, String name) throws IOException {
		final ListenableFuture<Image> imageIdFuture = doCreate(imageId, originalFile, contentType, originalFile.length(), name,
				originalFile.getName(), true);
		return Futures.getUnchecked(imageIdFuture);
	}

	@Override
	public <S extends Image> Collection<S> add(Collection<S> entities) {
		return add(ImmutableList.copyOf(entities), new ProgressMonitorWrapperImpl(null));
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
	public <S extends Image> List<S> add(Collection<S> newImages, final ProgressMonitor monitor) {
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
		final ListenableFuture<List<Image>> imageIdsFuture = Futures.transform(transformedsFuture,
				new AsyncFunction<List<OriginalUpload>, List<Image>>() {
			@Override
			public ListenableFuture<List<Image>> apply(
					List<OriginalUpload> input) throws Exception {
				monitor.beginTask("Inserting " + input.size() + " MongoDB documents", input.size());
				final List<ListenableFuture<Image>> imageIdFutures = Lists.transform(input, 
						new Function<OriginalUpload, ListenableFuture<Image>>() {
					@Override @Nullable
					public ListenableFuture<Image> apply(@Nullable final OriginalUpload input) {
						if (input == null) {
							monitor.worked(1, ProgressStatus.SKIPPED);
							return Futures.immediateFailedFuture(new ImageException("Null input"));
						}
						final ListenableFuture<Image> imageIdFuture = doInsertMongo(input);
						Futures.addCallback(imageIdFuture, new FutureCallback<Image>() {
							@Override
							public void onSuccess(Image image) {
								log.trace("Inserted image document {}", image.getId());
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
		Futures.addCallback(imageIdsFuture, new FutureCallback<List<Image>>() {
			@Override
			public void onSuccess(List<Image> result) {
				log.info("Inserted {} image documents: {}", result.size(),
						Lists.transform(result, new IdFunction()));
				monitor.done();
			}

			@Override
			public void onFailure(Throwable t) {
				monitor.done(ProgressStatus.ERROR);
				throw new ImageException("Cannot insert " + originalFutures.size() + " documents", t);
			}
		});
		return (List) Futures.getUnchecked(imageIdsFuture);
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
	protected ListenableFuture<Image> doCreate(String existingImageId, final File originalFile, final String contentType,
			final long length, final String name, final String originalName, boolean alsoUploadOriginal) {
		final ListenableFuture<OriginalUpload> originalFuture = doCreateOriginal(existingImageId, originalFile, contentType, length, name, originalName, alsoUploadOriginal);
		final ListenableFuture<OriginalUpload> transformedsFuture = Futures.transform(originalFuture, new AsyncFunction<OriginalUpload, OriginalUpload>() {
			@Override
			public ListenableFuture<OriginalUpload> apply(
					OriginalUpload original) throws Exception {
				return doTransform(original);
			}
		});
		final ListenableFuture<Image> addedImageFuture = Futures.transform(transformedsFuture, 
				new AsyncFunction<OriginalUpload, Image>() {
			@Override
			public ListenableFuture<Image> apply(OriginalUpload input)
					throws Exception {
				return doInsertMongo(input);
			}
		});
		return addedImageFuture;
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#doCreate(java.lang.String, java.io.File, java.lang.String, long, java.lang.String, java.lang.String, boolean)
	 */
	protected ListenableFuture<OriginalUpload> doCreateOriginal(String existingImageId, final File originalFile, final String upContentType,
			final long length, final String name, final String originalName, boolean alsoUploadOriginal) {
		Preconditions.checkNotNull(originalFile, "Original file to be added must not be null");
		if (!originalFile.exists()) {
			return Futures.immediateFailedFuture(new FileNotFoundException("Original file " + originalFile + " not found"));
		}
		
//		final String seoName = name + " " + FilenameUtils.getBaseName(fileName);
		final String seoName1 = SlugUtils.generateId(name, 0);
		final String seoName2 = SlugUtils.generateId(FilenameUtils.getBaseName(originalName), 0);
		final String imageId = Optional.fromNullable(existingImageId).or( seoName1.equals(seoName2) ? seoName1 : seoName1 + "_" + seoName2 );
		
		// guess content type if necessary
		final String contentType;
		// content type must be valid "image/*" types
		if (upContentType != null && upContentType.startsWith("image/")) {
			contentType = upContentType;
		} else {
			// if necessary, guess content type via JDK7 Probe (extension is not reliable)
			try {
				contentType = Files.probeContentType(originalFile.toPath());
			} catch (IOException e) {
				throw new ImageException(String.format("Cannot guess content type from originalName='%s' for existingImageId='%s' originalFile='%s', " +
						"with unsupported provided content type '%s', supported content types are: %s",
						originalName, existingImageId, originalFile, upContentType, ImageUtils.supportedContentTypes.keySet()),
						e);
			}
		}
		// guess extension if necessary
		String upExtension = StringUtils.lowerCase(FilenameUtils.getExtension(originalName));
		final String extension;
		if (Strings.isNullOrEmpty(upExtension)) {
			extension = ImageUtils.supportedContentTypes.get(contentType);
			if (Strings.isNullOrEmpty(extension)) {
				throw new ImageException(String.format("Cannot get extension from originalName='%s' for existingImageId='%s' originalFile='%s', " +
						"with unsupported content type '%s', supported content types are: %s",
						originalName, existingImageId, originalFile, contentType, ImageUtils.supportedContentTypes.keySet()));
			}
		} else {
			extension = upExtension;
		}
		
		// last sanity check, whatever you do up there, we NEED contentType AND extension
		Preconditions.checkArgument(!Strings.isNullOrEmpty(contentType), "Failed to get content type for %s (%s bytes) as %s",
				originalFile, length, imageId);
		Preconditions.checkArgument(!Strings.isNullOrEmpty(extension), "Failed to get extension for %s (%s bytes) as %s",
				originalFile, length, imageId);
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
			final ImageTransform fx = style.getTransform();
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
	
	protected ListenableFuture<Image> doInsertMongo(final OriginalUpload original) {
		// it's not possible to do it in bulk because it's an upsert, not insert, operation
		// although we definitely can use insert (or bulk remove first then bulk insert)
		// but image mongo is very fast anyway and also few documents, doesn't matter
		final ListenableFuture<Image> imageIdFuture = executor.submit(new Callable<Image>() {
			@Override
			public Image call() throws Exception {
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
				
				final Image addedImage = new Image(original.imageId, null, original.contentType, original.name);
				return addedImage;
			}
		});
		return imageIdFuture;
	}
	
	@Override
	public long deleteIds(Collection<String> ids) {
		log.info("Deleting {} {} images: {}", ids.size(), namespace, ids);
		long deleted = 0;
		for (String id : ids) {
			final Image image = findOne(id);
			if (image == null) {
				log.warn("Not deleting non-existing {} image {}", namespace, id);
				continue;
			}

			// --------- Delete styleds --------
//			Future<Iterable<StatusLine>> styledsFuture = Futures.traverse(image.getStyles().values(), new Function<StyledImage, Future<StatusLine>>() {
//			@Override
//			public Future<StatusLine> apply(final StyledImage styled) {
//				return Futures.future(new Callable<StatusLine>() {
//					@Override
//					public StatusLine call() throws Exception {
//						log.info("Deleting {} image {} - {}: {}",  
//								namespace, id, styled.getStyleName(), styled.getUri() );
//						HttpDelete deleteThumb = new HttpDelete(styled.getUri());
//						try {
//							HttpResponse response = client.execute(davHost, deleteThumb, createHttpContext());
//							final StatusLine statusLine = response.getStatusLine();
//							HttpClientUtils.closeQuietly(response);
//							log.info("Delete {} returned: {}", styled.getUri(), statusLine);
//							return statusLine;
//						} catch (Exception e) {
//							log.error("Error deleting "+ styled.getUri(), e);
//							return null;
//						}
//					}
//				}, system.dispatcher());
//			}
//		}, system.dispatcher());

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
		//		log.info("Delete styled {} image {} status codes: {}", namespace, id, statuses );
		//		StatusLine status = Await.result(originalFuture, Duration.create(60, TimeUnit.SECONDS));
		//		log.info("Delete original {} image {} status code: {}", namespace, id, status );
			} catch (Exception e) {
				log.error("Error deleting " + namespace + " image " + id + " from WebDAV", e);
			}

		// -------- Delete originals -------
//			Future<StatusLine> originalFuture = Futures.future(new Callable<StatusLine>() {
//				@Override
//				public StatusLine call() throws Exception {
//					URI originalUri = image.getUri();
//					log.info("Deleting {} image {} - original: {}", 
//							namespace, id, originalUri );
//					HttpDelete deleteOriginal = new HttpDelete(originalUri);
//					try {
//						HttpResponse response = client.execute(davHost, deleteOriginal, createHttpContext());
//						final StatusLine statusLine = response.getStatusLine();
//						log.info("Delete {} returned: {}", originalUri, statusLine);
//						HttpClientUtils.closeQuietly(response);
//						return statusLine;
//					} catch (Exception e) {
//						log.error("Error deleting "+ originalUri, e);
//						return null;
//					}
//				}
//			}, system.dispatcher());

			final String originalUri = image.getUri();
			log.info("Deleting {} image {} - original: {}", 
					namespace, id, originalUri);
			// TODO: should store extension of original, also the styleds
			final String fileName = image.getFileName();
			final String originalExtension = !Strings.isNullOrEmpty(fileName) ? FilenameUtils.getExtension(fileName) : "jpg";
			connector.delete(namespace, id, ImageRepository.ORIGINAL_CODE, ImageRepository.ORIGINAL_CODE, originalExtension);
			
			log.debug("Deleting {} image metadata {}", namespace, id);
			try {
				mongoColl.remove(new BasicDBObject("_id", id));
			} catch (Exception e) {
				log.error("Error deleting " + namespace + " image metadata " + id, e);
			}
			
			deleted++;
		}
		return deleted;
	}
	
	@Override
	public List<Image> findAll(Collection<String> ids) {
		return ImmutableList.copyOf(findAllByIds(ids).values());
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
			final Map<String, Image> images = Maps.uniqueIndex( Iterables.transform(dbCursor, new DBObjectToImage()), new Function<Image, String>() {
				@Override
				public String apply(Image input) {
					return input.getId();
				}
			});
			log.debug("Got {} {} images with IDs {}", 
					images.size(), namespace, ids );
			return images;
		} finally {
			dbCursor.close();
		}
	}
	
	@Override
	public Page<Image> findAll(Pageable pageable) {
		final BasicDBObject sortDbo = MongoUtils.getSort(pageable.getSort(), "modificationTime", -1);
		final DBCursor cursor = mongoColl.find().sort(sortDbo)
				.skip((int) pageable.getOffset()).limit((int) pageable.getPageSize());
		try {
			final List<Image> images = ImmutableList.copyOf( Iterables.transform(cursor, new DBObjectToImage()) );
			return new PageImpl<>(images, pageable, mongoColl.count());
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
		submon.subTask("Reprocessing " + images.size() + " images");
		ProgressStatus finalStatus = ProgressStatus.OK;
		final List<ListenableFuture<Image>> addedImageFutures = new ArrayList<>();
		for (final Image image : images) {
			final String extension = ImageUtils.getExtensionOrJpg(image.getFileName());
			try {
				// TODO: reprocessing should not require download (esp. for blitline transformer) 
				final File tempFile = File.createTempFile(image.getId(), "." + extension);
//				submon.beginTask("Fetching " + image.getId() + " from " + image.getUri() + " to " + tempFile, 1);
				log.info("Downloading {} from {} to {}", image.getId(), image.getUri(), tempFile);
				final boolean downloaded = connector.download(namespace, image.getId(), ORIGINAL_CODE, ORIGINAL_CODE,
						extension, tempFile);
				log.debug("donwnload status for image {} is {}", image.getId(), downloaded);
				if (downloaded) {
					final ListenableFuture<Image> imageIdFuture = doCreate(image.getId(), tempFile, image.getContentType(), tempFile.length(), image.getFileName(),
							image.getFileName(), false);
					Futures.addCallback(imageIdFuture, new FutureCallback<Image>() {
						@Override
						public void onSuccess(Image result) {
							deleteOriginal();
							log.info("Reprocessed {}", result.getId());
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
					addedImageFutures.add(imageIdFuture);
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
		
		final ListenableFuture<List<Image>> addedImagesFuture = Futures.successfulAsList(addedImageFutures);
		try {
			final List<Image> addedImages = addedImagesFuture.get();
			log.info("Reprocessed {} images successfully out of {} requested", addedImages.size(),
					images.size());
		} catch (InterruptedException | ExecutionException e) {
			log.error("Cannot reprocess {} images", images.size());
		}
		
//		submon.done(finalStatus); // TODO: shouldn't be done in proper implementation
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#reprocessAll()
	 */
	@Override
	public void reprocessAll(ProgressMonitor monitor) {
		final long imageCount = count();
		log.debug("discover {} images", imageCount);
		final ProgressMonitor submon = ProgressMonitorImpl.convert(monitor, (int) imageCount);
		submon.beginTask("Processing " + imageCount + " " + namespace + " images", imageCount);
		final long totalPages = (imageCount + 99) / 100;
		int i = 0;
		for (int page = 0; page < totalPages; page++) {
			final Page<Image> images = findAll(new PageRequest(page, 100L));
			doReprocess(images.getContent(), monitor);
		}
		submon.done();
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

	/**
	 * Note: For now Akka is not used, but for backwards compatibility it is simply ignored.
	 * @param system the Akka actor system to set
	 */
//	public void setSystem(ActorSystem system) {
//		this.system = system;
//	}
	public void setSystem(Object system) {
	}

	@Override
	public void updateUriAll(ProgressMonitor monitor) {
		final long imageCount = count();
		log.debug("discover {} images", imageCount);
		final ProgressMonitor submon = ProgressMonitorImpl.convert(monitor, (int) imageCount);
		submon.beginTask("Updating " + imageCount + " " + namespace + " image URIs", imageCount);
		final long totalPages = (imageCount + 99) / 100;
		int i = 0;
		for (int page = 0; page < totalPages; page++) {
			final Page<Image> images = findAll(new PageRequest(page, 100L));
			doUpdateUri(images.getContent(), submon);
		}
		submon.done();
	}

	protected void doUpdateUri(final Collection<Image> images, ProgressMonitor monitor) {
		log.info("Updating {} {} image URIs", images.size(), namespace);
//		final ProgressMonitor submon = ProgressMonitorImpl.convert(monitor, 2);
		monitor.subTask("Updating URIs for " + images.size() + " images");
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
			monitor.worked(1);
		}
//		submon.done(); // TODO: shouldn't be done in proper implementation
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
	public String toString() {
		return "MongoImageRepository " + mongoHosts + "/" + mongoDatabase;
	}

	@Override
	public long count() {
		return mongoColl.count();
	}

	@Override @Nullable
	protected String getId(Image entity) {
		return entity.getId();
	}

	@Override
	public <S extends Image> Collection<S> modify(Map<String, S> entities) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<String> exists(Collection<String> ids) {
		log.trace("Exists {} {} images? {}", ids.size(), namespace, ids);
		final Set<String> existingIds = ImmutableSet.copyOf(MongoUtils.transform(mongoColl.find(new BasicDBObject("_id", new BasicDBObject("$in", ids)),
				new BasicDBObject("_id", 1)).sort(new BasicDBObject("_id", 1)),
				new Function<DBObject, String>() {
			@Override @Nullable
			public String apply(@Nullable DBObject input) {
				return (String) input.get("_id");
			}
		}));
		log.trace("{} out of {} asked {} images exist: {}", 
				existingIds.size(), ids.size(), namespace, existingIds);
		return existingIds;
	}

	@Override
	public Page<String> findAllIds(Pageable pageable) {
		final BasicDBObject sortDbo = MongoUtils.getSort(pageable.getSort(), "modificationTime", -1);
		final DBCursor cursor = mongoColl.find(new BasicDBObject(), new BasicDBObject("_id", 1))
				.sort(sortDbo).skip((int) pageable.getOffset()).limit((int) pageable.getPageSize());
		try {
			final List<String> imageIds = ImmutableList.copyOf( Iterables.transform(cursor,
					new Function<DBObject, String>() {
				@Override @Nullable
				public String apply(@Nullable DBObject input) {
					return (String) input.get("_id");
				}
			}) );
			return new PageImpl<>(imageIds, pageable, mongoColl.count());
		} finally {
			cursor.close();
		}
	}

}

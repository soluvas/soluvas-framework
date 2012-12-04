package org.soluvas.image.store;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

import javax.annotation.Nullable;
import javax.annotation.PreDestroy;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.bson.BasicBSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.SlugUtils;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.base.Throwables;
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
	
	/**
	 * Name of the predefined "original" image style.
	 */
	public static String ORIGINAL_NAME = "original";
	/**
	 * Short code for predefined "original" image style.
	 */
	public static String ORIGINAL_CODE = "o";
	private String namespace;
	private String davUri;
	private String safeDavUri;
	private HttpHost davHost;
	private String publicUri;
	private String mongoUri;
	private DBCollection mongoColl;
	private final DefaultHttpClient client = new DefaultHttpClient(new PoolingClientConnectionManager());
	private final Map<String, ImageStyle> styles = new ConcurrentHashMap<String, ImageStyle>();
	
	private String maleDefaultPhotoID;
	private String femaleDefaultPhotoID;
	private String defaultPhotoID;
	
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
	
	public MongoImageRepository(String namespace, String davUri, String publicUri,
			String mongoUri) {
		super();
		this.namespace = namespace;
		this.davUri = davUri;
		this.publicUri = publicUri;
		this.mongoUri = mongoUri;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#init()
	 */
	@Override
	public void init() {
		log.info("Starting MongoImageRepository {}", namespace);
		
		// Sanity checks
		if (davUri == null || davUri.isEmpty())
			throw new RuntimeException("DAV URI for " + namespace + " Image Store cannot be empty");
		if (publicUri == null || publicUri.isEmpty())
			throw new RuntimeException("Public URI for " + namespace + " Image Store cannot be empty");
		if (mongoUri == null || mongoUri.isEmpty())
			throw new RuntimeException("MongoDB URI for " + namespace + " Image Store cannot be empty");

		URI davUriDetail = URI.create(davUri);
		final String userInfo = davUriDetail.getUserInfo();
		if (!Strings.isNullOrEmpty(userInfo)) {
			String username = userInfo;
			String password = "";
			if (userInfo.contains(":")) {
				String[] splitted = userInfo.split(":");
				username = splitted[0];
				password = splitted[1];
			}
			UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
			client.getCredentialsProvider().setCredentials(AuthScope.ANY, credentials);
		}
		davHost = new HttpHost(davUriDetail.getHost(), davUriDetail.getPort() != -1 ? davUriDetail.getPort() : 80, davUriDetail.getScheme());
		try {
			safeDavUri = new URIBuilder(davUri).setUserInfo(null).build().toString();
		} catch (URISyntaxException e1) {
			Throwables.propagate(e1);
		}
		
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
			throw new RuntimeException("Cannot connect to MongoDB "+ mongoUriDetail.getHosts() + " database " + mongoUriDetail.getDatabase(), e);
		}
		
		createFolders();
		
		// Start actors
//		if (system == null) {
//			shutdownActorSystem = true;
//			system = ActorSystem.create("MongoImageRepository");
//		}
	}
	
	/**
	 * Create {@link HttpContext} with {@link AuthCache} pre-populated,
	 * since HttpClient does not allow HttpContext to be shared among threads.
	 * @return
	 */
	protected HttpContext createHttpContext() {
		BasicHttpContext httpContext = new BasicHttpContext();
		BasicAuthCache authCache = new BasicAuthCache();
		authCache.put(davHost, new BasicScheme());
		httpContext.setAttribute(ClientContext.AUTH_CACHE, authCache);
		return httpContext;
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#destroy()
	 */
	@Override
	@PreDestroy public void destroy() {
		log.info("Shutting down MongoImageRepository {}", namespace);
//		if (shutdownActorSystem && system != null) {
//			system.shutdown();
//			system.awaitTermination();
//		}
		client.getConnectionManager().shutdown();
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
		if ("o".equals(code))
			throw new RuntimeException("Cannot use code 'o' for image style");
		log.info("Added image style {}:{} {}x{}", new Object[] { 
				code, name, maxWidth, maxHeight });
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
	 * @see org.soluvas.image.store.ImageRepository#getImageDavUri(java.lang.String, java.lang.String)
	 */
	@Override
	public URI getImageDavUri(String id, String styleName) {
		String extension = "jpg";
		ImageStyle style = styles.get(styleName);
		return URI.create(String.format("%s%s/%s/%s_%s.%s", safeDavUri, namespace, style.getCode(), id, style.getCode(), extension));
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#getImagePublicUri(java.lang.String, java.lang.String)
	 */
	@Override
	public URI getImagePublicUri(String id, String styleName) {
		String extension = "jpg";
		String code = ORIGINAL_NAME.equals(styleName) ? ORIGINAL_CODE : styles.get(styleName).getCode(); 
		return URI.create(String.format("%s%s/%s/%s_%s.%s", publicUri, namespace, code, id, code, extension));
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#getDefaultUserImage(java.lang.String)
	 */
	@Override
	public String getDefaultUserImage(String gender) {
		log.debug("Current User Gender {}", gender);
		if (gender == "MALE")
			return this.getMaleDefaultPhotoID();
		else if (gender == "FEMALE")
			return this.getFemaleDefaultPhotoID();
		else 
			return "Unknown";
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
	public String create(File originalFile, final String contentType, String name) throws IOException {
		Preconditions.checkNotNull(originalFile, "Original file to be added must not be null");
		return doCreate(null, originalFile, contentType, originalFile.length(), name, originalFile.getName(), true);
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#add(org.soluvas.image.store.Image)
	 */
	@Override
	public String add(Image newImage) {
		try {
			return create(newImage.getOriginalFile(), newImage.getContentType(), newImage.getName());
		} catch (IOException e) {
			throw new RuntimeException("Error adding image " + newImage, e);
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
		
		log.debug("Adding image from {} ({} {} bytes) as {}", new Object[] {
				originalFile.getName(), contentType, length, imageId });
		
		try {
			// Create styles and upload
			Collection<StyledImage> styledImages = Collections2.transform(styles.values(), new com.google.common.base.Function<ImageStyle, StyledImage>() {
				@Override
				public StyledImage apply(final ImageStyle style) {
					File styledFile = null;
					int width;
					int height;
					try {
						// I don't think Thumbnailer and/or ImageIO is thread-safe
						synchronized (this) {
							styledFile = File.createTempFile(imageId + "_", "_" + style.getCode() + ".jpg");
							final boolean progressive = style.getMaxWidth() >= 512;
							log.info("Resizing {} to {}, quality={} progressive={}", new Object[] {
									originalFile, styledFile, style.getQuality(), progressive });
							BufferedImage styledImage = Thumbnails.of(originalFile)
									.size(style.getMaxWidth(), style.getMaxHeight())
									.crop(Positions.CENTER).asBufferedImage();
							width = styledImage.getWidth();
							height = styledImage.getHeight();
							log.info("Dimensions of {} is {}x{}", new Object[] { styledFile, width, height });
							ImageWriter jpegWriter = ImageIO.getImageWritersByFormatName("jpg").next();
							final FileImageOutputStream styledOutput = new FileImageOutputStream(styledFile);
							jpegWriter.setOutput(styledOutput);
							try {
								ImageWriteParam jpegParam = jpegWriter.getDefaultWriteParam();
								jpegParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
								jpegParam.setCompressionQuality(style.getQuality());
								// Enable progressive if width >= 512, else disable
								jpegParam.setProgressiveMode(progressive ? ImageWriteParam.MODE_DEFAULT : ImageWriteParam.MODE_DISABLED);
								jpegWriter.write(null, new IIOImage(styledImage, null, null), jpegParam);
//								ImageIO.write(styledImage, "jpg", styledFile); // no quality control
							} finally {
								styledOutput.close();
							}
						}
						
//						ByteArrayOutputStream buf = new ByteArrayOutputStream();
//						ImageIO.write(styledImage, "jpg", buf);
//						byte[] content = buf.toByteArray();
//						ResizeResult result = new ResizeResult(style.getName(), contentType, "jpg", content.length, content,
//								styledImage.getWidth(), styledImage.getHeight());
					} catch (Exception e) {
						throw new RuntimeException("Error resizing " + imageId + " to " + style.getCode() + ", destination: " + styledFile, e);
					}
					URI styledDavUri = getImageDavUri(imageId, style.getName());
					try {
						// upload directly for efficiency
						final String styledContentType = "image/jpeg";
						log.info("Uploading {} {} to {}", new Object[] { style.getName(), imageId, styledDavUri });
						uploadFile(styledDavUri, new FileInputStream(styledFile), styledContentType, styledFile.length());
						URI styledPublicUri = getImagePublicUri(imageId, style.getName());
						StyledImage styled = new StyledImage(style.getName(), style.getCode(), styledPublicUri, styledContentType,
								(int)styledFile.length(), width, height);
						return styled;
					} catch (Exception e) {
						throw new RuntimeException("Error uploading " + style.getName() + " " + imageId + " to " + styledDavUri, e);
					} finally {
						log.info("Deleting temporary {} image {}", style.getName(), styledFile);
						styledFile.delete();
					}
				}
			});

			// Upload originals last, so that unreadable images aren't uploaded at all
			if (alsoUploadOriginal) {
				final Callable<Object> uploadOriginal = new Callable<Object>() {
					@Override
					public Object call() throws Exception {
						final URI originalDavUri = URI.create(String.format("%s%s/%s/%s_%s.%s",
								safeDavUri, namespace, 'o', imageId, 'o', extension));
						try {
							uploadFile(originalDavUri, new FileInputStream(originalFile), contentType, length);
							return null;
						} catch (Exception e) {
							throw new RuntimeException("Error uploading original " + imageId + " to " + originalDavUri, e);
						}
					}
				};
				uploadOriginal.call();
			}
//			Future<Object> originalFuture = Futures.future(uploadOriginal, system.dispatcher());

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
//										throw new RuntimeException("Error uploading " + resized.styleName + " " + imageId + " to " + styledDavUri, e);
//									}
//								}
//							}, system.dispatcher());
//						}
//					});
//				}
//			});

//			Await.result(originalFuture, Timeout.never().duration());
			
			BasicBSONObject stylesObj = new BasicBSONObject();
			for (StyledImage styled : styledImages) {
//				StyledImage styled = Await.result(future, Timeout.never().duration());
				Map<String, Object> bson = new HashMap<String, Object>();
				bson.put("code", styled.getCode());
				bson.put("uri", styled.getUri().toString());
				bson.put("contentType", styled.getContentType());
				bson.put("size", styled.getSize());
				bson.put("width", styled.getWidth());
				bson.put("height", styled.getHeight());
				stylesObj.put(styled.getStyleName(), bson);
			}
			
			// Create mongoDB
			BasicDBObject dbo = new BasicDBObject();
			URI originalPublicUri = URI.create(String.format("%s%s/%s/%s_%s.%s",
					publicUri, namespace, 'o', imageId, 'o', extension));
			dbo.put("_id", imageId);
			dbo.put("name", name);
			dbo.put("uri", originalPublicUri.toString());
			dbo.put("fileName", originalName);
			dbo.put("contentType", contentType);
			dbo.put("size", (int)length);
			dbo.put("created", new Date());
			dbo.put("styles", stylesObj);
			
			log.info("Upserting image {} ({}) metadata into MongoDB collection {}", new Object[] { 
					imageId, name, mongoColl.getName() });
			mongoColl.update(new BasicDBObject("_id", imageId), dbo, true, false);
			
			return imageId;
		} catch (Exception e) {
			throw new RuntimeException("Error processing image " + imageId, e);
		}
	}
	
	/**
	 * 
	 * @param uri
	 * @param source
	 * @param contentType
	 * @param length
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @deprecated Can throw org.apache.http.client.NonRepeatableRequestException: Cannot retry request with a non-repeatable request entity.
	 * 		because InputStream can only be read once.
	 */
	@Deprecated
	protected void uploadFile(URI uri, InputStream source, String contentType, long length) throws ClientProtocolException, IOException {
		log.info("Uploading {} ({} bytes) to {}", new Object[] { contentType, length, uri });
		
		HttpPut httpPut = new HttpPut(uri);
		httpPut.setHeader("Content-Type", contentType);
		httpPut.setEntity(new InputStreamEntity(source, length));
		HttpResponse response = client.execute(davHost, httpPut, createHttpContext());
		try {
			if (response.getStatusLine().getStatusCode() >= 200 && response.getStatusLine().getStatusCode() < 300)
				log.info("Upload {} returned: {}", uri, response.getStatusLine());
			else
				log.error("Upload {} returned: {}", uri, response.getStatusLine());
		} finally {
			HttpClientUtils.closeQuietly(response);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#delete(java.lang.String)
	 */
	@Override
	public void delete(final String id) {
		final Image image = findOne(id);
		
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
		log.info("Deleting {} image {} - original: {}", new Object[] { 
				namespace, id, originalUri });
		HttpDelete deleteOriginal = new HttpDelete(originalUri);
		try {
			HttpResponse response = client.execute(davHost, deleteOriginal, createHttpContext());
			try {
				final StatusLine statusLine = response.getStatusLine();
				if (statusLine.getStatusCode() >= 200 && statusLine.getStatusCode() < 300)
					log.info("Delete {} returned: {}", originalUri, statusLine);
				else
					log.error("Delete {} returned: {}", originalUri, statusLine);
			} finally {
				HttpClientUtils.closeQuietly(response);
			}
		} catch (Exception e1) {
			log.error("Cannot delete " + namespace + " " + id + " - original: " + originalUri, e1);
		}
		
//		Future<Iterable<StatusLine>> styledsFuture = Futures.traverse(image.getStyles().values(), new Function<StyledImage, Future<StatusLine>>() {
//			@Override
//			public Future<StatusLine> apply(final StyledImage styled) {
//				return Futures.future(new Callable<StatusLine>() {
//					@Override
//					public StatusLine call() throws Exception {
//						log.info("Deleting {} image {} - {}: {}", new Object[] { 
//								namespace, id, styled.getStyleName(), styled.getUri() });
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
			log.info("Deleting {} image {} - {}: {}", new Object[] { 
					namespace, id, styled.getStyleName(), styled.getUri() });
			HttpDelete deleteThumb = new HttpDelete(styled.getUri());
			HttpResponse deleteThumbResp;
			try {
				deleteThumbResp = client.execute(davHost, deleteThumb, createHttpContext());
				try {
					log.info("Delete {} returned: {}", styled.getUri(), deleteThumbResp.getStatusLine());
				} finally {
					HttpClientUtils.closeQuietly(deleteThumbResp);
				}
			} catch (Exception e) {
				log.error("Cannot delete " + namespace + " image " + id + ": " + styled.getStyleName() + " at " + styled.getUri(), e);
			}
		}

		try {
//			Iterable<StatusLine> statuses = Await.result(styledsFuture, Duration.create(60, TimeUnit.SECONDS));
//			log.info("Delete styled {} image {} status codes: {}", new Object[] { namespace, id, statuses });
//			StatusLine status = Await.result(originalFuture, Duration.create(60, TimeUnit.SECONDS));
//			log.info("Delete original {} image {} status code: {}", new Object[] { namespace, id, status });
		} catch (Exception e) {
			log.error("Error deleting " + namespace + " image " + id + " from WebDAV", e);
		}

		log.debug("Deleting {} image metadata {}", namespace, id);
		try {
			mongoColl.remove(new BasicDBObject("_id", id));
		} catch (Exception e) {
			log.error("Error deleting " + namespace + " image metadata " + id, e);
		}
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#findOne(java.lang.String)
	 */
	@Override
	public Image findOne(String id) {
		log.trace("Get {} Image {}", namespace, id);
		if (id == null)
			return null;
		DBObject dbo = mongoColl.findOne(new BasicDBObject("_id", id));
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
	public void reprocess(Iterable<String> ids) {
		Map<String, Image> images = findAllByIds(ids);
		doReprocess(images.values());
	}

	/**
	 * @param images
	 */
	protected void doReprocess(Iterable<Image> images) {
		log.info("Reprocessing {} images", Iterables.size(images));
		for (Image image : images) {
			log.info("Downloading {} from {}", new Object[] { image.getId(), image.getUri() });
			HttpGet httpGet = new HttpGet(image.getUri());
			try {
				HttpResponse response = client.execute(davHost, httpGet, createHttpContext());
				try {
					if (response.getStatusLine().getStatusCode() >= 200 && response.getStatusLine().getStatusCode() < 300) {
						log.trace("Download {} successful: {}", image.getUri(), response.getStatusLine());
						File tempFile = File.createTempFile(image.getId(), ".tmp");
						log.info("Writing {} bytes to {}", response.getEntity().getContentLength(), tempFile);
						FileUtils.copyInputStreamToFile(response.getEntity().getContent(), tempFile);
						try {
							if (tempFile.length() != image.getSize())
								log.warn("Downloaded file size is {} bytes, expected {} bytes",
										tempFile.length(), image.getSize() );
							doCreate(image.getId(), tempFile, image.getContentType(), tempFile.length(), image.getFileName(),
									image.getFileName(), false);
						} catch (Exception e) {
							log.error("Cannot reprocess " + image.getId(), e);
						} finally {
							log.debug("Deleting {}", tempFile);
							tempFile.delete();
						}
					} else {
						log.error("Download {} returned: {}", image.getUri(), response.getStatusLine());
					}
				} finally {
					HttpClientUtils.closeQuietly(response);
				}
			} catch (Exception e) {
				// log, but continue
				log.error("Cannot download " + image.getId() + " from " + image.getUri(), e);
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#reprocessAll()
	 */
	@Override
	public void reprocessAll() {
		List<Image> images = findAll();
		doReprocess(images);
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#getNamespace()
	 */
	@Override
	public String getNamespace() {
		return namespace;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#setNamespace(java.lang.String)
	 */
	@Override
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#getDavUri()
	 */
	@Override
	public String getDavUri() {
		return davUri;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#setDavUri(java.lang.String)
	 */
	@Override
	public void setDavUri(String davUri) {
		this.davUri = davUri;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#getPublicUri()
	 */
	@Override
	public String getPublicUri() {
		return publicUri;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#setPublicUri(java.lang.String)
	 */
	@Override
	public void setPublicUri(String publicUri) {
		this.publicUri = publicUri;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#getMongoUri()
	 */
	@Override
	public String getMongoUri() {
		return mongoUri;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#setMongoUri(java.lang.String)
	 */
	@Override
	public void setMongoUri(String mongoUri) {
		this.mongoUri = mongoUri;
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

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#getMaleDefaultPhotoID()
	 */
	@Override
	public String getMaleDefaultPhotoID() {
		return maleDefaultPhotoID;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#getFemaleDefaultPhotoID()
	 */
	@Override
	public String getFemaleDefaultPhotoID() {
		return femaleDefaultPhotoID;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#setMaleDefaultPhotoID(java.lang.String)
	 */
	@Override
	public void setMaleDefaultPhotoID(String maleDefaultPhotoID) {
		this.maleDefaultPhotoID = maleDefaultPhotoID;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.image.store.ImageRepository#setFemaleDefaultPhotoID(java.lang.String)
	 */
	@Override
	public void setFemaleDefaultPhotoID(String femaleDefaultPhotoID) {
		this.femaleDefaultPhotoID = femaleDefaultPhotoID;
	}

	@Override
	public void deleteMultiple(Set<String> ids) {
		log.info("Multiple deleting images {}", ids);
		for (String id : ids) {
			delete(id);
		}
	}

	@Override
	public void updateUriAll() {
		final List<Image> images = findAll();
		doUpdateUri(images);
	}

	protected void doUpdateUri(final Collection<Image> images) {
		log.info("Updating {} {} image URIs", images.size(), namespace);
		for (Image image : images) {
			final URI newUri = getImagePublicUri(image.getId(), ORIGINAL_NAME);
			final BasicDBObject dbo = new BasicDBObject();
			dbo.put("uri", newUri.toString());
			log.debug("updating {} image {} to {}", namespace, image.getId(), newUri);
			mongoColl.update(new BasicDBObject("_id", image.getId()), new BasicDBObject("$set", dbo));
			
			final Map<String, StyledImage> imageStyles = image.getStyles();
			for (Entry<String, StyledImage> styleImage : imageStyles.entrySet()) {
				final String styleName = styleImage.getKey();
				final URI newStyleUri = getImagePublicUri(image.getId(), styleName);
				final BasicDBObject updatedStyleUri = new BasicDBObject("styles."+ styleName +".uri", newStyleUri.toString());
				log.debug("Updating {} image id {} to {} with style {}", namespace, image.getId(), newStyleUri, styleName);
				mongoColl.update(new BasicDBObject("_id", image.getId()), new BasicDBObject("$set", updatedStyleUri));
			}
		}
	}

	@Override
	public void updateUri(Collection<String> imageIds) {
		Collection<Image> images = Collections2.transform(imageIds, new Function<String, Image>() {
			@Override @Nullable
			public Image apply(@Nullable String imageId) {
				final Image image = findOne(imageId);
				Preconditions.checkNotNull(image, "Cannot find %s image with imageId %s", namespace, imageId);
				return image;
			}
		});
		doUpdateUri(images);
	}

}

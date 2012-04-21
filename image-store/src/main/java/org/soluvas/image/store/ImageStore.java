package org.soluvas.image.store;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import javax.annotation.PreDestroy;
import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.protocol.BasicHttpContext;
import org.bson.BasicBSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.slug.SlugUtils;

import akka.actor.ActorSystem;
import akka.dispatch.Await;
import akka.dispatch.Future;
import akka.dispatch.Futures;
import akka.dispatch.Mapper;
import akka.japi.Function;
import akka.japi.Function2;
import akka.util.Duration;
import akka.util.Timeout;

import com.google.common.collect.Iterables;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
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
 * ${davUri}/${namespace}/${shortCode}/${id}_${shortCode}.${extension}
 *
 * Usage:
 * 1. Set the following 4 properties: namespace, davUri, publicUri, mongoUri
 * 2. addStyle() as needed
 * 3. Additional 2 passwords during init().
 * 
 * @todo Make the name SEO friendly: prefix the UUID with the original name/title but slugged.
 */
public class ImageStore {

	private transient Logger log = LoggerFactory.getLogger(ImageStore.class);
	
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
	private String publicUri;
	private String mongoUri;
	private DBCollection mongoColl;
	private final DefaultHttpClient client = new DefaultHttpClient(new ThreadSafeClientConnManager());
	private final BasicHttpContext httpContext = new BasicHttpContext();
	private final Map<String, ImageStyle> styles = new ConcurrentHashMap<String, ImageStyle>();
	private ActorSystem system;
	/**
	 * If true, means the {@link ActorSystem} is owned by {@link ImageStore},
	 * and should be shutdown when ImageStore is destroyed.
	 */
	private boolean shutdownActorSystem = false;

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
	
	public void init(String davPassword) {
		log.info("Starting ImageStore {}", namespace);
		
		// Sanity checks
		if (davUri == null || davUri.isEmpty())
			throw new RuntimeException("DAV URI for " + namespace + " Image Store cannot be empty");
		if (publicUri == null || publicUri.isEmpty())
			throw new RuntimeException("Public URI for " + namespace + " Image Store cannot be empty");
		if (mongoUri == null || mongoUri.isEmpty())
			throw new RuntimeException("MongoDB URI for " + namespace + " Image Store cannot be empty");

		URI davUriDetail = URI.create(davUri);
		if (davUriDetail.getUserInfo() != null) {
			UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(davUriDetail.getUserInfo(), davPassword);
			client.getCredentialsProvider().setCredentials(AuthScope.ANY, credentials);
			BasicAuthCache authCache = new BasicAuthCache();
			authCache.put(new HttpHost(davUriDetail.getHost()), new BasicScheme());
			httpContext.setAttribute(ClientContext.AUTH_CACHE, authCache);
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
		} catch (Exception e) {
			throw new RuntimeException("Cannot connect to MongoDB "+ mongoUriDetail.getHosts() + " database " + mongoUriDetail.getDatabase(), e);
		}
		
		createFolders();
		
		// Start actors
		if (system == null) {
			shutdownActorSystem = true;
			system = ActorSystem.create("ImageStore");
		}
	}
	
	@PreDestroy public void destroy() {
		log.info("Shutting down ImageStore {}", namespace);
		if (shutdownActorSystem && system != null) {
			system.shutdown();
			system.awaitTermination();
		}
		client.getConnectionManager().shutdown();
		if (mongoColl != null) {
			mongoColl.getDB().cleanCursors(false);
		}
	}
	
	/**
	 * Ensure folders exists based on namespace and image styles.
	 * @todo Implement
	 */
	public void createFolders() {
		// TODO: Implement createFolderS()
	}
	
	/**
	 * Note that the shortCode 'o' (for "original") is reserved.
	 * @param name
	 * @param code
	 * @param maxWidth
	 * @param maxHeight
	 */
	public void addStyle(String name, String code, int maxWidth, int maxHeight) {
		if ("o".equals(code))
			throw new RuntimeException("Cannot use code 'o' for image style");
		log.info("Added image style {}:{} {}x{}", new Object[] { 
				code, name, maxWidth, maxHeight });
		ImageStyle style = new ImageStyle(name, code, maxWidth, maxHeight);
		styles.put(name, style);
	}
	
	/**
	 * Scheme: ${davUri}/${namespace}/${shortCode}/${id}_${shortCode}.${extension}
	 * 
	 * This only works for non-original image styles.
	 * 
	 * @return
	 */
	public URI getImageDavUri(String id, String styleName) {
		String extension = "jpg";
		ImageStyle style = styles.get(styleName);
		return URI.create(String.format("%s%s/%s/%s_%s.%s", davUri, namespace, style.getCode(), id, style.getCode(), extension));
	}
	
	/**
	 * Scheme: ${publicUri}/${namespace}/${shortCode}/${id}_${shortCode}.${extension}
	 * @return
	 */
	public URI getImagePublicUri(String id, String styleName) {
		String extension = "jpg";
		String code = styleName == ORIGINAL_NAME ? ORIGINAL_CODE : styles.get(styleName).getCode(); 
		return URI.create(String.format("%s%s/%s/%s_%s.%s", publicUri, namespace, code, id, code, extension));
	}
	
	/**
	 * Add an {@link Image} from an {@link InputStream}. This method makes use of a temporary file.
	 * @param fileName
	 * @param content
	 * @param contentType
	 * @param length
	 * @param name
	 * @return
	 * @throws IOException
	 */
	public String create(String fileName, InputStream content, final String contentType, final long length, String name) throws IOException {
		final File originalFile = File.createTempFile(getNamespace() + "_", "_" + fileName);
		try {
			log.info("Saving original image ({} {} bytes) to temporary file {}", new Object[] { 
					contentType, length, originalFile });
			FileUtils.copyInputStreamToFile(content, originalFile);
			
			return doCreate(originalFile, contentType, originalFile.length(), name, fileName);
		} finally {
			log.info("Deleting temporary original image {}", originalFile);
			originalFile.delete();
		}
	}
	
	public String create(File originalFile, final String contentType, String name) throws IOException {
		return doCreate(originalFile, contentType, originalFile.length(), name, originalFile.getName());
	}
	
	public String doCreate(final File originalFile, final String contentType, final long length, String name, String originalName) throws IOException {
//		final String seoName = name + " " + FilenameUtils.getBaseName(fileName);
		final String seoName1 = SlugUtils.generateId(name, 0);
		final String seoName2 = SlugUtils.generateId(FilenameUtils.getBaseName(originalName), 0);
		final String imageId = seoName1.equals(seoName2) ? seoName1 : seoName1 + "_" + seoName2;
		final String extension = FilenameUtils.getExtension(originalName);
		
		try {
			// Upload original
			Future<Object> originalFuture = Futures.future(new Callable<Object>() {
				@Override
				public Object call() throws Exception {
					final URI originalDavUri = URI.create(String.format("%s%s/%s/%s_%s.%s",
							davUri, namespace, 'o', imageId, 'o', extension));
					try {
						uploadFile(originalDavUri, new FileInputStream(originalFile), contentType, length);
						return null;
					} catch (Exception e) {
						throw new RuntimeException("Error uploading original " + imageId + " to " + originalDavUri, e);
					}
				}
			}, system.dispatcher());

			// Create styles
			Iterable<Future<ResizeResult>> styledFutures = Iterables.transform(styles.values(), new com.google.common.base.Function<ImageStyle, Future<ResizeResult>>() {
				@Override
				public Future<ResizeResult> apply(final ImageStyle style) {
					return Futures.future(new Callable<ResizeResult>() {
						@Override public ResizeResult call() throws Exception {
							File styledFile = File.createTempFile(imageId + "_", "_" + style.getCode() + ".jpg");
							try {
								log.info("Resizing {} to {}", originalFile, styledFile);
								BufferedImage styledImage = Thumbnails.of(originalFile).size(style.getMaxWidth(), style.getMaxHeight())
									.crop(Positions.CENTER).asBufferedImage();
								log.info("Dimensions of {} is {}x{}", new Object[] { styledFile, styledImage.getWidth(), styledImage.getHeight() });
								ByteArrayOutputStream buf = new ByteArrayOutputStream();
								ImageIO.write(styledImage, "jpg", buf);
								byte[] content = buf.toByteArray();
								ResizeResult result = new ResizeResult(style.getName(), "image/jpeg", "jpg", content.length, content,
										styledImage.getWidth(), styledImage.getHeight());
								return result;
							} catch (Exception e) {
								throw new RuntimeException("Error resizing " + imageId + " to " + style.getCode() + ", destination: " + styledFile, e);
							} finally {
								log.info("Deleting temporary {} image {}", style.getName(), styledFile);
								styledFile.delete();
							}
						}
					}, system.dispatcher());
				}
			});
			
			// Upload these thumbnails
			Iterable<Future<StyledImage>> uploadedFutures = Iterables.transform(styledFutures, new com.google.common.base.Function<Future<ResizeResult>, Future<StyledImage>>() {
				@Override
				public Future<StyledImage> apply(final Future<ResizeResult> styledFuture) {
					return styledFuture.flatMap(new Mapper<ResizeResult, Future<StyledImage>>() {
						@Override
						public Future<StyledImage> apply(final ResizeResult resized) {
							return Futures.future(new Callable<StyledImage>() {
								@Override public StyledImage call() throws Exception {
									URI styledDavUri = getImageDavUri(imageId, resized.styleName);
									try {
										log.info("Uploading {} {} to {}", new Object[] { resized.styleName, imageId, styledDavUri });
										uploadFile(styledDavUri, new ByteArrayInputStream(resized.content), resized.contentType, resized.length);
										URI styledPublicUri = getImagePublicUri(imageId, resized.styleName);
										ImageStyle style = styles.get(resized.styleName);
										StyledImage styled = new StyledImage(resized.styleName, style.getCode(), styledPublicUri, resized.contentType,
												(int)resized.length, resized.width, resized.height);
										return styled;
									} catch (Exception e) {
										throw new RuntimeException("Error uploading " + resized.styleName + " " + imageId + " to " + styledDavUri, e);
									}
								}
							}, system.dispatcher());
						}
					});
				}
			});

			Await.result(originalFuture, Timeout.never().duration());
			
			Future<BasicBSONObject> stylesFuture = Futures.fold(new BasicBSONObject(), uploadedFutures,
					new Function2<BasicBSONObject, StyledImage, BasicBSONObject>() {
						@Override
						public BasicBSONObject apply(BasicBSONObject obj, StyledImage styled) {
							Map<String, Object> styledObj = new HashMap<String, Object>();
							styledObj.put("code", styled.getCode());
							styledObj.put("uri", styled.getUri().toString());
							styledObj.put("contentType", styled.getContentType());
							styledObj.put("size", styled.getSize());
							styledObj.put("width", (Integer)styled.getWidth());
							styledObj.put("height", (Integer)styled.getHeight());
							synchronized (obj) {
								obj.put(styled.getStyleName(), styledObj);
							}
							return obj;
						}
					}, system.dispatcher());
			
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
			dbo.put("styles", Await.result(stylesFuture, Duration.Inf()));
			
			log.info("Inserting image {} ({}) metadata into MongoDB collection {}", new Object[] { 
					imageId, name, mongoColl.getName() });
			mongoColl.insert(dbo);
			return imageId;
				
		} catch (Exception e) {
			throw new RuntimeException("Error processing image " + imageId, e);
		}
	}
	
	protected void uploadFile(URI uri, InputStream source, String contentType, long length) throws ClientProtocolException, IOException {
		log.info("Uploading {} ({} bytes) to {}", new Object[] { contentType, length, uri });
		
		HttpPut httpPut = new HttpPut(uri);
		httpPut.setHeader("Content-Type", contentType);
		httpPut.setEntity(new InputStreamEntity(source, length));
		HttpResponse response = client.execute(httpPut, httpContext);
		if (response.getEntity() != null)
			response.getEntity().getContent().close();
		log.info("Upload {} returned: {}", uri, response.getStatusLine());
	}
	
	/**
	 * Delete the image with the specified ID, from the MongoDB metadata including all files and styled images from WebDAV.
	 * @param id Image ID.
	 */
	public void delete(final String id) {
		final Image image = findOne(id);
		
		Future<StatusLine> originalFuture = Futures.future(new Callable<StatusLine>() {
			@Override
			public StatusLine call() throws Exception {
				URI originalUri = image.getUri();
				log.info("Deleting {} image {} - original: {}", new Object[] { 
						namespace, id, originalUri });
				HttpDelete deleteOriginal = new HttpDelete(originalUri);
				try {
					HttpResponse response = client.execute(deleteOriginal, httpContext);
					if (response.getEntity() != null)
						response.getEntity().getContent().close();
					log.info("Delete {} returned: {}", originalUri, response.getStatusLine());
					return response.getStatusLine();
				} catch (Exception e) {
					log.error("Error deleting "+ originalUri, e);
					return null;
				}				
			}
		}, system.dispatcher());
		
		Future<Iterable<StatusLine>> styledsFuture = Futures.traverse(image.getStyles().values(), new Function<StyledImage, Future<StatusLine>>() {
			@Override
			public Future<StatusLine> apply(final StyledImage styled) {
				return Futures.future(new Callable<StatusLine>() {
					@Override
					public StatusLine call() throws Exception {
						log.info("Deleting {} image {} - {}: {}", new Object[] { 
								namespace, id, styled.getStyleName(), styled.getUri() });
						HttpDelete deleteThumb = new HttpDelete(styled.getUri());
						try {
							HttpResponse response = client.execute(deleteThumb, httpContext);
							if (response.getEntity() != null)
								response.getEntity().getContent().close();
							log.info("Delete {} returned: {}", styled.getUri(), response.getStatusLine());
							return response.getStatusLine();
						} catch (Exception e) {
							log.error("Error deleting "+ styled.getUri(), e);
							return null;
						}
					}
				}, system.dispatcher());
			}
		}, system.dispatcher());

		try {
			Iterable<StatusLine> statuses = Await.result(styledsFuture, Duration.create(60, TimeUnit.SECONDS));
			log.info("Delete styled {} image {} status codes: {}", new Object[] { namespace, id, statuses });
			StatusLine status = Await.result(originalFuture, Duration.create(60, TimeUnit.SECONDS));
			log.info("Delete original {} image {} status code: {}", new Object[] { namespace, id, status });
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

	public Image findOne(String id) {
		log.trace("Get {} Image {}", namespace, id);
		DBObject dbo = mongoColl.findOne(new BasicDBObject("_id", id));
		if (dbo == null)
			return null;
		return new Image(this, (BasicBSONObject)dbo);
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getDavUri() {
		return davUri;
	}

	public void setDavUri(String davUri) {
		this.davUri = davUri;
	}

	public String getPublicUri() {
		return publicUri;
	}

	public void setPublicUri(String publicUri) {
		this.publicUri = publicUri;
	}

	public String getMongoUri() {
		return mongoUri;
	}

	public void setMongoUri(String mongoUri) {
		this.mongoUri = mongoUri;
	}

	/**
	 * @param system the system to set
	 */
	public void setSystem(ActorSystem system) {
		this.system = system;
	}

}

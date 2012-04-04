package org.soluvas.image.store;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PreDestroy;
import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
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

import com.google.common.collect.Maps;
import com.google.common.collect.Maps.EntryTransformer;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
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
	private final Map<String, ImageStyle> styles = new HashMap<String, ImageStyle>();
	
	public void init(String davPassword, String mongoPassword) {
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
		
//		String dataDir = System.getenv("OPENSHIFT_DATA_DIR");
//		Properties props = new Properties();
//		if (dataDir != null) {
//			props.load(new FileReader(new File(dataDir, "aksimata.properties")));
//		} else {
//			props.load(ImageStore.class.getResourceAsStream("/aksimata.properties"));
//		}
//		davUser = props.getProperty("image.dav.user");
//		davPassword = props.getProperty("image.dav.password");
//		davUri = props.getProperty("image.dav.uri");
//		publicUri = props.getProperty("image.public.uri");
		
		log.info("Connecting to MongoDB {}", mongoUri);
		Mongo mongo;
		try {
			MongoURI mongoUriDetail = new MongoURI(mongoUri);
			mongo = new Mongo(mongoUriDetail);
			DB db = mongo.getDB(mongoUriDetail.getDatabase());
			if (mongoUriDetail.getUsername() != null) {
				db.authenticate(mongoUriDetail.getUsername(), mongoPassword.toCharArray());
			}
			String collName = namespace + "Image";
			log.info("Authenticated to MongoDB. Collection name is {}", collName);
			mongoColl = db.getCollection(collName);
		} catch (Exception e) {
			throw new RuntimeException("Cannot connect to MongoDB "+ mongoUri, e);
		}
		
		createFolders();
	}
	
	@PreDestroy public void destroy() {
		log.info("Shutting down ImageStore {}", namespace);
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
	
	public String create(String fileName, InputStream content, String contentType, long length, String name) throws IOException {
//		final String seoName = name + " " + FilenameUtils.getBaseName(fileName);
		final String seoName1 = SlugUtils.generateId(name, 0);
		final String seoName2 = SlugUtils.generateId(FilenameUtils.getBaseName(fileName), 0);
		final String imageId = seoName1.equals(seoName2) ? seoName1 : seoName1 + "_" + seoName2;
		final HashMap<String, StyledImage> styleds = new HashMap<String, StyledImage>();
		final String extension = FilenameUtils.getExtension(fileName);
		
		final File origFile = File.createTempFile(imageId + "_", "_o." + extension);
		log.info("Saving original image ({} {} bytes) to temporary file {}", new Object[] { 
				contentType, length, origFile });
		FileUtils.copyInputStreamToFile(content, origFile);
		try {
			// TODO: make these operations parallel
			URI originalDavUri = URI.create(String.format("%s%s/%s/%s_%s.%s",
					davUri, namespace, 'o', imageId, 'o', extension));
			uploadFile(originalDavUri, new FileInputStream(origFile), contentType, length);

			// Create styles and upload
			for (Entry<String, ImageStyle> kv : styles.entrySet()) {
				File styledFile = File.createTempFile(imageId + "_", "_" + kv.getValue().getCode() + ".jpg");
				try {
					log.info("Shrinking {} to {}", origFile, styledFile);
					BufferedImage styledImage = Thumbnails.of(origFile).size(kv.getValue().getMaxWidth(), kv.getValue().getMaxHeight())
						.asBufferedImage();
					log.info("Dimensions of {} is {}x{}", new Object[] { styledFile, styledImage.getWidth(), styledImage.getHeight() });
					ImageIO.write(styledImage, "jpg", styledFile);
					URI styledDavUri = getImageDavUri(imageId, kv.getValue().getName());
					uploadFile(styledDavUri, new FileInputStream(styledFile), "image/jpeg", styledFile.length());
					URI styledPublicUri = getImagePublicUri(imageId, kv.getKey());
					StyledImage styled = new StyledImage(kv.getKey(), kv.getValue().getCode(), styledPublicUri, "image/jpeg",
							(int)styledFile.length(), styledImage.getWidth(), styledImage.getHeight());
					styleds.put(kv.getKey(), styled);
				} finally {
					log.info("Deleting temporary {} image {}", kv.getValue().getName(), styledFile);
					styledFile.delete();
				}
			}
			
		} finally {
			log.info("Deleting temporary original image {}", origFile);
			origFile.delete();
		}

		// Create mongoDB
		log.info("Inserting image {} ({}) metadata into MongoDB collection {}", new Object[] { 
				imageId, name, mongoColl.getName() });
		BasicDBObject dbo = new BasicDBObject();
		URI originalPublicUri = URI.create(String.format("%s%s/%s/%s_%s.%s",
				publicUri, namespace, 'o', imageId, 'o', extension));
		dbo.put("_id", imageId);
		dbo.put("name", name);
		dbo.put("uri", originalPublicUri.toString());
		dbo.put("fileName", fileName);
		dbo.put("contentType", contentType);
		dbo.put("size", (int)length);
		dbo.put("created", new Date());
		Map<String, Map<String, Object>> styledImages = Maps.transformEntries(styleds, new EntryTransformer<String, StyledImage, Map<String, Object>>() {
			@Override
			public Map<String, Object> transformEntry(String key, StyledImage styled) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("code", styled.getCode());
				map.put("uri", styled.getUri().toString());
				map.put("contentType", styled.getContentType());
				map.put("size", styled.getSize());
				map.put("width", (Integer)styled.getWidth());
				map.put("height", (Integer)styled.getHeight());
				return map;
			}
		});
		dbo.put("styles", styledImages); 
		mongoColl.insert(dbo);
		return imageId;
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
	public void delete(String id) {
		Image image = findOne(id);
		// TODO: Implement concurrent deletion

		for (StyledImage styled : image.getStyles().values()) {
			log.info("Deleting {} image {} - {}: {}", new Object[] { 
					namespace, id, styled.getStyleName(), styled.getUri() });
			HttpDelete deleteThumb = new HttpDelete(styled.getUri());
			try {
				HttpResponse response = client.execute(deleteThumb, httpContext);
				if (response.getEntity() != null)
					response.getEntity().getContent().close();
				log.info("Delete {} returned: {}", styled.getUri(), response.getStatusLine());
			} catch (Exception e) {
				log.error("Error deleting "+ styled.getUri(), e);
			}
		}

		URI originalUri = image.getUri();
		log.info("Deleting {} image {} - original: {}", new Object[] { 
				namespace, id, originalUri });
		HttpDelete deleteOriginal = new HttpDelete(originalUri);
		try {
			HttpResponse response = client.execute(deleteOriginal, httpContext);
			if (response.getEntity() != null)
				response.getEntity().getContent().close();
			log.info("Delete {} returned: {}", originalUri, response.getStatusLine());
		} catch (Exception e) {
			log.error("Error deleting "+ originalUri, e);
		}

		log.debug("Deleting {} image metadata {}", namespace, id);
		try {
			mongoColl.remove(new BasicDBObject("_id", id));
		} catch (Exception e) {
			log.error("Error deleting "+ namespace + " image metadata " + id, e);
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

}

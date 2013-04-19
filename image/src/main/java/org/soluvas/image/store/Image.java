package org.soluvas.image.store;

import java.io.File;
import java.util.Map;

import javax.annotation.Nullable;

import org.bson.BasicBSONObject;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps.EntryTransformer;

/**
 * Image descriptor;
 * @deprecated Will be replaced by EMF {@link org.soluvas.image.Image}.
 * @author ceefour
 */
@Deprecated
public class Image {
	
	public static class ToId implements Function<Image, String> {
		@Override @Nullable
		public String apply(@Nullable Image input) {
			return input.getId();
		}
	}
	
	private static final Logger log = LoggerFactory.getLogger(Image.class);

	private String id;
	private String uri;
	private String originUri;
	private String contentType;
	private String fileName;
	private Long size;
	// TODO: Support original width and height
//	private int width;
//	private int height;
	private Map<String, StyledImage> styles;
	/**
	 * Only used for creating/uploading new image. Otherwise it's always null.
	 * @see MongoImageRepository#add(Image)
	 */
	private File originalFile;
	/**
	 * Only used for creating/uploading new image. Otherwise it's always null.
	 * @see MongoImageRepository#add(Image)
	 */
	private String name;
	private DateTime created;
	
	public Image() {
		super();
	}
	
	/**
	 * Convenience constructor for passing to {@link MongoImageRepository#add(Image)}.
	 * @param originalFile
	 * @param contentType
	 * @param name
	 */
	public Image(String id, File originalFile, String contentType, String name) {
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
	public Image(File originalFile, String contentType, String name) {
		this(null, originalFile, contentType, name);
	}

	public Image(ImageRepository imageStore, BasicBSONObject dbo) {
		super();
		id = dbo.getString("_id");
		name = dbo.getString("name");
		uri = imageStore.getImageUri(id, MongoImageRepository.ORIGINAL_NAME);
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
		styles = ImmutableMap.copyOf(Maps.transformEntries(
				stylesBson, new EntryTransformer<String, Object, StyledImage>() {
			@Override
			public StyledImage transformEntry(String key, Object value) {
				BasicBSONObject styleBson = (BasicBSONObject)value;
				final Long size = styleBson.get("size") != null ? styleBson.getLong("size") : null;
				return new StyledImage(key, styleBson.getString("code"),
						styleBson.getString("uri"),
						styleBson.getString("contentType"), size,
						styleBson.getInt("width"), styleBson.getInt("height"));
			}
		}));
		
		// v1 field but forgotten in API
		created = dbo.get("created") != null ? new DateTime(dbo.get("created")) : null;
		// v2 field
		originUri = dbo.get("originUri") != null ? dbo.getString("originUri") : uri.toString();
	}

	public String getId() {
		return id;
	}

	/**
	 * Public URI of the original image.
	 * @return
	 */
	public String getUri() {
		return uri;
	}
	
	/**
	 * @return the originUri
	 */
	public String getOriginUri() {
		return originUri;
	}

	/**
	 * @param originUri the originUri to set
	 */
	public void setOriginUri(String originUri) {
		this.originUri = originUri;
	}

	public String getContentType() {
		return contentType;
	}

	/**
	 * Only set this for new Images, do not set this on existing images.
	 * @param contentType
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getFileName() {
		return fileName;
	}

	public Long getSize() {
		return size;
	}

	public Map<String, StyledImage> getStyles() {
		return styles;
	}

	/**
	 * Only used for creating/uploading new image. Otherwise it's always null.
	 * @see MongoImageRepository#add(Image)
	 */
	public File getOriginalFile() {
		return originalFile;
	}

	/**
	 * Only used for creating/uploading new image. Otherwise it's always null.
	 * @see MongoImageRepository#add(Image)
	 */
	public void setOriginalFile(File originalFile) {
		this.originalFile = originalFile;
	}

	/**
	 * Only used for creating/uploading new image. Otherwise it's always null.
	 * @see MongoImageRepository#add(Image)
	 */
	public String getName() {
		return name;
	}

	/**
	 * Only used for creating/uploading new image. Otherwise it's always null.
	 * @see MongoImageRepository#add(Image)
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the created
	 */
	public DateTime getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(DateTime created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return String.format(
				"Image [id=%s, contentType=%s, fileName=%s, size=%d, uri=%s]",
				id, contentType, fileName, size, uri);
	}
	
}

package org.soluvas.image.store;

import java.io.File;
import java.net.URI;
import java.util.Map;

import org.bson.BasicBSONObject;

import com.google.common.collect.Maps;
import com.google.common.collect.Maps.EntryTransformer;

/**
 * @author ceefour
 * Image descriptor;
 */
public class Image {

	private String id;
	private URI uri;
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
	
	public Image() {
		super();
	}
	
	/**
	 * Convenience constructor for passing to {@link MongoImageRepository#add(Image)}.
	 * @param originalFile
	 * @param contentType
	 * @param name
	 */
	public Image(File originalFile, String contentType, String name) {
		super();
		this.originalFile = originalFile;
		this.contentType = contentType;
		this.name = name;
	}

	public Image(ImageRepository imageStore, BasicBSONObject dbo) {
		super();
		id = dbo.getString("_id");
		uri = imageStore.getImagePublicUri(id, MongoImageRepository.ORIGINAL_NAME);
		contentType = dbo.getString("contentType");
		fileName = dbo.getString("fileName");
		size = dbo.getLong("size");
//		width = dbo.getInt("width");
//		height = dbo.getInt("height");
		BasicBSONObject stylesBson = (BasicBSONObject) dbo.get("styles");
		styles = Maps.transformEntries(stylesBson, new EntryTransformer<String, Object, StyledImage>() {
			@Override
			public StyledImage transformEntry(String key, Object value) {
				BasicBSONObject styleBson = (BasicBSONObject)value;
				return new StyledImage(key, styleBson.getString("code"),
						URI.create(styleBson.getString("uri")),
						styleBson.getString("contentType"), styleBson.getInt("size"),
						styleBson.getInt("width"), styleBson.getInt("height"));
			}
		});
	}

	public String getId() {
		return id;
	}

	/**
	 * Public URI of the original image.
	 * @return
	 */
	public URI getUri() {
		return uri;
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

	@Override
	public String toString() {
		return String.format(
				"Image [id=%s, contentType=%s, fileName=%s, size=%d, uri=%s]",
				id, contentType, fileName, size, uri);
	}
	
}

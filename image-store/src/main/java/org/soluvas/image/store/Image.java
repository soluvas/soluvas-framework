/**
 * 
 */
package org.soluvas.image.store;

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
	private long size;
	// TODO: Support original width and height
//	private int width;
//	private int height;
	private Map<String, StyledImage> styles;
	
	public Image(ImageStore imageStore, BasicBSONObject dbo) {
		id = dbo.getString("_id");
		uri = imageStore.getImagePublicUri(id, ImageStore.ORIGINAL_NAME);
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

	public URI getUri() {
		return uri;
	}

	public String getContentType() {
		return contentType;
	}

	public String getFileName() {
		return fileName;
	}

	public long getSize() {
		return size;
	}

	public Map<String, StyledImage> getStyles() {
		return styles;
	}
	
}

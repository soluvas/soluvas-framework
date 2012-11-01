/**
 * 
 */
package org.soluvas.image.store;

import java.net.URI;

/**
 * @author ceefour
 *
 */
public class StyledImage {

	private String styleName;
	private String code;
	private URI uri;
	private String contentType;
	private int size;
	private int width;
	private int height;
	
	public StyledImage(String styleName, String code, URI uri,
			String contentType, int size, int width, int height) {
		super();
		this.styleName = styleName;
		this.code = code;
		this.uri = uri;
		this.contentType = contentType;
		this.size = size;
		this.width = width;
		this.height = height;
	}

	public String getStyleName() {
		return styleName;
	}

	public String getCode() {
		return code;
	}

	public URI getUri() {
		return uri;
	}

	public String getContentType() {
		return contentType;
	}

	public int getSize() {
		return size;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
}

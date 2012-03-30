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
	private char code;
	private URI uri;
	private String contentType;
	private long size;
	private int width;
	private int height;
	
	public StyledImage(String styleName, char code, URI uri,
			String contentType, long size, int width, int height) {
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

	public char getCode() {
		return code;
	}

	public URI getUri() {
		return uri;
	}

	public String getContentType() {
		return contentType;
	}

	public long getSize() {
		return size;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
}

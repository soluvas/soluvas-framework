package org.soluvas.image.store;

import java.net.URI;

/**
 * @author ceefour
 *
 */
@Deprecated
public class StyledImage {

	private final String styleName;
	private final String code;
	private final URI uri;
	private final String contentType;
	private final Long size;
	private final int width;
	private final int height;
	
	public StyledImage(String styleName, String code, URI uri,
			String contentType, Long size, int width, int height) {
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

	public Long getSize() {
		return size;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StyledImage ["
				+ (styleName != null ? "styleName=" + styleName + ", " : "")
				+ (code != null ? "code=" + code + ", " : "")
				+ (uri != null ? "uri=" + uri + ", " : "")
				+ (contentType != null ? "contentType=" + contentType + ", "
						: "") + (size != null ? "size=" + size + ", " : "")
				+ "width=" + width + ", height=" + height + "]";
	}
	
}

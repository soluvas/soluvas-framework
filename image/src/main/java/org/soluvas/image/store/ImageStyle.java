package org.soluvas.image.store;

import org.soluvas.image.TransformGravity;

/**
 * Description on how to process an image to a different style like thumbnail.
 * 
 * @author ceefour
 * 
 */
public class ImageStyle {

	private final String name;
	private final String code;
	private final int maxWidth;
	private final int maxHeight;
	private final float quality = 0.85f;
	private final TransformGravity gravity;

	public ImageStyle(String name, String code, int maxWidth, int maxHeight) {
		super();
		this.name = name;
		this.code = code;
		this.maxWidth = maxWidth;
		this.maxHeight = maxHeight;
		this.gravity = TransformGravity.CENTER;
	}
	
	/**
	 * @param name
	 * @param code
	 * @param maxWidth
	 * @param maxHeight
	 * @param gravity
	 */
	public ImageStyle(String name, String code, int maxWidth, int maxHeight,
			TransformGravity gravity) {
		super();
		this.name = name;
		this.code = code;
		this.maxWidth = maxWidth;
		this.maxHeight = maxHeight;
		this.gravity = gravity;
	}

	/**
	 * Lowercase 1 letter
	 * 
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * All lowercase more descriptive name, such as "original", "small",
	 * "thumbnail".
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Maximum width of this style.
	 * 
	 * @return
	 */
	public int getMaxWidth() {
		return maxWidth;
	}

	/**
	 * Maximum height of this style.
	 * 
	 * @return
	 */
	public int getMaxHeight() {
		return maxHeight;
	}

	public float getQuality() {
		return quality;
	}

	public TransformGravity getGravity() {
		return gravity;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ImageStyle [" + (name != null ? "name=" + name + ", " : "")
				+ (code != null ? "code=" + code + ", " : "") + "maxWidth="
				+ maxWidth + ", maxHeight=" + maxHeight + ", quality="
				+ quality + ", "
				+ (gravity != null ? "gravity=" + gravity : "") + "]";
	}

}

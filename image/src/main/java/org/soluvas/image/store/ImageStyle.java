package org.soluvas.image.store;

import org.soluvas.image.ImageTransform;
import org.soluvas.image.TransformGravity;
import org.soluvas.image.impl.ResizeToFillImpl;
import org.soluvas.image.impl.ResizeToFitImpl;

/**
 * Description on how to process an image to a different style like thumbnail.
 * 
 * @author ceefour
 * 
 */
public class ImageStyle {

	private final String name;
	private final String code;
	private ImageTransform transform;

	public ImageStyle(String name, String code, Integer maxWidth, Integer maxHeight) {
		super();
		this.name = name;
		this.code = code;
		
		if (maxWidth != null && maxHeight != null) {
			// create ResizeToFill if both maxWidth and maxHeight is filled
			transform = new ResizeToFillImpl(maxWidth, maxHeight, TransformGravity.CENTER);
		} else {
			// otherwise assume ResizeToFit
			transform = new ResizeToFitImpl(maxWidth, maxHeight);
		}
	}
	
	/**
	 * @param name
	 * @param code
	 * @param maxWidth
	 * @param maxHeight
	 * @param gravity
	 */
	public ImageStyle(String name, String code, Integer maxWidth, Integer maxHeight,
			TransformGravity gravity) {
		super();
		this.name = name;
		this.code = code;
		
		if (maxWidth != null && maxHeight != null) {
			// create ResizeToFill if both maxWidth and maxHeight is filled
			transform = new ResizeToFillImpl(maxWidth, maxHeight, gravity);
		} else {
			// otherwise assume ResizeToFit
			transform = new ResizeToFitImpl(maxWidth, maxHeight);
		}
	}

	public ImageStyle(String name, String code, ImageTransform transform) {
		super();
		this.name = name;
		this.code = code;
		this.transform = transform;
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

	@Override
	public String toString() {
		return "ImageStyle [" + (name != null ? "name=" + name + ", " : "")
				+ (code != null ? "code=" + code + ", " : "") + "]";
	}

	public ImageTransform getTransform() {
		return transform;
	}

}

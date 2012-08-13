package org.soluvas.image.store;

/**
 * Description on how to process an image to a different style like thumbnail.
 * 
 * @author ceefour
 * 
 */
public class ImageStyle {

	private String name;
	private String code;
	private int maxWidth;
	private int maxHeight;

	public ImageStyle() {
		super();
	}

	public ImageStyle(String name, String code, int maxWidth, int maxHeight) {
		super();
		this.name = name;
		this.code = code;
		this.maxWidth = maxWidth;
		this.maxHeight = maxHeight;
	}

	/**
	 * Lowercase 1 letter
	 * 
	 * @return
	 */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Maximum width of this style.
	 * 
	 * @return
	 */
	public int getMaxWidth() {
		return maxWidth;
	}

	public void setMaxWidth(int maxWidth) {
		this.maxWidth = maxWidth;
	}

	/**
	 * Maximum height of this style.
	 * 
	 * @return
	 */
	public int getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}

	@Override
	public String toString() {
		return String.format(
				"ImageStyle [name=%s, code=%s, maxWidth=%s, maxHeight=%s]",
				name, code, maxWidth, maxHeight);
	}

}

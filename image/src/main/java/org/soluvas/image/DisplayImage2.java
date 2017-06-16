/**
 */
package org.soluvas.image;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DisplayImage2 implements Serializable {
	protected static final String SRC_EDEFAULT = null;

	protected String src = SRC_EDEFAULT;

	protected static final Integer WIDTH_EDEFAULT = null;

	protected Integer width = WIDTH_EDEFAULT;

	protected static final Integer HEIGHT_EDEFAULT = null;

	protected Integer height = HEIGHT_EDEFAULT;

	protected static final String ALT_EDEFAULT = null;

	protected String alt = ALT_EDEFAULT;

	protected static final String TITLE_EDEFAULT = null;

	protected String title = TITLE_EDEFAULT;

	public DisplayImage2() {
		super();
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String newSrc) {
		src = newSrc;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer newWidth) {
		width = newWidth;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer newHeight) {
		height = newHeight;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String newAlt) {
		alt = newAlt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String newTitle) {
		title = newTitle;
	}

	@Override
	public String toString() {

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (src: ");
		result.append(src);
		result.append(", width: ");
		result.append(width);
		result.append(", height: ");
		result.append(height);
		result.append(", alt: ");
		result.append(alt);
		result.append(", title: ");
		result.append(title);
		result.append(')');
		return result.toString();
	}

} //DisplayImage

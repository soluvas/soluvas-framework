package org.soluvas.data.push;

import java.io.Serializable;

/**
 * @author ceefour
 */
public class Label implements Serializable {
	
	private String id;
	private String name;
	private String slug;
	private String imageId;
	private String color;
	
	public Label(String id, String name, String slug, String imageId,
			String color) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.imageId = imageId;
		this.color = color;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the slug
	 */
	public String getSlug() {
		return slug;
	}

	/**
	 * @param slug the slug to set
	 */
	public void setSlug(String slug) {
		this.slug = slug;
	}

	/**
	 * @return the imageId
	 */
	public String getImageId() {
		return imageId;
	}

	/**
	 * @param imageId the imageId to set
	 */
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"Label [id=%s, name=%s, slug=%s, imageId=%s, color=%s]", id,
				name, slug, imageId, color);
	}
	
}

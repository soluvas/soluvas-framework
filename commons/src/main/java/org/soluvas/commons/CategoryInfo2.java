package org.soluvas.commons;

import java.io.Serializable;

/**
 * @author rudi
 *
 */
public class CategoryInfo2 implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nsPrefix;
	private String name;
	private Integer positioner;
	private String slug;
	private String imageId;
	private String slugPath;
	private String color;
	private Integer level;
	private Long googleFormalId;
	private String primaryUri;
	private String parentId;
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
	 * @return the nsPrefix
	 */
	public String getNsPrefix() {
		return nsPrefix;
	}
	/**
	 * @param nsPrefix the nsPrefix to set
	 */
	public void setNsPrefix(String nsPrefix) {
		this.nsPrefix = nsPrefix;
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
	 * @return the positioner
	 */
	public Integer getPositioner() {
		return positioner;
	}
	/**
	 * @param positioner the positioner to set
	 */
	public void setPositioner(Integer positioner) {
		this.positioner = positioner;
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
	 * @return the slugPath
	 */
	public String getSlugPath() {
		return slugPath;
	}
	/**
	 * @param slugPath the slugPath to set
	 */
	public void setSlugPath(String slugPath) {
		this.slugPath = slugPath;
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
	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * @return the googleFormalId
	 */
	public Long getGoogleFormalId() {
		return googleFormalId;
	}
	/**
	 * @param googleFormalId the googleFormalId to set
	 */
	public void setGoogleFormalId(Long googleFormalId) {
		this.googleFormalId = googleFormalId;
	}
	/**
	 * @return the primaryUri
	 */
	public String getPrimaryUri() {
		return primaryUri;
	}
	/**
	 * @param primaryUri the primaryUri to set
	 */
	public void setPrimaryUri(String primaryUri) {
		this.primaryUri = primaryUri;
	}
	/**
	 * @return the parentId
	 */
	public String getParentId() {
		return parentId;
	}
	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CategoryInfo2 [id=" + id + ", nsPrefix=" + nsPrefix + ", name="
				+ name + ", positioner=" + positioner + ", slug=" + slug
				+ ", imageId=" + imageId + ", slugPath=" + slugPath
				+ ", color=" + color + ", level=" + level + ", googleFormalId=" + googleFormalId
				+ ", primaryUri=" + primaryUri + ", parentId=" + parentId + "]";
	}
	
}

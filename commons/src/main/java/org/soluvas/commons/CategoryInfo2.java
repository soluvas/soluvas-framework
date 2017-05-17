package org.soluvas.commons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.base.Optional;

/**
 * @author rudi
 *
 */
public class CategoryInfo2 implements Serializable {

	private static final long serialVersionUID = 1L;
	protected static final Long CATEGORY_COUNT_EDEFAULT = null;
	
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
	private TranslationState translationState;
	private String originalLanguage;
	private String language;
	private Map<String, Map<String, String>> translations;
	protected Long categoryCount = CATEGORY_COUNT_EDEFAULT;
	private CategoryInfo2 parent;
	protected List<CategoryInfo2> parents;
	
	public void copyFrom(CategoryInfo upInfo) {
		setColor(upInfo.getColor());
		setGoogleFormalId(upInfo.getGoogleFormalId());
		setId(upInfo.getId());
		setImageId(upInfo.getImageId());
		setLevel(upInfo.getLevel());
		setName(upInfo.getName());
		setNsPrefix(upInfo.getNsPrefix());
		setParentId(upInfo.getParent() != null ? upInfo.getParent().getId() : null);
		setPositioner(upInfo.getPositioner());
		setPrimaryUri(upInfo.getPrimaryUri());
		setSlug(upInfo.getSlug());
		setSlugPath(upInfo.getSlugPath());
	}
	
	
	public String getEffectiveName(String curLanguageTag) {
		if (Optional.fromNullable(getLanguage()).or("id-ID").equals(curLanguageTag)) {
			return getName();
		} else {
			final Map<String, Map<String, String>> translations = getTranslations();
			if (translations.isEmpty()) {
				return getName();
			} else {
				if (!translations.containsKey(curLanguageTag)) {
					return getName();
				} else {
					final Map<String, String> translation = translations.get(curLanguageTag);
					if (!translation.containsKey(CategoryInfo.NAME_ATTR)) {
						return getName();
					} else {
						final String translatedValue = translation.get(CategoryInfo.NAME_ATTR);
						return translatedValue;
					}
				}
			}
		}
	}
	
	public Long getCategoryCount() {
		return categoryCount;
	}
	
	public void setCategoryCount(Long newCategoryCount) {
		categoryCount = newCategoryCount;
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

	public TranslationState getTranslationState() {
		return translationState;
	}

	public void setTranslationState(TranslationState value) {
		translationState = value;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public void setOriginalLanguage(String value) {
		originalLanguage = value;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String value) {
		language = value;
	}

	public Map<String, Map<String, String>> getTranslations() {
		return translations;
	}
	
	public CategoryInfo2 getParent() {
		return parent;
	}

	public CategoryInfo2 basicGetParent() {
		return parent;
	}

	public void setParent(CategoryInfo2 newParent) {
		parent = newParent;
	}
	
	public List<CategoryInfo2> getParents() {
		if (parents == null) {
			parents = new ArrayList<>();
		}
		return parents;
	}
}

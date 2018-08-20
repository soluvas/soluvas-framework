package org.soluvas.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.soluvas.commons.Identifiable;

import com.google.code.morphia.annotations.Id;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;

import jline.internal.Preconditions;

/**
 * @author rudi
 *
 */
public class Term2 implements Serializable, Identifiable {
	
	private static final long serialVersionUID = 1L;
	
	public static final long CURRENT_SCHEMA_VERSION = 2l;
	
	public static String NAME_ATTR = "name";
	public static String DESCRIPTION_ATTR = "description";
	public static String CONTENT_ATTR = "content";
	
	@Id private String id;
	private String formalId;
	private String name;
	private String imageId;
	private String imageUri;
	private Integer positioner;
	private String color;
	private String language;
	private final Map<String, Map<String, String>> translations = new HashMap<>();
	private String enumerationId;
	private String primaryUri;
	private Set<String> sameAsUris;
	private String description;
	private Boolean enabled;
	private Boolean overridden;
	private String content;
	
	public Term2() {
		super();
		this.enabled = true;
		this.overridden = true;
	}
	
	public void copy(Term2 term) {
		this.setColor(term.getColor());
		this.setDescription(term.getDescription());
		this.setEnabled(term.getEnabled());
		this.setEnumerationId(term.getEnumerationId());
		this.setFormalId(term.getFormalId());
		this.setId(term.getId());
		this.setImageId(term.getImageId());
		this.setImageUri(term.getImageUri());
		this.setLanguage(term.getLanguage());
		this.setName(term.getName());
		this.setOverridden(term.getOverridden());
		this.setPositioner(term.getPositioner());
		this.setPrimaryUri(term.getPrimaryUri());
		this.setSameAsUris(term.getSameAsUris());
		this.setContent(term.getContent());
	}
	
	public void copyFromXmi(Term xmiTerm) {
		this.setColor(xmiTerm.getColor());
		this.setId(xmiTerm.getNsPrefix() + "_" + xmiTerm.getName());
		this.setFormalId(getId());
		this.setImageId(xmiTerm.getImageId());
		this.setImageUri(xmiTerm.getImageUri());
		this.setEnumerationId(xmiTerm.getKindName());
		this.setLanguage(xmiTerm.getLanguage());
		this.setName(xmiTerm.getDisplayName());
		this.setPositioner(xmiTerm.getPositioner());
		this.setPrimaryUri(xmiTerm.getPrimaryUri());
		this.setSameAsUris(ImmutableSet.copyOf(xmiTerm.getSameAsUris()));
		this.setEnabled(true);
		this.setOverridden(true);
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the overriden
	 */
	public Boolean getOverridden() {
		return overridden;
	}

	/**
	 * @param overriden the overriden to set
	 */
	public void setOverridden(Boolean overriden) {
		this.overridden = overriden;
	}

	/**
	 * @return the id
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	@Override
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the formalId
	 */
	public String getFormalId() {
		return formalId;
	}

	/**
	 * @param formalId the formalId to set
	 */
	public void setFormalId(String formalId) {
		this.formalId = formalId;
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
	 * @return the imageUri
	 */
	public String getImageUri() {
		return imageUri;
	}

	/**
	 * @param imageUri the imageUri to set
	 */
	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
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
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	
	/**
	 * @return the enumerationId
	 */
	public String getEnumerationId() {
		return enumerationId;
	}

	/**
	 * @param enumerationId the enumerationId to set
	 */
	public void setEnumerationId(String enumerationId) {
		this.enumerationId = enumerationId;
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
	 * @return the sameAsUris
	 */
	public Set<String> getSameAsUris() {
		return sameAsUris;
	}

	/**
	 * @param sameAsUris the sameAsUris to set
	 */
	public void setSameAsUris(Set<String> sameAsUris) {
		this.sameAsUris = sameAsUris;
	}

	/**
	 * @return the translations
	 */
	public Map<String, Map<String, String>> getTranslations() {
		return translations;
	}
	
	public String getImageUri(String imagesUri) {
		if (!Strings.isNullOrEmpty(getImageId())) {
			final String bundleName = getId().startsWith("base") ? "org.soluvas.data" : "tenant_common";
			final String uri = imagesUri + bundleName + "/" + "base_" + getEnumerationId() +"/" + getImageId() + ".png";
			return uri;
		} else {
			return null;
		}
	}
	
	public String getEffectiveName(String curLanguageTag) {
		Preconditions.checkNotNull("For getting effective display name, the curLanguageTag must not be null.");
		if (getTranslations() != null && !getTranslations().isEmpty()) {
			if (curLanguageTag.equals(getLanguage())) {
				return getName();
			} else {
				final Map<String, String> msg = getTranslations().get(curLanguageTag);
				if (msg != null && msg.containsKey(NAME_ATTR)) {
					return msg.get(NAME_ATTR);
				} else {
					return getName();
				}
			}
		} else {
			return getName();
		}
	}
	
	public String getEffectiveDescription(String curLanguageTag) {
		Preconditions.checkNotNull("For getting effective description, the curLanguageTag must not be null.");
		if (getTranslations() != null && !getTranslations().isEmpty()) {
			if (curLanguageTag.equals(getLanguage())) {
				return getDescription();
			} else {
				final Map<String, String> msg = getTranslations().get(curLanguageTag);
				if (msg != null && msg.containsKey(DESCRIPTION_ATTR)) {
					return msg.get(DESCRIPTION_ATTR);
				} else {
					return getDescription();
				}
			}
		} else {
			return getDescription();
		}
	}
	
	public String getEffectiveContent(String curLanguageTag) {
		Preconditions.checkNotNull("For getting effective content, the curLanguageTag must not be null.");
		if (getTranslations() != null && !getTranslations().isEmpty()) {
			if (curLanguageTag.equals(getLanguage())) {
				return getContent();
			} else {
				final Map<String, String> msg = getTranslations().get(curLanguageTag);
				if (msg != null && msg.containsKey(CONTENT_ATTR)) {
					return msg.get(CONTENT_ATTR);
				} else {
					return getContent();
				}
			}
		} else {
			return getContent();
		}
	}
	

	@Override
	public String toString() {
		return "Term2 [id=" + id + ", formalId=" + formalId + ", name=" + name + ", imageId=" + imageId + ", imageUri="
				+ imageUri + ", positioner=" + positioner + ", color=" + color + ", language=" + language
				+ ", translations=" + translations + ", enumerationId=" + enumerationId + ", primaryUri=" + primaryUri
				+ ", sameAsUris=" + sameAsUris + ", description=" + description + ", enabled=" + enabled
				+ ", overridden=" + overridden + ", content=" + content + "]";
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
}

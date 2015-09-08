package org.soluvas.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import jline.internal.Preconditions;

import org.soluvas.commons.Identifiable;

import com.google.code.morphia.annotations.Id;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;

/**
 * @author rudi
 *
 */
public class Term2 implements Serializable, Identifiable {
	
	private static final long serialVersionUID = 1L;
	
	public static final long CURRENT_SCHEMA_VERSION = 2l;
	
	public static String NAME_ATTR = "name";
	public static String DESCRIPTION_ATTR = "description";
	
	@Id private String id;
	private String formalId;
	private String name;
	private String imageId;
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
	
	public Term2() {
		super();
		this.enabled = true;
		this.overridden = true;
	}
	
	public void copyFromXmi(Term xmiTerm) {
		this.setColor(xmiTerm.getColor());
		this.setId(xmiTerm.getNsPrefix() + "_" + xmiTerm.getName());
		this.setFormalId(getId());
		this.setImageId(xmiTerm.getImageId());
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
				if (msg != null && msg.containsKey(Term2.NAME_ATTR)) {
					return msg.get(Term2.NAME_ATTR);
				} else {
					return getName();
				}
			}
		} else {
			return getName();
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Term2 [" + id + ", name=" + name
				+ ", imageId=" + imageId + ", positioner=" + positioner
				+ ", color=" + color + ", language=" + language
				+ ", translations=" + translations + ", kindName=" + enumerationId + ", primaryUri="
				+ primaryUri + ", sameAsUris=" + sameAsUris + "]";
	}
	
}
package org.soluvas.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import jline.internal.Preconditions;

/**
 * @author rudi
 *
 */
public class TermKind implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static String NAME_ATTR = "name";
	public static String DESCRIPTION_ATTR = "description";
	
	private String id;
	private String name;
	private String idPropertyDefinition;
	private String description;
	private Boolean expandable;
	private Locale language;
	private final Map<String, Map<String, String>> translations = new HashMap<>();
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
	 * @return the idPropertyDefinition
	 */
	public String getIdPropertyDefinition() {
		return idPropertyDefinition;
	}
	/**
	 * @param idPropertyDefinition the idPropertyDefinition to set
	 */
	public void setIdPropertyDefinition(String idPropertyDefinition) {
		this.idPropertyDefinition = idPropertyDefinition;
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
	 * @return the expandable
	 */
	public Boolean getExpandable() {
		return expandable;
	}
	/**
	 * @param expandable the expandable to set
	 */
	public void setExpandable(Boolean expandable) {
		this.expandable = expandable;
	}
	/**
	 * @return the language
	 */
	public Locale getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(Locale language) {
		this.language = language;
	}
	/**
	 * @return the translation
	 */
	public Map<String, Map<String, String>> getTranslations() {
		return translations;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TermKind2 [id=" + id + ", name=" + name + ", description="
				+ description + ", expandable=" + expandable + ", translation="
				+ translations + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TermKind other = (TermKind) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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
	
}

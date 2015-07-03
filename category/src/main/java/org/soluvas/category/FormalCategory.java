package org.soluvas.category;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.soluvas.data.PropertyDefinition;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/**
 * Category that is recognized by the <a href="https://support.google.com/merchants/answer/160081?hl=en">Google Product Taxonomy</a>.
 * @author rudi
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, property="@type", defaultImpl=FormalCategory.class)
@JsonSubTypes(@JsonSubTypes.Type(name="FormalCategory", value=FormalCategory.class))
public class FormalCategory implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long googleId;
	
	private Long parentGoogleId;
	
	private ImmutableList<String> googleBreadcrumbs;
	
	private String name;
	
	private String description;
	
	private final Map<String, Map<String, String>> translations = new HashMap<>();
	
	private String primaryUri;
	
	private ImmutableSet<String> sameAsUris;
	
	private ImmutableSet<PropertyDefinition> propertyOverrides;

	public long getGoogleId() {
		return googleId;
	}

	public void setGoogleId(long googleId) {
		this.googleId = googleId;
	}

	public Long getParentGoogleId() {
		return parentGoogleId;
	}

	public void setParentGoogleId(Long parentGoogleId) {
		this.parentGoogleId = parentGoogleId;
	}

	public ImmutableList<String> getGoogleBreadcrumbs() {
		return googleBreadcrumbs;
	}

	public void setGoogleBreadcrumbs(ImmutableList<String> googleBreadcrumbs) {
		this.googleBreadcrumbs = googleBreadcrumbs;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Map<String, Map<String, String>> getTranslations() {
		return translations;
	}

	public String getPrimaryUri() {
		return primaryUri;
	}

	public void setPrimaryUri(String primaryUri) {
		this.primaryUri = primaryUri;
	}

	public ImmutableSet<String> getSameAsUris() {
		return sameAsUris;
	}

	public void setSameAsUris(ImmutableSet<String> sameAsUris) {
		this.sameAsUris = sameAsUris;
	}

	/**
	 * If you want to override or determine the option/properties for {@link org.soluvas.category.Category},
	 * just use {@link #getPropertyOverrides()} directly.
	 * This function is for convenience only.
	 * @return
	 */
	@JsonIgnore
	public Set<String> getDefaultOptionTypes() {
		return propertyOverrides.stream().filter(it -> it.getUsableAsOption()).map(PropertyDefinition::getId)
				.collect(Collectors.toSet());
	}

	/**
	 * If you want to override or determine the option/properties for {@link org.soluvas.category.Category},
	 * just use {@link #getPropertyOverrides()} directly.
	 * This function is for convenience only.
	 * @return
	 */
	@JsonIgnore
	public Set<String> getDefaultProperties() {
		return propertyOverrides.stream().filter(it -> !it.getUsableAsOption()).map(PropertyDefinition::getId)
			.collect(Collectors.toSet());
	}

	/**
	 * When creating a new {@link org.soluvas.category.Category}, the default list of
	 * property overrides will simply contain the IDs of FormalCategory's propertyOverrides.
	 * (i.e. name, description, etc. are not copied)
	 * @return
	 */
	public ImmutableSet<PropertyDefinition> getPropertyOverrides() {
		return propertyOverrides;
	}

	public void setPropertyOverrides(
			ImmutableSet<PropertyDefinition> propertyOverrides) {
		this.propertyOverrides = propertyOverrides;
	}

	@Override
	public String toString() {
		return "FormalCategory [googleId=" + googleId + ", parentGoogleId="
				+ parentGoogleId + ", googleBreadcrumbs=" + googleBreadcrumbs
				+ ", primaryUri=" + primaryUri + ", sameAsUris=" + sameAsUris
				+ ", propertyOverrides=" + propertyOverrides + "]";
	}

}

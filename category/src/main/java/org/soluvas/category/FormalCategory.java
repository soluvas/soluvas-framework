package org.soluvas.category;

import java.io.Serializable;

import org.soluvas.data.PropertyDefinition;

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
	
	private String primaryUri;
	
	private ImmutableSet<String> sameAsUris;
	
	private ImmutableSet<String> defaultOptionTypes;
	private ImmutableSet<String> defaultProperties;

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

	public ImmutableSet<String> getDefaultOptionTypes() {
		return defaultOptionTypes;
	}

	public void setDefaultOptionTypes(ImmutableSet<String> defaultOptionTypes) {
		this.defaultOptionTypes = defaultOptionTypes;
	}

	public ImmutableSet<String> getDefaultProperties() {
		return defaultProperties;
	}

	public void setDefaultProperties(ImmutableSet<String> defaultProperties) {
		this.defaultProperties = defaultProperties;
	}

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
				+ ", defaultOptionTypes=" + defaultOptionTypes
				+ ", defaultProperties=" + defaultProperties
				+ ", propertyOverrides=" + propertyOverrides + "]";
	}

}

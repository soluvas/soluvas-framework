package org.soluvas.category;

import java.io.Serializable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/**
 * Category that is recognized by the <a href="https://support.google.com/merchants/answer/160081?hl=en">Google Product Taxonomy</a>.
 * @author rudi
 */
public class FormalCategory implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long googleId;
	
	private Long parentGoogleId;
	
	private ImmutableList<String> googleBreadcrumbs;
	
	private String primaryUri;
	
	private ImmutableSet<String> sameAsUris;
	
	private ImmutableSet<Option> options;
	
	private ImmutableSet<String> properties;

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

	public ImmutableSet<Option> getOptions() {
		return options;
	}

	public void setOptions(ImmutableSet<Option> options) {
		this.options = options;
	}

	public ImmutableSet<String> getProperties() {
		return properties;
	}

	public void setProperties(ImmutableSet<String> properties) {
		this.properties = properties;
	}
	
	

}

package org.soluvas.category;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.ImmutableList;

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
	final Set<String> sameAsUris = new HashSet<>();
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
	public Set<String> getSameAsUris() {
		return sameAsUris;
	}
	
}

package org.soluvas.socmed.instagram;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InstagramPagination implements Serializable{
	@JsonProperty("next_min_id")
	private String nextMinId;
	@JsonProperty("deprecation_warning")
	private String deprecationWarning;
	@JsonProperty("min_tag_id")
	private String minTagId;
	@JsonProperty("max_tag_id")
	private String maxTagId;
	@JsonProperty("next_url")
	private String nextUrl;
	
	public String getNextMinId() {
		return nextMinId;
	}
	
	public void setNextMinId(String nextMinId) {
		this.nextMinId = nextMinId;
	}
	
	public String getDeprecationWarning() {
		return deprecationWarning;
	}
	
	public void setDeprecationWarning(String deprecationWarning) {
		this.deprecationWarning = deprecationWarning;
	}
	
	public String getMinTagId() {
		return minTagId;
	}
	
	public void setMinTagId(String minTagId) {
		this.minTagId = minTagId;
	}
	
	public String getMaxTagId() {
		return maxTagId;
	}
	
	public void setMaxTagId(String maxTagId) {
		this.maxTagId = maxTagId;
	}
	
	public String getNextUrl() {
		return nextUrl;
	}
	
	public void setNextUrl(String nextUrl) {
		this.nextUrl = nextUrl;
	}

	@Override
	public String toString() {
		return "InstagramPagination [nextMaxTagId=" + nextMinId + ", deprecationWarning=" + deprecationWarning
				+ ", minTagId=" + minTagId + ", maxTagId=" + maxTagId + ", nextUrl=" + nextUrl + "]";
	}
	
	
	
}

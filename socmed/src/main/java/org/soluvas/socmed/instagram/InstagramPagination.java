package org.soluvas.socmed.instagram;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InstagramPagination implements Serializable{

	private String next_max_tag_id;
	private String deprecation_warning;
	private String next_max_id;
	private String next_min_id;
	private String min_tag_id;
	private String next_url;
	
	public String getNext_max_tag_id() {
		return next_max_tag_id;
	}
	public void setNext_max_tag_id(String next_max_tag_id) {
		this.next_max_tag_id = next_max_tag_id;
	}
	public String getDeprecation_warning() {
		return deprecation_warning;
	}
	public void setDeprecation_warning(String deprecation_warning) {
		this.deprecation_warning = deprecation_warning;
	}
	public String getNext_max_id() {
		return next_max_id;
	}
	public void setNext_max_id(String next_max_id) {
		this.next_max_id = next_max_id;
	}
	public String getNext_min_id() {
		return next_min_id;
	}
	public void setNext_min_id(String next_min_id) {
		this.next_min_id = next_min_id;
	}
	public String getMin_tag_id() {
		return min_tag_id;
	}
	public void setMin_tag_id(String min_tag_id) {
		this.min_tag_id = min_tag_id;
	}
	public String getNext_url() {
		return next_url;
	}
	public void setNext_url(String next_url) {
		this.next_url = next_url;
	}
	@Override
	public String toString() {
		return "InstagramPagination [next_max_tag_id=" + next_max_tag_id
				+ ", deprecation_warning=" + deprecation_warning
				+ ", next_max_id=" + next_max_id + ", next_min_id="
				+ next_min_id + ", min_tag_id=" + min_tag_id + ", next_url="
				+ next_url + "]";
	}
	
	
}

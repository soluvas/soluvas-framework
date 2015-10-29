package org.soluvas.socmed.instagram;

import java.io.Serializable;

@SuppressWarnings("serial")
public class InstagramUser implements Serializable{
	
	private String username;
	private String profile_picture;
	private String id;
	private String full_name;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getProfile_picture() {
		return profile_picture;
	}
	public void setProfile_picture(String profile_picture) {
		this.profile_picture = profile_picture;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	
	@Override
	public String toString() {
		return "InstagramUser [username=" + username + ", profile_picture="
				+ profile_picture + ", id=" + id + ", full_name=" + full_name
				+ "]";
	}

}

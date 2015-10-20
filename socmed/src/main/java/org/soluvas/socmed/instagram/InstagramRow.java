package org.soluvas.socmed.instagram;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties( ignoreUnknown = true )
public class InstagramRow implements Serializable{

	/**
	 * 
	 */
	private static long serialVersionUID = 1L;
	
	private Images images;
	private String link;
	private List<String> tags;
	private InstagramCaption caption;
	private InstagramUser user;

	public Images getImages() {
		return images;
	}

	public void setImages(Images images) {
		this.images = images;
	}
	
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public InstagramCaption getCaption() {
		return caption;
	}

	public void setCaption(InstagramCaption caption) {
		this.caption = caption;
	}

	public InstagramUser getUser() {
		return user;
	}

	public void setUser(InstagramUser user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "InstagramRow [images=" + images + ", link=" + link + ", tags="
				+ tags + ", caption=" + caption + ", user=" + user + "]";
	}

}

package org.soluvas.socmed.instagram;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.code.morphia.annotations.Id;

@JsonIgnoreProperties( ignoreUnknown = true )
public class InstagramRow implements Serializable{

	/**
	 * 
	 */
	private static long serialVersionUID = 1L;
	
	private Images images;
	private String link;
	private String created_time;
	
	private List<String> tags;
	private InstagramCaption caption;
	private InstagramUser user;
	private InstagramLikes likes;
	
	@Id
	private String id;

	public Images getImages() {
		return images;
	}

	public void setImages(Images images) {
		this.images = images;
	}
	
	public String getLink() {
		return link;
	}
	
	public String getCreated_time() {
		return created_time;
	}

	public void setCreated_time(String created_time) {
		this.created_time = created_time;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public InstagramLikes getLikes() {
		return likes;
	}

	public void setLikes(InstagramLikes likes) {
		this.likes = likes;
	}

	@Override
	public String toString() {
		return "InstagramRow [images=" + images + ", link=" + link + ", created_time=" + created_time + ", tags=" + tags
				+ ", caption=" + caption + ", user=" + user + ", likes=" + likes + ", id=" + id + "]";
	}
	
}

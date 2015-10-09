package org.soluvas.socmed.instagram;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties( ignoreUnknown = true )
public class InstagramRow implements Serializable{

	/**
	 * 
	 */
	private static long serialVersionUID = 1L;
	
	private Images images;
	private String link;
	private InstagramCaption caption;

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

	public InstagramCaption getCaption() {
		return caption;
	}

	public void setCaption(InstagramCaption caption) {
		this.caption = caption;
	}

	@Override
	public String toString() {
		return "InstagramRow [images=" + images + ", link=" + link
				+ ", caption=" + caption + "]";
	}
	
}

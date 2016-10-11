package org.soluvas.socmed.instagram;

public class InstagramCaption {

	private String text;
//	private InstagramCaption caption;
	private String created_time;
	private InstagramUser from;
	private String id;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

//	public InstagramCaption getCaption() {
//		return caption;
//	}
//
//	public void setCaption(InstagramCaption caption) {
//		this.caption = caption;
//	}

	public String getCreated_time() {
		return created_time;
	}

	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}
	
	public void setFrom(InstagramUser from) {
		this.from = from;
	}
	
	public InstagramUser getFrom() {
		return from;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
}

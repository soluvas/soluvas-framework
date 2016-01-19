package org.soluvas.socmed.instagram;

public class InstagramCaption {

	private String text;
	private InstagramCaption caption;
	private String created_time;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public InstagramCaption getCaption() {
		return caption;
	}

	public void setCaption(InstagramCaption caption) {
		this.caption = caption;
	}

	public String getCreated_time() {
		return created_time;
	}

	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}

	@Override
	public String toString() {
		return "InstagramCaption [text=" + text + ", caption=" + caption + ", created_time=" + created_time + "]";
	}
	
}

package org.soluvas.facebook;

/**
 * @author rudi
 *
 */
public class Cursor {
	
	private String before;
	private String after;
	
	public Cursor() {
		super();
	}

	public String getBefore() {
		return before;
	}

	public void setBefore(String before) {
		this.before = before;
	}

	public String getAfter() {
		return after;
	}

	public void setAfter(String after) {
		this.after = after;
	}

	@Override
	public String toString() {
		return "Cursor [before=" + before + ", after=" + after + "]";
	}
	
}

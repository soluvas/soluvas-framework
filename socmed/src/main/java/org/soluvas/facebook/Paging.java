package org.soluvas.facebook;

/**
 * 
 * @author rudi
 *
 */
public class Paging {
	
	private String previous;
	private String next;
	private Cursor cursors;
	
	public Paging() {
		super();
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public Cursor getCursors() {
		return cursors;
	}

	public void setCursors(Cursor cursors) {
		this.cursors = cursors;
	}

	@Override
	public String toString() {
		return "Paging [previous=" + previous + ", next=" + next + ", cursors="
				+ cursors + "]";
	}

}

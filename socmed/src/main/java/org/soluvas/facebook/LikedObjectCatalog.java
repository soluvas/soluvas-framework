package org.soluvas.facebook;

import java.util.List;


/**
 * @author rudi
 *
 */
public class LikedObjectCatalog {

	private List<LikedObject> data;
	private Paging paging;

	public LikedObjectCatalog() {
		super();
	}

	public List<LikedObject> getData() {
		return data;
	}

	public void setData(List<LikedObject> data) {
		this.data = data;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

	@Override
	public String toString() {
		return "LikedObjectCatalog [data=" + data + ", paging=" + paging + "]";
	}

}

package org.soluvas.jaxrs;

import java.util.List;

/**
 * @author rudi
 *
 */
public class CatalogStatusOnly {
	
	private List<StatusOnly> statuses;

	public CatalogStatusOnly() {
		super();
	}

	public List<StatusOnly> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<StatusOnly> statuses) {
		this.statuses = statuses;
	}

	@Override
	public String toString() {
		return "CatalogStatusOnly [statuses=" + statuses + "]";
	}

}

package org.soluvas.push;

import java.io.Serializable;

/**
 * @author rudi
 */
@SuppressWarnings("serial")
public class TrackableEvent implements Serializable {
	
	private String trackingId;

	public TrackableEvent(String trackingId) {
		super();
		this.trackingId = trackingId;
	}

	/**
	 * @return the trackingId
	 */
	public String getTrackingId() {
		return trackingId;
	}

	/**
	 * @param trackingId the trackingId to set
	 */
	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("TrackableEvent [trackingId=%s]", trackingId);
	}
	
}

package org.soluvas.push;

import java.io.Serializable;

import org.soluvas.commons.tenant.TenantSubscribers;

/**
 * @author rudi
 * @deprecated Use {@link TenantEvent}.
 * @see TenantSubscribers
 */
@Deprecated
public class TrackableEvent implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String trackingId;

	public TrackableEvent() {
		super();
	}

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

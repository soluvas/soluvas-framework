package org.soluvas.commons;

import org.soluvas.push.TrackableEvent;

/**
 * @author adri
 *
 */
@SuppressWarnings("serial")
public class MonitorDone extends TrackableEvent {
	
	private final ProgressStatus status;

	public MonitorDone(String trackingId, ProgressStatus status) {
		super(trackingId);
		this.status = status;
	}

	public ProgressStatus getStatus() {
		return status;
	}
	
}

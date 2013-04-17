package org.soluvas.commons;

import org.soluvas.push.TrackableEvent;

/**
 * 
 * // TODO: move to soluvas commons
 * @author adri
 */
@SuppressWarnings("serial")
public class MonitorProgressed extends TrackableEvent {
	
	private final double worked;
	private final double totalWork;
	private final String name;
	
	public MonitorProgressed(String trackingId, double worked, double totalWork, String name) {
		super(trackingId);
		this.worked = worked;
		this.totalWork = totalWork;
		this.name = name;
	}

	public double getWorked() {
		return worked;
	}

	public double getTotalWork() {
		return totalWork;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "MonitorProgressed [worked="
				+ worked
				+ ", totalWork="
				+ totalWork
				+ ", "
				+ (name != null ? "name=" + name + ", " : "")
				+ (getTrackingId() != null ? "getTrackingId()="
						+ getTrackingId() : "") + "]";
	}

}

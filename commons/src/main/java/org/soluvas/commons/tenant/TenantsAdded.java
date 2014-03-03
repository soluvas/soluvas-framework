package org.soluvas.commons.tenant;

import org.soluvas.commons.AppManifest;
import org.soluvas.push.TrackableEvent;

import com.google.common.collect.ImmutableMap;

/**
 * @author ceefour
 */
public class TenantsAdded extends TrackableEvent {

	private static final long serialVersionUID = 1L;
	
	private final ImmutableMap<String, AppManifest> addeds;

	/**
	 * @param trackingId
	 */
	public TenantsAdded(ImmutableMap<String, AppManifest> addeds, String trackingId) {
		super(trackingId);
		this.addeds = addeds;
	}
	
	public ImmutableMap<String, AppManifest> getAddeds() {
		return addeds;
	}

}

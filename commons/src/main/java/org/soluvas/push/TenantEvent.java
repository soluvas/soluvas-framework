package org.soluvas.push;

import javax.annotation.Nullable;

/**
 * A {@link TrackableEvent} that targets a specific {@link #getTenantId()}. 
 * @author anton
 */
public class TenantEvent extends TrackableEvent {

	private static final long serialVersionUID = 1L;
	
	@Nullable
	private final String tenantId;

	/**
	 * @param tenantId Tenant ID, for the app itself you can leave it {@code null}.
	 * @param trackingId
	 */
	public TenantEvent(@Nullable String tenantId, String trackingId) {
		super(trackingId);
		this.tenantId = tenantId;
	}
	
	/**
	 * Tenant ID or {@code null} for the app itself.
	 * @return
	 */
	@Nullable
	public String getTenantId() {
		return tenantId;
	}

}

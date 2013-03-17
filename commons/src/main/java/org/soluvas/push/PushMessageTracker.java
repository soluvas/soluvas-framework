package org.soluvas.push;

import java.util.Map;

import com.google.common.eventbus.EventBus;

/**
 * Simulate push using regular AJAX operations.
 * 
 * No longer implements {@link PushListener}, although it can, because we want to deprecate {@link PushListener}
 * in favor of {@link EventBus} / @Subscribe & callbacks.
 * 
 * @author ceefour
 */
public interface PushMessageTracker {

	public abstract Map<String, PushMessage> getPushesAndRemove(
			String trackingId);

}
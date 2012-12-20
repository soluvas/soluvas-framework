package org.soluvas.push;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.annotation.Nonnull;
import javax.enterprise.context.ApplicationScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * Simulate push using regular AJAX operations.
 * 
 * No longer implements {@link PushListener}, although it can, because we want to deprecate {@link PushListener}
 * in favor of {@link EventBus} / @Subscribe & callbacks.
 * 
 * FIXME: Use Multimap when it's done
 * @author ceefour
 */
@ApplicationScoped
public class PushMessageTrackerImpl implements PushMessageTracker {

	private static final Logger log = LoggerFactory.getLogger(PushMessageTrackerImpl.class);
	private final Map<String, Queue<PushMessage>> queues = new ConcurrentHashMap<String, Queue<PushMessage>>();
	
	/* (non-Javadoc)
	 * @see id.co.bippo.commerce.push.PushListener#publishPublic(java.lang.String, org.soluvas.push.PushMessage)
	 */
	@Subscribe
	public void publishPublic(@Nonnull final PushMessage message) {
		if (!(message instanceof TrackableEvent)) {
			log.warn("{} is not TrackableEvent, cannot track", message);
		}
		final String trackingId = ((TrackableEvent) message).getTrackingId();
		// ignore do-not-track messages
		if (trackingId == null)
			return;
		
		Queue<PushMessage> queue = queues.get(trackingId);
		if (queue == null) {
			queue = new ConcurrentLinkedQueue<PushMessage>();
			queues.put(trackingId, queue);
		}
		log.debug("Tracking {} push message: {}", trackingId, message);
		queue.add(message);
	}
	
	protected Map<String, PushMessage> doGetPushesAndRemove(String trackingId) {
		final Queue<PushMessage> queue = queues.get(trackingId);
		if (queue == null) {
			log.debug("Queue tracker {} empty", trackingId);
			return ImmutableMap.of();
		}
		final Map<String, PushMessage> pushes = Maps.uniqueIndex(queue, new Function<PushMessage, String>() {
			@Override
			public String apply(PushMessage input) {
				return "/topic/" + input.getTopic();
			}
		});
		log.debug("Queue tracker {} contained {} messages, now removing", trackingId, pushes.size());
		queues.remove(trackingId);
		return pushes;
	}
	
	
	/* (non-Javadoc)
	 * @see org.soluvas.push.PushMessageTracker#getPushesAndRemove(java.lang.String)
	 */
	@Override
	public Map<String, PushMessage> getPushesAndRemove(String trackingId) {
		final Map<String, PushMessage> pushes = doGetPushesAndRemove(trackingId);
		// We expect at least 1 push
		if (!pushes.isEmpty())
			return pushes;
		// wait a bit, who knows something else is processing
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
		}
		return doGetPushesAndRemove(trackingId);
	}

}

package org.soluvas.push;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.enterprise.context.ApplicationScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.eventbus.Subscribe;

/**
 * Simulate push using regular AJAX.
 * FIXME: Use Multimap when it's done
 * @author ceefour
 */
@SuppressWarnings("deprecation")
@ApplicationScoped
public class QueuedPushListener implements PushListener {

	private transient Logger log = LoggerFactory.getLogger(QueuedPushListener.class);
	private Map<String, Queue<PushMessage>> queues = new ConcurrentHashMap<String, Queue<PushMessage>>();
	
	/* (non-Javadoc)
	 * @see id.co.bippo.commerce.push.PushListener#publishPublic(java.lang.String, org.soluvas.push.PushMessage)
	 */
	@Override @Subscribe
	public void publishPublic(PushMessage message) {
		if (!((Object)message instanceof TrackableEvent)) {
			log.warn("{} is not TrackableEvent, cannot track", message);
		}
		final String trackingId = ((TrackableEvent) (Object) message).getTrackingId();
		
		synchronized (queues) {
			Queue<PushMessage> queue = queues.get(trackingId);
			if (queue == null) {
				queue = new ConcurrentLinkedQueue<PushMessage>();
				queues.put(trackingId, queue);
			}
			log.debug("Tracking {} push message: {}", trackingId, message);
			queue.add(message);
		}
	}
	
	public Map<String, PushMessage> getPushesAndRemove(String trackingId) {
		synchronized (queues) {
			Queue<PushMessage> queue = queues.get(trackingId);
			if (queue == null) {
				log.debug("Queue tracker {} empty", trackingId);
				return ImmutableMap.of();
			}
			ImmutableMap<String, PushMessage> pushes = Maps.uniqueIndex(queue, new Function<PushMessage, String>() {
				@Override
				public String apply(PushMessage input) {
					return "/topic/" + input.getTopic();
				}
			});
			log.debug("Queue tracker {} contained {} messages, now removing", trackingId, pushes.size());
			queues.remove(trackingId);
			return pushes;
		}
	}

}

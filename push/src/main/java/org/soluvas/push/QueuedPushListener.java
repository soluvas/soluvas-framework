package org.soluvas.push;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.SynchronousQueue;

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
		
		Queue<PushMessage> queue = queues.get(trackingId);
		if (queue == null) {
			queue = new SynchronousQueue<PushMessage>();
			queues.put(trackingId, queue);
		}
		queue.add(message);
	}
	
	public Map<String, PushMessage> getPushesAndRemove(String trackingId) {
		Queue<PushMessage> queue = queues.get(trackingId);
		if (queue == null) {
			return ImmutableMap.of();
		}
		ImmutableMap<String, PushMessage> pushes = Maps.uniqueIndex(queue, new Function<PushMessage, String>() {
			@Override
			public String apply(PushMessage input) {
				return "/topic/" + input.getTopic();
			}
		});
		queues.remove(trackingId);
		return pushes;
	}

}

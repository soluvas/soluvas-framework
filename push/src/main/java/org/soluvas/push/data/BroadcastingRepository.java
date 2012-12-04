package org.soluvas.push.data;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.json.JsonUtils;
import org.soluvas.push.CollectionAdd;
import org.soluvas.push.CollectionDelete;
import org.soluvas.push.CollectionUpdate;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * A repository that broadcasts {@link CollectionAdd},
 * {@link CollectionDelete}, and {@link CollectionUpdate} messages
 * when data is changed.
 * @author ceefour
 * @todo Support Akka Future-based Repository.
 */
public class BroadcastingRepository<T, ID extends Serializable> implements SyncRepository<T, ID> {

	private static final Logger log = LoggerFactory.getLogger(BroadcastingRepository.class);
	private final SyncRepository<T, ID> delegate;
	private final Channel channel;
	private final String trackingId;
	private final String topic;
	
	public BroadcastingRepository(SyncRepository delegate, Connection amqp,
			String trackingId, String topic) throws IOException {
		super();
		this.delegate = delegate;
		this.trackingId = trackingId;
		this.topic = topic;
		channel = amqp.createChannel();
	}
	
	public void destroy() {
		try {
			channel.close();
		} catch (IOException e) {
			log.warn("Cannot close AMQP Channel", e);
		}
	}

	@Override
	public T findOne(ID id) {
		return delegate.findOne(id);
	}

	@Override
	public List<T> findAll() {
		return delegate.findAll();
	}

	@Override
	public T create(T entry) {
		T result = delegate.create(entry);
		CollectionAdd<T> push = new CollectionAdd<T>(trackingId, topic, topic, result);
		String pushJson = JsonUtils.asJson(push);
		log.info("Publishing CollectionAdd {} to {}", result, topic);
		try {
			channel.basicPublish("amq.topic", topic, null, pushJson.getBytes());
		} catch (IOException e) {
			log.error("Cannot publish CollectionAdd " + result + " to " + topic, e);
		}
		return result;
	}

	@Override
	public T update(ID id, T entry) {
		T result = delegate.update(id, entry);
		CollectionUpdate<T> push = new CollectionUpdate<T>(trackingId, topic, topic, String.valueOf(id), result);
		String pushJson = JsonUtils.asJson(push);
		log.info("Publishing CollectionUpdate {} to {}", result, topic);
		try {
			channel.basicPublish("amq.topic", topic, null, pushJson.getBytes());
		} catch (IOException e) {
			log.error("Cannot publish CollectionUpdate " + result + " to " + topic, e);
		}
		return result;
	}

	@Override
	public void delete(ID id) {
		delegate.delete(id);
		CollectionDelete push = new CollectionDelete(trackingId, topic, topic, String.valueOf(id));
		String pushJson = JsonUtils.asJson(push);
		log.info("Publishing CollectionDelete {} to {}", id, topic);
		try {
			channel.basicPublish("amq.topic", topic, null, pushJson.getBytes());
		} catch (IOException e) {
			log.error("Cannot publish CollectionDelete " + id + " to " + topic, e);
		}
	}

}

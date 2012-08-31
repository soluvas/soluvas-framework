package org.soluvas.push;

import java.io.IOException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.json.JsonUtils;

import com.google.common.eventbus.Subscribe;
import com.rabbitmq.client.Channel;

/**
 * Publishes messages through an AMQP Channel.
 * @author ceefour
 */
public class AmqpPushListener implements PushListener {

	private transient Logger log = LoggerFactory.getLogger(AmqpPushListener.class);
	@Inject private Channel amqpChannel;

	/* (non-Javadoc)
	 * @see id.co.bippo.commerce.push.PushListener#publishPublic(java.lang.String, org.soluvas.push.PushMessage)
	 */
	@Override @Subscribe
	public void publishPublic(PushMessage message) {
		final String json = JsonUtils.asJson(message);
		log.debug("Publishing to AMQP topic {}: {}", message.getTopic(), json);
		try {
			amqpChannel.basicPublish("amq.topic", message.getTopic(), null,
					json.getBytes());
		} catch (IOException e) {
			log.error("Cannot publish to AMQP topic " + message.getTopic() + ": " + json, e);
			throw new RuntimeException("Cannot publish to AMQP topic " + message.getTopic() + ": " + json, e);
		}
	}
	
}

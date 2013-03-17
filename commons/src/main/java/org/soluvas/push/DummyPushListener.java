package org.soluvas.push;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.json.JsonUtils;

import com.google.common.eventbus.Subscribe;

/**
 * Simply logs published messages.
 * @author ceefour
 */
public class DummyPushListener implements PushListener {

	private static final Logger log = LoggerFactory.getLogger(DummyPushListener.class);

	/* (non-Javadoc)
	 * @see id.co.bippo.commerce.push.PushListener#publishPublic(java.lang.String, org.soluvas.push.PushMessage)
	 */
	@Override @Subscribe
	public void publishPublic(PushMessage message) {
		final String json = JsonUtils.asJson(message);
		log.debug("Publish message requested to topic {}: {}", message.getTopic(), json);
	}

}

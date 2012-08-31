package org.soluvas.push;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Map;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author rudi
 *
 */
public class QueuedPushListenerTest {

	private transient Logger log = LoggerFactory
			.getLogger(QueuedPushListenerTest.class);
	private QueuedPushListener queuer;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		queuer = new QueuedPushListener();
	}

	@Test
	public void pushToQueue() {
		String trackingId = UUID.randomUUID().toString();
		String topic = "test";
		String collection = "test";
		String entry = "Halooooo";
		queuer.publishPublic(new CollectionAdd<String>(trackingId, topic, collection, entry ));
		Map<String, PushMessage> pushes = queuer.getPushesAndRemove(trackingId);
		log.info("Pushes of {}: {}", trackingId, pushes);
		assertNotNull(pushes);
		assertThat(pushes.values(), hasSize(1));
	}

}

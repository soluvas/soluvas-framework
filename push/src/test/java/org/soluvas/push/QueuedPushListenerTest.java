package org.soluvas.push;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

	private static Logger log = LoggerFactory
			.getLogger(QueuedPushListenerTest.class);
	private PushMessageTrackerImpl queuer;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		queuer = new PushMessageTrackerImpl();
	}

	@Test
	public void pushToQueue() {
		final String trackingId = UUID.randomUUID().toString();
		final String topic = "test";
		final String collection = "test";
		final String entry = "Halooooo";
		queuer.publishPublic(new CollectionAdd<String>(trackingId, topic, collection, entry ));
		final Map<String, PushMessage> pushes = queuer.getPushesAndRemove(trackingId);
		log.info("Pushes of {}: {}", trackingId, pushes);
		assertNotNull(pushes);
		assertEquals(1, pushes.size());
	}

}

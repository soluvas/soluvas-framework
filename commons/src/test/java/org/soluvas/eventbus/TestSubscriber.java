package org.soluvas.eventbus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.eventbus.Subscribe;

public class TestSubscriber {

	private transient Logger log = LoggerFactory
			.getLogger(TestSubscriber.class);
	
	public TestSubscriber() {
		log.info("Bikin subscriber test");
	}
	
	@Subscribe
	public void handleAnything(Object event) {
		log.info("Waw ada {}", event);
	}
}

package org.soluvas.push;

import com.google.common.eventbus.EventBus;

/**
 * Implementations can publish messages to a message channel e.g. AMQP.
 * Also may buffer messages to be passed via XHR/REST response and simulated by JavaScript client.
 * 
 * @deprecated To be deprecated. Replacements are: 1. Use {@link EventBus}. 2. Use callbacks (i.e. reactive Mongo/Play style).
 * 
 * @author ceefour
 */
@Deprecated
public interface PushListener {

	void publishPublic(PushMessage message);

}

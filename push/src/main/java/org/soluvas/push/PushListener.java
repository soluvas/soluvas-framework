package org.soluvas.push;


import com.google.common.eventbus.EventBus;

/**
 * Implementations can publish messages to a message channel e.g. AMQP.
 * Also may buffer messages to be passed via XHR/REST response and simulated by JavaScript client.
 * 
 * to be @deprecated Use {@link EventBus}.
 * 
 * @author ceefour
 */
@Deprecated
public interface PushListener {

	void publishPublic(PushMessage message);

}

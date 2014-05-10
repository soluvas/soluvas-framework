package org.soluvas.commons;

import com.google.common.eventbus.EventBus;

/**
 * See <a href="https://code.google.com/p/guava-libraries/issues/detail?id=1749">guava #1749</a>
 * @author rudi
 * @see IdAsyncEventBus
 */
public class IdEventBus extends EventBus {

	private final String identifier;
	
	public IdEventBus() {
		super();
		this.identifier = "default";
	}

	/**
	 * @param identifier
	 */
	public IdEventBus(String identifier) {
		super(identifier);
		this.identifier = identifier;
	}
	
	public String getIdentifier() {
		return identifier;
	}

	@Override
	public String toString() {
		return "EventBus ["
				+ (identifier != null ? "identifier=" + identifier : "") + "]";
	}

}

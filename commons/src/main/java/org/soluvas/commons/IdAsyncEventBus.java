package org.soluvas.commons;

import java.util.concurrent.Executor;

import com.google.common.eventbus.AsyncEventBus;

/**
 * See <a href="https://code.google.com/p/guava-libraries/issues/detail?id=1749">guava #1749</a>
 * @author rudi
 * @see IdEventBus
 */
public class IdAsyncEventBus extends AsyncEventBus {

	private final String identifier;

	/**
	 * @param executor
	 */
	public IdAsyncEventBus(Executor executor) {
		super(executor);
		this.identifier = "default";
	}

	/**
	 * @param identifier
	 * @param executor
	 */
	public IdAsyncEventBus(String identifier, Executor executor) {
		super(identifier, executor);
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

package org.soluvas.jaxrs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rudi
 *
 */
public class CatalogMessageOnly {
	
	private Map<String, List<MessageOnly>> messages;

	public CatalogMessageOnly() {
		super();
	}
	
	/**
	 * Initialize for messages group by INFO, WARN and ERROR.
	 */
	public CatalogMessageOnly initMessages() {
		this.messages = new HashMap<>();
		this.messages.put(MessageOnly.INFO_STATUS, new ArrayList<MessageOnly>());
		this.messages.put(MessageOnly.WARN_STATUS, new ArrayList<MessageOnly>());
		this.messages.put(MessageOnly.ERROR_STATUS, new ArrayList<MessageOnly>());
		return this;
	}

	public Map<String, List<MessageOnly>> getMessageMap() {
		return messages;
	}

	public void setMessageMap(Map<String, List<MessageOnly>> messageMap) {
		this.messages = messageMap;
	}

	@Override
	public String toString() {
		return "CatalogMessageOnly [messageMap=" + messages + "]";
	}
	
}

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
	
	private Map<String, List<MessageOnly>> messageMap;

	public CatalogMessageOnly() {
		super();
	}
	
	/**
	 * Initialize for messages group by INFO, WARN and ERROR.
	 */
	public CatalogMessageOnly byDefault() {
		this.messageMap = new HashMap<>();
		this.messageMap.put(MessageOnly.INFO_STATUS, new ArrayList<MessageOnly>());
		this.messageMap.put(MessageOnly.WARN_STATUS, new ArrayList<MessageOnly>());
		this.messageMap.put(MessageOnly.ERROR_STATUS, new ArrayList<MessageOnly>());
		return this;
	}

	public Map<String, List<MessageOnly>> getMessageMap() {
		return messageMap;
	}

	public void setMessageMap(Map<String, List<MessageOnly>> messageMap) {
		this.messageMap = messageMap;
	}

	@Override
	public String toString() {
		return "CatalogMessageOnly [messageMap=" + messageMap + "]";
	}
	
}

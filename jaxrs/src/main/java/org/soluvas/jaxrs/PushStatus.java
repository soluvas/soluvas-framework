package org.soluvas.jaxrs;

import java.util.Map;

import org.soluvas.push.PushMessage;

/**
 * @author rudi
 */
@SuppressWarnings("rawtypes")
public class PushStatus<T> extends Status {

	private T data;
	private Map<String, PushMessage> pushes;
	
	public PushStatus() {
		super();
	}

	public PushStatus(T data, Map<String, PushMessage> pushes) {
		super("success");
		this.data = data;
		this.pushes = pushes;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("DataStatus [data=%s]", data);
	}

	/**
	 * @return the pushes
	 */
	public Map<String, PushMessage> getPushes() {
		return pushes;
	}

	/**
	 * @param pushes the pushes to set
	 */
	public void setPushes(Map<String, PushMessage> pushes) {
		this.pushes = pushes;
	}
	
}

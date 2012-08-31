package org.soluvas.push;

import java.io.Serializable;

import org.soluvas.json.JsonUtils;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * @author ceefour
 */
@SuppressWarnings("serial")
@JsonTypeInfo(use=Id.CLASS)
//@org.codehaus.jackson.annotate.JsonTypeInfo(use=org.codehaus.jackson.annotate.JsonTypeInfo.Id.CLASS)
public class PushMessage extends TrackableEvent {

	private String topic;
	
	public PushMessage() {
	}
	
	public PushMessage(String trackingId, String topic) {
		super(trackingId);
		this.topic = topic;
	}

	/**
	 * @return the topic
	 */
	public String getTopic() {
		return topic;
	}

	/**
	 * @param topic the topic to set
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return JsonUtils.asJson(this);
	}

}

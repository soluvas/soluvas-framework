package org.soluvas.email;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.soluvas.commons.Identifiable;

import com.google.code.morphia.annotations.Id;

@SuppressWarnings("serial")
public class BouncedEmail implements Serializable, Identifiable {
	
	public static final long schemaVersion = 1l;

	@Id
	private String id;
	private String email;
	private String bounceType;
	private Date timestamp;
	private Map<String, Integer> count;
	
	@Override
	public String getId() {
		return id;
	}
	@Override
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBounceType() {
		return bounceType;
	}
	public void setBounceType(String bounceType) {
		this.bounceType = bounceType;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public Map<String, Integer> getCount() {
		return count;
	}
	public void setCount(Map<String, Integer> count) {
		this.count = count;
	}
	
}

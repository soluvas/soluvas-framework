package org.soluvas.newsletter;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataResponse {
	private String contactId;
	private String name;
	private String email;
	private String action;
	private Map<String, Object> properties;
	
	public DataResponse() {
		super();
	}
	
	public String getContactID() {
		return contactId;
	}
	
	@JsonProperty("ContactID")
	public void setContactID(String contactID) {
		contactId = contactID;
	}
	
	public String getName() {
		return name;
	}
	
	@JsonProperty("Name")
	public void setName(String name) {
		name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	@JsonProperty("Email")
	public void setEmail(String email) {
		email = email;
	}
	
	public String getAction() {
		return action;
	}
	
	@JsonProperty("Action")
	public void setAction(String action) {
		action = action;
	}
	
	public Map<String, Object> getProperties() {
		return properties;
	}

	@JsonProperty("Properties")
	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}
	
	@Override
	public String toString() {
		return "DataResponse [ContactID=" + contactId + ", Name=" + name
				+ ", Email=" + email + ", Action=" + action + "]";
	}
	
	
}

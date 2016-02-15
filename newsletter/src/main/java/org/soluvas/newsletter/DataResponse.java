package org.soluvas.newsletter;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataResponse {
	@JsonProperty("ContactID")
	private String contactId;
	@JsonProperty("Name")
	private String name;
	@JsonProperty("Email")
	private String email;
	@JsonProperty("Action")
	private String action;
	@JsonProperty("Properties")
	private Map<String, Object> properties;
	
	
	public String getContactID() {
		return contactId;	
	}
	
	
	public void setContactID(String contactID) {
		this.contactId = contactID;
	}
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}


	@Override
	public String toString() {
		return "DataResponse [contactId=" + contactId + ", name=" + name
				+ ", email=" + email + ", action=" + action + ", properties="
				+ properties + "]";
	}
	
}

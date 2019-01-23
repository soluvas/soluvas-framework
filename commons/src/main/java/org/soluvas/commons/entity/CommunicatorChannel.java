package org.soluvas.commons.entity;

import java.io.Serializable;

import org.soluvas.commons.Identifiable;

import com.google.code.morphia.annotations.Id;

public class CommunicatorChannel implements Serializable, Identifiable {
	private static final long serialVersionUID = 1L;
	
	private String number;
	private Boolean primary;
	private Boolean wa;
	private Boolean sms;
	
	@Id
	private String id;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String value) {
		this.id = value;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Boolean getPrimary() {
		return primary;
	}

	public void setPrimary(Boolean primary) {
		this.primary = primary;
	}

	public Boolean getWa() {
		return wa;
	}

	public void setWa(Boolean wa) {
		this.wa = wa;
	}

	public Boolean getSms() {
		return sms;
	}

	public void setSms(Boolean sms) {
		this.sms = sms;
	}

	@Override
	public String toString() {
		return "CommunicatorChanel [number=" + number + ", primary=" + primary + ", wa=" + wa + ", sms=" + sms + ", id="
				+ id + "]";
	}
	
}

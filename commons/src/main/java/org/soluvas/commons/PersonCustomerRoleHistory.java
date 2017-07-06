package org.soluvas.commons;

import org.joda.time.DateTime;

public class PersonCustomerRoleHistory implements Identifiable {
	private String id;
	private PersonInfo personInfo;
	private String customerRole;
	private PersonInfo updatedBy;
	private DateTime creationTime;
	
	@Override
	public String getId() {
		return null;
	}

	@Override
	public void setId(String value) {
		
	}

	
}

package org.soluvas.commons;

import org.joda.time.DateTime;
import org.soluvas.commons.mongo.DateTimeConverter;

import com.google.code.morphia.annotations.Converters;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Property;

@Entity 
@Converters({DateTimeConverter.class})
public class PersonCustomerRoleHistory implements Identifiable {
	@Id @Property("id")
	private String id;
	private PersonInfo2 personInfo;
	private String customerRole;
	private DateTime creationTime;
	private DateTime modificationTime;
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String value) {
		this.id = value;
	}

	public PersonInfo2 getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo2 personInfo) {
		this.personInfo = personInfo;
	}

	public DateTime getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(DateTime creationTime) {
		this.modificationTime = creationTime;
	}

	public String getCustomerRole() {
		return customerRole;
	}

	public void setCustomerRole(String customerRole) {
		this.customerRole = customerRole;
	}

	public DateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(DateTime creationTime) {
		this.creationTime = creationTime;
	}

	@Override
	public String toString() {
		return "PersonCustomerRoleHistory [id=" + id + ", personInfo=" + personInfo + ", customerRole=" + customerRole
				+ ", creationTime=" + creationTime + ", modificationTime=" + modificationTime + "]";
	}
	
	
}

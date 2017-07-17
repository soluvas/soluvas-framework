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
	private String fromCustomerRole;
	private String toCustomerRole;
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

	public String getFromCustomerRole() {
		return fromCustomerRole;
	}

	public void setFromCustomerRole(String fromCustomerRole) {
		this.fromCustomerRole = fromCustomerRole;
	}

	public String getToCustomerRole() {
		return toCustomerRole;
	}

	public void setToCustomerRole(String toCustomerRole) {
		this.toCustomerRole = toCustomerRole;
	}

	public DateTime getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(DateTime creationTime) {
		this.modificationTime = creationTime;
	}

	@Override
	public String toString() {
		return "PersonCustomerRoleHistory [id=" + id + ", personInfo=" + personInfo + ", fromCustomerRole="
				+ fromCustomerRole + ", toCustomerRole=" + toCustomerRole + ", modificationTime=" + modificationTime
				+ "]";
	}
	
	
}

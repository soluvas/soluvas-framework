package org.soluvas.security;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author anisa
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, property="@type", defaultImpl=DomainPermission2.class)
@JsonSubTypes(@JsonSubTypes.Type(name="DomainPermission", value=DomainPermission2.class))
public class DomainPermission2 implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String name;
	
	private String description;
	
	private List<ActionPermission> actionPermission;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ActionPermission> getActionPermission() {
		return actionPermission;
	}

	public void setActionPermission(List<ActionPermission> actionPermission) {
		this.actionPermission = actionPermission;
	}

	@Override
	public String toString() {
		return "DomainPermission2 [id=" + id + ", name=" + name + ", description=" + description + ", actionPermission="
				+ actionPermission + "]";
	}

}

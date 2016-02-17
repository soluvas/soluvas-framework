package org.soluvas.security;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author anisa
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, property="@type", defaultImpl=ActionPermission.class)
@JsonSubTypes(@JsonSubTypes.Type(name="ActionPermission", value=ActionPermission.class))
public class ActionPermission implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String name;
	
	private String description;
	
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

	@Override
	public String toString() {
		return "ActionPermission [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}

package org.soluvas.security;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author anisa
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, property="@type", defaultImpl=DomainPermissionCatalog.class)
@JsonSubTypes(@JsonSubTypes.Type(name="DomainPermissionCatalog", value=DomainPermissionCatalog.class))
public class DomainPermissionCatalog {
	
	private final List<DomainPermission2> domainPermissions = new ArrayList<>();

	public List<DomainPermission2> getDomainPermissions() {
		return domainPermissions;
	}

}

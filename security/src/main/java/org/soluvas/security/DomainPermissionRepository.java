package org.soluvas.security;

import java.io.IOException;
import java.util.Collection;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.common.collect.ImmutableCollection;

/**
 * @author rudi
 *
 */
public interface DomainPermissionRepository {

	void init() throws JsonParseException, JsonMappingException, IOException;
	
	DomainPermission2 findOne(String domainId);
	
	ImmutableCollection<DomainPermission2> findAll();
	
	Collection<DomainPermission2> findAll(Collection<String> domainIds);
	
}
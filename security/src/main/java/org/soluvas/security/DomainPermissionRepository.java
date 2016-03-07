package org.soluvas.security;

import java.io.IOException;
import java.util.Collection;

import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.common.collect.ImmutableCollection;

/**
 * @author anisa
 *
 */

//interface adalah standarisasi implementasi
public interface DomainPermissionRepository {

	void init() throws JsonParseException, JsonMappingException, IOException;
	
	//return type value //nama method di implementasi //nama parameter yang bertype data string 
	DomainPermission2 findOne(String domainId);
	
	ImmutableCollection<DomainPermission2> findAll();
	
	Collection<DomainPermission2> findAll(Collection<String> domainIds);

	Page<DomainPermission2> findAllBySearchText(String searchText, Pageable pageable);

	long countBase(String searchText);

}
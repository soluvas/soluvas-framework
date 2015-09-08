package org.soluvas.data;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.common.collect.ImmutableCollection;

/**
 * @author rudi
 *
 */
public interface TermKindRepository {

	void init() throws JsonParseException, JsonMappingException, IOException;
	
	TermKind findOne(String id);
	
	TermKind getColor();
	
	TermKind getApparelSize();
	
	TermKind getShoeSize();
	
	ImmutableCollection<TermKind> findAll();
	
	Collection<TermKind> findAll(Collection<String> ids);
	
	List<TermKind> findAllByIdPropertyDefinition(String id);


}
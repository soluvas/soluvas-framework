package org.soluvas.data;

import java.io.IOException;
import java.util.Collection;

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
	
	ImmutableCollection<TermKind> findAll();
	
	Collection<TermKind> findAll(Collection<String> ids);

}
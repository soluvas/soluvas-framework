package org.soluvas.data;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author rudi
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, property="@type", defaultImpl=Term2Catalog.class)
@JsonSubTypes(@JsonSubTypes.Type(name="TermCatalog", value=Term2Catalog.class))
public class Term2Catalog {
	
	final List<Term2> data = new ArrayList<>();
	
	public List<Term2> getData() {
		return data;
	}

}

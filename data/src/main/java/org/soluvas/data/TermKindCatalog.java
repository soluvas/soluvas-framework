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
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, property="@type", defaultImpl=TermKindCatalog.class)
@JsonSubTypes(@JsonSubTypes.Type(name="TermKindCatalog", value=TermKindCatalog.class))
public class TermKindCatalog {
	
	final List<TermKind> termKinds = new ArrayList<>();

	public List<TermKind> getTermKinds() {
		return termKinds;
	}
	
}

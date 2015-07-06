package org.soluvas.category;

import java.io.Serializable;
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
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, property="@type", defaultImpl=FormalCategoryCatalog.class)
@JsonSubTypes(@JsonSubTypes.Type(name="FormalCategoryCatalog", value=FormalCategoryCatalog.class))
public class FormalCategoryCatalog implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final List<FormalCategory> formalCategories = new ArrayList<>();;

	public List<FormalCategory> getFormalCategories() {
		return formalCategories;
	}

}

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
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, property="@type", defaultImpl=DataCatalog2.class)
@JsonSubTypes(@JsonSubTypes.Type(name="DataCatalog", value=DataCatalog2.class))
public class DataCatalog2 {
	
	final List<PropertyDefinition> propertyDefinitions = new ArrayList<>();

	public List<PropertyDefinition> getPropertyDefinitions() {
		return propertyDefinitions;
	}
	
}

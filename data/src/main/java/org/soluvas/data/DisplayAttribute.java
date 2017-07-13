package org.soluvas.data;

import java.io.Serializable;
import java.util.List;

/**
 * Simple data structure used to hold a principal or attribute {@link Attribute}
 * and a corresponding singular {@link Value}. The value can be {@code null}.
 * Usually used with a ListView and ValueLabel.
 * @author rudi
 */
public class DisplayAttribute implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private final PropertyDefinition propertyDefinition;
	private final List<String> values;
	
	public DisplayAttribute(PropertyDefinition propertyDefinition, List<String> values) {
		super();
		this.propertyDefinition = propertyDefinition;
		this.values = values;
	}

	/**
	 * @return the propertyDefinition
	 */
	public PropertyDefinition getPropertyDefinition() {
		return propertyDefinition;
	}

	/**
	 * @return the values
	 */
	public List<String> getValues() {
		return values;
	}
	
}

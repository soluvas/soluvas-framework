package org.soluvas.data;

import java.io.Serializable;
import java.util.List;

/**
 * Simple data structure used to hold a principal or attribute {@link Attribute}
 * and a corresponding singular {@link Value}. The value can be {@code null}.
 * Usually used with a ListView and ValueLabel.
 * @author haidar
 */
public class DisplayAttribute2 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private final String attrDisplayName;
	private final List<Value<?>> values;
	
	public DisplayAttribute2(String attrDisplayName, List<Value<?>> values) {
		super();
		this.attrDisplayName = attrDisplayName;
		this.values = values;
	}

	/**
	 * @return the attrDisplayName
	 */
	public String getAttrDisplayName() {
		return attrDisplayName;
	}

	/**
	 * @return the values
	 */
	public List<Value<?>> getValues() {
		return values;
	}
	
}
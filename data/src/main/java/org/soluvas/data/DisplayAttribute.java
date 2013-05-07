package org.soluvas.data;

import javax.annotation.Nullable;

/**
 * Simple data structure used to hold a principal or attribute {@link Attribute}
 * and a corresponding singular {@link Value}. The value can be {@code null}.
 * Usually used with a ListView and ValueLabel.
 * @author haidar
 */
public class DisplayAttribute {
	private final String attrDisplayName;
	private final Value<?> value;
	
	public DisplayAttribute(String principalDisplayName,
			@Nullable Value<?> principalValue) {
		super();
		this.attrDisplayName = principalDisplayName;
		this.value = principalValue;
	}

	public String getAttrDisplayName() {
		return attrDisplayName;
	}

	@Nullable
	public Value<?> getValue() {
		return value;
	}

}
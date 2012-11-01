/**
 * 
 */
package org.soluvas.data.query;

import java.io.Serializable;

/**
 * @author rudi
 *
 */
@SuppressWarnings("serial")
public class Criterion<T> implements Serializable {
	
	private String fieldName;
	private T equalsToValue;
	
	public Criterion() {
		super();
	}
	
	public Criterion(String fieldName, T equalsToValue) {
		super();
		this.fieldName = fieldName;
		this.equalsToValue = equalsToValue;
	}

	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * @return the equalsToValue
	 */
	public T getEqualsToValue() {
		return equalsToValue;
	}

	/**
	 * @param equalsToValue the equalsToValue to set
	 */
	public void setEqualsToValue(T equalsToValue) {
		this.equalsToValue = equalsToValue;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Criterion [fieldName=%s, equalsToValue=%s]",
				fieldName, equalsToValue);
	}
	
}

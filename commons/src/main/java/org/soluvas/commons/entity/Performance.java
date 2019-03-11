/**
 * 
 */
package org.soluvas.commons.entity;

/**
 * @author atang
 *
 */
public class Performance {
	private String personId;
	private Double value;
	
	public Performance(String personId, Double value) {
		super();
		this.personId = personId;
		this.value = value;
	}

	public String getPersonId() {
		return personId;
	}

	public Double getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "PersonPerformance [personId=" + personId + ", value=" + value + "]";
	}
	
	
}

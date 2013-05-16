package org.soluvas.mongo;

import java.io.Serializable;

import javax.measure.unit.Unit;

import org.soluvas.commons.mongo.UnitConverter;

import com.google.code.morphia.annotations.Converters;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity @Converters(UnitConverter.class)
public class UnitProduct implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id private String id;
	private Unit unit;

	public UnitProduct() {
		super();
	}

	public UnitProduct(String id, Unit unit) {
		super();
		this.id = id;
		this.unit = unit;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the unit
	 */
	public Unit getUnit() {
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UnitProduct [" + (id != null ? "id=" + id + ", " : "")
				+ (unit != null ? "unit=" + unit : "") + "]";
	}
	
}

package org.soluvas.category;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

/**
 * @author rudi
 *
 */
public class Option implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String kind;
	
	private Class<? extends Quantity> qty;
	
	private Unit<?> unit;
	
	private String name;
	
	private String description;
	
	private Map<String, Map<String, String>> translations = new HashMap<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public Class<? extends Quantity> getQty() {
		return qty;
	}

	public void setQty(Class<? extends Quantity> qty) {
		this.qty = qty;
	}

	public Unit<?> getUnit() {
		return unit;
	}

	public void setUnit(Unit<?> unit) {
		this.unit = unit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Map<String, Map<String, String>> getTranslations() {
		return translations;
	}

	public void setTranslations(Map<String, Map<String, String>> translations) {
		this.translations = translations;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Option other = (Option) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (kind == null) {
			if (other.kind != null)
				return false;
		} else if (!kind.equals(other.kind))
			return false;
		return true;
	}
	
}

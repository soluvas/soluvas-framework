package org.soluvas.data;

import java.io.Serializable;

import javax.measure.unit.Unit;

import org.soluvas.commons.mongo.UnitConverter;

import com.google.code.morphia.annotations.Converters;

/**
 * @author eki
 *
 */
@Converters({UnitConverter.class})
public class PropertyDefinitionInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public final static String NAME_ATTR = "name";
	public final static String DESCRIPTION_ATTR = "description";
	
	private String id;
	private String name;
	private String defaultEnum;
	private PropertyKind defaultKind;
	private Unit<?> defaultUnit;
	
	public PropertyDefinitionInfo() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDefaultEnum() {
		return defaultEnum;
	}

	public void setDefaultEnum(String defaultEnum) {
		this.defaultEnum = defaultEnum;
	}

	public PropertyKind getDefaultKind() {
		return defaultKind;
	}

	public void setDefaultKind(PropertyKind defaultKind) {
		this.defaultKind = defaultKind;
	}

	public Unit<?> getDefaultUnit() {
		return defaultUnit;
	}

	public void setDefaultUnit(Unit<?> defaultUnit) {
		this.defaultUnit = defaultUnit;
	}

	@Override
	public String toString() {
		return "PropertyDefinitionInfo [id=" + id + ", name=" + name + ", defaultEnum=" + defaultEnum + ", defaultKind="
				+ defaultKind + ", defaultUnit=" + defaultUnit + "]";
	}

	public void copyFrom(PropertyDefinition object) {
		setDefaultEnum(object.getDefaultEnum());
		setDefaultKind(object.getDefaultKind());
		setDefaultUnit(object.getDefaultUnit());
		setId(object.getId());
		setName(object.getName());
	}
	
}

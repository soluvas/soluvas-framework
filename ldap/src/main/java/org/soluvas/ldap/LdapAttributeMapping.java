package org.soluvas.ldap;

import java.lang.reflect.Field;

public class LdapAttributeMapping {
	
	private final Field field;
	private final String name;
	private final boolean multi;
	
	/**
	 * @param field
	 * @param name
	 * @param multi
	 */
	public LdapAttributeMapping(Field field, String name, boolean multi) {
		super();
		this.field = field;
		this.name = name;
		this.multi = multi;
	}

	/**
	 * @return the field
	 */
	public Field getField() {
		return field;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the multi
	 */
	public boolean isMulti() {
		return multi;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LdapAttributeMapping ["
				+ (field != null ? "field=" + field + ", " : "")
				+ (name != null ? "name=" + name + ", " : "") + "multi="
				+ multi + "]";
	}

}

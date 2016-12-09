package org.soluvas.geo;

import com.google.common.base.Strings;

import java.io.Serializable;
import java.util.Comparator;

public class Province implements Serializable, Comparable<Province> {
	
	private final String name;
	private final Country country;

	public Province(String name, Country country) {
		this.name = name;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public Country getCountry() {
		return country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Province other = (Province) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Province [" + (name != null ? "name=" + name + ", " : "")
				+ (country != null ? "country=" + country : "") + "]";
	}

	@Override
	public int compareTo(Province o) {
		return Strings.nullToEmpty(name).compareToIgnoreCase(o.getName());
	}
}

package org.soluvas.geo;

import java.io.Serializable;

/**
 * @author rudi
 *
 */
public class City implements Serializable {
	
	private final String name;
	private final String normalizedName;
	private final Country country;
	
	public City(String name, String normalizedName, Country country) {
		super();
		this.name = name;
		this.normalizedName = normalizedName;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	/**
	 * @todo Should we actually store this?
	 * @return
	 */
	public String getNormalizedName() {
		return normalizedName;
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
		if (!(obj instanceof City))
			return false;
		City other = (City) obj;
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
		return "City ["
				+ (name != null ? "name=" + name + ", " : "")
				+ (normalizedName != null ? "normalizedName=" + normalizedName
						+ ", " : "")
				+ (country != null ? "country=" + country.getIso() : "")
				+ "]";
	}
	
}

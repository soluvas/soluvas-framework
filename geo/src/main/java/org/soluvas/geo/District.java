package org.soluvas.geo;

import java.io.Serializable;

/**
 * @author anton
 *
 */
public class District implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private final String name;
	private final Country country;
	private final City city;
	
	public District(String name, Country country, City city) {
		super();
		this.name = name;
		this.country = country;
		this.city = city;
	}

	public City getCity() {
		return city;
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
		result = prime * result + ((city == null) ? 0 : city.hashCode());
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
		District other = (District) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
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
		return "District [" + (name != null ? "name=" + name + ", " : "")
				+ (country != null ? "country=" + country + ", " : "")
				+ (city != null ? "city=" + city : "") + "]";
	}
	
}

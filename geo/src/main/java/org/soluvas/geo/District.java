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
	private final String province;
	private final String city;
	private final String areaCode;
	
	
	public District(String name, Country country, String province, String city, String areaCode) {
		super();
		this.name = name;
		this.country = country;
		this.province = province;
		this.city = city;
		this.areaCode = areaCode;
	}
	
	public String getName() {
		return name;
	}
	
	public Country getCountry() {
		return country;
	}
	
	public String getProvince() {
		return province;
	}
	
	public String getCity() {
		return city;
	}

	public String getAreaCode() {
		return areaCode;
	}

	@Override
	public String toString() {
		return "District [name=" + name + ", country=" + country + ", province=" + province + ", city=" + city
				+ ", areaCode=" + areaCode + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((areaCode == null) ? 0 : areaCode.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((province == null) ? 0 : province.hashCode());
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
		if (areaCode == null) {
			if (other.areaCode != null)
				return false;
		} else if (!areaCode.equals(other.areaCode))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
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
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		return true;
	}
	
}

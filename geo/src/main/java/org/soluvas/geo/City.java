package org.soluvas.geo;

import java.io.Serializable;

import javax.annotation.Nullable;

/**
 * @author rudi
 *
 */
public class City implements Serializable {
	
	private final String name;
	private final String normalizedName;
	private final String province;
	private final Country country;
	
	public City(String name, String normalizedName, @Nullable String province, Country country) {
		super();
		this.name = name;
		this.normalizedName = normalizedName;
		this.province = province;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public String getNormalizedName() {
		return normalizedName;
	}

	public String getProvince() {
		return province;
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
		result = prime * result
				+ ((normalizedName == null) ? 0 : normalizedName.hashCode());
		result = prime * result
				+ ((province == null) ? 0 : province.hashCode());
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
		if (normalizedName == null) {
			if (other.normalizedName != null)
				return false;
		} else if (!normalizedName.equals(other.normalizedName))
			return false;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "City ["
				+ (name != null ? "name=" + name + ", " : "")
				+ (normalizedName != null ? "normalizedName=" + normalizedName
						+ ", " : "")
				+ (province != null ? "province=" + province + ", " : "")
				+ (country != null ? "country=" + country : "") + "]";
	}

}
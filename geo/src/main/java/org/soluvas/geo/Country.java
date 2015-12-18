package org.soluvas.geo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Currently sourced from <a href="https://github.com/mledoze/countries">https://github.com/mledoze/countries</a>.
 * Previously from <a href="http://download.geonames.org/export/dump/countryInfo.txt">http://download.geonames.org/export/dump/countryInfo.txt</a>.
 * @author rudi
 * @see GeoNamesCountryRepository
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Country implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String iso;
	private final String iso3;
	private final String name;
	@JsonProperty("callingCode")
	private List<String> callingCodes = new ArrayList<>();
	@JsonProperty("currency")
	private List<String> currencies = new ArrayList<>();

	public Country(String iso, String iso3, String name) {
		super();
		this.iso = iso;
		this.iso3 = iso3;
		this.name = name;
	}

	@JsonCreator
	public Country(@JsonProperty("cca2") String iso, @JsonProperty("cca3")String iso3, @JsonProperty("name") Map<String, Object> name) {
		super();
		this.iso = iso;
		this.iso3 = iso3;
		this.name = (String) name.get("common");
	}

	/**
	 * Country code using <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO-3166-1 alpha-2</a>.
	 * @return
	 */
	public String getIso() {
		return iso;
	}
	
	/**
	 * Country code using <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-3">ISO-3166-1 alpha-3</a>.
	 * @return
	 */
	public String getIso3() {
		return iso3;
	}

	public String getName() {
		return name;
	}

	public List<String> getCallingCodes() {
		return callingCodes;
	}

	public List<String> getCurrencies() {
		return currencies;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iso == null) ? 0 : iso.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Country))
			return false;
		Country other = (Country) obj;
		if (iso == null) {
			if (other.iso != null)
				return false;
		} else if (!iso.equals(other.iso))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Country [" + (iso != null ? "iso=" + iso + ", " : "")
				+ (name != null ? "name=" + name : "") + "]";
	}
	
}

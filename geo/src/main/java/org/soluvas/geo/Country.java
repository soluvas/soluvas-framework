package org.soluvas.geo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Strings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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
public class Country implements Serializable, Comparable<Country> {

	private static final long serialVersionUID = 1L;

	public static class Translation implements Serializable {
		private String official;
		private String common;

		public String getOfficial() {
			return official;
		}

		public void setOfficial(String official) {
			this.official = official;
		}

		public String getCommon() {
			return common;
		}

		public void setCommon(String common) {
			this.common = common;
		}
	}

	private final String iso;
	private final String iso3;
	private final String name;
	@JsonProperty("tld")
	private List<String> tlds = new ArrayList<>();
	private String ccn3;
	private String cioc;
	@JsonProperty("callingCode")
	private List<String> callingCodes = new ArrayList<>();
	@JsonProperty("currency")
	private List<String> currencies = new ArrayList<>();
	private String capital;
	private List<String> altSpellings = new ArrayList<>();
	private String region;
	private String subregion;
	private Map<String, String> languages = new LinkedHashMap<>();
	private Map<String, Translation> translations = new LinkedHashMap<>();
	private float[] latlng;
	private String demonym;
	private Boolean landlocked;
	private List<String> borders = new ArrayList<>();
	private Float area;

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

	public String getCcn3() {
		return ccn3;
	}

	public void setCcn3(String ccn3) {
		this.ccn3 = ccn3;
	}

	public String getCioc() {
		return cioc;
	}

	public void setCioc(String cioc) {
		this.cioc = cioc;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSubregion() {
		return subregion;
	}

	public void setSubregion(String subregion) {
		this.subregion = subregion;
	}

	public float[] getLatlng() {
		return latlng;
	}

	public void setLatlng(float[] latlng) {
		this.latlng = latlng;
	}

	public String getDemonym() {
		return demonym;
	}

	public void setDemonym(String demonym) {
		this.demonym = demonym;
	}

	public Boolean getLandlocked() {
		return landlocked;
	}

	public void setLandlocked(Boolean landlocked) {
		this.landlocked = landlocked;
	}

	public Float getArea() {
		return area;
	}

	public void setArea(Float area) {
		this.area = area;
	}

	public List<String> getTlds() {
		return tlds;
	}

	public List<String> getAltSpellings() {
		return altSpellings;
	}

	public Map<String, String> getLanguages() {
		return languages;
	}

	public Map<String, Translation> getTranslations() {
		return translations;
	}

	public List<String> getBorders() {
		return borders;
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

	@Override
	public int compareTo(Country o) {
		return Strings.nullToEmpty(name).compareTo(o.getName());
	}

}

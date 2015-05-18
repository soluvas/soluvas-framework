package org.soluvas.geo;

/**
 * @author rudi
 *
 */
public class GeoCountryLocation {
	
	private final String geoNameId;
	private final String countryIsoCode;
	private final String countryName;
	
	public GeoCountryLocation(String geoNameId, String countryIsoCode,
			String countryName) {
		super();
		this.geoNameId = geoNameId;
		this.countryIsoCode = countryIsoCode;
		this.countryName = countryName;
	}

	public String getGeoNameId() {
		return geoNameId;
	}

	public String getCountryIsoCode() {
		return countryIsoCode;
	}

	public String getCountryName() {
		return countryName;
	}
	
}

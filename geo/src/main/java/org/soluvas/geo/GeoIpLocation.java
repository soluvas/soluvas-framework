package org.soluvas.geo;


/**
 * @author rudi
 *
 */
public class GeoIpLocation {
	
	private final String network;
	private final String geoNameId;
	private final Country country;
	
	public GeoIpLocation(String network, String geoNameId, Country country) {
		super();
		this.network = network;
		this.geoNameId = geoNameId;
		this.country = country;
	}

	public String getNetwork() {
		return network;
	}

	public String getGeoNameId() {
		return geoNameId;
	}

	public Country getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return "GeoIpLocation [network=" + network + ", geoNameId=" + geoNameId
				+ ", country=" + country + "]";
	}
	
}

package org.soluvas.geo;

import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;

public interface DistrictRepository {

	/**
	 * Gets the {@link Country} using <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO-3166-1 alpha-2</a> (recommended) or <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-3">ISO-31661-alpha-3</a>.
	 * @param iso2orIso3
	 * @return
	 * @throws IllegalArgumentException
	 */
	public abstract Country getCountry(String iso2orIso3)
			throws IllegalArgumentException;

	public abstract Page<District> searchDistrict(String term, Pageable pageable);

	public abstract District putDistrict(String name, String normalizedName,
			String countryCode, String province, String city);

	long count();

	Page<Country> searchCountry(String term, Pageable pageable);

	District getDistrict(String normalizedNameAndCountryCode)
			throws IllegalArgumentException;
	
	District getDistrict(String name, String countryCode);

	String getKeyForDistrict(District district);

}
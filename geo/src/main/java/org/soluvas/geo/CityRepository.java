package org.soluvas.geo;

import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;

public interface CityRepository {

	/**
	 * Gets the {@link Country} using <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO-3166-1 alpha-2</a> (recommended) or <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-3">ISO-31661-alpha-3</a>.
	 * @param iso2orIso3
	 * @return
	 * @throws IllegalArgumentException
	 */
	public abstract Country getCountry(String iso2orIso3)
			throws IllegalArgumentException;

	public abstract Page<City> searchCity(String term, Pageable pageable);

	public abstract City putCity(String name, String normalizedName,
			String countryCode, String province);

	long count();

	Page<Country> searchCountry(String term, Pageable pageable);

	City getCity(String normalizedNameAndCountryCode)
			throws IllegalArgumentException;
	
	City getCity(String name, String countryCode);

	String getKeyForCity(City city);

}
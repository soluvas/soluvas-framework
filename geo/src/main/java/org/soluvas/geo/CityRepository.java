package org.soluvas.geo;

import javax.annotation.Nullable;

import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;

public interface CityRepository {

	public abstract Country getCountry(String iso2orIso3)
			throws IllegalArgumentException;

	public abstract Page<City> searchCity(String term, Pageable pageable);

	public abstract City putCity(String name, String normalizedName,
			String countryCode, @Nullable String province);

	long count();

	City getCity(String normalizedNameProvinceAndCountryCode) throws IllegalArgumentException;
	
	City getCity(String name, @Nullable String province, String countryCode);

	String getKeyForCity(City city);

	Page<City> searchCity(String term, String province, Pageable pageable);

	Page<City> searchCity(String term, @Nullable String province, @Nullable String countryIso, Pageable pageable);

}
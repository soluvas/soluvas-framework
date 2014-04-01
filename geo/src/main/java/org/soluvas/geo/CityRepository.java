package org.soluvas.geo;

import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;

public interface CityRepository {

	public abstract Country getCountry(String iso)
			throws IllegalArgumentException;

	public abstract Page<City> searchCity(String term, Pageable pageable);

	public abstract City putCity(String name, String normalizedName,
			String countryCode);

	long count();

}
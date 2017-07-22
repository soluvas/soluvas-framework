package org.soluvas.geo;

import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;

import java.util.List;

public interface CountryRepository {

	/**
	 * List all countries.
	 * @return
	 */
	List<Country> findAll();

	/**
	 * List all countries with calling code.
	 * @return
	 */
	List<Country> findAllWithCallingCode();

	Country getCountry(String iso2orIso3)
			throws IllegalArgumentException;
	
	Page<Country> searchCountry(String term, Pageable pageable);

	Page<Country> searchCountryWithCallingCode(String term, Pageable pageable);

	long count();

}

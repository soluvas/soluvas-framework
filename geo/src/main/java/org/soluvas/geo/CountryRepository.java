package org.soluvas.geo;

import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;

public interface CountryRepository {
	
	Country getCountry(String iso2orIso3)
			throws IllegalArgumentException;
	
	Page<Country> searchCountry(String term, Pageable pageable);
	
	long count();

}

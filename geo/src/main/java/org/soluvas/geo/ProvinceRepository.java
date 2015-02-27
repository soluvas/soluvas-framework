package org.soluvas.geo;

import javax.annotation.Nullable;

import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;

public interface ProvinceRepository {
	
	public Page<Province> searchProvince(String term, @Nullable String countryIso, Pageable pageable);
	
	public String getKeyForProvince(Province province); 
	
	Province getProvinceByCountryIsoAndName(String countryIsoAndName) throws IllegalArgumentException;

	Page<Province> searchProvince(String term, Pageable pageable);
	
}

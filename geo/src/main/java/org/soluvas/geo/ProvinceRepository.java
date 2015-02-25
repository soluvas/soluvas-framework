package org.soluvas.geo;

import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;

public interface ProvinceRepository {
	
	public Page<Province> searchProvince(String term, Pageable pageable);
	
	public String getKeyForProvince(Province province); 
	
	Province getProvince(String countryAndNormalizedProvince) throws IllegalArgumentException;
	
}

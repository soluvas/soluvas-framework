package org.soluvas.geo;

import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;


public interface DistrictRepository {

	District getByName(String name);
	
	District getDistrict(String normalizedNameAndCountryCode) throws IllegalArgumentException;
	
	public abstract Page<District> searchDistrict(String term, Pageable pageable);
	
	String getKeyForDistrict(District district);

}
package org.soluvas.geo;

import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;


public interface DistrictRepository {

	District getByName(String name);
	
	District getDistrict(String cityAndNormalizedDistrict) throws IllegalArgumentException;
	
	public abstract Page<District> searchDistrict(String term, Pageable pageable);
	
	String getKeyForDistrict(District district);

	Page<District> searchDistrictByCity(String term, String city, Pageable pageable);

}
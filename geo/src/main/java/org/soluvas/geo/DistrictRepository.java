package org.soluvas.geo;

import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;


public interface DistrictRepository {

	/**
	 * @param name (lower cases): "countryIso, province, city, district". Ex: "ID, jawa barat, bandung, cidadap", "ID, jawa barat, sumedang, cidadap"
	 * @return
	 */
	District getByCountryProvinceCityName(String countryProvinceCityName);
	
	District getDistrict(String cityAndNormalizedDistrict) throws IllegalArgumentException;
	
	public abstract Page<District> searchDistrict(String term, Pageable pageable, String city, String province, String country);
	
	String getKeyForDistrict(District district);

	Page<District> searchDistrictByCity(String term, String city, Pageable pageable);

}
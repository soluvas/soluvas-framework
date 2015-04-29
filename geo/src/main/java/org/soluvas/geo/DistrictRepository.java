package org.soluvas.geo;

import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;


public interface DistrictRepository {

	/**
	 * @param name: "province, city, district". Ex: "Jawa Barat, Bandung, Cidadap", "Jawa Barat, Sumedang, Cidadap"
	 * @return
	 */
	District getByCountryProvinceCityName(String countryProvinceCityName);
	
	District getDistrict(String cityAndNormalizedDistrict) throws IllegalArgumentException;
	
	public abstract Page<District> searchDistrict(String term, Pageable pageable, String city, String province, String country);
	
	String getKeyForDistrict(District district);

	Page<District> searchDistrictByCity(String term, String city, Pageable pageable);

}
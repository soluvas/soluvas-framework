package org.soluvas.geo;

import javax.annotation.Nullable;

import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;

import java.util.List;

public interface ProvinceRepository {

    List<Province> findAllByCountryIso(String countryIso);

    Page<Province> searchProvince(String term, @Nullable String countryIso, Pageable pageable);
	
	String getKeyForProvince(Province province);

	/**
	 *
	 * @param countryIsoAndLowerName
	 * @return
	 * @throws IllegalArgumentException
	 * @deprecated Use {@link #findOne(String, String)}
     */
	@Deprecated
	Province getProvinceByCountryIsoAndName(String countryIsoAndLowerName) throws IllegalArgumentException;

	Page<Province> searchProvince(String term, Pageable pageable);

	Province findOne(String countryIso, String name)
			throws IllegalArgumentException;
}

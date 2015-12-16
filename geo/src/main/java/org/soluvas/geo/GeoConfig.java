package org.soluvas.geo;

import com.google.common.collect.ImmutableSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * Created by ceefour on 16/12/2015.
 */
@Configuration
public class GeoConfig {

    @Bean
    public GeoNamesCountryRepository countryRepo() throws IOException {
        return new GeoNamesCountryRepository();
    }

    @Bean
    public GeoNamesProvinceRepository provinceRepo() throws IOException {
        return new GeoNamesProvinceRepository(countryRepo());
    }

    @Bean
    public GeoNamesCityRepository cityRepo() throws IOException {
        final GeoNamesCityRepository cityRepo = new GeoNamesCityRepository(
                ImmutableSet.of("ID"), countryRepo());
        cityRepo.putCitiesFromDistrictTsv("ID", GeoNamesDistrictRepository.getDistrictTsv());
        return cityRepo;
    }

    @Bean
    public GeoNamesDistrictRepository districtRepo() throws IOException {
        final GeoNamesDistrictRepository districtRepo = new GeoNamesDistrictRepository(cityRepo());
        return districtRepo;
    }

}

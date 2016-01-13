package org.soluvas.geo;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.ImmutableSet;

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
    
//	@Bean
//	public GeoNamesCityRepository cityRepo() throws IOException {
//		final GeoNamesCityRepository cityRepo = new GeoNamesCityRepository(ImmutableSet.of("ID"), countryRepo());
//		log.info("Adding {} cities from {} (city repository currently contains {} cities)", 
//				shipping.getDestinations().size(), shipping, cityRepo.count());
//		for (final ShipmentAddress addr : shipping.getDestinations()) {
//			final String normalizedCity =  Normalizer.normalize(addr.getCity(), Form.NFD).replaceAll("[^\\p{ASCII}]", "");
//			/*handle for same city*/
//			try {
//				cityRepo.getCity(addr.getCity(), addr.getProvince(), addr.getCountryCode());
//			} catch (IllegalArgumentException e) {
//				cityRepo.putCity(addr.getCity(), normalizedCity, addr.getCountryCode(), addr.getProvince());
//			}
//			
//		}
//		log.info("City repository now contains {} cities", cityRepo.count());
//		return cityRepo;
//	}
	
	@Bean
	public GeoNamesDistrictRepository districtRepo() throws IOException {
		final GeoNamesDistrictRepository districtRepo = new GeoNamesDistrictRepository(cityRepo());
		return districtRepo;
	}
	
	@Bean
	public IpLocationRepository geoIpLocationRepo() throws IOException {
		return new GeoIpLocationRepository(countryRepo());
	}

}

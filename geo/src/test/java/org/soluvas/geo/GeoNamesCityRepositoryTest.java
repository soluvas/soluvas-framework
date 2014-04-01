package org.soluvas.geo;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageRequest;

import com.google.common.collect.ImmutableSet;

public class GeoNamesCityRepositoryTest {

	private static final Logger log = LoggerFactory
			.getLogger(GeoNamesCityRepositoryTest.class);
	private CityRepository cityRepo;

	@Before
	public void setUp() throws Exception {
		cityRepo = new GeoNamesCityRepository();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void searchCityIndr() {
		final String term = "indr";
		final Page<City> cities1 = cityRepo.searchCity(term, new PageRequest(0, 5));
		log.info("Search {}: {}", term, cities1);
		final Page<City> cities2 = cityRepo.searchCity(term, new PageRequest(1, 5));
		log.info("Search {}: {}", term, cities2);
		assertEquals(5, cities1.getNumberOfElements());
		assertEquals(7, cities1.getTotalElements());
		assertEquals(2, cities2.getNumberOfElements());
		assertEquals(7, cities2.getTotalElements());
	}

	@Test
	public void getCountryID() {
		assertEquals("Indonesia", cityRepo.getCountry("ID").getName());
	}

	@Test
	public void searchCityIndrExcluded() throws IOException {
		final CityRepository cityRepo = new GeoNamesCityRepository(ImmutableSet.of("ID"));
		final String term = "indr";
		final Page<City> cities1 = cityRepo.searchCity(term, new PageRequest(0, 5));
		log.info("Search {}: {}", term, cities1);
		final Page<City> cities2 = cityRepo.searchCity(term, new PageRequest(1, 5));
		log.info("Search {}: {}", term, cities2);
		assertEquals(3, cities1.getNumberOfElements());
		assertEquals(3, cities1.getTotalElements());
		assertEquals(0, cities2.getNumberOfElements());
		assertEquals(3, cities2.getTotalElements());
	}

}

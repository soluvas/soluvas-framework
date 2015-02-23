package org.soluvas.geo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;

import au.com.bytecode.opencsv.CSVReader;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.googlecode.concurrenttrees.radix.ConcurrentRadixTree;
import com.googlecode.concurrenttrees.radix.RadixTree;
import com.googlecode.concurrenttrees.radix.node.concrete.DefaultCharArrayNodeFactory;

/**
 * How to prepare data:
 * 
 * <ol>
 * 	<li>Download from http://www.geonames.org/export/</li>
 * 	<li>Open the file using LibreOffice Calc</li>
 * 	<li>Delete the unneeded columns</li>
 * 	<li>Save as {@code districts_ID.csv}</li>
 * </ol>
 * 
 * @author anton
 */


public class GeoNamesDistrictRepository implements DistrictRepository {
	
	
	private CityRepository cityRepo;
	
	private static final Logger log = LoggerFactory.getLogger(GeoNamesDistrictRepository.class);
	
	final RadixTree<District> tree = new ConcurrentRadixTree<>(new DefaultCharArrayNodeFactory());
	final Map<String, District> districtMap = new HashMap<>();
	
	public GeoNamesDistrictRepository(CityRepository cityRepo,Collection<Country> countries) throws IOException {
		super();
		this.cityRepo = cityRepo;
		
		final Country country = Iterables.find(countries, new Predicate<Country>() {
			@Override
			public boolean apply(Country input) {
				return input.getIso().equals("ID");
			}
		});
		
		// Districts
		try (final InputStreamReader reader = new InputStreamReader(GeoNamesDistrictRepository.class.getResourceAsStream("districts_ID_jne.csv"))) {
			try (final CSVReader csv = new CSVReader(reader, '\t', '"')) {
				while (true) {
					@Nullable 
					final String[] line = csv.readNext();
					if (line == null) {
						break;
					}
					final String name = line[4];
					if (name.startsWith("#")) {
						continue;
					}
					final String city = line[2];
					if (city.startsWith("#")) {
						continue;
					}
					
					/*handle for same district name*/
					if (!districtMap.containsKey(name)){
						try {
							final District district = new District(name, country, cityRepo.getCity(city, country.getIso()));
							districtMap.put(name, district);
							/* FIXME: put two times for find based on city and not*/
							tree.put(city.toLowerCase() + ", " + name.toLowerCase(), district);
							tree.put(name.toLowerCase() + ", " + country.getIso(), district);
						} catch (Exception e) {
							log.error("Not found for city: " + city + ": " + e, e);
						}
				//		final District district = new District(name, country);
					}
				}
			}
		}
	}

	@Override
	public District getByName(String name) {
		return districtMap.get(name);
	}

	@Override
	public Page<District> searchDistrict(String term, Pageable pageable) {
		final String normalizedTerm = Normalizer.normalize(term, Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
		final Iterable<CharSequence> keys = tree.getKeysStartingWith(normalizedTerm);
		final ImmutableList<District> districts = FluentIterable.from(keys)
				.skip((int) pageable.getOffset())
				.limit((int) pageable.getPageSize())
				.transform(new Function<CharSequence, District>() {
			@Override @Nullable
			public District apply(@Nullable CharSequence key) {
				return tree.getValueForExactKey(key);
			}
		}).toList();
		
		/*List<District> districtsFilterByCity = new ArrayList<District>();
		for (District district : districts) {
			if (district.getCity().getName().equals("Banjarmasin")){
				districtsFilterByCity.add(district);
			}
		}*/
		
		final int total = Iterables.size(keys);
		final PageImpl<District> page = new PageImpl<>(districts, pageable, total);
		
		log.debug("Searching '{}' ({}) paged by {} returned {} (total {}) districts: {}",
				term, normalizedTerm, pageable, districts.size(), total, Iterables.limit(districts, 10));
		return page;
	}
	
	@Override
	public Page<District> searchDistrictByCity(String term, final String city, Pageable pageable) {
		Preconditions.checkNotNull("City must not be null");
		final String normalizedTerm = Normalizer.normalize(city + ", " + term, Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
		final Iterable<CharSequence> keys = tree.getKeysStartingWith(normalizedTerm);
		final ImmutableList<District> districts = FluentIterable.from(keys)
				.skip((int) pageable.getOffset())
				.limit((int) pageable.getPageSize())
				.transform(new Function<CharSequence, District>() {
			@Override @Nullable
			public District apply(@Nullable CharSequence key) {
//				log.debug("Querying: {}", key);
				return tree.getValueForExactKey(key);
			}
		}).toList();
		
		final int total = Iterables.size(keys);
		final PageImpl<District> page = new PageImpl<>(districts, pageable, total);
		log.debug("Searching '{}' ({}) paged by {} returned {} (total {}) districts: {}",
				city, normalizedTerm, pageable, districts.size(), total, Iterables.limit(districts, 10));
		return page;
	}

	@Override
	public String getKeyForDistrict(District district) {
		return district.getCity().getName().toLowerCase() + ", " + district.getName().toLowerCase();
	}

	@Override
	public District getDistrict(String cityAndNormalizedDistrictOrNormalizedDistrictAndCountry) throws IllegalArgumentException {
		final District district = tree.getValueForExactKey(cityAndNormalizedDistrictOrNormalizedDistrictAndCountry);
		Preconditions.checkArgument(district != null,
				"Invalid disctrict for '%s'.", cityAndNormalizedDistrictOrNormalizedDistrictAndCountry);
		return district;
	}
	
	
}

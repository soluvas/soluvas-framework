package org.soluvas.geo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;

import au.com.bytecode.opencsv.CSVReader;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.googlecode.concurrenttrees.radix.ConcurrentRadixTree;
import com.googlecode.concurrenttrees.radix.RadixTree;
import com.googlecode.concurrenttrees.radix.node.concrete.DefaultCharArrayNodeFactory;

/**
 * How to prepare data:
 * 
 * <ol>
 * 	<li>Download GeoNames cities1000.txt from http://www.geonames.org/export/</li>
 * 	<li>Open the file using LibreOffice Calc</li>
 * 	<li>Delete the unneded columns, so that columns become: name, normalized name, country code</li>
 * 	<li>Save as {@code cities1000lite.csv}</li>
 * </ol>
 * 
 * @author rudi
 */
public class GeoNamesCityRepository implements CityRepository {
	
	private static final Logger log = LoggerFactory
			.getLogger(GeoNamesCityRepository.class);
	/**
	 * Tree containing segmented city names.
	 * e.g. "Other Kab. Labuhan Batu" will become 1 main entry + 3 full text search entries ({@code 123} is the RadixTree index
	 * to avoid key collision):
	 * <ol>
	 * 	<li>other kab. labuhan batu, ID -- used for exact match</li>
	 * 	<li>kab. labuhan batu 123</li>
	 * 	<li>labuhan batu 123</li>
	 * 	<li>batu 123</li>
	 * </ol> 
	 */
	final RadixTree<City> tree = new ConcurrentRadixTree<>(new DefaultCharArrayNodeFactory());
	private int entryCount = 0;
	private int realCityCount = 0;
	private final CountryRepository countryRepo;
	private final ProvinceRepository provinceRepo;
	
	/**
	 * @param excludedCountryCodes Exclude cities from these country codes (2-letter ISO) from being loaded.
	 * @param countryRepo TODO
	 * @param provinceRepo TODO
	 * @throws IOException
	 */
	public GeoNamesCityRepository(final Set<String> excludedCountryCodes, CountryRepository countryRepo, ProvinceRepository provinceRepo) throws IOException {
		super();
		this.countryRepo = countryRepo;
		this.provinceRepo = provinceRepo;
		
		log.info("Initializing GeoNames city repository excluding {} countries: {}",
				excludedCountryCodes.size(), excludedCountryCodes);
		// Cities
		final List<String> skippedCities = new ArrayList<>();
		final List<String> excludedCities = new ArrayList<>();
		try (final InputStreamReader reader = new InputStreamReader(GeoNamesCityRepository.class.getResourceAsStream("cities1000lite.csv"))) {
			try (final CSVReader csv = new CSVReader(reader, '\t', '"')) {
				while (true) {
					@Nullable
					final String[] line = csv.readNext();
					if (line == null) {
						break;
					}
					if (line[2].isEmpty()) {
						skippedCities.add(line[0]);
						continue;
					}
					if (excludedCountryCodes.contains(line[2])) {
						excludedCities.add(line[2]);
						continue;
					}
					//Province memang NULL, karena data city disini untuk luar indonesia. City yang di indonesia, dapet dari JNE 
					putCity(line[0], line[1], line[2], null);
				}
			}
		}
		log.info("Skipped {} cities without country: {}", skippedCities.size(), Iterables.limit(skippedCities, 10));
		log.info("Excluded {} cities from country {}: {}", excludedCities.size(), Iterables.limit(excludedCities, 10));
		log.info("Read {} cities with countries into {} RadixTree entries", realCityCount, tree.size());
	}
	
	/**
	 * No excluded country codes.
	 * @throws IOException
	 */
	public GeoNamesCityRepository(CountryRepository countryRepo, ProvinceRepository provinceRepo) throws IOException {
		this(ImmutableSet.<String>of(), countryRepo, provinceRepo);
	}
	
	@Override
	public City getCity(String normalizedNameProvinceAndCountryCode) throws IllegalArgumentException {
		final City city = tree.getValueForExactKey(normalizedNameProvinceAndCountryCode);
		Preconditions.checkArgument(city != null,
				"Invalid city for '%s'.", normalizedNameProvinceAndCountryCode);
		return city;
	}
	
	@Override
	public String getKeyForCity(City city) {
		final String province = city.getProvince();
		final String key;
		if (!Strings.isNullOrEmpty(province)) {
			key = city.getNormalizedName().toLowerCase() + ", " + 
						province.toLowerCase() + ", " + city.getCountry().getIso();
		} else {
			key = city.getNormalizedName().toLowerCase() + ", " +
					city.getCountry().getIso();
		}
		return key;
	}
	
	@Override
	public City getCity(String name, @Nullable String province, String countryCode) {
		if (province != null) {
			return getCity(name.toLowerCase() + ", " + province.toLowerCase() + ", " + countryCode);
		} else {
			return getCity(name.toLowerCase() + ", " + countryCode);
		}
	}
	
	@Override
	public Country getCountry(String iso2orIso3) throws IllegalArgumentException {
		return countryRepo.getCountry(iso2orIso3);
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.geo.CityRepository#searchCity(java.lang.String, org.soluvas.data.domain.Pageable)
	 */
	@Override
	public Page<City> searchCity(String term, Pageable pageable) {
		// http://stackoverflow.com/a/3322174/1343587
		final String normalizedTerm = Normalizer.normalize(term, Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
		final Iterable<CharSequence> keys = tree.getKeysStartingWith(normalizedTerm);
		final ImmutableList<City> cities = FluentIterable.from(keys)
				.skip((int) pageable.getOffset())
				.limit((int) pageable.getPageSize())
				.transform(new Function<CharSequence, City>() {
			@Override @Nullable
			public City apply(@Nullable CharSequence key) {
				return tree.getValueForExactKey(key);
			}
		}).toList();
		final int total = Iterables.size(keys);
		final PageImpl<City> page = new PageImpl<>(cities, pageable, total);
		log.debug("Searching '{}' ({}) paged by {} returned {} (total {}) cities: {}",
				term, normalizedTerm, pageable, cities.size(), total, Iterables.limit(cities, 10));
		return page;
	}
	
	@Override
	public Page<City> searchCityByProvince(String term, Pageable pageable, Province province) {
		// http://stackoverflow.com/a/3322174/1343587
		final String normalizedTerm = Normalizer.normalize(term, Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
		final Iterable<CharSequence> keys = tree.getKeysStartingWith(province.getName()+", "+normalizedTerm);
		final ImmutableList<City> cities = FluentIterable.from(keys)
				.skip((int) pageable.getOffset())
				.limit((int) pageable.getPageSize())
				.transform(new Function<CharSequence, City>() {
					@Override @Nullable
					public City apply(@Nullable CharSequence key) {
						return tree.getValueForExactKey(key);
					}
				}).toList();
		final int total = Iterables.size(keys);
		final PageImpl<City> page = new PageImpl<>(cities, pageable, total);
		log.debug("Searching '{}' ({}) paged by {} returned {} (total {}) cities: {}",
				term, normalizedTerm, pageable, cities.size(), total, Iterables.limit(cities, 10));
		return page;
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.geo.CityRepository#putCity(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public City putCity(String name, String normalizedName, String countryCode, @Nullable String provinceName) {
//		final Country country = countryMap.get(countryCode);
		final Country country = countryRepo.getCountry(countryCode);
		Preconditions.checkNotNull(country, "Invalid country code '%s' for city '%s'",
				countryCode, name);
		final City city = new City(name, normalizedName, provinceName, country);
//		tree.put(city.getNormalizedName().toLowerCase() + ", " + city.getCountry().getIso(), city);
		if (provinceName != null) {
			tree.put( city.getNormalizedName().toLowerCase() + ", " + 
						provinceName.toLowerCase() + ", " + city.getCountry().getIso(),
						city);
		} else {
			tree.put( city.getNormalizedName().toLowerCase() + ", " + 
					city.getCountry().getIso(),
					city);
		}
		entryCount++;
		// below are full text search entries, so tree entries are "duplicates", but still refer to safe City object above
		String fullTextName = city.getNormalizedName().toLowerCase();
		int spacePos = fullTextName.indexOf(' ');
		while (spacePos >= 0) {
			fullTextName = fullTextName.substring(spacePos + 1);
//			log.debug("fullTextName {} {}", spacePos, fullTextName);
			tree.put(fullTextName + " " + entryCount, city);
			entryCount++;
			spacePos = fullTextName.indexOf(' ');
		}
		realCityCount++;		
		return city;
	}

	@Override
	public long count() {
		return realCityCount;
	}
	
}

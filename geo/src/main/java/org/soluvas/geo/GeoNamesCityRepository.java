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

import com.opencsv.CSVReader;

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
	
	/**
	 * @param excludedCountryCodes Exclude cities from these country codes (2-letter ISO) from being loaded.
	 * @param countryRepo TODO
	 * @param provinceRepo TODO
	 * @throws IOException
	 */
	public GeoNamesCityRepository(final Set<String> excludedCountryCodes, CountryRepository countryRepo) throws IOException {
		super();
		this.countryRepo = countryRepo;
		
		log.info("Initializing GeoNames city repository excluding {} countries: {}",
				excludedCountryCodes.size(), excludedCountryCodes);
		// Cities
		final List<String> skippedCities = new ArrayList<>();
		final List<String> excludedCities = new ArrayList<>();
		try (final InputStreamReader reader = new InputStreamReader(GeoNamesCityRepository.class.getResourceAsStream("cities1000lite_-id.csv"))) {
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
					if (line[1].isEmpty()) {
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
	public GeoNamesCityRepository(CountryRepository countryRepo) throws IOException {
		this(ImmutableSet.<String>of(), countryRepo);
	}
	
	@Override
	public City getCity(String countryCodeNormalizedProvinceAndName) throws IllegalArgumentException {
		final City city = tree.getValueForExactKey(countryCodeNormalizedProvinceAndName);
		Preconditions.checkArgument(city != null,
				"Invalid city for '%s'.", countryCodeNormalizedProvinceAndName);
		return city;
	}
	
	@Override
	public String getKeyForCity(City city) {
		final String province = city.getProvince();
		final String key;
		if (!Strings.isNullOrEmpty(province)) {
			key = city.getCountry().getIso() + ", " + 
						province.toLowerCase() + ", " + city.getNormalizedName().toLowerCase();
		} else {
			key = city.getCountry().getIso() + ", " + city.getNormalizedName().toLowerCase();
		}
		return key;
	}
	
	@Override
	public City getCity(String name, @Nullable String province, String countryCode) {
		if (province != null) {
			return getCity(countryCode + ", " + province.toLowerCase() + ", " + name.toLowerCase());
		} else {
			return getCity(countryCode + ", " + name.toLowerCase());
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
//		// http://stackoverflow.com/a/3322174/1343587
//		final String normalizedTerm = Normalizer.normalize(term, Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
//		final Iterable<CharSequence> keys = tree.getKeysStartingWith(normalizedTerm);
//		final ImmutableList<City> cities = FluentIterable.from(keys)
//				.skip((int) pageable.getOffset())
//				.limit((int) pageable.getPageSize())
//				.transform(new Function<CharSequence, City>() {
//			@Override @Nullable
//			public City apply(@Nullable CharSequence key) {
//				return tree.getValueForExactKey(key);
//			}
//		}).toList();
//		final int total = Iterables.size(keys);
//		final PageImpl<City> page = new PageImpl<>(cities, pageable, total);
//		log.debug("Searching '{}' ({}) paged by {} returned {} (total {}) cities: {}",
//				term, normalizedTerm, pageable, cities.size(), total, Iterables.limit(cities, 10));
//		return page;
		return searchCity(term, null, null, pageable);
	}
	
	@Override
	public Page<City> searchCity(String term, String province, Pageable pageable) {
		return searchCity(term, province, null, pageable);
	}
	
	@Override
	public Page<City> searchCity(String term, @Nullable String province, @Nullable String countryIso, Pageable pageable) {
		final String normalizedTerm;
		if (!Strings.isNullOrEmpty(countryIso) && !Strings.isNullOrEmpty(province)) {
			normalizedTerm = countryIso + ", " + Normalizer.normalize(province.toLowerCase() + ", " + term, Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase(); 
		} else if (Strings.isNullOrEmpty(countryIso) && !Strings.isNullOrEmpty(province)) {
			normalizedTerm = Normalizer.normalize(province.toLowerCase() + ", " + term, Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
		} else if (!Strings.isNullOrEmpty(countryIso) && Strings.isNullOrEmpty(province)) {
			normalizedTerm = countryIso + ", " + Normalizer.normalize(term, Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
		} else {
			normalizedTerm = Normalizer.normalize(term, Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
		}
		
//		log.debug("Nommalized term: {}", normalizedTerm);
		final Iterable<CharSequence> keys = tree.getKeysStartingWith(normalizedTerm);
//		final Iterable<CharSequence> keys = tree.getClosestKeys(normalizedTerm);
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
		Preconditions.checkState(!Strings.isNullOrEmpty(normalizedName), "Normalized name city %s must not be null or empty.", name);
		final Country country = countryRepo.getCountry(countryCode);
		Preconditions.checkNotNull(country, "Invalid country code '%s' for city '%s'",
				countryCode, name);
		final City city = new City(name, normalizedName, provinceName, country);
		if (provinceName != null) {
			tree.put( city.getCountry().getIso() + ", " + 
						provinceName.toLowerCase() + ", " +
						city.getNormalizedName().toLowerCase(),
					city);
			tree.put( provinceName.toLowerCase() + ", " + 
						city.getNormalizedName().toLowerCase(),
					city);
		}
		tree.put( city.getCountry().getIso() + ", " + 
					city.getNormalizedName().toLowerCase(),
				city);
//		log.debug(city.getCountry().getIso() + ", " + 
//					city.getNormalizedName().toLowerCase());
		tree.put( city.getNormalizedName().toLowerCase(), city);
		
		entryCount++;
		// below are full text search entries, so tree entries are "duplicates", but still refer to safe City object above
		String fullTextName = city.getNormalizedName().toLowerCase();
		int spacePos = fullTextName.indexOf(' ');
		while (spacePos >= 0) {
			fullTextName = fullTextName.substring(spacePos + 1);
//			log.debug("fullTextName {} {}", spacePos, fullTextName);
			if (provinceName != null) {
				tree.put( city.getCountry().getIso() + ", " + 
							provinceName.toLowerCase() + ", " +
							fullTextName + " " + entryCount,
						city);
				tree.put( provinceName.toLowerCase() + ", " + 
							fullTextName + " " + entryCount,
						city);
			}
			tree.put( city.getCountry().getIso() + ", " + 
						fullTextName + " " + entryCount,
					city);
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

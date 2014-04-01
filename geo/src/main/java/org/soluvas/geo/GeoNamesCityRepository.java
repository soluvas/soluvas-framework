package org.soluvas.geo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.HashMap;
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
	final RadixTree<City> tree = new ConcurrentRadixTree<>(new DefaultCharArrayNodeFactory());
	final HashMap<String, Country> countryMap = new HashMap<>();
	
	/**
	 * @param excludedCountryCodes Exclude cities from these country codes (2-letter ISO) from being loaded.
	 * @throws IOException
	 */
	public GeoNamesCityRepository(final Set<String> excludedCountryCodes) throws IOException {
		super();
		log.info("Initializing GeoNames city repository excluding {} countries: {}",
				excludedCountryCodes.size(), excludedCountryCodes);
		// Countries
		try (final InputStreamReader reader = new InputStreamReader(GeoNamesCityRepository.class.getResourceAsStream("countryinfo.csv"))) {
			try (final CSVReader csv = new CSVReader(reader, '\t', '"')) {
				while (true) {
					@Nullable
					final String[] line = csv.readNext();
					if (line == null) {
						break;
					}
					if (line[0].startsWith("#")) {
						continue;
					}
					final Country country = new Country(line[0], line[4]);
					countryMap.put(country.getIso(), country);
				}
			}
		}
		log.info("Read {} countries: {}", countryMap.size(), countryMap.keySet());
		// Cities
		try (final InputStreamReader reader = new InputStreamReader(GeoNamesCityRepository.class.getResourceAsStream("cities1000lite.csv"))) {
			try (final CSVReader csv = new CSVReader(reader, '\t', '"')) {
				while (true) {
					@Nullable
					final String[] line = csv.readNext();
					if (line == null) {
						break;
					}
					if (line[2].isEmpty()) {
						log.debug("Skipped city without country '{}'", line[0]);
						continue;
					}
					if (excludedCountryCodes.contains(line[2])) {
						log.debug("Excluding city '{}' from country '{}'", line[0], line[2]);
						continue;
					}
					final Country country = countryMap.get(line[2]);
					Preconditions.checkNotNull(country, "Invalid country code '%s' for city '%s'",
							line[2], line[0]);
					final City city = new City(line[0], line[1], country);
					tree.put(city.getNormalizedName().toLowerCase() + ", " + city.getCountry().getIso(), city);
				}
			}
		}
		log.info("Read {} cities with countries", tree.size());
	}
	
	/**
	 * No excluded country codes.
	 * @throws IOException
	 */
	public GeoNamesCityRepository() throws IOException {
		this(ImmutableSet.<String>of());
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.geo.CityRepository#getCountry(java.lang.String)
	 */
	@Override
	public Country getCountry(String iso) throws IllegalArgumentException {
		final Country country = countryMap.get(iso);
		Preconditions.checkArgument(country != null,
				"Invalid country ISO code '%s'. %s available countries are: %s.",
				iso, countryMap.size(), countryMap.keySet());
		return country;
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.geo.CityRepository#searchCity(java.lang.String, org.soluvas.data.domain.Pageable)
	 */
	@Override
	public Page<City> searchCity(String term, Pageable pageable) {
		// http://stackoverflow.com/a/3322174/1343587
		final String normalizedTerm = Normalizer.normalize(term, Form.NFD).replaceAll("[^\\p{ASCII}]", "");
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
	
	/* (non-Javadoc)
	 * @see org.soluvas.geo.CityRepository#putCity(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public City putCity(String name, String normalizedName, String countryCode) {
		final Country country = countryMap.get(countryCode);
		Preconditions.checkNotNull(country, "Invalid country code '%s' for city '%s'",
				countryCode, name);
		final City city = new City(name, normalizedName, country);
		tree.put(city.getNormalizedName().toLowerCase() + ", " + city.getCountry().getIso(), city);
		return city;
	}

	@Override
	public long count() {
		return tree.size();
	}
	
}

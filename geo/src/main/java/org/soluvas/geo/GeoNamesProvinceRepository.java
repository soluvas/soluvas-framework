package org.soluvas.geo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.data.domain.Pageable;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.googlecode.concurrenttrees.radix.ConcurrentRadixTree;
import com.googlecode.concurrenttrees.radix.RadixTree;
import com.googlecode.concurrenttrees.radix.node.concrete.DefaultCharArrayNodeFactory;
import com.opencsv.CSVReader;

/**
 * See http://www.kemendagri.go.id/pages/profil-daerah/provinsi
 * 
 * @author anton
 *
 */
public class GeoNamesProvinceRepository implements ProvinceRepository{

	private static final Logger log = LoggerFactory
			.getLogger(GeoNamesProvinceRepository.class);
	
	final RadixTree<Province> tree = new ConcurrentRadixTree<>(new DefaultCharArrayNodeFactory());
	final Map<String, Province> provinceMap = new HashMap<>();
	private int entryCount = 0;
	
	public GeoNamesProvinceRepository(CountryRepository countryRepo) throws IOException {
		super();
//		final Country indonesia = countryRepo.getCountry("ID");
		// Provinces for ID
		try (final InputStreamReader reader = new InputStreamReader(GeoNamesDistrictRepository.class.getResourceAsStream("provinces.csv"))) {
			try (final CSVReader csv = new CSVReader(reader, '\t', '"')) {
				while (true) {
					@Nullable 
					final String[] line = csv.readNext();
			//		log.debug("line -> {}", line);
					if (line == null || line.length == 0) {
						break;
					}
					final String name = line[1];
					if (name.startsWith("#")) {
						continue;
					}
					
					final Country country = countryRepo.getCountry(line[0]);
					
					final Province province = new Province(name, country);
					/*handle for same province name*/
					if (!provinceMap.containsKey(name)) {
//						log.debug("Putting province -> {}", province);
						provinceMap.put(name, province);
						tree.put(country.getIso() + ", " + province.getName().toLowerCase(), province);
						tree.put(province.getName().toLowerCase(), province);
					}
					
					/*below is for search the province based word 
					 * e.g. Province Maluku Utara
					 * we can find with type utara 
					 * */
					entryCount++;
					String fullTextName = province.getName().toLowerCase();
					int spacePos = fullTextName.indexOf(' ');
					while (spacePos >= 0) {
						fullTextName = fullTextName.substring(spacePos + 1);
						tree.put(country.getIso() + ", " + fullTextName + " " + entryCount, province);
						tree.put(fullTextName + " " + entryCount, province);
						entryCount++;
						spacePos = fullTextName.indexOf(' ');
					}
					
				}
			}
		}
		
	}
	
	@Override
	public Page<Province> searchProvince(String term, Pageable pageable) {
		return searchProvince(term, null, pageable);
	}

	/**
	 * Deduplicated and sorted.
	 * @param countryIso
	 * @return
	 */
	@Override
	public List<Province> findAllByCountryIso(String countryIso) {
		final Set<Province> all = ImmutableSet.copyOf(searchProvince("", countryIso, new PageRequest(0, 1000)).getContent());
		return Ordering.natural().immutableSortedCopy(all);
	}

	@Override
	public Page<Province> searchProvince(String term, @Nullable String countryIso, Pageable pageable) {
		final String normalizedTerm;
		if (Strings.isNullOrEmpty(countryIso)) {
			normalizedTerm = Normalizer.normalize(term, Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
		} else {
			normalizedTerm = countryIso + ", " + Normalizer.normalize(term, Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
		}
		final Iterable<CharSequence> keys = tree.getKeysStartingWith(normalizedTerm);
		final ImmutableList<Province> provinces = FluentIterable.from(keys)
				.skip((int) pageable.getOffset())
				.limit((int) pageable.getPageSize())
				.transform(new Function<CharSequence, Province>() {
			@Override @Nullable
			public Province apply(@Nullable CharSequence key) {
				return tree.getValueForExactKey(key);
			}
		}).toList();
		final int total = Iterables.size(keys);
		final PageImpl<Province> page = new PageImpl<>(provinces, pageable, total);
		log.debug("Searching '{}' ({}) paged by {} returned {} (total {}) provinces: {}",
				term, normalizedTerm, pageable, provinces.size(), total, Iterables.limit(provinces, 10));
		return page;
	}

	@Override
	public String getKeyForProvince(Province province) {
//		log.debug("province -> {}", province);
		final String key;
	//	if (!Strings.isNullOrEmpty(province.getName())){
			key = province.getCountry().getIso() + ", " + province.getName().toLowerCase();
	//	} else{
	//		key = province.getCountry().getIso();
	//	}
		return key;
	}

	@Override 
	public Province getProvinceByCountryIsoAndName(String countryAndLowerName)
			throws IllegalArgumentException {
//		log.debug("Get ONE province by '{}'..", countryAndName);
		final Province province = tree.getValueForExactKey(countryAndLowerName);
		Preconditions.checkArgument(province != null,
				"Invalid province for '%s'.", countryAndLowerName);
		return province;
	}

	@Override
	public Province findOne(String countryIso, String name)
			throws IllegalArgumentException {
		final String key = countryIso + ", " + name.toLowerCase();
		final Province province = tree.getValueForExactKey(key);
		Preconditions.checkArgument(province != null,
				"Invalid province for '%s'.", key);
		return province;
	}

}

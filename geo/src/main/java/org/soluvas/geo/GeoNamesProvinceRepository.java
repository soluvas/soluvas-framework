package org.soluvas.geo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;

import au.com.bytecode.opencsv.CSVReader;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.googlecode.concurrenttrees.radix.ConcurrentRadixTree;
import com.googlecode.concurrenttrees.radix.RadixTree;
import com.googlecode.concurrenttrees.radix.node.concrete.DefaultCharArrayNodeFactory;

public class GeoNamesProvinceRepository implements ProvinceRepository{

	private static final Logger log = LoggerFactory
			.getLogger(GeoNamesProvinceRepository.class);
	
	final RadixTree<Province> tree = new ConcurrentRadixTree<>(new DefaultCharArrayNodeFactory());
	final Map<String, Province> provinceMap = new HashMap<>();
	
	public GeoNamesProvinceRepository(CountryRepository countryRepo) throws IOException{
		super();
		final Country indonesia = countryRepo.getCountry("ID");
		// Provinces
		try (final InputStreamReader reader = new InputStreamReader(GeoNamesDistrictRepository.class.getResourceAsStream("provinces_ID.csv"))) {
			try (final CSVReader csv = new CSVReader(reader, '\t', '"')) {
				while (true) {
					@Nullable 
					final String[] line = csv.readNext();
					if (line == null) {
						break;
					}
					final String name = line[0];
					if (name.startsWith("#")) {
						continue;
					}
					
					/*handle for same province name*/
					if (!provinceMap.containsKey(name)){
						final Province province = new Province(name, indonesia);
						log.debug("province -> {}", province);
						provinceMap.put(name, province);
						tree.put(province.getName().toLowerCase() + ", " + indonesia.getIso(), province);
					}
				}
			}
		}
		
	}
	
	
	@Override
	public Page<Province> searchProvince(String term, Pageable pageable) {
		final String normalizedTerm = Normalizer.normalize(term, Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
//		final Iterable<CharSequence> keys = tree.getKeysStartingWith(normalizedTerm);
//		final ImmutableList<Province> provinces = FluentIterable.from(keys)
//				.skip((int) pageable.getOffset())
//				.limit((int) pageable.getPageSize())
//				.transform(new Function<CharSequence, Province>() {
//			@Override @Nullable
//			public Province apply(@Nullable CharSequence key) {
//				return tree.getValueForExactKey(key);
//			}
//		}).toList();
		final FluentIterable<Province> matching = FluentIterable.from(provinceMap.values())
				.filter(new Predicate<Province>() {
					@Override
					public boolean apply(@Nullable Province province) {
						return StringUtils.containsIgnoreCase(province.getName(), normalizedTerm);
					}
				});
		
		
		final int total = Iterables.size(matching);
		final ImmutableList<Province> paged = matching
				.skip((int) pageable.getOffset())
				.limit((int) pageable.getPageSize())
				.toList();
		final PageImpl<Province> page = new PageImpl<>(paged, pageable, total);
		
		log.debug("Searching '{}' ({}) paged by {} returned {} (total {}) provinces: {}",
				term, normalizedTerm, pageable, paged.size(), total, Iterables.limit(paged, 10));
		return page;
	}

	@Override
	public String getKeyForProvince(Province province) {
		return province.getCountry().getName().toLowerCase() + ", " + province.getCountry().getIso();
	}

	@Override
	public Province getProvinceByCountryAndName(String countryAndName)
			throws IllegalArgumentException {
		final Province province = tree.getValueForExactKey(countryAndName);
		Preconditions.checkArgument(province != null,
				"Invalid disctrict for '%s'.", countryAndName);
		return province;
	}


}

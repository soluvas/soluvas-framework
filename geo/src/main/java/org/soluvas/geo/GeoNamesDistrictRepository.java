package org.soluvas.geo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.annotation.Nullable;

import org.apache.commons.io.IOUtils;
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
import com.google.common.collect.Iterables;
import com.googlecode.concurrenttrees.radix.ConcurrentRadixTree;
import com.googlecode.concurrenttrees.radix.RadixTree;
import com.googlecode.concurrenttrees.radix.node.concrete.DefaultCharArrayNodeFactory;

/**
 * How to prepare data:
 *
 * <ol>
 *  <li>Get shipping tariff data from JNE</li>
 *  <li>Open in LibreOffice</li>
 *  <li>Keep column headers. Delete columns except: destinationProvince, mainCity, destinationDistrict</li>
 *  <li>Save as <tt>src/main/resources/org/soluvas/geo/{@value DISTRICTS_ID_JNE_2015_04_TSV}</tt> with these settings:
 *      Character set: UTF-8, Field delimiter: Tab, Text delimiter: ", Uncheck quote all text cells</li>
 * </ol>
 *
 * @author anton
 */
public class GeoNamesDistrictRepository implements DistrictRepository {

    public static final String DISTRICTS_ID_JNE_2015_04_TSV = "districts_ID_jne_2015-04.tsv";

    private final CityRepository cityRepo;
    private int entryCount = 0;

    private static final Logger log = LoggerFactory.getLogger(GeoNamesDistrictRepository.class);

    final RadixTree<District> tree = new ConcurrentRadixTree<>(new DefaultCharArrayNodeFactory());
    final Map<String, District> districtMap = new HashMap<>();

    public static URL getDistrictTsv() {
        return GeoNamesDistrictRepository.class.getResource(DISTRICTS_ID_JNE_2015_04_TSV);
    }

    public GeoNamesDistrictRepository(CityRepository cityRepo) throws IOException {
        super();
        this.cityRepo = cityRepo;

        // Districts
        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(getDistrictTsv().openStream()))) {
            try (final CSVReader csv = new CSVReader(reader, '\t', '"', 1)) {
                while (true) {
                    @Nullable
                    final String[] line = csv.readNext();
                    if (line == null) {
                        break;
                    }
                    final String name = line[2];
                    if (Strings.isNullOrEmpty(name)) {
                        continue;
                    }
                    final String cityStr = line[1];
                    if (Strings.isNullOrEmpty(cityStr)) {
                        continue;
                    }
                    final String provinceStr = line[0];
                    if (Strings.isNullOrEmpty(provinceStr)) {
                        continue;
                    }

                    final City city;
                    try {
                        city = cityRepo.getCity(cityStr, provinceStr, "ID");
                    } catch (IllegalArgumentException e) {
                        log.warn("City not found for city '{}' - province '{}' - country '{}'", cityStr, provinceStr, "ID");
                        continue;
                    }
                    final Country country = city.getCountry();
                    final String province = city.getProvince();

                    final String keyOfDistrict = country.getIso() + ", " +
                            province.toLowerCase() + ", " +
                            city.getName().toLowerCase() + ", " +
                            name.toLowerCase();
                    if (!districtMap.containsKey(keyOfDistrict)) {
                        try {
                            final District district = new District(name, country, province, city.getName());
                            //data map sebenarnya
                            districtMap.put(keyOfDistrict, district);
                            //dipake untuk query by "country, province, city, district"
                            tree.put(keyOfDistrict,
                                    district);
                            //dipake untuk query by "country, province, district"
                            tree.put(country.getIso() + ", " +
                                            province.toLowerCase() + ", " +
                                            name.toLowerCase(),
                                    district);
                            //dipake untuk query by "country, city, district"
                            tree.put(country.getIso() + ", " +
                                            city.getName().toLowerCase() + ", " +
                                            name.toLowerCase(),
                                    district);
                            //dipake untuk query by "province, city, district"
                            tree.put(province.toLowerCase() + ", " +
                                            city.getName().toLowerCase() + ", " +
                                            name.toLowerCase(),
                                    district);
                            //dipake untuk query by "country, district"
                            tree.put(country.getIso() + ", " +
                                            name.toLowerCase(),
                                    district);
                            //dipake untuk query by "district"
                            tree.put(name.toLowerCase(),
                                    district);

                            String fullTextName = name.toLowerCase();
                            int spacePos = fullTextName.indexOf(' ');
                            while (spacePos >= 0) {
                                fullTextName = fullTextName.substring(spacePos + 1);

                                tree.put(country.getIso() + ", " +
                                                province.toLowerCase() + ", " +
                                                city.getName().toLowerCase() + ", " +
                                                fullTextName + " " + entryCount,
                                        district);
                                tree.put(country.getIso() + ", " +
                                                province.toLowerCase() + ", " +
                                                fullTextName + " " + entryCount,
                                        district);

                                tree.put(country.getIso() + ", " +
                                                city.getName().toLowerCase() + ", " +
                                                fullTextName + " " + entryCount,
                                        district);

                                tree.put(province.toLowerCase() + ", " +
                                                city.getName().toLowerCase() + ", " +
                                                fullTextName + " " + entryCount,
                                        district);

                                tree.put(country.getIso() + ", " +
                                                fullTextName + " " + entryCount,
                                        district);

                                tree.put(fullTextName + " " + entryCount,
                                        district);
                                entryCount++;
                                spacePos = fullTextName.indexOf(' ');
                            }


                        } catch (Exception e) {
                            log.error("Not found for city: " + cityStr + ": " + e, e);
                        }
                    }
                }
            }
        }
    }

    /* The name contains: "province, city, district". Ex: "Jawa Barat, Bandung, Cidadap", "Jawa Barat, Sumedang, Cidadap"
     * @see org.soluvas.geo.DistrictRepository#getByName(java.lang.String)
     */
    @Override
    public District getByCountryProvinceCityName(String countryProvinceCityName) {
        return districtMap.get(countryProvinceCityName);
    }

    @Override
    public Page<District> searchDistrict(String term, Pageable pageable, @Nullable String city, @Nullable String province,
                                         @Nullable String countryIso) {

        final String normalizedTerm;
        if (!Strings.isNullOrEmpty(city) && !Strings.isNullOrEmpty(province) && !Strings.isNullOrEmpty(countryIso)) {
            normalizedTerm = countryIso + ", " + Normalizer.normalize(province + ", " + city + ", " + term, Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();

        } else if (!Strings.isNullOrEmpty(city) && Strings.isNullOrEmpty(province) && Strings.isNullOrEmpty(countryIso)) {
            normalizedTerm = Normalizer.normalize(city + ", " + term, Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
        } else if (!Strings.isNullOrEmpty(city) && !Strings.isNullOrEmpty(province) && Strings.isNullOrEmpty(countryIso)) {
            normalizedTerm = Normalizer.normalize(province + ", " + city + ", " + term, Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
        } else if (!Strings.isNullOrEmpty(city) && Strings.isNullOrEmpty(province) && !Strings.isNullOrEmpty(countryIso)) {
            normalizedTerm = countryIso + ", " + Normalizer.normalize(city + ", " + term, Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
        } else if (Strings.isNullOrEmpty(city) && !Strings.isNullOrEmpty(province) && Strings.isNullOrEmpty(countryIso)) {
            normalizedTerm = Normalizer.normalize(province + ", " + term, Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
        } else if (Strings.isNullOrEmpty(city) && !Strings.isNullOrEmpty(province) && !Strings.isNullOrEmpty(countryIso)) {
            normalizedTerm = countryIso + ", " + Normalizer.normalize(province + ", " + term, Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
        } else if (Strings.isNullOrEmpty(city) && Strings.isNullOrEmpty(province) && !Strings.isNullOrEmpty(countryIso)) {
            normalizedTerm = countryIso + ", " + Normalizer.normalize(term, Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
        } else {
            normalizedTerm = Normalizer.normalize(term, Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
        }
        log.debug("Querying districts by term: {}", normalizedTerm);

        final Iterable<CharSequence> keys = tree.getKeysStartingWith(normalizedTerm);
        final ImmutableList<District> districts = FluentIterable.from(keys)
                .skip((int) pageable.getOffset())
                .limit((int) pageable.getPageSize())
                .transform(new Function<CharSequence, District>() {
                    @Override
                    @Nullable
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
                term, normalizedTerm, pageable, districts.size(), total, Iterables.limit(districts, 5));
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
                    @Override
                    @Nullable
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
        return district.getCountry().getIso() + ", " + district.getProvince().toLowerCase() + ", " +
                district.getCity().toLowerCase() + ", " + district.getName().toLowerCase();
    }

    @Override
    public District getDistrict(String cityAndNormalizedDistrictOrNormalizedDistrictAndCountry) throws IllegalArgumentException {
        final District district = tree.getValueForExactKey(cityAndNormalizedDistrictOrNormalizedDistrictAndCountry);
        Preconditions.checkArgument(district != null,
                "Invalid disctrict for '%s'.", cityAndNormalizedDistrictOrNormalizedDistrictAndCountry);
        return district;
    }

}

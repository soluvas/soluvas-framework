package org.soluvas.category;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.json.JsonUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

/**
 * @author rudi
 *
 */
public class FormalCategoryRepositoryImpl implements FormalCategoryRepository {
	
	private static final Logger log = LoggerFactory
			.getLogger(FormalCategoryRepositoryImpl.class);
	
	private ImmutableMap<Long, FormalCategory> formalCategories;
	
	public FormalCategoryRepositoryImpl() {
		super();
	}
	
	@PostConstruct
	public void init() throws JsonParseException, JsonMappingException, IOException {
		formalCategories = loadFromFiles(ImmutableList.of(FormalCategoryRepositoryImpl.class.getResource("google.DataCatalog.jsonld")));
	}
	
	private ImmutableMap<Long, FormalCategory> loadFromFiles(List<URL> jsonldFiles) throws JsonParseException, JsonMappingException, IOException {
		final Builder<Long, FormalCategory> mab = ImmutableMap.builder();
		for (final URL jsonldFile : jsonldFiles) {
			final CategoryCatalog2 dataCatalog = JsonUtils.mapper.readValue(jsonldFile, CategoryCatalog2.class);
			dataCatalog.getFormalCategories().forEach(it -> mab.put(it.getGoogleId(), it));
		}
		final ImmutableMap<Long, FormalCategory> map = mab.build();
		log.info("Loaded {} Google-Formal Categories from {}: {}", map.size(), jsonldFiles, map.keySet());
		return map;
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.category.FormalCategoryRepository#findOne(long)
	 */
	@Override
	public Optional<FormalCategory> findOne(long googleId) {
		if (formalCategories.containsKey(googleId)) {
			return Optional.of(formalCategories.get(googleId));
		} else {
			return Optional.empty();
		}
	}

}

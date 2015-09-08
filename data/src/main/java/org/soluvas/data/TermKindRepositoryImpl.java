package org.soluvas.data;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.json.JsonUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

/**
 * Read {@link TermKind} objects from/to JSON-LD files.
 * @author rudi
 */
public class TermKindRepositoryImpl implements TermKindRepository {
	
	public static final String COLOR = "Color";
	public static final String APPAREL_SIZE = "ApparelSize";
	public static final String SHOE_SIZE = "ShoeSize";
	
	private static final Logger log = LoggerFactory
			.getLogger(TermKindRepositoryImpl.class);
	
	private ImmutableMap<String, TermKind> baseTermKind;
	
	protected ImmutableMap<String, TermKind> loadFromFiles(List<URL> jsonldFiles) throws JsonParseException, JsonMappingException, IOException {
		final Builder<String, TermKind> mab = ImmutableMap.builder();
		for (final URL jsonldFile : jsonldFiles) {
			final TermKindCatalog catalog = JsonUtils.mapper.readValue(jsonldFile, TermKindCatalog.class);
			catalog.getTermKinds().forEach(it -> mab.put(it.getId(), it));
		}
		final ImmutableMap<String, TermKind> map = mab.build();
		log.info("Loaded {} TermKind(s) from {}: {}", map.size(), jsonldFiles, map.keySet());
		return map;
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.data.PropertyDefinitionRepository#init()
	 */
	@PostConstruct
	@Override
	public void init() throws JsonParseException, JsonMappingException, IOException {
		baseTermKind = loadFromFiles(ImmutableList.of(TermKindRepositoryImpl.class.getResource("soluvas.TermKindCatalog.jsonld")));
	}

	@Override
	public TermKind findOne(String id) {
		return baseTermKind.get(id);
	}

	@Override
	public TermKind getColor() {
		return baseTermKind.get(COLOR);
	}
	
	@Override
	public TermKind getApparelSize() {
		return baseTermKind.get(APPAREL_SIZE);
	}
	
	@Override
	public TermKind getShoeSize() {
		return baseTermKind.get(SHOE_SIZE);
	}

	@Override
	public ImmutableCollection<TermKind> findAll() {
		return baseTermKind.values();
	}

	@Override
	public Collection<TermKind> findAll(Collection<String> ids) {
		return baseTermKind.entrySet().stream().filter(new Predicate<Entry<String, TermKind>>() {

			@Override
			public boolean test(Entry<String, TermKind> t) {
				return ids.contains(t.getKey());
			}
		}).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue())).values();
	}

	@Override
	public List<TermKind> findAllByIdPropertyDefinition(String id) {
		return baseTermKind.entrySet().stream().filter(new Predicate<Entry<String, TermKind>>() {
			@Override
			public boolean test(Entry<String, TermKind> t) {
				return t.getValue().getIdPropertyDefinition().equals(id);
			}
		}).map(new Function<Entry<String, TermKind>, TermKind>() {
			@Override
			public TermKind apply(Entry<String, TermKind> t) {
				return t.getValue();
			}
		}).collect(Collectors.toList());
	}
	
}

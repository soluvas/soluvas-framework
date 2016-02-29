package org.soluvas.security;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
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
 * Read {@link DomainPermission2} objects from/to JSON-LD files.
 * @author anisa
 */
public class DomainPermissionRepositoryImpl implements DomainPermissionRepository {
	
	private static final Logger log = LoggerFactory
			.getLogger(DomainPermissionRepositoryImpl.class);
	
	private ImmutableMap<String, DomainPermission2> baseDomainPermission2;
	
	protected ImmutableMap<String, DomainPermission2> loadFromFiles(List<URL> jsonldFiles) throws JsonParseException, JsonMappingException, IOException {
		final Builder<String, DomainPermission2> mab = ImmutableMap.builder();
		for (final URL jsonldFile : jsonldFiles) {
			final DomainPermissionCatalog catalog = JsonUtils.mapper.readValue(jsonldFile, DomainPermissionCatalog.class);
			catalog.getDomainPermissions().forEach(it -> mab.put(it.getId(), it));
		}
		final ImmutableMap<String, DomainPermission2> map = mab.build();
		log.info("Loaded {} DomainPermission(s) from {}: {}", map.size(), jsonldFiles, map.keySet());
		return map;
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.data.PropertyDefinitionRepository#init()
	 */
	@PostConstruct
	@Override
	public void init() throws JsonParseException, JsonMappingException, IOException {
		baseDomainPermission2 = loadFromFiles(ImmutableList.of(DomainPermissionRepositoryImpl.class.getResource("soluvas.DomainPermissionCatalog.jsonld")));
	}

	@Override
	public DomainPermission2 findOne(String id) {
		return baseDomainPermission2.get(id);
	}

	@Override
	public ImmutableCollection<DomainPermission2> findAll() {
		return baseDomainPermission2.values();
	}

	@Override
	public Collection<DomainPermission2> findAll(Collection<String> ids) {
		return baseDomainPermission2.entrySet().stream().filter(new Predicate<Entry<String, DomainPermission2>>() {

			@Override
			public boolean test(Entry<String, DomainPermission2> t) {
				return ids.contains(t.getKey());
			}
		}).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue())).values();
	}

}

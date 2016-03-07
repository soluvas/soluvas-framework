package org.soluvas.security;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.Nullable;
import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;
import org.soluvas.json.JsonUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.common.base.Strings;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;

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
	public DomainPermission2 findOne(String domainId) {
		return baseDomainPermission2.get(domainId);
	}

	@Override
	public ImmutableCollection<DomainPermission2> findAll() {
		return baseDomainPermission2.values();
	}

	@Override
	public Collection<DomainPermission2> findAll(Collection<String> domainIds) {
		return baseDomainPermission2.entrySet().stream().filter(new Predicate<Entry<String, DomainPermission2>>() {

			@Override
			public boolean test(Entry<String, DomainPermission2> t) {
				return domainIds.contains(t.getKey());
			}
		}).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue())).values();
	}

	@Override
	public Page<DomainPermission2> findAllBySearchText(String searchText, Pageable pageable) {
		final Set<Entry<String, DomainPermission2>> found = doFindAll(searchText, ImmutableSet.of(), pageable);
		final List<DomainPermission2> collect = found.stream().map(entry -> entry.getValue()).collect(Collectors.toList());
		return new PageImpl<>(ImmutableList.copyOf( collect ), pageable, countBase(searchText));
	}
	
	private Set<Entry<String, DomainPermission2>> doFindAll(@Nullable String term, Set<String> excludedIds, Pageable pageable) {
		final Map<String, DomainPermission2> tmpBaseDomainPermissionMap;
		if (!excludedIds.isEmpty()) {
			tmpBaseDomainPermissionMap = baseDomainPermission2.entrySet().stream()
					.filter( entry -> !excludedIds.contains(entry.getValue().getId()) )
					.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
		} else {
			tmpBaseDomainPermissionMap = baseDomainPermission2;
		}
		
		final Map<String, DomainPermission2> paged; 
		if (!Strings.isNullOrEmpty(term)) {
			final Map<String, DomainPermission2> filtered = tmpBaseDomainPermissionMap.entrySet().stream()
					.filter( entry -> entry.getValue().getName().toLowerCase().startsWith(term.toLowerCase()) )
					.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
			paged = doPaging(filtered, pageable);
		} else {
			paged = doPaging(tmpBaseDomainPermissionMap, pageable);
		}
		log.debug("Paged domainPermission: {}", paged.size());
		if (pageable.getSort() != null) {
			log.warn("Sorting is still not working!!");
			return paged.entrySet();
		} else {
			log.debug("Got {} paged propertyDefinitions by term '{}' and page {} from {} tmpPropertyDefinitions: {}",
					paged.size(), term, pageable, tmpBaseDomainPermissionMap.size(), Iterables.limit(paged.entrySet(), 5));
			return paged.entrySet();
		}
	}
	
	private Map<String, DomainPermission2> doPaging(final Map<String, DomainPermission2> unpagedDomainPermission, final Pageable pageable) {
		final Map<String, DomainPermission2> paged = FluentIterable.from(unpagedDomainPermission.entrySet())
				.skip((int) pageable.getOffset()).limit((int) pageable.getPageSize())
				.toList().stream().collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
		return paged;
	}
	
	@Override
	public long countBase(@Nullable String searchText) {
		if (Strings.isNullOrEmpty(searchText)) {
			return baseDomainPermission2.size();
		} else {
			return baseDomainPermission2.entrySet().stream().filter(new Predicate<Entry<String, DomainPermission2>>() {

				@Override
				public boolean test(Entry<String, DomainPermission2> t) {
					return t.getValue().getName().toLowerCase().startsWith(searchText.toLowerCase());
				}
				
			}).count();
		}
	}
	
}

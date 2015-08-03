package org.soluvas.data;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Nullable;
import javax.annotation.PostConstruct;

import org.apache.commons.beanutils.BeanUtils;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Iterables;

/**
 * Read {@link PropertyDefinition} objects from/to JSON-LD files.
 * Note: write support is only for overrides, in their own MongoDB/PostgreSQL database (i.e. {@link Category}).
 * @author rudi
 */
public class PropertyDefinitionRepositoryImpl implements PropertyDefinitionRepository {
	
	private static final Logger log = LoggerFactory
			.getLogger(PropertyDefinitionRepositoryImpl.class);
	private ImmutableMap<String, PropertyDefinition> basePropertyDefinitions;
	/**
	 * Key: {tenantId}
	 */
	private final Map<String, ImmutableMap<String, PropertyDefinition>> tenantPropertyDefinitions =
			 new LinkedHashMap<>();
	/**
	 * Key: {tenantId}/{categoryId}. Category ID (in all hierarchy levels) must be unique per-tenant!
	 */
	private final Map<String, ImmutableMap<String, PropertyDefinition>> categoryPropertyDefinitions =
			 new LinkedHashMap<>();
	
	/* (non-Javadoc)
	 * @see org.soluvas.data.PropertyDefinitionRepository#findAllByTenantId(java.lang.String)
	 */
	@Override
	public ImmutableList<PropertyDefinition> findAllByTenantId(String tenantId) {
		final Map<String, PropertyDefinition> tenantDefs = Optional.ofNullable(tenantPropertyDefinitions.get(tenantId))
				.orElse(ImmutableMap.of());
		final com.google.common.collect.ImmutableList.Builder<PropertyDefinition> lisb = ImmutableList.builder();
		basePropertyDefinitions.forEach((key, value) -> {
			try {
				final PropertyDefinition prop = (PropertyDefinition) BeanUtils.cloneBean(value);
				final PropertyDefinition overr = tenantDefs.get(prop.getId());
				overrideProperty(prop, overr);
				lisb.add(prop);
			} catch (Exception e) {
				throw new DataException(e, "Cannot clone PropertyDefinition %s", value.getId());
			}
		});
		return lisb.build();
	}

	protected void overrideProperty(final PropertyDefinition current,
			@Nullable final PropertyDefinition overlay) {
		if (overlay != null) {
			// non-overridables: id, language, primaryUri, sameAsUris
			if (overlay.getEnabled() != null) {
				current.setEnabled(overlay.getEnabled());
			}
			if (overlay.getSearchableInQuick() != null) {
				current.setSearchableInQuick(overlay.getSearchableInQuick());
			}
			if (overlay.getVisibleInSimple() != null) {
				current.setVisibleInSimple(overlay.getVisibleInSimple());
			}
			if (overlay.getDataTypeName() != null) {
				current.setDataTypeName(overlay.getDataTypeName());
			}
			if (overlay.getDefaultEnum() != null) {
				current.setDefaultEnum(overlay.getDefaultEnum());
			}
			if (overlay.getDefaultKind() != null) {
				current.setDefaultKind(overlay.getDefaultKind());
			}
			if (overlay.getDefaultQuantity() != null) {
				current.setDefaultQuantity(overlay.getDefaultQuantity());
			}
			if (overlay.getDefaultUnit() != null) {
				current.setDefaultUnit(overlay.getDefaultUnit());
			}
			if (overlay.getDescription() != null) {
				current.setDescription(overlay.getDescription());
			}
			if (overlay.getFieldWidth() != null) {
				current.setFieldWidth(overlay.getFieldWidth());
			}
			if (overlay.getImageId() != null) {
				current.setImageId(overlay.getImageId());
			}
			if (overlay.getMaxValues() != null) {
				current.setMaxValues(overlay.getMaxValues());
			}
			if (overlay.getMinValues() != null) {
				current.setMinValues(overlay.getMinValues());
			}
			if (overlay.getName() != null) {
				current.setName(overlay.getName());
			}
			if (overlay.getPositioner() != null) {
				current.setPositioner(overlay.getPositioner());
			}
			if (overlay.getTranslations() != null) {
				overlay.getTranslations().forEach((lang, messages) -> {
					current.getTranslations().putIfAbsent(lang, new HashMap<String, String>());
					current.getTranslations().get(lang).putAll(messages);
				});
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.PropertyDefinitionRepository#findOneByTenantId(java.lang.String, java.lang.String)
	 */
	@Override
	public PropertyDefinition findOneByTenantId(String tenantId, String id) throws EntityLookupException {
		final PropertyDefinition base = Optional.ofNullable(basePropertyDefinitions.get(id))
				.orElseThrow(() -> new EntityLookupException(PropertyDefinition.class, StatusMask.RAW, LookupKey.ID, id) );
		final Map<String, PropertyDefinition> tenantDefs = Optional.ofNullable(tenantPropertyDefinitions.get(tenantId))
				.orElse(ImmutableMap.of());
		try {
			final PropertyDefinition prop = (PropertyDefinition) BeanUtils.cloneBean(base);
			final PropertyDefinition overr = tenantDefs.get(prop.getId());
			return prop;
		} catch (IllegalAccessException | InstantiationException
				| InvocationTargetException | NoSuchMethodException e) {
			throw new DataException(e, "Cannot clone PropertyDefinition %s", base.getId());
		}
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.PropertyDefinitionRepository#findRecommendedByTenantIdAndCategories(java.lang.String, java.util.Set)
	 */
	@Override
	public ImmutableList<PropertyDefinition> findRecommendedByTenantIdAndCategories(String tenantId, Set<String> categoryIds) {
		final Map<String, PropertyDefinition> tenantDefs = Optional.ofNullable(tenantPropertyDefinitions.get(tenantId))
				.orElse(ImmutableMap.of());
		final HashMap<String, PropertyDefinition> categoryDefs = new HashMap<>();
		categoryIds.forEach(categoryId -> 
			categoryDefs.putAll( Optional.ofNullable(categoryPropertyDefinitions.get(tenantId + "/" + categoryId))
				.orElse(ImmutableMap.of()) )
		);
		final com.google.common.collect.ImmutableList.Builder<PropertyDefinition> lisb = ImmutableList.builder();
		basePropertyDefinitions.forEach((key, value) -> {
			try {
				final PropertyDefinition prop = (PropertyDefinition) BeanUtils.cloneBean(value);
				@Nullable
				final PropertyDefinition tenantOverr = tenantDefs.get(prop.getId());
				overrideProperty(prop, tenantOverr);
				@Nullable
				final PropertyDefinition categoryOverr = categoryDefs.get(prop.getId());
				overrideProperty(prop, categoryOverr);
				lisb.add(prop);
			} catch (Exception e) {
				throw new DataException(e, "Cannot clone PropertyDefinition %s", value.getId());
			}
		});
		return lisb.build();
	}

	protected ImmutableMap<String, PropertyDefinition> loadFromFiles(List<URL> jsonldFiles) throws JsonParseException, JsonMappingException, IOException {
		final Builder<String, PropertyDefinition> mab = ImmutableMap.builder();
		for (final URL jsonldFile : jsonldFiles) {
			final DataCatalog2 dataCatalog = JsonUtils.mapper.readValue(jsonldFile, DataCatalog2.class);
			dataCatalog.getPropertyDefinitions().forEach(it -> mab.put(it.getId(), it));
		}
		final ImmutableMap<String, PropertyDefinition> map = mab.build();
		log.info("Loaded {} PropertyDefinitions from {}: {}", map.size(), jsonldFiles, map.keySet());
		return map;
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.data.PropertyDefinitionRepository#init()
	 */
	@PostConstruct
	@Override
	public void init() throws JsonParseException, JsonMappingException, IOException {
		basePropertyDefinitions = loadFromFiles(ImmutableList.of(PropertyDefinitionRepositoryImpl.class.getResource("soluvas.DataCatalog.jsonld")));
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.data.PropertyDefinitionRepository#getTenantOverrides(java.lang.String)
	 */
	@Override
	public ImmutableMap<String, PropertyDefinition> getTenantOverrides(String tenantId) {
		return Optional.ofNullable(tenantPropertyDefinitions.get(tenantId)).orElse(ImmutableMap.of());
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.data.PropertyDefinitionRepository#getCategoryOverrides(java.lang.String, java.lang.String)
	 */
	@Override
	public ImmutableMap<String, PropertyDefinition> getCategoryOverrides(String tenantId, String categoryId) {
		return Optional.ofNullable(categoryPropertyDefinitions.get(tenantId + "/" + categoryId)).orElse(ImmutableMap.of());
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.PropertyDefinitionRepository#setTenantOverrides(java.lang.String, com.google.common.collect.ImmutableMap)
	 */
	@Override
	public void setTenantOverrides(String tenantId, ImmutableMap<String, PropertyDefinition> overrides) {
		tenantPropertyDefinitions.put(tenantId, overrides);
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.data.PropertyDefinitionRepository#setCategoryOverrides(java.lang.String, java.lang.String, com.google.common.collect.ImmutableMap)
	 */
	@Override
	public void setCategoryOverrides(String tenantId, String categoryId, ImmutableMap<String, PropertyDefinition> overrides) {
		tenantPropertyDefinitions.put(tenantId + "/" + categoryId, overrides);
	}

	@Override
	public PropertyDefinition findOneBase(String id) throws EntityLookupException {
		if (!basePropertyDefinitions.containsKey(id)) {
			throw new EntityLookupException(PropertyDefinitionRepositoryImpl.class,
					StatusMask.RAW, LookupKey.ID, id);
		}
		return basePropertyDefinitions.get(id);
	}

	@Override
	public Map<String, PropertyDefinition> findAllBaseAsMap() {
		return basePropertyDefinitions;
	}

	@Override
	public Set<String> getDefaultEnums() {
		return basePropertyDefinitions.entrySet().stream().filter(e -> e.getValue().getDefaultKind() == PropertyKind.ENUMERATION).map(e -> e.getValue().getDefaultEnum()).collect(Collectors.toSet());
	}

	@Override
	public Page<PropertyDefinition> findAllBaseBySearchText(String searchText, Set<String> excludedIds, Pageable pageable) {
		final Set<Entry<String, PropertyDefinition>> found = doFindAll(searchText, excludedIds, pageable);
		log.debug("Collecting {} PropertyDefinitions by term '{}' and page {}", found.size(), searchText, pageable);
		final List<PropertyDefinition> collect = found.stream().map(entry -> entry.getValue()).collect(Collectors.toList());
		log.debug("Collected {} PropertyDefinitions by term '{}' and page {}", collect.size(), searchText, pageable);
		return new PageImpl<>(ImmutableList.copyOf( collect ),
				pageable, countBase());
	}
	
	private Set<Entry<String, PropertyDefinition>> doFindAll(@Nullable String term, Set<String> excludedIds, Pageable pageable) {
//		log.debug("Try to findAll by term '{}' and page {} from {} formalCategories",
//				term, pageable, formalCategories.size());
		
		final Map<String, PropertyDefinition> tmpBasePropertyDefinitionMap;
		if (!excludedIds.isEmpty()) {
			tmpBasePropertyDefinitionMap = basePropertyDefinitions.entrySet().stream()
					.filter( entry -> !excludedIds.contains(entry.getValue().getId()) )
					.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
		} else {
			tmpBasePropertyDefinitionMap = basePropertyDefinitions;
		}
		
		final Map<String, PropertyDefinition> paged; 
		if (!Strings.isNullOrEmpty(term)) {
			final Map<String, PropertyDefinition> filtered = tmpBasePropertyDefinitionMap.entrySet().stream()
					.filter( entry -> entry.getValue().getName().toLowerCase().startsWith(term.toLowerCase()) )
					.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
			paged = doPaging(filtered, pageable);
		} else {
			paged = doPaging(tmpBasePropertyDefinitionMap, pageable);
		}
		if (pageable.getSort() != null) {
//			log.debug("Sorting {} paged formalCategories use {}", paged.size(), pageable.getSort());
//			final TreeMap<Long, FormalCategory> sorted = new TreeMap<>(new ValueComparator(paged, pageable.getSort()));
//			log.debug("Got {} sorted formalCategories by term '{}' and page {} from {} formalCategories: {}",
//					sorted.size(), term, pageable, formalCategories.size(), Iterables.limit(sorted.entrySet(), 5));
//
//			return sorted.entrySet();
			log.warn("Sorting is still not working!!");
			return paged.entrySet();
		} else {
			log.debug("Got {} paged propertyDefinitions by term '{}' and page {} from {} tmpPropertyDefinitions: {}",
					paged.size(), term, pageable, tmpBasePropertyDefinitionMap.size(), Iterables.limit(paged.entrySet(), 5));
			return paged.entrySet();
		}
	}
	
	private Map<String, PropertyDefinition> doPaging(final Map<String, PropertyDefinition> unpagedPropertyDefinitions, final Pageable pageable) {
		final Map<String, PropertyDefinition> paged = FluentIterable.from(unpagedPropertyDefinitions.entrySet())
				.skip((int) pageable.getOffset()).limit((int) pageable.getPageSize())
				.toList().stream().collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
		return paged;
	}
	
	@Override
	public long countBase() {
		return basePropertyDefinitions.size();
	}

	@Override
	public ImmutableList<PropertyDefinition> findAllBase(Collection<String> ids) {
		return ImmutableList.copyOf(basePropertyDefinitions.entrySet().stream().filter(e -> ids.contains(e.getKey()))
				.map(it -> it.getValue()).collect(Collectors.toList()));
	}
	
}

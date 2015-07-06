package org.soluvas.category;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Nullable;
import javax.annotation.PostConstruct;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.domain.Sort.Order;
import org.soluvas.data.repository.PagingAndSortingRepositoryBase;
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
 * @author rudi
 *
 */
public class FormalCategoryRepositoryImpl extends PagingAndSortingRepositoryBase<FormalCategory, Long>
	implements FormalCategoryRepository {
	
	private static final Logger log = LoggerFactory
			.getLogger(FormalCategoryRepositoryImpl.class);
	
	private ImmutableMap<Long, FormalCategory> formalCategories;
	
	public FormalCategoryRepositoryImpl() {
		super();
	}
	
	@PostConstruct
	@Override
	public void init() throws JsonParseException, JsonMappingException, IOException {
		formalCategories = loadFromFiles(ImmutableList.of(FormalCategoryRepositoryImpl.class.getResource("google.DataCatalog.jsonld")));
	}
	
	private ImmutableMap<Long, FormalCategory> loadFromFiles(List<URL> jsonldFiles) throws JsonParseException, JsonMappingException, IOException {
		final Builder<Long, FormalCategory> mab = ImmutableMap.builder();
		for (final URL jsonldFile : jsonldFiles) {
			final FormalCategoryCatalog dataCatalog = JsonUtils.mapper.readValue(jsonldFile, FormalCategoryCatalog.class);
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

	@Override
	public long count() {
		return formalCategories.size();
	}

	@Override
	protected Long getId(FormalCategory entity) {
		return entity.getGoogleId();
	}

	@Override
	public <S extends FormalCategory> Collection<S> add(Collection<S> entities) {
		throw new UnsupportedOperationException("NO ADD action for Formal Category!!");
	}

	@Override
	public <S extends FormalCategory> Collection<S> modify(Map<Long, S> entities) {
		throw new UnsupportedOperationException("NO MODIFY action for Formal Category!!");
	}

	@Override
	public Set<Long> exists(Collection<Long> ids) {
		return findAllByIds(ids).keySet();
	}

	@Override
	public List<FormalCategory> findAll(Collection<Long> ids, @Nullable Sort sort) {
		final Map<Long, FormalCategory> found = findAllByIds(ids);
		if (sort != null) {
//			final TreeMap<Long, FormalCategory> sortedMap = new TreeMap<>(new ValueComparator(found, sort));
//			return ImmutableList.copyOf(sortedMap.values());
			log.warn("Sorting is still not working!!");
			return ImmutableList.copyOf(found.values()); 
		} else {
			return ImmutableList.copyOf(found.values());
		}
	}
	
	private Map<Long, FormalCategory> findAllByIds(Collection<Long> ids) {
		return formalCategories.entrySet().stream().filter(entry -> ids.contains(entry.getKey()))
				.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
	}

	@Override
	public long deleteIds(Collection<Long> ids) {
		throw new UnsupportedOperationException("NO DELETE action for Formal Category!!");
	}

	@Override
	public Page<Long> findAllIds(Pageable pageable) {
		final Set<Entry<Long, FormalCategory>> found = doFindAll(pageable, null);
		return new PageImpl<>(ImmutableList.copyOf( found.stream().map(entry -> entry.getKey()).collect(Collectors.toList()) ),
				pageable, count());
	}

	@Override
	public Page<FormalCategory> findAll(Pageable pageable) {
		final Set<Entry<Long, FormalCategory>> found = doFindAll(pageable, null);
		return new PageImpl<>(ImmutableList.copyOf(ImmutableList.copyOf( found.stream().map(entry -> entry.getValue()).collect(Collectors.toList())) ),
				pageable, count());
	}
	
	private Set<Entry<Long, FormalCategory>> doFindAll(Pageable pageable, @Nullable String term) {
//		log.debug("Try to findAll by term '{}' and page {} from {} formalCategories",
//				term, pageable, formalCategories.size());
		
		final Map<Long, FormalCategory> paged; 
		if (!Strings.isNullOrEmpty(term)) {
			final Map<Long, FormalCategory> filtered = formalCategories.entrySet().stream()
					.filter( entry -> Iterables.getLast(entry.getValue().getGoogleBreadcrumbs()).toLowerCase().startsWith(term.toLowerCase()) )
					.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
			paged = doPaging(filtered, pageable);
		} else {
			paged = doPaging(formalCategories, pageable);
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
			log.debug("Got {} paged formalCategories by term '{}' and page {} from {} formalCategories: {}",
					paged.size(), term, pageable, formalCategories.size(), Iterables.limit(paged.entrySet(), 5));
			return paged.entrySet();
		}
	}
	
	private Map<Long, FormalCategory> doPaging(final Map<Long, FormalCategory> unpagedFormalCategories, final Pageable pageable) {
		final Map<Long, FormalCategory> paged = FluentIterable.from(unpagedFormalCategories.entrySet())
				.skip((int) pageable.getOffset()).limit((int) pageable.getPageSize())
				.toList().stream().collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
		return paged;
	}
	
	/**
	 * FIXME: ga ke panggil T.T
	 * 
	 * Handle first order on the Sort!
	 * @author rudi
	 *
	 */
	public class ValueComparator implements Comparator<Long> {
		
		private final Sort sort;
		private final Map<Long, FormalCategory> base;
		
	    public ValueComparator(Map<Long, FormalCategory> base, Sort sort) {
	    	super();
	        this.base = base;
	        this.sort = sort;
	    }
		
		@Override
		public int compare(Long left, Long right) {
			final Order order = Iterables.getFirst(sort, null);
			log.debug("Comparte left {} - right {} use {}", base.get(left), base.get(right), order);
			if (order != null) {
				try {
					log.debug("leftFormalCategory: {}", base.get(left));
					final Object leftProp = com.google.common.base.Optional.fromNullable(PropertyUtils.getProperty(base.get(left), order.getProperty())).or("");
					log.debug("leftProp: {}", leftProp);
					final Object rightProp = com.google.common.base.Optional.fromNullable(PropertyUtils.getProperty(base.get(right), order.getProperty())).or("");
					log.debug("rightProp: {}", rightProp);
					final int sorted;
					if (leftProp instanceof Comparable<?> && !(leftProp instanceof String)) {
						sorted = ((Comparable<Object>) leftProp).compareTo(rightProp);
					} else {
						sorted = ((String) leftProp).compareToIgnoreCase( (String) rightProp );
					}
					return order.isAscending() ? sorted : -sorted;
				} catch (IllegalAccessException | InvocationTargetException
						| NoSuchMethodException e) {
					log.warn("Cannot access bean property " + order, e);
					return 0;
				}
			} else {
				return 0;
			}
		}
	}

	@Override
	public Page<FormalCategory> findAllBySearchText(String searchText, Pageable pageable) {
		final Set<Entry<Long, FormalCategory>> found = doFindAll(pageable, searchText);
		log.debug("Collecting {} formalCategories by term '{}' and page {}", found.size(), searchText, pageable);
		final List<FormalCategory> collect = found.stream().map(entry -> entry.getValue()).collect(Collectors.toList());
		log.debug("Collected {} formalCategories by term '{}' and page {}", collect.size(), searchText, pageable);
		return new PageImpl<>(ImmutableList.copyOf( collect ),
				pageable, count());
	}

}

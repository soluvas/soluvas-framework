package org.soluvas.data.repository;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import org.apache.commons.beanutils.PropertyUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Identifiable;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.domain.Sort.Order;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;

/**
 * Base class for modifiable XMI-backed {@link PagingAndSortingRepository}, with "save" semantics
 * (i.e. XMIResource is kept open in memory, and only written to disk on save operation).
 * 
 * @todo Nested (recursively contained) objects support.
 * @author ceefour
 */
public abstract class XmiRepositoryBase<T extends Identifiable> extends PagingAndSortingRepositoryBase<T, String> {

	protected final Logger log = LoggerFactory.getLogger(getClass());
	/**
	 * To be used with {@link XMIResource#save(Map)}.
	 */
	public static final ImmutableMap<String, Object> SAVE_OPTIONS = ImmutableMap.<String, Object>of(
			XMIResource.OPTION_LINE_WIDTH, 80,
			XMIResource.OPTION_DECLARE_XML, true,
			XMIResource.OPTION_ENCODING, "UTF-8",
			XMIResource.OPTION_SCHEMA_LOCATION, true);
	
	public abstract EList<T> getRoot();
	
	@Override
	public long count() {
		return Iterables.size(getRoot());
	}

	@Override @Nullable
	protected String getId(T entity) {
		return entity != null ? entity.getId() : null;
	}

	@Override
	public <S extends T> Collection<S> add(Collection<S> entities) {
		// FIXME: implement
		throw new UnsupportedOperationException();
	}

	@Override
	public <S extends T> Collection<S> modify(Map<String, S> entities) {
		// FIXME: implement
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<String> exists(final Collection<String> ids) {
		return ImmutableSet.copyOf(Iterables.transform(Iterables.filter(
				getRoot(), new Predicate<T>() {
			@Override
			public boolean apply(@Nullable T input) {
				if (input.getId() != null) {
					return ids.contains(input.getId());
				} else {
					return false;
				}
			}
		}), new org.soluvas.commons.IdFunction()));
	}

	@Override
	public List<T> findAll(final Collection<String> ids, Sort sort) {
		// TODO: support sort
		final Collection<T> filtered = Collections2.filter(
				getRoot(), new Predicate<T>() {
			@Override
			public boolean apply(@Nullable T input) {
				if (input.getId() != null) {
					return ids.contains(input.getId());
				} else {
					return false;
				}
			}
		});
		return ImmutableList.copyOf(EcoreUtil.copyAll(filtered));
//		return ImmutableList.copyOf(Collections2.transform(filtered, new EcoreCopyFunction<T>()));
	}

	@Override
	public long deleteIds(Collection<String> ids) {
		// FIXME: implement
		throw new UnsupportedOperationException();
	}

	protected Iterable<T> doFindAll(Predicate<T> filter, Pageable pageable) {
		final Sort sort = Optional.fromNullable(pageable.getSort()).or(new Sort("id"));
		log.debug("Find T sorted by {}", sort.iterator().next().getProperty());
		final Iterable<T> filtered;
		if (filter != null) {
			filtered = Iterables.filter(getRoot(), filter);
		} else {
			filtered = getRoot();
		}
		final Ordering<T> ordering = new Ordering<T>() {
			@Override
			public int compare(@Nullable T left, @Nullable T right) {
				final Order order = Iterables.getFirst(sort, null);
				if (order != null) {
					try {
						final Object leftProp = Optional.fromNullable(PropertyUtils.getProperty(left, order.getProperty())).or("");
						final Object rightProp = Optional.fromNullable(PropertyUtils.getProperty(right, order.getProperty())).or("");
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
		};
		final List<T> sorted = ordering.immutableSortedCopy(filtered);
		final Iterable<T> limited = Iterables.limit(Iterables.skip(sorted,
				(int) pageable.getOffset()), (int) pageable.getPageSize());
		return limited;
	}
	
	@Override
	public Page<String> findAllIds(Pageable pageable) {
		final int allSize = Iterables.size(getRoot());
		final Iterable<T> limited = doFindAll(null, pageable);
		final Iterable<String> limitedUNames = Iterables.transform(limited, new IdFunction());
		return new PageImpl<>(ImmutableList.copyOf(limitedUNames),
				pageable, allSize);
	}

	@Override
	public Page<T> findAll(Pageable pageable) {
		final int allSize = Iterables.size(getRoot());
		final Iterable<T> limited = doFindAll(null, pageable);
		return new PageImpl<>(ImmutableList.copyOf(EcoreUtil.copyAll(ImmutableList.copyOf(limited))),
				pageable, allSize);
	}

}

package org.soluvas.data.repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.NotNullPredicate;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.data.domain.Sort.Order;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;

/**
 * {@link CrudRepository} base implementation that needs only the core
 * methods to override.
 * @author ceefour
 */
public abstract class CrudRepositoryBase<T, ID extends Serializable> implements PagingAndSortingRepository<T, ID> {

	private static final Logger log = LoggerFactory
			.getLogger(CrudRepositoryBase.class);
	
	@Override
	public boolean isEmpty() {
		return count() > 0;
	}

	@Override
	public long deleteAll() {
		Collection<T> entities = findAll();
		return delete(entities);
	}

	@Override
	public <S extends T> S save(S entity) {
		final S saved;
		final ID id = getId(entity);
		if (id != null && exists(id)) {
			saved = modify(id, entity);
		} else {
			saved = add(entity);
		}
		return saved;
	}
	
	@Nullable protected abstract ID getId(T entity);
	
	@Override
	public <S extends T> Collection<S> add(Iterable<S> entities) {
		return ImmutableList.of( add(entities.iterator().next()) );
	}
	
	@Override
	public <S extends T> Collection<S> modify(@Nonnull final Map<ID, S> entities) {
		final ImmutableList.Builder<S> resultBuilder = ImmutableList.builder();
		for (final Map.Entry<ID, S> entity : entities.entrySet()) {
			resultBuilder.add( modify(entity.getKey(), entity.getValue()) );
		}
		return resultBuilder.build();
	}
	
	@Override
	public <S extends T> Collection<S> save(Iterable<S> entities) {
		List<S> saved = ImmutableList.copyOf(Iterables.transform(entities, new Function<S, S>() {
			@Override
			@Nullable
			public S apply(@Nullable S input) {
				return save(input);
			}
		}));
		return saved;
	}

	@Override
	public boolean existsAll(final Iterable<ID> ids) {
		return Iterables.all(ids, new Predicate<ID>() {
			@Override
			public boolean apply(@Nullable ID input) {
				return exists(input);
			}
		});
	}

	@Override
	public boolean existsAny(final Iterable<ID> ids) {
		return Iterables.any(ids, new Predicate<ID>() {
			@Override
			public boolean apply(@Nullable ID input) {
				return exists(input);
			}
		});
	}

	@Override
	public Collection<T> findAll(Iterable<ID> ids) {
		List<T> found = ImmutableList.copyOf(Iterables.filter(Iterables.transform(ids, new Function<ID, T>() {
			@Override
			@Nullable
			public T apply(@Nullable ID id) {
				T entity = findOne(id);
				if (entity == null)
					log.warn("Cannot find entity with ID '{}'", id);
				return entity;
			}
		}), new NotNullPredicate<T>()));
		return found;
	}

	@Override
	public long count(Iterable<ID> ids) {
		return findAll(ids).size();
	}

	@Override
	public boolean delete(T entity) {
		return delete(getId(entity));
	}

	@Override
	public long delete(Iterable<? extends T> entities) {
		long deleted = 0;
		for (T entity : entities) {
			if (delete(entity))
				deleted++;
		}
		return deleted;
	}

	@Override
	public long deleteIds(Iterable<ID> ids) {
		long deleted = 0;
		for (ID id : ids) {
			if (delete(id))
				deleted++;
		}
		return deleted;
	}
	
	/**
	 * It is recommended to override this method for performance.
	 * The default implementation delegates to {@link #findAll()}.
	 */
	@Override
	@Nonnull
	public Collection<T> findAll(Sort sort) {
		Iterable<Comparator<T>> comparators = Iterables.transform(sort, new Function<Order, Comparator<T>>() {
			@Override
			@Nullable
			public Comparator<T> apply(@Nullable final Order order) {
				final String property = order.getProperty();
				final int multiplier = order.getDirection() == Direction.ASC ? 1 : -1;
				return new Comparator<T>() {
					@SuppressWarnings("unchecked")
					@Override
					public int compare(T o1, T o2) {
						try {
							Object v1 = PropertyUtils.getProperty(o1, property);
							Object v2 = PropertyUtils.getProperty(o2, property);
							if (Objects.equal(v1, v2)) {
								return 0;
							} else if (v1 == null) {
								return -1 * multiplier;
							} else if (v2 == null) {
								return 1 * multiplier;
							} else {
								if (v1 instanceof Comparable) {
									return ((Comparable<T>)v1).compareTo(o2) * multiplier;
								} else {
									return String.valueOf(v1).compareToIgnoreCase(String.valueOf(v2)) * multiplier;
								}
							}
						} catch (Exception e) {
							Throwables.propagate(e);
							return 0;
						}
					}
				};
			}
		});
		Ordering<T> ordering = Ordering.compound(comparators);
		Collection<T> entities = findAll();
		List<T> sorted = ordering.immutableSortedCopy(entities);
		return sorted;
	}
	
	/**
	 * It is recommended to override this method for performance.
	 * The default implementation delegates to {@link #findAll(Sort)}.
	 */
	@Override
	@Nonnull
	public Page<T> findAll(Pageable pageable) {
		final Collection<T> entities = findAll(pageable.getSort());
		final Iterable<T> skipped = Iterables.skip(entities, (int) (pageable.getOffset() + pageable.getPageNumber() * pageable.getPageSize()));
		final Iterable<T> limited = Iterables.limit(skipped, (int) pageable.getPageSize());
		final List<T> content = ImmutableList.copyOf(limited);
		return new PageImpl<T>(content, pageable, entities.size());
	}

}

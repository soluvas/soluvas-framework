package org.soluvas.data.repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.NotNullPredicate;
import org.soluvas.data.StatusMask;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

/**
 * {@link CrudRepository} base implementation that needs only the core
 * methods to override. For new implementations please use {@link StatusAwareRepositoryBase} instead,
 * even if you don't store status in your entity, API consumers still expect {@link StatusMask} support.
 * 
 * <p><strong>Tip:</strong> It's better if you extend {@link StatusAwareRepositoryBase} instead.
 * 
 * <p><strong>Important:</strong> Do not remove the @{@link Transactional} annotations because they're
 * 	used by JpaRepositoryBase.
 * @author ceefour
 */
public abstract class PagingAndSortingRepositoryBase<T, ID extends Serializable> implements PagingAndSortingRepository<T, ID> {

	public final class IdFunction implements Function<T, ID> {
		@Override @Nullable
		public ID apply(@Nullable T input) {
			return input != null ? getId(input) : null;
		}
	}

	private static final Logger log = LoggerFactory
			.getLogger(PagingAndSortingRepositoryBase.class);
	private static final long DEFAULT_PAGE_SIZE = 10;
	
	@Override @Transactional(readOnly=true)
	public final boolean isEmpty() {
		return count() > 0;
	}

	@Override @Transactional
	public final long deleteAll() {
		final long cnt = count();
		if (cnt > 0) {
			log.debug("Deleting {} entities", cnt);
			// Delete in batches of 10
			long deletedCount = 0;
			while (true) {
				final List<ID> ids = findAllIds(new PageRequest(0, 10)).getContent();
				if (ids.isEmpty()) {
					break;
				}
				deletedCount += deleteIds(ids);
			}
			log.debug("Deleted {} entities out of {} planned", deletedCount, cnt);
			return deletedCount;
		} else {
			return 0;
		}
	}

	@Nullable @Transactional(readOnly=true)
	protected abstract ID getId(T entity);
	
	@Override @Transactional
	public abstract <S extends T> Collection<S> add(Collection<S> entities);
	
	@Override @Transactional
	public final <S extends T> S add(S entity) {
		final Collection<S> addResults = add(ImmutableList.of(entity));
		Preconditions.checkNotNull(addResults, 
				getClass().getName() + ".add(Collection) succeeds but returned invalid null list");
		Preconditions.checkState(!addResults.isEmpty(), 
				getClass().getName() + ".add(Collection) succeeds but returned invalid empty list");
		final S result = addResults.iterator().next();
		Preconditions.checkNotNull(result, 
				getClass().getName() + ".add(Collection) succeeds but returned invalid element: null");
		return result;
	}
	
	@Override @Transactional
	public abstract <S extends T> Collection<S> modify(final Map<ID, S> entities);
	
	@Override @Transactional
	public final <S extends T> S modify(ID id, S entity) {
		return modify(ImmutableMap.of(id, entity)).iterator().next();
	}
	
	@Override @Transactional
	public final <S extends T> S save(S entity) {
		return save(ImmutableList.of(entity)).iterator().next();
	}
	
	/**
	 * The {@code entities} will be split between documents to {@link #modify(Map)}
	 * and documents to {@link #add(Collection)}.
	 * @see org.soluvas.data.repository.CrudRepository#save(java.util.Collection)
	 */
	@Override @Transactional
	public final <S extends T> Collection<S> save(Collection<S> entities) {
		final Collection<ID> ids = Collections2.filter(
				Collections2.transform(entities, new IdFunction()), new NotNullPredicate<>());
		final Set<ID> existing = exists(ids);
		final Map<ID, S> modifies = Maps.uniqueIndex(Collections2.filter(entities, new Predicate<T>() {
			@Override
			public boolean apply(@Nullable T input) {
				final ID id = getId(input);
				return id != null && existing.contains(id);
			}
		}), new IdFunction());
		final Collection<S> adds = Collections2.filter(entities, new Predicate<T>() {
			@Override
			public boolean apply(@Nullable T input) {
				final ID id = getId(input);
				return id == null || !existing.contains(id);
			}
		});
		
		final Collection<S> modifieds = modify(modifies);
		final Collection<S> addeds = add(adds);
		return ImmutableList.copyOf(Iterables.concat(modifieds, addeds));
	}
	
	@Override @Transactional(readOnly=true)
	public final boolean exists(ID id) {
		return existsAny(ImmutableList.of(id));
	}

	@Transactional(readOnly=true)
	public abstract Set<ID> exists(final Collection<ID> ids);

	@Override @Transactional(readOnly=true)
	public final boolean existsAll(final Collection<ID> ids) {
		return count(ids) == ids.size();
	}

	@Override @Transactional(readOnly=true)
	public final boolean existsAny(final Collection<ID> ids) {
		return count(ids) >= 1;
	}

	@Override @Transactional(readOnly=true)
	public abstract List<T> findAll(Collection<ID> ids, @Nullable Sort sort);
	
	@Override @Transactional(readOnly=true)
	public final List<T> findAll(Collection<ID> ids) {
		return findAll(ids, null);
	}
	
	@Override @Nullable @Transactional(readOnly=true)
	public final <S extends T> S findOne(@Nullable ID id) {
		if (id == null) {
			return null;
		} else {
			return (S) Iterables.getFirst(findAll(ImmutableList.of(id)), null);
		}
	}

	@Override @Transactional(readOnly=true)
	public final long count(Collection<ID> ids) {
		return exists(ids).size();
	}
	
	@Override @Transactional
	public final boolean delete(ID id) {
		return deleteIds(ImmutableList.of(id)) > 0;
	}

	@Override @Transactional
	public final boolean delete(T entity) {
		return delete(getId(entity));
	}

	@Override @Transactional
	public final long delete(Collection<? extends T> entities) {
		final Collection<ID> ids = Collections2.transform(entities, new IdFunction());
		return deleteIds(ids);
	}
	
	@Override @Transactional
	public abstract long deleteIds(Collection<ID> ids);
	
	@Transactional(readOnly=true)
	public abstract Page<ID> findAllIds(Pageable pageable);
	
	@Override @Transactional(readOnly=true)
	public abstract Page<T> findAll(Pageable pageable);
	
	/**
	 * Only returns the first {@value #DEFAULT_PAGE_SIZE} entities.
	 * @param sort
	 * @return
	 * @deprecated Use {@link #findAll(Pageable)} instead.
	 */
	@Override @Deprecated @Transactional(readOnly=true)
	public final List<T> findAll(Sort sort) {
		return findAll(new PageRequest(0, DEFAULT_PAGE_SIZE, sort)).getContent();
	}
	
	/**
	 * Will only return the first {@value #DEFAULT_PAGE_SIZE} entities.
	 * @see org.soluvas.data.repository.CrudRepository#findAll()
	 * @deprecated Use {@link #findAll(Pageable)} instead.
	 */
	@Override @Deprecated @Transactional(readOnly=true)
	public final List<T> findAll() {
		return findAll(new PageRequest(0, DEFAULT_PAGE_SIZE)).getContent();
	}

}

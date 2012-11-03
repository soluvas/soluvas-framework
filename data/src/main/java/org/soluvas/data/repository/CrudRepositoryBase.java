package org.soluvas.data.repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.NotNullPredicate;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * {@link CrudRepository} base implementation that needs only the core
 * methods to override.
 * @author ceefour
 */
public abstract class CrudRepositoryBase<T, ID extends Serializable> implements CrudRepository<T, ID> {

	private transient Logger log = LoggerFactory
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
		if (exists(id)) {
			saved = modify(id, entity);
		} else {
			saved = add(entity);
		}
		return saved;
	}
	
	protected abstract ID getId(T entity);
	
	protected abstract <S extends T> S modify(ID id, T entity);
	
	protected abstract <S extends T> S add(T entity);

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

}

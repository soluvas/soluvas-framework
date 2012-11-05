package org.soluvas.push.data;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * A entity lookup function with a built-in Guava powered {@link Cache}.
 * @author ceefour
 */
public class CachingEntityLookup<ID extends Serializable, T> implements Function<ID, T> {

	private transient Logger log = LoggerFactory
			.getLogger(CachingEntityLookup.class);
	private SyncRepository<T, ID> repository;
	private LoadingCache<ID, T> cache;
	
	public CachingEntityLookup(final SyncRepository<T, ID> repository) {
		super();
		this.repository = repository;
		cache = CacheBuilder.newBuilder().build(new CacheLoader<ID, T>() {
			@Override
			public T load(ID key) throws Exception {
				T entity = repository.findOne(key);
				return entity;
			}
		});
	}

	@Override
	public T apply(ID id) {
		try {
			return cache.get(id);
		} catch (ExecutionException e) {
			log.error("Cannot lookup " + id + " from " + repository, e);
			throw new RuntimeException("Cannot lookup " + id + " from " + repository, e);
		}
	}
	
}

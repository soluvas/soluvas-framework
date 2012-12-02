package org.soluvas.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.base.Function;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Collections2;

/**
 * Makes {@link EntityShadow#ensure(Object)} very cheap!
 * A {@link EntityShadow#refresh(Object)} and {@link EntityShadow#remove(Object)} always invalidates
 * the associated objects.
 * 
 * Note that Guava {@link Cache} won't work well when clustered. In that scenario,
 * a Redis- or Infinispan- backed cache is required. Although a straight Neo4j-backed "cache"
 * works quite well too, which greatly simplifies the setup.
 * 
 * @author ceefour
 */
public abstract class CachingEntityShadow<T, ID extends Serializable, D> extends EntityShadowBase<T, ID, D> {
	
	private final EntityShadow<T, ID, D> delegate;
	private final Cache<ID, D> cache;
	private final boolean alwaysRefresh;
	
	/**
	 * @param delegate
	 * @param cache
	 */
	public CachingEntityShadow(@Nonnull final EntityShadow<T, ID, D> delegate,
			@Nonnull final LoadingCache<ID, D> cache) {
		this(delegate, cache, false);
	}
	
	/**
	 * @param delegate
	 * @param cache
	 * @param alwaysRefresh If {@literal true}, the first loading to the cache using {@link #ensure(Object)}
	 * 		will call the delegate's {@link EntityShadow#refresh(Object)}
	 * 		instead of {@link EntityShadow#ensure(Object)}. This combines the quick loading of the {@link Cache} with
	 * 		the always-synchronized nature of {@link #refresh(Object)}.
	 * 		The behavior of {@link #refresh(Object)} remains unchanged. 
	 */
	public CachingEntityShadow(@Nonnull final EntityShadow<T, ID, D> delegate,
			@Nonnull final LoadingCache<ID, D> cache, final boolean alwaysRefresh) {
		super(delegate.getEntityClass(), delegate.getKind(), new Function<D, T>() {
			@Override @Nullable
			public T apply(@Nullable D input) {
				return delegate.realize(input);
			}
		});
		this.delegate = delegate;
		this.cache = CacheBuilder.newBuilder().build();
		this.alwaysRefresh = alwaysRefresh;
	}
	
	@Override
	public long remove(Collection<T> objs) {
		final Collection<ID> keys = Collections2.transform(objs, new Function<T, ID>() {
			@Override @Nullable
			public ID apply(@Nullable T input) {
				return getKey(input);
			}
		});
		cache.invalidateAll(keys);
		return delegate.remove(objs);
	}

	@Override
	protected D doEnsure(@Nonnull final T obj, final boolean refresh) {
		final ID cacheKey = getKey(obj);
		if (refresh) {
			cache.invalidate(cacheKey);
			return delegate.refresh(obj);
		} else {
			try {
				return cache.get(cacheKey, new Callable<D>() {
					@Override
					public D call() throws Exception {
						return alwaysRefresh ? delegate.refresh(obj) : delegate.ensure(obj);
					};
				});
			} catch (ExecutionException e) {
				throw new DataException("Cannot ensure object " + cacheKey + " from delegate shadow " + delegate, e);
			}
		}
	}
	
}

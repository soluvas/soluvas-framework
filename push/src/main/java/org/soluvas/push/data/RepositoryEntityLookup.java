package org.soluvas.push.data;

import java.io.Serializable;

import javax.annotation.Nonnull;

import org.soluvas.data.EntityLookup;

import com.google.common.base.Preconditions;

/**
 * A entity lookup function without cache.
 * @see CachingEntityLookup
 * @author ceefour
 */
public class RepositoryEntityLookup<T, ID extends Serializable> implements EntityLookup<T, ID> {

	private final SyncRepository<T, ID> repository;
	
	public RepositoryEntityLookup(final SyncRepository<T, ID> repository) {
		super();
		this.repository = repository;
	}

	public RepositoryEntityLookup(final CallbackRepository<T, ID> repository) {
		super();
		this.repository = new SyncRepositoryWrapper<T, ID>(repository);
	}

	@Override
	public <U extends T> U findOne(@Nonnull ID id) {
		Preconditions.checkNotNull(id, "Cannot lookup null ID");
		return (U) repository.findOne(id);
	}
	
}

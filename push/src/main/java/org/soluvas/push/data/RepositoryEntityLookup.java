package org.soluvas.push.data;

import javax.annotation.Nonnull;

import com.google.common.base.Preconditions;

/**
 * A entity lookup function without cache.
 * @see CachingEntityLookup
 * @author ceefour
 */
public class RepositoryEntityLookup<ID, T> implements EntityLookup<ID, T>{

	private SyncRepository<ID, T> repository;
	
	public RepositoryEntityLookup(final SyncRepository<ID, T> repository) {
		super();
		this.repository = repository;
	}

	public RepositoryEntityLookup(final CallbackRepository<ID, T> repository) {
		super();
		this.repository = new SyncRepositoryWrapper<ID, T>(repository);
	}

	@Override
	public <U extends T> U findOne(@Nonnull ID id) {
		Preconditions.checkNotNull(id, "Cannot lookup null ID");
		return (U) repository.findOne(id);
	}
	
}

package org.soluvas.push.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;

/**
 * A entity lookup function without cache.
 * @see CachingEntityLookup
 * @author ceefour
 */
public class EntityLookup<ID, T> implements Function<ID, T> {

	private transient Logger log = LoggerFactory
			.getLogger(EntityLookup.class);
	private SyncRepository<ID, T> repository;
	
	public EntityLookup(final SyncRepository<ID, T> repository) {
		super();
		this.repository = repository;
	}

	public T apply(ID id) {
		return repository.findOne(id);
	}
	
}

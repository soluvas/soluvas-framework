package org.soluvas.push.data;

import javax.annotation.Nonnull;


/**
 * A entity lookup function without cache.
 * @see CachingEntityLookup, {@link RepositoryEntityLookup}
 * @author ceefour
 */
public interface EntityLookup<ID, T> {

	public <U extends T> U findOne(@Nonnull ID id);
	
}

package org.soluvas.data;

import java.io.Serializable;

import javax.annotation.Nonnull;

/**
 * A entity lookup function without cache.
 * @see CachingEntityLookup
 * @see RepositoryEntityLookup
 * @author ceefour
 */
public interface EntityLookup<T, ID extends Serializable> {

	/**
	 * Retrives an entity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the entity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public <S extends T> S findOne(@Nonnull ID id);
	
}

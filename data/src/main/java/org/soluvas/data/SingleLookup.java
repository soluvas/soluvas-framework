package org.soluvas.data;

import java.io.Serializable;

import javax.annotation.Nullable;

import org.soluvas.data.push.CachingEntityLookup;
import org.soluvas.data.push.RepositoryEntityLookup;

/**
 * Enhanced entity lookup function which throws {@link EntityLookupException}.
 * @see CachingEntityLookup
 * @see RepositoryEntityLookup
 * @author ceefour
 */
public interface SingleLookup<T, K extends Serializable> {

	/**
	 * Retrives an entity by its {@link LookupKey} key.
	 * @param statusMask entity status must match this criteria
	 * @param lookupKey Recognized lookup key, implementations may choose to implement a subset of {@link LookupKey}s.
	 * @param key must not be {@literal null}.
	 * 
	 * @return the entity with the given key
	 * @throws EntityLookupException if not found in any way, including if {@code key} is {@code null}, see {@link EntityLookupException} for details
	 * @throws UnsupportedOperationException if lookupKey or statusMask is not supported due to implementation limitation
	 * 
	 */
	public <S extends T> S lookupOne(StatusMask statusMask, LookupKey lookupKey, @Nullable K key) throws EntityLookupException;
	
}

package org.soluvas.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import org.soluvas.data.push.CachingEntityLookup;
import org.soluvas.data.push.RepositoryEntityLookup;

import scala.util.Try;

/**
 * Multiple version of {@link SingleLookup} which can provide {@link EntityLookupException} information
 * for each key.
 * @see CachingEntityLookup
 * @see RepositoryEntityLookup
 * @author ceefour
 */
public interface MultiLookup<T, K extends Serializable> {

	/**
	 * Retrives an entity by its {@link LookupKey} key.
	 *
	 * <p>Each {@link Entry} may contain {@link EntityLookupException} if not found in any way, see {@link EntityLookupException} for details.
	 * 
	 * @param statusMask entity status must match this criteria
	 * @param lookupKey Recognized lookup key, implementations may choose to implement a subset of {@link LookupKey}s.
	 * @param keys must not be {@code null}, can be {@link Collection#isEmpty()}.
	 * 
	 * @return the entity with the given key
	 * @throws IllegalArgumentException if {@code keys} is {@code null}
	 * @throws UnsupportedOperationException if {@code lookupKey} or {@code statusMask} is not supported due to implementation limitation
	 */
	public <S extends T> Map<K, Try<S>> lookupAll(StatusMask statusMask, LookupKey lookupKey, Collection<K> keys);
	
}

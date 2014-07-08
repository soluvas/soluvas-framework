package org.soluvas.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import javax.annotation.Nullable;

import scala.util.Try;

/**
 * Enhanced entity lookup function which throws {@link EntityLookupException}.
 * @author ceefour
 */
public interface GenericLookup<T> {

	/**
	 * Retrieves an entity by its {@link LookupKey} key.
	 * @param statusMask entity status must match this criteria
	 * @param lookupKey Recognized lookup key, implementations may choose to implement a subset of {@link LookupKey}s.
	 * @param key must not be {@literal null}.
	 * 
	 * @return the entity with the given key
	 * @throws EntityLookupException if not found in any way, including if {@code key} is {@code null}, see {@link EntityLookupException} for details
	 * @throws UnsupportedOperationException if lookupKey or statusMask is not supported due to implementation limitation
	 * @todo Please create lookupOne() method for each {@link LookupKey}, and remove this method. Note that since it's an interface
	 * 		most of the methods won't be implemented. 
	 */
	public <S extends T, K extends Serializable> S lookupOne(StatusMask statusMask, LookupKey lookupKey, @Nullable K key) throws EntityLookupException;
	
	/**
	 * Multiple version of {@link #lookupOne(StatusMask, LookupKey, Serializable)} which can provide {@link EntityLookupException} information
	 * for each key.
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
	 * @todo Please create lookupAll() method for each {@link LookupKey}, and remove this method. Note that since it's an interface
	 * 		most of the methods won't be implemented. 
	 */
	public <S extends T, K extends Serializable> Map<K, Try<S>> lookupAll(StatusMask statusMask, LookupKey lookupKey, Collection<K> keys);

	/**
	 * Multiple version of {@link #lookupOne(StatusMask, LookupKey, Serializable)} which can provide {@link EntityLookupException} information
	 * for each key.
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
	 * @todo Please create checkExistsAll() method for each {@link LookupKey}, and remove this method. Note that since it's an interface
	 * 		most of the methods won't be implemented. 
	 */
	public <K extends Serializable> Map<K, Existence<K>> checkExistsAll(StatusMask statusMask, LookupKey lookupKey, Collection<K> keys);

	/**
	 * Retrieves an entity by its {@link LookupKey} key.
	 * @param statusMask entity status must match this criteria
	 * @param lookupKey Recognized lookup key, implementations may choose to implement a subset of {@link LookupKey}s.
	 * @param key must not be {@literal null}.
	 * 
	 * @return the entity with the given key
	 * @throws UnsupportedOperationException if {@code lookupKey} or {@code statusMask} is not supported due to implementation limitation
	 * @todo Please create checkExists() method for each {@link LookupKey}, and remove this method. Note that since it's an interface
	 * 		most of the methods won't be implemented. 
	 */
	public <K extends Serializable> Existence<K> checkExists(StatusMask statusMask, LookupKey lookupKey, @Nullable K key);
	
}

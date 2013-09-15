package org.soluvas.data;

import javax.annotation.Nullable;

import org.soluvas.commons.ResourceNotFoundException;
import org.soluvas.data.repository.CrudRepository;

import com.google.common.base.Optional;

/**
 * Enhanced Exception to be used for handling non-critical
 * lookup misses from an {@link EntityLookup} (which may also be a {@link CrudRepository}, but doesn't have to be),
 * for example in a frontend show entity page
 * that should return either:
 * 
 * <ol>
 * 	<li>a fancy 404 error page</li>
 * 	<li>a search results with the keywords</li>
 * 	<li>a redirect to a new/moved/renamed/replacement entity</li>
 * </ol>
 * 
 * <p>The Exception also contains enough information for giving
 * the reason of the not found (deleted? inactive? blocked for abusive behavior?)
 * 
 * <p>This exception should simply be rethrown and caught by the global application exception handler.
 * 
 * @author ceefour
 * @todo Merge with {@link ResourceNotFoundException}
 */
public class EntityLookupException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private final Class<?> clazz;
	private final StatusMask statusMask;
	private final LookupKey lookupKey;
	@Nullable
	private final Object key;
	private final GenericLookup<?> lookup;
	private final Optional<Enum<?>> status;

	/**
	 * @param clazz
	 * @param lookupKey
	 * @param key
	 * @param lookup
	 * @param status If not present, means the query actually did not return any row.
	 * 		If present, means the query actually returned a row but filtered due to {@link StatusMask}.
	 */
	public <T, K, S extends Enum<?>> EntityLookupException(Class<T> clazz, StatusMask statusMask, LookupKey lookupKey, @Nullable K key, GenericLookup<T> lookup, Optional<S> status) {
		super("Cannot lookup " + statusMask + " " + clazz.getName() + " " + lookupKey + "=" + key + " using " + lookup.getClass().getName() + ", returned " + status);
		this.clazz = clazz;
		this.statusMask = statusMask;
		this.lookupKey = lookupKey;
		this.key = key;
		this.lookup = lookup;
		this.status = (Optional<Enum<?>>) status;
	}

	/**
	 * @return the clazz
	 */
	public Class<?> getClazz() {
		return clazz;
	}
	
	public StatusMask getStatusMask() {
		return statusMask;
	}

	/**
	 * @return the lookupKey
	 */
	public LookupKey getLookupKey() {
		return lookupKey;
	}

	/**
	 * If {@code null} means the caller actually looks up empty key (which should always fail with {@link Optional#absent()}).
	 * @return the key
	 */
	@Nullable
	public Object getKey() {
		return key;
	}

	/**
	 * @return the lookup
	 */
	public GenericLookup<?> getLookup() {
		return lookup;
	}

	/**
	 * If not present, means the query actually did not return any row.
	 * If present, means the query actually returned a row but filtered due to {@link StatusMask}.
	 * @return the status
	 */
	public Optional<Enum<?>> getStatus() {
		return status;
	}

}

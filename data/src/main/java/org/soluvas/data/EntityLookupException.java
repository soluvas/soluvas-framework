package org.soluvas.data;

import javax.annotation.Nullable;

import org.soluvas.commons.ResourceNotFoundException;
import org.soluvas.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

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
 * the reason of the not found (deleted? inactive? blocked for abusive behavior?).
 * 
 * <p><b>Why not {@link RuntimeException}?</b> Non-existing entities are usually not a fatal error, but either wrong input or data,
 * that must be either handled or propagated. In (20%) cases where it's used to show a entity on a web page, you can just wrap and rethrow.
 * Note that a {@code Page} may lookup multiple entities, e.g. {@code ProductShowPage} you need to find the {@code product.shop}, so if the {@code shop} doesn't exist it's a
 * system inconsistency, not a 404 Not Found.
 * 
 * <p><b>Why not {@link Optional}?</b> Main reason is simple global exception handling in Wicket {@link org.apache.wicket.request.IExceptionMapper}
 * and JAX-RS / Spring MVC. Even with Java 8, consumers need to {@link java.util.Optional#orElseThrow()}. Actually {@link scala.util.Try}
 * is a better idea than Optional in this case, which unfortunately Java doesn't have. :(
 * 
 * @author ceefour
 * @todo What about {@link ResourceNotFoundException}? I think it's a different thing. EntityLookupException is meant for low-level stuff,
 * 		while {@link ResourceNotFoundException} is for the main entity of a show page, e.g. {@code product} on a {@code ProductShowPage}.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityLookupException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private final Class<?> clazz;
	private final StatusMask statusMask;
	private final LookupKey lookupKey;
	@Nullable
	private final Object key;
	@Nullable
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
	public <T, K, S extends Enum<?>> EntityLookupException(Class<T> clazz, StatusMask statusMask, LookupKey lookupKey, @Nullable K key, 
			@Nullable GenericLookup<T> lookup, Optional<S> status) {
		super("Cannot lookup " + statusMask + " " + clazz.getName() + " " + lookupKey + "=" + key +
				" using " + (lookup != null ? lookup.getClass().getName() : "N/A") + ", returned " + status);
		this.clazz = clazz;
		this.statusMask = statusMask;
		this.lookupKey = lookupKey;
		this.key = key;
		this.lookup = lookup;
		this.status = (Optional<Enum<?>>) status;
	}

	public <T, K, S extends Enum<?>> EntityLookupException(Class<T> clazz, StatusMask statusMask, LookupKey lookupKey, @Nullable K key) {
		super("Cannot lookup " + statusMask + " " + clazz.getName() + " " + lookupKey + "=" + key);
		this.clazz = clazz;
		this.statusMask = statusMask;
		this.lookupKey = lookupKey;
		this.key = key;
		this.lookup = null;
		this.status = Optional.<Enum<?>>absent();
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
	 * The provided key that was searched.
	 * If {@code null} means the caller actually looks up empty key (which should always fail with {@link Optional#absent()}).
	 * In case of {@link LookupKey#SLUG}, due to use of {@code canonicalSlug}, the searched key may be
	 * different than the actual key. However the actual key is not informed in this exception.
	 * @return the key
	 */
	@Nullable
	public Object getKey() {
		return key;
	}

	/**
	 * @return the lookup
	 */
	@Nullable
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

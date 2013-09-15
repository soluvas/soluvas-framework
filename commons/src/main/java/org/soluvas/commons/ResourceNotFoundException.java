package org.soluvas.commons;

import javax.annotation.Nullable;

/**
 * General exception to throw if a resource such as a person, article,
 * or other entity is not found during lookup and should be handled by the UI request controller.
 * For example, in Wicket web app, throw this so it can be handled by exception handler
 * which will show either the 404 page or search page.
 * @author ceefour
 * @todo Merge with {@link org.soluvas.data.EntityLookupException}
 */
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static enum LookupType {
		ID,
		SLUG,
		FORMAL_ID,
		SLUG_PATH
	}
	
	public static <T> T checkNotNull(T obj, Class<T> clazz, LookupType lookupType, @Nullable String id, Object lookup) {
		if (obj == null) {
			throw new ResourceNotFoundException(String.format("%s with %s '%s' not found in %s",
				clazz.getName(), lookupType, id, lookup));
		} else {
			return obj;
		}
	}

	/**
	 * 
	 */
	public ResourceNotFoundException() {
	}

	/**
	 * @param message
	 */
	public ResourceNotFoundException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ResourceNotFoundException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ResourceNotFoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

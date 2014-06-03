package org.soluvas.commons;

/**
 * Factory for creating entities.
 * @author rudi
 */
public interface Creator<T, P> {

	/**
	 * Create an entirely blank entity.
	 * @return
	 */
	<S extends T> S newBlank(P params);
	
	/**
	 * Create an entity with administrative attributes filled,
	 * and other attributes with common values (e.g. quantity = 1).
	 * @return
	 */
	<S extends T> S newDefault(P params);
	
}

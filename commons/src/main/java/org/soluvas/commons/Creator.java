package org.soluvas.commons;


/**
 * Factory for creating raw entities.
 * @author rudi
 */
public interface Creator<T> {

	/**
	 * Create an entirely blank entity.
	 * @return
	 */
	T newBlank();
	
	/**
	 * Create an entity with administrative attributes filled,
	 * and other attributes with common values (e.g. quantity = 1).
	 * @return
	 */
	T newDefault();
	
}

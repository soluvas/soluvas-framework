package org.soluvas.data.repository;

/**
 * All repositories must support three operations:
 * {@link #isEmpty()}, {@link #count()}, and {@link #deleteAll()}. 
 * @author ceefour
 */
public interface BasicRepository {

	/** Returns {@code true} if the repository contains no entities. */
	boolean isEmpty();

	/**
	 * Returns the number of entities available.
	 * 
	 * @return the number of entities
	 */
	long count();

	/**
	 * Deletes all entities managed by the repository.
	 * @return The number of deleted entities (can be approximation). 0 if nothing. -1 if unknown.
	 */
	long deleteAll();

}

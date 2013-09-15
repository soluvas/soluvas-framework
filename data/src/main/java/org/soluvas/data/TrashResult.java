package org.soluvas.data;

import org.soluvas.data.repository.Trashable;

/**
 * Result of {@link Trashable} trash operations. For error, use {@link Exception} instead.
 * @author ceefour
 * @see Trashable#trash(Object)
 * @see Trashable#trashAll(java.util.Collection)
 * @see Trashable#trashAllByIds(java.util.Collection)
 * @see Trashable#trashById(java.io.Serializable)
 */
public enum TrashResult {
	/**
	 * ID ({@link StatusMask#RAW}) was not found. 
	 */
	NOT_FOUND,
	/**
	 * ID ({@link StatusMask#RAW}) was found and then trashed.
	 */
	TRASHED,
	/**
	 * ID ({@link StatusMask#RAW}) was found, but already in trashed status.
	 */
	ALREADY_TRASHED
}

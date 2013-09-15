package org.soluvas.data;

import org.soluvas.data.repository.Trashable;

/**
 * Result of {@link Trashable} untrash operations. For error, use {@link Exception} instead.
 * @author ceefour
 * @see Trashable#untrash(Object)
 * @see Trashable#untrashAll(java.util.Collection)
 * @see Trashable#untrashAllByIds(java.util.Collection)
 * @see Trashable#untrashById(java.io.Serializable)
 */
public enum UntrashResult {
	/**
	 * ID ({@link StatusMask#RAW}) was not found. 
	 */
	NOT_FOUND,
	/**
	 * ID ({@link StatusMask#RAW}) was found and then untrashed.
	 */
	UNTRASHED,
	/**
	 * ID ({@link StatusMask#RAW}) was found, but already in untrashed status.
	 */
	ALREADY_UNTRASHED
}

package org.soluvas.data.repository;

/**
 * Thrown when entity to be {@link CrudRepository#modify(java.util.Map)}-ed has
 * been changed in the database by another thread/connection.
 * @author rudi
 */
public class StaleEntityException extends Exception {

	public StaleEntityException() {
		super();
	}

	public StaleEntityException(String message, Throwable cause) {
		super(message, cause);
	}

	public StaleEntityException(String message) {
		super(message);
	}

	public StaleEntityException(Throwable cause) {
		super(cause);
	}

	public StaleEntityException(Throwable cause, String format, Object... args) {
		super(String.format(format, args), cause);
	}

}

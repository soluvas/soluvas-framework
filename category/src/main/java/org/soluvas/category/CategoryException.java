package org.soluvas.category;

/**
 * @author ceefour
 *
 */
@SuppressWarnings("serial")
public class CategoryException extends RuntimeException {

	/**
	 * 
	 */
	public CategoryException() {
	}

	/**
	 * @param message
	 */
	public CategoryException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public CategoryException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CategoryException(String message, Throwable cause) {
		super(message, cause);
	}

	public CategoryException(Throwable cause, String message, Object... args) {
		super(String.format(message, args), cause);
	}

}

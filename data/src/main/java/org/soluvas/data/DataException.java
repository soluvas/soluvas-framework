package org.soluvas.data;

/**
 * @author ceefour
 */
@SuppressWarnings("serial")
public class DataException extends RuntimeException {

	public DataException() {
		super();
	}

	/**
	 * @param message
	 */
	public DataException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public DataException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DataException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataException(Throwable cause, String format, Object... args) {
		super(String.format(format, args), cause);
	}

}

package org.soluvas.jpa;

/**
 * @author ceefour
 */
@SuppressWarnings("serial")
public class JpaRepositoryException extends RuntimeException {

	public JpaRepositoryException() {
		super();
	}

	public JpaRepositoryException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public JpaRepositoryException(String message, Throwable cause) {
		super(message, cause);
	}

	public JpaRepositoryException(String message) {
		super(message);
	}

	public JpaRepositoryException(Throwable cause) {
		super(cause);
	}

	public JpaRepositoryException(Throwable cause, String format, Object... args) {
		super(String.format(format, args), cause);
	}

}

package org.soluvas.couchdb;

/**
 * @author ceefour
 */
@SuppressWarnings("serial")
public class CouchDbRepositoryException extends RuntimeException {

	public CouchDbRepositoryException() {
		super();
	}

	public CouchDbRepositoryException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CouchDbRepositoryException(String message, Throwable cause) {
		super(message, cause);
	}

	public CouchDbRepositoryException(String message) {
		super(message);
	}

	public CouchDbRepositoryException(Throwable cause) {
		super(cause);
	}

	public CouchDbRepositoryException(Throwable cause, String format, Object... args) {
		super(String.format(format, args), cause);
	}

}

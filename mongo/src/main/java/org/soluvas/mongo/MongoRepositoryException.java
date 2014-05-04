package org.soluvas.mongo;

/**
 * @author ceefour
 *
 */
public class MongoRepositoryException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MongoRepositoryException() {
		super();
	}

	public MongoRepositoryException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MongoRepositoryException(String message, Throwable cause) {
		super(message, cause);
	}

	public MongoRepositoryException(String message) {
		super(message);
	}

	public MongoRepositoryException(Throwable cause) {
		super(cause);
	}

	public MongoRepositoryException(Throwable cause, String format, Object... args) {
		super(String.format(format, args), cause);
	}

}

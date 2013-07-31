package org.soluvas.data.push;

/**
 * Unchecked exception thrown by {@link SyncRepository} implementations.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class RepositoryException extends RuntimeException {

	public RepositoryException() {
		super();
	}

	public RepositoryException(String message, Throwable cause) {
		super(message, cause);
	}

	public RepositoryException(String message) {
		super(message);
	}

	public RepositoryException(Throwable cause) {
		super(cause);
	}

	public RepositoryException(Throwable cause, String format, Object... args) {
		super(String.format(format, args), cause);
	}

}

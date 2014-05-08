package org.soluvas.commons.tenant;

/**
 * @author rudi
 *
 */
public class TenantException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public TenantException() {
	}

	/**
	 * @param message
	 */
	public TenantException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public TenantException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public TenantException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public TenantException(Throwable cause, String message, Object... args) {
		super(String.format(message, args), cause);
	}

}

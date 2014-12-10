package org.soluvas.commons.tenant;

import org.soluvas.commons.config.MultiTenantWebConfig;

/**
 * Thrown when {@link MultiTenantWebConfig} cannot find the specified tenant,
 * so Wicket / Soluvas Web can display appropriate 404 not found page,
 * instead of internal error. 
 * @author ceefour
 */
@SuppressWarnings("serial")
public class TenantNotFoundException extends TenantException {

	public TenantNotFoundException() {
	}

	/**
	 * @param message
	 */
	public TenantNotFoundException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public TenantNotFoundException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public TenantNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public TenantNotFoundException(Throwable cause, String format, Object... args) {
		super(String.format(format, args), cause);
	}

}

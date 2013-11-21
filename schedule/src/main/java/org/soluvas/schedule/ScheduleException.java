package org.soluvas.schedule;

/**
 * @author ceefour
 *
 */
public class ScheduleException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ScheduleException() {
	}

	/**
	 * @param message
	 */
	public ScheduleException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ScheduleException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ScheduleException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ScheduleException(Throwable cause, String message, Object... args) {
		super(String.format(message, args), cause);
	}

}

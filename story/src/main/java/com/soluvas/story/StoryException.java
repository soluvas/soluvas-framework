package com.soluvas.story;

/**
 * @author rully
 *
 */
@SuppressWarnings("serial")
public class StoryException extends RuntimeException {

	/**
	 * 
	 */
	public StoryException() {
	}

	/**
	 * @param message
	 */
	public StoryException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public StoryException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public StoryException(String message, Throwable cause) {
		super(message, cause);
	}

	public StoryException(Throwable cause, String message, Object... args) {
		super(String.format(message, args), cause);
	}

}

package org.soluvas.image;

/**
 * @author ceefour
 *
 */
@SuppressWarnings("serial")
public class ImageException extends RuntimeException {

	/**
	 * 
	 */
	public ImageException() {
	}

	/**
	 * @param message
	 */
	public ImageException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ImageException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ImageException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ImageException(Throwable cause, String message, Object... args) {
		super(String.format(message, args), cause);
	}

}

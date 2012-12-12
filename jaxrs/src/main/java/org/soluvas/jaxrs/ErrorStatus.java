package org.soluvas.jaxrs;

/**
 * @author atang
 *
 */
public class ErrorStatus<T> extends Status<T> {
	
	public ErrorStatus() {
		super("error");
	}
	
	public ErrorStatus(String message) {
		super("error");
		setMessage(message);
	}

	public ErrorStatus(String message, Throwable exception) {
		super("error");
		setMessage(message);
		setException(exception != null ? exception.getClass().getName() + ": " + exception.getMessage() : null);
	}

}

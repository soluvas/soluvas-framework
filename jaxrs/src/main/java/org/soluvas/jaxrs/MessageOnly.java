package org.soluvas.jaxrs;

/**
 * @author rudi
 *
 */
public class MessageOnly {
	
	private String message;

	public MessageOnly() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MessageOnly [message=" + message + "]";
	}
	

}

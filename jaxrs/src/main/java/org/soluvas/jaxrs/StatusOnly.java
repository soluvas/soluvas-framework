package org.soluvas.jaxrs;

/**
 * @author rudi
 *
 */
public class StatusOnly {
	
	public static final String INFO_STATUS = "INFO";
	public static final String WARN_STATUS = "WARN";
	public static final String ERROR_STATUS = "ERROR";
	
	private String status;
	private String message;
	
	public StatusOnly() {
		super();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "StatusOnly [status=" + status + ", message=" + message + "]";
	}
	

}

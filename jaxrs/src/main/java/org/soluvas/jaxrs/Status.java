package org.soluvas.jaxrs;


/**
 * @author atang
 */
//@XmlRootElement
public class Status<T> {

	private String status;
	private String exception;
	private String message;
	
	public Status() {
		super();
	}
	
	public Status(String status) {
		super();
		this.status = status;
	}

	public Status(String status, String exception, String message) {
		super();
		this.status = status;
		this.exception = exception;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getException() {
		return exception;
	}
	
	public void setException(String exception) {
		this.exception = exception;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return String.format("Status [status=%s, exception=%s, message=%s]",
				status, exception, message);
	}

}

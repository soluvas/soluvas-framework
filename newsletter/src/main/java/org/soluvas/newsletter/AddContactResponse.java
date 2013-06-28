/**
 * 
 */
package org.soluvas.newsletter;

/**
 * @author atang
 *
 */
public class AddContactResponse {
	
	private String status;
	private String contact_id;
	
	public AddContactResponse() {
		super();
	}
	
	public AddContactResponse(String status, String contact_id) {
		super();
		this.status = status;
		this.contact_id = contact_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContact_id() {
		return contact_id;
	}

	public void setContact_id(String contact_id) {
		this.contact_id = contact_id;
	}

	@Override
	public String toString() {
		return "AddContactResponse ["
				+ (status != null ? "status=" + status + ", " : "")
				+ (contact_id != null ? "contact_id=" + contact_id : "") + "]";
	}

	
	
}

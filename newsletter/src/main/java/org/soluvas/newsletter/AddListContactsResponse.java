package org.soluvas.newsletter;

/**
 * @author atang
 *
 */
public class AddListContactsResponse {
	
	private String status;
	private String list_id;
	/**
	 * 
	 */
	public AddListContactsResponse() {
		super();
	}
	
	public AddListContactsResponse(String status, String list_id) {
		super();
		this.status = status;
		this.list_id = list_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getList_id() {
		return list_id;
	}

	public void setList_id(String list_id) {
		this.list_id = list_id;
	}

	@Override
	public String toString() {
		return "NewListContactsResponse ["
				+ (status != null ? "status=" + status + ", " : "")
				+ (list_id != null ? "list_id=" + list_id : "") + "]";
	}
	
	
}

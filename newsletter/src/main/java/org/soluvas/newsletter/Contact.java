package org.soluvas.newsletter;

/**
 * @author atang
 *
 */
public class Contact {
	
	private Long id;
	private Long last_activity;
	private String email;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLast_activity() {
		return last_activity;
	}

	public void setLast_activity(Long last_activity) {
		this.last_activity = last_activity;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact ["
				+ (id != null ? "id=" + id + ", " : "")
				+ (last_activity != null ? "last_activity=" + last_activity
						+ ", " : "") + (email != null ? "email=" + email : "")
				+ "]";
	}

}

package org.soluvas.commons;

import java.io.Serializable;
import java.util.List;

/**
 * @author rudi
 *
 */
public class AdminMall implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String id;
	private final String name;
	private final List<String> securityRoleIds;
	private final List<String> emails;
	
	public AdminMall(String id, String name, List<String> securityRoleIds, List<String> emails) {
		super();
		this.id = id;
		this.name = name;
		this.securityRoleIds = securityRoleIds;
		this.emails = emails;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the securityRoleIds
	 */
	public List<String> getSecurityRoleIds() {
		return securityRoleIds;
	}

	/**
	 * @return the emails
	 */
	public List<String> getEmails() {
		return emails;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AdminMall [id=" + id + ", name=" + name + ", securityRoleIds=" + securityRoleIds + ", emails=" + emails
				+ "]";
	}

}

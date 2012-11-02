package org.soluvas.commons.tenant;

import java.io.Serializable;

/**
 * @author ceefour
 *
 */
@SuppressWarnings("serial")
public class TenantRef implements Serializable {

	private String clientId;
	private String tenantId;
	private String tenantEnv;
	
	public TenantRef(String clientId, String tenantId, String tenantEnv) {
		super();
		this.clientId = clientId;
		this.tenantId = tenantId;
		this.tenantEnv = tenantEnv;
	}

	/**
	 * Client ID is usually null. Only used by shell-based tenant usage.
	 * 
	 * @return
	 */
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getTenantEnv() {
		return tenantEnv;
	}

	public void setTenantEnv(String tenantEnv) {
		this.tenantEnv = tenantEnv;
	}

	@Override
	public String toString() {
		return "TenantRef [tenantId=" + tenantId + ", tenantEnv=" + tenantEnv
				+ "]";
	}
	
}

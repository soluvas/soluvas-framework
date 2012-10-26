package org.soluvas.multitenant;

import java.io.Serializable;

/**
 * @author ceefour
 *
 */
@SuppressWarnings("serial")
public class TenantRef implements Serializable {

	private String tenantId;
	private String tenantEnv;
	
	public TenantRef(String tenantId, String tenantEnv) {
		super();
		this.tenantId = tenantId;
		this.tenantEnv = tenantEnv;
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

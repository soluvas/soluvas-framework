package org.soluvas.commons.tenant;

import com.google.common.base.Strings;

/**
 * @author ceefour
 *
 */
@SuppressWarnings("serial")
public class TenantRefImpl implements TenantRef {

	private String clientId;
	private String tenantId;
	private String tenantEnv;
	
	/**
	 * make it CGLIB-proxiable.
	 * @todo use interfaces instead.
	 */
	public TenantRefImpl() {
		super();
	}
	
	public TenantRefImpl(String clientId, String tenantId, String tenantEnv) {
		super();
		this.clientId = clientId;
		this.tenantId = tenantId;
		this.tenantEnv = tenantEnv;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.commons.tenant.TenantRef#getClientId()
	 */
	@Override
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.commons.tenant.TenantRef#getTenantId()
	 */
	@Override
	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.commons.tenant.TenantRef#getTenantEnv()
	 */
	@Override
	public String getTenantEnv() {
		return tenantEnv;
	}

	public void setTenantEnv(String tenantEnv) {
		this.tenantEnv = tenantEnv;
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.commons.tenant.TenantRef#getKey()
	 */
	@Override
	public String getKey() {
		return Strings.nullToEmpty(tenantId) + "_" + Strings.nullToEmpty(tenantEnv);
	}

	@Override
	public String toString() {
		return "TenantRef [tenantId=" + tenantId + ", tenantEnv=" + tenantEnv
				+ "]";
	}
	
}

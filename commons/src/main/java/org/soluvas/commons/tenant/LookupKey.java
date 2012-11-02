package org.soluvas.commons.tenant;

public class LookupKey {
	private String clientId;
	private String tenantEnv;
	private String tenantId;
	private String namespace;
	
	public LookupKey(String clientId, String tenantEnv, String tenantId,
			String namespace) {
		super();
		this.clientId = clientId;
		this.tenantEnv = tenantEnv;
		this.tenantId = tenantId;
		this.namespace = namespace;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result
				+ ((namespace == null) ? 0 : namespace.hashCode());
		result = prime * result
				+ ((tenantEnv == null) ? 0 : tenantEnv.hashCode());
		result = prime * result
				+ ((tenantId == null) ? 0 : tenantId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LookupKey other = (LookupKey) obj;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		if (namespace == null) {
			if (other.namespace != null)
				return false;
		} else if (!namespace.equals(other.namespace))
			return false;
		if (tenantEnv == null) {
			if (other.tenantEnv != null)
				return false;
		} else if (!tenantEnv.equals(other.tenantEnv))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		return true;
	}
	
}
package org.soluvas.commons.tenant;

import java.io.Serializable;

public interface TenantRef extends Serializable {

	/**
	 * Client ID is usually null. Only used by shell-based tenant usage.
	 * 
	 * @return
	 */
	public abstract String getClientId();

	public abstract String getTenantId();

	public abstract String getTenantEnv();

	/**
	 * Returns e.g. <code>tuneeca_dev</code>.
	 * @return
	 */
	public abstract String getKey();

}
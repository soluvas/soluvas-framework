package org.soluvas.commons.tenant;

/**
 * How to create the tenant's {@code dataDir} when provisioned.
 * @author rudi
 */
public enum TenantDirProvision {
	/**
	 * Directly creates the tenant {@code dataDir} under {@code workspaceDir}. 
	 */
	WORKSPACE,
	/**
	 * Creates the tenant {@code dataDir} under <tt>~/git/${hotelId}-model</tt>,
	 * then symlinks to it from <tt>${workspaceDir}/tenantId</tt>. 
	 */
	SYMLINK
}

package org.soluvas.commons;

import org.soluvas.commons.tenant.TenantXmiBeansImpl;

/**
 * Used by {@link TenantXmiBeansImpl} to specify behavior
 * when adding/modifying/deleting entities.
 * @author ceefour
 */
public enum VersioningMode {
	/**
	 * Saves the modified entity(s) to file(s),
	 * then applies template and {@link Expandable#expand(java.util.Map)} for in-memory operational copy(s).
	 * 
	 * <p>Note: {@link TenantXmiBeansImpl} does not support entirely diskless operation.
	 */
	FILE,
	/**
	 * Does {@link #FILE}, then commits the working tree using the SCM (usually git), but does not sync. 
	 */
	WORKING,
	/**
	 * Does {@link #FILE} then {@link #WORKING}, then syncs the local repository with the remote repository.
	 * In git, this will do a {@code git pull} then {@code git push}. 
	 */
	SYNC
}

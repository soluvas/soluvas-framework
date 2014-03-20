package org.soluvas.commons.tenant;

import org.osgi.framework.Bundle;

/**
 * Runtime tenant state, inspired by OSGi {@link Bundle} states.
 * @author ceefour
 */
public enum TenantState {

	UNINSTALLED,
	RESOLVED,
	STARTING,
	ACTIVE,
	STOPPING
	
}

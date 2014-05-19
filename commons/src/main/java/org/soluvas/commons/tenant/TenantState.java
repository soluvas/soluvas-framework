package org.soluvas.commons.tenant;

import java.util.Map;

import org.osgi.framework.Bundle;

import com.google.common.collect.ImmutableMap;

/**
 * Runtime tenant state, inspired by OSGi {@link Bundle} states.
 * @author ceefour
 */
public enum TenantState {

	UNINSTALLED,
	RESOLVED,
	STARTING,
	ACTIVE,
	STOPPING;
	
	/**
	 * Mapping to Bootstrap glyphicons.
	 */
	public static final Map<TenantState, String> ICON_MAPPING = ImmutableMap.of(
			UNINSTALLED, "eject",
			RESOLVED, "stop",
			STARTING, "cog",
			ACTIVE, "play",
			STOPPING, "pause");
}

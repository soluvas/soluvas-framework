package org.soluvas.security;

import java.util.Set;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.DomainPermission;

/**
 * {@link Permission} for tenant actions.
 * @author ceefour
 */
public class TenantPermission extends DomainPermission {

	private static final long serialVersionUID = 1L;

	public TenantPermission() {
	}

	/**
	 * @param actions
	 */
	public TenantPermission(String actions) {
		super(actions);
	}

	/**
	 * @param actions
	 * @param targets
	 */
	public TenantPermission(String actions, String targets) {
		super(actions, targets);
	}

	/**
	 * @param actions
	 * @param targets
	 */
	public TenantPermission(Set<String> actions, Set<String> targets) {
		super(actions, targets);
	}

}

package org.soluvas.security;

import org.apache.shiro.authz.permission.DomainPermission;
import org.soluvas.commons.ToStringFunction;

import com.google.common.collect.FluentIterable;

/**
 * Permission for {@link PersonAction}.
 * @author rudi
 */
public class CustomerRolePermission extends DomainPermission {
	
	private static final long serialVersionUID = 1L;

	public CustomerRolePermission(CustomerRoleAction action, String targets) {
		super(action.name(), targets);
	}

	public CustomerRolePermission(CustomerRoleAction action) {
		super(action.name());
	}

	public CustomerRolePermission(Iterable<CustomerRoleAction> actions, Iterable<?> targets) {
		super(FluentIterable.from(actions).transform(new ToStringFunction<>()).toSet(),
				FluentIterable.from(targets).transform(new ToStringFunction<>()).toSet());
	}

}

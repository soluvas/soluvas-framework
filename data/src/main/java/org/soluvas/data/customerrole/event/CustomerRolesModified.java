package org.soluvas.data.customerrole.event;

import org.soluvas.commons.impl.CustomerRole2;
import org.soluvas.push.TenantEvent;

import com.google.common.collect.ImmutableList;

/**
 * @author rudi
 *
 */
public class CustomerRolesModified extends TenantEvent {
	
	private static final long serialVersionUID = 1L;
	
	private final ImmutableList<CustomerRole2> customerRoles;
	
	@Deprecated
	public CustomerRolesModified(ImmutableList<CustomerRole2> customerRoles, String trackingId) {
		super(null, trackingId);
		this.customerRoles = customerRoles;
	}

	public CustomerRolesModified(String tenantId, ImmutableList<CustomerRole2> customerRoles, String trackingId) {
		super(tenantId, trackingId);
		this.customerRoles = customerRoles;
	}

	public ImmutableList<CustomerRole2> getCustomerRoles() {
		return customerRoles;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "CustomerRolesModified ["
				+ (customerRoles != null ? "customerRoles="
						+ customerRoles.subList(0,
								Math.min(customerRoles.size(), maxLen)) : "")
				+ "]";
	}
	
}

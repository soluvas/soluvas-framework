package org.soluvas.data.customerrole.event;

import org.soluvas.commons.CustomerRole;
import org.soluvas.push.TrackableEvent;

import com.google.common.collect.ImmutableList;

/**
 * @author rudi
 *
 */
public class CustomerRolesAdded extends TrackableEvent {
	
	private static final long serialVersionUID = 1L;
	
	public final ImmutableList<CustomerRole> customerRoles;
	
	public CustomerRolesAdded(ImmutableList<CustomerRole> customerRoles, String trackingId) {
		super(trackingId);
		this.customerRoles = customerRoles;
	}

	public ImmutableList<CustomerRole> getCustomerRoles() {
		return customerRoles;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "CustomerRolesAdded ["
				+ (customerRoles != null ? "customerRoles="
						+ customerRoles.subList(0,
								Math.min(customerRoles.size(), maxLen)) : "")
				+ "]";
	}
	
}

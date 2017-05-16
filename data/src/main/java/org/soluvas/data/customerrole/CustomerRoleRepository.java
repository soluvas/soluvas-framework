package org.soluvas.data.customerrole;

import javax.annotation.Nullable;

import org.soluvas.commons.impl.CustomerRole2;
import org.soluvas.data.StatusMask;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.repository.CrudRepository;

import com.google.common.collect.ImmutableSet;

/**
 * @author rudi
 *
 */
public interface CustomerRoleRepository extends CrudRepository<CustomerRole2, String> {
	
	Page<CustomerRole2> findAll(StatusMask statusMask, Pageable pageable);
	
	Page<CustomerRole2> findAll(StatusMask statusMask, @Nullable String searchText, Pageable pageable);
	
	long count(StatusMask statusMask);
	
	ImmutableSet<String> findAllIds();
	
	ImmutableSet<String> findAllIdsBySalesOrderReportEnabled(StatusMask statusMask);
	
	ImmutableSet<String> findAllIdsByQuickShopEnabled(StatusMask statusMask);
	
	ImmutableSet<String> findAllIdsByHistorySalesOrderEnabled(StatusMask statusMask);
	
	ImmutableSet<String> findAllIdsByAgentSalesReportEnabled(StatusMask statusMask);

	ImmutableSet<String> findAllIdsByTransactionHistoryEnabled(StatusMask statusMask);
	
	ImmutableSet<String> findAllIdsByBookingEnabled(StatusMask statusMask);
	
	ImmutableSet<String> findAllCustRoleByPaymentGatewayEnabled(StatusMask statusMask);
	
	ImmutableSet<String> findAllCustRoleByReviewReminderEnabled(StatusMask statusMask);
	
	int getBookingExpiryTime(String id);
	
	boolean isDropShipEnabled(String customerRole);
	
	@Nullable Long getZendeskOrganizationId(String customerRoleId);
	
}

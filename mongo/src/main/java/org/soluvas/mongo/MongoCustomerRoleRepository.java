package org.soluvas.mongo;

import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.CustomerRole;
import org.soluvas.commons.CustomerRoleCatalog;
import org.soluvas.commons.CustomerRoleStatus;
import org.soluvas.commons.OnDemandXmiLoader;
import org.soluvas.commons.impl.CustomerRoleImpl;
import org.soluvas.data.StatusMask;
import org.soluvas.data.customerrole.CustomerRoleRepository;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.data.domain.Sort.Order;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * {@code base} {@link CustomerRole}s are read from
 * {@code /org.soluvas.commons/src/main/resources/org/soluvas/commons/base.CustomerRoleCatalog.xmi}.
 * @author rudi
 */
public class MongoCustomerRoleRepository extends MongoRepositoryBase<CustomerRole>
	implements CustomerRoleRepository {

	public MongoCustomerRoleRepository(String mongoUri,
			boolean migrationEnabled,
			boolean autoExplainSlow) {
		super(CustomerRole.class, CustomerRoleImpl.class, CustomerRoleImpl.serialVersionUID, mongoUri, ReadPattern.SECONDARY_PREFERRED,
				"customerRole", null, migrationEnabled, autoExplainSlow,
				Index.desc("creationTime"),
				Index.desc("modificationTime"),
				Index.asc("status"),
				Index.asc("historySalesOrderEnabled"),
				Index.asc("quickShopEnabled"),
				Index.asc("salesOrderReportEnabled"),
				Index.asc("agentSalesReportEnabled"),
				Index.asc("transactionHistoryEnabled"));
		ensureBaseEntities();
	}

	protected void ensureBaseEntities() {
		final CustomerRoleCatalog base = new OnDemandXmiLoader<CustomerRoleCatalog>(CommonsPackage.eINSTANCE,
				CustomerRole.class, "base.CustomerRoleCatalog.xmi").get();
		final ImmutableSet<String> baseCustomerRoleIds = FluentIterable.from(base.getCustomerRoles())
				.transform(new org.soluvas.commons.IdFunction()).toSet();
		log.debug("Ensuring {} base CustomerRoles from {}: {}",
				base.getCustomerRoles().size(), base.eResource().getURI(),
				baseCustomerRoleIds);
		final Set<String> existing = exists(baseCustomerRoleIds);
		for (final CustomerRole customerRole : base.getCustomerRoles()) {
			if (!existing.contains(customerRole.getId())) {
				add(customerRole);
			}
			primary.update(new BasicDBObject("_id", customerRole.getId()),
					new BasicDBObject("$set", ImmutableMap.of(
							"description", customerRole.getDescription(),
							"readOnly", customerRole.isReadOnly())));
		}
		log.info("Ensured {} base CustomerRoles from {}: {}",
				base.getCustomerRoles().size(), base.eResource().getURI(),
				baseCustomerRoleIds);
	}

	@Override
	public Page<CustomerRole> findAll(@Nonnull StatusMask statusMask, @Nonnull Pageable pageable) {
		//query
		final DBObject query = new BasicDBObject();
		augmentQueryForStatusMask(query, statusMask);
		//sort
		final BasicDBObject sortObj = new BasicDBObject();
		if (pageable.getSort() != null) {
			for (final Order order : pageable.getSort()) {
				sortObj.put(order.getProperty(), order.getDirection() == Direction.DESC ? -1 : 1);
			}
		}
		if (sortObj.isEmpty()) {
			// do NOT add modificationTime as "default", sorting isn't free! it uses CPU time and sometimes require index (without it, query fails)
			log.warn("No sort for find customerRoles using {} pageable {}, please add Order or use Sort.unsorted()",
					query, pageable);
		}
		final List<CustomerRole> customerRoles = findPrimary(query, null, sortObj, pageable.getOffset(), pageable.getPageSize(), "findAll",
				statusMask, pageable);
		if (customerRoles.isEmpty()) {
			return new PageImpl<>(ImmutableList.<CustomerRole>of(), pageable, 0);
		} else {
			//count
			final long count = countByQuery(query);
			return new PageImpl<>(customerRoles, pageable, count);
		}
	}
	
	@Override
	public Page<CustomerRole> findAll(@Nonnull StatusMask statusMask, @Nullable String searchText, @Nonnull Pageable pageable) {
		//query
		final BasicDBObject query = getQueryBySearchText(statusMask, searchText);
		//sort
		final BasicDBObject sortObj = new BasicDBObject();
		if (pageable.getSort() != null) {
			for (final Order order : pageable.getSort()) {
				sortObj.put(order.getProperty(), order.getDirection() == Direction.DESC ? -1 : 1);
			}
		}
		if (sortObj.isEmpty()) {
			// do NOT add modificationTime as "default", sorting isn't free! it uses CPU time and sometimes require index (without it, query fails)
			log.warn("No sort for find customerRoles using {} pageable {}, please add Order or use Sort.unsorted()",
					query, pageable);
		}
		final List<CustomerRole> customerRoles = findSecondary(query, null, sortObj, pageable.getOffset(), pageable.getPageSize(), "findAll",
				statusMask, pageable);
		if (customerRoles.isEmpty()) {
			return new PageImpl<>(ImmutableList.<CustomerRole>of(), pageable, 0);
		} else {
			//count
			final long count = countByQuery(query);
			return new PageImpl<>(customerRoles, pageable, count);
		}
	}
	
	@Override
	public long count(@Nonnull StatusMask statusMask) {
		//query
		final DBObject query = new BasicDBObject();
		augmentQueryForStatusMask(query, statusMask);
		return countByQuery(query);
	}
	
	private BasicDBObject getQueryBySearchText(StatusMask statusMask, String searchText) {
		final Pattern regex = Pattern.compile(Pattern.quote(searchText), Pattern.CASE_INSENSITIVE);
		BasicDBObject nameQuery = new BasicDBObject("name", regex);
		BasicDBObject idQuery = new BasicDBObject("_id", regex);
		BasicDBObject query = new BasicDBObject("$or", ImmutableList.of(nameQuery, idQuery));
		augmentQueryForStatusMask(query, statusMask);
		log.debug("Query is {}", query);
		return query;
	}
	
	protected void augmentQueryForStatusMask(DBObject query, StatusMask statusMask) {
		Preconditions.checkArgument(!query.containsField("status"),
				"Query to be augmented using StatusMask must not already have a 'status' criteria.");
		switch (statusMask) {
		case RAW:
			break;
		case ACTIVE_ONLY:
			query.put("status", CustomerRoleStatus.ACTIVE.name());
			break;
		case INCLUDE_INACTIVE:
			query.put("status", new BasicDBObject("$in", 
					ImmutableSet.of(CustomerRoleStatus.ACTIVE.name(), CustomerRoleStatus.INACTIVE.name())));
			break;
		case VOID_ONLY:
			query.put("status", CustomerRoleStatus.VOID.name());
			break;
		default:
			throw new IllegalArgumentException("Unrecognized StatusMask: " + statusMask);	
		}
	}

	@Override
	public ImmutableSet<String> findAllIds() {
		final List<DBObject> objs = findSecondaryAsDBObjects(null, new BasicDBObject("_id", true), null, 0, 0, "findAllIds");
		return FluentIterable.from(objs).transform(new DBObjectToId()).toSet();
	}

	@Override
	public ImmutableSet<String> findAllIdsBySalesOrderReportEnabled(StatusMask statusMask) {
		final BasicDBObject query = new BasicDBObject("salesOrderReportEnabled", true);
		augmentQueryForStatusMask(query, statusMask);
		
		final List<DBObject> objs = findSecondaryAsDBObjects(query, new BasicDBObject("_id", true), null, 0, 0, "findAllIdsBySalesOrderReportEnabled", statusMask);
		return FluentIterable.from(objs).transform(new DBObjectToId()).toSet();
	}

	@Override
	public ImmutableSet<String> findAllIdsByQuickShopEnabled(StatusMask statusMask) {
		final BasicDBObject query = new BasicDBObject("quickShopEnabled", true);
		augmentQueryForStatusMask(query, statusMask);
		
		final List<DBObject> objs = findSecondaryAsDBObjects(query, new BasicDBObject("_id", true), null, 0, 0, "findAllIdsByQuickShopEnabled", statusMask);
		return FluentIterable.from(objs).transform(new DBObjectToId()).toSet();
	}

	@Override
	public ImmutableSet<String> findAllIdsByHistorySalesOrderEnabled(StatusMask statusMask) {
		final BasicDBObject query = new BasicDBObject("historySalesOrderEnabled", true);
		augmentQueryForStatusMask(query, statusMask);
		
		final List<DBObject> objs = findSecondaryAsDBObjects(query, new BasicDBObject("_id", true), null, 0, 0, "findAllIdsByHistorySalesOrderEnabled", statusMask);
		return FluentIterable.from(objs).transform(new DBObjectToId()).toSet();
	}

	@Override
	public ImmutableSet<String> findAllIdsByAgentSalesReportEnabled(StatusMask statusMask) {
		final BasicDBObject query = new BasicDBObject("agentSalesReportEnabled", true);
		augmentQueryForStatusMask(query, statusMask);
		
		final List<DBObject> objs = findSecondaryAsDBObjects(query, new BasicDBObject("_id", true), null, 0, 0, "findAllIdsByAgentSalesReportEnabled", statusMask);
		return FluentIterable.from(objs).transform(new DBObjectToId()).toSet();
	}

	@Override
	public ImmutableSet<String> findAllIdsByTransactionHistoryEnabled(StatusMask statusMask) {
		final BasicDBObject query = new BasicDBObject("transactionHistoryEnabled", true);
		augmentQueryForStatusMask(query, statusMask);
		
		final List<DBObject> objs = findSecondaryAsDBObjects(query, new BasicDBObject("_id", true), null, 0, 0, "findAllIdsByTransactionHistoryEnabled", statusMask);
		return FluentIterable.from(objs).transform(new DBObjectToId()).toSet();
	}
	
	@Override
	public ImmutableSet<String> findAllIdsByBookingEnabled(StatusMask statusMask) {
		final BasicDBObject query = new BasicDBObject("bookingEnabled", true);
		augmentQueryForStatusMask(query, statusMask);
		
		final List<DBObject> objs = findSecondaryAsDBObjects(query, new BasicDBObject("_id", true), null, 0, 0, "findAllIdsByBookingEnabled", statusMask);
		return FluentIterable.from(objs).transform(new DBObjectToId()).toSet();
	}
	
	@Override
	public ImmutableSet<String> findAllIdsByPaymentGatewayEnabled(StatusMask statusMask) {
		final BasicDBObject query = new BasicDBObject("paymentGatewayEnabled", true);
		augmentQueryForStatusMask(query, statusMask);
		
		final List<DBObject> objs = findSecondaryAsDBObjects(query, new BasicDBObject("_id", true), null, 0, 0, "findAllIdsByPaymentGatewayEnabled", statusMask);
		return FluentIterable.from(objs).transform(new DBObjectToId()).toSet();
	}

	@Override
	public int getBookingExpiryTime(String id) {
		final BasicDBObject query = new BasicDBObject();
		query.put("_id", id);
		
		final DBObject obj = findOnePrimary(query, new BasicDBObject("bookingExpiryTimeInMinutes", true), "getBookingExpiryTime", id);
//		log.debug("obj: {}", obj);
		if (obj != null && !"null".equals(obj)) {
			final Object objBookingExpiryTime = obj.get("bookingExpiryTimeInMinutes");
			if (objBookingExpiryTime != null && !"null".equals(objBookingExpiryTime)) {
				return Integer.valueOf(String.valueOf(objBookingExpiryTime)).intValue();
			}
			return 0;
		}
		return 0;
	}

	@Override
	public boolean isDropShipEnabled(String customerRole) {
		Preconditions.checkState(!Strings.isNullOrEmpty(customerRole), "Customer Role must not be null or empty.");
		final BasicDBObject query = new BasicDBObject("_id", customerRole);
		final BasicDBObject fields = new BasicDBObject("dropshipEnabled", true);
		final DBObject dbObj = findOnePrimary(query, fields, "isDropShipEnabled", customerRole);
		log.debug("dbObj: {}", dbObj);
		if (dbObj != null && !"null".equals(dbObj)) {
			final Object isDropShipEnabledObj = dbObj.get("dropshipEnabled");
			if (isDropShipEnabledObj != null && !"null".equals(isDropShipEnabledObj)) {
				final boolean dropShipEnabled = Boolean.valueOf(String.valueOf(isDropShipEnabledObj)).booleanValue();
//				log.debug("dropshipEnabled for customerRole {}: {}", customerRole, dropShipEnabled);
				return dropShipEnabled;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
	

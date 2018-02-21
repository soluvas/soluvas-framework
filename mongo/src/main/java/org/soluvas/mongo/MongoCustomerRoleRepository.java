package org.soluvas.mongo;

import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.soluvas.commons.CustomerRoleStatus;
import org.soluvas.commons.impl.CustomerRole2;
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
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class MongoCustomerRoleRepository extends MongoRepositoryBase<CustomerRole2>
	implements CustomerRoleRepository {

	public MongoCustomerRoleRepository(String mongoUri,
			boolean migrationEnabled,
			boolean autoExplainSlow) {
		super(CustomerRole2.class, CustomerRole2.class, CustomerRole2.serialVersionUID, mongoUri, ReadPattern.SECONDARY_PREFERRED,
				"customerRole", null, migrationEnabled, autoExplainSlow,
				Index.desc("creationTime"),
				Index.desc("modificationTime"),
				Index.asc("status"),
				Index.asc("historySalesOrderEnabled"),
				Index.asc("quickShopEnabled"),
				Index.asc("salesOrderReportEnabled"),
				Index.asc("agentSalesReportEnabled"),
				Index.asc("transactionHistoryEnabled"));
		upgradeEntityFrom1To2();
		ensureBaseEntities();
	}
	
	private void upgradeEntityFrom1To2() {
		final DBObject query = new BasicDBObject();
		query.put("schemaVersion", CustomerRoleImpl.serialVersionUID);
		
		final DBCursor cursor = primary.find(query);
		log.debug("Updating for {} row(s)", cursor.size());
		for (final DBObject dbObject : cursor) {
			dbObject.put("schemaVersion", CustomerRole2.serialVersionUID);
			dbObject.put("className", CustomerRole2.class.getName());
			primary.save(dbObject);
		}//end of looping
	}
	
	private List<CustomerRole2> getBases() {
		//common
		final CustomerRole2 common = new CustomerRole2();
		common.setId(CustomerRole2.COMMON_ID);
		common.setName("Common");
		common.setReadOnly(true);
		common.setDescription("Registered users / retail.");
		
		//agent
		final CustomerRole2 member = new CustomerRole2();
		member.setId(CustomerRole2.MEMBER_ID);
		member.setName("Premium Member");
		member.setReadOnly(true);
		member.setDescription("Premium members.");
		
		final CustomerRole2 agent = new CustomerRole2();
		agent.setId(CustomerRole2.AGENT_ID);
		agent.setName("Agent");
		agent.setReadOnly(true);
		agent.setDescription("Reseller agents.");
		
		final CustomerRole2 drops = new CustomerRole2();
		drops.setId(CustomerRole2.DROPS_ID);
		drops.setName("Drop shipper");
		drops.setReadOnly(true);
		drops.setDescription("Retailers not keeping goods in stock, but instead transfer customer orders and shipment details to us.");
		
		return ImmutableList.of(common, member, agent, drops);
	}
			
	protected void ensureBaseEntities() {
		final List<CustomerRole2> bases = getBases();
//		final List<String> baseCustomerRoleIds = bases.stream().map(new Function<CustomerRole2, String>() {
//			@Override
//			public String apply(CustomerRole2 t) {
//				return t.getId();
//			}
//		}).collect(Collectors.toList());
		final List<String> baseCustomerRoleIds = bases.stream().map(it -> it.getId()).collect(Collectors.toList());
		log.debug("Ensuring {} base CustomerRoles: {}", bases.size(), baseCustomerRoleIds);
		final Set<String> existing = exists(baseCustomerRoleIds);
		log.debug("Existing customerRoles: {}", existing);
		for (final CustomerRole2 customerRole : bases) {
			if (!existing.contains(customerRole.getId())) {
				log.debug("Adding new base customerRole: {}", customerRole);
				add(customerRole);
			} else {
				log.debug("Updating base customerRole: {}", customerRole);
				primary.update(new BasicDBObject("_id", customerRole.getId()),
						new BasicDBObject("$set", ImmutableMap.of(
								"description", customerRole.getDescription(),
								"readOnly", customerRole.isReadOnly())));
			}
		}
		log.info("Ensured {} base CustomerRoles: {}", bases.size(), baseCustomerRoleIds);
	}

	@Override
	public Page<CustomerRole2> findAll(@Nonnull StatusMask statusMask, @Nonnull Pageable pageable) {
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
		final List<CustomerRole2> customerRoles = findPrimary(query, null, sortObj, pageable.getOffset(), pageable.getPageSize(), "findAll",
				statusMask, pageable);
		if (customerRoles.isEmpty()) {
			return new PageImpl<>(ImmutableList.<CustomerRole2>of(), pageable, 0);
		} else {
			//count
			final long count = countByQuery(query);
			return new PageImpl<>(customerRoles, pageable, count);
		}
	}
	
	@Override
	public Page<CustomerRole2> findAll(@Nonnull StatusMask statusMask, @Nullable String searchText, @Nonnull Pageable pageable) {
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
		final List<CustomerRole2> customerRoles = findSecondary(query, null, sortObj, pageable.getOffset(), pageable.getPageSize(), "findAll",
				statusMask, pageable);
		if (customerRoles.isEmpty()) {
			return new PageImpl<>(ImmutableList.<CustomerRole2>of(), pageable, 0);
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
	public ImmutableSet<String> findAllCustRoleByPaymentGatewayEnabled(StatusMask statusMask) {
		final BasicDBObject query = new BasicDBObject("paymentGatewayEnabled", true);
		augmentQueryForStatusMask(query, statusMask);
		
		final List<DBObject> objs = findSecondaryAsDBObjects(query, new BasicDBObject("_id", true), null, 0, 0, "findAllIdsByPaymentGatewayEnabled", statusMask);
		return FluentIterable.from(objs).transform(new DBObjectToId()).toSet();
	}
	
	@Override
	public ImmutableSet<String> findAllCustRoleByReviewReminderEnabled(StatusMask statusMask) {
		final BasicDBObject query = new BasicDBObject("reviewReminderEnabled", true);
		augmentQueryForStatusMask(query, statusMask);
		
		final List<DBObject> objs = findSecondaryAsDBObjects(query, new BasicDBObject("_id", true), null, 0, 0, "findAllIdsByReviewReminderEnabled", statusMask);
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

	@Override @Nullable
	public Long getZendeskOrganizationId(String customerRoleId) {
		final BasicDBObject query = new BasicDBObject();
		query.put("_id", customerRoleId);
		query.put("zendeskIntegration", true);
		query.put("zendeskOrganizationId", new BasicDBObject("$exists", true));
		
		final DBObject dbObject = findOnePrimary(query, new BasicDBObject("zendeskOrganizationId", 1), "getZendeskOrganizationId", customerRoleId);
		if (dbObject != null) {
			if (dbObject.get("getZendeskOrganizationId") != null && !"null".equals(dbObject.get("getZendeskOrganizationId"))) {
				return Long.valueOf(dbObject.get("getZendeskOrganizationId").toString());
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public boolean isBookingEnabled(String customerRole) {
		Preconditions.checkState(!Strings.isNullOrEmpty(customerRole), "Customer Role must not be null or empty.");
		final BasicDBObject query = new BasicDBObject("_id", customerRole);
		final BasicDBObject fields = new BasicDBObject("bookingEnabled", true);
		final DBObject dbObj = findOnePrimary(query, fields, "isBookingEnabled", customerRole);
		log.debug("dbObj: {}", dbObj);
		if (dbObj != null && !"null".equals(dbObj)) {
			final Object bookingEnabledObj = dbObj.get("bookingEnabled");
			if (bookingEnabledObj != null && !"null".equals(bookingEnabledObj)) {
				final boolean bookingEnabled = Boolean.valueOf(String.valueOf(bookingEnabledObj)).booleanValue();
				return bookingEnabled;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	@Override @Nullable
	public String getName(String customerRoleId) {
		final BasicDBObject query = new BasicDBObject();
		query.put("_id", customerRoleId);
		
		final DBObject dbObject = findOnePrimary(query, new BasicDBObject("name", 1), "getName", customerRoleId);
		if (dbObject != null) {
			if (dbObject.get("name") != null && !"null".equals(dbObject.get("name"))) {
				return dbObject.get("name").toString();
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public boolean isBankTransferPaymentEnabled(String customerRole) {
		Preconditions.checkState(!Strings.isNullOrEmpty(customerRole), "Customer Role must not be null or empty.");
		final BasicDBObject query = new BasicDBObject("_id", customerRole);
		final BasicDBObject fields = new BasicDBObject("bankTransferPaymentEnabled", true);
		final DBObject dbObj = findOnePrimary(query, fields, "isBankTransferPaymentEnabled", customerRole);
		log.debug("dbObj: {}", dbObj);
		if (dbObj != null && !"null".equals(dbObj)) {
			final Object objBankTransferPaymentEnabled = dbObj.get("bankTransferPaymentEnabled");
			if (objBankTransferPaymentEnabled != null && !"null".equals(objBankTransferPaymentEnabled)) {
				final boolean bankTransferPaymentEnabled = Boolean.valueOf(String.valueOf(objBankTransferPaymentEnabled)).booleanValue();
				return bankTransferPaymentEnabled;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	
}
	

package org.soluvas.mongo;

import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.soluvas.commons.CustomerRole;
import org.soluvas.commons.CustomerRoleStatus;
import org.soluvas.commons.impl.CustomerRoleImpl;
import org.soluvas.data.StatusMask;
import org.soluvas.data.customerrole.CustomerRoleRepository;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.data.domain.Sort.Order;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @author rudi
 *
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
				Index.asc("status"));
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

}
	

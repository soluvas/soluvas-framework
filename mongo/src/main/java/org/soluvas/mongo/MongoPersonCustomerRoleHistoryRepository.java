package org.soluvas.mongo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Nullable;

import org.soluvas.commons.AccountStatus;
import org.soluvas.commons.PersonCustomerRoleHistory;
import org.soluvas.data.EntityLookupException;
import org.soluvas.data.Existence;
import org.soluvas.data.LookupKey;
import org.soluvas.data.StatusMask;
import org.soluvas.data.person.PersonCustomerRoleHistoryRepository;
import org.springframework.cache.CacheManager;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mongodb.BasicDBObject;

import scala.util.Try;

/**
 * MongoDB powered {@link PersonCustomerRoleHistory} repository.
 * @author ceefour
 */
public class MongoPersonCustomerRoleHistoryRepository extends MongoRepositoryBase<PersonCustomerRoleHistory> implements
		PersonCustomerRoleHistoryRepository {
	
	private final String tenantId;
	@Nullable
	private final CacheManager cacheMgr;

	public MongoPersonCustomerRoleHistoryRepository(String tenantId, @Nullable CacheManager cacheMgr, String mongoUri, boolean migrationEnabled, boolean autoExplainSlow) {
		super(PersonCustomerRoleHistory.class, PersonCustomerRoleHistory.class, 1, mongoUri, ReadPattern.DUAL, "personCustomerRoleHistory",
				ImmutableList.of("canonicalSlug"), migrationEnabled, autoExplainSlow,
				Index.asc("name"), // for sorting in list
				Index.desc("creationTime"),
				Index.desc("modificationTime"),
				Index.asc("securityRoleIds"),
				Index.asc("customerRole"),
				Index.asc("memberRole"),
				Index.asc("managerRole")
			);
		this.tenantId = tenantId;
		this.cacheMgr = cacheMgr;
	}
	
//	@Override
//	public Existence<String> existsBySlug(StatusMask statusMask, String upSlug) {
//		final BasicDBObject query = new BasicDBObject("canonicalSlug", SlugUtils.canonicalize(upSlug));
//		augmentQueryForStatusMask(query, statusMask);
//		final DBObject dbo = findDBObjectByQuery(query,
//				new BasicDBObject("slug", true));
//		if (dbo != null) {
//			final String actualSlug = (String) dbo.get("slug");
//			if (actualSlug.equals(upSlug)) {
//				return Existence.of(actualSlug, (String) dbo.get("_id"));
//			} else {
//				return Existence.mismatch(actualSlug, (String) dbo.get("_id"));
//			}
//		} else {
//			return Existence.<String>absent();
//		}
//	}
	
	
	private BasicDBObject getQueryByKeyword(String searchText) {
		final Pattern regex = Pattern.compile(Pattern.quote(searchText), Pattern.CASE_INSENSITIVE);
		
		final BasicDBObject nameQuery = new BasicDBObject("name", regex);
		final BasicDBObject idQuery = new BasicDBObject("_id", regex);
		
		final BasicDBObject query = new BasicDBObject("$or", ImmutableList.of(nameQuery, idQuery));
		log.debug("Query is {}", query);
		return query;
	}


	
	protected void augmentQueryForStatusMask(BasicDBObject query, StatusMask statusMask) {
		Preconditions.checkArgument(!query.containsField("accountStatus"),
				"Query to be augmented using StatusMask must not already have a 'status' criteria.");
		switch (statusMask) {
		case RAW:
			break;
		case ACTIVE_ONLY:
			query.put("accountStatus", new BasicDBObject("$in", 
					ImmutableSet.of(AccountStatus.ACTIVE.name(), AccountStatus.VERIFIED.name())));
			break;
		case INCLUDE_INACTIVE:
			query.put("accountStatus", new BasicDBObject("$in", 
					ImmutableSet.of(AccountStatus.ACTIVE.name(), AccountStatus.VERIFIED.name(),
							AccountStatus.INACTIVE.name())));
			break;
		case VOID_ONLY:
			query.put("accountStatus", AccountStatus.VOID.name());
			break;
		default:
			throw new IllegalArgumentException("Unrecognized StatusMask: " + statusMask);	
		}
	}

	@Override
	public PersonCustomerRoleHistory findOneBySlug(StatusMask statusMask, String upSlug) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Existence<String> existsBySlug(StatusMask statusMask, String upSlug) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends PersonCustomerRoleHistory, K extends Serializable> S lookupOne(StatusMask statusMask,
			LookupKey lookupKey, K key) throws EntityLookupException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends PersonCustomerRoleHistory, K extends Serializable> Map<K, Try<S>> lookupAll(StatusMask statusMask,
			LookupKey lookupKey, Collection<K> keys) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <K extends Serializable> Map<K, Existence<K>> checkExistsAll(StatusMask statusMask, LookupKey lookupKey,
			Collection<K> keys) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <K extends Serializable> Existence<K> checkExists(StatusMask statusMask, LookupKey lookupKey, K key) {
		// TODO Auto-generated method stub
		return null;
	}

}

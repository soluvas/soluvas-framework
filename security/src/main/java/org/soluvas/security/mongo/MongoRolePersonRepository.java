package org.soluvas.security.mongo;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Person;
import org.soluvas.data.repository.AssocRepositoryBase;
import org.soluvas.mongo.MongoRepositoryException;
import org.soluvas.mongo.MongoUtils;
import org.soluvas.security.Role;
import org.soluvas.security.RolePersonRepository;
import org.soluvas.security.SecurityException;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClientURI;
import com.mongodb.ReadPreference;
import com.mongodb.WriteResult;

/**
 * Associates {@link Role} ID with MongoDB {@link Person} IDs, this is implemented by
 * storing the tenant-scoped {@link Role} IDs inside {@link Person#getSecurityRoleIds()}.
 * @author ceefour
 * @todo App-scoped role/person assignments?
 */
public class MongoRolePersonRepository extends AssocRepositoryBase<String, String>
	implements RolePersonRepository {

	private static final Logger log = LoggerFactory
			.getLogger(MongoRolePersonRepository.class);
	
	private final String PERSON_COLL_NAME = "person";

	private DBCollection personColl;
	
	public MongoRolePersonRepository(String mongoUri) {
		super();
		// WARNING: mongoUri may contain password!
		final MongoClientURI realMongoUri = new MongoClientURI(mongoUri);
		log.info("Connecting to MongoDB role-person repository {}/{} as {}, person collection={}",
				realMongoUri.getHosts(), realMongoUri.getDatabase(), realMongoUri.getUsername(), PERSON_COLL_NAME);
		try {
			final DB db = MongoUtils.getDb(realMongoUri, ReadPreference.primary());
			personColl = db.getCollection(PERSON_COLL_NAME);
		} catch (Exception e) {
			throw new MongoRepositoryException(e, "Cannot connect to MongoDB role-person repository {}/{} as {} for collection '{}'",
					realMongoUri.getHosts(), realMongoUri.getDatabase(), realMongoUri.getUsername(),
					PERSON_COLL_NAME);
		}
	}

	@Override
	public boolean put(String roleId, String personId) {
		Preconditions.checkArgument(!Strings.isNullOrEmpty(roleId), "roleId must be specified");
		Preconditions.checkArgument(!Strings.isNullOrEmpty(personId), "personId must be specified");
		final BasicDBObject personObj = (BasicDBObject) personColl.findOne(new BasicDBObject("_id", personId));
		Preconditions.checkNotNull(personObj, "Cannot find person '%s'", personId);
		final Set<String> tenantRoleIds = personObj.get("securityRoleIds") != null ?
				new LinkedHashSet<>((List<String>) personObj.get("securityRoleIds")) : new LinkedHashSet<String>();
		final boolean added = tenantRoleIds.contains(tenantRoleIds) ? tenantRoleIds.add(roleId) : false;
		final WriteResult writeResult = personColl.update(new BasicDBObject("_id", personId), personObj);
		if (writeResult.getLastError() != null && writeResult.getLastError().getException() != null) {
			throw new SecurityException("Cannot update person '" + personId + "'", writeResult.getLastError().getException());
		}
		if (added) {
			log.info("Assigned tenant role {} to person {}. Current tenant roles: {}", roleId, personId, tenantRoleIds);
		} else {
			log.debug("Tenant role {} not added to person {}. Current tenant roles: {}", roleId, personId, tenantRoleIds);
		}
		return added;
	}

	@Override
	public boolean delete(String roleId, String personId) {
		final BasicDBObject personObj = (BasicDBObject) personColl.findOne(new BasicDBObject("_id", personId));
		if (personObj != null) {
			final Set<String> tenantRoleIds = personObj.get("securityRoleIds") != null ?
					new LinkedHashSet<>((List<String>) personObj.get("securityRoleIds")) : new LinkedHashSet<String>();
			if (tenantRoleIds != null) {
				final boolean removed = tenantRoleIds.remove(roleId);
				final WriteResult writeResult = personColl.update(new BasicDBObject("_id", personId), personObj);
				if (writeResult.getLastError() != null && writeResult.getLastError().getException() != null) {
					throw new SecurityException("Cannot update person '" + personId + "'", writeResult.getLastError().getException());
				}
				if (removed) {
					log.info("Unassigned tenant role {} from person {}. Current tenant roles: {}", roleId, personId, tenantRoleIds);
				} else {
					log.debug("Tenant role didn't exist {} in person {}. Current tenant roles: {}", roleId, personId, tenantRoleIds);
				}
				return true;
			} else {
				log.debug("Person '{}' has no roles, cannot delete", personId);
				return false;
			}
		} else {
			log.info("Person '{}' not found", personId);
			return false;
		}
	}

	@Override
	public Multimap<String, String> findAll() {
		final BasicDBObject query = new BasicDBObject("securityRoleIds", new BasicDBObject("$exists", true));
		final ImmutableMultimap.Builder<String, String> allb = ImmutableMultimap.builder();
		try (final DBCursor cursor = personColl.find(query, new BasicDBObject("securityRoleIds", 1))
				.sort(new BasicDBObject("_id", 1))) {
			for (final DBObject personObj : cursor) {
				final Set<String> tenantRoleIds = personObj.get("securityRoleIds") != null ?
						new LinkedHashSet<>((List<String>) personObj.get("securityRoleIds")) : new LinkedHashSet<String>();
				if (tenantRoleIds != null) {
					final String personId = (String) personObj.get("_id");
					for (final String roleId : tenantRoleIds) {
						allb.put(roleId, personId);
					}
				}
			}
		}
		return allb.build();
	}

	@Override
	public List<String> getLeft(String roleId) {
		try (final DBCursor personIdCur = personColl.find(new BasicDBObject("securityRoleIds", roleId))) {
			final ImmutableList<String> personIds = FluentIterable.from(personIdCur)
					.transform(new Function<DBObject, String>() {
				@Override @Nullable
				public String apply(@Nullable DBObject input) {
					return (String) input.get("_id");
				}
			}).toList();
			log.trace("Role owned by {} people: {}", roleId, personIds.size(), Iterables.limit(personIds, 10));
			return personIds;
		}
	}

	@Override
	public List<String> getRight(String personId) {
		final BasicDBObject personObj = (BasicDBObject) personColl.findOne(new BasicDBObject("_id", personId));
		final Set<String> tenantRoleIds = personObj.get("securityRoleIds") != null ?
				new LinkedHashSet<>((List<String>) personObj.get("securityRoleIds")) : new LinkedHashSet<String>();
		if (!tenantRoleIds.isEmpty()) {
			final ImmutableList<String> roleSet = ImmutableList.copyOf(tenantRoleIds);
			log.trace("PersonID {} has {} roles: {}", personObj.get("_id"), roleSet.size(), roleSet);
			return roleSet;
		} else {
			log.trace("PersonID {} has no roles or not found", personId);
			return ImmutableList.of();
		}
	}
	
}

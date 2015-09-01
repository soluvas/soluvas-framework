package org.soluvas.category;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.soluvas.commons.AccountStatus;
import org.soluvas.commons.EnumNameFunction;
import org.soluvas.data.EntityLookupException;
import org.soluvas.data.Existence;
import org.soluvas.data.StatusMask;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
import org.soluvas.mongo.Index;
import org.soluvas.mongo.MongoRepositoryBase;

import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @author rudi
 *
 */
public class MongoCategoryRepositoryImpl extends MongoRepositoryBase<Category2> implements MongoCategoryRepository {

	public MongoCategoryRepositoryImpl(String mongoUri, boolean migrationEnabled, boolean autoExplainSlow) {
		super(Category2.class, Category2.class, Category2.CURRENT_SCHEMA_VERSION, mongoUri, ReadPattern.DUAL,
				"category", migrationEnabled, autoExplainSlow,
				Index.asc("name"),
				Index.asc("status"),
				Index.asc("level"),
				Index.asc("slug"),
				Index.asc("slugPath"),
				Index.asc("parentId"),
				Index.uniqueAsc("slug"),
				Index.uniqueAsc("slugPath"));
	}

	@Override
	public Page<Category2> findAllByStatus(Collection<CategoryStatus> statuses, Pageable pageable) {
		final BasicDBObject query = new BasicDBObject();
		query.put("status", new BasicDBObject("$in", FluentIterable.from(statuses).transform(new EnumNameFunction()).toList()));
		return findAllByQuery(query, pageable);
	}

	@Override
	public Category2 findOneBySlugPath(String slugPath, Collection<CategoryStatus> statuses) {
		final BasicDBObject query = new BasicDBObject();
		query.put("slugPath", slugPath);
		query.put("status", new BasicDBObject("$in", FluentIterable.from(statuses).transform(new EnumNameFunction()).toList()));
		return findOneByQuery(query);
	}

	@Override
	public Category2 lookupOneByUri(Set<CategoryStatus> statuses, String uri) throws EntityLookupException {
		final BasicDBObject query = new BasicDBObject();
		query.put("$or", ImmutableMap.of("primaryUri", uri, "sameAsUris", uri));
		query.put("status", new BasicDBObject("$in", FluentIterable.from(statuses).transform(new EnumNameFunction()).toList()));
		return findOneByQuery(query);
	}

	@Override
	public Page<Category2> findAllByLevelAndStatus(Collection<CategoryStatus> statuses, int level, Pageable pageable) {
		final BasicDBObject query = new BasicDBObject();
		query.put("status", new BasicDBObject("$in", FluentIterable.from(statuses).transform(new EnumNameFunction()).toList()));
		query.put("level", level);
		final Page<Category2> result = findAllByQuery(query, pageable);
		log.debug("Got {} categories by status '{}' and level '{}'", result.getContent().size(), statuses, level);
		return result;
	}
	
	@Override
	public Page<Category2> findAllByLevelAndStatus(Collection<CategoryStatus> statuses, int level, String parentId, Pageable pageable) {
		final BasicDBObject query = new BasicDBObject();
		query.put("status", new BasicDBObject("$in", FluentIterable.from(statuses).transform(new EnumNameFunction()).toList()));
		query.put("level", level);
		query.put("parentId", parentId);
		return findAllByQuery(query, pageable);
	}

	@Override
	public Existence<String> existsBySlugPath(StatusMask statusMask, String upSlugPath) {
		final BasicDBObject query = new BasicDBObject();
		query.put("slugPath", upSlugPath);
		augmentQueryForStatusMask(query, statusMask);
		final Category2 found = findOneByQuery(query);
		if (found != null) {
			return Existence.of(found.getSlugPath(), upSlugPath);
		} else {
			return Existence.absent();
		}
	}
	
	protected void augmentQueryForStatusMask(BasicDBObject query, StatusMask statusMask) {
		Preconditions.checkArgument(!query.containsField("accountStatus"),
				"Query to be augmented using StatusMask must not already have a 'status' criteria.");
		switch (statusMask) {
		case RAW:
			break;
		case ACTIVE_ONLY:
			query.put("status", new BasicDBObject("$in", 
					ImmutableSet.of(CategoryStatus.ACTIVE.name())));
			break;
		case INCLUDE_INACTIVE:
			query.put("status", new BasicDBObject("$in", 
					ImmutableSet.of(AccountStatus.ACTIVE.name(), AccountStatus.INACTIVE.name())));
			break;
		case VOID_ONLY:
			query.put("status", AccountStatus.VOID.name());
			break;
		default:
			throw new IllegalArgumentException("Unrecognized StatusMask: " + statusMask);	
		}
	}

	@Override
	public Set<String> findAllSlugPathsByStatus(Collection<CategoryStatus> statuses) {
		final BasicDBObject query = new BasicDBObject("status", new BasicDBObject("$in", FluentIterable.from(statuses).transform(new EnumNameFunction()).toList()));
		final BasicDBObject fields = new BasicDBObject("slugPath", true);
		final List<DBObject> dbObjects = findSecondaryAsDBObjects(query, fields, null, 0, 500, "findAllSlugPathsByStatus", statuses);
		if (dbObjects == null || dbObjects.isEmpty()) {
			return ImmutableSet.of();
		} 
		final Builder<String> builder = ImmutableSet.builder();
		for (final DBObject dbObject : dbObjects) {
			builder.add(String.valueOf(dbObject.get("slugPath")));
		}
		return builder.build();
	}

	@Override
	public Page<Category2> findAllLeavesByStatus(Collection<CategoryStatus> statuses, Pageable pageable) {
		final BasicDBObject query = new BasicDBObject();
		query.put("status", new BasicDBObject("$in", FluentIterable.from(statuses).transform(new EnumNameFunction()).toList()));
		query.put("categories", new BasicDBObject("$exists", false));
		return findAllByQuery(query, pageable);
	}

	@Override
	public Page<Category2> findAll(String searchText, Collection<CategoryStatus> statuses, Pageable pageable) {
		final BasicDBObject query = new BasicDBObject();
		query.put("status", new BasicDBObject("$in", FluentIterable.from(statuses).transform(new EnumNameFunction()).toList()));
		
		final String quotedSearchText = Pattern.quote(searchText);
		final Pattern pattern = Pattern.compile(".*" + quotedSearchText + ".*", Pattern.CASE_INSENSITIVE);
		query.put("name", pattern);
		
		return findAllByQuery(query, pageable);
	}

	@Override
	public Category2 getFirstActive() {
		final BasicDBObject query = new BasicDBObject();
		augmentQueryForStatusMask(query, StatusMask.ACTIVE_ONLY);
		return findOneByQuery(query);
	}

		
}

package org.soluvas.mongo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Identifiable;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.repository.PagingAndSortingRepositoryBase;

import com.google.code.morphia.Morphia;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.WriteResult;

/**
 * @author adri
 *
 */
@ParametersAreNonnullByDefault
public class MongoRepositoryBase<T extends Identifiable> extends PagingAndSortingRepositoryBase<T, String> {

	public class DBObjectToEntity implements Function<DBObject, T> {
		@Override
		public T apply(DBObject input) {
			if (input == null)
				return null;
			try {
				return morphia.fromDBObject(entityClass, input);
			} catch (Exception e) {
				throw new MongoRepositoryException(e,
						"Cannot deserialize MongoDB object to {}: {}",
								entityClass.getName(), input);
			}
		}
	}

	private class EntityToDBObject implements Function<T, DBObject> {
		@Override @Nullable
		public DBObject apply(@Nullable T entity) {
			return morphia.toDBObject(entity);
		}
	}

	protected final Logger log = LoggerFactory.getLogger(getClass());
	private DBCollection coll;
	private Morphia morphia;
	/**
	 * Slow query threshold in milliseconds.
	 */
	private static final long LONG_QUERY_THRESHOLD = 500;
	private MongoClient mongoClient;
	private final String collName;
	private final Class<T> entityClass;
	
	/**
	 * 
	 */
	public MongoRepositoryBase(Class<T> entityClass, String mongoUri, String collName, String[] indexedFields) {
		super();
		this.entityClass = entityClass;
		this.collName = collName;
		// WARNING: mongoUri may contain password!
		final MongoClientURI realMongoUri = new MongoClientURI(mongoUri);
		log.info("Connecting to MongoDB database {}/{} as {} for {}",
				realMongoUri.getHosts(), realMongoUri.getDatabase(), realMongoUri.getUsername(), collName);
		try {
			mongoClient = new MongoClient(realMongoUri);
			final DB db = mongoClient.getDB(realMongoUri.getDatabase());
			if (realMongoUri.getUsername() != null)
				db.authenticate(realMongoUri.getUsername(),
						realMongoUri.getPassword());
			coll = db.getCollection(collName);
			log.debug("Ensuring {} indexes on {}: {}", indexedFields.length, collName);
			for (String field : indexedFields) {
				coll.ensureIndex(new BasicDBObject(field, 1));
			}

			morphia = new Morphia();
		} catch (Exception e) {
			throw new MongoRepositoryException(e, "Cannot connect to MongoDB {}/{} as {} for {} repository",
					realMongoUri.getHosts(), realMongoUri.getDatabase(), realMongoUri.getUsername(),
					collName);
		}
		
	}

	@PreDestroy
	public final void destroy() {
		log.info("Shutting down {} MongoDB repository", collName);
		mongoClient.close();
	}

	@Override
	public final Page<T> findAll(Pageable pageable) {
		final BasicDBObject query = new BasicDBObject();
		final long total = coll.count(query);
		final BasicDBObject sortQuery = MongoUtils.getSort(pageable.getSort(), "modificationTime", -1);
		final DBCursor cursor = coll.find(query)
				.sort(sortQuery)
				.skip((int) pageable.getOffset())
				.limit((int) pageable.getPageSize());
		final List<T> physicalInventories = MongoUtils
				.transform(cursor, new DBObjectToEntity());
		return new PageImpl<>(physicalInventories, pageable, total);
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.BasicRepository#count()
	 */
	@Override
	public final long count() {
		return coll.count();
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.CrudRepositoryBase#getId(java.lang.Object)
	 */
	@Override @Nullable
	protected final String getId(T entity) {
		return entity.getId();
	}

	@Override
	public <S extends T> Collection<S> add(Collection<S> entities) {
		beforeSave(entities);
		final List<String> ids = ImmutableList.copyOf(Collections2.transform(entities, new IdFunction()));
		log.debug("Adding {} {} documents: {}", entities.size(), collName, ids);
		final List<DBObject> dbObjs = ImmutableList.copyOf(Collections2.transform(entities, new EntityToDBObject()));
		final WriteResult writeResult = coll.insert(dbObjs);
		if (writeResult.getLastError() != null && writeResult.getLastError().getException() != null) {
			throw new MongoRepositoryException(writeResult.getLastError().getException(),
					"Cannot add %d %s documents: %s", entities.size(), collName, ids);
		}
		log.info("Added {} {} documents: {}", entities.size(), collName, ids);
		return ImmutableList.copyOf(entities);
	}
	
	/**
	 * Override this method to perform additional operations before adding/modifying an entity.
	 * e.g. setModificationTime
	 * @param entity
	 */
	protected void beforeSave(T entity) {
	}

	protected final void beforeSave(Collection<? extends T> entities) {
		for (T entity : entities) {
			beforeSave(entity);
		}
	}

	@Override
	public <S extends T> Collection<S> modify(Map<String, S> entities) {
		log.debug("Modifying {} {} documents: {}", entities.size(), collName, entities.keySet());
		final List<S> modifieds = new ArrayList<>();
		for (final Entry<String, S> entry : entities.entrySet()) {
			final S entity = entry.getValue();
			beforeSave(entity);
			final DBObject dbo = new EntityToDBObject().apply(entity);
			final WriteResult writeResult = coll.update(new BasicDBObject("_id", entry.getKey()), dbo);
			if (writeResult.getLastError() != null && writeResult.getLastError().getException() != null) {
				throw new MongoRepositoryException(writeResult.getLastError().getException(),
						"Cannot modify %d %s documents: %s", entities.size(), collName, entities.keySet());
			}
			modifieds.add(entity);
		}
		log.info("Modified {} {} documents: {}", entities.size(), collName, entities.keySet());
		return modifieds;
	}

	@Override
	public final Set<String> exists(Collection<String> ids) {
		log.debug("Checking existence of {} {}: {}", ids.size(), collName, ids);
		try (final DBCursor cursor = coll.find(new BasicDBObject("_id", new BasicDBObject("$in", ids)), new BasicDBObject())) {
			final Set<String> existed = ImmutableSet.copyOf(Iterables.transform(cursor, new Function<DBObject, String>() {
				@Override @Nullable
				public String apply(@Nullable DBObject input) {
					return (String) input.get("_id");
				}
			}));
			log.info("Found {} out of {} existing {}: {}, checked: {}",
					existed.size(), ids.size(), collName, existed, ids);
			return existed;
		} 
	}

	@Override
	public final List<T> findAll(Collection<String> ids) {
		log.trace("finding {} {}: {}", ids.size(), collName, ids);
		final List<T> entities = MongoUtils.transform(coll.find(new BasicDBObject("_id", new BasicDBObject("$in", ids))),
				new DBObjectToEntity());
		log.debug("find {} {} ({}) returned {} documents", 
				ids.size(), collName, ids, entities.size());  
		return entities;
	}

	@Override
	public final long deleteIds(Collection<String> ids) {
		log.debug("Deleting {} {}: {}", ids.size(), collName, ids);
		final WriteResult result = coll.remove(new BasicDBObject("_id", new BasicDBObject("$in", ids)));
		if (result.getLastError().getException() != null) {
			throw new MongoRepositoryException(result.getLastError().getException(),
					"Cannot delete %s %s", collName, ids);
		}
		log.info("Deleted {} out of {} {} ({})", result.getN(), ids.size(), collName, ids);
		return result.getN();
	}

	@Override
	public final Page<String> findAllIds(Pageable pageable) {
		final BasicDBObject query = new BasicDBObject();
		final long total = coll.count(query);
		final BasicDBObject sortQuery = MongoUtils.getSort(pageable.getSort(), "_id", 1);
		final DBCursor cursor = coll.find(query)
				.sort(sortQuery)
				.skip((int) pageable.getOffset())
				.limit((int) pageable.getPageSize());
		final List<String> entityIds = MongoUtils
				.transform(cursor, new Function<DBObject, String>() {
					@Override @Nullable
					public String apply(@Nullable DBObject input) {
						return (String) input.get("_id");
					}
				});
		return new PageImpl<>(entityIds, pageable, total);
	}
	
}

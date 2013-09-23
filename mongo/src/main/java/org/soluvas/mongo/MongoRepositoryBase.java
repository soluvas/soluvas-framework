package org.soluvas.mongo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Nullable;
import javax.annotation.PreDestroy;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Email;
import org.soluvas.commons.Identifiable;
import org.soluvas.commons.SchemaVersionable;
import org.soluvas.commons.Timestamped;
import org.soluvas.commons.impl.EmailImpl;
import org.soluvas.commons.impl.PersonImpl;
import org.soluvas.commons.util.Profiled;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.repository.PagingAndSortingRepository;
import org.soluvas.data.repository.PagingAndSortingRepositoryBase;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.mapping.DefaultCreator;
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
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.WriteResult;

/**
 * {@link PagingAndSortingRepository} implemented using MongoDB, with {@link SchemaVersionable} support.
 * <p>{@link SchemaVersionable#getSchemaVersion()} is <b>not</b> used for filtering documents,
 * because this will complicate structure of indexes and ad-hoc queries. The recommended approach
 * for schema migration with UUID as IDs, and no formalId/slug, is:
 * <ol>
 * 	<li>Rename the current collection to "old" collection.</li>
 * 	<li>Create the 'new' collection, so it's usable immediately, albeit empty.</li> 
 * 	<li>Move all current documents from 'old' collection to 'new' collection.</li> 
 * 	<li>Migrate old documents from 'old' collection to 'new' collection.</li> 
 * 	<li>Delete 'old' collection</li>
 * </ol>
 * <p>For entities with formalId/slug/non-UUID IDs, use in-place migration. However
 * the application should handle occasional errors due to schema mismatch. 
 * @author ceefour
 */
public class MongoRepositoryBase<T extends Identifiable> extends PagingAndSortingRepositoryBase<T, String>
	implements MongoRepository<T> {
	
	public class DBObjectToEntity implements Function<DBObject, T> {
		@Override
		public T apply(DBObject input) {
			if (input == null)
				return null;
			try {
				return morphia.fromDBObject(implClass, input);
			} catch (Exception e) {
				throw new MongoRepositoryException(e,
						"Cannot deserialize MongoDB object to %s: %s",
								entityClass.getName(), input);
			}
		}
	}

	public class EntityToDBObject implements Function<T, DBObject> {
		@Override @Nullable
		public DBObject apply(@Nullable T entity) {
			return morphia.toDBObject(entity);
		}
	}

	public static final String SCHEMA_VERSION_FIELD = "schemaVersion";
	protected final Logger log;
	protected DBCollection coll;
	protected Morphia morphia;
	/**
	 * Slow query threshold in milliseconds.
	 */
	protected static final long LONG_QUERY_THRESHOLD = 500;
	/**
	 * Usually used by {@link #beforeSave(Identifiable)} to set creationTime and modificationTime
	 * based on default time zone.
	 * TODO: Should use user's time zone (i.e. audit system).  
	 */
	protected static final DateTimeZone timeZone = DateTimeZone.forID("Asia/Jakarta");
	protected final String collName;
	private final Class<T> entityClass;
	private final Class<? extends T> implClass;
	protected long currentSchemaVersion;
	protected final String mongoUri;

	/**
	 * @param intfClass
	 * @param currentSchemaVersion e.g. {@link PersonImpl#CURRENT_SCHEMA_VERSION}.
	 * @param mongoUri
	 * @param collName
	 * @param indexedFields
	 */
	public MongoRepositoryBase(Class<T> intfClass, Class<? extends T> implClass, long currentSchemaVersion, 
			String mongoUri, String collName, List<String> uniqueFields, Map<String, Integer> indexedFields) {
		super();
		this.entityClass = intfClass;
		this.implClass = implClass;
		this.currentSchemaVersion = currentSchemaVersion;
		this.mongoUri = mongoUri;
		this.collName = collName;
		// WARNING: mongoUri may contain password!
		final MongoClientURI realMongoUri = new MongoClientURI(mongoUri);
		this.log = LoggerFactory.getLogger(getClass().getName() + "/" + realMongoUri.getDatabase() + "/" + collName + "/" + currentSchemaVersion);
		log.info("Connecting to MongoDB database {}/{} as {} for {}",
				realMongoUri.getHosts(), realMongoUri.getDatabase(), realMongoUri.getUsername(), collName);
		try {
			final DB db = MongoUtils.getDb(realMongoUri);
			if (realMongoUri.getUsername() != null)
				db.authenticate(realMongoUri.getUsername(),
						realMongoUri.getPassword());
			coll = db.getCollection(collName);
			morphia = new Morphia();
			morphia.map(implClass);
			morphia.getMapper().getOptions().objectFactory = new DefaultCreator() {
				@Override
				public Object createInstance(Class clazz, DBObject dbObj) {
					// TODO: Do not hardcode
					if (clazz == Email.class) {
						return new EmailImpl();
					}
					return super.createInstance(clazz, dbObj);
				}
			};
		} catch (Exception e) {
			throw new MongoRepositoryException(e, "Cannot connect to MongoDB %s/%s as %s for %s repository",
					realMongoUri.getHosts(), realMongoUri.getDatabase(), realMongoUri.getUsername(),
					collName);
		}
		beforeEnsureIndexes();
		final List<String> ensuredIndexes = new ArrayList<>();
		ensuredIndexes.addAll( MongoUtils.ensureUnique(coll, uniqueFields.toArray(new String[] {})) );
		ensuredIndexes.addAll( MongoUtils.ensureIndexes(coll, indexedFields) );
		MongoUtils.retainIndexes(coll, ensuredIndexes.toArray(new String[] {}));
	}

	@Deprecated
	public MongoRepositoryBase(Class<T> entityClass, String mongoUri, String collName, String[] indexedFields) {
		super();
		this.entityClass = entityClass;
		this.implClass = entityClass;
		this.currentSchemaVersion = 1L;
		this.mongoUri = mongoUri;
		this.collName = collName;
		// WARNING: mongoUri may contain password!
		final MongoClientURI realMongoUri = new MongoClientURI(mongoUri);
		this.log = LoggerFactory.getLogger(getClass().getName() + "/" + realMongoUri.getDatabase() + "/" + collName);
		log.info("Connecting to MongoDB database {}/{} as {} for {}",
				realMongoUri.getHosts(), realMongoUri.getDatabase(), realMongoUri.getUsername(), collName);
		try {
			final DB db = MongoUtils.getDb(realMongoUri);
			if (realMongoUri.getUsername() != null)
				db.authenticate(realMongoUri.getUsername(),
						realMongoUri.getPassword());
			coll = db.getCollection(collName);
			morphia = new Morphia();
		} catch (Exception e) {
			throw new MongoRepositoryException(e, "Cannot connect to MongoDB %s/%s as %s for %s repository",
					realMongoUri.getHosts(), realMongoUri.getDatabase(), realMongoUri.getUsername(),
					collName);
		}
		beforeEnsureIndexes();
		log.debug("Ensuring {} indexes on {}: {}", indexedFields.length, collName, indexedFields);
		for (String field : indexedFields) {
			coll.ensureIndex(new BasicDBObject(field, 1));
		}
	}
	
	/**
	 * Called by constructor after connection and authentication but 
	 * before calling {@link MongoUtils#ensureUnique(DBCollection, String...)} and {@link MongoUtils#ensureIndexes(DBCollection, Map)}.
	 * Useful if you want to migrate data or reslug.
	 */
	protected void beforeEnsureIndexes() {
	}

	@PreDestroy
	public final void destroy() {
		log.info("Shutting down {} MongoDB repository", collName);
		// DO NOT CALL THIS: mongoClient.close();
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

	/**
	 * @see org.soluvas.data.repository.PagingAndSortingRepositoryBase#add(java.util.Collection)
	 * @throws MongoException
	 * @throws MongoException.DuplicateKey
	 */
	@Override
	public <S extends T> Collection<S> add(Collection<S> entities) {
		beforeSave(entities);
		final List<String> ids = ImmutableList.copyOf(Collections2.transform(entities, new IdFunction()));
		log.debug("Adding {} {} documents: {}", entities.size(), collName, ids);
		try (Profiled p = new Profiled(log, "Added " + entities.size() + " " + collName + " documents: " + ids)) {
			final List<DBObject> dbObjs = ImmutableList.copyOf(Collections2
					.transform(entities, new EntityToDBObject()));
			final WriteResult writeResult = coll.insert(dbObjs);
			if (writeResult.getLastError() != null
					&& writeResult.getLastError().getException() != null) {
				throw new MongoRepositoryException(writeResult.getLastError()
						.getException(), "Cannot add %d %s documents: %s",
						entities.size(), collName, ids);
			}
			log.info("Added {} {} documents: {}", entities.size(), collName,
					ids);
			return ImmutableList.copyOf(entities);
		} catch (IOException e) {
			throw new MongoRepositoryException(e, "Cannot add %s %s documents: %s", entities.size(), collName, ids);
		}
	}
	
	/**
	 * Override this method to perform additional operations before adding/modifying an entity.
	 * setCreationTime and setModificationTime is already handled if entity implements
	 * {@link Timestamped}.
	 * @param entity
	 */
	protected void beforeSave(T entity) {
		if (entity instanceof Timestamped) {
			final Timestamped timestamped = (Timestamped) entity;
			if (timestamped.getCreationTime() == null) {
				timestamped.setCreationTime(new DateTime(timeZone));
			}
			timestamped.setModificationTime(new DateTime(timeZone));
		}
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
	public final List<T> findAll(Collection<String> ids, Sort sort) {
		final BasicDBObject sortQuery = MongoUtils.getSort(sort, "_id", 1);
		log.trace("finding {} {} sort by {}: {}", ids.size(), collName, sort, Iterables.limit(ids, 10));
		final List<T> entities = MongoUtils.transform(
				coll.find(new BasicDBObject("_id", new BasicDBObject("$in", ids))).sort(sortQuery),
				new DBObjectToEntity());
		if (ids.size() > 1 || ids.size() != entities.size()) {
			log.debug("find {} {} by _id ({}) returned {} documents", 
					ids.size(), collName, Iterables.limit(ids, 10), entities.size());  
		} else {
			log.trace("find {} by _id '{}' returned {} documents", 
					collName, Iterables.getFirst(ids, null), entities.size());
		}
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
	
	@Override
	public long countByQuery(DBObject query) {
		final long total = coll.count(query);
		log.debug("Got count {} by query {}", total, query);
		return total;
	}
	
	@Override
	public Page<T> findAllByQuery(DBObject query, Pageable pageable) {
		final BasicDBObject sortQuery = MongoUtils.getSort(pageable.getSort(), "modificationTime", -1);
		log.debug("findAllByQuery {} {} sort {} skip {} limit {}",
				collName, query, sortQuery, pageable.getOffset(), pageable.getPageSize());
		final long total = coll.count(query);
		final DBCursor cursor = coll.find(query)
				.sort(sortQuery)
				.skip((int) pageable.getOffset())
				.limit((int) pageable.getPageSize());
		final List<T> entities = MongoUtils
				.transform(cursor, new DBObjectToEntity());
		log.info("findAllByQuery {} {} returned {} out of {} documents, sort {} skip {} limit {}",
				collName, query, entities.size(), total, sortQuery, pageable.getOffset(), pageable.getPageSize());
		return new PageImpl<>(entities, pageable, total);		
	}

	protected DBObject findDBObjectByQuery(DBObject query, DBObject fields) {
		log.trace("findOneByQuery {} {}", collName, query, fields);
		final DBObject dbo = coll.findOne(query, fields);
		log.debug("findAllByQuery {} {} {} returned {}",
				collName, query, fields, dbo != null ? dbo.get("_id") : null);
		return dbo;
	}

	@Override
	public T findOneByQuery(DBObject upQuery) {
		final DBObject dbo = findDBObjectByQuery(upQuery, null);
		final T entity = new DBObjectToEntity().apply(dbo);
		return entity;		
	}

}

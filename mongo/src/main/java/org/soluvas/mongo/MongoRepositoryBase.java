package org.soluvas.mongo;

import java.io.Closeable;
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
import org.soluvas.data.DataException;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.data.repository.CrudRepository;
import org.soluvas.data.repository.PagingAndSortingRepository;
import org.soluvas.data.repository.PagingAndSortingRepositoryBase;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.mapping.DefaultCreator;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable;
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
import com.mongodb.MongoException;
import com.mongodb.ReadPreference;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

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
	
	/**
	 * Closure used by {@link MongoRepositoryBase#findPrimary(DBObject, DBObject, String, Object[], CursorFunction)}
	 * and {@link MongoRepositoryBase#findSecondary(DBObject, DBObject, String, Object[], CursorFunction)}
	 * to process {@link DBCursor}.
	 * @author rudi
	 *
	 * @param <R>
	 */
	protected static interface CursorFunction<R> {
		/**
		 * @param cursor This cursor will be {@link Closeable#close()}d by {@link MongoRepositoryBase}.
		 * @return
		 * @throws Exception
		 */
		R apply(DBCursor cursor) throws Exception;
	}
	
	/**
	 * Determines which {@link MongoClient}s will be used by this repository.
	 * @author ceefour
	 */
	protected static enum ReadPattern {
		/**
		 * Only use a {@link MongoClient} with {@link ReadPreference#primaryPreferred()}.
		 * This is seldom used, and has better data consistency.
		 * But if you use this, you probably want to use an ACID database (such as RDBMS or Neo4j) instead of MongoDB.
		 * Both {@link MongoRepositoryBase#primary} and {@link MongoRepositoryBase#secondary} use this {@link MongoClient}.
		 */
		PRIMARY_PREFERRED,
		/**
		 * Only use a {@link MongoClient} with {@link ReadPreference#secondaryPreferred()}.
		 * Used for some repositories that does not need consistency even for {@link CrudRepository#findOne(java.io.Serializable)}.
		 * Both {@link MongoRepositoryBase#primary} and {@link MongoRepositoryBase#secondary} use this {@link MongoClient}.
		 */
		SECONDARY_PREFERRED,
		/**
		 * <ul>
		 * 	<li>{@link MongoRepositoryBase#primary} uses a {@link MongoClient} with {@link ReadPreference#primaryPreferred()},
		 * 		which is especially used by {@link CrudRepository#findOne(java.io.Serializable)}.</li>
		 * 	<li>{@link MongoRepositoryBase#secondary} uses a {@link MongoClient} with {@link ReadPreference#secondaryPreferred()}</li>
		 * </ol>
		 * Typically used for most repositories.
		 */
		DUAL
	}

	public static final String SCHEMA_VERSION_FIELD = "schemaVersion";
	protected final Logger log;
	/**
	 * Please use the {@code protected} {@link MongoRepositoryBase} methods.
	 */
	@Deprecated
	protected final DBCollection primary;
	/**
	 * Please use the {@code protected} {@link MongoRepositoryBase} methods.
	 */
	@Deprecated
	protected final DBCollection secondary;
	protected Morphia morphia;
	/**
	 * Slow query threshold in milliseconds.
	 */
	protected static final long SLOW_QUERY_THRESHOLD = 500;
	/**
	 * Usually used by {@link #beforeSave(Identifiable)} to set creationTime and modificationTime
	 * based on default time zone.
	 * TODO: Should use user's time zone (i.e. audit system).  
	 */
	protected static final DateTimeZone timeZone = DateTimeZone.forID("Asia/Jakarta");
	protected final String collName;
	protected final Class<T> entityClass;
	protected final Class<? extends T> implClass;
	protected long currentSchemaVersion;
	protected final String mongoUri;
	protected final boolean migrationEnabled;
	protected final boolean autoExplainSlow;

	/**
	 * @param intfClass
	 * @param currentSchemaVersion e.g. {@link PersonImpl#CURRENT_SCHEMA_VERSION}.
	 * @param mongoUri
	 * @param collName
	 * @param indexedFields
	 */
	public MongoRepositoryBase(Class<T> intfClass, Class<? extends T> implClass, long currentSchemaVersion, 
			String mongoUri, ReadPattern readPattern, String collName, List<String> uniqueFields, boolean migrationEnabled, boolean autoExplainSlow,
			Index... indexes) {
		super();
		this.entityClass = intfClass;
		this.implClass = implClass;
		this.currentSchemaVersion = currentSchemaVersion;
		this.mongoUri = mongoUri;
		this.collName = collName;
		this.migrationEnabled = migrationEnabled;
		this.autoExplainSlow = autoExplainSlow;
		// WARNING: mongoUri may contain password!
		final MongoClientURI realMongoUri = new MongoClientURI(mongoUri);
		this.log = LoggerFactory.getLogger(getClass().getName() + "/" + realMongoUri.getDatabase() + "/" + collName + "/" + currentSchemaVersion);
		log.info("Connecting to MongoDB database {}/{} {} as {} for {}",
				realMongoUri.getHosts(), realMongoUri.getDatabase(), readPattern, realMongoUri.getUsername(), collName);
		try {
			switch (readPattern) {
			case PRIMARY_PREFERRED:
				final DB ppDb = MongoUtils.getDb(realMongoUri, ReadPreference.primaryPreferred());
				Preconditions.checkState(ppDb.getMongo().getReadPreference() == ReadPreference.primaryPreferred(),
						"Expected ReadPreference '%s' but got '%s' for Mongo ppDb %s",
						ppDb.getMongo(), ppDb.getMongo().getReadPreference());
				if (realMongoUri.getUsername() != null) {
					ppDb.authenticate(realMongoUri.getUsername(), realMongoUri.getPassword());
				}
				primary = ppDb.getCollection(collName);
				secondary = primary;
				break;
			case SECONDARY_PREFERRED:
				final DB spDb = MongoUtils.getDb(realMongoUri, ReadPreference.secondaryPreferred());
				Preconditions.checkState(spDb.getMongo().getReadPreference() == ReadPreference.secondaryPreferred(),
						"Expected ReadPreference '%s' but got '%s' for Mongo spDb %s",
						ReadPreference.primaryPreferred(), ReadPreference.secondaryPreferred(), spDb.getMongo(), spDb.getMongo().getReadPreference());
				if (realMongoUri.getUsername() != null) {
					spDb.authenticate(realMongoUri.getUsername(), realMongoUri.getPassword());
				}
				secondary = spDb.getCollection(collName);
				primary = secondary;
				break;
			case DUAL:
				final DB primaryDb = MongoUtils.getDb(realMongoUri, ReadPreference.primaryPreferred());
				Preconditions.checkState(primaryDb.getMongo().getReadPreference() == ReadPreference.primaryPreferred(),
						"Expected ReadPreference '%s' but got '%s' for Mongo primaryDb %s",
						ReadPreference.primaryPreferred(), primaryDb.getMongo().getReadPreference(), primaryDb.getMongo());
				if (realMongoUri.getUsername() != null) {
					primaryDb.authenticate(realMongoUri.getUsername(), realMongoUri.getPassword());
				}
				primary = primaryDb.getCollection(collName);
				final DB secondaryDb = MongoUtils.getDb(realMongoUri, ReadPreference.secondaryPreferred());
				Preconditions.checkState(secondaryDb.getMongo().getReadPreference() == ReadPreference.secondaryPreferred(),
						"Expected ReadPreference '%s' but got '%s' for Mongo secondaryDb %s",
						ReadPreference.secondaryPreferred(), secondaryDb.getMongo(), secondaryDb.getMongo().getReadPreference());
				if (realMongoUri.getUsername() != null) {
					secondaryDb.authenticate(realMongoUri.getUsername(), realMongoUri.getPassword());
				}
				secondary = secondaryDb.getCollection(collName);
				break;
			default:
				throw new MongoRepositoryException("Unknown readPattern: " + readPattern);
			}
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
		if (migrationEnabled) {
			log.info("Migrating collection {}...", collName);
			beforeEnsureIndexes();
		} else {
			log.info("Migration disabled for collection {}", collName);
		}
		final List<String> ensuredIndexes = new ArrayList<>();
		if (uniqueFields != null) {
			ensuredIndexes.addAll( MongoUtils.ensureUnique(primary, uniqueFields.toArray(new String[] {})) );
		}
		ensuredIndexes.addAll( MongoUtils.ensureIndexes(primary, indexes) );
		MongoUtils.retainIndexes(primary, ensuredIndexes.toArray(new String[] {}));
	}
	
	private static Index[] indexedFieldMapToIndexes(Map<String, Integer> indexedFields) {
		final List<Index> indexes = new ArrayList<>();
		for (final Map.Entry<String, Integer> indexedField : indexedFields.entrySet()) {
			indexes.add(indexedField.getValue() == 1 ? Index.asc(indexedField.getKey()) : Index.desc(indexedField.getKey()));
		}
		return indexes.toArray(new Index[] {});
	}

	/**
	 * @param intfClass
	 * @param currentSchemaVersion e.g. {@link PersonImpl#CURRENT_SCHEMA_VERSION}.
	 * @param mongoUri
	 * @param collName
	 * @param indexedFields
	 */
	@Deprecated
	public MongoRepositoryBase(Class<T> intfClass, Class<? extends T> implClass, long currentSchemaVersion, 
			String mongoUri, ReadPattern readPattern, String collName, List<String> uniqueFields, Map<String, Integer> indexedFields,
			boolean migrationEnabled) {
		this(intfClass, implClass, currentSchemaVersion, mongoUri, readPattern, collName, uniqueFields, migrationEnabled, false,
				indexedFieldMapToIndexes(indexedFields));
	}

	/**
	 * @param intfClass
	 * @param currentSchemaVersion e.g. {@link PersonImpl#CURRENT_SCHEMA_VERSION}.
	 * @param mongoUri
	 * @param collName
	 * @param indexedFields
	 */
	@Deprecated
	public MongoRepositoryBase(Class<T> intfClass, Class<? extends T> implClass, long currentSchemaVersion, 
			String mongoUri, ReadPattern readPattern, String collName, List<String> uniqueFields, Map<String, Integer> indexedFields,
			boolean migrationEnabled, boolean autoExplainSlow) {
		this(intfClass, implClass, currentSchemaVersion, mongoUri, readPattern, collName, uniqueFields, migrationEnabled, autoExplainSlow,
				indexedFieldMapToIndexes(indexedFields));
	}

	@Deprecated
	public MongoRepositoryBase(Class<T> entityClass, String mongoUri, String collName, String[] indexedFields) {
		super();
		this.entityClass = entityClass;
		this.implClass = entityClass;
		this.currentSchemaVersion = 1L;
		this.mongoUri = mongoUri;
		this.collName = collName;
		this.migrationEnabled = true;
		this.autoExplainSlow = false;
		// WARNING: mongoUri may contain password!
		final MongoClientURI realMongoUri = new MongoClientURI(mongoUri);
		this.log = LoggerFactory.getLogger(getClass().getName() + "/" + realMongoUri.getDatabase() + "/" + collName);
		log.info("Connecting to MongoDB database {}/{} as {} for {}",
				realMongoUri.getHosts(), realMongoUri.getDatabase(), realMongoUri.getUsername(), collName);
		try {
			final DB db = MongoUtils.getDb(realMongoUri, ReadPreference.primaryPreferred());
			if (realMongoUri.getUsername() != null)
				db.authenticate(realMongoUri.getUsername(),
						realMongoUri.getPassword());
			primary = db.getCollection(collName);
			secondary = primary;
			morphia = new Morphia();
		} catch (Exception e) {
			throw new MongoRepositoryException(e, "Cannot connect to MongoDB %s/%s as %s for %s repository",
					realMongoUri.getHosts(), realMongoUri.getDatabase(), realMongoUri.getUsername(),
					collName);
		}
		beforeEnsureIndexes();
		log.debug("Ensuring {} indexes on {}: {}", indexedFields.length, collName, indexedFields);
		for (String field : indexedFields) {
			primary.ensureIndex(new BasicDBObject(field, 1));
		}
	}
	
	public boolean isMigrationEnabled() {
		return migrationEnabled;
	}
	
	/**
	 * Automatically {@link DBCursor#explain()}s slow queries.
	 * @return
	 */
	public boolean isAutoExplainSlow() {
		return autoExplainSlow;
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
		final long total = secondary.count(new BasicDBObject());
		final BasicDBObject sortQuery = MongoUtils.getSort(pageable.getSort(), "modificationTime", Sort.Direction.DESC);
		try {
			log.debug("findAll sort={} skip={} limit={} on {}",
					sortQuery, pageable.getOffset(), pageable.getPageSize(), entityClass);
			final List<T> entities = findSecondary(null, null, sortQuery, pageable.getOffset(), pageable.getPageSize(), "findAll");
			return new PageImpl<>(entities, pageable, total);
		} catch (Exception e) {
			throw new MongoRepositoryException(e, "Cannot findAll %s sort=%s skip=%s limit=%s on %s",
					collName, sortQuery, pageable.getOffset(), pageable.getPageSize(), entityClass);
		}
	}

	@Override
	public final Page<T> findAllFields(@Nullable Map<String, Boolean> projection, Pageable pageable) {
		final long total = secondary.count(new BasicDBObject());
		final BasicDBObject sortQuery = MongoUtils.getSort(pageable.getSort(), "modificationTime", Sort.Direction.DESC);
		try {
			log.debug("findAll projection={} sort={} skip={} limit={} on {}",
					projection, sortQuery, pageable.getOffset(), pageable.getPageSize(), entityClass);
			final List<T> entities = findSecondary(null, MongoUtils.getProjectionDBObject(projection),
					sortQuery, pageable.getOffset(), pageable.getPageSize(), "findAllFields", projection);
			return new PageImpl<>(entities, pageable, total);
		} catch (Exception e) {
			throw new MongoRepositoryException(e, "Cannot findAll %s projection=%s sort=%s skip=%s limit=%s on %s",
					collName, projection, sortQuery, pageable.getOffset(), pageable.getPageSize(), entityClass);
		}
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.BasicRepository#count()
	 */
	@Override
	public final long count() {
		return secondary.count();
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
		if (entities.isEmpty()) {
			log.debug("Not adding empty list of {} documents", collName);
			return ImmutableList.of();
		}
		beforeSave(entities);
		final Collection<String> transformedAsIds = Collections2.transform(entities, new IdFunction());
		final List<String> ids;
		try {
			ids = ImmutableList.copyOf(transformedAsIds);
		} catch (Exception e1) {
			throw new DataException(e1, "Make sure all of the entities have valid 'id': %s", transformedAsIds);
		}
		log.debug("Adding {} {} documents: {}", entities.size(), collName, ids);
		String dbObjsStr = "";
		try (Profiled p = new Profiled(log, "Added " + entities.size() + " " + collName + " documents: " + ids)) {
			final List<DBObject> dbObjs = ImmutableList.copyOf(Collections2
					.transform(entities, new EntityToDBObject()));
			dbObjsStr = dbObjs.toString();
			final WriteResult writeResult = primary.insert(dbObjs);
//			log.debug("writeResult: {}", writeResult);
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
		if (entities.isEmpty()) {
			log.debug("Not modifying empty list of {} documents", collName);
			return ImmutableList.of();
		}
		log.debug("Modifying {} {} documents: {}", entities.size(), collName, entities.keySet());
		final List<S> modifieds = new ArrayList<>();
		for (final Entry<String, S> entry : entities.entrySet()) {
			final S entity = entry.getValue();
			beforeSave(entity);
			final DBObject dbo = new EntityToDBObject().apply(entity);
			final WriteResult writeResult = primary.update(new BasicDBObject("_id", entry.getKey()), dbo);
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
	public final Set<String> exists(final Collection<String> ids) {
		log.debug("Checking existence of {} {}: {}", ids.size(), collName, ids);
		return findPrimary(new BasicDBObject("_id", new BasicDBObject("$in", ids)), new BasicDBObject("_id", 1), null, 0, 0, new CursorFunction<Set<String>>() {
			@Override
			public Set<String> apply(DBCursor cursor) throws Exception {
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
		}, "exists", ids);
	}

	/**
	 * Used by {@link #findOne(java.io.Serializable)}, so this must use the {@link #primary} client.
	 * @param ids
	 * @param sort
	 * @return
	 */
	@Override
	public final List<T> findAll(Collection<String> ids, Sort sort) {
		final BasicDBObject sortQuery = MongoUtils.getSort(sort, "_id", Direction.ASC);
		log.trace("finding {} {} sort by {}: {}", ids.size(), collName, sort, Iterables.limit(ids, 10));
		final List<T> entities;
		if (ids.size() == 1) {
			// special case, for better debugging
			final String id = ids.iterator().next();
			entities = ImmutableList.copyOf(Optional.fromNullable(
					findOnePrimaryAsEntity(new BasicDBObject("_id", id), null, "findOne", id)).asSet());
			if (!entities.isEmpty()) {
				log.debug("findOne {} by _id '{}' returned that document", collName, id);  
			} else {
				log.trace("findOne {} by _id '{}' returned nothing", collName, id);
			}
		} else {
			final BasicDBObject idsQuery = new BasicDBObject("_id", new BasicDBObject("$in", ids));
			entities = findPrimary(idsQuery, null, sortQuery, 0, 0, "findAll", ids, sort);
			if (ids.size() > 1 || ids.size() != entities.size()) {
				log.debug("find {} {} by _id ({}) returned {} documents", 
						ids.size(), collName, Iterables.limit(ids, 10), entities.size());  
			}
		}
		return entities;
	}

	@Override
	public final long deleteIds(Collection<String> ids) {
		log.debug("Deleting {} {}: {}", ids.size(), collName, ids);
		final WriteResult result = primary.remove(new BasicDBObject("_id", new BasicDBObject("$in", ids)));
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
		final long total = secondary.count(query);
		final BasicDBObject sortQuery = MongoUtils.getSort(pageable.getSort(), "_id", Direction.ASC);
		final List<String> entityIds = findSecondary(query, new BasicDBObject("_id", true),
				sortQuery, pageable.getOffset(), pageable.getPageSize(), new Function<DBObject, String>() {
			@Override @Nullable
			public String apply(@Nullable DBObject input) {
				return (String) input.get("_id");
			}
		}, "findAllIds");
		return new PageImpl<>(entityIds, pageable, total);
	}
	
	@Override
	public long countByQuery(DBObject query) {
		final long total = secondary.count(query);
		log.debug("Got count {} by query {}", total, query);
		return total;
	}
	
	@Override
	public Page<T> findAllByQuery(DBObject query, Pageable pageable) {
		final BasicDBObject sortQuery = MongoUtils.getSort(pageable.getSort(), "modificationTime", Sort.Direction.DESC);
		log.debug("findAllByQuery {} {} sort {} skip {} limit {}",
				collName, query, sortQuery, pageable.getOffset(), pageable.getPageSize());
		final long total = secondary.count(query);
		final List<T> entities = findSecondary(query, null, sortQuery, pageable.getOffset(), pageable.getPageSize(), "findAllByQuery");
		log.info("findAllByQuery {} {} returned {} out of {} documents, sort {} skip {} limit {}",
				collName, query, entities.size(), total, sortQuery, pageable.getOffset(), pageable.getPageSize());
		return new PageImpl<>(entities, pageable, total);		
	}

	protected DBObject findDBObjectByQuery(DBObject query, DBObject fields) {
		log.trace("findOneByQuery {} {}", collName, query, fields);
		final DBObject dbo = secondary.findOne(query, fields);
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
	
	/**
	 * @param coll
	 * @param query
	 * @param fields
	 * @param sort
	 * @param skip
	 * @param limit 0 means no limit.
	 * @param func
	 * @param methodName
	 * @param params {@code Object[]} is used instead of {@link List} because {@link ImmutableList} does not accept {@code null} values.
	 * @return
	 */
	private <R> R doFindClient(DBCollection coll, @Nullable DBObject query, @Nullable DBObject fields, @Nullable DBObject sort, long skip, long limit,
			CursorFunction<R> func, String methodName, @Nullable Object... params) {
		final long startTime = System.currentTimeMillis();
//		log.debug("Params: {}", params);
		final String methodSignature = getClass().getSimpleName() + "." + methodName + "(" + (params != null ? Joiner.on(", ").skipNulls().join(params) : "") + ")";
		Integer cursorSize = null;
		try (final DBCursor cursor = coll.find(query, fields).addSpecial("$comment", Thread.currentThread().getName() + ": " + methodSignature)
			.sort(sort).skip((int) skip).limit((int) limit)) {
			log.debug("Cursor: {}", cursor);
			R applied = func.apply(cursor);
			cursorSize = cursor.size();
			return applied;
		} catch (Exception e) {
			throw new MongoRepositoryException(e, "Cannot find %s %s %s fields=%s sort=%s page=%s/%s for method %s: %s",
					coll.getDB().getMongo().getReadPreference(), collName, query, fields, sort, skip, limit, methodSignature, e);
		} finally {
			final long duration = System.currentTimeMillis() - startTime;
			if (duration > SLOW_QUERY_THRESHOLD) {
				if (autoExplainSlow) {
					final DBObject explain = coll.find(query, fields).addSpecial("$comment", Thread.currentThread().getName() + ": " + methodSignature)
						.sort(sort).skip((int) skip).limit((int) limit).explain();
					final int n = (int) explain.get("n");
					final int nscanned = (int) explain.get("nscannedAllPlans");
					final int efficiency = nscanned > 0 ? n * 100 / nscanned : 100;
					final int millis = (int) explain.get("millis");
					log.warn("Slow find {} {} {} fields={} sort={} page={}/{} for method {} size {} took {}ms (DB scanned {} to get {} for {}ms, {}% efficiency). db.{}.find({}, {}).sort({}).skip({}).limit({}).explain() >> {}",
							coll.getDB().getMongo().getReadPreference(), collName, query, fields, sort, skip, limit, methodSignature, cursorSize, duration,
							nscanned, n, millis, efficiency, collName, JSON.serialize(query), JSON.serialize(fields), JSON.serialize(sort), skip, limit, explain);
				} else {
					log.warn("Slow find {} {} {} fields={} sort={} page={}/{} for method {} size {} took {}ms",
							coll.getDB().getMongo().getReadPreference(), collName, query, fields, sort, skip, limit, methodSignature, cursorSize, duration);
				}
			}
		}
	}

	/**
	 * @param coll
	 * @param query
	 * @param fields
	 * @param sort
	 * @param skip
	 * @param limit 0 means no limit.
	 * @param func Must not return {@code null}!
	 * @param methodName
	 * @param params
	 * @return Important: It may not contain {@code null} elements!
	 */
	private <R> ImmutableList<R> doFindClient(DBCollection coll, @Nullable DBObject query, @Nullable DBObject fields, @Nullable DBObject sort, long skip, long limit,
			final Function<DBObject, R> func, String methodName, @Nullable Object... params) {
		return doFindClient(coll, query, fields, sort, skip, limit, new CursorFunction<ImmutableList<R>>() {
			@Override
			public ImmutableList<R> apply(DBCursor cursor)
						throws Exception {
					return FluentIterable.from(cursor).transform(func).toList();
			}
			}, methodName, params);
	}

	/**
	 * @param coll
	 * @param query
	 * @param fields
	 * @param sort
	 * @param skip
	 * @param limit 0 means no limit.
	 * @param methodName
	 * @param params
	 * @return Important: It may not contain {@code null} elements!
	 */
	private ImmutableList<T> doFindClient(DBCollection coll, @Nullable DBObject query, @Nullable DBObject fields, @Nullable DBObject sort, long skip, long limit,
			String methodName, @Nullable Object... params) {
		return doFindClient(coll, query, fields, sort, skip, limit, new DBObjectToEntity(), methodName, params);
	}

	/**
	 * Runs {@link DBCollection#find(DBObject, DBObject)} with specified parameters using {@link #primary} client.
	 * @param query
	 * @param fields
	 * @param sort
	 * @param skip
	 * @param limit 0 means no limit.
	 * @param func
	 * @param methodName
	 * @param params
	 * @return
	 */
	protected <R> R findPrimary(@Nullable DBObject query, @Nullable DBObject fields, @Nullable DBObject sort, long skip, long limit,
			CursorFunction<R> func, String methodName, @Nullable Object... params) {
		return doFindClient(primary, query, fields, sort, skip, limit, func, methodName, params);
	}

	/**
	 * Runs {@link DBCollection#find(DBObject, DBObject)} with specified parameters using {@link #primary} client.
	 * @param query
	 * @param fields
	 * @param sort
	 * @param skip
	 * @param limit 0 means no limit.
	 * @param func
	 * @param methodName
	 * @param params
	 * @return
	 */
	protected <R> ImmutableList<R> findPrimary(@Nullable DBObject query, @Nullable DBObject fields, @Nullable DBObject sort, long skip, long limit,
			final Function<DBObject, R> func, String methodName, @Nullable Object... params) {
		return doFindClient(primary, query, fields, sort, skip, limit, func, methodName, params);
	}

	/**
	 * Runs {@link DBCollection#find(DBObject, DBObject)} with specified parameters using {@link #primary} client.
	 * @param query
	 * @param fields
	 * @param sort
	 * @param skip
	 * @param limit 0 means no limit.
	 * @param methodName
	 * @param params
	 * @param func
	 * @return
	 */
	protected ImmutableList<T> findPrimary(@Nullable DBObject query, @Nullable DBObject fields, @Nullable DBObject sort, long skip, long limit,
			String methodName, @Nullable Object... params) {
		return doFindClient(primary, query, fields, sort, skip, limit, methodName, params);
	}

	/**
	 * Runs {@link DBCollection#find(DBObject, DBObject)} with specified parameters using {@link #primary} client.
	 * @param query
	 * @param fields
	 * @param sort
	 * @param skip
	 * @param limit 0 means no limit.
	 * @param methodName
	 * @param params
	 * @param func
	 * @return
	 */
	protected List<DBObject> findPrimaryAsDBObjects(@Nullable DBObject query, @Nullable DBObject fields, @Nullable DBObject sort, long skip, long limit,
			String methodName, @Nullable Object... params) {
		return doFindClient(primary, query, fields, sort, skip, limit,
				new CursorFunction<List<DBObject>>() {
					@Override
					public List<DBObject> apply(DBCursor cursor) throws Exception {
						return cursor.toArray();
					}
				}, methodName, params);
	}

	/**
	 * Runs {@link DBCollection#find(DBObject, DBObject)} with specified parameters using {@link #secondary} client.
	 * @param query
	 * @param fields
	 * @param sort
	 * @param skip
	 * @param limit 0 means no limit.
	 * @param func
	 * @param methodName
	 * @param params
	 * @return
	 */
	protected <R> R findSecondary(@Nullable DBObject query, @Nullable DBObject fields, @Nullable DBObject sort, long skip, long limit,
			CursorFunction<R> func, String methodName, @Nullable Object... params) {
		return doFindClient(secondary, query, fields, sort, skip, limit, func, methodName, params);
	}

	/**
	 * Runs {@link DBCollection#find(DBObject, DBObject)} with specified parameters using {@link #secondary} client.
	 * @param query
	 * @param fields
	 * @param sort
	 * @param skip
	 * @param limit 0 means no limit.
	 * @param func
	 * @param methodName
	 * @param params
	 * @return
	 */
	protected <R> ImmutableList<R> findSecondary(@Nullable DBObject query, @Nullable DBObject fields, @Nullable DBObject sort, long skip, long limit,
			final Function<DBObject, R> func, String methodName, @Nullable Object... params) {
		return doFindClient(secondary, query, fields, sort, skip, limit, func, methodName, params);
	}

	/**
	 * Runs {@link DBCollection#find(DBObject, DBObject)} with specified parameters using {@link #secondary} client.
	 * @param query
	 * @param fields
	 * @param sort
	 * @param skip
	 * @param limit 0 means no limit.
	 * @param methodName
	 * @param params
	 * @param func
	 * @return
	 */
	protected ImmutableList<T> findSecondary(@Nullable DBObject query, @Nullable DBObject fields, @Nullable DBObject sort, long skip, long limit,
			String methodName, @Nullable Object... params) {
		return doFindClient(secondary, query, fields, sort, skip, limit, methodName, params);
	}

	/**
	 * Runs {@link DBCollection#find(DBObject, DBObject)} with specified parameters using {@link #secondary} client.
	 * @param query
	 * @param fields
	 * @param sort
	 * @param skip
	 * @param limit 0 means no limit.
	 * @param methodName
	 * @param params
	 * @param func
	 * @return
	 */
	protected List<DBObject> findSecondaryAsDBObjects(@Nullable DBObject query, @Nullable DBObject fields, @Nullable DBObject sort, long skip, long limit,
			String methodName, @Nullable Object... params) {
		return doFindClient(secondary, query, fields, sort, skip, limit,
				new CursorFunction<List<DBObject>>() {
					@Override
					public List<DBObject> apply(DBCursor cursor) throws Exception {
						return cursor.toArray();
					}
				}, methodName, params);
	}

	@Nullable
	private DBObject doFindOneClient(DBCollection coll, @Nullable DBObject query, @Nullable DBObject fields, @Nullable DBObject orderBy,
			String methodName, @Nullable Object... params) {
		final long startTime = System.currentTimeMillis();
		try {
			return coll.findOne(query, fields, orderBy);
		} catch (Exception e) {
			// defer methodSignature calculation until necessary to save performance
			final String methodSignature = getClass().getSimpleName() + "." + methodName + "(" + (params != null ? Joiner.on(", ").join(params) : "") + ")";
			throw new MongoRepositoryException(e, "Cannot findOne %s %s %s fields=%s orderBy=%s for method %s: %s",
					coll.getDB().getMongo().getReadPreference(), collName, query, fields, orderBy, methodSignature, e);
		} finally {
			final long duration = System.currentTimeMillis() - startTime;
			if (duration > SLOW_QUERY_THRESHOLD) {
				// defer methodSignature calculation until necessary to save performance
				final String methodSignature = getClass().getSimpleName() + "." + methodName + "(" + (params != null ? Joiner.on(", ").join(params) : "") + ")";
				if (autoExplainSlow) {
					final DBObject explain = coll.find(query, fields).addSpecial("$comment", Thread.currentThread().getName() + ": " + methodSignature)
						.sort(orderBy).limit(1).explain();
					final int n = (int) explain.get("n");
					final int nscanned = (int) explain.get("nscannedAllPlans");
					final int efficiency = nscanned > 0 ? n * 100 / nscanned : 100;
					final int millis = (int) explain.get("millis");
					log.warn("Slow findOne {} {} {} fields={} sort={} page={}/{} for method {} took {}ms (DB scanned {} to get {} for {}ms, {}% efficiency). db.{}.find({}, {}).sort({}).limit(1).explain() >> {}",
							coll.getDB().getMongo().getReadPreference(), collName, query, fields, orderBy, methodSignature, duration, 
							nscanned, n, millis, efficiency, collName, query, fields, orderBy, explain);
				} else {
					log.warn("Slow findOne {} {} {} fields={} sort={} page={}/{} for method {} took {}ms",
							coll.getDB().getMongo().getReadPreference(), collName, query, fields, orderBy, methodSignature, duration);
				}
			}
		}
	}

	/**
	 * Runs {@link DBCollection#findOne(DBObject, DBObject, DBObject)} with specified parameters using {@link #primary} client.
	 * @param query
	 * @param fields
	 * @param orderBy
	 * @param methodName
	 * @param params
	 * @return
	 */
	@Nullable
	protected DBObject findOnePrimary(@Nullable DBObject query, @Nullable DBObject fields, @Nullable DBObject orderBy,
			String methodName, @Nullable Object... params) {
		return doFindOneClient(primary, query, fields, orderBy, methodName, params);
	}

	/**
	 * Runs {@link DBCollection#findOne(DBObject, DBObject, DBObject)} with specified parameters using {@link #primary} client.
	 * @param query
	 * @param fields
	 * @param orderBy
	 * @param methodName
	 * @param params
	 * @return
	 */
	@Nullable
	protected T findOnePrimaryAsEntity(@Nullable DBObject query, @Nullable DBObject fields, @Nullable DBObject orderBy,
			String methodName, @Nullable Object... params) {
		final DBObject obj = findOnePrimary(query, fields, orderBy, methodName, params);
		return obj != null ? new DBObjectToEntity().apply(obj) : null;
	}

	/**
	 * Runs {@link DBCollection#findOne(DBObject, DBObject, DBObject)} with specified parameters using {@link #primary} client.
	 * @param query
	 * @param fields
	 * @param methodName
	 * @param params
	 * @return
	 */
	@Nullable
	protected DBObject findOnePrimary(@Nullable DBObject query, @Nullable DBObject fields,
			String methodName, @Nullable Object... params) {
		return doFindOneClient(primary, query, fields, null, methodName, params);
	}

	/**
	 * Runs {@link DBCollection#findOne(DBObject, DBObject, DBObject)} with specified parameters using {@link #primary} client.
	 * @param query
	 * @param fields
	 * @param orderBy
	 * @param methodName
	 * @param params
	 * @return
	 */
	@Nullable
	protected T findOnePrimaryAsEntity(@Nullable DBObject query, @Nullable DBObject fields,
			String methodName, @Nullable Object... params) {
		final DBObject obj = findOnePrimary(query, fields, methodName, params);
		return obj != null ? new DBObjectToEntity().apply(obj) : null;
	}

	/**
	 * Runs {@link DBCollection#findOne(DBObject, DBObject, DBObject)} with specified parameters using {@link #secondary} client.
	 * @param query
	 * @param fields
	 * @param orderBy
	 * @param methodName
	 * @param params
	 * @return
	 */
	@Nullable
	protected DBObject findOneSecondary(@Nullable DBObject query, @Nullable DBObject fields, @Nullable DBObject orderBy,
			String methodName, @Nullable Object... params) {
		return doFindOneClient(secondary, query, fields, orderBy, methodName, params);
	}

	/**
	 * Runs {@link DBCollection#findOne(DBObject, DBObject, DBObject)} with specified parameters using {@link #secondary} client.
	 * @param query
	 * @param fields
	 * @param orderBy
	 * @param methodName
	 * @param params
	 * @return
	 */
	@Nullable
	protected T findOneSecondaryAsEntity(@Nullable DBObject query, @Nullable DBObject fields, @Nullable DBObject orderBy,
			String methodName, @Nullable Object... params) {
		final DBObject obj = findOneSecondary(query, fields, orderBy, methodName, params);
		return obj != null ? new DBObjectToEntity().apply(obj) : null;
	}

	/**
	 * Runs {@link DBCollection#findOne(DBObject, DBObject, DBObject)} with specified parameters using {@link #secondary} client.
	 * @param query
	 * @param fields
	 * @param methodName
	 * @param params
	 * @return
	 */
	@Nullable
	protected DBObject findOneSecondary(@Nullable DBObject query, @Nullable DBObject fields,
			String methodName, @Nullable Object... params) {
		return doFindOneClient(secondary, query, fields, null, methodName, params);
	}

	/**
	 * Runs {@link DBCollection#findOne(DBObject, DBObject, DBObject)} with specified parameters using {@link #secondary} client.
	 * @param query
	 * @param fields
	 * @param orderBy
	 * @param methodName
	 * @param params
	 * @return
	 */
	@Nullable
	protected T findOneSecondaryAsEntity(@Nullable DBObject query, @Nullable DBObject fields,
			String methodName, @Nullable Object... params) {
		final DBObject obj = findOneSecondary(query, fields, methodName, params);
		return obj != null ? new DBObjectToEntity().apply(obj) : null;
	}

}

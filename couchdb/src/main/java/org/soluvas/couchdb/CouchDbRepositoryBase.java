package org.soluvas.couchdb;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;
import javax.annotation.PreDestroy;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ektorp.PageRequest;
import org.ektorp.ViewQuery;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;
import org.ektorp.support.DesignDocument;
import org.ektorp.support.DesignDocument.View;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Identifiable;
import org.soluvas.commons.NotNullPredicate;
import org.soluvas.commons.Revisionable;
import org.soluvas.commons.SchemaVersionable;
import org.soluvas.commons.Timestamped;
import org.soluvas.commons.impl.PersonImpl;
import org.soluvas.commons.util.Profiled;
import org.soluvas.data.DataException;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.data.push.RepositoryException;
import org.soluvas.data.repository.PagingAndSortingRepository;
import org.soluvas.data.repository.PagingAndSortingRepositoryBase;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.mongodb.DBCollection;

/**
 * {@link PagingAndSortingRepository} implemented using CouchDB, with {@link SchemaVersionable} support.
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
public class CouchDbRepositoryBase<T extends Identifiable> extends PagingAndSortingRepositoryBase<T, String>
	implements CouchDbRepository<T> {
	
//	public class DBObjectToEntity implements Function<DBObject, T> {
//		@Override
//		public T apply(DBObject input) {
//			if (input == null)
//				return null;
//			try {
//				return morphia.fromDBObject(implClass, input);
//			} catch (Exception e) {
//				throw new CouchDbRepositoryException(e,
//						"Cannot deserialize MongoDB object to %s: %s",
//								entityClass.getName(), input);
//			}
//		}
//	}
//
//	public class EntityToDBObject implements Function<T, DBObject> {
//		@Override @Nullable
//		public DBObject apply(@Nullable T entity) {
//			return morphia.toDBObject(entity);
//		}
//	}

	public static final String SCHEMA_VERSION_FIELD = "schemaVersion";
	protected final Logger log;
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
	protected final Class<T> entityClass;
	protected final Class<? extends T> implClass;
	protected long currentSchemaVersion;
	protected final String couchDbUri;
	private HttpClient httpClient;
	protected final String dbName;
	protected StdCouchDbConnector dbConn;
	
	/**
	 * @param intfClass
	 * @param currentSchemaVersion e.g. {@link PersonImpl#CURRENT_SCHEMA_VERSION}.
	 * @param couchDbUri Scheme (http/https), username (optional), password (optional), port, and path, e.g. {@code http://localhost:5984}.
	 * 	Excluding databaseName.
	 * @param dbName Database name.
	 * @param collName
	 * @param indexedFields
	 */
	public CouchDbRepositoryBase(Class<T> intfClass, Class<? extends T> implClass, long currentSchemaVersion, 
			String couchDbUri, String dbName, String collName, List<String> uniqueFields, Map<String, Integer> indexedFields) {
		super();
		this.entityClass = intfClass;
		this.implClass = implClass;
		this.currentSchemaVersion = currentSchemaVersion;
		this.couchDbUri = couchDbUri;
		this.dbName = dbName;
		this.collName = collName;
		
		// WARNING: couchDbUri may contain password!
		URI realCouchDbUri = URI.create(couchDbUri);
		this.log = LoggerFactory.getLogger(getClass().getName() + "/" + dbName + "/" + collName + "/" + currentSchemaVersion);
		final String username = realCouchDbUri.getUserInfo() != null ? realCouchDbUri.getUserInfo().split(":")[0] : null;
		log.info("Connecting to CouchDB {}:{}{} database {} as {} for {}",
				realCouchDbUri.getHost(), realCouchDbUri.getPort(), realCouchDbUri.getPath(), dbName, username, collName);
		try {
			httpClient = new StdHttpClient.Builder().url(couchDbUri).build();
			StdCouchDbInstance dbInstance = new StdCouchDbInstance(httpClient, SoluvasObjectMapperFactory.INSTANCE);
			dbConn = new StdCouchDbConnector(dbName, dbInstance, SoluvasObjectMapperFactory.INSTANCE);
			dbConn.createDatabaseIfNotExists();
		} catch (Exception e) {
			throw new CouchDbRepositoryException(e, "Cannot connect to CouchDB %s:%s%s database %s as %s for %s repository",
					realCouchDbUri.getHost(), realCouchDbUri.getPort(), realCouchDbUri.getPath(), dbName, username, collName);
		}
		beforeEnsureIndexes();
		
		DesignDocument design = dbConn.get(DesignDocument.class, getDesignDocId());
		if (design == null) {
			design = new DesignDocument(getDesignDocId());
		}
		// 'all' view: {"map": "function(doc) { if (doc.type == 'Sofa' ) emit( null, doc._id ) } "}
		// 'count' view
		design.addView("all", new View("function(doc) { if (doc.type == '" + intfClass.getSimpleName() + "' ) emit( null, doc._id ); }"));
		design.addView("count", new View("function(doc) { if (doc.type == '" + intfClass.getSimpleName() + "' ) emit( null, doc._id ); }", "_count"));
		design.addView("id", new View("function(doc) { if (doc.type == '" + intfClass.getSimpleName() + "' ) emit( doc.id, null ); }"));
		design.addView("by_modificationTime", new View("function(doc) { if (doc.type == '" + intfClass.getSimpleName() + "' ) emit( [doc.modificationTime, doc._id], null ); }"));
		dbConn.update(design);
//		final List<String> ensuredIndexes = new ArrayList<>();
//		ensuredIndexes.addAll( MongoUtils.ensureUnique(coll, uniqueFields.toArray(new String[] {})) );
//		ensuredIndexes.addAll( MongoUtils.ensureIndexes(coll, indexedFields) );
//		MongoUtils.retainIndexes(coll, ensuredIndexes.toArray(new String[] {}));
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
		log.info("Shutting down CouchDB {} database {} repository", dbName, collName);
		httpClient.shutdown();
	}

	/**
	 * Note: include_docs will cause a single document lookup per returned view result row. 
	 * This adds significant strain on the storage system if you are under high load or return a lot of rows per request. 
	 * If you are concerned about this, you can emit the full doc in each row; 
	 * this will increase view index time and space requirements, but will make view reads optimally fast.
	 * @see org.soluvas.data.repository.PagingAndSortingRepositoryBase#findAll(org.soluvas.data.domain.Pageable)
	 */
	@Override
	public final Page<T> findAll(Pageable pageable) {
		final Sort sort = Optional.fromNullable(pageable.getSort()).or(new Sort("modificationTime"));
		ViewQuery query = new ViewQuery().designDocId(getDesignDocId())
			.viewName("by_" + sort.iterator().next().getProperty())
			.descending(sort.iterator().next().getDirection() == Direction.DESC)
			.includeDocs(true);
		final PageRequest pageRequest = new PageRequest.Builder().page((int) pageable.getPageNumber()).pageSize((int) pageable.getPageSize()).build();
		final org.ektorp.Page<? extends T> page = dbConn.queryForPage(query, pageRequest, implClass);
		return new PageImpl<T>((List) page.getRows(), pageable, page.getTotalSize());
		
//		final BasicDBObject query = new BasicDBObject();
//		final long total = coll.count(query);
//		final BasicDBObject sortQuery = MongoUtils.getSort(pageable.getSort(), "modificationTime", -1);
//		final DBCursor cursor = coll.find(query)
//				.sort(sortQuery)
//				.skip((int) pageable.getOffset())
//				.limit((int) pageable.getPageSize());
//		final List<T> physicalInventories = MongoUtils
//				.transform(cursor, new DBObjectToEntity());
//		return new PageImpl<>(physicalInventories, pageable, total);
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.BasicRepository#count()
	 */
	@Override
	public final long count() {
		final ViewQuery query = new ViewQuery().designDocId(getDesignDocId())
				.viewName("count");
		final List<Long> view = dbConn.queryView(query, Long.class);
		return Iterables.getFirst(view, 0L);
	}

	/**
	 * Design document GUID, e.g. "_design/Checklist".
	 * @return
	 */
	protected String getDesignDocId() {
		return "_design/" + StringUtils.capitalize(collName);
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.CrudRepositoryBase#getId(java.lang.Object)
	 */
	@Override @Nullable
	protected final String getId(T entity) {
		return entity.getId();
	}
	
	public static class GuidFunction implements Function<Revisionable, String> {
		@Override @Nullable
		public String apply(@Nullable Revisionable input) {
			return input != null ? input.getGuid() : null;
		}
	}

	@Override
	public <S extends T> Collection<S> add(Collection<S> entities) {
		beforeSave(entities);
		
		final Collection<String> transformedAsIds = Collections2.transform(entities, new IdFunction());
		final List<String> ids;
		try {
			ids = ImmutableList.copyOf(transformedAsIds);
		} catch (Exception e1) {
			throw new DataException(e1, "Make sure all of the entities have valid 'id': %s", transformedAsIds);
		}
		
		final Collection<String> guids = Collections2.transform((Collection) entities, new GuidFunction());
		Preconditions.checkArgument(Iterables.all(guids, new NotNullPredicate<>()),
			"Make sure all of the entities have valid guid: %s", guids);
		
		log.debug("Adding {} {} documents: {}", entities.size(), collName, ids);
		String dbObjsStr = "";
		try (Profiled p = new Profiled(log, "Added " + entities.size() + " " + collName + " documents: " + ids)) {
			final List<S> results = new ArrayList<>();
			for (final S entity : entities) {
				final S addedEntity = EcoreUtil.copy(entity);
				dbConn.create(addedEntity);
				results.add(addedEntity);
			}
//			final List<DocumentOperationResult> opResults = dbConn.executeBulk(entities);
//			for (final DocumentOperationResult opResult : opResults) {
//				if (!opResult.isErroneous()) {
//					S entity = Iterables.find(entities, new Predicate<T>() {
//						@Override
//						public boolean apply(@Nullable T input) {
//							return opResult.getId().equals( ((Revisionable) input).getGuid() );
//						}
//					});
//					S addedEntity = EcoreUtil.copy(entity);
//					((Revisionable) addedEntity).setRevision(opResult.getRevision());
//					results.add(addedEntity);
//				} else {
//					log.error("Error adding {} document {}: {} - {}", collName, opResult.getId(), opResult.getError(), opResult.getReason());
//				}
//			}
			return results;
//			final List<DBObject> dbObjs = ImmutableList.copyOf(Collections2
//					.transform(entities, new EntityToDBObject()));
//			dbObjsStr = dbObjs.toString();
//			final WriteResult writeResult = coll.insert(dbObjs);
//			if (writeResult.getLastError() != null
//					&& writeResult.getLastError().getException() != null) {
//				throw new CouchDbRepositoryException(writeResult.getLastError()
//						.getException(), "Cannot add %d %s documents: %s",
//						entities.size(), collName, ids);
//			}
//			log.info("Added {} {} documents: {}", entities.size(), collName,
//					ids);
//			return ImmutableList.copyOf(entities);
		} catch (Exception e) {
			throw new RepositoryException(e, "Error adding %s %s documents (%s): %s", entities.size(), collName, ids, 
					StringUtils.abbreviateMiddle(dbObjsStr, "…", 1000));
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
		throw new UnsupportedOperationException();
//		log.debug("Modifying {} {} documents: {}", entities.size(), collName, entities.keySet());
//		final List<S> modifieds = new ArrayList<>();
//		for (final Entry<String, S> entry : entities.entrySet()) {
//			final S entity = entry.getValue();
//			beforeSave(entity);
//			final DBObject dbo = new EntityToDBObject().apply(entity);
//			final WriteResult writeResult = coll.update(new BasicDBObject("_id", entry.getKey()), dbo);
//			if (writeResult.getLastError() != null && writeResult.getLastError().getException() != null) {
//				throw new CouchDbRepositoryException(writeResult.getLastError().getException(),
//						"Cannot modify %d %s documents: %s", entities.size(), collName, entities.keySet());
//			}
//			modifieds.add(entity);
//		}
//		log.info("Modified {} {} documents: {}", entities.size(), collName, entities.keySet());
//		return modifieds;
	}

	@Override
	public final Set<String> exists(Collection<String> ids) {
		throw new UnsupportedOperationException();
//		log.debug("Checking existence of {} {}: {}", ids.size(), collName, ids);
//		try (final DBCursor cursor = coll.find(new BasicDBObject("_id", new BasicDBObject("$in", ids)), new BasicDBObject())) {
//			final Set<String> existed = ImmutableSet.copyOf(Iterables.transform(cursor, new Function<DBObject, String>() {
//				@Override @Nullable
//				public String apply(@Nullable DBObject input) {
//					return (String) input.get("_id");
//				}
//			}));
//			log.info("Found {} out of {} existing {}: {}, checked: {}",
//					existed.size(), ids.size(), collName, existed, ids);
//			return existed;
//		} 
	}

	@Override
	public final List<T> findAll(Collection<String> ids, Sort sort) {
		// FIXME: support sorting
		final ViewQuery query = new ViewQuery().designDocId(getDesignDocId())
				.viewName("id").keys(ids).includeDocs(true);
		log.debug("Querying {} view {} for {} keys: {}", 
				getDesignDocId(), "id", ids.size(), Iterables.limit(ids, 10));
		final List<T> fetcheds = (List) dbConn.queryView(query, implClass);
		log.debug("Queried {} view {} for {} keys returned {} entities: {}", 
				getDesignDocId(), "id", ids.size(), fetcheds.size(), 
				Iterables.limit(Lists.transform(fetcheds, new org.soluvas.commons.IdFunction()), 10));
		return fetcheds;
	}

	@Override
	public final long deleteIds(Collection<String> ids) {
		throw new UnsupportedOperationException();
//		log.debug("Deleting {} {}: {}", ids.size(), collName, ids);
//		final WriteResult result = coll.remove(new BasicDBObject("_id", new BasicDBObject("$in", ids)));
//		if (result.getLastError().getException() != null) {
//			throw new CouchDbRepositoryException(result.getLastError().getException(),
//					"Cannot delete %s %s", collName, ids);
//		}
//		log.info("Deleted {} out of {} {} ({})", result.getN(), ids.size(), collName, ids);
//		return result.getN();
	}

	@Override
	public final Page<String> findAllIds(Pageable pageable) {
		throw new UnsupportedOperationException();
//		final BasicDBObject query = new BasicDBObject();
//		final long total = coll.count(query);
//		final BasicDBObject sortQuery = MongoUtils.getSort(pageable.getSort(), "_id", 1);
//		final DBCursor cursor = coll.find(query)
//				.sort(sortQuery)
//				.skip((int) pageable.getOffset())
//				.limit((int) pageable.getPageSize());
//		final List<String> entityIds = MongoUtils
//				.transform(cursor, new Function<DBObject, String>() {
//					@Override @Nullable
//					public String apply(@Nullable DBObject input) {
//						return (String) input.get("_id");
//					}
//				});
//		return new PageImpl<>(entityIds, pageable, total);
	}
	
	@Override
	public long countByView(String viewName) {
		throw new UnsupportedOperationException();
//		final long total = coll.count(query);
//		log.debug("Got count {} by query {}", total, query);
//		return total;
	}
	
	@Override
	public Page<T> findAllByView(String viewName, Pageable pageable) {
		throw new UnsupportedOperationException();
//		final BasicDBObject sortQuery = MongoUtils.getSort(pageable.getSort(), "modificationTime", -1);
//		log.debug("findAllByQuery {} {} sort {} skip {} limit {}",
//				collName, query, sortQuery, pageable.getOffset(), pageable.getPageSize());
//		final long total = coll.count(query);
//		final DBCursor cursor = coll.find(query)
//				.sort(sortQuery)
//				.skip((int) pageable.getOffset())
//				.limit((int) pageable.getPageSize());
//		final List<T> entities = MongoUtils
//				.transform(cursor, new DBObjectToEntity());
//		log.info("findAllByQuery {} {} returned {} out of {} documents, sort {} skip {} limit {}",
//				collName, query, entities.size(), total, sortQuery, pageable.getOffset(), pageable.getPageSize());
//		return new PageImpl<>(entities, pageable, total);		
	}

//	protected DBObject findDBObjectByQuery(DBObject query, DBObject fields) {
//		log.trace("findOneByQuery {} {}", collName, query, fields);
//		final DBObject dbo = coll.findOne(query, fields);
//		log.debug("findAllByQuery {} {} {} returned {}",
//				collName, query, fields, dbo != null ? dbo.get("_id") : null);
//		return dbo;
//	}
//
//	@Override
//	public T findOneByQuery(DBObject upQuery) {
//		final DBObject dbo = findDBObjectByQuery(upQuery, null);
//		final T entity = new DBObjectToEntity().apply(dbo);
//		return entity;		
//	}

}

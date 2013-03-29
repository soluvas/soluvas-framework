package org.soluvas.security.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.PreDestroy;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.repository.CrudRepositoryBase;
import org.soluvas.mongo.MongoUtils;
import org.soluvas.security.AppSession;
import org.soluvas.security.AppSessionRepository;
import org.soluvas.security.AppSessionStatus;

import com.google.code.morphia.Morphia;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoURI;

/**
 * Manages OAuth app session ({@link AppSession}).
 * 
 * See https://sites.google.com/a/bippo.co.id/dev/berbatik/oauth
 * 
 * @author rudi
 */
public class MongoAppSessionRepository extends CrudRepositoryBase<AppSession, String>
	implements AppSessionRepository {
	
	public class FromDBObject implements Function<DBObject, AppSession> {
		@Override @Nullable
		public AppSession apply(@Nullable DBObject input) {
			if (input == null)
				return null;
			// create "standard" DBObject
			final AppSession session = morphia.fromDBObject(AppSession.class, input);
//			// deserialize attributes, the difficult part
//			final DBObject attrsObj = (DBObject) input.get("attributes");
//			for (final String encodedKey : attrsObj.keySet()) {
////				final String key = URLDecoder.decode(encodedKey);
//				final String key = encodedKey.replace("__dot__", ".");
//				if (attrsObj.get(encodedKey) instanceof DBObject) {
//					final DBObject valueObj = (DBObject) attrsObj.get(encodedKey);
//					final String className = (String) valueObj.get("className");
//					Class<?> clazz;
//					try {
//						clazz = getClass().getClassLoader().loadClass(className);
//					} catch (ClassNotFoundException e) {
//						throw new SecurityException("Cannot deserialize " + key + " = " + valueObj, e);
//					}
//					Object value = morphia.getMapper().fromDBObject(clazz, valueObj, morphia.getMapper().createEntityCache());
////					final Object value = morphia.fromDBObject(clazz, valueObj);
//					session.getAttributes().put(key, value);
//				} else {
//					session.getAttributes().put(key, attrsObj.get(encodedKey));
//				}
//			}
			return session;
		}
	}
	
	public class ToDBObject implements Function<AppSession, DBObject> {
		@Override @Nullable
		public DBObject apply(@Nullable AppSession input) {
			if (input == null)
				return null;
			// add attributes, the difficult part
//			final BasicDBObject attrs = new BasicDBObject();
//			final List<Object> ignoredAttrs = Lists.newArrayList();
//			for (final Entry<String, Object> entry : input.getAttributes()) {
//				// Wicket:SessionUnbindingListener-berbatik_dev
//				if (entry.getKey().startsWith("Wicket:") || entry.getKey().startsWith("wicket:")) {
//					ignoredAttrs.add(entry.getKey());
//					continue;
//				}
//				log.debug("Mapping AppSession {} attribute {} from {}",
//						input.getId(), entry.getKey(), entry.getValue() != null ? entry.getValue().getClass().getName() : null);
//				final DBObject entryObj = morphia.toDBObject(entry.getValue());
////				final String encodedKey = URLEncoder.encode(entry.getKey());
//				final String encodedKey = entry.getKey().replace(".", "__dot__");
//				attrs.put(encodedKey, entryObj);
//			}
//			log.debug("Mongo AppSession {} Attributes is {}, ignored: {}",
//					input.getId(), attrs, ignoredAttrs);
			// create "standard" DBObject 
			DBObject dbo = morphia.toDBObject(input);
//			dbo.put("attributes", attrs);
			return dbo;
		}
	}
	
	private static final Logger log = LoggerFactory.getLogger(MongoAppSessionRepository.class);
	
	private final String mongoUri;
	private final DBCollection coll;
	private final Morphia morphia;
	
	public MongoAppSessionRepository(String mongoUri) {
		super();
		// WARNING: mongoUri may contain password!
		this.mongoUri = Preconditions.checkNotNull(mongoUri, "mongoUri must be specified");
		final MongoURI realMongoUri = new MongoURI(mongoUri);
		try {
			log.info("Connecting to MongoDB database {} for AppSessionRepository",
					realMongoUri.getHosts());
			// connecting to mongoDB
			final DB db = realMongoUri.connectDB();
			if (realMongoUri.getUsername() != null)
				db.authenticate(realMongoUri.getUsername(), realMongoUri.getPassword());
			coll  = db.getCollection("appSession");
			coll.ensureIndex(new BasicDBObject("className", 1));
			coll.ensureIndex(new BasicDBObject("schemaVersion", 1));
			coll.ensureIndex(new BasicDBObject("status", 1));
			coll.ensureIndex(new BasicDBObject("person.id", 1));
			coll.ensureIndex(new BasicDBObject("creationTime", -1));
			coll.ensureIndex(new BasicDBObject("modificationTime", -1));
			coll.ensureIndex(new BasicDBObject("accessTime", -1));
			coll.ensureIndex(new BasicDBObject("ipAddress", 1));
			coll.ensureIndex(new BasicDBObject("ipv6Address", 1));
			coll.ensureIndex(new BasicDBObject("userAgent", 1));
			
			morphia = new Morphia();
			morphia.map(AppSessionImpl.class);
		} catch (Exception e) {
			throw new RuntimeException("Cannot connect to mongo DB "+ realMongoUri.getHosts() +
					" for AppSessionRepository", e);
		}
	}

	@PreDestroy
	public void destroy() {
		log.info("Shutting down AppSessionRepository");
		if (coll != null) {
			coll.getDB().cleanCursors(true);
			coll.getDB().getMongo().close();
		}
	}

	/* (non-Javadoc)
	 * @see tmp.org.soluvas.app.AppSessionDao#getMongoUri()
	 */
	public String getMongoUri() {
		return mongoUri;
	}

	/* (non-Javadoc)
	 * @see tmp.org.soluvas.app.AppSessionDao#findOneByActive(java.lang.String)
	 */
	@Override
	public AppSession findOneByActive(String id) {
		if (id == null)
			return null;
		final DBObject dbo = coll.findOne(new BasicDBObject(ImmutableMap.of(
				"schemaVersion", AppSessionImpl.SCHEMA_VERSION_EDEFAULT,
				"status", AppSessionStatus.ACTIVE.name(),
				"_id", id)));
		log.trace("findOneByActive {} returns {}", id, dbo);
		return new FromDBObject().apply(dbo);
	}

	@Override
	public <S extends AppSession> S add(@Nonnull final S appSession) {
		Preconditions.checkNotNull(appSession, "Cannot add null AppSession");
		Preconditions.checkNotNull(appSession.getId(), "Cannot add AppSession with null ID");
		log.info("Insert AppSession {} for {} with User Agent: {} (dated: {})",
				appSession.getId(),
				appSession.getPerson() != null ? appSession.getPerson().getId() : null,
				appSession.getUserAgent(),
				appSession.getCreationTime() );
		final DBObject obj = new ToDBObject().apply(appSession);
		coll.insert(obj);
		return appSession;
	}

	@Override
	public <S extends AppSession> S modify(@Nonnull final String id, @Nonnull final S appSession) {
		log.debug("Updating AppSession for {} to {} (modificationTime={})",
				id, appSession.getStatus(), appSession.getModificationTime() );
		final DBObject obj = new ToDBObject().apply(appSession);
		coll.update(new BasicDBObject("_id", id), obj, true, false);
		log.info("Updated AppSession for {} to {} (modificationTime={})",
				id, appSession.getStatus(), appSession.getModificationTime() );
		return appSession;
	}

	@Override
	public boolean exists(String id) {
		final long count = coll.count(new BasicDBObject("_id", id));
		return count >= 1;
	}

	@Override
	public List<AppSession> findAll() {
		final DBCursor cursor = coll.find(new BasicDBObject("schemaVersion", AppSessionImpl.SCHEMA_VERSION_EDEFAULT))
				.sort(new BasicDBObject("creationTime", -1));
		final List<AppSession> appSessions = MongoUtils.transform(cursor, new FromDBObject());
		log.debug("findAll returns {} documents", appSessions.size());
		return appSessions;
	}

	@Override
	public long count() {
		return coll.count();
	}

	@SuppressWarnings("unchecked") @Override
	public <S extends AppSession> S findOne(String id) {
		if (id == null)
			return null;
		final Map<String, Object> queryMap = ImmutableMap.<String, Object>of(
				"schemaVersion", AppSessionImpl.SCHEMA_VERSION_EDEFAULT,
				"_id", id);
		final DBCursor cursor = coll.find(new BasicDBObject(queryMap));
		final List<AppSession> appSessions = MongoUtils.transform(cursor, new FromDBObject());
		final AppSession webSession = Iterables.getOnlyElement(appSessions, null);
		log.debug("findOneByAny {} returns {}", id, webSession);
		return (S) webSession;
	}

	@Override @Nullable
	protected String getId(AppSession entity) {
		return entity.getId();
	}

	@Override
	public boolean delete(String id) {
		log.info("Getting Web Session with ID {} ", id);
		final BasicDBObject basicObj = new BasicDBObject();
		basicObj.put("_id", id);
		log.info("Trying to remove Web Session with ID {} ", basicObj.get("_id"));
		coll.remove(basicObj);
		return true;
	}

	@Override
	public List<AppSession> findAllByActive() {
		final Map<String, Object> queryMap = ImmutableMap.<String, Object>of(
				"schemaVersion", AppSessionImpl.SCHEMA_VERSION_EDEFAULT,
				"status", AppSessionStatus.ACTIVE.name());
		final DBCursor cursor = coll.find(new BasicDBObject(queryMap))
				.sort(new BasicDBObject("creationTime", -1));
		final List<AppSession> appSessions = MongoUtils.transform(cursor, new FromDBObject());
		log.debug("findAllByActive returns {} AppSessions", appSessions.size());
		return appSessions;
	}

	@Override
	public boolean touch(String id) {
		final DateTime accessTime = new DateTime();
		log.trace("Touching AppSession {} as {}", id, accessTime);
		coll.update(new BasicDBObject("_id", id),
				new BasicDBObject("$set", new BasicDBObject("accessTime", accessTime.toDate())));
		return true;
	}
	
	protected AppSession fromDbObject(DBObject dbo) {
		return new FromDBObject().apply(dbo);
	}

}

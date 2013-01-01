package org.soluvas.security.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.repository.CrudRepositoryBase;
import org.soluvas.mongo.MongoUtils;
import org.soluvas.security.AppSession;
import org.soluvas.security.AppSessionRepository;
import org.soluvas.security.AppSessionStatus;

import com.google.code.morphia.Morphia;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
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
	private static final Logger log = LoggerFactory.getLogger(MongoAppSessionRepository.class);
	
	private final String mongoUri;
	private final DBCollection coll;
	private final Morphia morphia;
	
	public MongoAppSessionRepository(String mongoUri) {
		super();
		// WARNING: mongoUri may contain password!
		this.mongoUri = mongoUri;
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
	public AppSession findOneByActive(String _id) {
		if (_id == null)
			return null;
		final DBCursor cursor = coll.find(new BasicDBObject(ImmutableMap.of("_id", _id, "status", "active")));
		final AppSession webSession = Iterables.getOnlyElement(MongoUtils.transform(cursor, new Function<DBObject, AppSession>() {
			@Override
			public AppSession apply(DBObject input) {
				return morphia.fromDBObject(AppSession.class, input);
			}
		}), null);
		log.debug("findOneByActive {} returns {}", _id, webSession);
		return webSession;
	}

	@Override
	public <S extends AppSession> S add(@Nonnull final S appSession) {
		log.info("Insert AppSession for {} with User Agent: {} (dated: {})",
				appSession.getPerson().getId(), appSession.getUserAgent(),
				appSession.getCreationTime() );
		final DBObject obj = morphia.toDBObject(appSession);
		coll.insert(obj);
		return appSession;
	}

	@Override
	public <S extends AppSession> S modify(@Nonnull final String id, @Nonnull final S appSession) {
		log.info("Update AppSession for {} to {}({})",
				id, appSession.getStatus(), appSession.getModificationTime() );
		final DBObject obj = morphia.toDBObject(appSession);
		coll.update(new BasicDBObject("_id", id), obj, true, false);
		return appSession;
	}

	@Override
	public boolean exists(String id) {
		final long count = coll.count(new BasicDBObject("_id", id));
		return count >= 1;
	}

	@Override
	public Collection<AppSession> findAll() {
		final DBCursor cursor = coll.find(new BasicDBObject("schemaVersion", AppSessionImpl.SCHEMA_VERSION_EDEFAULT))
				.sort(new BasicDBObject("creationTime", -1));
		final List<AppSession> appSessions = MongoUtils.transform(cursor, new Function<DBObject, AppSession>() {
			@Override
			public AppSession apply(DBObject input) {
				return morphia.fromDBObject(AppSession.class, input);
			}
		});
		log.debug("findAll returns {} documents", appSessions.size());
		return appSessions;
	}

	@Override
	public long count() {
		return coll.count();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <S extends AppSession> S findOne(String id) {
		if (id == null)
			return null;
		final Map<String, Object> queryMap = ImmutableMap.<String, Object>of(
				"schemaVersion", AppSessionImpl.SCHEMA_VERSION_EDEFAULT,
				"_id", id);
		final DBCursor cursor = coll.find(new BasicDBObject(queryMap));
		final List<AppSession> webSessionIterable = MongoUtils.transform(cursor, new Function<DBObject, AppSession>() {
			@Override
			public AppSession apply(DBObject input) {
				return morphia.fromDBObject(AppSession.class, input);
			}
		});
		final AppSession webSession = Iterables.getOnlyElement(webSessionIterable, null);
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
				"status", AppSessionStatus.ACTIVE.getLiteral());
		final DBCursor cursor = coll.find(new BasicDBObject(queryMap))
				.sort(new BasicDBObject("creationTime", -1));
		final List<AppSession> appSessions = MongoUtils.transform(cursor, new Function<DBObject, AppSession>() {
			@Override
			public AppSession apply(DBObject input) {
				return morphia.fromDBObject(AppSession.class, input);
			}
		});
		log.debug("findAllByActive returns {} AppSessions", appSessions.size());
		return appSessions;
	}

}

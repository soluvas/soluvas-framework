package org.soluvas.security;

import java.util.Collection;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.repository.CrudRepositoryBase;
import org.soluvas.mongo.MongoUtils;

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
	
	private String mongoUri;
	private String nameSpace;
	private DBCollection coll;
	private Morphia morphia;
	
	public MongoAppSessionRepository(String mongoUri, String nameSpace) {
		super();
		this.mongoUri = mongoUri;
		this.nameSpace = nameSpace;
	}

	/* (non-Javadoc)
	 * @see tmp.org.soluvas.app.AppSessionDao#init()
	 */
	@Override
	public void init() {
		try {
			log.info("Connecting to MongoDB database {}", mongoUri);
			// connecting to mongoDB
			MongoURI realMongoUri = new MongoURI(mongoUri);
			DB db = realMongoUri.connectDB();
			if (realMongoUri.getUsername() != null)
				db.authenticate(realMongoUri.getUsername(), realMongoUri.getPassword());
			coll  = db.getCollection(getNameSpace() + "Session");
			
			morphia = new Morphia();
			morphia.map(AppSession.class);
		} catch (Exception e) {
			throw new RuntimeException("Cannot connect to mongo DB "+ mongoUri, e);
		}
	}

	/* (non-Javadoc)
	 * @see tmp.org.soluvas.app.AppSessionDao#getNameSpace()
	 */
	@Override
	public String getNameSpace() {
		return nameSpace;
	}

	/* (non-Javadoc)
	 * @see tmp.org.soluvas.app.AppSessionDao#setNameSpace(java.lang.String)
	 */
	@Override
	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}

	/* (non-Javadoc)
	 * @see tmp.org.soluvas.app.AppSessionDao#getMongoUri()
	 */
	@Override
	public String getMongoUri() {
		return mongoUri;
	}

	/* (non-Javadoc)
	 * @see tmp.org.soluvas.app.AppSessionDao#setMongoUri(java.lang.String)
	 */
	@Override
	public void setMongoUri(String mongoUri) {
		this.mongoUri = mongoUri;
	}
	
	/* (non-Javadoc)
	 * @see tmp.org.soluvas.app.AppSessionDao#findOneByActive(java.lang.String)
	 */
	@Override
	public AppSession findOneByActive(String _id) {
		if (_id == null)
			return null;
		DBCursor cursor = coll.find(new BasicDBObject(ImmutableMap.of("_id", _id, "status", "active")));
		AppSession webSession = Iterables.getOnlyElement(MongoUtils.transform(cursor, new Function<DBObject, AppSession>() {
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
		log.info("Insert {} Web Session for {} with User Agent: {} (dated: {})",
				nameSpace, appSession.getPerson().getId(), appSession.getUserAgent(),
				appSession.getCreationTime() );
		final DBObject obj = morphia.toDBObject(appSession);
		coll.insert(obj);
		return appSession;
	}

	@Override
	public <S extends AppSession> S modify(@Nonnull final String id, @Nonnull final S appSession) {
		log.info("Update {} Web Session for {} to {}({})",
				nameSpace, id, appSession.getStatus(),
				appSession.getModificationTime() );
		final DBObject obj = morphia.toDBObject(appSession);
		coll.update(new BasicDBObject("_id", id), obj, true, false);
		return appSession;
	}

	@Override
	public boolean exists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<AppSession> findAll() {
		// TODO Auto-generated method stub
		return null;
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
		final DBCursor cursor = coll.find(new BasicDBObject("_id", id));
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

	@Override
	@Nullable
	protected String getId(AppSession entity) {
		// TODO Auto-generated method stub
		return null;
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

}

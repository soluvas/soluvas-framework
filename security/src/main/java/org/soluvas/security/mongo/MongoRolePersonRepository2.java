package org.soluvas.security.mongo;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Email;
import org.soluvas.commons.impl.EmailImpl;
import org.soluvas.mongo.MongoRepositoryException;
import org.soluvas.mongo.MongoUtils;
import org.soluvas.security.Role2;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.mapping.DefaultCreator;
import com.google.common.base.Function;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClientURI;
import com.mongodb.ReadPreference;
import com.mongodb.WriteResult;

/**
 * @author anisa
 *
 */
public class MongoRolePersonRepository2 implements RolePersonRepository {
	
	private static final Logger log = LoggerFactory.getLogger(MongoRolePersonRepository2.class);
	
	private final String ROLE_PERSON_COLL_NAME = "rolePerson";

	protected Morphia morphia;
	private DBCollection rolePersonColl;
	
	//transform 
	public class DBObjectToEntity implements Function<DBObject, Role2> {
		@Override
		public Role2 apply(DBObject input) {
			if (input == null)
				return null;
			try {
				return morphia.fromDBObject(Role2.class, input);
			} catch (Exception e) {
				throw new MongoRepositoryException(e,
						"%s: Cannot deserialize MongoDB object to %s: %s",
								rolePersonColl.getName(), Role2.class.getName(), input);
			}
		}
	}

	public class EntityToDBObject implements Function<Role2, DBObject> {
		@Override @Nullable
		public DBObject apply(@Nullable Role2 entity) {
			return morphia.toDBObject(entity);
		}
	}
	//
	
	public MongoRolePersonRepository2(final String mongoUri) {
		super();
		
		// WARNING: mongoUri may contain password!
		final MongoClientURI realMongoUri = new MongoClientURI(mongoUri);
		log.info("Connecting to MongoDB role-person repository {}/{} as {}, rolePerson collection={}",
				realMongoUri.getHosts(), realMongoUri.getDatabase(), realMongoUri.getUsername(), ROLE_PERSON_COLL_NAME);
		try {
			final DB db = MongoUtils.getDb(realMongoUri, ReadPreference.primary());
			rolePersonColl = db.getCollection(ROLE_PERSON_COLL_NAME);
			
			morphia = new Morphia();
			morphia.map(Role2.class);
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
			throw new MongoRepositoryException(e, "Cannot connect to MongoDB role-person repository {}/{} as {} for collection '{}'",
					realMongoUri.getHosts(), realMongoUri.getDatabase(), realMongoUri.getUsername(),
					ROLE_PERSON_COLL_NAME);
		}
		
	}

	@Override
	public List<Role2> addAll(List<Role2> upRoleList) {
		final List<DBObject> dbObjects = upRoleList.stream().map(new java.util.function.Function<Role2, DBObject>() {
			@Override
			public DBObject apply(Role2 t) {
				return new EntityToDBObject().apply(t);
			}
		}).collect(Collectors.toList());
		
		final WriteResult result = rolePersonColl.insert(dbObjects);
		log.info("{} role(s) has/have been added", result.getN());
		
		return upRoleList;
	}
	
}

package org.soluvas.security.mongo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Email;
import org.soluvas.commons.impl.EmailImpl;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Sort;
import org.soluvas.mongo.MongoRepositoryException;
import org.soluvas.mongo.MongoUtils;
import org.soluvas.security.Role2;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.mapping.DefaultCreator;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClientURI;
import com.mongodb.ReadPreference;
import com.mongodb.WriteResult;

/**
 * @author anisa
 *
 */
public class MongoRolePersonRepository2 implements RolePersonRepository2 {
	
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

	@Override
	public List<Role2> findAll() {
		final BasicDBObject query = new BasicDBObject();
		final BasicDBObject fields = new BasicDBObject();
		
		final DBCursor dbCursor = rolePersonColl.find(query, fields);
		final List<Role2> roleList = new ArrayList<>();
			final DBObject dbObject = dbCursor.next();
			while (dbCursor.hasNext()) {
			final Role2 role = new DBObjectToEntity().apply(dbObject);
			roleList.add(role);
		}
		log.info("Find all by query '{}' and field '{}' got {} role(s)", query, fields, roleList);
		return roleList;
	}

	@Override
	public Page<Role2> findAll(String searchText, Pageable pageable) {
		final BasicDBObject query;
		if (!Strings.isNullOrEmpty(searchText)) {
			query = getQueryBySearchText(searchText);
		} else {
			query = new BasicDBObject();
		}
		final BasicDBObject fields = new BasicDBObject();
		
		final BasicDBObject sortQuery = MongoUtils.getSort(pageable.getSort(), "modificationTime", Sort.Direction.DESC);
		
		final DBCursor dbCursor = rolePersonColl.find(query, fields, (int) pageable.getOffset(), (int) pageable.getPageSize()).sort(sortQuery);
		final List<Role2> roleList = new ArrayList<>();
		while (dbCursor.hasNext()) {
			final DBObject dbObject = dbCursor.next();
			final Role2 role = new DBObjectToEntity().apply(dbObject);
			roleList.add(role);
		}
		
		final long total = count(searchText);
		return new PageImpl<>(roleList, pageable, total);
		
	}

	@Override
	public long count(String searchText) {
		final BasicDBObject query;
		if (!Strings.isNullOrEmpty(searchText)) {
			query = getQueryBySearchText(searchText);
		} else {
			query = new BasicDBObject();
		}
		return rolePersonColl.count(query);
	}
	
	private BasicDBObject getQueryBySearchText(String searchText) {
		final Pattern regex = Pattern.compile(Pattern.quote(searchText), Pattern.CASE_INSENSITIVE);
		BasicDBObject idQuery = new BasicDBObject("id", regex);
		BasicDBObject nameQuery = new BasicDBObject("name", regex);
		BasicDBObject descriptionQuery = new BasicDBObject("description", regex);
		BasicDBObject query = new BasicDBObject("$or", ImmutableList.of(idQuery, nameQuery , descriptionQuery));
		return query;
	}

	@Override
	public Role2 findOne(String id) {
		final BasicDBObject query = new BasicDBObject();
		query.put("_id", id);
		log.debug("Find One Role by id '{}' - query: {}", id, query);
		final DBObject dbObject = rolePersonColl.findOne(query);
		final Role2 role = new DBObjectToEntity().apply(dbObject);
		return role;
	}
	
}

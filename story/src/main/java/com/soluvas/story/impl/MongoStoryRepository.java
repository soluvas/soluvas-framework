package com.soluvas.story.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.PreDestroy;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.repository.CrudRepositoryBase;
import org.soluvas.mongo.MongoUtils;

import com.google.code.morphia.Morphia;
import com.google.common.base.Function;
import com.google.common.eventbus.EventBus;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoURI;
import com.mongodb.WriteResult;
import com.soluvas.story.Story;
import com.soluvas.story.StoryException;
import com.soluvas.story.StoryRepository;

/**
 * Manage {@link Story} entries.
 * @todo Using storyEntityClasses, the list of story classes is static, and
 * 		requires a specific start order.
 * @author atang
 */
public class MongoStoryRepository extends CrudRepositoryBase<Story, String>
	implements StoryRepository {

	private final Logger log;
	private final String namespace; 
	// set mongo db url
	private final String mongoUri;
	// assign to collections
	private final DBCollection coll;
	private final Morphia morphia;
	/**
	 * Even it's not thread-safe, but the add/remove Class methods are synchronized. 
	 */
	private final Set<Class<?>> mappedClasses = new HashSet<Class<?>>();
	private final EventBus eventBus;
	
	public MongoStoryRepository(String mongoUri, String namespace, EventBus eventBus) {
		super();
		this.mongoUri = mongoUri;
		this.namespace = namespace;
		this.eventBus = eventBus;
		
		// connecting to mongoDB
		// WARNING: mongoUri may contain password!
		final MongoURI realMongoUri = new MongoURI(mongoUri);
		log = LoggerFactory.getLogger(MongoStoryRepository.class.getName() + "/" + realMongoUri.getDatabase());
		log.info("Connecting to MongoDB database {}/{} as {} for {} Story Repository", 
				realMongoUri.getHosts(), realMongoUri.getDatabase(), realMongoUri.getUsername(), namespace);
		try {
			final DB db = realMongoUri.connectDB();
			if (realMongoUri.getUsername() != null)
				db.authenticate(realMongoUri.getUsername(), realMongoUri.getPassword());
			coll = db.getCollection(getNamespace() + "Story");
			coll.ensureIndex(new BasicDBObject("className", 1));
			coll.ensureIndex(new BasicDBObject("subject", 1));
			coll.ensureIndex(new BasicDBObject("kind", 1));
			coll.ensureIndex(new BasicDBObject("publicized", 1));
			coll.ensureIndex(new BasicDBObject("creationTime", -1));
			coll.ensureIndex(new BasicDBObject("modificationTime", -1));
			
			mappedClasses.add(StoryImpl.class);
//			mappedClasses.addAll((Collection) storyEntityClasses);
			morphia = createMorphia();
//			morphia.map(Story.class);
//			morphia.map(storyEntityClasses.toArray(new Class[] {}));
//			morphia.map(PersonLikeProduct.class);
//			morphia.map(PersonLikeShop.class);
//			morphia.map(PersonCommentProduct.class);
//			morphia.map(PersonBookProduct.class);
//			morphia.map(PersonConfirmProduct.class);
//			morphia.map(PersonCancelProduct.class);
//			morphia.map(PersonBuyProduct.class);
//			morphia.map(PersonExpiredBookProduct.class);
//			morphia.map(WinkStory.class);
		} catch (Exception e) {
			throw new RuntimeException("Cannot connect to MongoDB "+ realMongoUri.getHosts() +
					" for " + namespace + " Story Repository", e);
		} 
		
	}
	
	public MongoStoryRepository(String mongoUri, String namespace) {
		this(mongoUri, namespace, new EventBus(MongoStoryRepository.class.getName() + "_" + namespace));
	}
	
	public class DBObjectToStory implements Function<DBObject, Story> {
		@Override
		public Story apply(DBObject input) {
			//return new Story(input);
			return morphia.fromDBObject(Story.class, input);
		}
	}
	
	protected Morphia createMorphia() {
		log.debug("Creating {} Story Morphia with {} mapped classes: {}", namespace,
				mappedClasses.size(), mappedClasses);
		final Morphia morphia = new Morphia();
		morphia.map(mappedClasses.toArray(new Class[] {}));
		return morphia;
	}
	
	@PreDestroy
	public void destroy() {
		log.info("Shutting down {} MongoStoryRepo", namespace);
		if (coll != null) {
			coll.getDB().cleanCursors(true);
			coll.getDB().getMongo().close();
		}
	}
	
	/**
	 * Add a mapped {@link Class}.
	 * @param clazz
	 */
	public synchronized void addClasses(@Nonnull final Collection<Class<?>> clazzes) {
		log.info("Adding {} mapped class(es): {}", clazzes.size(), clazzes);
		mappedClasses.addAll(clazzes);
		createMorphia();
	}
	
	/**
	 * Add a mapped {@link Class}.
	 * @param clazz
	 */
	public synchronized void removeClasses(@Nonnull final Collection<Class<?>> clazzes) {
		log.info("Removing {} mapped class(es): {}", clazzes.size(), clazzes);
		mappedClasses.removeAll(clazzes);
		createMorphia();
	}
	
	public String getMongoUri() {
		return mongoUri;
	}

	@Override
	public <S extends Story> S findOne(String id) {
		final BasicDBObject query = new BasicDBObject();
		query.put("_id", id);
		query.put("schemaVersion", StoryImpl.SCHEMA_VERSION_EDEFAULT);
		
		final DBObject story = coll.findOne(query);
		log.debug("Find one story by id is {}: {}", id, story);
		return story != null ? (S) morphia.fromDBObject(Story.class, story) : null;
	}
	
//	@Override
//	public PersonCommentProduct findOneByCommentId(String commentId) {
//		final DBObject story = coll.findOne(new BasicDBObject("commentId", commentId));
//		log.debug("Find one story by comment id is {}: {}", commentId, story);
//		return morphia.fromDBObject(PersonCommentProduct.class, story);				
//	}
	
	@Override
	public List<Story> findAll() {
		final BasicDBObject query = new BasicDBObject("schemaVersion", StoryImpl.SCHEMA_VERSION_EDEFAULT);
		final DBCursor cursor = coll.find(query).sort(new BasicDBObject("modificationTime", -1));
		final List<Story> stories = MongoUtils.transform(cursor, new DBObjectToStory());
		log.debug("findAll {} returns {} stories", getNamespace(), stories.size());
//		final List<String> storySummaries = Lists.transform(stories, new Function<Story, String>() {
//			@Override
//			public String apply(Story input) {
//				return input.getKind() + " " + input.getId();
//			}
//		});
		return stories;
	}

//	@Override
//	public List<Story> findBySubjectStatus(String subject, com.soluvas.story.OldStory.Status status) {
//		BasicDBObject query = new BasicDBObject();
//		query.put("subject", subject);
//		query.put("status", Pattern.compile(status.name(), Pattern.CASE_INSENSITIVE)); // TODO: standardize enum in MongoDB!
//		
//		final DBCursor cursor = coll.find(query).sort(new BasicDBObject("created", -1));
//		final List<Story> stories = MongoUtils.transform(cursor, new DBObjectToStory());
//		log.debug("findBySubjectStatus {} subject={} status={} returned {} stories",
//				getNamespace(), subject, status, stories.size() );
//		List<String> storySummaries = Lists.transform(stories, new Function<Story, String>() {
//			@Override
//			public String apply(Story input) {
//				return input.getKind() + " " + input.getId();
//			}
//		});
//		
//		log.debug("findBySubject {} returns {} documents: {}",
//				subject, stories.size(), storySummaries );
//		return stories;
//	}

//	@Override
//	public List<Story> findBySubject(String subject) {
//		final DBCursor cursor = coll.find(new BasicDBObject("subject", subject));
//		log.debug("Cursor {}", cursor);
//		final List<Story> stories = MongoUtils.transform(cursor, new DBObjectToStory());
//		final List<String> storySummaries = Lists.transform(stories, new Function<Story, String>() {
//			@Override
//			public String apply(Story input) {
//				return input.getKind() + " " + input.getId();
//			}
//		});
//		
//		log.debug("findBySubject {} returns {} documents: {}",
//				subject, stories.size(), storySummaries );
//		return stories;
//	}
	
	public String getNamespace() {
		return namespace;
	}

//	@Override
//	public void upsert(Story story) {
//		log.info("Update {} Story about {}: {}",
//				namespace, story.getSubject(), story );
//		final DBObject obj = morphia.toDBObject(story);
//		log.debug("Upsert {} {}: {}",
//				namespace, story.getId(), obj );
//		coll.update(new BasicDBObject("_id", story.getId()), obj, true, false);
//	}
	
	@Override
	public String toString() {
		return String.format("MongoStoryRepository [namespace=%s]", namespace);
	}

	@Override
	public <S extends Story> S add(S story) {
		log.info("Add {} Story for {} about {} {} {} [{}]",
				namespace, story.getOwner(), story.getSubject(), story.getAction(), story.getReceiver(), story.getId() );
		final S added = EcoreUtil.copy(story);
		added.getSubject().setTargetType(null);
		if (added.getReceiver() != null)
			added.getReceiver().setTargetType(null);
		final DBObject obj = morphia.toDBObject(added);
		log.debug("Adding {} {}: {}", namespace, story.getId(), obj);
		final WriteResult result = coll.insert(obj);
		if (result.getLastError().getException() != null) {
			throw new StoryException("Cannot add " + namespace + " Story " + story.getId() + " for " + story.getOwner(), result.getLastError().getException() );
		}
		return added;
	}

	@Override
	public <S extends Story> S modify(String id, S entity) {
		log.info("Update {} Story about {}: {}", namespace, entity.getSubject(), entity );
		final DBObject obj = morphia.toDBObject(entity);
		log.debug("Upsert {} {}: {}",
				namespace, entity.getId(), obj );
		coll.update(new BasicDBObject("_id", id), obj, true, false);
		
		return entity;
	}

	@Override
	public boolean exists(String id) {
		final BasicDBObject query = new BasicDBObject();
		query.put("_id", id);
		query.put("schemaVersion", StoryImpl.SCHEMA_VERSION_EDEFAULT);
		final long count = coll.count(query);
		log.debug("Count {} story by id is {}: {}", namespace, id, count);
		return count >= 1;
	}

	@Override
	public boolean delete(String id) {
		final BasicDBObject basicObj = new BasicDBObject("_id", id);
		log.info("Deleting {} story {} ", id);
		final WriteResult writeResult = coll.remove(basicObj);
		if (writeResult.getLastError().getException() != null) {
			throw new StoryException("Cannot delete " + namespace + " Story " + id, writeResult.getLastError().getException() );
		}
		return true;
	}

	@Override
	public long count() {
		return coll.count();
	}

	@Override @Nullable
	protected String getId(Story entity) {
		return entity.getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <S extends Story> S findOneByPartialId(String partialId) {
		log.trace("findOneByPartialId {} Story {}", namespace, partialId);
		final Pattern pattern = Pattern.compile(Pattern.quote(partialId) + ".*", Pattern.CASE_INSENSITIVE);
		final BasicDBObject query = new BasicDBObject();
		query.put("_id", pattern);
		query.put("schemaVersion", StoryImpl.SCHEMA_VERSION_EDEFAULT);
		
		final DBObject story = coll.findOne(query);
		log.debug("Find one story by partial ID {} is {}: {}", partialId, story);
		return story != null ? (S) morphia.fromDBObject(Story.class, story) : null;
	}

	@Override
	public List<Story> findAllByOwnerId(String ownerId) {
		final BasicDBObject query = new BasicDBObject();
		query.put("owner.id", ownerId);
		query.put("schemaVersion", StoryImpl.SCHEMA_VERSION_EDEFAULT);
		final DBCursor cursor = coll.find(query).sort(new BasicDBObject("creationTime", -1));
		final List<Story> stories = MongoUtils.transform(cursor, new DBObjectToStory());
		log.debug("findAllByOwnerId {} {} returns {} stories", getNamespace(), ownerId, stories.size());
		return stories;
	}

}

package com.soluvas.story;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.mongo.MongoUtils;

import com.google.code.morphia.Morphia;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoURI;
import com.mongodb.WriteResult;

/**
 * Manage {@link Story} entries.
 * @todo Using storyEntityClasses, the list of story classes is static, and
 * 		requires a specific start order.
 * @author atang
 */
public class MongoStoryDao implements StoryDao {

	// Logger adalah kelas yang berguna untuk membuat file log
	private static final Logger log = LoggerFactory.getLogger(MongoStoryDao.class);
	private final String namespace; 
	// set mongo db url
	private final String mongoUri;
	// assign to collections
	private final DBCollection coll;
	private volatile Morphia morphia;
	/**
	 * Even it's not thread-safe, but the add/remove Class methods are synchronized. 
	 */
	private final Set<Class<?>> mappedClasses = new HashSet<Class<?>>();
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MongoStoryDao(String mongoUri, String namespace, Collection<Class> storyEntityClasses) {
		super();
		this.mongoUri = mongoUri;
		this.namespace = namespace;
		
		// connecting to mongoDB
		// WARNING: mongoUri may contain password!
		final MongoURI realMongoUri = new MongoURI(mongoUri);
		log.info("Connecting to MongoDB database {} for {} Story DAO", realMongoUri.getHosts(), namespace);
		try {
			final DB db = realMongoUri.connectDB();
			if (realMongoUri.getUsername() != null)
				db.authenticate(realMongoUri.getUsername(), realMongoUri.getPassword());
			coll = db.getCollection(getNamespace() + "Story");
			coll.ensureIndex(new BasicDBObject("className", 1));
			coll.ensureIndex(new BasicDBObject("subject", 1));
			coll.ensureIndex(new BasicDBObject("kind", 1));
			coll.ensureIndex(new BasicDBObject("publicized", 1));
			coll.ensureIndex(new BasicDBObject("created", -1));
			
			mappedClasses.add(Story.class);
			mappedClasses.addAll((Collection) storyEntityClasses);
			recreateMorphia();
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
			throw new RuntimeException("Cannot connect to mongo DB "+ realMongoUri.getHosts() +
					" for " + namespace + " Story DAO", e);
		} 
		
	}
	
	public class DBObjectToStory implements Function<DBObject, Story> {
		@Override
		public Story apply(DBObject input) {
			//return new Story(input);
			return morphia.fromDBObject(Story.class, input);
		}
	}
	
	public void recreateMorphia() {
		log.debug("Recreating {} Story Morphia with {} mapped classes: {}", namespace,
				mappedClasses.size(), mappedClasses);
		final Morphia morphia = new Morphia();
		morphia.map(mappedClasses.toArray(new Class[] {}));
		this.morphia = morphia;
	}
	
	/* (non-Javadoc)
	 * @see com.soluvas.story.StoryDao#destroy()
	 */
	@PreDestroy
	public void destroy() {
		log.info("Shutting down {} MongoStoryDao", namespace);
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
		recreateMorphia();
	}
	
	/**
	 * Add a mapped {@link Class}.
	 * @param clazz
	 */
	public synchronized void removeClasses(@Nonnull final Collection<Class<?>> clazzes) {
		log.info("Removing {} mapped class(es): {}", clazzes.size(), clazzes);
		mappedClasses.removeAll(clazzes);
		recreateMorphia();
	}
	
	/* (non-Javadoc)
	 * @see com.soluvas.story.StoryDao#getMongoUri()
	 */
	@Override
	public String getMongoUri() {
		return mongoUri;
	}

	/* (non-Javadoc)
	 * @see com.soluvas.story.StoryDao#findOne(java.lang.String)
	 */
	@Override
	public Story findOne(String _id) {
		final BasicDBObject query = new BasicDBObject();
		query.put("_id", _id);
		
		final DBObject story = coll.findOne(query);
		log.debug("Find one story by id is {}: {}", _id, story);
		return morphia.fromDBObject(Story.class, story);
	}
	
	/* (non-Javadoc)
	 * @see com.soluvas.story.StoryDao#findOneByCommentId(java.lang.String)
	 */
//	@Override
//	public PersonCommentProduct findOneByCommentId(String commentId) {
//		final DBObject story = coll.findOne(new BasicDBObject("commentId", commentId));
//		log.debug("Find one story by comment id is {}: {}", commentId, story);
//		return morphia.fromDBObject(PersonCommentProduct.class, story);				
//	}
	
	/* (non-Javadoc)
	 * @see com.soluvas.story.StoryDao#findAll()
	 */
	@Override
	public List<Story> findAll() {
		final DBCursor cursor = coll.find().sort(new BasicDBObject("created", -1));
		final List<Story> stories = MongoUtils.transform(cursor, new DBObjectToStory());
		log.trace("findAll {} returns {} stories",
				getNamespace(), stories.size() );
		final List<String> storySummaries = Lists.transform(stories, new Function<Story, String>() {
			@Override
			public String apply(Story input) {
				return input.getKind() + " " + input.getId();
			}
		});
		log.debug("findAll {} returns {} stories: {}",
				namespace, stories.size(), storySummaries );
		return stories;
	}

	/* (non-Javadoc)
	 * @see com.soluvas.story.StoryDao#findBySubjectStatus(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Story> findBySubjectStatus(String subject, com.soluvas.story.OldStory.Status status) {
		BasicDBObject query = new BasicDBObject();
		query.put("subject", subject);
		query.put("status", Pattern.compile(status.name(), Pattern.CASE_INSENSITIVE)); // TODO: standardize enum in MongoDB!
		
		final DBCursor cursor = coll.find(query).sort(new BasicDBObject("created", -1));
		final List<Story> stories = MongoUtils.transform(cursor, new DBObjectToStory());
		log.debug("findBySubjectStatus {} subject={} status={} returned {} stories",
				getNamespace(), subject, status, stories.size() );
		List<String> storySummaries = Lists.transform(stories, new Function<Story, String>() {
			@Override
			public String apply(Story input) {
				return input.getKind() + " " + input.getId();
			}
		});
		
		log.debug("findBySubject {} returns {} documents: {}",
				subject, stories.size(), storySummaries );
		return stories;
	}

	/* (non-Javadoc)
	 * @see com.soluvas.story.StoryDao#findBySubject(java.lang.String)
	 */
	@Override
	public List<Story> findBySubject(String subject) {
		final DBCursor cursor = coll.find(new BasicDBObject("subject", subject));
		log.debug("Cursor {}", cursor);
		final List<Story> stories = MongoUtils.transform(cursor, new DBObjectToStory());
		final List<String> storySummaries = Lists.transform(stories, new Function<Story, String>() {
			@Override
			public String apply(Story input) {
				return input.getKind() + " " + input.getId();
			}
		});
		
		log.debug("findBySubject {} returns {} documents: {}",
				subject, stories.size(), storySummaries );
		return stories;
	}
	
	/* (non-Javadoc)
	 * @see com.soluvas.story.StoryDao#getNamespace()
	 */
	@Override
	public String getNamespace() {
		return namespace;
	}

	/* (non-Javadoc)
	 * @see com.soluvas.story.StoryDao#upsert(com.soluvas.story.Story)
	 */
	@Override
	public void upsert(Story story) {
		log.info("Update {} Story about {}: {}",
				namespace, story.getSubject(), story );
		final DBObject obj = morphia.toDBObject(story);
		log.debug("Upsert {} {}: {}",
				namespace, story.getId(), obj );
		coll.update(new BasicDBObject("_id", story.getId()), obj, true, false);
	}
	
	/* (non-Javadoc)
	 * @see com.soluvas.story.StoryDao#insert(com.soluvas.story.Story)
	 */
	@Override
	public void insert(Story story) {
		log.info("Insert {} Story about {}: {}",
				namespace, story.getSubject(), story );
		final DBObject obj = morphia.toDBObject(story);
		log.debug("Inserting {} {}: {}",
				namespace, story.getId(), obj );
		final WriteResult result = coll.insert(obj);
		if (result.getLastError().getException() != null) {
			throw new RuntimeException("Cannot insert " + namespace + " Story " + story.getKind() + " for " + story.getSubject(), result.getLastError().getException() );
		}
	}

	/* (non-Javadoc)
	 * @see com.soluvas.story.StoryDao#toString()
	 */
	@Override
	public String toString() {
		return String.format("MongoStoryDao [namespace=%s, mongoUri=%s]", namespace,
				mongoUri);
	}
	
}

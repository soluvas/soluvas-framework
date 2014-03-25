package com.soluvas.story.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.mongo.MongoRepositoryBase;

import com.google.code.morphia.Morphia;
import com.google.common.base.Function;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.soluvas.story.Story;
import com.soluvas.story.StoryRepository;

/**
 * Manage {@link Story} entries.
 * @todo Using storyEntityClasses, the list of story classes is static, and
 * 		requires a specific start order.
 * @author atang
 */
public class MongoStoryRepository extends MongoRepositoryBase<Story>
	implements StoryRepository {

	private static final Logger log = LoggerFactory
			.getLogger(MongoStoryRepository.class);
	
	/**
	 * Even it's not thread-safe, but the add/remove Class methods are synchronized. 
	 */
	private final Set<Class<?>> mappedClasses = new HashSet<>();

	private final String namespace;
	
	private static class IndexMap {
		
		public IndexMap() {
			super();
		}
		
		public static Map<String, Integer> getIndexMap() {
			final Map<String, Integer> indexMap = new HashMap<>();
			indexMap.put("className", 1);
			indexMap.put("subject", 1);
			indexMap.put("kind", 1);
			indexMap.put("publicized", 1);
			indexMap.put("creationTime", -1);
			indexMap.put("modificationTime", -1);
			return indexMap;
		}
		
	}
	
	public MongoStoryRepository(String mongoUri, String namespace, boolean migrationEnabled, boolean autoExplainSlow) {
		super(Story.class, StoryImpl.class, StoryImpl.SCHEMA_VERSION_EDEFAULT, mongoUri, ReadPattern.PRIMARY_PREFERRED,
				namespace + "Story", null, IndexMap.getIndexMap(), migrationEnabled, autoExplainSlow);
		this.namespace = namespace;
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

	public String getNamespace() {
		return namespace;
	}
	
	@Override
	public String toString() {
		return String.format("MongoStoryRepository [namespace=%s]", namespace);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <S extends Story> S findOneByPartialId(String partialId) {
		log.trace("findOneByPartialId {} Story {}", namespace, partialId);
		final Pattern pattern = Pattern.compile(Pattern.quote(partialId) + ".*", Pattern.CASE_INSENSITIVE);
		final BasicDBObject query = new BasicDBObject();
		query.put("_id", pattern);
		query.put("schemaVersion", StoryImpl.SCHEMA_VERSION_EDEFAULT);
		
		final DBObject story = findOnePrimary(query, null, "findOneByPartialId", partialId);
		log.debug("Find one story by partial ID {} is {}: {}", partialId, story);
		return story != null ? (S) morphia.fromDBObject(Story.class, story) : null;
	}

	@Override
	public List<Story> findAllByOwnerId(String ownerId) {
		final BasicDBObject query = new BasicDBObject();
		query.put("owner.id", ownerId);
		query.put("schemaVersion", StoryImpl.SCHEMA_VERSION_EDEFAULT);
		final List<Story> stories = findPrimary(query, null, new BasicDBObject("creationTime", -1), 0, 0, "findAllByOwnerId", ownerId);
//		final DBCursor cursor = coll.find(query).sort();
//		final List<Story> stories = MongoUtils.transform(cursor, new DBObjectToStory());
		log.debug("findAllByOwnerId {} {} returns {} stories", getNamespace(), ownerId, stories.size());
		return stories;
	}

}

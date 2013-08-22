package org.soluvas.mongo;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.data.domain.Sort.Order;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * @author ceefour
 *
 */
public class MongoUtils {
	
	private static final Logger log = LoggerFactory.getLogger(MongoUtils.class);
	/**
	 * Singleton {@link MongoClient} instances so we can effectively limit to 11 connections per webapp
	 * (regardless of number of {@link MongoRepositoryBase} repositories).
	 * <p>Note: This does cause a "memory leak" but in practice it should not matter. 
	 */
	private static final Map<String, MongoClient> mongoClients = new HashMap<>();

	/**
	 * Use {@link #getMongoDb(MongoClientURI, String)} instead.
	 * To prevent accidental call to {@link MongoClient#close()}, this method is marked {@code protected}.
	 * @param realMongoUri
	 * @return
	 * @throws UnknownHostException
	 */
	protected static MongoClient getClient(MongoClientURI realMongoUri) throws UnknownHostException {
		final String mongoUriStr = realMongoUri.getURI();
		if (mongoClients.containsKey(mongoUriStr)) {
			final MongoClient client = mongoClients.get(mongoUriStr);
			log.debug("Returning existing MongoClient {} for {}/{} as {}", 
					client, realMongoUri.getHosts(), realMongoUri.getDatabase(), realMongoUri.getUsername());
			return client;
		} else {
			final MongoClient client = new MongoClient(realMongoUri);
			log.info("Instatiating new MongoClient {} for {}/{} as {}", 
					client, realMongoUri.getHosts(), realMongoUri.getDatabase(), realMongoUri.getUsername());
			mongoClients.put(mongoUriStr, client);
			return client;
		}
	}
	
	/**
	 * Use {@link #getMongoDb(MongoClientURI, String)} instead.
	 * To prevent accidental call to {@link MongoClient#close()}, this method is marked {@code protected}.
	 * @param mongoUri
	 * @return
	 * @throws UnknownHostException
	 */
	protected static synchronized MongoClient getClient(String mongoUri) throws UnknownHostException {
		return getClient(new MongoClientURI(mongoUri));
	}
	
	/**
	 * Gets a {@link DB} with dbname corresponding to {@link MongoClientURI#getDatabase()},
	 * reusing a single {@link MongoClient}.
	 * @param realMongoUri
	 * @return
	 * @throws UnknownHostException
	 */
	public static DB getDb(MongoClientURI realMongoUri) throws UnknownHostException {
		final MongoClient client = getClient(realMongoUri);
		final String dbname = Preconditions.checkNotNull(realMongoUri.getDatabase(), "MongoURI must contain dbname part");
		return client.getDB(dbname);
	}
	
	/**
	 * Wrap MongoDB {@link DBCursor} results in immutable {@link List},
	 * and closes the cursor.
	 * @param cursor
	 * @return
	 */
	public static List<? extends DBObject> asList(DBCursor cursor) {
		try (DBCursor cur = cursor) {
			return ImmutableList.copyOf((Iterable<? extends DBObject>) cur);
		}
	}
	
	/**
	 * Transforms MongoDB {@link DBCursor} results using a {@link Function}, wraps
	 * the results in immutable {@link List}, and closes the cursor.
	 * @param cursor
	 * @param transformer Transform function.
	 * @return
	 */
	public static <T> List<T> transform(DBCursor cursor, Function<DBObject, T> transformer) {
		try (DBCursor cur = cursor) {
			return ImmutableList.copyOf( Iterables.transform(cur, transformer) );
		}
	}
	
	public static BasicDBObject getSort(@Nullable Sort sort) {
		final BasicDBObject sortObj = new BasicDBObject();
		if (sort != null) {
			for (final Order order : sort) {
				sortObj.put(order.getProperty(), order.getDirection() == Direction.DESC ? -1 : 1);
			}
		}
		return sortObj;
	}
	
	public static BasicDBObject getSort(@Nullable Sort sort, String defaultSortField, int defaultSortOrder) {
		final BasicDBObject sortObj = getSort(sort);
		if (!sortObj.containsField(defaultSortField)) {
			sortObj.put(defaultSortField, defaultSortOrder);
		}
		return sortObj;
	}
	
	/**
	 * Ensure unique index(es) on MongoDB collection, with logging.
	 * If an index already exist but not unique, it will drop and recreate the index with <code>{unique: true}</code>.
	 * <p>Usage:
	 * <pre>{@literal
	 * MongoUtils.ensureUnique(coll, "canonicalSlug");
	 * }</pre>
	 * @return Ensured index names (including existing ones).
	 */
	public static List<String> ensureUnique(DBCollection coll, String... fields) {
		log.debug("Ensuring collection {} has {} unique indexes: {}", 
				coll.getName(), fields.length, fields);
		final List<String> ensuredNames = new ArrayList<>();
		if (fields.length > 0) {
			final List<DBObject> indexes = coll.getIndexInfo();
			for (String field : fields) {
				final String name = field + "_1";
				final Optional<DBObject> existing = Iterables.tryFind(indexes, new Predicate<DBObject>() {
					@Override
					public boolean apply(@Nullable DBObject input) {
						return name.equals(input.get("name"));
					}
				});
				if (existing.isPresent() && !existing.get().containsField("unique")) {
					log.trace("Dropping non-unique index {} from {}", name, coll.getName());
					coll.dropIndex(name);
					log.info("Dropped non-unique index {} from {}", name, coll.getName());
				}
				coll.ensureIndex(new BasicDBObject(field, 1), new BasicDBObject("unique", true));
				ensuredNames.add(name);
			}
		}
		return ensuredNames;
	}
	
	/**
	 * Ensure indexes on MongoDB collection, with logging.
	 * <p>Usage:
	 * <pre>{@literal
	 * MongoUtils.ensureIndexes(coll, ImmutableMap.of("creationTime", -1, "modificationTime", -1);
	 * }</pre>
	 * @return 
	 * @return Ensured index names (including existing ones).
	 */
	public static List<String> ensureIndexes(DBCollection coll, 
			final Map<String, Integer> fields) {
		final List<String> ensuredNames = new ArrayList<>();
		log.debug("Ensuring collection {} has {} indexes: {}", 
				coll.getName(), fields.size(), fields);
		for (final Map.Entry<String, Integer> entry : fields.entrySet()) {
			coll.ensureIndex(new BasicDBObject(entry.getKey(), entry.getValue()));
			ensuredNames.add(entry.getKey() + "_" + entry.getValue());
		}
		return ensuredNames;
	}
	
	/**
	 * Drop the specified indexes if not already existing in collection.
	 * <p>Usage:
	 * <pre>MongoUtils.dropIndexesIfNotExist(coll, "formalId_-1", "status_1", "className_1");</pre>
	 * @param coll
	 * @param indexNames
	 */
	public static void dropIndexesIfNotExist(DBCollection coll,
			final String... indexNames) {
		log.debug("Dropping {} indexes from collection {} if not exists: {}", 
				indexNames.length, coll.getName(), indexNames);
		final List<DBObject> indexes = coll.getIndexInfo();
		for (final String indexName : indexNames) {
			final Optional<DBObject> existing = Iterables.tryFind(indexes, new Predicate<DBObject>() {
				@Override
				public boolean apply(@Nullable DBObject input) {
					return indexName.equals(input.get("name"));
				}
			});
			if (existing.isPresent()) {
				log.debug("Dropping index {} from {}", indexName, coll.getName());
				coll.dropIndex(indexName);
				log.info("Dropped index {} from {}", indexName, coll.getName());
			}
		}
	}
	
	/**
	 * Drop all indexes except the specified ones.
	 * 
	 * <p>Usage:
	 * 
	 * <pre>{@literal
	 * final List<String> ensuredIndexes = new ArrayList<>();
	 * ensuredIndexes.addAll( MongoUtils.ensureUnique(coll, uniqueFields.toArray(new String[] {})) );
	 * ensuredIndexes.addAll( MongoUtils.ensureIndexes(coll, indexedFields) );
	 * MongoUtils.retainIndexes(coll, ensuredIndexes.toArray(new String[] {}));
	 * }</pre>
	 * 
	 * @param coll
	 * @param retaineds
	 */
	public static void retainIndexes(DBCollection coll,
			final String... retaineds) {
		log.debug("Dropping indexes from collection {} except {}: {}", 
				coll.getName(), retaineds.length, retaineds);
		final List<DBObject> indexes = coll.getIndexInfo();
		final List<String> existingNames = Lists.transform(indexes, new Function<DBObject, String>() {
			@Override @Nullable
			public String apply(@Nullable DBObject input) {
				return (String) input.get("name");
			}
		});
		final Set<String> existingNameSet = new HashSet<>(existingNames);
		existingNameSet.remove("_id_"); // the _id_ index can't be deleted anyway
		final Set<String> indexesToDelete = ImmutableSet.copyOf(Sets.difference(existingNameSet, ImmutableSet.copyOf(retaineds)));
		if (!indexesToDelete.isEmpty()) {
			log.debug("Dropping {} indexes from collection {}: {}", 
					indexesToDelete.size(), coll.getName(), indexesToDelete);
			for (final String indexToDelete : indexesToDelete) {
				coll.dropIndex(indexToDelete);
			}
			log.info("Dropped {} indexes from collection {}: {}", 
					indexesToDelete.size(), coll.getName(), indexesToDelete);
		}
	}

}

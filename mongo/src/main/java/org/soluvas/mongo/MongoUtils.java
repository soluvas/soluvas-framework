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
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.ReadPreference;

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
	 * <p>Entry: "{readPreference}:{uri}" -> MongoClient 
	 */
	private static final Map<String, MongoClient> mongoClients = new HashMap<>();

	/**
	 * Use {@link #getMongoDb(MongoClientURI, String)} instead.
	 * To prevent accidental call to {@link MongoClient#close()}, this method is marked {@code protected}.
	 * @param realMongoUri
	 * @param readPreference 
	 * @return
	 * @throws UnknownHostException
	 */
	protected static synchronized MongoClient getClient(MongoClientURI realMongoUri, ReadPreference readPreference) throws UnknownHostException {
		final String key = readPreference + ":" + realMongoUri.getURI();
		if (mongoClients.containsKey(key)) {
			final MongoClient client = mongoClients.get(key);
			log.debug("Reusing existing MongoClient {} for {}:{}/{} as {}", 
					client, readPreference, realMongoUri.getHosts(), realMongoUri.getDatabase(), realMongoUri.getUsername());
			return client;
		} else {
			final MongoClientOptions.Builder optionsBuilder = MongoClientOptions.builder().readPreference(readPreference);
			final MongoClientURI optionsMongoUri = new MongoClientURI(realMongoUri.toString(), optionsBuilder);
			final MongoClient client = new MongoClient(optionsMongoUri);
			log.info("Instantiating new MongoClient {} for {}:{}/{} as {}", 
					client, readPreference, optionsMongoUri.getHosts(), optionsMongoUri.getDatabase(), optionsMongoUri.getUsername());
			mongoClients.put(key, client);
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
//	protected static synchronized MongoClient getClient(String mongoUri) throws UnknownHostException {
//		return getClient(new MongoClientURI(mongoUri));
//	}
	
	/**
	 * Gets a {@link DB} with dbname corresponding to {@link MongoClientURI#getDatabase()},
	 * reusing a single {@link MongoClient},
	 * using {@link ReadPreference#primaryPreferred()} (which works in failover situations).
	 * @param realMongoUri
	 * @return
	 * @throws UnknownHostException
	 * @deprecated Use {@link #getDb(MongoClientURI, ReadPreference)}
	 */
	@Deprecated
	public static DB getDb(MongoClientURI realMongoUri) throws UnknownHostException {
		return getDb(realMongoUri, ReadPreference.primaryPreferred());
	}
	
	/**
	 * Gets a {@link DB} with dbname corresponding to {@link MongoClientURI#getDatabase()},
	 * reusing a single {@link MongoClient}, with custom {@link ReadPreference}.
	 * <p>Note: You must {@link DB#authenticate(String, char[])} yourself.
	 * @param realMongoUri
	 * @param readPreference {@link ReadPreference} for the pooled {@link MongoClient} of this DB.
	 * 		For most repositories you'll use {@link ReadPreference#secondaryPreferred()}.
	 * 		No tag set is needed unless you actually want to target specific secondary servers.
	 * @return
	 * @throws UnknownHostException
	 */
	public static DB getDb(MongoClientURI realMongoUri, ReadPreference readPreference) throws UnknownHostException {
		final MongoClient client = getClient(realMongoUri, readPreference);
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
	
	/**
	 * Gets the MongoDB sort {@link BasicDBObject} without specifying default sort.
	 * @param sort
	 * @return
	 */
	public static BasicDBObject getSort(@Nullable Sort sort) {
		final BasicDBObject sortObj = new BasicDBObject();
		if (sort != null) {
			for (final Order order : sort) {
				sortObj.put(order.getProperty(), order.getDirection() == Direction.DESC ? -1 : 1);
			}
		}
		return sortObj;
	}
	
	/**
	 * Gets the MongoDB sort {@link BasicDBObject} with specifying default sort.
	 * @param sort
	 * @param defaultSortField Default sort field, used only if {@code sort} is {@code null}.
	 * @param defaultSortOrder Default sort order, used only if {@code sort} is {@code null}.
	 * @return
	 * @deprecated Use {@link #getSort(Sort, String, Direction)}.
	 */
	@Deprecated
	public static BasicDBObject getSort(@Nullable Sort sort, String defaultSortField, int defaultSortOrder) {
		return getSort(sort, defaultSortField, defaultSortOrder == 1 ? Direction.ASC : Direction.DESC);
	}
	
	/**
	 * Gets the MongoDB sort {@link BasicDBObject} with specifying default sort.
	 * @param sort
	 * @param defaultSortField Default sort field, used only if {@code sort} is {@code null}.
	 * @param defaultSortOrder Default sort order, used only if {@code sort} is {@code null}.
	 * @return
	 */
	public static BasicDBObject getSort(@Nullable Sort sort, String defaultSortField, Sort.Direction defaultSortOrder) {
		if (sort != null) {
			return getSort(sort);
		} else {
			return new BasicDBObject(defaultSortField, defaultSortOrder == Direction.ASC ? 1 : -1);
		}
	}
	
	/**
	 * Ensure unique index(es) on MongoDB collection, with logging.
	 * If an index already exist but not unique, it will drop and recreate the index with <code>{unique: true}</code>.
	 * <p>Usage:
	 * <pre>{@literal
	 * MongoUtils.ensureUnique(primary, "canonicalSlug");
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
	 * MongoUtils.ensureIndexes(primary, ImmutableMap.of("creationTime", -1, "modificationTime", -1);
	 * }</pre>
	 * @return 
	 * @return Ensured index names (including existing ones). A single index is named e.g. {@code creationTime_-1},
	 * 		a compound index is named e.g. {@code emails.email_1_accountStatus_1}.
	 */
	public static ImmutableList<String> ensureIndexes(DBCollection coll, final Index...indexes) {
		final ImmutableList.Builder<String> ensuredNames = ImmutableList.builder();
		log.debug("Ensuring collection {} has {} indexes: {}", 
				coll.getName(), indexes.length, indexes);
		for (final Index index : indexes) {
			final DBObject indexObj = index.getIndexObj();
			String indexName = "";
			for (final String key : indexObj.keySet()) {
				if (!indexName.isEmpty()) {
					indexName += "_";
				}
				indexName += key + "_" + indexObj.get(key);
			}
			coll.ensureIndex(indexObj, indexName);
			ensuredNames.add(indexName);
		}
		return ensuredNames.build();
	}
	
	/**
	 * Ensure indexes on MongoDB collection, with logging.
	 * <p>Usage:
	 * <pre>{@literal
	 * MongoUtils.ensureIndexes(primary, ImmutableMap.of("creationTime", -1, "modificationTime", -1);
	 * }</pre>
	 * @return 
	 * @return Ensured index names (including existing ones). A single index is named e.g. {@code creationTime_-1},
	 * 		a compound index is named e.g. {@code emails.email_1_accountStatus_1}.
	 */
	@Deprecated
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
	 * <pre>MongoUtils.dropIndexesIfNotExist(primary, "formalId_-1", "status_1", "className_1");</pre>
	 * @param primary
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
	 * ensuredIndexes.addAll( MongoUtils.ensureUnique(primary, uniqueFields.toArray(new String[] {})) );
	 * ensuredIndexes.addAll( MongoUtils.ensureIndexes(primary, indexedFields) );
	 * MongoUtils.retainIndexes(primary, ensuredIndexes.toArray(new String[] {}));
	 * }</pre>
	 * 
	 * @param primary
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

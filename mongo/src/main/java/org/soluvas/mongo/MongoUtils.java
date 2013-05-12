package org.soluvas.mongo;

import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.data.domain.Sort.Order;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * @author ceefour
 *
 */
public class MongoUtils {
	
	private static final Logger log = LoggerFactory.getLogger(MongoUtils.class);

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
	 * Ensure unique index on MongoDB collection, with logging.
	 * <p>Usage:
	 * <pre>{@literal
	 * MongoUtils.ensureUnique(coll, "slug");
	 * }</pre>
	 */
	public static void ensureUnique(DBCollection coll, String field) {
		log.debug("Ensuring collection {} has unique index {}", 
				coll.getName(), field);
		coll.ensureIndex(new BasicDBObject(field, 1), field + "_1", true);
	}
	
	/**
	 * Ensure indexes on MongoDB collection, with logging.
	 * <p>Usage:
	 * <pre>{@literal
	 * MongoUtils.ensureIndexes(coll, ImmutableMap.of("creationTime", -1, "modificationTime", -1);
	 * }</pre>
	 */
	public static void ensureIndexes(DBCollection coll, 
			final Map<String, Integer> fields) {
		log.debug("Ensuring collection {} has {} indexes: {}", 
				coll.getName(), fields.size(), fields);
		for (final Map.Entry<String, Integer> entry : fields.entrySet()) {
			coll.ensureIndex(new BasicDBObject(entry.getKey(), entry.getValue()));
		}
	}
	
}

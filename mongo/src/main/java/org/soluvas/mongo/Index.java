package org.soluvas.mongo;

import org.soluvas.data.domain.Sort;
import org.soluvas.data.domain.Sort.Direction;

import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * Used by {@link MongoRepositoryBase} and {@link MongoUtils} to define MongoDB indexes conveniently.
 * @author rudi
 */
public class Index {
	
	private final DBObject indexObj;
	private final boolean unique;
	
	private Index(DBObject indexObj, boolean unique) {
		this.indexObj = indexObj;
		this.unique = unique;
	}
	
	public DBObject getIndexObj() {
		return indexObj;
	}
	
	public boolean isUnique() {
		return unique;
	}
	
	@Override
	public String toString() {
		return indexObj.toString();
	}

	/**
	 * Create {@link Sort.Direction#ASC} single non-unique index.
	 * @param field
	 * @return
	 */
	public static Index asc(String field) {
		return new Index(new BasicDBObject(field, 1), false);
	}

	/**
	 * Create {@link Sort.Direction#DESC} single non-unique index.
	 * @param field
	 * @return
	 */
	public static Index desc(String field) {
		return new Index(new BasicDBObject(field, -1), false);
	}

	/**
	 * Create a compound non-unique index, each pair is a {@link String} field and a {@link Direction}.
	 * @param fieldsAndDirections Must be even number of arguments.
	 * @return
	 */
	public static Index compound(Object... fieldsAndDirections) {
		final BasicDBObject indexObj = new BasicDBObject();
		final UnmodifiableIterator<Object> iter = Iterators.forArray(fieldsAndDirections);
		while (iter.hasNext()) {
			final String field = (String) iter.next();
			final Sort.Direction dir = (Direction) iter.next();
			indexObj.put(field, dir == Direction.ASC ? 1 : -1);
		}
		return new Index(indexObj, false);
	}
	
	/**
	 * Create {@link Sort.Direction#ASC} single unique index.
	 * @param field
	 * @return
	 */
	public static Index uniqueAsc(String field) {
		return new Index(new BasicDBObject(field, 1), true);
	}

	/**
	 * Create {@link Sort.Direction#DESC} single non-unique index.
	 * @param field
	 * @return
	 */
	public static Index uniqueDesc(String field) {
		return new Index(new BasicDBObject(field, -1), true);
	}

	/**
	 * Create a compound unique index, each pair is a {@link String} field and a {@link Direction}.
	 * @param fieldsAndDirections Must be even number of arguments.
	 * @return
	 */
	public static Index uniqueCompound(Object... fieldsAndDirections) {
		final BasicDBObject indexObj = new BasicDBObject();
		final UnmodifiableIterator<Object> iter = Iterators.forArray(fieldsAndDirections);
		while (iter.hasNext()) {
			final String field = (String) iter.next();
			final Sort.Direction dir = (Direction) iter.next();
			indexObj.put(field, dir == Direction.ASC ? 1 : -1);
		}
		return new Index(indexObj, true);
	}
	
}
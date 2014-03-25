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
	
	private Index(DBObject indexObj) {
		this.indexObj = indexObj;
	}
	
	public DBObject getIndexObj() {
		return indexObj;
	}
	
	@Override
	public String toString() {
		return indexObj.toString();
	}

	/**
	 * Create {@link Sort.Direction#ASC} single index.
	 * @param field
	 * @return
	 */
	public static Index asc(String field) {
		return new Index(new BasicDBObject(field, 1));
	}

	/**
	 * Create {@link Sort.Direction#DESC} single index.
	 * @param field
	 * @return
	 */
	public static Index desc(String field) {
		return new Index(new BasicDBObject(field, -1));
	}

	/**
	 * Create a compound index, each pair is a {@link String} field and a {@link Direction}.
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
		return new Index(indexObj);
	}
	
}
package org.soluvas.mongo;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * @author ceefour
 *
 */
public class MongoUtils {

	/**
	 * Wrap MongoDB {@link DBCursor} results in immutable {@link List},
	 * and closes the cursor.
	 * @param cursor
	 * @return
	 */
	public static List<? extends DBObject> asList(DBCursor cursor) {
		if (cursor == null)
			return ImmutableList.of();
		try {
			return ImmutableList.copyOf((Iterable<? extends DBObject>) cursor);
		} finally {
			cursor.close();
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
		if (cursor == null)
			return ImmutableList.of();
		try {
			return ImmutableList.copyOf( Iterables.transform(cursor, transformer) );
		} finally {
			cursor.close();
		}
	}
	
}

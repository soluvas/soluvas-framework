package org.soluvas.mongo;

import javax.annotation.Nullable;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.mongodb.DBObject;

/**
 * Gets the {@code _id} (mandatory) from {@link DBObject}.
 * @author ceefour
 */
public class DBObjectToId implements Function<DBObject, String> {
	
	@Override @Nullable
	public String apply(@Nullable DBObject input) {
		return Preconditions.checkNotNull((String) input.get("_id"),
				"Expected '_id' in DBObject: %s", input);
	}

}
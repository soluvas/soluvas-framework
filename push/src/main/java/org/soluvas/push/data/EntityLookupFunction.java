package org.soluvas.push.data;

import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;

/**
 * Adapts an {@link EntityLookup} into Guava {@link Function}.
 * Note: null IDs are returned as null.
 * @author ceefour
 */
public class EntityLookupFunction<ID, T> implements Function<ID, T> {
	
	EntityLookup<ID, T> entityLookup;
	
	public EntityLookupFunction(EntityLookup<ID, T> entityLookup) {
		super();
		this.entityLookup = entityLookup;
	}

	public T apply(@Nullable ID id) {
		return id != null ? entityLookup.findOne(id) : null;
	};

}

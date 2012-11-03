package org.soluvas.push.data;

import java.io.Serializable;

import javax.annotation.Nullable;

import org.soluvas.data.EntityLookup;

import com.google.common.base.Function;

/**
 * Adapts an {@link EntityLookup} into Guava {@link Function}.
 * Note: null IDs are returned as null.
 * @author ceefour
 */
public class EntityLookupFunction<ID extends Serializable, T> implements Function<ID, T> {
	
	EntityLookup<T, ID> entityLookup;
	
	public EntityLookupFunction(EntityLookup<T, ID> entityLookup) {
		super();
		this.entityLookup = entityLookup;
	}

	@Override
	public T apply(@Nullable ID id) {
		return id != null ? entityLookup.findOne(id) : null;
	};

}

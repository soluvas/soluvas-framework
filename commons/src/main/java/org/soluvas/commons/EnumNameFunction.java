package org.soluvas.commons;

import javax.annotation.Nullable;

import com.google.common.base.Function;

/**
 * Returns {@link Enum#name()}.
 * @author rudi
 */
public class EnumNameFunction implements
		Function<Enum<?>, String> {
	
	@Override @Nullable
	public String apply(@Nullable Enum<?> input) {
		return input != null ? input.name() : null;
	}

}
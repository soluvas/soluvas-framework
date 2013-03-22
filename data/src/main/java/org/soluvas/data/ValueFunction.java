package org.soluvas.data;

import javax.annotation.Nullable;


import com.google.common.base.Function;

public final class ValueFunction implements
		Function<Value<?>, String> {
	@Override @Nullable
	public String apply(@Nullable Value<?> input) {
		return (String) (input != null ? input.getValue() : null);
	}
}
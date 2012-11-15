package org.soluvas.commons;

import com.google.common.base.Function;

public final class SimpleNameFunction implements
		Function<Object, String> {
	@Override
	public String apply(Object input) {
		return input.getClass().getSimpleName();
	}
}
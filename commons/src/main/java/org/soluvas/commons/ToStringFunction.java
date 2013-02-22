package org.soluvas.commons;

import javax.annotation.Nullable;

import com.google.common.base.Function;

/**
 * @author agus
 *
 */
public class ToStringFunction<F> implements Function<F, String> {

	@Override @Nullable
	public String apply(@Nullable F input) {
		return input != null ? input.toString() : null;
	}
	
}

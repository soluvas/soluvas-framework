package org.soluvas.commons;

import javax.annotation.Nullable;

import com.google.common.base.Function;

/**
 * Returns {@link Nameable#getName()}.
 * @author rully
 */
public class NameFunction implements Function<Nameable, String> {

	@Override @Nullable
	public String apply(@Nullable Nameable input) {
		return input != null ? input.getName() : null;
	}

}

package org.soluvas.category;

import javax.annotation.Nullable;

import com.google.common.base.Function;

/**
 * Returns {@link Category#getUName()}.
 * @author ceefour
 */
public class CategoryUNameFunction implements Function<Category, String> {

	@Override @Nullable
	public String apply(@Nullable Category input) {
		return input != null ? input.getUName() : null;
	}

}

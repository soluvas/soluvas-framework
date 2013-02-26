package org.soluvas.category.util;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.category.Category;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author ceefour
 * 
 */
public class CategoryUtils {
	
	private static final Logger log = LoggerFactory
			.getLogger(CategoryUtils.class);

	public static final class CategoryExpander implements
			Function<Category, Iterable<Category>> {
		@Override
		@Nullable
		public Iterable<Category> apply(@Nullable Category input) {
			final Iterable<Category> children = Iterables.concat(Lists
					.transform(input.getCategories(), new CategoryExpander()));
			return Iterables.concat(ImmutableList.of(input), children);
		}
	}

	public static List<Category> flatten(@Nonnull final Iterable<Category> nestedCategories) {
//		log.debug("Found nestedCategories: {}", nestedCategories);
		final List<Category> flatCategories = ImmutableList.copyOf(Iterables.concat(Iterables.transform(
				nestedCategories, new CategoryExpander())));
		return flatCategories;
	}

}

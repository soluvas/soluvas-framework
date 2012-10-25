package org.soluvas.commons;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

/**
 * Returns true if object is not null. 
 * @author rudi
 *
 * @param <T>
 */
public class NotNullPredicate<T> implements
		Predicate<T> {

	@Override
	public boolean apply(@Nullable T input) {
		return input != null;
	}

}
package org.soluvas.commons;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * Finds based on {@link Identifiable#getId()}.
 * Usually used in combination with {@link Iterables#tryFind(Iterable, Predicate)}.
 * @author adri
 */
public class IdPredicate<T extends Identifiable> implements Predicate<T> {
	
	private final String wantedId;
	
	public IdPredicate(String wantedId) {
		super();
		this.wantedId = wantedId;
	}

	@Override
	public boolean apply(@Nullable T input) {
		return input != null && wantedId.equals(input.getId());
	}

}

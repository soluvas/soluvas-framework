package org.soluvas.commons;

import java.util.Collection;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;

/**
 * Finds based on {@link Identifiable#getId()}.
 * Usually used in combination with {@link Iterables#tryFind(Iterable, Predicate)}.
 * @author adri
 */
public class IdPredicate<T extends Identifiable> implements Predicate<T> {
	
	private final Collection<String> wantedIds;
	
	/**
	 * Simple version which finds a single ID.
	 * @param wantedId
	 */
	public IdPredicate(String wantedId) {
		super();
		this.wantedIds = ImmutableSet.of(wantedId);
	}

	/**
	 * Enhanced version which finds several IDs.
	 * @param wantedIds
	 */
	public IdPredicate(Collection<String> wantedIds) {
		super();
		this.wantedIds = wantedIds;
	}

	@Override
	public boolean apply(@Nullable T input) {
		return input != null && wantedIds.contains(input.getId());
	}

}

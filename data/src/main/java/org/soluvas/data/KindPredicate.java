package org.soluvas.data;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

/**
 * Filters {@link Term} based on {@link Kind}'s nsPrefix and name.
 * @author adri
 */
public class KindPredicate implements Predicate<Term> {
	private final String kindNsPrefix;
	private final String kindName;
	
	public KindPredicate(String kindNsPrefix, String kindName) {
		super();
		this.kindNsPrefix = kindNsPrefix;
		this.kindName = kindName;
	}

	@Override
	public boolean apply(@Nullable Term input) {
		return input != null && kindNsPrefix.equals(input.getKindNsPrefix()) && kindName.equals(input.getKindName());
	}
}
package org.soluvas.data;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

/**
 * Filter only {@link Attribute} with {@link Attribute#isPrincipal()} <code>true</code>.
 * @author haidar
 */
public class PrincipalAttributePredicate implements
		Predicate<Attribute> {
	@Override
	public boolean apply(@Nullable Attribute input) {
		return input.isPrincipal();
	}
}
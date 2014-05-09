package org.soluvas.commons.locale;

import java.util.Locale;

import javax.annotation.Nullable;

import com.google.common.collect.Ordering;

/**
 * Orders {@link Locale} based on {@link Locale#toLanguageTag()}.
 * @author ceefour
 */
public class LocaleOrdering extends Ordering<Locale> {
	
	public static LocaleOrdering INSTANCE = new LocaleOrdering();
	
	@Override
	public int compare(@Nullable Locale left, @Nullable Locale right) {
		return left.toLanguageTag().compareToIgnoreCase(right.toLanguageTag());
	}
	
}
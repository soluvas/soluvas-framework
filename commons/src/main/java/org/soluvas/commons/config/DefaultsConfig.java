package org.soluvas.commons.config;

import java.util.Locale;

import org.joda.time.DateTimeZone;

/**
 * Provide app-wide defaults.
 * @author ceefour
 */
public interface DefaultsConfig {

	/**
	 * Default {@link Locale} for tenantless operations, e.g. Manage and Open pages.
	 * @return
	 * @see commerce.properties: {@code defaultLocale}
	 */
	public Locale getDefaultLocale();

	/**
	 * Default {@link DateTimeZone} for tenantless operations, e.g. Manage and Open pages.
	 * @return
	 * @see commerce.properties: {@code defaultTimeZone}
	 */
	public DateTimeZone getDefaultTimeZone();
	
}

package org.soluvas.commons.config;

import java.util.Locale;

import javax.inject.Inject;

import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Non-web tenant-related application configuration.
 * @author ceefour
 * @see MultiTenantWebConfig
 */
@Configuration
public class SingleTenantConfig implements DefaultsConfig {
	private static final Logger log = LoggerFactory
			.getLogger(SingleTenantConfig.class);

	@Inject
	private Environment env;
	
	/**
	 * Default {@link Locale} for tenantless operations, e.g. Manage and Open pages.
	 * @return
	 * @see commerce.properties: defaultLocale
	 */
	@Override
	public Locale getDefaultLocale() {
		return Locale.forLanguageTag(env.getRequiredProperty("defaultLocale"));
	}

	/**
	 * Default {@link DateTimeZone} for tenantless operations, e.g. Manage and Open pages.
	 * @return
	 * @see commerce.properties: defaultTimeZone
	 */
	@Override
	public DateTimeZone getDefaultTimeZone() {
		return DateTimeZone.forID(env.getRequiredProperty("defaultTimeZone"));
	}

}

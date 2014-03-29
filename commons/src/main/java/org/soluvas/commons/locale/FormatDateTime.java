package org.soluvas.commons.locale;

import java.util.Locale;

import javax.annotation.Nullable;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;

import com.google.common.base.Function;
import com.google.common.base.Strings;

/**
 * Function to format a {@link Datetime} value using {@link DateTimeFormat#forStyle("MS")}.
 * Useful as Mustache function.
 * 
 * @author rudi
 */
public final class FormatDateTime implements
		Function<String, String> {
	
	private static final Logger log = LoggerFactory
			.getLogger(FormatDateTime.class);
	private final DateTimeFormatter dateTimeFormat;
	
	/**
	 * Use specific {@link Locale}, usually from {@link AppManifest#getDefaultLocale()}.
	 * @param locale
	 */
	public FormatDateTime(Locale locale) {
		super();
		this.dateTimeFormat = DateTimeFormat.forStyle("MS").withLocale(locale);
	}

	@Override @Nullable
	public String apply(@Nullable String input) {
		if (!Strings.isNullOrEmpty(input)) {
			try {
				return dateTimeFormat.print(new DateTime(input));
			} catch (Exception e) {
				log.error("Cannot formatDateTime from " + input, e);
				return input.toString();
			}
		} else {
			return "";
		}
	}

}
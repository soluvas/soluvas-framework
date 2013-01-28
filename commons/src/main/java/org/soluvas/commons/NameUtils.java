package org.soluvas.commons;

import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.fusesource.jansi.Ansi;
import org.osgi.framework.Bundle;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * @author ceefour
 *
 */
public class NameUtils {
	
	/**
	 * @author haidar
	 *
	 */
	public static class PersonName {
		private final String firstName;
		private final String lastName;
		
		public PersonName(String firstName, String lastName) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}
		
	}

	/**
	 * Shorten a class name by abbreviating package prefixes, then replacing with ellipsis
	 * as last resort.
	 * @param name
	 * @param targetLength
	 * @return
	 */
	public static String shortenClass(@Nullable final Class clazz, final int targetLength) {
		return shortenClass(clazz != null ? clazz.getName() : null, targetLength);
	}

	/**
	 * Shorten a class name by abbreviating package prefixes, then replacing with ellipsis
	 * as last resort.
	 * @param name
	 * @param targetLength
	 * @return
	 */
	public static String shortenClass(final String name, final int targetLength) {
		if (Strings.isNullOrEmpty(name))
			return Strings.repeat(" ", targetLength);
		String current = name;
		if (current.length() <= targetLength)
			return current;
		// Split into segments
		final List<String> split = Lists.newArrayList(Splitter.on('.').split(name));
		// get rid of first to third-from-last segment
		for (int i = 0; i < split.size() - 2; i++) {
			split.set(i, split.get(i).substring(0, 1));
			current = Joiner.on('.').join(split);
			if (current.length() <= targetLength)
				return current;
		}
		// last resort, force cut then replace with ellipsis
		return "…" + current.substring(current.length() - targetLength + 1);
	}
	
	/**
	 * Shorten a class name by abbreviating package prefixes, then replacing with ellipsis
	 * as last resort.
	 * 
	 * The result is right-padded with space and contain {@link Ansi}-style color instructions.
	 * 
	 * @param name
	 * @param targetLength
	 * @return
	 */
	public static String shortenClassAnsi(final Class<?> clazz, final int targetLength) {
		return shortenClassAnsi(clazz != null ? clazz.getName() : null, targetLength);
	}

	/**
	 * Shorten a class name by abbreviating package prefixes, then replacing with ellipsis
	 * as last resort.
	 * 
	 * The result is right-padded with space and contain {@link Ansi}-style color instructions.
	 * 
	 * @param name
	 * @param targetLength
	 * @return
	 */
	public static String shortenClassAnsi(final String name, final int targetLength) {
		final String shortened = shortenClass(name, targetLength);
		final String padding = Strings.repeat(" ", targetLength - shortened.length());
		return formatClassAnsi(shortened) + padding;
	}

	/**
	 * Shorten a package/bundle name by abbreviating package prefixes, then replacing with ellipsis
	 * as last resort.
	 * @param name
	 * @param targetLength
	 * @return
	 */
	public static String shortenPackage(final String name, final int targetLength) {
		if (Strings.isNullOrEmpty(name))
			return Strings.repeat(" ", targetLength);
		String current = name;
		if (current.length() <= targetLength)
			return current;
		// Split into segments
		final List<String> split = Lists.newArrayList(Splitter.on('.').split(name));
		// get rid of first to second-from-last segment
		for (int i = 0; i < split.size() - 1; i++) {
			split.set(i, split.get(i).substring(0, 1));
			current = Joiner.on('.').join(split);
			if (current.length() <= targetLength)
				return current;
		}
		// last resort, force cut then replace with ellipsis
		return "…" + current.substring(current.length() - targetLength + 1);
	}
	
	/**
	 * Shorten a package/bundle name by abbreviating package prefixes, then replacing with ellipsis
	 * as last resort.
	 * 
	 * The result is right-padded with space and contain {@link Ansi}-style color instructions.
	 * 
	 * @param name
	 * @param targetLength
	 * @return
	 */
	public static String shortenPackageAnsi(final String name, final int targetLength) {
		final String shortened = shortenPackage(name, targetLength);
		final String padding = Strings.repeat(" ", targetLength - shortened.length());
		return formatClassAnsi(shortened) + padding;
	}
	
	/**
	 * Shorten a bundle symbolic name plus bundle ID by abbreviating package prefixes, then replacing with ellipsis
	 * as last resort.
	 * 
	 * The result is right-padded with space and contain {@link Ansi}-style color instructions.
	 * 
	 * @param bundle {@literal null} is gracefully handled.
	 * @param targetLength Includes the 5 characters used by space and 4-digit bundle ID.
	 * 		Recommended is 20.
	 * @return
	 */
	public static String shortenBundleAnsi(final Bundle bundle, final int targetLength) {
		if (bundle == null)
			return Strings.repeat(" ", targetLength);
		final String packageAnsi = shortenPackageAnsi(bundle.getSymbolicName(), targetLength - 5);
		final String idAnsi = String.format(" @|bold,yellow %4d|@", bundle.getBundleId());
		return packageAnsi + idAnsi;
	}
	
	/**
	 * Format a class name as {@link Ansi}-style color codes.
	 * @param name
	 * @return
	 */
	public static String formatClassAnsi(final String name) {
		// Split into segments
		final List<String> split = Lists.newArrayList(Splitter.on('.').split(name));
		final String lastSegment = split.get(split.size() - 1);
		final String boldedLastSegment = "…".equals(lastSegment.substring(0, 1))
				? "…" + "@|bold " + lastSegment.substring(1) + "|@"
				: "@|bold " + lastSegment + "|@";
		split.set(split.size() - 1, boldedLastSegment);
//		final List<String> highlight = Lists.transform(split, new Function<String, String>() {
//			@Override
//			@Nullable
//			public String apply(@Nullable String input) {
//				if (input.substring(0, 1).equals("…")) {
//					return "@|bold,black …|@@|bold " + input.substring(1) + "|@";
//				} else {
//					return "@|bold " + input + "|@";
//				}
//			}
//		});
		return Joiner.on("@|bold,black .|@").join(split).replaceFirst("…", "@|bold,black …|@");
	}

	/**
	 * Shorten {@link UUID}.
	 * @param uuid
	 * @param targetLength Recommended is 9.
	 */
	public static String shortenUuid(@Nullable final String uuid, final int targetLength) {
		if (uuid == null)
			return null;
		if (uuid.length() <= targetLength)
			return uuid;
		else {
			return uuid.substring(0, targetLength - 1) + "…";
		}
	}
	
	/**
	 * Shorten {@link UUID}, Ansi-formatted and padded.
	 * @param uuid
	 * @param targetLength Recommended is 9.
	 */
	public static String shortenUuidAnsi(final String uuid, final int targetLength) {
		if (uuid == null)
			return null;
		final String shortened = shortenUuid(uuid, targetLength);
		if (shortened.length() >= 1 && "…".equals(shortened.substring(shortened.length() - 1))) {
			return "@|bold " + shortened.substring(0, shortened.length() - 1) + "|@@|bold,black …|@";
		} else {
			return "@|bold " + Strings.padEnd(shortened, targetLength, ' ') + "|@";
		}
	}
	
	/**
	 * Shorten Mustache template.
	 */
	public static String shortenMustache(final String template) {
		if (template == null)
			return null;
		final String shortened = template.replace("{{{", "◁").replace("}}}", "▷")
				.replace("{{", "«").replace("}}", "»");
		return shortened;
	}
	
	/**
	 * Shorten any string with ellipsis, avoiding any exceptions.
	 */
	public static String shorten(final String input, final int maxLength) {
		if (input == null)
			return null;
		if (input.length() <= maxLength)
			return input;
		else
			return input.substring(0, maxLength - 1) + "…";
	}
	
	/**
	 * Shorten any string with ellipsis any ANSI colors, avoiding any exceptions, padded to targetLength.
	 */
	public static String shortenAnsi(final String input, final int targetLength) {
		if (input == null)
			return null;
		if (input.length() <= targetLength)
			return Strings.padEnd(input, targetLength, ' ');
		else
			return input.substring(0, targetLength - 1) + "@|bold,black …|@";
	}
	
	/**
	 * Splits a name to first name and last name. It will never return null. If name cannot be split, it will return "name name".
	 * If name is empty, it will return "- -".  
	 * @param name
	 * @return
	 */
	@Nonnull
	public static PersonName splitName(String name) {
		if (Strings.isNullOrEmpty(name))
			name = "-";
		final Matcher matcher = Pattern.compile("(.+) (.+)").matcher(name);
		if (matcher.matches()) {
			return new PersonName(matcher.group(1), matcher.group(2));
		} else {
			return new PersonName(name, name);
		}
	}
}

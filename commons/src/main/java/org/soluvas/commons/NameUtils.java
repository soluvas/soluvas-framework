package org.soluvas.commons;

import java.util.List;
import java.util.UUID;

import javax.annotation.Nullable;

import org.fusesource.jansi.Ansi;

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
	
}

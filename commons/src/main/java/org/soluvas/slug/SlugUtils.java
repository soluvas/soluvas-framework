package org.soluvas.slug;

import com.google.common.base.Predicate;

/**
 * Generates ID, screen name, or URI segment.
 * @author ceefour
 */
public class SlugUtils {
	
	public static final int MIN_LENGTH = 3;
	
	/**
	 * Generates person slugs (using underscores).
	 * @param name
	 * @param suffix
	 * @return
	 */
	public static String generateScreenName(String name, int suffix) {
		String base = name.replaceAll("[^A-Za-z0-9]", " ").trim().toLowerCase().replaceAll(" ", ".")
				.replaceAll("\\.+", ".");
		while (base.length() < MIN_LENGTH)
			base += "a";
		return (suffix == 0) ? base : base + String.valueOf(suffix);
	}
	
	/**
	 * Generates person slugs (using underscores).
	 * @param name
	 * @return
	 */
	public static String generateScreenName(String name) {
		return generateScreenName(name, 0);
	}
	
	/**
	 * Generates resource IDs (using underscores).
	 * @param name
	 * @param suffix
	 * @return
	 */
	public static String generateId(String name, int suffix) {
		String base = name.replaceAll("[^A-Za-z0-9]", " ").trim().toLowerCase().replaceAll(" ", "_")
				.replaceAll("\\_+", "_");
		while (base.length() < MIN_LENGTH)
			base += "a";
		return (suffix == 0) ? base : base + String.valueOf(suffix);
	}
	
	/**
	 * Generates resource IDs (using underscores).
	 * @param name
	 * @return
	 */
	public static String generateId(String name) {
		return generateId(name, 0);
	}
	
	/**
	 * Generates article URI path segments (using '-').
	 * @param name
	 * @param suffix
	 * @return
	 */
	public static String generateSegment(String name, int suffix) {
		String base = name.replaceAll("[^A-Za-z0-9]", " ").trim().toLowerCase().replaceAll(" ", "-")
				.replaceAll("\\-+", "-");
		while (base.length() < MIN_LENGTH)
			base += "a";
		return (suffix == 0) ? base : base + String.valueOf(suffix);
	}
	
	/**
	 * Generates article URI path segments (using '-').
	 * @param name
	 * @return
	 */
	public static String generateSegment(String name) {
		return generateSegment(name, 0);
	}
	
	/**
	 * Retries 99 times (using suffix 2 to 99) to get a valid ID, otherwise throw Exception.
	 * @param name
	 * @param validator
	 * @return
	 */
	public static String generateValidId(String name, Predicate<String> validator) {
		String id = generateId(name, 0);
		if (validator.apply(id))
			return id;
		else {
			for (int i = 2; i <= 99; i++) {
				id = generateId(name, i);
				if (validator.apply(id))
					return id;
			}
			throw new RuntimeException("Cannot generate valid ID for '" + name + "' after 99 retries.");
		}
	}
	
	/**
	 * Retries 99 times (using suffix 2 to 99) to get a valid segment, otherwise throw Exception.
	 * @param name
	 * @param validator
	 * @return
	 */
	public static String generateValidSegment(String name, Predicate<String> validator) {
		String id = generateSegment(name, 0);
		if (validator.apply(id))
			return id;
		else {
			for (int i = 2; i <= 99; i++) {
				id = generateSegment(name, i);
				if (validator.apply(id))
					return id;
			}
			throw new RuntimeException("Cannot generate valid segment for '" + name + "' after 99 retries.");
		}
	}
	
	/**
	 * Retries 99 times (using suffix 2 to 99) to get a valid segment, otherwise throw Exception.
	 * @param name
	 * @param validator
	 * @return
	 */
	public static String generateValidScreenName(String name, Predicate<String> validator) {
		String id = generateScreenName(name, 0);
		if (validator.apply(id))
			return id;
		else {
			for (int i = 2; i <= 99; i++) {
				id = generateScreenName(name, i);
				if (validator.apply(id))
					return id;
			}
			throw new RuntimeException("Cannot generate valid screen name for '" + name + "' after 99 retries.");
		}
	}
	
	/**
	 * Makes it lowercase, and removes every character not in a-z, 0-9, and underscore.
	 * 
	 * It is useful for e.g. making both http://www.satukancinta.com/member/arum.puspita and http://www.satukancinta.com/member/arumpuspita
	 * or even http://www.satukancinta.com/member/arum.pus.pi.ta usable.
	 * From the technical point-of-view (easy matching/lookup), the canonical slug/identifier for <tt>arum.puspita</tt> is <tt>arumpuspita</tt>.
	 * From the user or SEO point-of-view however, the "canonical" one is <tt>arum.puspita</tt>, but it is not what is meant here.
	 * 
	 * @param slug
	 * @return
	 */
	public static String canonicalize(String slug) {
		return slug.toLowerCase().replaceAll("[^a-z0-9_]", "");
	}
}

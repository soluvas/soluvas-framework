package org.soluvas.slug;

import com.google.common.base.Predicate;

/**
 * Generates ID, screen name, or URI segment.
 * @author ceefour
 */
public class SlugUtils {
	
	public static final int MIN_LENGTH = 3;
	
	/**
	 * Generate person slugs (using underscores).
	 * @param name
	 * @param iteration
	 * @return
	 */
	public static String generateScreenName(String name, int iteration) {
		String base = name.replaceAll("[^A-Za-z0-9]", " ").trim().toLowerCase().replaceAll(" ", ".")
				.replaceAll("\\.+", ".");
		while (base.length() < MIN_LENGTH)
			base += "a";
		return (iteration == 0) ? base : base + String.valueOf(iteration + 1);
	}
	
	/**
	 * Generator resource IDs (using underscores).
	 * @param name
	 * @param iteration
	 * @return
	 */
	public static String generateId(String name, int iteration) {
		String base = name.replaceAll("[^A-Za-z0-9]", " ").trim().toLowerCase().replaceAll(" ", "_")
				.replaceAll("\\_+", "_");
		while (base.length() < MIN_LENGTH)
			base += "a";
		return (iteration == 0) ? base : base + String.valueOf(iteration + 1);
	}
	
	/**
	 * Generator article URI path segments (using '-').
	 * @param name
	 * @param iteration
	 * @return
	 */
	public static String generateSegment(String name, int iteration) {
		String base = name.replaceAll("[^A-Za-z0-9]", " ").trim().toLowerCase().replaceAll(" ", "-")
				.replaceAll("\\-+", "-");
		while (base.length() < MIN_LENGTH)
			base += "a";
		return (iteration == 0) ? base : base + String.valueOf(iteration + 1);
	}
	
	/**
	 * Retries 99 times (using iteration 2 to 99) to get a valid ID, otherwise throw Exception.
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
	 * Retries 99 times (using iteration 2 to 99) to get a valid segment, otherwise throw Exception.
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
	 * Retries 99 times (using iteration 2 to 99) to get a valid segment, otherwise throw Exception.
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
	
}

package org.soluvas.slug;

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
	
}

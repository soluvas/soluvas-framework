/**
 * 
 */
package org.soluvas.slug;

/**
 * @author ceefour
 *
 */
public class SlugUtils {

	/**
	 * Generate person slugs (using underscores).
	 * @param name
	 * @param iteration
	 * @return
	 */
	public static String generateScreenName(String name, int iteration) {
		final String base = name.replaceAll("[.,_]", " ").trim().toLowerCase().replaceAll(" ", ".").replaceAll("[^A-Za-z0-9.]", "")
				.replaceAll("\\.+", ".");
		return (iteration == 0) ? base : base + String.valueOf(iteration + 1);
	}
	
	/**
	 * Generator resource IDs (using underscores).
	 * @param name
	 * @param iteration
	 * @return
	 */
	public static String generateId(String name, int iteration) {
		final String base = name.replaceAll("[.,_-]", " ").trim().toLowerCase().replaceAll(" ", "_").replaceAll("[^A-Za-z0-9_]", "")
				.replaceAll("\\_+", "_");
		return (iteration == 0) ? base : base + String.valueOf(iteration + 1);
	}
	
	/**
	 * Generator article URL path segments (using '-').
	 * @param name
	 * @param iteration
	 * @return
	 */
	public static String generateSegment(String name, int iteration) {
		final String base = name.replaceAll("[_.,-]", " ").trim().toLowerCase().replaceAll(" ", "-").replaceAll("[^A-Za-z0-9-]", "")
				.replaceAll("\\-+", "-");
		return (iteration == 0) ? base : base + String.valueOf(iteration + 1);
	}
	
}

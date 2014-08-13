package org.soluvas.commons;

import java.text.Normalizer;
import java.util.regex.Pattern;

import javax.annotation.Nonnegative;
import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;

/**
 * Generates ID, screen name, or URI segment.
 * @author ceefour
 */
public class SlugUtils {
	
	public static final int MIN_LENGTH = 3;
	public static final int MAX_LENGTH = 63;
	public static final Pattern ID_PATTERN = Pattern.compile("[a-z0-9][a-z0-9_]+");
	/**
	 * Happens to be same as {@link #CANONICAL_PATTERN} but different in purpose.
	 */
	public static final Pattern TENANT_ID_PATTERN = Pattern.compile("[a-z0-9][a-z0-9]+");
	public static final Pattern SCREEN_NAME_PATTERN = Pattern.compile("[a-z0-9][a-z0-9.]+");
	public static final Pattern SEGMENT_PATTERN = Pattern.compile("[a-z0-9][a-z0-9-]+");
	public static final Pattern SEGMENT_PATH_PATTERN = Pattern.compile("[a-z0-9][a-z0-9-]+[a-z0-9/-]*");
	/**
	 * Happens to be same as {@link #TENANT_ID_PATTERN} but different in purpose.
	 */
	public static final Pattern CANONICAL_PATTERN = Pattern.compile("[a-z0-9][a-z0-9]+");
	public static final Pattern CANONICAL_PATH_PATTERN = Pattern.compile("[a-z0-9][a-z0-9]+[a-z0-9/]*");
	public static final Pattern PUNCTUATION = Pattern.compile("\\p{Punct}+", Pattern.UNICODE_CHARACTER_CLASS);
	public static final Pattern NOT_ALPHANUM_OR_SPACE = Pattern.compile("[^A-Za-z0-9 ]+");
	public static final Pattern NOT_ALPHANUM = Pattern.compile("[^A-Za-z0-9]+");
	public static final Pattern NOT_LOWER_ALPHANUM = Pattern.compile("[^a-z0-9]+");
	public static final Pattern NOT_LOWER_ALPHANUM_OR_SLASH = Pattern.compile("[^a-z0-9/]+");
	public static final Pattern DOTS = Pattern.compile("\\.+");
	public static final Pattern UNDERSCORES = Pattern.compile("\\_+");
	public static final Pattern DASHES = Pattern.compile("\\-+");
	
	/**
	 * Generates person slugs (using dots).
	 * @param name
	 * @param suffix
	 * @return Guaranteed to conform to {@link #SCREEN_NAME_PATTERN}.
	 */
	public static String generateScreenName(String name, @Nonnegative int suffix) {
		Preconditions.checkNotNull(name, "name must not be null");
		Preconditions.checkArgument(suffix >= 0, "suffix must be non-negative");
		// http://stackoverflow.com/a/3322174/122441
		String base = Normalizer.normalize(name, Normalizer.Form.NFD);
		base = PUNCTUATION.matcher(base).replaceAll(" ");
		base = NOT_ALPHANUM_OR_SPACE.matcher(base).replaceAll("");
		base = base.trim().toLowerCase().replace(' ', '.');
		base = DOTS.matcher(base).replaceAll(".");
		while (base.length() < MIN_LENGTH)
			base += "a";
		final String suffixStr = String.valueOf(suffix);
		return (suffix == 0) ? StringUtils.left(base, MAX_LENGTH) :
			StringUtils.left(base, MAX_LENGTH - suffixStr.length()) + suffixStr;
	}
	
	/**
	 * Generates person slugs (using dots).
	 * @param name
	 * @return Guaranteed to conform to {@link #SCREEN_NAME_PATTERN}.
	 */
	public static String generateScreenName(String name) {
		return generateScreenName(name, 0);
	}
	
	/**
	 * Generates resource IDs (using underscores).
	 * @param name
	 * @param suffix
	 * @return Guaranteed to conform to {@link #ID_PATTERN}.
	 */
	public static String generateId(String name, int suffix) {
		Preconditions.checkNotNull(name, "name must not be null");
		Preconditions.checkArgument(suffix >= 0, "suffix must be non-negative");
		// http://stackoverflow.com/a/3322174/122441
		String base = Normalizer.normalize(name, Normalizer.Form.NFD);
		base = PUNCTUATION.matcher(base).replaceAll(" ");
		base = NOT_ALPHANUM_OR_SPACE.matcher(base).replaceAll("");
		base = base.trim().toLowerCase().replace(' ', '_');
		base = UNDERSCORES.matcher(base).replaceAll("_");
		while (base.length() < MIN_LENGTH)
			base += "a";
		final String suffixStr = String.valueOf(suffix);
		return (suffix == 0) ? StringUtils.left(base, MAX_LENGTH) :
			StringUtils.left(base, MAX_LENGTH - suffixStr.length()) + suffixStr;
	}
	
	/**
	 * Generates resource IDs (using underscores).
	 * @param name
	 * @return Guaranteed to conform to {@link #ID_PATTERN}.
	 */
	public static String generateId(String name) {
		return generateId(name, 0);
	}
	
	/**
	 * Generates tenant IDs (without underscores).
	 * @param name
	 * @param suffix
	 * @return Guaranteed to conform to {@link #TENANT_ID_PATTERN}.
	 */
	public static String generateTenantId(String name, int suffix) {
		Preconditions.checkNotNull(name, "name must not be null");
		Preconditions.checkArgument(suffix >= 0, "suffix must be non-negative");
		// http://stackoverflow.com/a/3322174/122441
		String base = Normalizer.normalize(name, Normalizer.Form.NFD);
		base = NOT_ALPHANUM.matcher(base).replaceAll("");
		base = base.trim().toLowerCase();
		while (base.length() < MIN_LENGTH)
			base += "a";
		final String suffixStr = String.valueOf(suffix);
		return (suffix == 0) ? StringUtils.left(base, MAX_LENGTH) :
			StringUtils.left(base, MAX_LENGTH - suffixStr.length()) + suffixStr;
	}
	
	/**
	 * Generates tenant IDs (without underscores).
	 * @param name
	 * @return Guaranteed to conform to {@link #TENANT_ID_PATTERN}.
	 */
	public static String generateTenantId(String name) {
		return generateTenantId(name, 0);
	}
	
	/**
	 * Generates article URI path segments (using '-').
	 * @param name
	 * @param suffix
	 * @return Guaranteed to conform to {@link #SEGMENT_PATTERN}.
	 */
	public static String generateSegment(String name, int suffix) {
		Preconditions.checkNotNull(name, "name must not be null");
		Preconditions.checkArgument(suffix >= 0, "suffix must be non-negative");
		// http://stackoverflow.com/a/3322174/122441
		String base = Normalizer.normalize(name, Normalizer.Form.NFD);
		base = PUNCTUATION.matcher(base).replaceAll(" ");
		base = NOT_ALPHANUM_OR_SPACE.matcher(base).replaceAll("");
		base = base.trim().toLowerCase().replace(' ', '-');
		base = DASHES.matcher(base).replaceAll("-");
		while (base.length() < MIN_LENGTH)
			base += "a";
		final String suffixStr = String.valueOf(suffix);
		return (suffix == 0) ? StringUtils.left(base, MAX_LENGTH) :
			StringUtils.left(base, MAX_LENGTH - suffixStr.length()) + suffixStr;
	}
	
	/**
	 * Generates article URI path segments (using '-').
	 * @param name
	 * @return Guaranteed to conform to {@link #SEGMENT_PATTERN}.
	 */
	public static String generateSegment(String name) {
		return generateSegment(name, 0);
	}
	
	/**
	 * Retries 99 times (using suffix 2 to 99) to get a valid ID, otherwise throw Exception.
	 * @param name
	 * @param validator
	 * @return Guaranteed to conform to {@link #ID_PATTERN}.
	 */
	public static String generateValidId(String name, Predicate<String> validator) {
		Preconditions.checkNotNull(validator, "validator must not be null");
		String id = generateId(name, 0);
		if (validator.apply(id))
			return id;
		else {
			for (int i = 2; i <= 99; i++) {
				id = generateId(name, i);
				if (validator.apply(id))
					return id;
			}
			throw new CommonsException("Cannot generate valid ID for '" + name + "' after 99 retries.");
		}
	}

	/**
	 * Retries 99 times (using suffix 2 to 99) to get a valid tenant ID, otherwise throw Exception.
	 * @param name
	 * @param validator
	 * @return Guaranteed to conform to {@link #TENANT_ID_PATTERN}.
	 */
	public static String generateValidTenantId(String name, Predicate<String> validator) {
		Preconditions.checkNotNull(validator, "validator must not be null");
		String id = generateTenantId(name, 0);
		if (validator.apply(id))
			return id;
		else {
			for (int i = 2; i <= 99; i++) {
				id = generateTenantId(name, i);
				if (validator.apply(id))
					return id;
			}
			throw new CommonsException("Cannot generate valid tenant ID for '" + name + "' after 99 retries.");
		}
	}

	/**
	 * @param name
	 * @param validator
	 * @return
	 * @deprecated Use {@link #generateValidSegment(String, Predicate)}.
	 */
	@Deprecated
	public static String generateValidSlug(String name, Predicate<String> validator) {
		return generateValidSegment(name, validator);
	}
	
	/**
	 * Retries 99 times (using suffix 2 to 99) to get a valid segment, otherwise throw Exception.
	 * @param name
	 * @param validator
	 * @return Guaranteed to conform to {@link #SEGMENT_PATTERN}.
	 */
	public static String generateValidSegment(String name, Predicate<String> validator) {
		Preconditions.checkNotNull(validator, "validator must not be null");
		String segment = generateSegment(name, 0);
		if (validator.apply(segment))
			return segment;
		else {
			for (int i = 2; i <= 999; i++) {
				segment = generateSegment(name, i);
				if (validator.apply(segment))
					return segment;
			}
			throw new CommonsException("Cannot generate valid segment for '" + name + "' after 99 retries.");
		}
	}
	
	/**
	 * Retries 99 times (using suffix 2 to 99) to get a valid segment, otherwise throw Exception.
	 * @param name
	 * @param validator
	 * @return Guaranteed to conform to {@link #SCREEN_NAME_PATTERN}.
	 */
	public static String generateValidScreenName(String name, Predicate<String> validator) {
		Preconditions.checkNotNull(validator, "validator must not be null");
		String id = generateScreenName(name, 0);
		if (validator.apply(id))
			return id;
		else {
			for (int i = 2; i <= 99; i++) {
				id = generateScreenName(name, i);
				if (validator.apply(id))
					return id;
			}
			throw new CommonsException("Cannot generate valid screen name for '" + name + "' after 99 retries.");
		}
	}
	
	/**
	 * Makes it lowercase, and removes every character not in a-z and 0-9. Underscore is also removed.
	 * 
	 * <p>It is useful for e.g. making both {@code http://www.satukancinta.com/arum.puspita} and {@code http://www.satukancinta.com/arumpuspita}
	 * or even {@code http://www.satukancinta.com/member/arum.pus.pi.ta} usable.
	 * <p>From the technical point-of-view (easy matching/lookup), the canonical slug/identifier for <tt>arum.puspita</tt> is <tt>arumpuspita</tt>,
	 * the canonicalSlug should be indexed in database for fast matching.
	 * From the user or SEO point-of-view however, the "canonical" one is <tt>arum.puspita</tt>, but it is not what is meant here.
	 * 
	 * @param slug
	 * @return Canonicalized slug, or {@code null} if input is null.
	 * @see #canonicalizePath(String)
	 * @see #generateValidSegment(String, Predicate)
	 * @see #generateValidScreenName(String, Predicate)
	 * @return Guaranteed to conform to {@link #CANONICAL_PATTERN}.
	 */
	@Nullable
	public static String canonicalize(@Nullable String slug) {
		return slug != null ? NOT_LOWER_ALPHANUM.matcher(slug.toLowerCase()).replaceAll("") : null;
	}

	/**
	 * Makes it lowercase, and removes every character not in a-z and 0-9 and '/'. Underscore is also removed.
	 * @param slugPath
	 * @return Guaranteed to conform to {@link #CANONICAL_PATH_PATTERN}.
	 * @see #canonicalize(String)
	 */
	@Nullable
	public static String canonicalizePath(@Nullable String slugPath) {
		return slugPath != null ? NOT_LOWER_ALPHANUM_OR_SLASH.matcher(slugPath.toLowerCase()).replaceAll("") : null;
	}

}

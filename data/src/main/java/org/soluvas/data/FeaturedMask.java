package org.soluvas.data;

/**
 * A mask often used for public-facing items like eCommerce products, blogs, etc.
 * @author ceefour
 */
public enum FeaturedMask {
	/**
	 * Include unfeatured items, i.e. do not filter on {@code featured}.
	 */
	INCLUDE_UNFEATURED,
	/**
	 * Show only featured items.
	 */
	FEATURED_ONLY
}

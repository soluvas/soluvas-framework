package org.soluvas.data.domain;

import org.soluvas.data.domain.Sort.Direction;

/**
 * Used for quick "single page" implementation where proper {@link Pageable} logic is deferred.
 * This should throw a warning somewhere, at least the log and preferably in the UI,
 * when the total elements is larger then the cap.
 * @author ceefour
 */
public class CappedRequest extends PageRequest {

	private static final long serialVersionUID = 1L;

	/**
	 * @param page
	 * @param size
	 */
	public CappedRequest(long size) {
		super(0, size);
	}

	/**
	 * @param page
	 * @param size
	 * @param direction
	 * @param properties
	 */
	public CappedRequest(long size, Direction direction,
			String... properties) {
		super(0, size, direction, properties);
	}

	/**
	 * @param page
	 * @param size
	 * @param sort
	 */
	public CappedRequest(long size, Sort sort) {
		super(0, size, sort);
	}

	@Override
	public String toString() {
		return "CappedRequest [size=" + getPageSize() + ", "
				+ (getSort() != null ? "sort=" + getSort() : "") + "]";
	}
	
	@Override
	public boolean isCapped() {
		return true;
	}

}

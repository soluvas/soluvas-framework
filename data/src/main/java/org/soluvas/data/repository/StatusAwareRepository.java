package org.soluvas.data.repository;

import java.io.Serializable;

import org.soluvas.data.StatusMask;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;

/**
 * Understands {@link StatusMask}.
 * @author ceefour
 */
public interface StatusAwareRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {

	/**
	 * Returns a {@link Page} of entities meeting {@link StatusMask} with
	 * the paging restriction provided in the {@code Pageable} object.
	 * 
	 * @param pageable
	 * @return a page of entities
	 */
	public Page<T> findAll(StatusMask statusMask, Pageable pageable);

}

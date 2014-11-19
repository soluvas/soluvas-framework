package org.soluvas.couchdb;

import org.soluvas.commons.Identifiable;
import org.soluvas.data.StatusMask;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;

/**
 * CouchDB-specific repository operations.
 * @author ceefour
 */
public interface CouchDbRepository<T extends Identifiable> {

	/**
	 * Count entities in specified view.
	 * @param viewName
	 * @return
	 */
	public long countByView(String viewName);
	
	/**
	 * Find all entities in specified view.
	 * @param viewName
	 * @param pageable
	 * @return
	 */
	public Page<T> findAllByView(String viewName, Pageable pageable);

	/**
	 * Count entities matching {@link StatusMask}.
	 * Note: {@link CouchDbRepositoryBase} implementation requires this view:
	 * {VIEW_STATUSMASK_PREFIX}statusMask_by_modificationTime
	 * @param statusMask
	 * @return
	 */
	public long count(StatusMask statusMask);

}

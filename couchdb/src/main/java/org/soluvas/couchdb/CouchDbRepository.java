package org.soluvas.couchdb;

import org.soluvas.commons.Identifiable;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;

/**
 * CouchDB-specific repository operations.
 * @author ceefour
 */
public interface CouchDbRepository<T extends Identifiable> {

	public long countByView(String viewName);
	public Page<T> findAllByView(String viewName, Pageable pageable);

}

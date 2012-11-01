package org.soluvas.data.repository;

import java.io.Serializable;

/**
 * Supports bulk delete by IDs.
 * @author ceefour
 */
public interface BulkCrudRepository<T, ID extends Serializable>  extends CrudRepository<T, ID> {
	
	/**
	 * This is usually (but not always) more efficient than calling
	 * {@link CrudRepository#delete(Serializable)} multiple times.
	 * @param ids
	 */
	void deleteIds(Iterable<ID> ids);

}

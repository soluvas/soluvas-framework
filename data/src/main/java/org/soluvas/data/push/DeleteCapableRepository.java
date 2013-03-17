package org.soluvas.data.push;

import java.util.List;

/**
 * Synchronous interface for delete capabilities.
 * @author ceefour
 */
public interface DeleteCapableRepository<ID, T> {
	
	/**
	 * Returns true if delete is supported.
	 * @return
	 */
	boolean canDelete();
	
	/**
	 * Returns true if undelete is supported.
	 * @return
	 */
	boolean canUndelete();
	
	/**
	 * Delete entities.
	 * @param ids
	 */
	void delete(List<ID> ids);
	
	/**
	 * Convenience method for {@link #delete(List)}.
	 * @param id
	 */
	void delete(ID id);
	
	/**
	 * Undelete entities.
	 * @param ids
	 */
	void undelete(List<ID> ids);
	
	/**
	 * Convenience method for {@link #undelete(List)}.
	 * @param id
	 */
	void undelete(ID id);

}

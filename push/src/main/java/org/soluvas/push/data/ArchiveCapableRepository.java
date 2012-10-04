package org.soluvas.push.data;

import java.util.List;

/**
 * Synchronous interface for archive capabilities.
 * @author ceefour
 */
public interface ArchiveCapableRepository<ID, T> {
	
	/**
	 * Returns true if archive is supported.
	 * @return
	 */
	boolean canArchive();
	
	/**
	 * Returns true if unarchive is supported.
	 * @return
	 */
	boolean canUnarchive();
	
	/**
	 * Archive entities.
	 * @param ids
	 */
	void archive(List<ID> ids);
	
	/**
	 * Convenience method for {@link #archive(List)}.
	 * @param id
	 */
	void archive(ID id);
	
	/**
	 * Unarchive entities.
	 * @param ids
	 */
	void unarchive(List<ID> ids);
	
	/**
	 * Convenience method for {@link #unarchive(List)}.
	 * @param id
	 */
	void unarchive(ID id);

}

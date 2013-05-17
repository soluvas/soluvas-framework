package org.soluvas.data.util;

import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;

/**
 * Used to fetch a {@link Pageable} of data, usually an anonymous class.
 * @author haidar
 * @see RepositoryUtils#runBatch(String, BatchFinder, BatchProcessor)
 */
public interface BatchFinder<T> {
	
	/**
	 * Used to fetch a {@link Pageable} of data, usually an anonymous class.
	 * @param pageable
	 * @return
	 * @throws Exception
	 * @see RepositoryUtils#runBatch(String, BatchFinder, BatchProcessor)
	 */
	public Page<T> find(Pageable pageable) throws Exception;

}

package org.soluvas.data.util;

import org.soluvas.commons.ProgressMonitor;
import org.soluvas.data.domain.Page;

/**
 * Process each row in a {@link Page} batch, usually an anonymous class.
 * @author haidar
 * @see RepositoryUtils#runBatch(String, BatchFinder, BatchProcessor)
 */
public interface BatchProcessor<T> {
	
	/**
	 * Process each row in a {@link Page} batch, usually an anonymous class.
	 * @param inputs
	 * @param pageNumber
	 * @param totalPages
	 * @param totalElements
	 * @param i 
	 * @param monitor
	 * @throws Exception
	 * @see RepositoryUtils#runBatch(String, BatchFinder, BatchProcessor)
	 */
	public void process(T input, long elementIndex, long elementOffset, long numberOfElements, long totalElements,
			long pageNumber, long totalPages, 
			ProgressMonitor monitor) throws Exception;

}

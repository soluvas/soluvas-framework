package org.soluvas.data.util;

import org.soluvas.commons.ProgressMonitor;
import org.soluvas.data.domain.Page;

/**
 * Process each {@link Page} batch, usually an anonymous class.
 * @author haidar
 * @see RepositoryUtils#runBatch(String, org.soluvas.data.domain.Sort, BatchFinder, PageProcessor)
 */
public interface PageProcessor<T> {
	
	/**
	 * Process each {@link Page} batch, usually an anonymous class.
	 * @param inputs
	 * @param pageNumber
	 * @param totalPages
	 * @param totalElements
	 * @param i 
	 * @param monitor
	 * @throws Exception
	 * @see {@link RepositoryUtils#runBatch(String, org.soluvas.data.domain.Sort, BatchFinder, PageProcessor)}
	 */
	public void process(Page<T> page, ProgressMonitor monitor) throws Exception;

}

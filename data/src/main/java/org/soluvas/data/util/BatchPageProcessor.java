package org.soluvas.data.util;

import java.util.List;

import org.soluvas.commons.ProgressMonitor;
import org.soluvas.data.domain.Page;

/**
 * Process each data {@link Page}, usually an anonymous class.
 * @author haidar
 * @see RepositoryUtils#runBatch(String, BatchFinder, BatchListProcessor)
 */
public interface BatchPageProcessor<T> {
	
	/**
	 * Process each data {@link Page}, usually an anonymous class.
	 * @param inputs
	 * @param pageNumber
	 * @param totalPages
	 * @param totalElements
	 * @param monitor
	 * @throws Exception
	 * @see RepositoryUtils#runBatch(String, BatchFinder, BatchListProcessor)
	 */
	public void process(List<T> inputs, long pageNumber, long totalPages, long totalElements,
			ProgressMonitor monitor) throws Exception;

}

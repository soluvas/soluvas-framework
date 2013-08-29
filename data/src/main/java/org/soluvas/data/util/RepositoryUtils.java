package org.soluvas.data.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.ProgressMonitor;
import org.soluvas.commons.ProgressStatus;
import org.soluvas.commons.util.ThreadLocalProgress;
import org.soluvas.data.DataException;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.repository.PagingAndSortingRepository;
import org.soluvas.data.repository.Repository;

/**
 * Batch {@link Repository} operation support.
 * @author haidar
 */
public class RepositoryUtils {

	private static final Logger log = LoggerFactory
			.getLogger(RepositoryUtils.class);
	
	/**
	 * Perform a {@link PagingAndSortingRepository}-related batch processing job using {@link Pageable},
	 * with {@link ProgressMonitor} support.
	 * 
	 * <p><b>WARNING</b>: Do <b>NOT</b> modify the entity returned by {@code finder} inside the {@code processor}
	 * that will make the query used by {@code finder} return different results.
	 * If you want to modify the entity, use an wider query in {@code finder} that does not depend
	 * on the outcome of {@code processor}.
	 * 
	 * @param jobTitle Job name, will be used by {@link ProgressMonitor}. It will get the monitor using {@link ThreadLocalProgress#get()}.
	 * @param finder Used to fetch a {@link Pageable} of data, usually an anonymous class.
	 * @param processor Process each data {@link Page}, usually an anonymous class.
	 */
	public static <T> void runBatch(String jobTitle, BatchFinder<T> finder, BatchProcessor<T> processor) {
		final long itemsPerPage = 100;
		final ProgressMonitor monitor = ThreadLocalProgress.get();
		log.info("Starting batch job: {}", jobTitle);
		// get first page
		final Pageable firstPageable = new PageRequest(0, itemsPerPage);
		Page<T> page;
		try {
			page = finder.find(firstPageable);
		} catch (Exception e1) {
			throw new DataException(e1, "Cannot fetch first page of batch job '%s': %s", jobTitle, e1);
		}
		
		monitor.beginTask(String.format("%d entries %d pages %s", page.getTotalElements(), page.getTotalPages(), jobTitle), page.getTotalElements());
		Pageable currentPageable = firstPageable;
		while (page.hasContent()) {
			monitor.subTask(String.format("%3d/%3d #%5d Σ%3d %s", page.getNumber(), page.getTotalPages(), currentPageable.getOffset(), page.getNumberOfElements(), jobTitle));
			long elementIndex = 0;
			long elementOffset = currentPageable.getOffset();
			for (T el : page.getContent()) {
				try {
					processor.process(el, elementIndex, elementOffset, page.getNumberOfElements(), page.getTotalElements(), page.getNumber(), page.getTotalPages(), monitor);
					monitor.worked(1);
					elementIndex++;
					elementOffset++;
				} catch (Exception e) {
					monitor.done(ProgressStatus.ERROR);
					throw new DataException(e, "Cannot process %s %d/%d (offset %d) in page %d out of %d (offset %d out of %d) in batch job '%s': %s",
							el.getClass().getSimpleName(), elementIndex, page.getNumberOfElements(), elementOffset,
							currentPageable.getPageNumber(), page.getTotalPages(), currentPageable.getOffset(), page.getTotalElements(), jobTitle, e);
				}
			}
//				processor.process(page.getContent(), page.getNumber(), page.getTotalPages(), page.getTotalElements(), monitor);
			// fetch next page
			if (page.hasNextPage()) {
				final Pageable nextPageable = new PageRequest(page.getNumber() + 1, itemsPerPage);
				try {
					page = finder.find(nextPageable);
					currentPageable = nextPageable;
				} catch (Exception e) {
					throw new DataException(e, "Cannot fetch page %d out of %d (offset %d out of %d) in batch job '%s': %s",
							nextPageable.getPageNumber(), page.getTotalPages(), nextPageable.getOffset(), page.getTotalElements(), jobTitle, e);
				}
			} else {
				// last page
				break;
			}
		}
		monitor.done();
	}
	
}

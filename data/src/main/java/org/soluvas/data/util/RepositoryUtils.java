package org.soluvas.data.util;

import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.ProgressMonitor;
import org.soluvas.commons.ProgressStatus;
import org.soluvas.commons.util.ThreadLocalProgress;
import org.soluvas.data.DataException;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.repository.PagingAndSortingRepository;
import org.soluvas.data.repository.Repository;

/**
 * Batch {@link Repository} operation support.
 * @author haidar
 */
public class RepositoryUtils {

	private static final Logger log = LoggerFactory
			.getLogger(RepositoryUtils.class);

	public static final long ITEMS_PER_PAGE = 100;
	
	/**
	 * Perform a {@link PagingAndSortingRepository}-related batch processing job ({@value #ITEMS_PER_PAGE} at a time) using {@link Pageable},
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
	public static <T> void runBatch(String jobTitle, @Nullable Sort sort, BatchFinder<T> finder, BatchProcessor<T> processor) {
		final ProgressMonitor monitor = ThreadLocalProgress.get();
		log.info("Starting batch job: {}", jobTitle);
		// get first page
		final Pageable firstPageable = sort != null ? new PageRequest(0, ITEMS_PER_PAGE, sort) : new PageRequest(0, ITEMS_PER_PAGE);
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
			// fetch next page, but only if page has valid Pageable
			if (page.getSize() > 0 && page.hasNextPage()) {
				final Pageable nextPageable = sort != null ? new PageRequest(page.getNumber() + 1, ITEMS_PER_PAGE, sort) : new PageRequest(page.getNumber() + 1, ITEMS_PER_PAGE);
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
	
	/**
	 * Perform a {@link PagingAndSortingRepository}-related batch processing job ({@value #ITEMS_PER_PAGE} at a time) using {@link Pageable},
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
	public static <T> void runBatch(String jobTitle, @Nullable Sort sort, BatchFinder<T> finder, PageProcessor<T> processor) {
		final ProgressMonitor monitor = ThreadLocalProgress.get();
		log.info("Starting batch job: {}", jobTitle);
		// get first page
		final Pageable firstPageable = sort != null ? new PageRequest(0, ITEMS_PER_PAGE, sort) : new PageRequest(0, ITEMS_PER_PAGE);
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
			try {
				processor.process(page, monitor);
				monitor.worked(page.getNumberOfElements());
				elementIndex += page.getNumberOfElements();
				elementOffset += page.getNumberOfElements();
			} catch (Exception e) {
				monitor.done(ProgressStatus.ERROR);
				throw new DataException(e, "Cannot process %d/%d (offset %d) in page %d out of %d (offset %d out of %d) in batch job '%s': %s",
						elementIndex, page.getNumberOfElements(), elementOffset,
						currentPageable.getPageNumber(), page.getTotalPages(), currentPageable.getOffset(), page.getTotalElements(), jobTitle, e);
			}
//				processor.process(page.getContent(), page.getNumber(), page.getTotalPages(), page.getTotalElements(), monitor);
			// fetch next page, but only if page has valid Pageable
			if (page.getSize() > 0 && page.hasNextPage()) {
				final Pageable nextPageable = sort != null ? new PageRequest(page.getNumber() + 1, ITEMS_PER_PAGE, sort) : new PageRequest(page.getNumber() + 1, ITEMS_PER_PAGE);
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
	
	/**
	 * Perform a {@link PagingAndSortingRepository}-related <b>subtractive</b> batch processing job ({@value #ITEMS_PER_PAGE} at a time) using {@link Pageable},
	 * with {@link ProgressMonitor} support. Subtractive means that the {@code processor} must modify the found entities in a way
	 * that {@code finder} will not return them again.
	 * 
	 * <p><b>WARNING</b>: You <b>must</b> modify the entity returned by {@code finder} inside the {@code processor}
	 * so the query used by {@code finder} will <b>not</b> return the entity again.
	 * 
	 * @param jobTitle Job name, will be used by {@link ProgressMonitor}. It will get the monitor using {@link ThreadLocalProgress#get()}.
	 * @param finder Used to fetch a {@link Pageable} of data, usually an anonymous class.
	 * @param processor Process each data {@link Page}, usually an anonymous class.
	 */
	public static <T> void runSubtractiveBatch(String jobTitle, @Nullable Sort sort, BatchFinder<T> finder, BatchProcessor<T> processor) {
		final ProgressMonitor monitor = ThreadLocalProgress.get();
		log.info("Starting batch job: {}", jobTitle);
		// get first page
		final Pageable firstPageable = sort != null ? new PageRequest(0, ITEMS_PER_PAGE, sort) : new PageRequest(0, ITEMS_PER_PAGE);
		Page<T> page;
		try {
			page = finder.find(firstPageable);
		} catch (Exception e1) {
			throw new DataException(e1, "Cannot fetch first page of batch job '%s': %s", jobTitle, e1);
		}
		
		monitor.beginTask(String.format("%d entries %d pages %s", page.getTotalElements(), page.getTotalPages(), jobTitle), page.getTotalElements());
		long iteration = 0;
		while (page.hasContent()) {
			monitor.subTask(String.format("%3d/%3d #%5d Σ%3d %s", iteration, page.getTotalPages(), firstPageable.getOffset(), page.getNumberOfElements(), jobTitle));
			long elementIndex = 0;
			long elementOffset = firstPageable.getOffset();
			for (T el : page.getContent()) {
				try {
					processor.process(el, elementIndex, elementOffset, page.getNumberOfElements(), page.getTotalElements(), iteration, page.getTotalPages(), monitor);
					monitor.worked(1);
					elementIndex++;
					elementOffset++;
				} catch (Exception e) {
					monitor.done(ProgressStatus.ERROR);
					throw new DataException(e, "Cannot process %s %d/%d (offset %d) in iteration %d out of %d (offset %d out of %d) in batch job '%s': %s",
							el.getClass().getSimpleName(), elementIndex, page.getNumberOfElements(), elementOffset,
							iteration, page.getTotalPages(), firstPageable.getOffset(), page.getTotalElements(), jobTitle, e);
				}
			}
//				processor.process(page.getContent(), page.getNumber(), page.getTotalPages(), page.getTotalElements(), monitor);
			// fetch next page
			if (page.hasNextPage()) {
				iteration++;
				try {
					page = finder.find(firstPageable);
				} catch (Exception e) {
					throw new DataException(e, "Cannot fetch iteration %d out of %d (offset %d out of %d) in batch job '%s': %s",
							iteration, page.getTotalPages(), firstPageable.getOffset(), page.getTotalElements(), jobTitle, e);
				}
			} else {
				// last page
				break;
			}
		}
		monitor.done();
	}
	
}

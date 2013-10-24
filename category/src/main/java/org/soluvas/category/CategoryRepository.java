package org.soluvas.category;

import java.util.Collection;

import javax.annotation.Nullable;

import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.repository.PagingAndSortingRepository;

/**
 * {@link PagingAndSortingRepository} for {@link Category}.
 * @author ceefour
 */
public interface CategoryRepository extends
		PagingAndSortingRepository<Category, String> {

	Page<Category> findAllByStatus(Collection<CategoryStatus> statuses, Pageable pageable);

	@Nullable
	Category findOneBySlugPath(String slugPath, Collection<CategoryStatus> statuses);
	
	Page<Category> findAllOriginalByStatus(Collection<CategoryStatus> statuses, Pageable pageable);
	
	Page<Category> findAllByLevelAndStatus(Collection<CategoryStatus> statuses, int level, Pageable pageable);

}

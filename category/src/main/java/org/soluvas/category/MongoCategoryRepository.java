package org.soluvas.category;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Nullable;

import org.soluvas.data.EntityLookupException;
import org.soluvas.data.Existence;
import org.soluvas.data.StatusMask;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.repository.PagingAndSortingRepository;

/**
 * {@link PagingAndSortingRepository} for {@link Category}.
 * @author ceefour
 */
public interface MongoCategoryRepository extends
		PagingAndSortingRepository<Category2, String> {

	Page<Category2> findAllByStatus(Collection<CategoryStatus> statuses, Pageable pageable);
	
	Page<Category2> findAllByStatusExCacheable(Collection<CategoryStatus> statuses, Pageable pageable);
	
	@Nullable
	Category2 findOneBySlugPath(String slugPath, Collection<CategoryStatus> statuses);
	
	/**
	 * Find category by {@link Category#getPrimaryUri()} or {@link Category#getSameAsUris()}.
	 * @param statuses
	 * @param uri
	 * @return
	 */
	Category2 lookupOneByUri(Set<CategoryStatus> statuses, String uri) throws EntityLookupException;
	
	Page<Category2> findAllByLevelAndStatus(Collection<CategoryStatus> statuses, int level, Pageable pageable);
	
	Page<Category2> findAllByLevelAndStatusExCacheable(Collection<CategoryStatus> statuses, int level, Pageable pageable);
	
	Page<Category2> findAllByLevelAndStatus(Collection<CategoryStatus> statuses, int level, String parentId, Pageable pageable);
	
	Page<Category2> findAllByLevelAndStatusExCacheable(Collection<CategoryStatus> statuses, int level, String parentId, Pageable pageable);

	Existence<String> existsBySlugPath(StatusMask statusMask, String upSlugPath);
	
	Set<String> findAllSlugPathsByStatus(Collection<CategoryStatus> statuses);

	Page<Category2> findAllLeavesByStatus(Collection<CategoryStatus> statuses, Pageable pageable);
	
	Page<Category2> findAll(@Nullable String searchText, Collection<CategoryStatus> statuses, Pageable pageable);
	
	long countAll(@Nullable String searchText, Collection<CategoryStatus> statuses);

	Category2 getFirstActive();
	

}

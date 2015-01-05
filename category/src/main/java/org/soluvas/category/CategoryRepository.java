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

import com.google.common.base.Optional;

/**
 * {@link PagingAndSortingRepository} for {@link Category}.
 * @author ceefour
 */
public interface CategoryRepository extends
		PagingAndSortingRepository<Category, String> {

	Page<Category> findAllByStatus(Collection<CategoryStatus> statuses, Pageable pageable);

	@Nullable
	Category findOneBySlugPath(String slugPath, Collection<CategoryStatus> statuses);
	
	/**
	 * Find category by {@link Category#getPrimaryUri()} or {@link Category#getSameAsUris()}.
	 * @param statuses
	 * @param uri
	 * @return
	 */
	Category lookupOneByUri(Set<CategoryStatus> statuses, String uri) throws EntityLookupException;
	
	Page<Category> findAllOriginalByStatus(Collection<CategoryStatus> statuses, Pageable pageable);
	
	Page<Category> findAllByLevelAndStatus(Collection<CategoryStatus> statuses, int level, boolean notForHasChildren, Pageable pageable);

	/**
	 * Return the first {@link CategoryStatus#ACTIVE} leaf {@link Category}.
	 * @return
	 * @see id.co.bippo.product.hand.ProductCreator
	 */
	Optional<Category> getFirstActiveLeaf();

	Existence<String> existsBySlugPath(StatusMask statusMask, String upSlugPath);
	
	Set<String> findAllSlugPathsByStatus(Collection<CategoryStatus> statuses);

	Page<Category> findAllLeavesByStatus(Collection<CategoryStatus> statuses,
			Pageable pageable);
	

}

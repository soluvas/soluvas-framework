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
public interface MongoCategoryRepository extends
		PagingAndSortingRepository<Category2, String> {

	Page<Category2> findAllByStatus(Collection<CategoryStatus> statuses, Pageable pageable);

	@Nullable
	Category2 findOneBySlugPath(String slugPath, Collection<CategoryStatus> statuses);
	
	/**
	 * Find category by {@link Category#getPrimaryUri()} or {@link Category#getSameAsUris()}.
	 * @param statuses
	 * @param uri
	 * @return
	 */
	Category2 lookupOneByUri(Set<CategoryStatus> statuses, String uri) throws EntityLookupException;
	
	/**
	 * @param statuses
	 * @param level The "implicit root category" has level 0. So a Category without a parent has level 1. Automatically updated on save.
	 * @param excludeLeaves If {@code true}, excludes {@link Category}s which don't have children.
	 * @param pageable
	 * @return
	 */
	Page<Category2> findAllByLevelAndStatus(Collection<CategoryStatus> statuses, int level, boolean excludeLeaves, Pageable pageable);

	/**
	 * Return the first {@link CategoryStatus#ACTIVE} leaf {@link Category}.
	 * @return
	 * @see id.co.bippo.product.hand.ProductCreator
	 */
	Optional<Category2> getFirstActiveLeaf();

	Existence<String> existsBySlugPath(StatusMask statusMask, String upSlugPath);
	
	Set<String> findAllSlugPathsByStatus(Collection<CategoryStatus> statuses);

	Page<Category2> findAllLeavesByStatus(Collection<CategoryStatus> statuses,
			Pageable pageable);
	

}

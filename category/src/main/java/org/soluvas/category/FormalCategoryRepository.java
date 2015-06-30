package org.soluvas.category;

import java.util.Optional;

import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.repository.PagingAndSortingRepository;

public interface FormalCategoryRepository extends PagingAndSortingRepository<FormalCategory, Long> {

	Optional<FormalCategory> findOne(long googleId);
	
	Page<FormalCategory> findAllBySearchText(final String searchText, Pageable pageable);

}
package org.soluvas.category;

import java.io.IOException;
import java.util.Optional;

import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.repository.PagingAndSortingRepository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface FormalCategoryRepository extends PagingAndSortingRepository<FormalCategory, Long> {

	Optional<FormalCategory> findOne(long googleId);
	
	Page<FormalCategory> findAllBySearchText(final String searchText, Pageable pageable);

	void init() throws JsonParseException, JsonMappingException, IOException;

}
package org.soluvas.mongo;


import java.util.Collection;

import org.soluvas.data.Existence;
import org.soluvas.data.Term2;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.repository.PagingAndSortingRepository;

/**
 * @author rudi
 *
 */
public interface MongoTermRepository extends PagingAndSortingRepository<Term2, String> {
	
	Page<Term2> findAllByEnumId(String enumerationId, Pageable pageable);
	
	Page<Term2> findAll(Collection<String> ids, Pageable pageable);
	
	Page<Term2> findAll(String enumerationId, String searchText, Pageable pageable);
	
	Page<Term2> findAll(String enumerationId, Pageable pageable);
	
	long countByEnumId(String enumerationId);
	
	Existence<String> existsByEnumerationId(String enumerationId, String termId);
	
	Term2 findOneByFormalId(String formalId);

}

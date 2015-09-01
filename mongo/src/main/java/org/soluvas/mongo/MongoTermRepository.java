package org.soluvas.mongo;


import org.soluvas.data.Existence;
import org.soluvas.data.Term2;
import org.soluvas.data.TermKind;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.repository.PagingAndSortingRepository;

/**
 * @author rudi
 *
 */
public interface MongoTermRepository extends PagingAndSortingRepository<Term2, String> {
	
	Page<Term2> findAll(TermKind termKind, Pageable pageable);
	
	Page<Term2> findAll(String enumerationId, String searchText, Pageable pageable);
	
	long count(TermKind termKind);
	
	Existence<String> existsByEnumerationId(String enumerationId, String termId);
	
	Term2 findOneByFormalId(String formalId);

}

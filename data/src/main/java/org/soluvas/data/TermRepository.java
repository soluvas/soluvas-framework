package org.soluvas.data;

import org.soluvas.data.repository.PagingAndSortingRepository;

/**
 * Use MongoTermRepository
 * 
 * @author ceefour
 */
@Deprecated
public interface TermRepository extends
		PagingAndSortingRepository<Term, String> {
	
	DataCatalog getDataCatalog();

}

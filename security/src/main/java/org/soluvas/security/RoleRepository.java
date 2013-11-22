package org.soluvas.security;

import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.repository.PagingAndSortingRepository;

/**
 * Repository of {@link Role} entities. Refactored from {@link SecurityRepository}.
 * @author rudi
 */
public interface RoleRepository extends PagingAndSortingRepository<Role, String> {

	public Page<String> findAllIds(Pageable pageable);

}

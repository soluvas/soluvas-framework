package org.soluvas.data.customerrole;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.soluvas.commons.CustomerRole;
import org.soluvas.data.StatusMask;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.repository.CrudRepository;

/**
 * @author rudi
 *
 */
public interface CustomerRoleRepository extends CrudRepository<CustomerRole, String> {
	
	Page<CustomerRole> findAll(@Nonnull StatusMask statusMask, @Nonnull Pageable pageable);
	
	Page<CustomerRole> findAll(@Nonnull StatusMask statusMask, @Nullable String searchText, @Nonnull Pageable pageable);
	
	long count(@Nonnull StatusMask statusMask);
	
}

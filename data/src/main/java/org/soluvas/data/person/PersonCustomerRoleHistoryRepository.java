package org.soluvas.data.person;

import org.soluvas.commons.PersonCustomerRoleHistory;
import org.soluvas.data.GenericLookup;
import org.soluvas.data.SlugLookup;
import org.soluvas.data.repository.PagingAndSortingRepository;

public interface PersonCustomerRoleHistoryRepository
		extends PagingAndSortingRepository<PersonCustomerRoleHistory, String>, SlugLookup<PersonCustomerRoleHistory>,
		GenericLookup<PersonCustomerRoleHistory> {

}

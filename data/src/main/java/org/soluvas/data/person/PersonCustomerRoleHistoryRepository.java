package org.soluvas.data.person;

import java.util.List;
import java.util.Set;

import org.soluvas.commons.PersonCustomerRoleHistory;
import org.soluvas.data.repository.PagingAndSortingRepository;

public interface PersonCustomerRoleHistoryRepository  extends PagingAndSortingRepository<PersonCustomerRoleHistory, String> {

	public List<PersonCustomerRoleHistory> findByToCustomerRoleId(Set<String> toCustomerRoleIds);

	public List<PersonCustomerRoleHistory> findByPersonInfoId(String id);
	
}

package org.soluvas.data.person;

import java.util.List;
import java.util.Set;

import org.soluvas.commons.PersonCustomerRoleHistory;

public interface PersonCustomerRoleHistoryRepository {
	
	public void addNewHistory(PersonCustomerRoleHistory newHistory);

	public List<PersonCustomerRoleHistory> findByToCustomerRoleId(Set<String> toCustomerRoleIds);
	
}

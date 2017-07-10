package org.soluvas.mongo;

import org.soluvas.commons.PersonCustomerRoleHistory;
import org.soluvas.data.person.PersonCustomerRoleHistoryRepository;

/**
 * 
 * @author atang
 *
 */
public class MongoPersonCustomerRoleHistoryRepository extends MongoRepositoryBase<PersonCustomerRoleHistory> implements
		PersonCustomerRoleHistoryRepository {

	public MongoPersonCustomerRoleHistoryRepository(String mongoUri, boolean migrationEnabled, boolean autoExplainSlow) {
		super(PersonCustomerRoleHistory.class, PersonCustomerRoleHistory.class, 1l, mongoUri, 
				ReadPattern.DUAL, "personCustomerRoleHistory", migrationEnabled, autoExplainSlow);

	}
	
	@Override
	public void addNewHistory(PersonCustomerRoleHistory newHistory) {
		add(newHistory);
	}

}

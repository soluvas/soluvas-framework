package org.soluvas.mongo;

import java.util.UUID;

import org.joda.time.DateTime;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.PersonCustomerRoleHistory;
import org.soluvas.commons.impl.CustomerRole2;
import org.soluvas.commons.impl.PersonInfoImpl;
import org.soluvas.data.person.PersonCustomerRoleHistoryRepository;

/**
 * @author rudi
 *
 */
public class MongoCustomerRoleRepositoryTest {
	
	private static final Logger log = LoggerFactory
			.getLogger(MongoCustomerRoleRepositoryTest.class);
	
	private final PersonCustomerRoleHistoryRepository repo;
	
	public MongoCustomerRoleRepositoryTest() {
		repo = new MongoPersonCustomerRoleHistoryRepository("mongodb://127.0.0.1:27017/tuneeca_dev", false, false);
	}

	@Test
	public void findOneById() {
		final String queryId = "common";
		final CustomerRole2 customerRole = repo.findOne(queryId);
		log.info("Got customerRole by id '{}': {}", queryId, customerRole);
	}
	
	@Test
	public void add() {
		PersonCustomerRoleHistory newHistory = new PersonCustomerRoleHistory();
		newHistory.setId(UUID.randomUUID().toString());
		newHistory.setPersonInfo(new PersonInfoImpl());
		newHistory.setFromCustomerRole("common");
		newHistory.setToCustomerRole("drop_ship");
		newHistory.setModificationTime(new DateTime());
		repo.addNewHistory(newHistory);
	}

}

package org.soluvas.mongo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.impl.CustomerRole2;
import org.soluvas.data.customerrole.CustomerRoleRepository;

/**
 * @author rudi
 *
 */
public class MongoCustomerRoleRepositoryTest {
	
	private static final Logger log = LoggerFactory
			.getLogger(MongoCustomerRoleRepositoryTest.class);
	
	private final CustomerRoleRepository repo;

	public MongoCustomerRoleRepositoryTest() {
		repo = new MongoCustomerRoleRepository("mongodb://127.0.0.1:27017/tuneeca_dev", false, false);
	}

	@Test
	public void findOneById() {
		final String queryId = "common";
		final CustomerRole2 customerRole = repo.findOne(queryId);
		log.info("Got customerRole by id '{}': {}", queryId, customerRole);
	}

}

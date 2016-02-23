package org.soluvas.security.mongo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.security.Role2;

/**
 * @author anisa
 *
 */
public class MongoRolePersonRepository2Test {
	
	private static final Logger log = LoggerFactory.getLogger(MongoRolePersonRepository2Test.class);
	
	private final MongoRolePersonRepository2 rolePersonRepo;

	public MongoRolePersonRepository2Test() {
		super();
		this.rolePersonRepo = new MongoRolePersonRepository2("mongodb://127.0.0.1:27017/tingbelmart_dev");
	}

	@Test
	public void findOneById() {
		final String id = "";
		final Role2 role = rolePersonRepo.findOne(id);
		
		log.info("Find one by id '{}': {}", id, role);
	}

}

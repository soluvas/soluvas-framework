package org.soluvas.security.mongo;

import org.joda.time.DateTime;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.security.AssignMode;
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
		final String id = "admin";
		final Role2 role = rolePersonRepo.findOne(id);
		
		log.info("Find one by id '{}': {}", id, role);
	}
	
	@Test
	public void addNew() {
		final Role2 role = new Role2();
		role.setAssignMode(AssignMode.AUTHENTICATED);
		role.setCreationTime(new DateTime());
		role.setDescription("Description");
		role.setId("Id");
		role.setModificationTime(new DateTime());
		role.setName("Name");
		
		rolePersonRepo.add(role);
		log.debug("inserting....");
	}

	@Test
	public void modifyData() {
		final String idRole = ("3");
		final Role2 role = rolePersonRepo.findOne(idRole);
		role.setName("Name");
		
		final Role2 modifiedRole = rolePersonRepo.modify(idRole, role);
		log.info("Role '{}' has been modified", modifiedRole.getId());
	}
	
}

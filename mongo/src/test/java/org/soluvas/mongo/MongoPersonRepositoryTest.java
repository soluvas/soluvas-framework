/**
 * 
 */
package org.soluvas.mongo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AccountStatus;
import org.soluvas.commons.Person;
import org.soluvas.commons.impl.PersonImpl;
import org.soluvas.data.person.PersonRepository;

import com.aksimata.person.MongoPersonRepository;
import com.google.code.morphia.logging.MorphiaLoggerFactory;
import com.google.code.morphia.logging.slf4j.SLF4JLogrImplFactory;
import com.google.common.collect.ImmutableList;

/**
 * @author atang
 *
 */
public class MongoPersonRepositoryTest {
	private static final Logger log = LoggerFactory
			.getLogger(MongoPersonRepositoryTest.class);
	
	private PersonRepository personRepo;
	
	static {
		MorphiaLoggerFactory.registerLogger(SLF4JLogrImplFactory.class);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		personRepo = new MongoPersonRepository("mongodb://127.0.0.1:27017/tuneeca_dev");
	}
	
	@Test
	public void addPerson() {
		final Person person = new PersonImpl();
		person.setId("atang");
		person.setName("Atang Sutisna");
		person.setAccountStatus(AccountStatus.ACTIVE);
		
		final ImmutableList<String> roles = ImmutableList.of("admin", "sysadmin");
		person.getSecurityRoleIds().addAll(roles);
		final Person personAdded = personRepo.add(person);
		assertNotNull(personAdded);
		assertEquals(personAdded, person);
		
		log.info("1 person was added {} ", personAdded);
	}

}

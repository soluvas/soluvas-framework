/**
 * 
 */
package org.soluvas.mongo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AccountStatus;
import org.soluvas.commons.Person;
import org.soluvas.commons.impl.PersonImpl;
import org.soluvas.data.StatusMask;
import org.soluvas.data.domain.CappedRequest;
import org.soluvas.data.domain.Page;
import org.soluvas.data.person.PersonRepository;

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
		personRepo = new MongoPersonRepository("mongodb://127.0.0.1:27017/tuneeca_dev", false, true);
	}
	
	@Test
	public void addPerson() {
		final Person person = new PersonImpl();
		person.setId("atang");
		person.setName("Atang Sutisna");
		person.setAccountStatus(AccountStatus.ACTIVE);
		
		final List<String> roles = ImmutableList.of("admin", "sysadmin");
		person.getSecurityRoleIds().addAll(roles);
		final Person personAdded = personRepo.add(person);
		assertNotNull(personAdded);
		assertEquals(personAdded, person);
		
		log.info("1 person was added {} ", personAdded);
	}
	
	@Test
	public void canFindOneBySlug() {
		final String slug = "yuni-arcadia";
		final Person person = personRepo.findOneBySlug(StatusMask.ACTIVE_ONLY, slug);
		assertNotNull(String.format("Person by slug %s must not be null", slug),  person);
		log.info("Got person by slug {}: {}", slug, person);
	}
	
	@Test
	public void findAllBySecRoleIdsAndStatus() {
		final List<String> secRoleIds = ImmutableList.of("sales_admin", "sales_staff");
		final List<Person> personList = personRepo.findAllBySecRoleIds(StatusMask.ACTIVE_ONLY, secRoleIds);
		log.debug("People by secRoleIds {} and statusMask Active Only: {}", secRoleIds, personList);
		assertEquals(3, personList.size());
	}
	
	@Test
	public void findByPhoneNumberOrMobileNumber() {
		final String mobileNumber = "+6285286185328";
		final Person person = personRepo.findOneByPhoneNumber(StatusMask.INCLUDE_INACTIVE, mobileNumber);
		assertNotNull(person);
		log.debug("we found person {} with mobileNumber {}", person, mobileNumber);
	}
	
	@Test
	public void findPersonByMobileNumber() {
		final String mobileNumber = "+6285286185328";
		
		final Page<Person> personPage = personRepo.findBySearchText(StatusMask.INCLUDE_INACTIVE, mobileNumber, new CappedRequest(100));
		assertNotNull(personPage.getContent());
		log.info("web found {} person with mobileNumber {}", personPage.getContent(), mobileNumber);
	}
	
	@Test
	public void findOneBySearchText() {
		final String searchText = "emiral_diana_15382";
		final List<Person> people = personRepo.findBySearchText(ImmutableList.of(AccountStatus.ACTIVE, AccountStatus.VERIFIED), searchText,
				new CappedRequest(10)).getContent();
		assertEquals(1, people.size());
	}
	
	@Test
	public void findOne() {
		final String personId = "atang";
		final Person person = personRepo.findOne(personId);
		assertNull("Person tidak boleh kosong", person);
		log.debug("result findone person {}", person);
//		assertNull("Rules must be not null", person.getCustomerRole());
		
	}
	
}

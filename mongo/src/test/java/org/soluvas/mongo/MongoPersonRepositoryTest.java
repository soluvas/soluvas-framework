/**
 * 
 */
package org.soluvas.mongo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AccountStatus;
import org.soluvas.commons.PostalAddress2;
import org.soluvas.commons.entity.Person2;
import org.soluvas.data.StatusMask;
import org.soluvas.data.domain.CappedRequest;
import org.soluvas.data.domain.Page;
import org.soluvas.data.person.PersonRepository;

import com.google.code.morphia.logging.MorphiaLoggerFactory;
import com.google.code.morphia.logging.slf4j.SLF4JLogrImplFactory;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

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
		personRepo = new MongoPersonRepository("tuneeca", null, "mongodb://127.0.0.1:27017/tuneeca_dev", false, true);
	}
	
	@Test
	public void addPerson() {
		final Person2 person = new Person2();
		person.setId("atang");
		person.setName("Atang Sutisna");
		person.setAccountStatus(AccountStatus.ACTIVE);
		
		final List<String> roles = ImmutableList.of("admin", "sysadmin");
		person.getSecurityRoleIds().addAll(roles);
		final Person2 personAdded = personRepo.add(person);
		assertNotNull(personAdded);
		assertEquals(personAdded, person);
		
		log.info("1 person was added {} ", personAdded);
	}
	
	@Test
	public void canFindOneBySlug() {
		final String slug = "yuni-arcadia";
		final Person2 person = personRepo.findOneBySlug(StatusMask.ACTIVE_ONLY, slug);
		assertNotNull(String.format("Person by slug %s must not be null", slug),  person);
		log.info("Got person by slug {}: {}", slug, person);
	}
	
	@Test
	public void findAllBySecRoleIdsAndStatus() {
		final List<String> secRoleIds = ImmutableList.of("sales_admin", "sales_staff");
		final List<Person2> personList = personRepo.findAllBySecRoleIds(StatusMask.ACTIVE_ONLY, secRoleIds);
		log.debug("People by secRoleIds {} and statusMask Active Only: {}", secRoleIds, personList);
		assertEquals(3, personList.size());
	}
	
	@Test
	public void findByPhoneNumberOrMobileNumber() {
		final String mobileNumber = "+6285286185328";
		final Person2 person = personRepo.findOneByMobileOrPhoneNumber(StatusMask.INCLUDE_INACTIVE, mobileNumber);
		assertNotNull(person);
		log.debug("we found person {} with mobileNumber {}", person, mobileNumber);
	}
	
	@Test
	public void findPersonByMobileNumber() {
		final String mobileNumber = "+6285286185328";
		
		final Page<Person2> personPage = personRepo.findBySearchText(StatusMask.INCLUDE_INACTIVE, mobileNumber, new CappedRequest(100));
		assertNotNull(personPage.getContent());
		log.info("web found {} person with mobileNumber {}", personPage.getContent(), mobileNumber);
	}
	
	@Test
	public void findOneBySearchText() {
		final String searchText = "emiral_diana_15382";
		final List<Person2> people = personRepo.findAllByKeywordAndStatus(searchText, ImmutableList.of(AccountStatus.ACTIVE, AccountStatus.VERIFIED), 
				new CappedRequest(10)).getContent();
		assertEquals(1, people.size());
	}
	
	@Test
	public void findOne() {
		final String personId = "atang";
		final Person2 person = personRepo.findOne(personId);
		assertNull("Person tidak boleh kosong", person);
		log.debug("result findone person {}", person);
//		assertNull("Rules must be not null", person.getCustomerRole());
		
	}
	
	@Test
	public void findCustomerRole() {
		final String personId = "listriana_suherman";
		final String customerRole = personRepo.getCustomerRoleByPersonId(personId);
	}
	
	@Test
	public void existsByPhoneNumberOrMobileNumber() {
		final String mobileOrPhoneNumber = "081655649656";
		final boolean existsByMobileOrPhoneNumber = personRepo.isMobilePhoneNumberAlreadyRegistered(StatusMask.RAW, mobileOrPhoneNumber);
		assertTrue(existsByMobileOrPhoneNumber);
	}
	
	@Test
	public void nameTest() {
		final String newName = " rudi wijaya";
		final String[] nameArray = newName.split(" ", 2);
		final String firstName = nameArray[0];
		log.debug("firstName '{}'", firstName);
		if (nameArray.length > 1) {
			final String lastName = nameArray[1];
			log.debug("lastName '{}'", lastName);
		}
	}
	
	@Test
	public void getFcmTokens() {
		final ImmutableSet<String> fcmTokens = personRepo.getFcmTokens("ingga_bia_putri");
	}
	
	@Test
	public void checkStartUpResellerAdd() {
		Person2 person = personRepo.findOne("atang");
		PostalAddress2 inputAddr = new PostalAddress2();
		inputAddr.setId(UUID.fromString("ea27abc2-af4d-4791-aac5-c97f03bd2a17"));
		inputAddr.setName("batman");
		inputAddr.setStreet("fasdf asdf");
		inputAddr.setCity("Bandung");
		inputAddr.setPostalCode("12345");
		inputAddr.setProvince("Jawa Barat");
		inputAddr.setCountry("Indonesia");
		inputAddr.setCountryCode("ID");
		inputAddr.setPrimaryMobile("08912333377");
		inputAddr.setPrimaryEmail("batman@gmail.com");
		inputAddr.setPrimary(Boolean.FALSE);
		inputAddr.setPrimaryBilling(Boolean.FALSE);
		inputAddr.setPrimaryShipping(Boolean.FALSE);
		inputAddr.setDistrict("Andir");
		inputAddr.setStartupReseller(Boolean.TRUE);
		inputAddr.setStartupResellerId("atang");
		inputAddr.setStartupResellerRegistartion(new Date(1539795600000L));
		
		java.util.Optional<PostalAddress2> resellerAddr = person.getAddresses().stream().filter(new java.util.function.Predicate<PostalAddress2>() {
			@Override
			public boolean test(PostalAddress2 t) {
				return t.isEqualWith(inputAddr) && t.isStartupReseller();
			}
		}).findFirst();
		
		if (!resellerAddr.isPresent()) {
			System.out.println("gak ade");
		} else {
			Date regDate = resellerAddr.get().getStartupResellerRegistartion();
			boolean lessThan3Month = regDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isBefore(
					LocalDate.now().minusMonths(3)
					);
			System.out.println(!lessThan3Month);
		}
		
		
	}
	
}

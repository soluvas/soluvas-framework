package org.soluvas.ldap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.directory.ldap.client.api.LdapConnectionConfig;
import org.apache.directory.ldap.client.api.LdapConnectionPool;
import org.apache.directory.ldap.client.api.LdapNetworkConnection;
import org.apache.directory.ldap.client.api.PoolableLdapConnectionFactory;
import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AccountStatus;
import org.soluvas.commons.Gender;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

/**
 * Test {@link LdapRepository} for {@link SocialPerson}.
 * @author ceefour
 */
public class PooledLdapRepositoryTest {

	private static final Logger log = LoggerFactory.getLogger(PooledLdapRepositoryTest.class);
	private LdapNetworkConnection conn;
	private LdapRepository<SocialPerson> personRepo;
	private LdapConnectionPool pool;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		final LdapConnectionConfig config = LdapUtils.createTrustingConfig("ldap://localhost:389", "cn=admin,dc=dev,dc=tuneeca,dc=com", "secret");
		pool = new LdapConnectionPool(new PoolableLdapConnectionFactory(config));
		personRepo = new PooledLdapRepository<SocialPerson>(SocialPerson.class, pool, "ou=users,dc=dev,dc=tuneeca,dc=com");
		personRepo.init();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		pool.close();
	}

	@Test
	public void findOne() {
		SocialPerson hendy = personRepo.findOne("hendy");
		Assert.assertNotNull(hendy);
		Assert.assertEquals("hendy", hendy.getId());
		Assert.assertEquals("Hendy Irawan", hendy.getName());
	}

	@Test
	public void findAll() {
		List<SocialPerson> people = personRepo.findAll();
		List<String> names = Lists.transform(people, new Function<SocialPerson, String>() {
			@Override
			public String apply(SocialPerson input) {
				return input.getId() + " (" + input.getName() + ")";
			}
		});
		log.info("Returned person objects: {}", names);
		Assert.assertNotNull(people);
		Assert.assertTrue(people.size() >= 2);
	}

	@Test
	public void delete() {
		SocialPerson liz = personRepo.findOne("liz");
		Assert.assertNotNull(liz);
		personRepo.delete("liz");
		SocialPerson deletedLiz = personRepo.findOne("liz");
		Assert.assertNull(deletedLiz);
	}

	@Test
	public void add() {
		SocialPerson liz = new SocialPerson("liz", "liz.lemon", "Liz", "Lemon", Gender.FEMALE);
		liz.setEmails(ImmutableSet.of("liz.lemon@example.com", "liz@example.com"));
		liz.setPhotoId("liz_lemon");
		liz.setFacebookId(123456L);
		liz.setFacebookUsername("liz.lemon");
		liz.setTwitterId(123456L);
		liz.setTwitterScreenName("liz.lemon");
		liz.setBirthDate(new DateTime(new Date()));
		liz.setNewsletterSubscriptionEnabled(true);
		liz.setNewsletterSubscriptionTime(new DateTime());
		liz.setSignupSourceType(SignupSourceType.ALIA_MAGAZINE);
		liz.setAccountStatus(AccountStatus.ACTIVE);
		
		log.info("Input Person: {}", liz);
		
		SocialPerson newLiz = personRepo.add(liz);
		Assert.assertNotNull(newLiz);
		
		SocialPerson foundLiz = personRepo.findOne("liz");
		Assert.assertNotNull(foundLiz);
		Assert.assertEquals("liz", foundLiz.getId());
		Assert.assertEquals("Liz Lemon", foundLiz.getName());
	}

	@Test
	public void modifyWithRename() {
		final String oldId = "liz";
		final String newId = "lix";
		final String newName = UUID.randomUUID().toString();
		
		final SocialPerson liz = personRepo.findOne(oldId);
		log.info("Input Person: {}", liz);
		liz.setId(newId);
		liz.setName(newName);
		
		final SocialPerson newLiz = personRepo.modify(oldId, liz);
		Assert.assertNotNull(newLiz);
		Assert.assertEquals(newId, newLiz.getId());
		Assert.assertEquals(newName, newLiz.getName());
	}

	@Test
	public void modifyWithRename2() {
		final String oldId = "lix";
		final String newId = "rudi";
		final String newName = "Rudi Wijaya";
		final String slug = "rudi123";
		final String primaryEmail = "rudi@yahoo.com";
		
		final SocialPerson oldTONew = personRepo.findOne(oldId);
		log.info("Input Person: {}", oldTONew);
		oldTONew.setId(newId);
		oldTONew.setName(newName);
		oldTONew.setSlug(slug);
		oldTONew.setPrimaryEmail(primaryEmail);
		
		final SocialPerson newLix = personRepo.modify(oldId, oldTONew);
		Assert.assertNotNull(newLix);
		Assert.assertEquals(newId, newLix.getId());
		Assert.assertEquals(newName, newLix.getName());
	}

	@Test(expected=Exception.class)
	public void modifyShouldThrowExceptionIfFailed() {
		SocialPerson person = personRepo.findOne("hendy");
		person.setId("nana");
		SocialPerson modified = personRepo.modify(person);
		log.info("Modified person: ", modified);
	}
	
	@Test
	public void findAllByMultipleFilter() {
//		final String filter = "(cn=*ang*)";
		final String filter = "(|(cn=*ang*)(mobile=*0856*))";
		final List<SocialPerson> people = personRepo.findAllByFilter(filter);
		
		log.info("User by filter has {} records", people.size());
	}
	
	@Test
	public void findAllByEmail() {
		final String email = "atang.sutisna.87@gmail.com";
		SocialPerson person = personRepo.findOneByAttribute("primaryMail", email);
		log.info("Finding person with email {} : {}", email, person);
		assertNotNull("Person must not be null", person);
		assertEquals("atang", person.getId());
	}
	
	@Test
	public void checkExpirePasswordResetCode() {
		SocialPerson person = personRepo.findOne("atang");
		
		DateTime passwordResetExpiryTime = person.getPasswordResetExpiryTime();
		Date dateExpire = passwordResetExpiryTime.toDate();
		DateMidnight dateMidnightExpire = new DateMidnight(dateExpire);
		
		DateMidnight confirmTime = new DateMidnight(2013, 03, 31);
		assertEquals(true, confirmTime.isAfter(passwordResetExpiryTime));
	}
	
	@Test
	public void modifyPasswordResetSettings() {
		final SocialPerson person = personRepo.findOne("test");
		person.setPasswordResetCode("abc");
		person.setPasswordResetExpiryTime(new DateTime().plusDays(2));
		personRepo.modify(person.getId(), person);
		
		final SocialPerson modified = personRepo.findOne("test");
		log.info("Modified person: {}", modified);
		assertEquals("abc", modified.getPasswordResetCode());
		assertTrue(modified.getPasswordResetExpiryTime().isAfterNow());
	}
	
}

package org.soluvas.ldap;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.directory.ldap.client.api.LdapConnectionConfig;
import org.apache.directory.ldap.client.api.LdapConnectionPool;
import org.apache.directory.ldap.client.api.LdapNetworkConnection;
import org.apache.directory.ldap.client.api.PoolableLdapConnectionFactory;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.ldap.SocialPerson.Gender;

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
		LdapConnectionConfig config = LdapUtils.createTrustingConfig("ldap://localhost:389", "cn=admin,dc=dev,dc=berbatik,dc=com", "secret");
		pool = new LdapConnectionPool(new PoolableLdapConnectionFactory(config));
		personRepo = new PooledLdapRepository<SocialPerson>(SocialPerson.class, pool, "ou=users,dc=dev,dc=berbatik,dc=com");
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
		final String newId = "liz";
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

	@Test(expected=Exception.class)
	public void modifyShouldThrowExceptionIfFailed() {
		SocialPerson person = personRepo.findOne("hendy");
		person.setId("nana");
		SocialPerson modified = personRepo.modify(person);
		log.info("Modified person: ", modified);
	}

}

package org.soluvas.ldap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.directory.shared.ldap.model.entry.DefaultEntry;
import org.apache.directory.shared.ldap.model.entry.Entry;
import org.apache.directory.shared.ldap.model.exception.LdapInvalidAttributeValueException;
import org.apache.directory.shared.ldap.model.exception.LdapInvalidDnException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.ldap.SocialPerson.Gender;

import com.google.common.collect.ImmutableSet;

/**
 * Test mapping of {@link Person} to {@link Entry} and back.
 * @author ceefour
 */
public class LdapMapperTest {

	private transient Logger log = LoggerFactory.getLogger(LdapMapperTest.class);
	private LdapMapper mapper;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mapper = new LdapMapper();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test public void canMapSimpleClassToEntry() throws LdapInvalidAttributeValueException {
		Person hendy = new Person("hendy", "hendy.irawan", "Hendy", "Irawan", "hendy@soluvas.com");
		log.info("Input Person: {}", hendy);
		
		Entry entry = mapper.toEntry(hendy, "ou=users,dc=aksimata,dc=com");
		log.info("Output Entry: {}", entry);
		
		assertTrue( entry.contains("objectClass", "organizationalPerson", "uidObject", "extensibleObject") );
		assertEquals("uid=hendy,ou=users,dc=aksimata,dc=com", entry.getDn().toString());
		assertEquals("hendy", entry.get("uid").getString());
		assertEquals("hendy.irawan", entry.get("uniqueIdentifier").getString());
		assertEquals("Hendy", entry.get("gn").getString());
		assertEquals("Irawan", entry.get("sn").getString());
		assertEquals("Hendy Irawan", entry.get("cn").getString());
		assertEquals("hendy@soluvas.com", entry.get("mail").getString());
	}

	@Test
	public void canMapMultiValuesToEntry() throws LdapInvalidAttributeValueException {
		Person hendy = new Person("hendy", "hendy.irawan", "Hendy", "Irawan", "male");
		hendy.setEmails(ImmutableSet.of("hendy@soluvas.com", "hendy@bippo.co.id", "ceefour666@gmail.com"));
		log.info("Input Person: {}", hendy);
		
		Entry entry = mapper.toEntry(hendy, "ou=users,dc=aksimata,dc=com");
		log.info("Output Entry: {}", entry);
		
		assertTrue( entry.contains("objectClass", "organizationalPerson", "uidObject", "extensibleObject") );
		assertEquals("uid=hendy,ou=users,dc=aksimata,dc=com", entry.getDn().toString());
		assertEquals("hendy", entry.get("uid").getString());
		assertEquals("hendy.irawan", entry.get("uniqueIdentifier").getString());
		assertEquals("Hendy", entry.get("gn").getString());
		assertEquals("Irawan", entry.get("sn").getString());
		assertEquals("Hendy Irawan", entry.get("cn").getString());
		assertTrue( entry.contains("mail", "hendy@soluvas.com", "hendy@bippo.co.id", "ceefour666@gmail.com") );
	}
	
	@Test
	public void canMapSubclassToEntry() throws LdapInvalidAttributeValueException {
		SocialPerson hendy = new SocialPerson("hendy", "hendy.irawan", "Hendy", "Irawan", Gender.MALE);
		hendy.setEmails(ImmutableSet.of("hendy@soluvas.com", "hendy@bippo.co.id", "ceefour666@gmail.com"));
		hendy.setPhotoId("hendy");
		hendy.setFacebookId(596326671L);
		hendy.setFacebookUsername("ceefour");
		hendy.setTwitterId(384154265L);
		hendy.setTwitterScreenName("hendyirawan");
		log.info("Input Person: {}", hendy);
		
		Entry entry = mapper.toEntry(hendy, "ou=users,dc=aksimata,dc=com");
		log.info("Output Entry: {}", entry);
		
		assertTrue( entry.contains("objectClass", "organizationalPerson", "uidObject", "extensibleObject") );
		assertEquals("uid=hendy,ou=users,dc=aksimata,dc=com", entry.getDn().toString());
		assertEquals("hendy", entry.get("uid").getString());
		assertEquals("hendy.irawan", entry.get("uniqueIdentifier").getString());
		assertEquals("Hendy", entry.get("gn").getString());
		assertEquals("Irawan", entry.get("sn").getString());
		assertEquals("Hendy Irawan", entry.get("cn").getString());
		assertTrue( entry.contains("mail", "hendy@soluvas.com", "hendy@bippo.co.id", "ceefour666@gmail.com") );
		
		assertEquals("hendy", entry.get("photoId").getString());
		assertEquals("596326671", entry.get("fbId").getString());
		assertEquals("ceefour", entry.get("fbUser").getString());
		assertEquals("384154265", entry.get("twitterId").getString());
		assertEquals("hendyirawan", entry.get("twitterScreenName").getString());
	}

	@Test public void canMapEntryToSimpleClass() throws LdapInvalidAttributeValueException, LdapInvalidDnException {
		Entry entry = new DefaultEntry("uid=hendy,ou=users,dc=aksimata,dc=com");
		entry.put("objectClass", "organizationalPerson", "extensibleObject");
		entry.put("uid", "hendy");
		entry.put("uniqueIdentifier", "hendy.irawan");
		entry.put("gn", "Hendy");
		entry.put("sn", "Irawan");
		entry.put("cn", "Hendy Irawan");
		entry.put("mail", "hendy@soluvas.com");
		log.info("Input Entry: {}", entry);
		
		Person person = mapper.fromEntry(entry, Person.class);
		log.info("Output Person: {}", person);
		
		assertEquals("hendy", person.getId());
		assertEquals("hendy.irawan", person.getSlug());
		assertEquals("Hendy", person.getFirstName());
		assertEquals("Irawan", person.getLastName());
		assertEquals("Hendy Irawan", person.getName());
		assertEquals(ImmutableSet.of("hendy@soluvas.com"), person.getEmails());
	}

	@Test public void mapsUserPasswordCorrectly() throws LdapInvalidAttributeValueException, LdapInvalidDnException {
		Entry entry = new DefaultEntry("uid=hendy,ou=users,dc=aksimata,dc=com");
		entry.put("objectClass", "organizationalPerson", "extensibleObject");
		entry.put("uid", "hendy");
		final String password = "{SSHA}BacKnhFVjpSunHYgivCVPAzcavAZZe9QFtd51A==";
		entry.put("userPassword", password.getBytes());
		log.info("Input Entry: {}", entry);
		
		Person person = mapper.fromEntry(entry, Person.class);
		log.info("Output Person: {}", person);
		
		assertEquals(password, person.getPassword());
	}

	@Test
	public void canMapMultiToSimpleClass() throws LdapInvalidAttributeValueException, LdapInvalidDnException {
		Entry entry = new DefaultEntry("uid=hendy,ou=users,dc=aksimata,dc=com");
		entry.put("objectClass", "organizationalPerson", "extensibleObject");
		entry.put("uid", "hendy");
		entry.put("uniqueIdentifier", "hendy.irawan");
		entry.put("gn", "Hendy");
		entry.put("sn", "Irawan");
		entry.put("cn", "Hendy Irawan");
		entry.put("mail", "hendy@soluvas.com", "ceefour666@gmail.com", "hendy@bippo.co.id");
		log.info("Input Entry: {}", entry);
		
		Person person = mapper.fromEntry(entry, Person.class);
		log.info("Output Person: {}", person);
		
		assertEquals("hendy", person.getId());
		assertEquals("hendy.irawan", person.getSlug());
		assertEquals("Hendy", person.getFirstName());
		assertEquals("Irawan", person.getLastName());
		assertEquals("Hendy Irawan", person.getName());
		assertEquals(ImmutableSet.of("hendy@soluvas.com", "ceefour666@gmail.com", "hendy@bippo.co.id"),
				person.getEmails());
	}

	@Test
	public void canMapEntryToSubclass() throws LdapInvalidAttributeValueException, LdapInvalidDnException {
		Entry entry = new DefaultEntry("uid=hendy,ou=users,dc=aksimata,dc=com");
		entry.put("objectClass", "organizationalPerson", "extensibleObject", "socialPerson", "facebookObject", "twitterObject");
		entry.put("uid", "hendy");
		entry.put("uniqueIdentifier", "hendy.irawan");
		entry.put("gn", "Hendy");
		entry.put("sn", "Irawan");
		entry.put("cn", "Hendy Irawan");
		entry.put("mail", "hendy@soluvas.com", "ceefour666@gmail.com", "hendy@bippo.co.id");
		
		entry.put("photoId", "hendy");
		entry.put("fbId", "596326671");
		entry.put("fbUser", "ceefour");
		entry.put("twitterId", "384154265");
		entry.put("twitterScreenName", "hendyirawan");
		log.info("Input Entry: {}", entry);
		
		SocialPerson person = mapper.fromEntry(entry, SocialPerson.class);
		log.info("Output Person: {}", person);
		
		assertEquals("hendy", person.getId());
		assertEquals("hendy.irawan", person.getSlug());
		assertEquals("Hendy", person.getFirstName());
		assertEquals("Irawan", person.getLastName());
		assertEquals("Hendy Irawan", person.getName());
		assertEquals(ImmutableSet.of("hendy@soluvas.com", "ceefour666@gmail.com", "hendy@bippo.co.id"),
				person.getEmails());
		assertEquals("hendy", person.getPhotoId());
		assertEquals((Long)596326671L, person.getFacebookId());
		assertEquals("ceefour", person.getFacebookUsername());
		assertEquals((Long)384154265L, person.getTwitterId());
		assertEquals("hendyirawan", person.getTwitterScreenName());
	}

	@Test public void canMapLongToEntry() throws LdapInvalidAttributeValueException {
		PersonWithLong hendy = new PersonWithLong("hendy", "hendy.irawan", "Hendy", "Irawan", "male");
		hendy.setMagentoId(123L);
		log.info("Input Person: {}", hendy);
		
		Entry entry = mapper.toEntry(hendy, "ou=users,dc=aksimata,dc=com");
		log.info("Output Entry: {}", entry);
		
		assertEquals("123", entry.get("magentoId").getString());
	}
	
	@Test public void canAttributeToLong() throws LdapInvalidAttributeValueException, LdapInvalidDnException {
		Entry entry = new DefaultEntry("uid=hendy,ou=users,dc=aksimata,dc=com");
		entry.put("objectClass", "organizationalPerson", "extensibleObject", "socialPerson", "facebookObject", "twitterObject");
		entry.put("uid", "hendy");
		entry.put("uniqueIdentifier", "hendy.irawan");
		entry.put("gn", "Hendy");
		entry.put("sn", "Irawan");
		entry.put("cn", "Hendy Irawan");
		entry.put("mail", "hendy@soluvas.com", "ceefour666@gmail.com", "hendy@bippo.co.id");
		entry.put("magentoId", "123");
		
		log.info("Input Entry: {}", entry);
		
		PersonWithLong person = mapper.fromEntry(entry, PersonWithLong.class);
		log.info("Output Person: {}", person);
		
		assertEquals((Long)123L, person.getMagentoId());
	}
	
}

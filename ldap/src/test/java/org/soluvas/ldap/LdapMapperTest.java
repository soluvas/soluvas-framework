package org.soluvas.ldap;

import junit.framework.Assert;

import org.apache.directory.shared.ldap.model.entry.DefaultEntry;
import org.apache.directory.shared.ldap.model.entry.Entry;
import org.apache.directory.shared.ldap.model.exception.LdapInvalidAttributeValueException;
import org.apache.directory.shared.ldap.model.exception.LdapInvalidDnException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

	@Test
	public void canMapSimpleClassToEntry() throws LdapInvalidAttributeValueException {
		Person hendy = new Person("hendy", "hendy.irawan", "Hendy", "Irawan", "hendy@soluvas.com");
		log.info("Input Person: {}", hendy);
		
		Entry entry = mapper.toEntry(hendy, "ou=users,dc=aksimata,dc=com");
		log.info("Output Entry: {}", entry);
		
		Assert.assertTrue( entry.contains("objectClass", "organizationalPerson", "uidObject", "extensibleObject") );
		Assert.assertEquals("uid=hendy,ou=users,dc=aksimata,dc=com", entry.getDn().toString());
		Assert.assertEquals("hendy", entry.get("uid").getString());
		Assert.assertEquals("hendy.irawan", entry.get("uniqueIdentifier").getString());
		Assert.assertEquals("Hendy", entry.get("gn").getString());
		Assert.assertEquals("Irawan", entry.get("sn").getString());
		Assert.assertEquals("Hendy Irawan", entry.get("cn").getString());
		Assert.assertEquals("hendy@soluvas.com", entry.get("mail").getString());
	}

	@Test
	public void canMapMultiValuesToEntry() throws LdapInvalidAttributeValueException {
		Person hendy = new Person("hendy", "hendy.irawan", "Hendy", "Irawan");
		hendy.setEmails(ImmutableSet.of("hendy@soluvas.com", "hendy@bippo.co.id", "ceefour666@gmail.com"));
		log.info("Input Person: {}", hendy);
		
		Entry entry = mapper.toEntry(hendy, "ou=users,dc=aksimata,dc=com");
		log.info("Output Entry: {}", entry);
		
		Assert.assertTrue( entry.contains("objectClass", "organizationalPerson", "uidObject", "extensibleObject") );
		Assert.assertEquals("uid=hendy,ou=users,dc=aksimata,dc=com", entry.getDn().toString());
		Assert.assertEquals("hendy", entry.get("uid").getString());
		Assert.assertEquals("hendy.irawan", entry.get("uniqueIdentifier").getString());
		Assert.assertEquals("Hendy", entry.get("gn").getString());
		Assert.assertEquals("Irawan", entry.get("sn").getString());
		Assert.assertEquals("Hendy Irawan", entry.get("cn").getString());
		Assert.assertTrue( entry.contains("mail", "hendy@soluvas.com", "hendy@bippo.co.id", "ceefour666@gmail.com") );
	}
	
	@Test
	public void canMapSubclassToEntry() throws LdapInvalidAttributeValueException {
		SocialPerson hendy = new SocialPerson("hendy", "hendy.irawan", "Hendy", "Irawan");
		hendy.setEmails(ImmutableSet.of("hendy@soluvas.com", "hendy@bippo.co.id", "ceefour666@gmail.com"));
		hendy.setPhotoId("hendy");
		hendy.setFacebookId(596326671L);
		hendy.setFacebookUsername("ceefour");
		hendy.setTwitterId(384154265L);
		hendy.setTwitterScreenName("hendyirawan");
		log.info("Input Person: {}", hendy);
		
		Entry entry = mapper.toEntry(hendy, "ou=users,dc=aksimata,dc=com");
		log.info("Output Entry: {}", entry);
		
		Assert.assertTrue( entry.contains("objectClass", "organizationalPerson", "uidObject", "extensibleObject") );
		Assert.assertEquals("uid=hendy,ou=users,dc=aksimata,dc=com", entry.getDn().toString());
		Assert.assertEquals("hendy", entry.get("uid").getString());
		Assert.assertEquals("hendy.irawan", entry.get("uniqueIdentifier").getString());
		Assert.assertEquals("Hendy", entry.get("gn").getString());
		Assert.assertEquals("Irawan", entry.get("sn").getString());
		Assert.assertEquals("Hendy Irawan", entry.get("cn").getString());
		Assert.assertTrue( entry.contains("mail", "hendy@soluvas.com", "hendy@bippo.co.id", "ceefour666@gmail.com") );
		
		Assert.assertEquals("hendy", entry.get("photoId").getString());
		Assert.assertEquals("596326671", entry.get("fbId").getString());
		Assert.assertEquals("ceefour", entry.get("fbUser").getString());
		Assert.assertEquals("384154265", entry.get("twitterId").getString());
		Assert.assertEquals("hendyirawan", entry.get("twitterScreenName").getString());
	}

	@Test
	public void canMapEntryToSimpleClass() throws LdapInvalidAttributeValueException, LdapInvalidDnException {
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
		
		Assert.assertEquals("hendy", person.getId());
		Assert.assertEquals("hendy.irawan", person.getSlug());
		Assert.assertEquals("Hendy", person.getFirstName());
		Assert.assertEquals("Irawan", person.getLastName());
		Assert.assertEquals("Hendy Irawan", person.getName());
		Assert.assertEquals(ImmutableSet.of("hendy@soluvas.com"), person.getEmails());
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
		
		Assert.assertEquals("hendy", person.getId());
		Assert.assertEquals("hendy.irawan", person.getSlug());
		Assert.assertEquals("Hendy", person.getFirstName());
		Assert.assertEquals("Irawan", person.getLastName());
		Assert.assertEquals("Hendy Irawan", person.getName());
		Assert.assertEquals(ImmutableSet.of("hendy@soluvas.com", "ceefour666@gmail.com", "hendy@bippo.co.id"),
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
		
		Assert.assertEquals("hendy", person.getId());
		Assert.assertEquals("hendy.irawan", person.getSlug());
		Assert.assertEquals("Hendy", person.getFirstName());
		Assert.assertEquals("Irawan", person.getLastName());
		Assert.assertEquals("Hendy Irawan", person.getName());
		Assert.assertEquals(ImmutableSet.of("hendy@soluvas.com", "ceefour666@gmail.com", "hendy@bippo.co.id"),
				person.getEmails());
		Assert.assertEquals("hendy", person.getPhotoId());
		Assert.assertEquals((Long)596326671L, person.getFacebookId());
		Assert.assertEquals("ceefour", person.getFacebookUsername());
		Assert.assertEquals((Long)384154265L, person.getTwitterId());
		Assert.assertEquals("hendyirawan", person.getTwitterScreenName());
	}

}

package org.soluvas.ldap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Collection;
import java.util.Set;

import org.apache.directory.shared.ldap.model.entry.DefaultEntry;
import org.apache.directory.shared.ldap.model.entry.Entry;
import org.apache.directory.shared.ldap.model.exception.LdapInvalidAttributeValueException;
import org.apache.directory.shared.ldap.model.exception.LdapInvalidDnException;
import org.apache.directory.shared.ldap.model.schema.AttributeType;
import org.apache.directory.shared.ldap.model.schema.SchemaManager;
import org.apache.directory.shared.ldap.model.schema.registries.Schema;
import org.apache.directory.shared.ldap.model.schema.registries.SchemaLoader;
import org.apache.directory.shared.ldap.schemaloader.LdifSchemaLoader;
import org.apache.directory.shared.ldap.schemamanager.impl.DefaultSchemaManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.ldap.SocialPerson.Gender;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Ordering;

/**
 * Test mapping of {@link Person} to {@link Entry} and back.
 * @author ceefour
 */
public class LdapMapperTest {

	private transient Logger log = LoggerFactory.getLogger(LdapMapperTest.class);
	private LdapMapper mapper;
	private DefaultSchemaManager schemaManager;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		schemaManager = new DefaultSchemaManager();
		mapper = new LdapMapper(schemaManager);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test public void mapsSimpleClassToEntry() throws LdapInvalidAttributeValueException {
		Person hendy = new Person("hendy", "hendy.irawan", "Hendy", "Irawan", "hendy@soluvas.com");
		log.info("Input Person: {}", hendy);
		
		Entry entry = mapper.toEntry(hendy, "ou=users,dc=aksimata,dc=com");
		log.info("Output Entry: {}", entry);
		
		assertTrue(entry.contains("objectClass", "inetOrgPerson", "uidObject", "extensibleObject") );
		assertEquals("uid=hendy,ou=users,dc=aksimata,dc=com", entry.getDn().toString());
		assertEquals("hendy", entry.get("uid").getString());
		assertEquals("hendy.irawan", entry.get("uniqueIdentifier").getString());
		assertEquals("Hendy", entry.get("gn").getString());
		assertEquals("Irawan", entry.get("sn").getString());
		assertEquals("Hendy Irawan", entry.get("cn").getString());
		assertEquals("hendy@soluvas.com", entry.get("mail").getString());
	}

	@Test public void mapsEntryWithProperAttributeTypes() throws LdapInvalidAttributeValueException {
		Person hendy = new Person("hendy", "hendy.irawan", "Hendy", "Irawan", "hendy@soluvas.com");
		log.info("Input Person: {}", hendy);
		
		Entry entry = mapper.toEntry(hendy, "ou=users,dc=aksimata,dc=com");
		log.info("Output Entry: {}", entry);
		
		AttributeType objectClassType = schemaManager.getAttributeType("objectClass");
		assertEquals(objectClassType, entry.get("objectClass").getAttributeType());
		assertTrue("mapped Entry should contain AttributeType objectClass", entry.containsAttribute(objectClassType));
		AttributeType uidType = schemaManager.getAttributeType("uid");
		assertEquals(uidType, entry.get("uid").getAttributeType());
		assertTrue("mapped Entry should contain AttributeType uid", entry.containsAttribute(uidType));
		AttributeType uniqueIdentifierType = schemaManager.getAttributeType("uniqueIdentifier");
		assertEquals(uniqueIdentifierType, entry.get("uniqueIdentifier").getAttributeType());
		assertTrue("mapped Entry should contain AttributeType uniqueIdentifier", entry.containsAttribute(uniqueIdentifierType));
		AttributeType gnType = schemaManager.getAttributeType("gn");
		assertEquals(gnType, entry.get("gn").getAttributeType());
		assertEquals(gnType, entry.get("givenName").getAttributeType());
		assertTrue("mapped Entry should contain AttributeType gn", entry.containsAttribute(gnType));
		AttributeType snType = schemaManager.getAttributeType("sn");
		assertEquals(snType, entry.get("sn").getAttributeType());
		assertTrue("mapped Entry should contain AttributeType sn", entry.containsAttribute(snType));
		AttributeType cnType = schemaManager.getAttributeType("cn");
		assertEquals(cnType, entry.get("cn").getAttributeType());
		assertTrue("mapped Entry should contain AttributeType cn", entry.containsAttribute(cnType));
		AttributeType mailType = schemaManager.getAttributeType("mail");
		assertEquals(mailType, entry.get("mail").getAttributeType());
		assertTrue("mapped Entry should contain AttributeType mail", entry.containsAttribute(mailType));
	}

	@Test public void mapsSimpleClassWithProperAlias() throws LdapInvalidAttributeValueException {
		Person hendy = new Person("hendy", "hendy.irawan", "Hendy", "Irawan", "hendy@soluvas.com");
		log.info("Input Person: {}", hendy);
		
		Entry entry = mapper.toEntry(hendy, "ou=users,dc=aksimata,dc=com");
		log.info("Output Entry: {}", entry);
		
		assertEquals("Hendy", entry.get("gn").getString());
		assertEquals("Hendy", entry.get("givenName").getString());
	}

	@Test public void mapsMultiValuesToEntry() throws LdapInvalidAttributeValueException {
		Person hendy = new Person("hendy", "hendy.irawan", "Hendy", "Irawan", "male");
		hendy.setEmails(ImmutableSet.of("hendy@soluvas.com", "hendy@bippo.co.id", "ceefour666@gmail.com"));
		log.info("Input Person: {}", hendy);
		
		Entry entry = mapper.toEntry(hendy, "ou=users,dc=aksimata,dc=com");
		log.info("Output Entry: {}", entry);
		
		assertTrue( entry.contains("objectClass", "inetOrgPerson", "uidObject", "extensibleObject") );
		assertEquals("uid=hendy,ou=users,dc=aksimata,dc=com", entry.getDn().toString());
		assertEquals("hendy", entry.get("uid").getString());
		assertEquals("hendy.irawan", entry.get("uniqueIdentifier").getString());
		assertEquals("Hendy", entry.get("gn").getString());
		assertEquals("Irawan", entry.get("sn").getString());
		assertEquals("Hendy Irawan", entry.get("cn").getString());
		assertTrue( entry.contains("mail", "hendy@soluvas.com", "hendy@bippo.co.id", "ceefour666@gmail.com") );
	}
	
	@Test public void mapsSubclassToEntry() throws Exception {
		SchemaLoader customSchemaLoader = new LdifSchemaLoader(new File("/var/lib/apacheds-2.0.0-M7/default/partitions/schema/"));
		SchemaManager customSchemaMgr = new DefaultSchemaManager(customSchemaLoader);
		final Collection<Schema> schemas = customSchemaLoader.getAllEnabled();
		log.info("Loaded {} LDAP schemas: {}", schemas.size(), schemas);
		customSchemaMgr.enable(schemas.toArray(new Schema[] {}));
		LdapMapper customMapper = new LdapMapper(customSchemaMgr);
		
		SocialPerson hendy = new SocialPerson("hendy", "hendy.irawan", "Hendy", "Irawan", Gender.MALE);
		hendy.setEmails(ImmutableSet.of("hendy@soluvas.com", "hendy@bippo.co.id", "ceefour666@gmail.com"));
		hendy.setPhotoId("hendy");
		hendy.setFacebookId(596326671L);
		hendy.setFacebookUsername("ceefour");
		hendy.setTwitterId(384154265L);
		hendy.setTwitterScreenName("hendyirawan");
		log.info("Input Person: {}", hendy);
		
		Entry entry = customMapper.toEntry(hendy, "ou=users,dc=aksimata,dc=com");
		log.info("Output Entry: {}", entry);
		
		assertTrue( entry.contains("objectClass", "inetOrgPerson", "uidObject", "extensibleObject") );
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

	@Test public void mapsEntryToSimpleClass() throws LdapInvalidAttributeValueException, LdapInvalidDnException {
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
	public void mapsMultiToSimpleClass() throws LdapInvalidAttributeValueException, LdapInvalidDnException {
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
	public void mapsEntryToSubclass() throws LdapInvalidAttributeValueException, LdapInvalidDnException {
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

	@Test
	public void includesSuperClassAttributes() throws LdapInvalidAttributeValueException, LdapInvalidDnException {
		Set<String> expectedAttributeIds = ImmutableSet.of(
				// Person:
				"uid", "uniqueIdentifier", "gn", "givenName", "sn", "cn",
				"userPassword", "mail", "mobile", "telephoneNumber",
				"street", "postalCode", "l", "st", "c",
				// SocialPerson:
				"primaryMail", "photoId", "gender", "fbId", "facebookId", "fbUser", "facebookUser",
				"fbAccessToken", "facebookAccessToken",
				"twitterId", "twitterScreenName", "virtualMail", "nickname");
		Set<String> attributeIds = mapper.getAttributeIds(SocialPerson.class);
		;
		log.info("Attribute IDs of SocialPerson: {}", attributeIds);
		assertEquals(Ordering.natural().immutableSortedCopy(expectedAttributeIds), Ordering.natural().immutableSortedCopy(attributeIds));
//		assertEquals(expectedAttributeIds, attributeIds);
	}

	@Test public void mapsLongToEntry() throws LdapInvalidAttributeValueException {
		PersonWithLong hendy = new PersonWithLong("hendy", "hendy.irawan", "Hendy", "Irawan", "male");
		hendy.setEmployeeNumber(123L);
		log.info("Input Person: {}", hendy);
		
		Entry entry = mapper.toEntry(hendy, "ou=users,dc=aksimata,dc=com");
		log.info("Output Entry: {}", entry);
		
		assertEquals("123", entry.get("employeeNumber").getString());
	}
	
	@Test public void mapsAttributeToLong() throws LdapInvalidAttributeValueException, LdapInvalidDnException {
		Entry entry = new DefaultEntry("uid=hendy,ou=users,dc=aksimata,dc=com");
		entry.put("objectClass", "organizationalPerson", "extensibleObject", "socialPerson", "facebookObject", "twitterObject");
		entry.put("uid", "hendy");
		entry.put("uniqueIdentifier", "hendy.irawan");
		entry.put("gn", "Hendy");
		entry.put("sn", "Irawan");
		entry.put("cn", "Hendy Irawan");
		entry.put("mail", "hendy@soluvas.com", "ceefour666@gmail.com", "hendy@bippo.co.id");
		entry.put("employeeNumber", "123");
		
		log.info("Input Entry: {}", entry);
		
		PersonWithLong person = mapper.fromEntry(entry, PersonWithLong.class);
		log.info("Output Person: {}", person);
		
		assertEquals((Long)123L, person.getEmployeeNumber());
	}
	
	@Test public void mapsAttributeAlias() throws LdapInvalidAttributeValueException, LdapInvalidDnException {
		Entry entry = new DefaultEntry("uid=hendy,ou=users,dc=aksimata,dc=com");
		entry.put("objectClass", "organizationalPerson", "extensibleObject", "socialPerson", "facebookObject", "twitterObject");
		entry.put("uid", "hendy");
		entry.put("uniqueIdentifier", "hendy.irawan");
		entry.put("givenName", "Hendy");
		entry.put("sn", "Irawan");
		entry.put("cn", "Hendy Irawan");
		entry.put("mail", "hendy@soluvas.com", "ceefour666@gmail.com", "hendy@bippo.co.id");
		entry.put("magentoId", "123");
		
		log.info("Input Entry: {}", entry);
		
		SocialPerson person = mapper.fromEntry(entry, SocialPerson.class);
		log.info("Output Person: {}", person);
		
		assertEquals("Hendy", person.getFirstName());
	}
	
}

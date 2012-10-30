package org.soluvas.ldap;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapNetworkConnection;
import org.apache.directory.shared.ldap.model.entry.DefaultEntry;
import org.apache.directory.shared.ldap.model.entry.Entry;
import org.apache.directory.shared.ldap.model.entry.Modification;
import org.apache.directory.shared.ldap.model.entry.ModificationOperation;
import org.apache.directory.shared.ldap.model.exception.LdapException;
import org.apache.directory.shared.ldap.model.message.ModifyRequest;
import org.apache.directory.shared.ldap.model.schema.SchemaManager;
import org.apache.directory.shared.ldap.schemamanager.impl.DefaultSchemaManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.ldap.SocialPerson.Gender;

import com.google.common.collect.ImmutableSet;

/**
 * Test {@link LdapMapper} combined with {@link LdapUtils} in
 * a real {@link LdapConnection}.
 * @author ceefour
 */
public class LdapUtilsTest {

	private transient Logger log = LoggerFactory.getLogger(LdapUtilsTest.class);
	
	private transient LdapMapper mapper;
	private transient LdapConnection conn;
	private SchemaManager schemaManager;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		schemaManager = new DefaultSchemaManager();
		mapper = new LdapMapper(schemaManager);
		conn = new LdapNetworkConnection("localhost", 10389);
		conn.bind("uid=admin,ou=system", "secret");
		conn.loadSchema();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void canCreatePerson() throws LdapException {
		SocialPerson liz = new SocialPerson("liz", "liz.lemon", "Liz", "Lemon", Gender.FEMALE);
		liz.setEmails(ImmutableSet.of("liz.lemon@example.com", "liz@example.com"));
		liz.setPhotoId("liz_lemon");
		liz.setFacebookId(123456L);
		liz.setFacebookUsername("liz.lemon");
		liz.setTwitterId(123456L);
		liz.setTwitterScreenName("liz.lemon");
		log.info("Input Person: {}", liz);
		
		Entry entry = mapper.toEntry(liz, "ou=users,dc=aksimata,dc=com");
		log.info("Output Entry: {}", entry);
		
		conn.add(entry);
	}

	@Test public void properModificationWhenUpdatingStandardPerson() throws LdapException {
		Entry existing = conn.lookup("uid=budi,ou=users,dc=dev,dc=berbatik,dc=com");
		assertNotNull(existing);
		Person liz = mapper.fromEntry(existing, Person.class);
		
		liz.setMobile("08123456789");
		
		Entry newEntry = mapper.toEntry(liz, "ou=users,dc=dev,dc=berbatik,dc=com");
		ModifyRequest request = LdapUtils.createModifyRequest(newEntry, existing,
				schemaManager, mapper.getAttributeIds(Person.class) );
		log.info("Modify request: {}", request);
		assertNotNull(request);
		assertThat(request.getModifications(), hasSize(1));
		final Modification modification = request.getModifications().iterator().next();
		assertEquals(ModificationOperation.REPLACE_ATTRIBUTE, modification.getOperation());
		assertThat(modification.getAttribute().getAttributeType().getNames(), hasItem("mobile"));
	}

	@Test public void canUpdateStandardPerson() throws LdapException {
		Entry entry = conn.lookup("uid=budi,ou=users,dc=dev,dc=berbatik,dc=com");
		Person liz = mapper.fromEntry(entry, Person.class);
		
		liz.setMobile("08123456789");
		
		Entry newEntry = mapper.toEntry(liz, "ou=users,dc=dev,dc=berbatik,dc=com");
		LdapUtils.update(conn, newEntry,
				ImmutableSet.of("objectClass", "uid", "cn"));
	}

	@Test public void canUpdateSocialPerson() throws LdapException {
		Entry entry = conn.lookup("uid=budi,ou=users,dc=dev,dc=berbatik,dc=com");
		final LdapMapper socialMapper = new LdapMapper(conn.getSchemaManager());
		SocialPerson liz = socialMapper.fromEntry(entry, SocialPerson.class);
		
		liz.setFacebookAccessToken("abcdefgh");
		
		Entry newEntry = socialMapper.toEntry(liz,
				"ou=users,dc=dev,dc=berbatik,dc=com");
		LdapUtils.update(conn, newEntry,
				ImmutableSet.of("objectClass", "uid", "cn", "fbAccessToken"));
	}

	@Test public void replaceAttributeModifyRequest() throws LdapException {
		Entry existing = new DefaultEntry(schemaManager, "uid=hendy,ou=users,dc=aksimata,dc=com");
		existing.put("objectClass", "organizationalPerson", "extensibleObject");
		existing.put("uid", "hendy");
		existing.put("cn", "Hendy Irawan");
		log.info("Existing Entry: {}", existing);
		
		Entry updating = new DefaultEntry(schemaManager, "uid=hendy,ou=users,dc=aksimata,dc=com");
		updating.put("objectClass", "organizationalPerson", "extensibleObject");
		updating.put("uid", "hendy");
		updating.put("cn", "Hendy Irawan 2");
		log.info("Updating Entry: {}", updating);
		
		ModifyRequest request = LdapUtils.createModifyRequest(updating, existing,
				schemaManager, ImmutableSet.of("objectClass", "uid", "cn", "userPassword") );
		log.info("Modify request: {}", request);
		assertThat(request.getModifications(), hasSize(1));
	}

	@Test public void replaceAttributeAliasModifyRequest() throws LdapException {
		Entry existing = new DefaultEntry(schemaManager,
				"uid=hendy,ou=users,dc=aksimata,dc=com");
		existing.put("objectClass", "organizationalPerson", "extensibleObject");
		existing.put("uid", "hendy");
		existing.put("givenName", "Hendy");
		log.info("Existing Entry: {}", existing);
		
		Entry updating = new DefaultEntry(schemaManager,
				"uid=hendy,ou=users,dc=aksimata,dc=com");
		updating.put("objectClass", "organizationalPerson", "extensibleObject");
		updating.put("uid", "hendy");
		updating.put("gn", "Rudi");
		log.info("Updating Entry: {}", updating);
		
		ModifyRequest request = LdapUtils.createModifyRequest(updating, existing,
				schemaManager, ImmutableSet.of("objectClass", "uid", "givenName", "gn", "cn", "userPassword") );
		log.info("Modify request: {}", request);
		assertNotNull(request);
		assertThat(request.getModifications(), hasSize(1));
	}

	@Test public void addAttributeModifyRequest() throws LdapException {
		Entry existing = new DefaultEntry(schemaManager, "uid=hendy,ou=users,dc=aksimata,dc=com");
		existing.put("objectClass", "organizationalPerson", "extensibleObject");
		existing.put("uid", "hendy");
		log.info("Existing Entry: {}", existing);
		
		Entry updating = new DefaultEntry(schemaManager, "uid=hendy,ou=users,dc=aksimata,dc=com");
		updating.put("objectClass", "organizationalPerson", "extensibleObject");
		updating.put("uid", "hendy");
		updating.put("cn", "Hendy Irawan");
		log.info("Input Entry: {}", updating);
		
		ModifyRequest request = LdapUtils.createModifyRequest(updating, existing, 
				schemaManager, ImmutableSet.of("objectClass", "uid", "cn", "userPassword") );
		log.info("Modify request: {}", request);
		assertNotNull(request);
		assertThat(request.getModifications(), not(empty()));
		assertThat(request.getModifications(), hasSize(1));
		final Modification modification = request.getModifications().iterator().next();
		assertEquals(ModificationOperation.REPLACE_ATTRIBUTE, modification.getOperation());
		assertThat(modification.getAttribute().getAttributeType().getNames(), hasItem("cn"));
	}

	@Test public void removeAttributeModifyRequest() throws LdapException {
		Entry existing = new DefaultEntry(schemaManager, "uid=hendy,ou=users,dc=aksimata,dc=com");
		existing.put("objectClass", "organizationalPerson", "extensibleObject");
		existing.put("uid", "hendy");
		existing.put("cn", "Hendy Irawan");
		existing.put("sn", "Irawan");
		log.info("Existing Entry: {}", existing);
		
		Entry updating = new DefaultEntry(schemaManager, "uid=hendy,ou=users,dc=aksimata,dc=com");
		updating.put("objectClass", "organizationalPerson", "extensibleObject");
		updating.put("uid", "hendy");
		updating.put("cn", "Hendy Irawan");
		log.info("Input Entry: {}", updating);
		
		ModifyRequest request = LdapUtils.createModifyRequest(updating, existing,
				schemaManager, ImmutableSet.of("objectClass", "uid", "cn", "sn") );
		log.info("Modify request: {}", request);
		assertNotNull(request);
		assertThat(request.getModifications(), not(empty()));
		assertThat(request.getModifications(), hasSize(1));
		final Modification modification = request.getModifications().iterator().next();
		assertEquals(ModificationOperation.REMOVE_ATTRIBUTE, modification.getOperation());
		assertThat(modification.getAttribute().getAttributeType().getNames(), hasItem("sn"));
	}

	@Test public void doNotRemoveAttributeWithAlias() throws LdapException {
		Entry existing = new DefaultEntry(schemaManager, "uid=hendy,ou=users,dc=aksimata,dc=com");
		existing.put("objectClass", "organizationalPerson", "extensibleObject");
		existing.put("uid", "hendy");
		existing.put("gn", "Hendy");
		log.info("Existing Entry: {}", existing);
		
		Entry updating = new DefaultEntry(schemaManager, "uid=hendy,ou=users,dc=aksimata,dc=com");
		updating.put("objectClass", "organizationalPerson", "extensibleObject");
		updating.put("uid", "hendy");
		updating.put("givenName", "Hendy");
		log.info("Input Entry: {}", updating);
		
		ModifyRequest request = LdapUtils.createModifyRequest(updating, existing,
				schemaManager, ImmutableSet.of("objectClass", "uid", "gn", "givenName") );
		log.info("Modify request: {}", request);
		assertNotNull(request);
		assertThat(request.getModifications(), empty());
	}

	@Test public void stringEqualsBytesPassword() throws LdapException {
		final String password = "{SSHA}BacKnhFVjpSunHYgivCVPAzcavAZZe9QFtd51A==";

		Entry entry = new DefaultEntry(schemaManager, "uid=hendy,ou=users,dc=aksimata,dc=com");
		entry.put("objectClass", "organizationalPerson", "extensibleObject");
		entry.put("uid", "hendy");
		entry.put("cn", "Hendy Irawan");
		entry.put("userPassword", password.getBytes());
		log.info("Input Entry: {}", entry);
		
		Entry existing = new DefaultEntry(schemaManager, "uid=hendy,ou=users,dc=aksimata,dc=com");
		existing.put("objectClass", "organizationalPerson", "extensibleObject");
		existing.put("uid", "hendy");
		existing.put("cn", "Hendy Irawan");
		existing.put("userPassword", password);
		log.info("Input Entry: {}", entry);
		
		ModifyRequest request = LdapUtils.createModifyRequest(entry, existing,
				schemaManager, ImmutableSet.of("objectClass", "uid", "cn", "userPassword") );
		log.info("Modify request: {}", request);
		assertThat(request.getModifications(), empty());
	}

	@Test public void canChangePassword() throws LdapException {
		final String password = "{SSHA}BacKnhFVjpSunHYgivCVPAzcavAZZe9QFtd51A==";

		Entry entry = new DefaultEntry(schemaManager, "uid=hendy,ou=users,dc=aksimata,dc=com");
		entry.put("objectClass", "organizationalPerson", "extensibleObject");
		entry.put("uid", "hendy");
		entry.put("cn", "Hendy Irawan");
		entry.put("userPassword", password.getBytes());
		log.info("Input Entry: {}", entry);
		
		Entry existing = new DefaultEntry(schemaManager, "uid=hendy,ou=users,dc=aksimata,dc=com");
		existing.put("objectClass", "organizationalPerson", "extensibleObject");
		existing.put("uid", "hendy");
		existing.put("cn", "Hendy Irawan");
		existing.put("userPassword", password + "a");
		log.info("Input Entry: {}", entry);
		
		ModifyRequest request = LdapUtils.createModifyRequest(entry, existing,
				schemaManager, ImmutableSet.of("objectClass", "uid", "cn", "userPassword") );
		log.info("Modify request: {}", request);
		assertThat(request.getModifications(), not(empty()));
		assertThat(request.getModifications(), hasSize(1));
		final Modification modification = request.getModifications().iterator().next();
		assertEquals(ModificationOperation.REPLACE_ATTRIBUTE, modification.getOperation());
		assertThat(modification.getAttribute().getAttributeType().getNames(), hasItem("userPassword"));
	}

	@Test public void canDeletePerson() throws LdapException {
		final String dn = "uid=liz,ou=users,dc=aksimata,dc=com";
		log.info("Delete Entry {}", dn);
		conn.delete(dn);
	}

}

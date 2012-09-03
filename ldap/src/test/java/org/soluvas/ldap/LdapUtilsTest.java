package org.soluvas.ldap;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapNetworkConnection;
import org.apache.directory.shared.ldap.model.entry.DefaultEntry;
import org.apache.directory.shared.ldap.model.entry.Entry;
import org.apache.directory.shared.ldap.model.exception.LdapException;
import org.apache.directory.shared.ldap.model.message.ModifyRequestImpl;
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
	
	private LdapUtils ldapUtils;
	private LdapMapper mapper;

	private LdapNetworkConnection conn;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ldapUtils = new LdapUtils();
		mapper = new LdapMapper();
		conn = new LdapNetworkConnection("localhost", 10389);
		conn.bind("uid=admin,ou=system", "secret");
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

	@Test public void canUpdatePerson() throws LdapException {
		Entry entry = conn.lookup("uid=liz,ou=users,dc=aksimata,dc=com");
		SocialPerson liz = mapper.fromEntry(entry, SocialPerson.class);
		
		liz.setFacebookAccessToken("abcdefgh");
		
		Entry newEntry = mapper.toEntry(liz, "ou=users,dc=aksimata,dc=com");
		ldapUtils.update(conn, newEntry, true, "uid", "userPassword");
	}

	@Test public void replaceAttributeModifyRequest() throws LdapException {
		Entry existing = new DefaultEntry("uid=hendy,ou=users,dc=aksimata,dc=com");
		existing.put("objectClass", "organizationalPerson", "extensibleObject");
		existing.put("uid", "hendy");
		existing.put("cn", "Hendy Irawan");
		log.info("Existing Entry: {}", existing);
		
		Entry updating = new DefaultEntry("uid=hendy,ou=users,dc=aksimata,dc=com");
		updating.put("objectClass", "organizationalPerson", "extensibleObject");
		updating.put("uid", "hendy");
		updating.put("cn", "Hendy Irawan 2");
		log.info("Updating Entry: {}", updating);
		
		ModifyRequestImpl request = LdapUtils.createModifyRequest(updating, existing, false, "uid");
		assertThat(request.getModifications(), hasSize(1));
	}

	@Test public void addAttributeModifyRequest() throws LdapException {
		Entry existing = new DefaultEntry("uid=hendy,ou=users,dc=aksimata,dc=com");
		existing.put("objectClass", "organizationalPerson", "extensibleObject");
		existing.put("uid", "hendy");
		log.info("Existing Entry: {}", existing);
		
		Entry updating = new DefaultEntry("uid=hendy,ou=users,dc=aksimata,dc=com");
		updating.put("objectClass", "organizationalPerson", "extensibleObject");
		updating.put("uid", "hendy");
		updating.put("cn", "Hendy Irawan");
		log.info("Input Entry: {}", updating);
		
		ModifyRequestImpl request = LdapUtils.createModifyRequest(updating, existing, false, "uid");
		assertNotNull(request);
		assertThat(request.getModifications(), not(empty()));
		assertThat(request.getModifications(), hasSize(1));
	}

	@Test public void comparesPasswordIfNotChanged() throws LdapException {
		final String password = "{SSHA}BacKnhFVjpSunHYgivCVPAzcavAZZe9QFtd51A==";

		Entry entry = new DefaultEntry("uid=hendy,ou=users,dc=aksimata,dc=com");
		entry.put("objectClass", "organizationalPerson", "extensibleObject");
		entry.put("uid", "hendy");
		entry.put("cn", "Hendy Irawan");
		entry.put("userPassword", password.getBytes());
		log.info("Input Entry: {}", entry);
		
		Entry existing = new DefaultEntry("uid=hendy,ou=users,dc=aksimata,dc=com");
		existing.put("objectClass", "organizationalPerson", "extensibleObject");
		existing.put("uid", "hendy");
		existing.put("cn", "Hendy Irawan");
		existing.put("userPassword", password);
		log.info("Input Entry: {}", entry);
		
		ModifyRequestImpl request = LdapUtils.createModifyRequest(entry, existing, false, "uid");
		assertThat(request.getModifications(), empty());
	}

	@Test
	public void canDeletePerson() throws LdapException {
		final String dn = "uid=liz,ou=users,dc=aksimata,dc=com";
		log.info("Delete Entry {}", dn);
		conn.delete(dn);
	}

}

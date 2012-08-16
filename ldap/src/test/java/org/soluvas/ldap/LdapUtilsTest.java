package org.soluvas.ldap;

import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapNetworkConnection;
import org.apache.directory.shared.ldap.model.entry.Entry;
import org.apache.directory.shared.ldap.model.exception.LdapException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
		SocialPerson liz = new SocialPerson("liz", "liz.lemon", "Liz", "Lemon", "female");
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

	@Test
	public void canUpdatePerson() throws LdapException {
		Entry entry = conn.lookup("uid=liz,ou=users,dc=aksimata,dc=com");
		SocialPerson liz = mapper.fromEntry(entry, SocialPerson.class);
		
		liz.setFacebookAccessToken("abcdefgh");
		
		Entry newEntry = mapper.toEntry(liz, "ou=users,dc=aksimata,dc=com");
		ldapUtils.update(conn, newEntry, true, "uid", "userPassword");
	}

	@Test
	public void canDeletePerson() throws LdapException {
		final String dn = "uid=liz,ou=users,dc=aksimata,dc=com";
		log.info("Delete Entry {}", dn);
		conn.delete(dn);
	}

}

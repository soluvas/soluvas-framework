package org.soluvas.ldap;

import org.apache.directory.api.ldap.model.entry.Entry;
import org.apache.directory.api.ldap.model.exception.LdapException;
import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapNetworkConnection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Gender;

import com.google.common.collect.ImmutableSet;

/**
 * Test {@link LdapMapper} combined with {@link LdapUtils} in
 * a real {@link LdapConnection}.
 * @author ceefour
 */
public class LdapUtilsConnectionTest {

	private static final Logger log = LoggerFactory.getLogger(LdapUtilsConnectionTest.class);
	
	private transient LdapMapper mapper;
	private transient LdapConnection conn;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mapper = new LdapMapper();
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

	@Test public void canDeletePerson() throws LdapException {
		final String dn = "uid=liz,ou=users,dc=aksimata,dc=com";
		log.info("Delete Entry {}", dn);
		conn.delete(dn);
	}
	
}

package org.soluvas.security;

import static org.junit.Assert.assertNotNull;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.security.couchdb.SoluvasCouchDbRealm;

/**
 * @author mahendri
 *
 */
public class SoluvasCouchDbRealmTest {

	private static final Logger log = LoggerFactory
			.getLogger(SoluvasCouchDbRealmTest.class);
	private SoluvasCouchDbRealm realm;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// acme_dev_hub
		realm = new SoluvasCouchDbRealm(null, "http://localhost:5984/", "", "", "quikdo");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void matchHendri() {
		final UsernamePasswordToken authToken = new UsernamePasswordToken("mahen.0112@gmail.com", "bippo");
		final AuthenticationInfo authInfo = realm.getAuthenticationInfo(authToken);
		log.info("Auth info: {}", authInfo);
		assertNotNull(authInfo);
	}

	@Test(expected=IncorrectCredentialsException.class)
	public void notMatchHendri() {
		final UsernamePasswordToken authToken = new UsernamePasswordToken("mahen.0112@gmail.com", "test");
		final AuthenticationInfo authInfo = realm.getAuthenticationInfo(authToken);
		log.info("Auth info: {}", authInfo);
	}

}

package org.soluvas.security;

import static org.junit.Assert.assertNotNull;

import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.config.CommonsWebConfig;
import org.soluvas.security.couchdb.CouchDbRealm;

/**
 * @author mahendri
 *
 */
public class SoluvasCouchDbRealmTest {

	private static final Logger log = LoggerFactory
			.getLogger(SoluvasCouchDbRealmTest.class);
	private CouchDbRealm realm;
	private PoolingClientConnectionManager connMgr;

	/**
	 * @throws java.lang.Exception
	 * @see CommonsWebConfig#httpClientConnMgr()
	 */
	@Before
	public void setUp() throws Exception {
		connMgr = new PoolingClientConnectionManager();
		// acme_dev_hub
		realm = new CouchDbRealm(connMgr, "acme", null, "http://localhost:5984/", "acme_dev");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		connMgr.shutdown();
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

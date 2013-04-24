package org.soluvas.security;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.soluvas.commons.util.HashedPasswordUtils;

/**
 * @author mahendri
 *
 */
public class LdapCredentialsMatcherTest {

	private Rfc2307CredentialsMatcher matcher;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		matcher = new Rfc2307CredentialsMatcher();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void matches() {
		// Password (hex): 953a3605f52d2a82b5830aa46e0a2e392b932099
		// Salt (hex): b065ba74dfcd0509
		// Apache Directory Studio generates 20-byte password + 8-byte salt
		final boolean matched = matcher.doCredentialsMatch(new UsernamePasswordToken("mahendri", "bippo"),
				new SimpleAuthenticationInfo("mahendri", "{SSHA}lTo2BfUtKoK1gwqkbgouOSuTIJmwZbp0380FCQ==", null, "soluvas"));
		assertTrue(matched);
	}

	@Test
	public void matchesOurOwn() {
		final boolean matched = matcher.doCredentialsMatch(new UsernamePasswordToken("mahendri", "test"),
				new SimpleAuthenticationInfo("mahendri", HashedPasswordUtils.encodeSsha("test"), null, "soluvas"));
		assertTrue(matched);
	}

	@Test
	public void notMatch() {
		final boolean matched = matcher.doCredentialsMatch(new UsernamePasswordToken("mahendri", "halo"),
				new SimpleAuthenticationInfo("mahendri", "{SSHA}lTo2BfUtKoK1gwqkbgouOSuTIJmwZbp0380FCQ==", null, "soluvas"));
		assertFalse(matched);
	}

}

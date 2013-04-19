package org.soluvas.ldap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LdapUtilsLogicTest {

	private static final Logger log = LoggerFactory.getLogger(LdapUtilsLogicTest.class);
	
	@Test
	public void enforceValidPhoneNumbers() {
		assertEquals("02382935928359285", LdapUtils.enforcePhoneNumber("02382935928359285").get());
		assertEquals("0200000 3+++8,,,,293+59,28-( 35) 9285", LdapUtils.enforcePhoneNumber("  0200000 3+++8,,,,293+59,28-( 35) 9285").get());
	}

	@Test
	public void enforceInvalidPhoneNumbers() {
		assertFalse(LdapUtils.enforcePhoneNumber("   ++++++()()()()()  --,,,").isPresent());
		assertFalse(LdapUtils.enforcePhoneNumber("-").isPresent());
	}

}

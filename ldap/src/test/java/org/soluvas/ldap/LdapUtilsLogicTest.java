package org.soluvas.ldap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.joda.time.DateTime;
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

	@Test(expected=IllegalArgumentException.class)
	public void toGeneralizedTimeYear1() {
		final DateTime dateTime = new DateTime("0001-11-30T05:00:00Z");
		log.info("DateTime: {} hour {}", dateTime, dateTime.getHourOfDay());
		final String generalizedTime = LdapUtils.toGeneralizedTime(dateTime);
		log.info("Generalized time: {}", generalizedTime);
	}
	
	@Test
	public void toGeneralizedTimeYear1753() {
		// 1000-11-30T12:07:12.000+07:07:12
		// 1000-11-30T12:00:00.000+07:00
//		final DateTime dateTime = new DateTime("1000-11-30T05:00:00.000Z");
		final DateTime dateTime = new DateTime("1753-11-30T05:00:00Z");
		log.info("DateTime: {} hour {}", dateTime, dateTime.getHourOfDay());
		final String generalizedTime = LdapUtils.toGeneralizedTime(dateTime);
		log.info("Generalized time: {}", generalizedTime);
	}
	
}

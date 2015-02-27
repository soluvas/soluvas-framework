package org.soluvas.ldap;

import static org.hamcrest.Matchers.empty;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author haidar
 *
 */
public class SocialPersonTest {
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void setNullPrimaryEmailShouldNotCreateSetWithNullEntry() {
		final SocialPerson person = new SocialPerson();
		assertNull(person.getEmails());
		person.setPrimaryEmail(null);
		assertNotNull(person.getEmails());
		assertThat(person.getEmails(), empty());
	}
	
}

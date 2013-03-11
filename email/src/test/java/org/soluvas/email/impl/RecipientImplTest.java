package org.soluvas.email.impl;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.soluvas.email.EmailFactory;
import org.soluvas.email.Recipient;

import com.google.common.collect.Sets;

/**
 * @author rudi
 *
 */
public class RecipientImplTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void behavesInASet() {
		final Set<Recipient> recipients = Sets.newHashSet();
		final Recipient recipient1 = EmailFactory.eINSTANCE.createRecipient(
				"Rudi Rudi", "rudi@berbatik.com", "billing contact");
		final Recipient recipient2 = EmailFactory.eINSTANCE.createRecipient(
				"Rudi Rudi Lagi", "rudi@berbatik.com", "shipping contact");
		final Recipient recipient3 = EmailFactory.eINSTANCE.createRecipient(
				"Rudi Rudi Lagi", "rudi_mail90@yahoo.com", "admin contact");
		recipients.add(recipient1);
		recipients.add(recipient2);
		recipients.add(recipient3);
		assertThat(recipients, hasSize(2));
	}

}

package org.soluvas.commons.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author mahendri
 *
 */
public class WebAddressImplTest {

	@Test
	public void getFqdn() {
		final String fqdn = WebAddressImpl.getFqdn();
		assertEquals("mahendri.dev", fqdn);
	}

}

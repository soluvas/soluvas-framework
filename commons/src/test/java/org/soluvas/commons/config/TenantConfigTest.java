package org.soluvas.commons.config;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TenantConfigTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getFqdn() {
		final String fqdn = MultiTenantConfig.getFqdn();
		assertEquals("mahendri.dev", fqdn);
	}

}

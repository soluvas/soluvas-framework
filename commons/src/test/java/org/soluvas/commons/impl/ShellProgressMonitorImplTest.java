/**
 * 
 */
package org.soluvas.commons.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.soluvas.commons.ProgressMonitor;

/**
 * @author ceefour
 *
 */
public class ShellProgressMonitorImplTest {

	private ProgressMonitor pm;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		pm = new ShellProgressMonitorImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void simpleShortTaskDone() throws InterruptedException {
		pm.beginTask("Downloading blablabla", 100);
		Thread.sleep(1000);
		pm.done();
	}

}

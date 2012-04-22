package org.soluvas.slug;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests {@link SlugUtils}.
 * @author ceefour
 */
public class SlugUtilsTest {

	private SlugUtils slugUtils;

	@Before
	public void setUp() throws Exception {
		slugUtils = new SlugUtils();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGenerateScreenName() {
		Assert.assertEquals("have.a.wonderful.day",
				slugUtils.generateScreenName("Have a Wonderful Day :)", 0));
		Assert.assertEquals("slurp.martabak.telor.slurp",
				slugUtils.generateScreenName("Slurp martabak telor slurp :-)", 0));
	}

	@Test
	public void testGenerateId() {
		Assert.assertEquals("have_a_wonderful_day",
				slugUtils.generateId("Have a Wonderful Day :)", 0));
		Assert.assertEquals("slurp_martabak_telor_slurp",
				slugUtils.generateId("Slurp martabak telor slurp :-)", 0));
	}

	@Test
	public void testGenerateSegment() {
		// should actually be "have-wonderful-day"
		Assert.assertEquals("have-a-wonderful-day",
				slugUtils.generateSegment("Have a Wonderful Day :)", 0));
		Assert.assertEquals("slurp-martabak-telor-slurp",
				slugUtils.generateSegment("Slurp martabak telor slurp :-)", 0));
	}

}

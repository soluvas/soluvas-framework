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
		// Minimum length is 3, pad with 'a'
		Assert.assertEquals("aaa",
				slugUtils.generateScreenName("", 0));
		// International characters
		Assert.assertEquals("aaa",
				slugUtils.generateScreenName("増田秀樹", 0));
	}

	@Test
	public void testGenerateId() {
		Assert.assertEquals("have_a_wonderful_day",
				slugUtils.generateId("Have a Wonderful Day :)", 0));
		Assert.assertEquals("slurp_martabak_telor_slurp",
				slugUtils.generateId("Slurp martabak telor slurp :-)", 0));
		Assert.assertEquals("x5_4_0dhyyydgs",
				slugUtils.generateId("x5%4!(0dhyYYDgs", 0));
		// Minimum length is 3, pad with 'a'
		Assert.assertEquals("aaa",
				slugUtils.generateId("", 0));
		// International characters
		Assert.assertEquals("aaa",
				slugUtils.generateId("増田秀樹", 0));
	}

	@Test
	public void testGenerateSegment() {
		// should actually be "have-wonderful-day"
		Assert.assertEquals("have-a-wonderful-day",
				slugUtils.generateSegment("Have a Wonderful Day :)", 0));
		Assert.assertEquals("slurp-martabak-telor-slurp",
				slugUtils.generateSegment("Slurp martabak telor slurp :-)", 0));
		// Minimum length is 3, pad with 'a'
		Assert.assertEquals("aaa",
				slugUtils.generateSegment("", 0));
		// International characters
		Assert.assertEquals("aaa",
				slugUtils.generateSegment("増田秀樹", 0));
	}

}

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
	public void generateScreenName() {
		Assert.assertEquals("have.a.wonderful.day",
				slugUtils.generateScreenName("Have a Wonderful Day :)"));
		Assert.assertEquals("slurp.martabak.telor.slurp",
				slugUtils.generateScreenName("Slurp martabak telor slurp :-)"));
		// Minimum length is 3, pad with 'a'
		Assert.assertEquals("aaa",
				slugUtils.generateScreenName(""));
		// International characters
		Assert.assertEquals("aaa",
				slugUtils.generateScreenName("増田秀樹"));
		// suffix
		Assert.assertEquals("have.a.wonderful.day5",
				slugUtils.generateScreenName("Have a Wonderful Day :)", 5));
		Assert.assertEquals("aaa45",
				slugUtils.generateScreenName("増田秀樹", 45));
	}

	@Test
	public void generateId() {
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
		// suffix
		Assert.assertEquals("have_a_wonderful_day5",
				slugUtils.generateId("Have a Wonderful Day :)", 5));
		Assert.assertEquals("aaa45",
				slugUtils.generateId("増田秀樹", 45));
	}

	@Test
	public void generateSegment() {
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
		// suffix
		Assert.assertEquals("have-a-wonderful-day5",
				slugUtils.generateSegment("Have a Wonderful Day :)", 5));
		Assert.assertEquals("aaa45",
				slugUtils.generateSegment("増田秀樹", 45));
	}

	@Test(expected=NullPointerException.class)
	public void generateNullName() {
		SlugUtils.generateId(null);
	}
	
	@Test
	public void canonicalize() {
		Assert.assertEquals("arumpuspita", SlugUtils.canonicalize("arum.puspita"));
		Assert.assertEquals("arumpuspita", SlugUtils.canonicalize("Arum.Puspita"));
		Assert.assertEquals("arumpuspita", SlugUtils.canonicalize("Arum.Pus.pIt.a"));
		Assert.assertEquals("arumpuspita", SlugUtils.canonicalize("Ar um. @#%# P-us .p I t.-a"));
		Assert.assertEquals("arum_puspita", SlugUtils.canonicalize("Ar um. @#%#_ P-us .p I t.-a"));
	}

}

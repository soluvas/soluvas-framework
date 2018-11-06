package org.soluvas.slug;

import static org.junit.Assert.assertEquals;

import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.SlugUtils;

/**
 * Tests {@link SlugUtils}.
 * @author ceefour
 */
public class SlugUtilsTest {
	
	private static final Logger log = LoggerFactory.getLogger(SlugUtilsTest.class);

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
		assertEquals("have.a.wonderful.day",
				slugUtils.generateScreenName("Have a Wonderful Day :)"));
		assertEquals("slurp.martabak.telor.slurp",
				slugUtils.generateScreenName("Slurp martabak telor slurp :-)"));
		// Minimum length is 3, pad with 'a'
		assertEquals("aaa",
				slugUtils.generateScreenName(""));
		// International characters
		assertEquals("aaa",
				slugUtils.generateScreenName("増田秀樹"));
		// suffix
		assertEquals("have.a.wonderful.day5",
				slugUtils.generateScreenName("Have a Wonderful Day :)", 5));
		assertEquals("aaa45",
				slugUtils.generateScreenName("増田秀樹", 45));
		assertEquals("al.muwatta.imam.malik",
				slugUtils.generateScreenName("Al-Muwaṭṭaʾ Imam Mālik"));
	}

	@Test
	public void generateId() {
		assertEquals("have_a_wonderful_day",
				slugUtils.generateId("Have a Wonderful Day :)", 0));
		assertEquals("slurp_martabak_telor_slurp",
				slugUtils.generateId("Slurp martabak telor slurp :-)", 0));
		assertEquals("x5_4_0dhyyydgs",
				slugUtils.generateId("x5%4!(0dhyYYDgs", 0));
		// Minimum length is 3, pad with 'a'
		assertEquals("aaa",
				slugUtils.generateId("", 0));
		// International characters
		assertEquals("aaa",
				slugUtils.generateId("増田秀樹", 0));
		// suffix
		assertEquals("have_a_wonderful_day5",
				slugUtils.generateId("Have a Wonderful Day :)", 5));
		assertEquals("aaa45",
				slugUtils.generateId("増田秀樹", 45));
		assertEquals("al_muwatta_imam_malik",
				slugUtils.generateId("Al-Muwaṭṭaʾ Imam Mālik"));
	}

	@Test
	public void generateSegment() {
		// should actually be "have-wonderful-day"
		assertEquals("have-a-wonderful-day",
				slugUtils.generateSegment("Have a Wonderful Day :)", 0));
		assertEquals("slurp-martabak-telor-slurp",
				slugUtils.generateSegment("Slurp martabak telor slurp :-)", 0));
		// Minimum length is 3, pad with 'a'
		assertEquals("aaa",
				slugUtils.generateSegment("", 0));
		// International characters
		assertEquals("aaa",
				slugUtils.generateSegment("増田秀樹", 0));
		// suffix
		assertEquals("have-a-wonderful-day5",
				slugUtils.generateSegment("Have a Wonderful Day :)", 5));
		assertEquals("aaa45",
				slugUtils.generateSegment("増田秀樹", 45));
		assertEquals("al-muwatta-imam-malik",
				slugUtils.generateSegment("Al-Muwaṭṭaʾ Imam Mālik"));
	}

	@Test(expected=NullPointerException.class)
	public void generateNullName() {
		SlugUtils.generateId(null);
	}
	
	@Test
	public void canonicalize() {
		assertEquals("arumpuspita", SlugUtils.canonicalize("arum.puspita"));
		assertEquals("arumpuspita", SlugUtils.canonicalize("Arum.Puspita"));
		assertEquals("arumpuspita", SlugUtils.canonicalize("Arum.Pus.pIt.a"));
		assertEquals("arumpuspita", SlugUtils.canonicalize("Ar um. @#%# P-us .p I t.-a"));
		assertEquals("arumpuspita", SlugUtils.canonicalize("Ar um. @#%#_ P-us .p I t.-a"));
		assertEquals("almuwattaimammalik", SlugUtils.canonicalize("al-muwatta-imam-malik"));
		assertEquals("almuwatta/imammalik", SlugUtils.canonicalizePath("al-muwatta/imam-malik"));
	}
	
	@Test
	public void testUsername() {
		final Pattern USERNAME = Pattern.compile("[a-zA-Z0-9_][a-zA-Z0-9_.]+");
		
		log.info("space: {}", USERNAME.matcher("rudi w").matches());
		log.info("clean: {}", USERNAME.matcher("rudiw").matches());
	}

}

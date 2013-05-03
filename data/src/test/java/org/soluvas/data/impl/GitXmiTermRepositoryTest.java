package org.soluvas.data.impl;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.Term;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.eventbus.EventBus;

/**
 * @author adri
 *
 */
public class GitXmiTermRepositoryTest {

	private static final Logger log = LoggerFactory
			.getLogger(GitXmiTermRepositoryTest.class);
	private XmiTermRepository repo;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// easy way:
//		final File xmiFile = new File(System.getProperty("user.home"), "git/bedi-model/berbatik_common/base_Color-berbatik.DataCatalog.xmi");
		// hard way:
		final File xmiFile = new File(System.getProperty("user.home"), "berbatik_dev/common/base_Color-berbatik.DataCatalog.xmi");
		repo = new GitXmiTermRepository("base", "Color", 
				ImmutableList.of(GitXmiTermRepositoryTest.class.getResource("/org/soluvas/data/base_Color-base.DataCatalog.xmi")),
				ImmutableMap.of("berbatik", xmiFile), new EventBus());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void count() {
		final long count = repo.count();
		log.info("Count {}", count);
		// 147 standard HTML colors
		assertThat(count, greaterThan(100L));
	}

	@Test
	public void addTerm() {
		final long origRepoCount = repo.count();
		final Term term = new TermImpl();
		term.setNsPrefix("berbatik");
		term.setKindNsPrefix("base");
		term.setKindName("Color");
		term.setName("merahcinta");
		term.setColor("#f0f0dd");
		term.setDisplayName("Merah Cinta");
		log.info("Adding {}", term);
		final Term added = repo.add(term);
		assertNotNull(added);
		assertEquals(origRepoCount + 1, repo.count());
	}

	@Test
	public void merahcintaExists() {
		assertThat(repo.count(), greaterThanOrEqualTo(148L));
		assertTrue(repo.exists("berbatik_merahcinta"));
	}
	
	@Test
	public void modifyTerm() {
		assertThat(repo.count(), greaterThanOrEqualTo(148L));
		final String origUName = "berbatik_merahcinta";
		final Term term = repo.findOne(origUName);
		term.setName("birucinta");
		term.setDisplayName("Biru Cinta");
		term.setColor("#ddddf0");
		log.info("Modifying {} to {}", origUName, term);
		final Term modified = repo.modify(origUName, term);
		assertNotNull(modified);
		assertThat(repo.count(), greaterThanOrEqualTo(148L));
	}

	@Test
	public void deleteTerm() {
		final long origRepoCount = repo.count();
		assertThat(origRepoCount, greaterThanOrEqualTo(148L));
		boolean deleted = repo.delete("berbatik_birucinta");
		assertTrue(deleted);
		assertEquals(origRepoCount - 1, origRepoCount);
	}

}

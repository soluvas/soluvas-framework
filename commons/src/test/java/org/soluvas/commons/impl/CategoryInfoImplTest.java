/**
 * 
 */
package org.soluvas.commons.impl;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.CategoryInfo;
import org.soluvas.commons.CommonsFactory;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.logging.MorphiaLoggerFactory;
import com.google.code.morphia.logging.slf4j.SLF4JLogrImplFactory;
import com.mongodb.DBObject;

/**
 * @author haidar
 *
 */
public class CategoryInfoImplTest {

	private static final Logger log = LoggerFactory
			.getLogger(CategoryInfoImplTest.class);
	private Morphia morphia;

	static {
		MorphiaLoggerFactory.registerLogger(SLF4JLogrImplFactory.class);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		morphia = new Morphia();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void mapChildToMorphia() {
		final CategoryInfo aksesoris = CommonsFactory.eINSTANCE.createCategoryInfo();
		aksesoris.setName("Aksesoris");
		final CategoryInfo bandana = CommonsFactory.eINSTANCE.createCategoryInfo();
		bandana.setName("Bandana");
		bandana.setParent(aksesoris);
		bandana.getParents().add(aksesoris);
		final DBObject bandanaDbo = morphia.toDBObject(bandana);
		log.info("Bandana: {}", bandanaDbo);
		assertNotNull(bandanaDbo);
	}

}

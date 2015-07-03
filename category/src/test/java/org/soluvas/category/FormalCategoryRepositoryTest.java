package org.soluvas.category;

import java.io.IOException;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * @author rudi
 *
 */
public class FormalCategoryRepositoryTest {
	
	private static final Logger log = LoggerFactory
			.getLogger(FormalCategoryRepositoryTest.class);
	
	private final FormalCategoryRepositoryImpl formalCategoryRepo;
	
	public FormalCategoryRepositoryTest() throws JsonParseException, JsonMappingException, IOException {
		super();
		this.formalCategoryRepo = new FormalCategoryRepositoryImpl();
		this.formalCategoryRepo.init();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void findOne() {
		final long googleId = 6248l;
		
		final Optional<FormalCategory> optFormalCat = formalCategoryRepo.findOne(googleId);
		if (optFormalCat.isPresent()) {
			log.info("Found one Formal Category by id '{}': {}", googleId, optFormalCat.get());
		} else {
			log.warn("NOT Found one Formal Category by id '{}'", googleId);
		}
		
	}

}

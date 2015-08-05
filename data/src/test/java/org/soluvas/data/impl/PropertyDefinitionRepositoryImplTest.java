package org.soluvas.data.impl;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.PropertyDefinitionRepositoryImpl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.common.collect.ImmutableSet;

public class PropertyDefinitionRepositoryImplTest {
	
	private static final Logger log = LoggerFactory
			.getLogger(PropertyDefinitionRepositoryImplTest.class);
	
	private final PropertyDefinitionRepositoryImpl repo;

	public PropertyDefinitionRepositoryImplTest() throws JsonParseException, JsonMappingException, IOException {
		repo = new PropertyDefinitionRepositoryImpl();
		repo.init();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getDefaultEnums() {
		final ImmutableSet<String> defaultEnums = repo.getDefaultEnums();
		log.info("Got defaultEnums: {}", defaultEnums);
	}

}

package org.soluvas.security;

import java.io.IOException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.common.collect.ImmutableCollection;

/**
 * @author anisa
 *
 */
public class DomainPermissionRepositoryTest {
	
	private static final Logger log = LoggerFactory.getLogger(DomainPermissionRepositoryTest.class);
	
	private final DomainPermissionRepository repo;

	public DomainPermissionRepositoryTest() throws JsonParseException, JsonMappingException, IOException {
		super();
		repo = new DomainPermissionRepositoryImpl();
		repo.init();
	}

	@Test
	public void findAll() {
		final ImmutableCollection<DomainPermission2> result = repo.findAll();
		for (final DomainPermission2 domainPermission2 : result) {
			log.info("Domain '{}' has action permissions: {}", domainPermission2.getId(), domainPermission2.getActionPermission());
		}
	}

}

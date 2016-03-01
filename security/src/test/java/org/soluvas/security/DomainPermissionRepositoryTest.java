package org.soluvas.security;

import java.io.IOException;
import java.util.Collection;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;

/**
 * @author anisa
 *
 */
public class DomainPermissionRepositoryTest {
	
	private static final Logger log = LoggerFactory.getLogger(DomainPermissionRepositoryTest.class);

	private static final int Collection = 0;
	
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
	
	@Test 
	public void findOne (){
//		int i = null;
//		Integer j = null;
//		
//		String x = "";
//		String y = null;
//		String z = "0";
//		
//		log.info("x vs y: {}", x.equals(z));
		final DomainPermission2 domain = repo.findOne("person");
		log.info("Domain '{}' has action permissions: {} ", domain.getId(), domain.getActionPermission());
	}
	
	@Test
	//method bukan return value
	public void findAllByDomainIds(){
		final Collection<DomainPermission2> result = repo.findAll(ImmutableList.of("admin", "person", "salesorder"));
		for (final DomainPermission2 domain : result){
			log.info("domain '{}' has action : {}",  domain.getId(), domain.getActionPermission());
		}
		
		tampilkanNamaKu();
		
	}
	
	private void tampilkanNamaKu() {
		int i = 6 + 7;
		log.info("rudi wijaya" + i);
	}

}

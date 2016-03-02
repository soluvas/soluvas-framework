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

/**Final yaitu modifier yang digunakan untuk mencegah kemungkinan modifikasi terhadap atribut maupun method. 
Dengan modifier suatu atribut akan berlaku sebagai konstanta.*/

//nama class
public class DomainPermissionRepositoryTest {
	
	private static final Logger log = LoggerFactory.getLogger(DomainPermissionRepositoryTest.class);

	private static final int Collection = 0;
	
	//"domainpermissionrepository" nama interface
	private final DomainPermissionRepository repo;

	//constructor kenapa constructor karena namanya = class
	public DomainPermissionRepositoryTest() throws JsonParseException, JsonMappingException, IOException {
		super();
		//nama kelas //nama constructor
		repo = new DomainPermissionRepositoryImpl();
		repo.init();
	}

	@Test
	//method bukan return value
	public void findAll() {

		//immmutable adalah return type value //result nama object //findall nama method standarisasi yang ada di interface
		final ImmutableCollection<DomainPermission2> result = repo.findAll();
		for (final DomainPermission2 domainPermission2 : result) {
			log.info("Domain '{}' has action permissions: {}", domainPermission2.getId(), domainPermission2.getActionPermission());
		}
	}
	
	@Test 
	//method bukan return value
	public void findOne (){
//		int i = null;
//		Integer j = null;
//		
//		String x = "";
//		String y = null;
//		String z = "0";
//		
//		log.info("x vs y: {}", x.equals(z));
		
//dengan return value type domainPermission2 //domain nama object //repo nama object interface //findone nama method standarisasi //person nama id yang akan dicari
		final DomainPermission2 domain = repo.findOne("person");
		log.info("Domain '{}' has action permissions: {} ", domain.getId(), domain.getActionPermission());
	}
	
	@Test
	//method bukan return value
	public void findAllByDomainIds(){
		//return type parameter	    //nama method         //kenapa immutablelist karena return value typenya Collection<DomainPermission2>  
														  //.parameter dengan type immutablelist dan isi parameter nya admin person salesorder
		final Collection<DomainPermission2> result = repo.findAll(ImmutableList.of("admin", "person", "salesorder"));
		for (final DomainPermission2 domain : result){
			log.info("domain '{}' has action : {}",  domain.getId(), domain.getActionPermission());
		}
		tampilkanNamaKu();
	}
	
	//bukan return method 
	private void tampilkanNamaKu() {
		int i = 6 + 7;
		log.info("rudi wijaya" + i);
	}

}

package org.soluvas.mongo;

import org.soluvas.commons.tenant.TenantBeanRepository;
import org.soluvas.data.person.PersonRepository;

/**
 * @author ceefour
 * @see MongoPersonConfig
 */
public interface PersonConfig {

	TenantBeanRepository<PersonRepository> personRepoBeanRepo();
	
}

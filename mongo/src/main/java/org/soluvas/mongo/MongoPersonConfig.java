package org.soluvas.mongo;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.beanutils.PropertyUtils;
import org.eclipse.emf.ecore.EObject;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.PersonRelated;
import org.soluvas.commons.config.MultiTenantConfig;
import org.soluvas.commons.config.SysConfigMapHolder;
import org.soluvas.commons.config.TenantSelector;
import org.soluvas.commons.tenant.TenantBeanRepository;
import org.soluvas.data.person.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import com.google.common.eventbus.EventBus;

/**
 * @author ceefour
 */
@Configuration @Lazy
public class MongoPersonConfig implements PersonConfig {
	
	@Inject
	private Environment env;
	@Inject
	private MultiTenantConfig tenantConfig;
	/**
	 * Note: SysConfig object must contain {@code getMongoUri()}.
	 * @todo Better mechanism?
	 */
	@Inject
	private SysConfigMapHolder<EObject> sysConfigMapHolder;
	@Inject @Named("appEventBus")
	private EventBus appEventBus;
	@Inject
	private TenantSelector tenantSelector;

	@Override
	@Bean(destroyMethod="destroy")
	public TenantBeanRepository<PersonRepository> personRepoBeanRepo() {
		final boolean mongoMigrationEnabled = env.getProperty("mongoMigrationEnabled", Boolean.class, true);
		return new TenantBeanRepository<PersonRepository>(MongoPersonRepository.class, tenantConfig.tenantMap(), appEventBus) {
			@Override
			protected MongoPersonRepository create(String tenantId, AppManifest appManifest) throws Exception {
				final EObject sysConfig = sysConfigMapHolder.sysConfigMap().get(tenantId);
				final String mongoUri = (String) PropertyUtils.getProperty(sysConfig, "mongoUri");
				final MongoPersonRepository personRepo = new MongoPersonRepository(mongoUri, mongoMigrationEnabled);
				return personRepo;
			}
		};
	}
	
	@Bean(name={"personRepo", "personLookup"}) @PersonRelated @Scope("prototype")
	public PersonRepository personRepo() {
		return personRepoBeanRepo().get(tenantSelector.tenantRef().getTenantId());
	}
	
}

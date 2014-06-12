package org.soluvas.mongo;

import javax.inject.Inject;

import org.soluvas.commons.AppManifest;
import org.soluvas.commons.MongoSysConfig;
import org.soluvas.commons.config.SysConfigMapHolder;
import org.soluvas.commons.tenant.TenantBeans;
import org.soluvas.data.customerrole.CustomerRoleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

/**
 * {@link Configuration} for {@link MongoCustomerRoleRepository}.
 * @author ceefour
 */
@Configuration
public class MongoCustomerRoleConfig {

	@Inject
	private Environment env;
	@Inject
	private SysConfigMapHolder<? extends MongoSysConfig> sysConfigMapHolder;
	
	@Bean
	public TenantBeans<CustomerRoleRepository> customerRoleBeans() {
		final boolean mongoMigrationEnabled = env.getProperty("mongoMigrationEnabled", Boolean.class, true);
		final boolean mongoAutoExplainSlow = env.getProperty("mongoAutoExplainSlow", Boolean.class, false);
		return new TenantBeans<CustomerRoleRepository>(MongoCustomerRoleRepository.class) {
			@Override
			protected CustomerRoleRepository create(String tenantId, AppManifest appManifest) throws Exception {
				final MongoSysConfig sysConfig = sysConfigMapHolder.sysConfigMap().get(tenantId);
				final String mongoUri = sysConfig.getMongoUri();
				return new MongoCustomerRoleRepository(mongoUri, mongoMigrationEnabled, mongoAutoExplainSlow);
			}
		};
	}
	
	@Bean @Scope("prototype")
	public CustomerRoleRepository customerRoleRepo() {
		return customerRoleBeans().getCurrent();
	}
	
}

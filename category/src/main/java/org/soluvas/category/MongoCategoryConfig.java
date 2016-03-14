package org.soluvas.category;

import javax.inject.Inject;

import org.soluvas.commons.AppManifest;
import org.soluvas.commons.MongoSysConfig;
import org.soluvas.commons.config.SysConfigMapHolder;
import org.soluvas.commons.tenant.TenantBeans;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

/**
 * @author rudi
 *
 */
@Configuration
public class MongoCategoryConfig {
	
	@Inject
	private Environment env;
	@Inject
	private SysConfigMapHolder<? extends MongoSysConfig> sysConfigMapHolder;
	@Inject
	private CacheManager cacheMgr;
	
	@Bean
	public TenantBeans<MongoCategoryRepository> mongoCategoryRepoBeans() {
		final boolean mongoMigrationEnabled = env.getProperty("mongoMigrationEnabled", Boolean.class, true);
		final boolean mongoAutoExplainSlow = env.getProperty("mongoAutoExplainSlow", Boolean.class, false);
		return new TenantBeans<MongoCategoryRepository>(MongoCategoryRepository.class) {
			@Override
			protected MongoCategoryRepository create(String tenantId, AppManifest appManifest) throws Exception {
				final MongoSysConfig sysConfig = sysConfigMapHolder.sysConfigMap().get(tenantId);
				final String mongoUri = sysConfig.getMongoUri();
				return new MongoCategoryRepositoryImpl(cacheMgr, tenantId,
						mongoUri, mongoMigrationEnabled, mongoAutoExplainSlow);
			}
		};
	}
	
	@Bean @Scope("prototype")
	public MongoCategoryRepository mongoCategoryRepo() {
		return mongoCategoryRepoBeans().getCurrent();
	}

}

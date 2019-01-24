package org.soluvas.category;

import java.io.File;
import java.net.URL;
import java.util.Map;

import javax.inject.Inject;

import org.soluvas.category.impl.GitXmiCategoryRepository;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.config.MultiTenantConfig;
import org.soluvas.commons.tenant.TenantBeans;
import org.soluvas.commons.tenant.TenantDirProvision;
import org.soluvas.commons.tenant.TenantUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.eventbus.EventBus;

@Configuration
@Import(MultiTenantCategoryConfig.class)
public class GitXmiCategoryConfig {
	
	@Inject
	private MultiTenantConfig tenantConfig;
	@Inject
	private Environment env;
	
//	@Bean
//	public TenantBeans<CategoryRepository> categoryRepoBeans() {
//		return new TenantBeans<CategoryRepository>(GitXmiCategoryRepository.class) {
//			@Override
//			protected GitXmiCategoryRepository create(String tenantId, AppManifest appManifest)
//					throws Exception {
//				final File dataDir = tenantConfig.dataDirMap().get(tenantId);
//				final EventBus tenantEventBus = TenantUtils.selectBean(tenantId, tenantConfig.eventBusMap(), EventBus.class);
//				final TenantDirProvision tenantDirProvision = env.getRequiredProperty("tenantDirProvision", TenantDirProvision.class);
//				final File tenantXmiFile = new File(dataDir, "common/" + tenantId + ".CategoryCatalog.xmi");
//				final Map<String, File> xmiFiles = tenantXmiFile.exists() ? ImmutableMap.of(tenantId, tenantXmiFile) : ImmutableMap.<String, File>of();
////					final XmiCategoryRepository repo = new XmiCategoryRepository( 
////							ImmutableList.<URL>of(), xmiFiles, eventBus);
//				final GitXmiCategoryRepository repo = new GitXmiCategoryRepository( 
//						ImmutableList.<URL>of(), xmiFiles, tenantEventBus, tenantDirProvision);
//				return repo;
//				
//			}
//		};
//	}
//	
//	@Bean @Scope("prototype")
//	public CategoryRepository categoryRepo() {
//		return categoryRepoBeans().getCurrent();
//	}
	
}
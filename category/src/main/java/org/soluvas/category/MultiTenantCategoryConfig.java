package org.soluvas.category;

import java.io.File;

import javax.inject.Inject;

import org.soluvas.category.impl.CategoryCatalogImpl;
import org.soluvas.category.util.CategoryCatalogXmiTracker;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.config.MultiTenantConfig;
import org.soluvas.commons.tenant.TenantBeans;
import org.soluvas.commons.tenant.TenantUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.google.common.eventbus.EventBus;

/**
 * {@link Configuration} for Soluvas {@link Category} beans.
 * @author rudi
 */
@Configuration
@ComponentScan("org.soluvas.category.shell")
public class MultiTenantCategoryConfig {
	
	@Inject
	private MultiTenantConfig tenantConfig;
	
	@Bean(destroyMethod="destroy")
	public TenantBeans<CategoryCatalog> categoryCatalogBeans() {
		return new TenantBeans<CategoryCatalog>(CategoryCatalogImpl.class) {
			@Override
			protected CategoryCatalogImpl create(String tenantId, AppManifest appManifest)
					throws Exception {
				final File dataDir = TenantUtils.selectBean(tenantId, tenantConfig.dataDirMap(), File.class);
				final EventBus tenantEventBus = TenantUtils.selectBean(tenantId, tenantConfig.eventBusMap(), EventBus.class);
				
				final CategoryCatalogImpl categoryCatalog = (CategoryCatalogImpl) CategoryFactory.eINSTANCE.createCategoryCatalog();
				final CategoryCatalogXmiTracker tracker = new CategoryCatalogXmiTracker(categoryCatalog, tenantEventBus);
				tracker.scan(MultiTenantCategoryConfig.class.getClassLoader(), dataDir);
				return categoryCatalog;
			}
		};
	}
	
	@Bean @Scope("prototype")
	public CategoryCatalog categoryCatalog() {
		return categoryCatalogBeans().getCurrent();
	}
	
}

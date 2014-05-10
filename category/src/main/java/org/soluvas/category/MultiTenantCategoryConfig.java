package org.soluvas.category;

import java.io.File;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Named;

import org.soluvas.category.impl.CategoryCatalogImpl;
import org.soluvas.category.util.CategoryCatalogXmiTracker;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.config.CommonsWebConfig;
import org.soluvas.commons.config.MultiTenantConfig;
import org.soluvas.commons.config.TenantSelector;
import org.soluvas.commons.tenant.TenantBeans;
import org.soluvas.commons.tenant.TenantRepository;
import org.soluvas.commons.tenant.TenantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.google.common.eventbus.EventBus;

/**
 * {@link Configuration} for Soluvas Category beans.
 * @author rudi
 */
@Configuration @Lazy
@ComponentScan("org.soluvas.category.shell")
public class MultiTenantCategoryConfig {
	
	@Inject
	private TenantSelector tenantSelector;
	@Inject @Named(CommonsWebConfig.APP_EVENT_BUS)
	private EventBus appEventBus;
	@Inject
	private MultiTenantConfig tenantConfig;
	@Autowired(required=false) @Nullable
	private TenantRepository<?> tenantRepo;
	
	@Bean(destroyMethod="destroy")
	public TenantBeans<CategoryCatalog> categoryCatalogBeanRepo() {
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
		return categoryCatalogBeanRepo().get(tenantSelector.tenantRef().getTenantId());
	}
	
}

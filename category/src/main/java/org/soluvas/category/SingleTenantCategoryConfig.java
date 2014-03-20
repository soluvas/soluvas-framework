package org.soluvas.category;

import javax.inject.Inject;

import org.soluvas.category.util.CategoryCatalogXmiTracker;
import org.soluvas.commons.DataFolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.google.common.eventbus.EventBus;

/**
 * @author rudi
 * @deprecated Use {@link MultiTenantCategoryConfig} for multitenant applications.
 */
@Deprecated
@Configuration @Lazy
@ComponentScan("org.soluvas.category.shell")
public class SingleTenantCategoryConfig {
	
	@Inject
	private EventBus eventBus;
	@Inject @DataFolder
	private String dataFolder;
	
	@Bean
	public CategoryCatalog categoryCatalog() {
		final CategoryCatalog categoryCatalog = CategoryFactory.eINSTANCE.createCategoryCatalog();
		final CategoryCatalogXmiTracker tracker = new CategoryCatalogXmiTracker(categoryCatalog, eventBus);
		tracker.scan(SingleTenantCategoryConfig.class.getClassLoader(), dataFolder);
		return categoryCatalog;
	}

}

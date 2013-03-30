package org.soluvas.category;

import javax.inject.Inject;

import org.soluvas.category.util.CategoryCatalogXmiTracker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.google.common.eventbus.EventBus;

/**
 * @author rudi
 *
 */
@Configuration @Lazy
public class CategoryConfig {
	
	@Inject
	private EventBus eventBus;
	
	@Bean
	public CategoryCatalog categoryCatalog() {
		final CategoryCatalog categoryCatalog = CategoryFactory.eINSTANCE.createCategoryCatalog();
		final CategoryCatalogXmiTracker tracker = new CategoryCatalogXmiTracker(categoryCatalog, eventBus);
		tracker.scan(CategoryConfig.class.getClassLoader());
		return categoryCatalog;
	}

}

package org.soluvas.social;

import javax.inject.Inject;

import org.soluvas.social.schema.SchemaFactory;
import org.soluvas.social.schema.SocialSchemaCatalog;
import org.soluvas.social.util.SocialSchemaCatalogXmiTracker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.google.common.eventbus.EventBus;

/**
 * {@link Configuration} that scans for {@link SocialSchemaCatalog} in the classpath (only).
 * @author rudi
 * @deprecated Use {@link MultiTenantSocialConfig} for multitenant applications.
 */
@Deprecated
@Configuration @Lazy
@ComponentScan("org.soluvas.social")
public class SocialConfig {
	
	@Inject
	private EventBus eventBus;
	
	@Bean
	public SocialSchemaCatalog socialSchemaCatalog() {
		final SocialSchemaCatalog socialSchemaCatalog = SchemaFactory.eINSTANCE.createSocialSchemaCatalog();
		final SocialSchemaCatalogXmiTracker tracker = new SocialSchemaCatalogXmiTracker(socialSchemaCatalog, eventBus);
		tracker.scan(SocialConfig.class.getClassLoader(), null);
		return socialSchemaCatalog;
	}

}

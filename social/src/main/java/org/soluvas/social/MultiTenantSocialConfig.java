package org.soluvas.social;

import javax.inject.Inject;
import javax.inject.Named;

import org.soluvas.commons.config.CommonsWebConfig;
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
 */
@Configuration @Lazy
@ComponentScan("org.soluvas.social")
public class MultiTenantSocialConfig {
	
	@Inject @Named(CommonsWebConfig.APP_EVENT_BUS)
	private EventBus appEventBus;
	
	@Bean
	public SocialSchemaCatalog socialSchemaCatalog() {
		final SocialSchemaCatalog socialSchemaCatalog = SchemaFactory.eINSTANCE.createSocialSchemaCatalog();
		final SocialSchemaCatalogXmiTracker tracker = new SocialSchemaCatalogXmiTracker(socialSchemaCatalog, appEventBus);
		tracker.scan(MultiTenantSocialConfig.class.getClassLoader(), null);
		return socialSchemaCatalog;
	}

}

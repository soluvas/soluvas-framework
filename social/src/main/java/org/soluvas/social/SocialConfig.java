package org.soluvas.social;

import javax.inject.Inject;

import org.soluvas.commons.DataFolder;
import org.soluvas.social.schema.SchemaFactory;
import org.soluvas.social.schema.SocialSchemaCatalog;
import org.soluvas.social.util.SocialSchemaCatalogXmiTracker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.google.common.eventbus.EventBus;

/**
 * @author rudi
 *
 */
@Configuration @Lazy
@ComponentScan("org.soluvas.social")
public class SocialConfig {
	
	@Inject @DataFolder
	private String dataFolder;
	@Inject
	private EventBus eventBus;
	
	@Bean
	public SocialSchemaCatalog socialSchemaCatalog() {
		final SocialSchemaCatalog socialSchemaCatalog = SchemaFactory.eINSTANCE.createSocialSchemaCatalog();
		final SocialSchemaCatalogXmiTracker tracker = new SocialSchemaCatalogXmiTracker(socialSchemaCatalog, eventBus);
		tracker.scan(SocialConfig.class.getClassLoader(), dataFolder);
		return socialSchemaCatalog;
	}

}

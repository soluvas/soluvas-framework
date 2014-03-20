package com.soluvas.story;

import javax.inject.Inject;

import org.soluvas.social.schema.SocialSchemaCatalog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.soluvas.story.schema.SchemaFactory;
import com.soluvas.story.schema.StorySchemaCatalog;
import com.soluvas.story.util.StorySchemaCatalogXmiTracker;

/**
 * {@link Configuration} that scans {@link StorySchemaCatalog} in classpath (only).
 * @author ceefour
 */
@Configuration @Lazy(false)
@ComponentScan("com.soluvas.story")
public class StoryConfig {
	
	@Inject
	private SocialSchemaCatalog socialSchemaCatalog;
	
	@Bean
	public StorySchemaCatalog storySchemaCatalog() {
		final StorySchemaCatalog storySchemaCatalog = SchemaFactory.eINSTANCE.createStorySchemaCatalog();
		final StorySchemaCatalogXmiTracker tracker = new StorySchemaCatalogXmiTracker(socialSchemaCatalog, storySchemaCatalog);
		tracker.scan(StoryConfig.class.getClassLoader(), null);
		return storySchemaCatalog;
	}

}

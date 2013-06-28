package com.soluvas.story;

import javax.inject.Inject;

import org.soluvas.commons.DataFolder;
import org.soluvas.social.schema.SocialSchemaCatalog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.soluvas.story.schema.SchemaFactory;
import com.soluvas.story.schema.StorySchemaCatalog;
import com.soluvas.story.util.StorySchemaCatalogXmiTracker;

/**
 * @author adri
 *
 */
@Configuration @Lazy(false)
@ComponentScan("com.soluvas.story")
public class StoryConfig {
	
	@Inject
	private SocialSchemaCatalog socialSchemaCatalog;
	@Inject @DataFolder
	private String dataFolder;
	
	@Bean
	public StorySchemaCatalog storySchemaCatalog() {
		final StorySchemaCatalog storySchemaCatalog = SchemaFactory.eINSTANCE.createStorySchemaCatalog();
		final StorySchemaCatalogXmiTracker tracker = new StorySchemaCatalogXmiTracker(socialSchemaCatalog, storySchemaCatalog);
		tracker.scan(StoryConfig.class.getClassLoader(), dataFolder);
		return storySchemaCatalog;
	}

}

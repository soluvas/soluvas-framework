package org.soluvas.image.impl;

import org.soluvas.image.rs.MediaResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * Configures {@link MediaResource}.
 * @author ceefour
 */
@Configuration @Lazy
public class MediaTenantConfig {

	@Bean @Scope("request")
	public MediaResource mediaResource() {
		return new MediaResource();
	}
}

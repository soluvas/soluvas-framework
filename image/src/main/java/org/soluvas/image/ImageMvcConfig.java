package org.soluvas.image;

import org.soluvas.image.rs.ImageApiController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author rudi
 * @see ImageApiController
 */
@Configuration
public class ImageMvcConfig {
	
	@Bean @Scope("request")
	public ImageApiController imageApiController() {
		return new ImageApiController();
	}

}

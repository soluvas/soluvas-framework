package org.soluvas.image;

import java.util.concurrent.ExecutorService;

import javax.inject.Inject;

import org.soluvas.commons.Cpu;
import org.soluvas.commons.Network;
import org.soluvas.image.impl.ImageManagerImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @author rudi
 *
 */
@Configuration @Lazy
public class ImageConfig {
	
	@Bean
	public ImageManager imageManager() {
		return new ImageManagerImpl();
	}

}

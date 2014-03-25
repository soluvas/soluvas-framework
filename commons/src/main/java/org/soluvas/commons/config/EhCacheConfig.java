package org.soluvas.commons.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

/**
 * To use this, you must add the following dependency to your app:
 * 
 * <pre>{@literal
 * 		<dependency>
 * 		    <groupId>net.sf.ehcache</groupId>
 * 		    <artifactId>ehcache</artifactId>
 * 		</dependency>
 * 		<dependency>
 * 			<groupId>org.springframework</groupId>
 * 			<artifactId>spring-context-support</artifactId>
 * 		</dependency>
 * }</pre>
 *
 * <p>Then {@link Import} it into your {@literal AppConfig}.
 * 
 * @author rudi
 */
@Configuration @Lazy
public class EhCacheConfig {

	@Bean
	public EhCacheManagerFactoryBean ehCacheFactory() {
		final EhCacheManagerFactoryBean ehCacheFactory = new EhCacheManagerFactoryBean();
		return ehCacheFactory;
	}
	
	@Bean
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheFactory().getObject());
	}

}
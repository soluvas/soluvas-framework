package org.soluvas.twitter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author ceefour
 * @deprecated TODO: multitenant config for creating {@link TwitterManagerImpl}s
 */
@Configuration
@Import(TwitterConfig.class)
@Deprecated
public class TwitterSingleConfig {

	@Value("#{soluvasProps.authTwitterConsumerKey}") String consumerKey;
	@Value("#{soluvasProps.authTwitterConsumerSecret}") String consumerSecret;
	@Value("#{soluvasProps.twitterAppScreenName}") String tenantScreenName;
	@Value("#{soluvasProps.twitterAppAccessToken}") String tenantAccessToken;
	@Value("#{soluvasProps.twitterAppAccessTokenSecret}") String tenantAccessTokenSecret;
	
	@Bean
	public TwitterManagerImpl twitterMgr() {
		return new TwitterManagerImpl(consumerKey, consumerSecret, 
				tenantScreenName, tenantAccessToken, tenantAccessTokenSecret);
	}

}

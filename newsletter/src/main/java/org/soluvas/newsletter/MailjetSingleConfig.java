package org.soluvas.newsletter;

import org.soluvas.newsletter.impl.MailjetManagerImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author ceefour
 * @deprecated use {@link MailjetConfig}
 */
@Configuration
@Deprecated
@Import(NewsletterConfig.class)
public class MailjetSingleConfig {

	@Value("#{soluvasProps.mailjetApiKey}") String apiKey;
	@Value("#{soluvasProps.mailjetSecretKey}") String secretKey; 
	@Value("#{soluvasProps.mailjetListId}") Long listId;
	
	@Bean
	public MailjetManagerImpl mailjetMgr() {
		return new MailjetManagerImpl(apiKey, secretKey, listId);
	}

}

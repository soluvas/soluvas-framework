package org.soluvas.email;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

@Configuration
public class BouncedEmailConfig {
	
	@Inject
	private Environment env;
	
	@Bean @Scope("prototype")
	public BouncedEmailRepository bouncedEmailRepository() {
		final String mongoUri = env.getProperty("bouncedEmailMongoUri", "");
		Preconditions.checkState(!Strings.isNullOrEmpty(mongoUri), 
				"Mongo URI 'bouncedEmailMongoUri' must not be null or empty for creating '%s'",
				BouncedEmailRepository.class.getName());
		final boolean mongoMigrationEnabled = env.getProperty("mongoMigrationEnabled", Boolean.class, true);
		final boolean mongoAutoExplainSlow = env.getProperty("mongoAutoExplainSlow", Boolean.class, true);
		
		return new BouncedEmailRepositoryImpl(mongoUri, mongoMigrationEnabled, mongoAutoExplainSlow);
	}

}

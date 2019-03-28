package org.soluvas.category;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FormalCategoryConfig {
	
	@Bean
	public FormalCategoryRepository formalCategoryRepo() {
		return new FormalCategoryRepositoryImpl();
	}

}

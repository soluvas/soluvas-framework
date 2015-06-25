package org.soluvas.category;

import javax.annotation.PostConstruct;

import com.google.common.collect.ImmutableMap;

/**
 * @author rudi
 *
 */
public class FormalCategoryRepositoryImpl {
	
	private ImmutableMap<Long, String> formalCategories;
	
	@PostConstruct
	public void init() {
		
	}

}

/*
 * Copyright 2008-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.soluvas.data.domain;

import javax.annotation.Nullable;


/**
 * Abstract interface for pagination information.
 * 
 * <p>Note to implementors: To calculate the {@code skip/offset},
 * use this:
 * 
 * <p>{@code long skip = pageable.getOffset() + pageable.getPageNumber() * pageable.getPageSize();}
 *
 * @author Oliver Gierke
 */
public interface Pageable {

	/**
	 * Returns the page to be returned.
	 * 
	 * @return the page to be returned.
	 */
	long getPageNumber();

	/**
	 * Returns the number of items to be returned.
	 * 
	 * @return the number of items of that page
	 */
	long getPageSize();

	/**
	 * Returns the offset to be taken according to the underlying page and page size.
	 * 
	 * @return the offset to be taken
	 */
	long getOffset();

	/**
	 * Returns the sorting parameters.
	 * 
	 * @return
	 */
	@Nullable
	Sort getSort();
	
	/**
	 * Creates a new {@link Pageable} with the same type, appending a {@link Sort} criteria.
	 * @param tailSort
	 * @return
	 */
	Pageable andSort(Sort tailSort);
	
	/**
	 * If {@code true}, then this {@link Pageable} is hard-capped to {@link #getPageSize()},
	 * and a warning should be logged when {@link Page#getTotalElements()} exceeds that limit.
	 * @return
	 */
	boolean isCapped();
	
}

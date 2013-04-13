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
package org.soluvas.data.repository;

import java.util.Collection;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Sort;

/**
 * Extension of {@link BasicRepository} to provide additional methods to retrieve entities using the pagination and
 * sorting abstraction.
 * 
 * Difference to Spring Data's PagingAndSortingRepository:
 * <ol>
 * 	<li>{@link #findAll(Sort)} returns {@code Collection<T>}</li>
 * 	<li>{@link Nonnull} annotations</li>
 * 	<li>Split between {@link PageableAndSortable} behavior and {@link PagingAndSortingRepository} for CRUD.</li>
 * </ol>
 * 
 * @author Oliver Gierke
 * @see Sort
 * @see Pageable
 * @see Page
 */
//@NoRepositoryBean
@ParametersAreNonnullByDefault
public interface PageableAndSortable<T> extends BasicRepository {

	/**
	 * Returns all entities sorted by the given options.
	 * 
	 * @param sort
	 * @return all entities sorted by the given options
	 */
	public Collection<T> findAll(Sort sort);

	/**
	 * Returns a {@link Page} of entities meeting the paging restriction provided in the {@code Pageable} object.
	 * 
	 * @param pageable
	 * @return a page of entities
	 */
	public Page<T> findAll(Pageable pageable);

}

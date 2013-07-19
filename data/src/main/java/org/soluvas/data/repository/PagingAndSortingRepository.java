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

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Sort;

/**
 * Extension of {@link CrudRepository} to provide additional methods to retrieve entities using the pagination and
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
public interface PagingAndSortingRepository<T, ID extends Serializable> extends CrudRepository<T, ID>, PageableAndSortable<T> {
	
	/**
	 * Returns all instances of the type with the given IDs, sorted by a particular field(s).
	 * Not found instances are skipped, but should be logged.
	 * 
	 * @param ids
	 * @param sort Sort order(s), specify {@code null} if no sorting required.
	 * @return
	 */
	List<T> findAll(Collection<ID> ids, @Nullable Sort sort);

}

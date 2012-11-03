/*
 * Copyright 2008-2011 the original author or authors.
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

import javax.annotation.Nonnull;

import org.soluvas.data.EntityLookup;

/**
 * Interface for generic CRUD operations on a repository for a specific type.
 * 
 * The difference to Spring Data 1.4 are:
 * <ol>
 * 	<li>@{@link Nonnull} annotations</li>
 *  <li>CrudRepository{@link #isEmpty()}</li>
 *  <li>Supports bulk delete by IDs: {@link CrudRepository#deleteIds(Iterable)}.</li>
 *  <li>Extends {@link BasicRepository}</li>
 *  <li>find methods return {@link Collection} instead of {@link Iterable}. Reason
 *  	is find methods are not supposed to return large results anyway. For that
 *  	you need batching or paging. The ability to call {@link Collection#size()}
 *  	outweights the {@link Iterable} benefits.</li>
 *  <li>EntityLookup{@link #findOne(Serializable)} returns subclass of T.
 *  <li>delete methods return number of changed entities</li>
 * </ol>
 * 
 * @author Oliver Gierke
 * @author Eberhard Wolff
 * @author Hendy Irawan
 */
//@NoRepositoryBean
public interface CrudRepository<T, ID extends Serializable> extends Repository<T, ID>, BasicRepository, EntityLookup<T, ID> {

	/**
	 * Saves a given entity. Use the returned instance for further operations as the save operation might have changed the
	 * entity instance completely.
	 * 
	 * @param entity
	 * @return the saved entity
	 */
	<S extends T> S save(@Nonnull final S entity);

	/**
	 * Saves all given entities.
	 * 
	 * @param entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is (@literal null}.
	 */
	<S extends T> Collection<S> save(@Nonnull final Iterable<S> entities);

	/**
	 * Returns whether an entity with the given id exists.
	 * 
	 * @param id must not be {@literal null}.
	 * @return true if an entity with the given id exists, alse otherwise
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	boolean exists(@Nonnull final ID id);

	/**
	 * Returns whether all entities with the given ids exists.
	 * 
	 * @param ids must not be {@literal null}.
	 * @return true if an entity with the given id exists, alse otherwise
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	boolean existsAll(@Nonnull final Iterable<ID> ids);

	/**
	 * Returns whether any entity with one of the given ids exists.
	 * 
	 * @param ids must not be {@literal null}.
	 * @return true if an entity with the given id exists, alse otherwise
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	boolean existsAny(@Nonnull final Iterable<ID> ids);

	/**
	 * Returns all instances of the type.
	 * 
	 * @return all entities
	 */
	Collection<T> findAll();

	/**
	 * Returns all instances of the type with the given IDs.
	 * Not found instances are skipped, but should be logged.
	 * 
	 * @param ids
	 * @return
	 */
	Collection<T> findAll(Iterable<ID> ids);

    /**
	 * Returns the number of entities matching the given ids.
	 * 
	 * @return the number of entities, the maximum number of returned
	 * is always the size of ids parameter.
	 */
	long count(@Nonnull Iterable<ID> ids);

	/**
	 * Deletes the entity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return TODO
	 * @throws IllegalArgumentException in case the given {@code id} is {@literal null}
	 */
	boolean delete(@Nonnull final ID id);

	/**
	 * Deletes a given entity.
	 * 
	 * @param entity
	 * @return TODO
	 * @throws IllegalArgumentException in case the given entity is (@literal null}.
	 */
	boolean delete(@Nonnull final T entity);

	/**
	 * Deletes the given entities.
	 * 
	 * @param entities
	 * @return TODO
	 * @throws IllegalArgumentException in case the given {@link Iterable} is (@literal null}.
	 */
	long delete(@Nonnull final Iterable<? extends T> entities);

	/**
	 * This is usually (but not always) more efficient than calling
	 * {@link CrudRepository#delete(Serializable)} multiple times.
	 * @param ids
	 * @return TODO
	 */
	long deleteIds(Iterable<ID> ids);

}

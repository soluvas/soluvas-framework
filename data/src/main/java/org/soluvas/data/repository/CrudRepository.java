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
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import org.soluvas.data.EntityLookup;

/**
 * Interface for generic CRUD operations on a repository for a specific type.
 * 
 * The difference to Spring Data 1.4 are:
 * <ol>
 * 	<li>@{@link Nonnull} annotations</li>
 *  <li>CrudRepository{@link #isEmpty()}</li>
 *  <li>Supports bulk delete by IDs: {@link CrudRepository#deleteIds(Collection)}.</li>
 *  <li>Extends {@link BasicRepository}</li>
 *  <li>find methods return {@link Collection} instead of {@link Iterable}. Reason
 *  	is find methods are not supposed to return large results anyway. For that
 *  	you need batching or paging. The ability to call {@link Collection#size()}
 *  	outweights the {@link Iterable} benefits.</li>
 *  <li>EntityLookup{@link #findOne(Serializable)} returns subclass of T.
 *  <li>{@link #delete(Object)} methods return number of changed entities</li>
 *  <li>{@link #add(Object)} and {@link #modify(Serializable, Object)} methods to replace {@link #save(Object)}</li>
 * </ol>
 * 
 * @author Oliver Gierke
 * @author Eberhard Wolff
 * @author Hendy Irawan
 */
//@NoRepositoryBean
public interface CrudRepository<T, ID extends Serializable> extends Repository<T, ID>, BasicRepository, EntityLookup<T, ID> {

	/**
	 * Adds a given entity. Use the returned instance for further operations as the save operation might have changed the
	 * entity instance completely.
	 * 
	 * @param entity
	 * @return the saved entity
	 */
	public abstract <S extends T> S add(S entity);
	
	/**
	 * Adds all given entities.
	 * 
	 * @param entities It may be {@link Collection#isEmpty()}, part of the reason is because {@link PagingAndSortingRepositoryBase#save(Collection)} expects it that way.
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is (@literal null}.
	 */
	public abstract <S extends T> Collection<S> add(Collection<S> entities);
	
	/**
	 * Modifies a given entity. Some repositories may allow modifying the {@code id} attribute.
	 * 
	 * @param entities
	 * @return the modified entities
	 * @throws IllegalArgumentException in case the given entity is (@literal null}.
	 */
	public abstract <S extends T> S modify(ID id, S entity);

	/**
	 * Modifies the given entities. Some repositories may allow modifying the {@code id} attribute.
	 * 
	 * @param entities It may be {@link Map#isEmpty()}, part of the reason is because {@link PagingAndSortingRepositoryBase#save(Collection)} expects it that way
	 * @return the modified entities
	 * @throws IllegalArgumentException in case the given entity is (@literal null}.
	 */
	public abstract <S extends T> Collection<S> modify(Map<ID, S> entities);

	/**
	 * Saves a given entity. Use the returned instance for further operations as the save operation might have changed the
	 * entity instance completely.
	 * 
	 * Note that default implementation in {@link CrudRepositoryBase} is not efficient,
	 * it's recommended to call {@link #add(Object)} or {@link #modify(Serializable, Object)} instead.
	 * 
	 * @param entity
	 * @return the saved entity
	 */
	@Deprecated
	<S extends T> S save(final S entity);
	
	/**
	 * Saves all given entities.
	 * 
	 * @param entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is (@literal null}.
	 */
	@Deprecated
	<S extends T> Collection<S> save(final Collection<S> entities);
	
	/**
	 * Returns whether an entity with the given id exists.
	 * 
	 * @param id must not be {@literal null}.
	 * @return true if an entity with the given id exists, alse otherwise
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	boolean exists(final ID id);

	/**
	 * Returns whether all entities with the given ids exists.
	 * 
	 * @param ids must not be {@literal null}.
	 * @return true if an entity with the given id exists, alse otherwise
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	boolean existsAll(final Collection<ID> ids);

	/**
	 * Returns whether any entity with one of the given ids exists.
	 * 
	 * @param ids must not be {@literal null}.
	 * @return true if an entity with the given id exists, alse otherwise
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	boolean existsAny(final Collection<ID> ids);

	/**
	 * Returns all instances of the type.
	 * 
	 * <p>WARNING: You usually would want {@link PageableAndSortable#findAll(org.soluvas.data.domain.Pageable)} instead.
	 * 
	 * @return all entities
	 */
	List<T> findAll();

	/**
	 * Returns all instances of the type with the given IDs.
	 * Not found instances are skipped, but should be logged.
	 * 
	 * @param ids
	 * @return
	 */
	List<T> findAll(Collection<ID> ids);

    /**
	 * Returns the number of entities matching the given ids.
	 * 
	 * @return the number of entities, the maximum number of returned
	 * is always the size of ids parameter.
	 */
	long count(Collection<ID> ids);

	/**
	 * Deletes the entity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return {@literal true} if deleted.
	 * @throws IllegalArgumentException in case the given {@code id} is {@literal null}
	 */
	boolean delete(final ID id);

	/**
	 * Deletes a given entity.
	 * 
	 * @param entity
	 * @return {@literal true} if deleted.
	 * @throws IllegalArgumentException in case the given entity is (@literal null}.
	 */
	boolean delete(final T entity);

	/**
	 * Deletes the given entities.
	 * 
	 * @param entities
	 * @return Number of deleted entities.
	 * @throws IllegalArgumentException in case the given {@link Iterable} is (@literal null}.
	 */
	long delete(final Collection<? extends T> entities);

	/**
	 * This is usually (but not always) more efficient than calling
	 * {@link CrudRepository#delete(Serializable)} multiple times.
	 * @param ids
	 * @return Number of deleted entities.
	 */
	long deleteIds(Collection<ID> ids);

}

package org.soluvas.data.repository;

import java.io.Serializable;

import javax.annotation.Nonnull;

import org.soluvas.data.query.Criteria;

/**
 * {@link CrudRepository} supporting {@link Criteria} for the following operations:
 * 
 * <ol>
 * 	<li>findOne</li>
 * 	<li>findAll</li>
 * 	<li>exists</li>
 * 	<li>count</li>
 * 	<li>delete</li>
 * </ol>
 * find, exists, count and delete operations.
 * @author ceefour
 * @todo Switch to Querydsl
 */
public interface CriteriaRepository<T, ID extends Serializable>  extends CrudRepository<T, ID> {
	
	<S extends T> Iterable<S> findOne(@Nonnull final Criteria criteria);

	T findAll(@Nonnull final Criteria criteria);
	
	boolean exists(@Nonnull final Criteria criteria);
	
	long count(@Nonnull final Criteria criteria);
	
	void delete(@Nonnull final Criteria criteria);

}

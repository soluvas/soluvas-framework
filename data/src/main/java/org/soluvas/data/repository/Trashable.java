package org.soluvas.data.repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import org.soluvas.data.TrashResult;
import org.soluvas.data.UntrashResult;

import scala.util.Try;

/**
 * Repository methods to support trash semantics.
 * Usually implemented via status attribute, but that is implementation detail.
 * <p>Untrashing is a bit problematic because most stores override the status
 * attribute when trashing, i.e. the previous status value was lost.
 * @author ceefour
 */
public interface Trashable<T, ID extends Serializable> {

	/**
	 * Moves an entity to trash.
	 * @param entity
	 * @return Trash operation result.
	 */
	TrashResult trash(T entity);
	
	/**
	 * Moves an entity to trash.
	 * @param id
	 * @return Trash operation result.
	 */
	TrashResult trashById(ID id);
	
	/**
	 * Moves multiple entities to trash.
	 * @param entities
	 * @return Key is entity's ID.
	 */
	Map<String, Try<TrashResult>> trashAll(Collection<T> entities);

	/**
	 * Moves multiple entities to trash.
	 * @param ids
	 * @return Key is entity's ID.
	 */
	Map<String, Try<TrashResult>> trashAllByIds(Collection<ID> ids);

	/**
	 * Restores an entity from trash.
	 * @param entity
	 * @return Untrash operation result.
	 */
	UntrashResult untrash(T entity);
	
	/**
	 * Restores an entity from trash.
	 * @param id
	 * @return Untrash operation result.
	 */
	UntrashResult untrashById(ID id);
	
	/**
	 * Restores multiple entities from trash.
	 * @param entities
	 * @return Key is entity's ID.
	 */
	Map<String, Try<UntrashResult>> untrashAll(Collection<T> entities);

	/**
	 * Restores multiple entities from trash.
	 * @param ids
	 * @return Key is entity's ID.
	 */
	Map<String, Try<UntrashResult>> untrashAllByIds(Collection<ID> ids);

}

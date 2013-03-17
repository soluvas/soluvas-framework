package org.soluvas.data.push;

import java.io.Serializable;
import java.util.List;

import org.soluvas.async.FailingCallback;

/**
 * Callback-based repository.
 * This is a the lowest-level repository access API. For convenience,
 * you can use {@link SyncRepositoryWrapper}.
 * 
 * The API is meant for asynchronous callbacks, i.e. the callback
 * should be an Akka typed actor or a Camel proxy.
 * @author ceefour
 */
public interface CallbackRepository<T, ID extends Serializable> {
	
	/**
	 * Add entity to repository.
	 * @param data
	 * @param callback
	 */
	void add(T data, FailingCallback<T> callback);
	
	/**
	 * Delete entity from repository.
	 * @param id
	 * @param callback
	 */
	void delete(ID id, FailingCallback<T> callback);
	
	/**
	 * Find a single entity by ID.
	 * @param id
	 * @param callback
	 */
	void findOne(ID id, FailingCallback<T> callback);
	
	/**
	 * Find all data.
	 * @param callback
	 */
	void findAll(FailingCallback<List<T>> callback);
	
	/**
	 * List all entity IDs.
	 * @param callback
	 */
	void findAllIds(FailingCallback<List<ID>> callback);
	
	/**
	 * Coarse-grained query for search entities by partial ID, partial slug, or partial name.
	 * For detailed query use the query() method.
	 * @param searchText
	 * @param callback
	 */
	void search(String searchText, FailingCallback<List<T>> callback);
	
	/**
	 * Update an entity with new attributes. <tt>id</tt> attribute is usually immutable.
	 * @param id
	 * @param data
	 * @param callback
	 */
	void update(ID id, T data, FailingCallback<T> callback);

}

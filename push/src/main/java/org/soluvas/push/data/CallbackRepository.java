package org.soluvas.push.data;

import java.util.List;

import org.soluvas.async.FailingCallback;

/**
 * Callback-based repository.
 * The API is meant for asynchronous callbacks, i.e. the callback
 * should be an Akka typed actor or a Camel proxy.
 * @author ceefour
 */
public interface CallbackRepository<ID, T> {
	
	void add(T data, FailingCallback<T> callback);
	void delete(ID id, FailingCallback<T> callback);
	void findOne(ID id, FailingCallback<T> callback);
	void findAll(FailingCallback<List<T>> callback);
	void findAllIds(FailingCallback<List<ID>> callback);
	void search(String searchText, FailingCallback<List<T>> callback);

}

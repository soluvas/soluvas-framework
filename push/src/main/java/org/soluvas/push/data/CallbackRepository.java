package org.soluvas.push.data;

import java.util.List;

import org.soluvas.async.Callback;

/**
 * Callback-based repository.
 * The API is meant for asynchronous callbacks, i.e. the callback
 * should be an Akka typed actor or a Camel proxy.
 * @author ceefour
 */
public interface CallbackRepository<ID, T> {
	
	void add(T menu);
	void delete(ID id);
	void findOne(ID id, Callback<T> callback);
	void findAll(Callback<List<T>> callback);
	void findAllIds(Callback<List<T>> callback);

}

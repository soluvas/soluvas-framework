package org.soluvas.push.data;

import java.util.List;

/**
 * Repository with synchronous API.
 * @author ceefour
 */
public interface SyncRepository<ID, T> {

	T findOne(ID id);
	List<T> findAll();
	T create(T entry);
	T update(ID id, T entry);
	void delete(ID id);

}

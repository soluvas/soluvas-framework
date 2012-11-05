package org.soluvas.push.data;

import java.io.Serializable;
import java.util.List;

import org.soluvas.data.repository.CrudRepository;

/**
 * Repository with synchronous API.
 * @author ceefour
 * @deprecated This should be just {@link CrudRepository}, and replaced by AbstractCrudRepository. 
 */
@Deprecated
public interface SyncRepository<T, ID extends Serializable> {

	T findOne(ID id);
	List<T> findAll();
	T create(T entry);
	T update(ID id, T entry);
	void delete(ID id);

}

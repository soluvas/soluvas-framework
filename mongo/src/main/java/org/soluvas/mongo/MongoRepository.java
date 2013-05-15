package org.soluvas.mongo;

import org.soluvas.commons.Identifiable;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.repository.Repository;

import com.mongodb.DBObject;

/**
 * Mongo-specific {@link Repository} enhancements.
 * @author atang
 */
public interface MongoRepository<T extends Identifiable> extends Repository<T, String> {

	public Page<T> findAllByQuery(DBObject dbo, Pageable pageable);

	public long countByQuery(DBObject query);

	public T findOneByQuery(DBObject upQuery);

}

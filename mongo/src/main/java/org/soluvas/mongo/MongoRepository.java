package org.soluvas.mongo;

import org.soluvas.commons.Identifiable;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;

import com.mongodb.DBObject;

/**
 * @author atang
 *
 */
public interface MongoRepository<T extends Identifiable> {

	Page<T> findAllByQuery(DBObject dbo, Pageable pageable);

	long countByQuery(DBObject query);

}

package org.soluvas.mongo;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Nullable;

import org.soluvas.commons.Identifiable;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Projection;
import org.soluvas.data.repository.CrudRepository.ModificationTimePolicy;
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

	/**
	 * @param projection true to include the field. The find() method always includes the _id field even if the field is not explicitly stated to return in the projection parameter.
	 * 		false to exclude the field.
	 * 		A projection cannot contain both include and exclude specifications, except for the exclusion of the _id field. In projections that explicitly include fields, the _id field is the only field that you can explicitly exclude.
	 * @param pageable
	 * @return
	 */
	Page<T> findAllFields(@Nullable Projection projection, Pageable pageable);

	<S extends T> Collection<S> modify(Map<String, S> entities, ModificationTimePolicy mtimePolicy);

	<S extends T> S modify(String id, S entity, ModificationTimePolicy mtimePolicy);

}

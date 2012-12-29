package org.soluvas.security;

import org.soluvas.data.repository.CrudRepository;

public interface AppSessionRepository extends CrudRepository<AppSession, String> {

	public abstract AppSession findOneByActive(String _id);

}

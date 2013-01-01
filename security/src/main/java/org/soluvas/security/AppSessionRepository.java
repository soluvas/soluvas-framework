package org.soluvas.security;

import java.util.List;

import org.soluvas.data.repository.CrudRepository;

public interface AppSessionRepository extends CrudRepository<AppSession, String> {

	public abstract AppSession findOneByActive(String _id);

	public abstract List<AppSession> findAllByActive();

}

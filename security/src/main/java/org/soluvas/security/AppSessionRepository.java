package org.soluvas.security;

import org.soluvas.data.repository.CrudRepository;

public interface AppSessionRepository extends CrudRepository<AppSession, String> {

	public abstract void init();

	/**
	 * @return the nameSpace
	 */
	public abstract String getNameSpace();

	/**
	 * @param nameSpace the nameSpace to set
	 */
	public abstract void setNameSpace(String nameSpace);

	/**
	 * @return the mongoUri
	 */
	public abstract String getMongoUri();

	/**
	 * @param mongoUri the mongoUri to set
	 */
	public abstract void setMongoUri(String mongoUri);

	public abstract AppSession findOneByActive(String _id);

}
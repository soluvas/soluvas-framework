package org.soluvas.jpa;

import java.io.Serializable;

import javax.persistence.Entity;

import org.joda.time.DateTime;
import org.soluvas.commons.Identifiable;
import org.soluvas.commons.Timestamped;

/**
 * {@link Identifiable} + {@link Timestamped} for JPA {@link Entity}s.
 * @author rudi
 */
public interface JpaEntity<ID extends Serializable> {
	
	public ID getId();
	
	public void setId(ID id);
	
	public DateTime getCreationTime();
	
	public void setCreationTime(DateTime creationTime);
	
	public DateTime getModificationTime();
	
	public void setModificationTime(DateTime modificationTime);

}

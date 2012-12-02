package org.soluvas.data.repository;

import java.io.Serializable;

/**
 * @author ceefour
 */
public interface IdAssocRepository<LID extends Serializable, RID extends Serializable>
	extends BasicAssocRepository<LID, RID> {

}

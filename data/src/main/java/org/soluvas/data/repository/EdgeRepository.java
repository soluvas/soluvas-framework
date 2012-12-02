package org.soluvas.data.repository;

import java.io.Serializable;

/**
 * A subset ({@link BasicAssocRepository}) of {@link AssocRepository} combined with {@link CrudRepository},
 * where each association (edge) is an entity in its own right.
 * 
 * <p>There can be (but not always) multiple edges that links from left to right.
 * 
 * <p>Example of single-edged EdgeRepository is: Like (attributes: creationTime, modificationTime), it can also be implemented as a AssocRepository
 * but will lose edge attributes.
 * 
 * <p>Example of single-edged EdgeRepository is: FriendRequest, Friend (attributes: creationTime, modificationTime, approvalTime, friendLists).
 * 
 * <p>Example of EdgeRepository with multiple edges is: Wink. Wink is also a hyperedge.
 * @author ceefour
 */
public interface EdgeRepository<T, ID extends Serializable, L, R> extends CrudRepository<T, ID>, BasicAssocRepository<L, R> {

}

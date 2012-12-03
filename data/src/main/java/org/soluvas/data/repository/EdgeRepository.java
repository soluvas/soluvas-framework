package org.soluvas.data.repository;

import java.io.Serializable;

import javax.annotation.Nonnull;

import org.neo4j.graphdb.Relationship;
import org.soluvas.data.domain.Edge;

/**
 * A subset ({@link BasicAssocRepository}) of {@link AssocRepository} combined with {@link CrudRepository},
 * where each association (edge) is an entity in its own right.
 * 
 * <p>The implementation doesn't have to store a "real entity", it can be a e.g. Neo4j {@link Relationship},
 * where a {@link Relationship} can store {@code creationTime} and {@code modificationTime} as properties.
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
public interface EdgeRepository<L, R, LID extends Serializable, RID extends Serializable,
		T extends Edge<L, R>, ID extends Serializable>
	extends CrudRepository<T, ID>, BasicAssocRepository<L, R> {

    /**
     * Stores a left-right pair in the multimap.
     *
     * <p>Some multimap implementations allow duplicate left-right pairs, in which
     * case {@code put} always adds a new left-right pair and increases the
     * multimap size by 1. Other implementations prohibit duplicates, and storing
     * a left-right pair that's already in the multimap has no effect.
     *
     * @param key key to store in the multimap
     * @param value value to store in the multimap
     * @return {@code true} if the method increased the size of the multimap, or
     *     {@code false} if the multimap already contained the left-right pair and
     *     doesn't allow duplicates
     */
    public abstract T put(@Nonnull LID leftId, @Nonnull RID rightID);

}

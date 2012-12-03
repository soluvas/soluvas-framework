package org.soluvas.data.repository;

import java.io.Serializable;

import javax.annotation.Nonnull;

/**
 * The most powerful {@link AssocRepository}, able to look up the {@code L}
 * and {@code R} objects at will, simply by given the {@code LID} and {@code RID}.
 * 
 * <p>Methods that take L and R as parameters are not efficient,
 * please use the {@code LID}/{@code RID} variants.
 * 
 * @author ceefour
 */
public interface LookupAssocRepository<L, R, LID extends Serializable, RID extends Serializable> extends
		ExtendedAssocRepository<L, R, LID, RID> {

    // Modification Operations

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
    boolean put(@Nonnull LID leftId, @Nonnull RID rightID);

}

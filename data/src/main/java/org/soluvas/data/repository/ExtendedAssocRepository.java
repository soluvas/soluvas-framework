package org.soluvas.data.repository;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Nonnull;

import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Sort;

/**
 * An {@link AssocRepository} with extended operations which mimic
 * those in {@link IdAssocRepository}.
 * @author ceefour
 */
public interface ExtendedAssocRepository<L, R, LID extends Serializable, RID extends Serializable>
	extends AssocRepository<L, R> {

    // Query Operations

	/**
	 * Returns a collection view of all rights associated with a key. If no
	 * mappings in the multimap have the provided key, an empty collection is
	 * returned.
	 *
	 * @param key key to search for in multimap
	 * @return the collection of rights that the key maps to
	 */
	@Nonnull
	public abstract Collection<R> getLeft(@Nonnull LID leftId);

	/**
	 * Returns a collection view of all lefts associated with a key. If no
	 * mappings in the multimap have the provided key, an empty collection is
	 * returned.
	 *
	 * @param right right to search for in multimap
	 * @return the collection of lefts that the key maps to
	 */
	@Nonnull
	public abstract Collection<L> getRight(@Nonnull RID rightId);

	/**
	 * Returns a collection view of all rights associated with a key. If no
	 * mappings in the multimap have the provided key, an empty collection is
	 * returned.
	 *
	 * @param key key to search for in multimap
	 * @return the collection of rights that the key maps to
	 * @todo Add a {@link Sort} variant, like {@link #findAll()}
	 */
	@Nonnull
	public abstract Page<R> getLeft(@Nonnull LID leftId, @Nonnull Pageable pageable);

	/**
	 * Returns a collection view of all lefts associated with a key. If no
	 * mappings in the multimap have the provided key, an empty collection is
	 * returned.
	 *
	 * @param right right to search for in multimap
	 * @return the collection of lefts that the key maps to
	 * @todo Add a {@link Sort} variant, like {@link #findAll()}
	 */
	@Nonnull
	public abstract Page<L> getRight(@Nonnull RID rightId, @Nonnull Pageable pageable);
	
	/**
	 * Returns the number of right values (should never be duplicates) for a particular left.
	 */
	public abstract long countRights(@Nonnull LID leftId);

	/**
	 * Returns the number of left values (should never be duplicates) for a particular right.
	 */
	public abstract long countLefts(@Nonnull RID rightId);

    // Modification Operations

    /**
     * Removes a single left-right pair from the multimap.
     *
     * @param key key of entry to remove from the multimap
     * @param value value of entry to remove the multimap
     * @return {@code true} if the multimap changed
     */
    boolean delete(@Nonnull LID leftId, @Nonnull RID rightId);

    // Bulk Operations

    /**
     * Removes one or more left-right pairs with the same left from the multimap.
     *
     * @param left left of entry to remove from the multimap
     * @param rights rights of entry to remove the multimap
     * @return {@code true} if the multimap changed
     */
    long delete(@Nonnull LID leftId, @Nonnull Iterable<RID> rightIds);

    /**
     * Removes one or more left-right pairs with the same right from the multimap.
     *
     * @param lefts lefts of entry to remove from the multimap
     * @param right right of entry to remove the multimap
     * @return {@code true} if the multimap changed
     */
    long delete(@Nonnull Iterable<LID> leftIds, @Nonnull RID rightId);

}

/**
 * 
 */
package org.soluvas.data.repository;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;

/**
 * Repository that manages left-right pairs. A left-right pair is unique (no duplicates),
 * and has no attached information (unlike graph edges, which are
 * objects in their own right). Only the pair is unique, each left can have
 * multiple rights, and each right can have multiple lefts.
 * 
 * A {@link AssocRepository} is usually used as follows.
 * 
 * 1. Associating IDs with IDs. The L and R generic parameters will be strings,
 *    and no other information is provided.
 * 2. Another interface is used to get a representation objects of LID and RID.
 *    For example LID may represented Role and RID may represent Person.
 *    Usually, the LID is the "owner" of the association.
 *    For example, in Role-Person association in LDAP, the associations
 *    are stored in the <tt>groupOfUniqueNames</tt> entry, hence belonging to the Role.
 *    
 * And ID may be either a "real" ID or a path (e.g. "bags/hobos").
 * It is assumed that IDs are homogenous, i.e. LID is IDs from a
 * particular class and also with RID.
 *  
 * For heterogenous IDs, e.g. likes, where LID can be Person/Shop/Page,
 * and RID can be Product/Shop/Page; IDs need a namespacing mechanism
 * (using URN scheme, path, or QName). Or maybe a job for a different interface
 * (TypedAssocRepository?).
 * 
 * Inspired by com.tinkerpop.blueprints.pgm.Graph.
 * @see BiMap, {@link Multimap}
 * @author ceefour
 */
public interface AssocRepository<LID, RID> extends BasicRepository {

    // Query Operations

    /** Returns the number of left-right pairs in the multimap. */
    @Override
	long count();

    /** Returns {@code true} if the multimap contains no left-right pairs. */
    @Override
	boolean isEmpty();

    /**
     * Returns {@code true} if the multimap contains any rights for the specified
     * key.
     *
     * @param key key to search for in multimap
     */
    boolean containsLeft(@Nullable LID left);

    /**
     * Returns {@code true} if the multimap contains the specified value for any
     * key.
     *
     * @param value value to search for in multimap
     */
    boolean containsRight(@Nullable RID right);

    /**
     * Returns {@code true} if the multimap contains the specified left-right pair.
     *
     * @param key key to search for in multimap
     * @param value value to search for in multimap
     */
    boolean containsEntry(@Nullable LID left, @Nullable RID right);

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
    boolean put(@Nullable LID left, @Nullable RID right);

    /**
     * Removes a single left-right pair from the multimap.
     *
     * @param key key of entry to remove from the multimap
     * @param value value of entry to remove the multimap
     * @return {@code true} if the multimap changed
     */
    boolean remove(@Nullable LID left, @Nullable RID right);

    // Bulk Operations

    /**
     * Stores a collection of rights with the same left.
     *
     * @param left left to store in the multimap
     * @param rights rights to store in the multimap
     * @return {@code true} if the multimap changed
     */
    boolean putAll(@Nullable LID left, Iterable<? extends RID> rights);

    /**
     * Stores a collection of lefts with the same right.
     *
     * @param key key to store in the multimap
     * @param rights rights to store in the multimap
     * @return {@code true} if the multimap changed
     */
    boolean putAllInverse(@Nullable LID right, Iterable<? extends RID> lefts);

    /**
     * Copies all of another multimap's left-right pairs into this multimap. The
     * order in which the mappings are added is determined by
     * {@code multimap.entries()}.
     *
     * @param multimap mappings to store in this multimap
     * @return {@code true} if the multimap changed
     */
    boolean putAll(Multimap<? extends LID, ? extends RID> multimap);

    /**
     * Copies all of another multimap's right-left pairs into this multimap. The
     * order in which the mappings are added is determined by
     * {@code multimap.entries()}.
     *
     * @param multimap mappings to store in this multimap
     * @return {@code true} if the multimap changed
     */
    boolean putAllInverse(Multimap<? extends RID, ? extends LID> inverseMultimap);

    /**
     * Stores a collection of rights with the same left, replacing any existing
     * rights for that left.
     *
     * @param key key to store in the multimap
     * @param rights rights to store in the multimap
     * @return the collection of replaced rights, or an empty collection if no
     *     rights were previously associated with the key. The collection
     *     <i>may</i> be modifiable, but updating it will have no effect on the
     *     multimap.
     */
    Collection<RID> replaceRights(@Nullable LID left, Iterable<? extends RID> rights);

    /**
     * Stores a collection of lefts with the same right, replacing any existing
     * lefts for that right.
     *
     * @param key key to store in the multimap
     * @param rights rights to store in the multimap
     * @return the collection of replaced rights, or an empty collection if no
     *     rights were previously associated with the key. The collection
     *     <i>may</i> be modifiable, but updating it will have no effect on the
     *     multimap.
     */
    Collection<RID> replaceLefts(@Nullable LID right, Iterable<? extends LID> lefts);

    /**
     * Removes all rights associated with a given left.
     *
     * @param left left of entries to remove from the multimap
     * @return the collection of removed rights, or an empty collection if no
     *     rights were associated with the provided key. The collection
     *     <i>may</i> be modifiable, but updating it will have no effect on the
     *     multimap.
     */
    Collection<RID> removeAllRights(@Nullable LID left);

    /**
     * Removes all lefts associated with a given right.
     *
     * @param right right of entries to remove from the multimap
     * @return the collection of removed rights, or an empty collection if no
     *     rights were associated with the provided key. The collection
     *     <i>may</i> be modifiable, but updating it will have no effect on the
     *     multimap.
     */
    Collection<LID> removeAllLefts(@Nullable RID right);

    /**
     * Removes all left-right pairs from the multimap.
     */
    @Override
	void deleteAll();

    // Views

    /**
     * Returns a collection view of all rights associated with a key. If no
     * mappings in the multimap have the provided key, an empty collection is
     * returned.
     *
     * <p>Changes to the returned collection will update the underlying multimap,
     * and vice versa.
     *
     * @param key key to search for in multimap
     * @return the collection of rights that the key maps to
     */
    Collection<RID> getLeft(@Nullable LID left);

    /**
     * Returns a collection view of all lefts associated with a key. If no
     * mappings in the multimap have the provided key, an empty collection is
     * returned.
     *
     * <p>Changes to the returned collection will update the underlying multimap,
     * and vice versa.
     *
     * @param right right to search for in multimap
     * @return the collection of lefts that the key maps to
     */
    Collection<LID> getRight(@Nullable RID right);

    /**
     * Returns the set of all lefts, each appearing once in the returned set.
     *
     * @return the collection of distinct lefts
     */
    Set<LID> leftSet();

    /**
     * Returns the set of all rights, each appearing once in the returned set.
     *
     * @return the collection of distinct rights
     */
    Set<RID> rightSet();

    /**
     * Returns a collection, which may contain duplicates, of all keys. The number
     * of times of key appears in the returned multiset equals the number of
     * mappings the key has in the multimap. Changes to the returned multiset will
     * update the underlying multimap, and vice versa.
     *
     * @return a multiset with keys corresponding to the distinct keys of the
     *     multimap and frequencies corresponding to the number of rights that
     *     each key maps to
     */
    Multiset<LID> lefts();

    /**
     * Returns a collection of all rights in the multimap. Changes to the returned
     * collection will update the underlying multimap, and vice versa.
     *
     * @return collection of rights, which may include the same value multiple
     *     times if it occurs in multiple mappings
     */
    Multiset<RID> rights();
    
    /**
     * Returns a multimap of all left-right pairs. It's the reverse of
     * {@link #putAll(Multimap)}.
     *
     * @return map entries
     */
    Multimap<LID, RID> findAll();

    /**
     * Returns a collection of all left-right pairs. Changes to the returned
     * collection will update the underlying multimap, and vice versa. The entries
     * collection does not support the {@code add} or {@code addAll} operations.
     *
     * @return collection of map entries consisting of left-right pairs
     */
    Collection<Map.Entry<LID, RID>> entries();

}

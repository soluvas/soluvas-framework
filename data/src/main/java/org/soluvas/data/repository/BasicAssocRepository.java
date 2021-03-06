package org.soluvas.data.repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;

import org.soluvas.data.domain.Page;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;

/**
 * This is implemented by both {@link AssocRepository} and {@link EdgeRepository}.
 * 
 * <p>Collection Methods return {@link List} instead of {@link Collection} because:
 * 
 * <ol>
 * <li>{@link Page} contains a {@link List} anyway</li>
 * <li>Makes it easier to wrap with Wicket's {@code ListModel}</li>
 * </li>
 * 
 * <p>Note to implementors: The returned data structures ({@link List}, {@link Set}, {@link Map}, {@link Multimap}, {@link Multiset})
 * should be immutable.
 *
 * @param <L>
 * @param <R>
 * @author ceefour
 */
public interface BasicAssocRepository<L, R> extends BasicRepository {

	/** Returns the number of left-right pairs in the multimap. */
	@Override
	public abstract long count();

	/** Returns the number of left values (can be duplicates) in the multimap. */
	public abstract long countLefts();

	/** Returns the number of left set (no duplicates) in the multimap. */
	public abstract long countLeftSet();

	/** Returns the number of right values (can be duplicates) in the multimap. */
	public abstract long countRights();

	/** Returns the number of right set (no duplicates) in the multimap. */
	public abstract long countRightSet();

	/** Returns {@code true} if the multimap contains no left-right pairs. */
	@Override
	public abstract boolean isEmpty();

	/**
	 * Returns {@code true} if the multimap contains any rights for the specified
	 * key.
	 *
	 * @param key key to search for in multimap
	 */
	public abstract boolean containsLeft(@Nonnull L left);

	/**
	 * Returns {@code true} if the multimap contains the specified value for any
	 * key.
	 *
	 * @param value value to search for in multimap
	 */
	public abstract boolean containsRight(@Nonnull R right);

	/**
	 * Returns {@code true} if the multimap contains the specified left-right pair.
	 *
	 * @param key key to search for in multimap
	 * @param value value to search for in multimap
	 */
	public abstract boolean containsEntry(@Nonnull L left, @Nonnull R right);

	/**
	 * Removes all rights associated with a given left.
	 *
	 * @param left left of entries to remove from the multimap
	 * @return the collection of removed rights, or an empty collection if no
	 *     rights were associated with the provided key. The collection
	 *     <i>may</i> be modifiable, but updating it will have no effect on the
	 *     multimap.
	 */
	public abstract long deleteAllRights(@Nonnull L left);

	/**
	 * Removes all lefts associated with a given right.
	 *
	 * @param right right of entries to remove from the multimap
	 * @return the collection of removed rights, or an empty collection if no
	 *     rights were associated with the provided key. The collection
	 *     <i>may</i> be modifiable, but updating it will have no effect on the
	 *     multimap.
	 */
	public abstract long deleteAllLefts(@Nonnull R right);

	/**
	 * Removes all left-right pairs from the multimap.
	 */
	@Override
	public abstract long deleteAll();

	/**
	 * Returns a collection view of all rights associated with a key. If no
	 * mappings in the multimap have the provided key, an empty collection is
	 * returned.
	 *
	 * The returned {@link List} should be immutable.
	 *
	 * @param key key to search for in multimap
	 * @return the collection of rights that the key maps to
	 */
	@Nonnull
	public abstract List<R> getLeft(@Nonnull final L left);

	/**
	 * Returns a collection view of all lefts associated with a key. If no
	 * mappings in the multimap have the provided key, an empty collection is
	 * returned.
	 * 
	 * The returned {@link List} should be immutable.
	 *
	 * @param right right to search for in multimap
	 * @return the collection of lefts that the key maps to
	 */
	@Nonnull
	public abstract List<L> getRight(@Nonnull R right);

	/**
	 * Returns the set of all lefts, each appearing once in the returned set.
	 *
	 * @return the collection of distinct lefts
	 */
	@Nonnull
	public abstract Set<L> leftSet();

	/**
	 * Returns the set of all rights, each appearing once in the returned set.
	 *
	 * @return the collection of distinct rights
	 */
	@Nonnull
	public abstract Set<R> rightSet();

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
	@Nonnull
	public abstract Multiset<L> lefts();

	/**
	 * Returns a collection of all rights in the multimap. Changes to the returned
	 * collection will update the underlying multimap, and vice versa.
	 *
	 * @return collection of rights, which may include the same value multiple
	 *     times if it occurs in multiple mappings
	 */
	@Nonnull
	public abstract Multiset<R> rights();

}
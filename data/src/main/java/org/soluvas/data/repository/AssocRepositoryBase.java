package org.soluvas.data.repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Nonnull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Sort;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;

/**
 * {@link AssocRepository} base implementation that only needs
 * few methods to override.
 * @author ceefour
 */
public abstract class AssocRepositoryBase<L, R> implements AssocRepository<L, R>,
	PageableAndSortable<Map.Entry<L, R>> {
	
	private transient Logger log = LoggerFactory
			.getLogger(AssocRepositoryBase.class);

	@Override
	public boolean isEmpty() {
		return count() == 0;
	}
	
	@Override
	public long count() {
		return findAll().size();
	}
	
	/**
	 * Deletes all associations by getting {@link #leftSet()},
	 * and {@link #deleteAllRights(Object)} on each of the left set.
	 */
	@Override
	public long deleteAll() {
		long removed = 0;
		Set<L> leftSet = leftSet();
		for (L left : leftSet) {
			long step = deleteAllRights(left);
			if (step > 0) {
				if (removed <= 0) {
					removed = step;
				} else {
					removed += step;
				}
			} else if (step < 0 && removed == 0) {
				removed = -1;
			}
		}
		return removed;
	}
	
	@Override
	public long delete(Iterable<L> lefts, R right) {
		long deleted = 0;
		for (L left : lefts) {
			if (delete(left, right))
				deleted++;
		}
		return deleted;
	};
	
	@Override
	public long delete(L left, Iterable<R> rights) {
		long deleted = 0;
		for (R right : rights) {
			if (delete(left, right))
				deleted++;
		}
		return deleted;
	}

	@Override
	public boolean containsLeft(L left) {
		return leftSet().contains(left);
	}

	@Override
	public boolean containsRight(R right) {
		return rightSet().contains(right);
	}

	@Override
	public boolean containsEntry(L left, R right) {
		Multimap<L, R> edges = findAll();
		return edges.containsEntry(left, right);
	}

	/**
	 * It's recommended to override this for efficiency,
	 * it's used by {@link #deleteAll()}.
	 */
	@Override
	@Nonnull
	public long deleteAllRights(L left) {
		Collection<R> rights = getLeft(left);
		long removed = 0;
		for (R right : rights) {
			if (delete(left, right))
				removed++;
		}
		return removed;
	}

	@Override
	@Nonnull
	public long deleteAllLefts(R right) {
		Collection<L> lefts = getRight(right);
		long removed = 0;
		for (L left : lefts) {
			if (delete(left, right))
				removed++;
		}
		return removed;
	}

	/**
	 * It's recommended to override this for effiency.
	 * The default implementation simply calls {@link #put(Object, Object)} repeatedly.
	 */
	@Override
	public long put(L left, Iterable<? extends R> rights) {
		long result = 0;
		for (R right : rights) {
			if (put(left, right))
				result++;
		}
		return result;
	}

	@Override
	public long put(Iterable<? extends L> lefts, R right) {
		long result = 0;
		for (L left : lefts) {
			if (put(left, right))
				result++;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public long put(Multimap<? extends L, ? extends R> multimap) {
		long result = 0;
		Set<? extends L> leftSet = multimap.keySet();
		for (L left : leftSet) {
			long changed = put(left, ((Multimap<L, ? extends R>)multimap).get(left));
			if (changed > 0) {
				if (result > 0)
					result += changed;
				else
					result = changed;
			} else if (changed == -1) {
				if (result <= 0)
					result = changed;
			}
		}
		return result;
	}

	@Override
	public long putInverse(
			Multimap<? extends R, ? extends L> inverseMultimap) {
		Multimap<L, R> normal = ImmutableMultimap.copyOf(inverseMultimap).inverse();
		return put(normal);
	}

	@Override
	@Nonnull
	public long replaceRights(L left, Iterable<? extends R> rights) {
		long removeAllRights = deleteAllRights(left);
		long putAll = put(left, rights);
		if (removeAllRights == 0 && putAll == 0) {
			return 0;
		} else if (removeAllRights > 0 && putAll > 0) {
			return removeAllRights + putAll;
		} else if (removeAllRights > 0) {
			return removeAllRights;
		} else if (putAll > 0) {
			return putAll;
		} else {
			return -1;
		}
	}

	@Override
	@Nonnull
	public void replaceLefts(R right, Iterable<? extends L> lefts) {
		deleteAllLefts(right);
		put(lefts, right);
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.AssocRepository#entries()
	 */
	@Override
	public Collection<Map.Entry<L, R>> entries() {
		return findAll().entries();
	}
	
	/**
	 * It is recommended to override this for efficiency.
	 * The default implementation simply processes {@link #findAll()}.
	 */
	@Override
	@Nonnull
	public Multiset<L> lefts() {
		return findAll().keys();
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.AssocRepository#leftSet()
	 */
	@Override
	public Set<L> leftSet() {
		return ImmutableSet.copyOf(lefts());
	}

	/**
	 * It is recommended to override this for efficiency.
	 * The default implementation simply processes {@link #findAll()}.
	 */
	@Override
	@Nonnull
	public Multiset<R> rights() {
		return ImmutableMultiset.copyOf(findAll().values());
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.AssocRepository#rightSet()
	 */
	@Override
	public Set<R> rightSet() {
		return ImmutableSet.copyOf(rights());
	}

	@Override
	public long countLefts() {
		return lefts().size();
	}

	@Override
	public long countLeftSet() {
		return leftSet().size();
	}

	@Override
	public long countRights() {
		return rights().size();
	}

	@Override
	public long countRightSet() {
		return rightSet().size();
	}
	
	/**
	 * It's recommended to override this method for efficiency,
	 * the default implementation uses {@link #getRight(Object)}.
	 */
	@Override
	public long countLefts(R right) {
		return getRight(right).size();
	}
	
	/**
	 * It's recommended to override this method for efficiency,
	 * the default implementation uses {@link #getLeft(Object)}.
	 */
	@Override
	public long countRights(L left) {
		return getLeft(left).size();
	}
	
	@Override
	@Nonnull
	public Collection<Entry<L, R>> findAll(Sort sort) {
		log.warn("Sorting on {} not supported", getClass());
		return findAll().entries();
	}
	
	@Override
	@Nonnull
	public Page<Entry<L, R>> findAll(Pageable pageable) {
		final Collection<Entry<L, R>> entries = findAll(pageable.getSort());
		final Iterable<Entry<L, R>> skipped = Iterables.skip(
				entries, pageable.getOffset() + pageable.getPageNumber() * pageable.getPageSize());
		final Iterable<Entry<L, R>> limited = Iterables.limit(skipped, pageable.getPageSize());
		final List<Entry<L, R>> content = ImmutableList.copyOf(limited);
		return new PageImpl<Entry<L, R>>(content, pageable, entries.size());
	}
	
	/**
	 * It's recommended to override this for efficiency.
	 * The default implementation uses {@link #findAll()}.
	 * @see org.soluvas.data.repository.AssocRepository#getLeftCounts()
	 */
	@Override @Nonnull
	public Map<R, Long> getLeftCounts() {
		final Multimap<R, L> invertedEntries = ImmutableMultimap.copyOf(findAll()).inverse();
		final ImmutableMap.Builder<R, Long> builder = ImmutableMap.builder();
		for (final R right : invertedEntries.keySet()) {
			final int count = invertedEntries.get(right).size();
			builder.put(right, Long.valueOf(count));
		}
		return builder.build();
	}
	
	/**
	 * It's recommended to override this for efficiency.
	 * The default implementation uses {@link #findAll()}.
	 * @see org.soluvas.data.repository.AssocRepository#getRightCounts()
	 */
	@Override @Nonnull
	public Map<L, Long> getRightCounts() {
		final Multimap<L, R> entries = findAll();
		final ImmutableMap.Builder<L, Long> builder = ImmutableMap.builder();
		for (final L left : entries.keySet()) {
			final int count = entries.get(left).size();
			builder.put(left, Long.valueOf(count));
		}
		return builder.build();
	}

}

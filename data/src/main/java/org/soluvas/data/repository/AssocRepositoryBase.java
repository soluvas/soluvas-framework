package org.soluvas.data.repository;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;

/**
 * {@link AssocRepository} base implementation that only needs
 * few methods to override.
 * @author ceefour
 */
public abstract class AssocRepositoryBase<L, R> implements AssocRepository<L, R> {

	@Override
	public boolean isEmpty() {
		return count() > 0;
	}
	
	@Override
	public long count() {
		return findAll().size();
	}
	
	/**
	 * Deletes all associations by getting {@link #leftSet()},
	 * and {@link #removeAllRights(Object)} on each of the left set.
	 */
	@Override
	public void deleteAll() {
		Set<L> leftSet = leftSet();
		for (L left : leftSet) {
			removeAllRights(left);
		}
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
	public long removeAllRights(L left) {
		Collection<R> rights = getLeft(left);
		long removed = 0;
		for (R right : rights) {
			if (remove(left, right))
				removed++;
		}
		return removed;
	}

	@Override
	@Nonnull
	public long removeAllLefts(R right) {
		Collection<L> lefts = getRight(right);
		long removed = 0;
		for (L left : lefts) {
			if (remove(left, right))
				removed++;
		}
		return removed;
	}

	/**
	 * It's recommended to override this for effiency.
	 * The default implementation simply calls {@link #put(Object, Object)} repeatedly.
	 */
	@Override
	public long putAll(L left, Iterable<? extends R> rights) {
		long result = 0;
		for (R right : rights) {
			if (put(left, right))
				result++;
		}
		return result;
	}

	@Override
	public long putAllInverse(R right, Iterable<? extends L> lefts) {
		long result = 0;
		for (L left : lefts) {
			if (put(left, right))
				result++;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public long putAll(Multimap<? extends L, ? extends R> multimap) {
		long result = 0;
		Set<? extends L> leftSet = multimap.keySet();
		for (L left : leftSet) {
			long changed = putAll(left, ((Multimap<L, ? extends R>)multimap).get(left));
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
	public long putAllInverse(
			Multimap<? extends R, ? extends L> inverseMultimap) {
		Multimap<L, R> normal = ImmutableMultimap.copyOf(inverseMultimap).inverse();
		return putAll(normal);
	}

	@Override
	@Nonnull
	public long replaceRights(L left, Iterable<? extends R> rights) {
		long removeAllRights = removeAllRights(left);
		long putAll = putAll(left, rights);
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
		removeAllLefts(right);
		putAllInverse(right, lefts);
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.AssocRepository#entries()
	 */
	@Override
	public Collection<Map.Entry<L, R>> entries() {
		return findAll().entries();
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.AssocRepository#leftSet()
	 */
	@Override
	public Set<L> leftSet() {
		return ImmutableSet.copyOf(lefts());
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
		return rights().size();
	}

	@Override
	public long countRights() {
		return rights().size();
	}

	@Override
	public long countRightSet() {
		return rightSet().size();
	}

}

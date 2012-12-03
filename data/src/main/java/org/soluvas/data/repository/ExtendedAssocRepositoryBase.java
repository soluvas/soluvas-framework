package org.soluvas.data.repository;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * @author ceefour
 */
public abstract class ExtendedAssocRepositoryBase<L, R, LID extends Serializable, RID extends Serializable>
	extends AssocRepositoryBase<L, R>
	implements ExtendedAssocRepository<L, R, LID, RID> {

	@Override
	public long countRights(L left) {
		return countRights(getLeftId(left));
	}
	
	@Override
	public long countLefts(R right) {
		return countLefts(getRightId(right));
	}
	
	@Override
	public boolean delete(L left, R right) {
		return delete(getLeftId(left), getRightId(right));
	}
	
	@Override
	public long delete(final LID leftId, Iterable<RID> rightIds) {
		final List<Boolean> deleteds = ImmutableList.copyOf(
				Iterables.transform(rightIds, new Function<RID, Boolean>() {
			@Override
			@Nullable
			public Boolean apply(@Nullable RID rightId) {
				return delete(leftId, rightId);
			}
		}) );
		return Iterables.frequency(deleteds, true);
	}

	@Override
	public long delete(Iterable<LID> leftIds, final RID rightId) {
		final List<Boolean> deleteds = ImmutableList.copyOf(
				Iterables.transform(leftIds, new Function<LID, Boolean>() {
			@Override @Nullable
			public Boolean apply(@Nullable LID leftId) {
				return delete(leftId, rightId);
			}
		}) );
		return Iterables.frequency(deleteds, true);
	}
	
	/**
	 * Return the ID of a left object.
	 * @param left
	 * @return
	 */
	protected abstract LID getLeftId(L left);
	
	/**
	 * Return the ID of a right object.
	 * @param right
	 * @return
	 */
	protected abstract RID getRightId(R right);
	
	@Override @Nonnull
	public List<R> getLeft(L left) {
		return getLeft(getLeftId(left));
	}
	
	@Override @Nonnull
	public List<R> getLeft(LID leftId) {
		return doGetLeft(leftId, null, null).getContent();
	}

	@Override @Nonnull
	public List<L> getRight(R right) {
		return getRight(getRightId(right));
	}
	
	@Override @Nonnull
	public List<L> getRight(RID rightId) {
		return doGetRight(rightId, null, null).getContent();
	}

	/**
	 * Note to implementors: In the return value, skip the {@link Pageable}
	 * parameter.
	 * @param leftId
	 * @param skip
	 * @param limit
	 * @return
	 */
	@Nonnull
	protected abstract Page<R> doGetLeft(@Nonnull final LID leftId,
			@Nullable final Long skip, @Nullable final Long limit);

	/**
	 * Note to implementors: In the return value, skip the {@link Pageable}
	 * parameter.
	 * @param rightId
	 * @param skip
	 * @param limit
	 * @return
	 */
	@Nonnull
	protected abstract Page<L> doGetRight(@Nonnull final RID rightId,
			@Nullable final Long skip, @Nullable final Long limit);
	
	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.ExtendedAssocRepository#getLeft(java.io.Serializable, org.soluvas.data.domain.Pageable)
	 */
	@Override @Nonnull
	public Page<R> getLeft(LID leftId, Pageable pageable) {
		long skip = pageable.getOffset() + pageable.getPageNumber() * pageable.getPageSize();
		final Page<R> upPage = doGetLeft(leftId, skip, (long) pageable.getPageSize());
		return new PageImpl<R>(upPage.getContent(), pageable, upPage.getTotalElements());
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.ExtendedAssocRepository#getRight(java.io.Serializable, org.soluvas.data.domain.Pageable)
	 */
	@Override @Nonnull
	public Page<L> getRight(RID rightId, Pageable pageable) {
		long skip = pageable.getOffset() + pageable.getPageNumber() * pageable.getPageSize();
		final Page<L> upPage = doGetRight(rightId, skip, (long) pageable.getPageSize());
		return new PageImpl<L>(upPage.getContent(), pageable, upPage.getTotalElements());
	}

}

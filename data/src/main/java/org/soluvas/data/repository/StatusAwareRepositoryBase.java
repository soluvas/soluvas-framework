package org.soluvas.data.repository;

import java.io.Serializable;

import org.soluvas.data.StatusMask;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;

/**
 * Base class for {@link StatusMask}-supporting {@link Repository}.
 * @author ceefour
 */
public abstract class StatusAwareRepositoryBase<T, ID extends Serializable> extends
		PagingAndSortingRepositoryBase<T, ID>
	implements StatusAwareRepository<T, ID> {

	@Override
	public final Page<T> findAll(Pageable pageable) {
		return findAll(StatusMask.RAW, pageable);
	}

}

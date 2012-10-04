package org.soluvas.push.data;

import java.util.List;

import jline.internal.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.async.AsyncUtils;
import org.soluvas.async.FailingCallback;

import com.google.common.base.Function;

/**
 * Wraps a callback-based {@link CallbackRepository} API in a convenient synchronized (traditional) API style.
 * @author ceefour
 */
public class SyncRepositoryWrapper<ID, T> implements SyncRepository<ID, T> {

	private transient Logger log = LoggerFactory.getLogger(SyncRepositoryWrapper.class);
	private CallbackRepository<ID, T> delegateRepository;

	public SyncRepositoryWrapper(CallbackRepository<ID, T> delegateRepository) {
		super();
		this.delegateRepository = delegateRepository;
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.push.data.SyncRepository#findOne(java.lang.Object)
	 */
	@Override
	public T findOne(final ID id) {
		return AsyncUtils.wrap(new Function<FailingCallback<T>, Void>() {
			@Override @Nullable
			public Void apply(@Nullable FailingCallback<T> callback) {
				delegateRepository.findOne(id, callback);
				return null;
			}
		});
	}

	/* (non-Javadoc)
	 * @see org.soluvas.push.data.SyncRepository#findAll()
	 */
	@Override
	public List<T> findAll() {
		return AsyncUtils.wrap(new Function<FailingCallback<List<T>>, Void>() {
			@Override @Nullable
			public Void apply(@Nullable FailingCallback<List<T>> callback) {
				delegateRepository.findAll(callback);
				return null;
			}
		});
	}

	/* (non-Javadoc)
	 * @see org.soluvas.push.data.SyncRepository#create(java.lang.Object)
	 */
	@Override
	public T create(final T entry) {
		return AsyncUtils.wrap(new Function<FailingCallback<T>, Void>() {
			@Override @Nullable
			public Void apply(@Nullable FailingCallback<T> callback) {
				delegateRepository.add(entry, callback);
				return null;
			}
		});
	}

	/* (non-Javadoc)
	 * @see org.soluvas.push.data.SyncRepository#update(java.lang.Object, java.lang.Object)
	 */
	@Override
	public T update(final ID id, final T entry) {
		return AsyncUtils.wrap(new Function<FailingCallback<T>, Void>() {
			@Override @Nullable
			public Void apply(@Nullable FailingCallback<T> callback) {
				delegateRepository.update(id, entry, callback);
				return null;
			}
		});
	}

	/* (non-Javadoc)
	 * @see org.soluvas.push.data.SyncRepository#delete(java.lang.Object)
	 */
	@Override
	public void delete(final ID id) {
		T deleteResult = AsyncUtils.wrap(new Function<FailingCallback<T>, Void>() {
			@Override @Nullable
			public Void apply(@Nullable FailingCallback<T> callback) {
				delegateRepository.delete(id, callback);
				return null;
			}
		});
		log.debug("Delete {} result: {}", id, deleteResult);
	}

}

package org.soluvas.push.data;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.async.FailingCallback;

/**
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
	public T findOne(ID id) {
		try {
			final AtomicReference<T> result = new AtomicReference<T>();
			delegateRepository.findOne(id, new FailingCallback<T>() {
				@Override public void success(T data) {
					result.set(data);
					result.notify();
				}
				
				@Override public void error(Throwable e) {
					throw new RepositoryException(e);
				}
			});
			if (result.get() == null) {
				result.wait();
			}
			return result.get();
		} catch (InterruptedException e) {
			throw new RepositoryException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.soluvas.push.data.SyncRepository#findAll()
	 */
	@Override
	public List<T> findAll() {
		try {
			final AtomicReference<List<T>> result = new AtomicReference<List<T>>();
			delegateRepository.findAll(new FailingCallback<List<T>>() {
				@Override public void success(List<T> data) {
					result.set(data);
					result.notify();
				}
				
				@Override public void error(Throwable e) {
					throw new RepositoryException(e);
				}
			});
			if (result.get() == null) {
				result.wait();
			}
			return result.get();
		} catch (InterruptedException e) {
			throw new RepositoryException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.soluvas.push.data.SyncRepository#create(java.lang.Object)
	 */
	@Override
	public T create(T entry) {
		try {
			final AtomicReference<T> result = new AtomicReference<T>();
			delegateRepository.add(entry, new FailingCallback<T>() {
				@Override public void success(T data) {
					result.set(data);
					result.notify();
				}
				
				@Override public void error(Throwable e) {
					throw new RepositoryException(e);
				}
			});
			if (result.get() == null) {
				result.wait();
			}
			return result.get();
		} catch (InterruptedException e) {
			throw new RepositoryException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.soluvas.push.data.SyncRepository#update(java.lang.Object, java.lang.Object)
	 */
	@Override
	public T update(ID id, T entry) {
		try {
			final AtomicReference<T> result = new AtomicReference<T>();
			delegateRepository.update(id, entry, new FailingCallback<T>() {
				@Override public void success(T data) {
					result.set(data);
					result.notify();
				}
				
				@Override public void error(Throwable e) {
					throw new RepositoryException(e);
				}
			});
			if (result.get() == null) {
				result.wait();
			}
			return result.get();
		} catch (InterruptedException e) {
			throw new RepositoryException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.soluvas.push.data.SyncRepository#delete(java.lang.Object)
	 */
	@Override
	public void delete(ID id) {
		try {
			final AtomicReference<T> result = new AtomicReference<T>();
			delegateRepository.delete(id, new FailingCallback<T>() {
				@Override public void success(T data) {
					result.set(data);
					result.notify();
				}
				
				@Override public void error(Throwable e) {
					throw new RepositoryException(e);
				}
			});
			if (result.get() == null) {
				result.wait();
			}
			log.debug("Delete {} result: ", result.get());
		} catch (InterruptedException e) {
			throw new RepositoryException(e);
		}
	}

}

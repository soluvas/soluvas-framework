package org.soluvas.data.push;

import java.io.Serializable;
import java.util.List;

import org.soluvas.async.FailingCallback;

/**
 * Throws {@link UnsupportedOperationException} for all methods.
 * @author ceefour
 */
public class CallbackRepositoryBase<T, ID extends Serializable> implements
		CallbackRepository<T, ID> {

	/* (non-Javadoc)
	 * @see org.soluvas.push.data.CallbackRepository#add(java.lang.Object, org.soluvas.async.FailingCallback)
	 */
	@Override
	public void add(T data, FailingCallback<T> callback) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.soluvas.push.data.CallbackRepository#delete(java.lang.Object, org.soluvas.async.FailingCallback)
	 */
	@Override
	public void delete(ID id, FailingCallback<T> callback) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.soluvas.push.data.CallbackRepository#findOne(java.lang.Object, org.soluvas.async.FailingCallback)
	 */
	@Override
	public void findOne(ID id, FailingCallback<T> callback) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.soluvas.push.data.CallbackRepository#findAll(org.soluvas.async.FailingCallback)
	 */
	@Override
	public void findAll(FailingCallback<List<T>> callback) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.soluvas.push.data.CallbackRepository#findAllIds(org.soluvas.async.FailingCallback)
	 */
	@Override
	public void findAllIds(FailingCallback<List<ID>> callback) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.soluvas.push.data.CallbackRepository#search(java.lang.String, org.soluvas.async.FailingCallback)
	 */
	@Override
	public void search(String searchText, FailingCallback<List<T>> callback) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.soluvas.push.data.CallbackRepository#update(java.lang.Object, java.lang.Object, org.soluvas.async.FailingCallback)
	 */
	@Override
	public void update(ID id, T data, FailingCallback<T> callback) {
		throw new UnsupportedOperationException();
	}

}

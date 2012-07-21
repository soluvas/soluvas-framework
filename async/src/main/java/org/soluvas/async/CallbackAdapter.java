package org.soluvas.async;

/**
 * For easy implementation of any callback.
 * @author ceefour
 */
public class CallbackAdapter<S, P, T> implements UpdatingCallback<S, P, T> {

	/* (non-Javadoc)
	 * @see org.soluvas.async.Callback#success(java.lang.Object)
	 */
	@Override
	public void success(T data) {
	}

	/* (non-Javadoc)
	 * @see org.soluvas.async.ErrorCallback#error(java.lang.Throwable)
	 */
	@Override
	public void error(Throwable e) {
	}

	/* (non-Javadoc)
	 * @see org.soluvas.async.ProgressCallback#progress(java.lang.Object)
	 */
	@Override
	public void progress(P data) {
	}

	@Override
	public void start(S data) {
	}

}

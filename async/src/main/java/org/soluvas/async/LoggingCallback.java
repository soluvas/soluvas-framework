package org.soluvas.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Callback that simply logs whatever is received.
 * Probably a better base class than {@link CallbackAdapter}.
 * @author ceefour
 */
public class LoggingCallback<S, P, T> implements UpdatingCallback<S, P, T> {

	private static final Logger log = LoggerFactory.getLogger(LoggingCallback.class);
	
	/* (non-Javadoc)
	 * @see org.soluvas.async.Callback#success(java.lang.Object)
	 */
	@Override
	public void success(T data) {
		log.info("Success {}", data);
	}

	/* (non-Javadoc)
	 * @see org.soluvas.async.ErrorCallback#error(java.lang.Throwable)
	 */
	@Override
	public void error(Throwable e) {
		log.warn("Error", e);
	}

	/* (non-Javadoc)
	 * @see org.soluvas.async.ProgressCallback#progress(java.lang.Object)
	 */
	@Override
	public void progress(P data) {
		log.info("Progress {}", data);
	}

	@Override
	public void start(S data) {
		log.info("Start {}", data);
	}

}

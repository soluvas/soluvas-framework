package org.soluvas.async;

/**
 * Supports both error and progress.
 * @author ceefour
 */
public interface UpdatingCallback<S, P, T> extends FailingCallback<T>,
		ProgressCallback<S, P> {

}

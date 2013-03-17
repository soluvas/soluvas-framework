package org.soluvas.async;

/**
 * Progress callback.
 * @author ceefour
 *
 * @param <S> Start data.
 * @param <P> Progress data.
 */
public interface ProgressCallback<S, P> {

	void start(S data);
	void progress(P data);
	
}

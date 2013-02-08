package org.soluvas.async;

/**
 * A simple success-only callbak.
 * @author ceefour
 *
 * @param <T>
 */
public interface Callback<T> {

	void success(T data);
	
}

package org.soluvas.async;

/**
 * Supports {@link ErrorCallback}.
 * @author ceefour
 */
public interface FailingCallback<T> extends Callback<T>, ErrorCallback {

}

package org.soluvas.async;

import java.util.concurrent.atomic.AtomicReference;

import javax.annotation.Nonnull;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Throwables;

/**
 * Utility methods to wrap a callback-based method into synchronous calls.
 * @author ceefour
 */
public class AsyncUtils {
	
	public static <V> V wrap(@Nonnull Function<FailingCallback<V>, Void> func) {
		// Uses Optional because the callback may return null, and we need to distinguish between "our" null and "their" null
		final AtomicReference<Optional<V>> success = new AtomicReference<>(Optional.<V>absent());
		final AtomicReference<Optional<Throwable>> error = new AtomicReference<>(Optional.<Throwable>absent());
		func.apply(new FailingCallback<V>() {
			@Override public void success(V data) {
				success.set(Optional.of(data));
				synchronized (success) {
					success.notify();
				}
			}

			@Override public void error(Throwable e) {
				error.set(Optional.of(e));
				synchronized (error) {
					error.notify();
				}
			}
		});
		final Object marker = new Object();
		if (!success.get().isPresent() && !error.get().isPresent()) {
			synchronized (marker) {
				try {
					marker.wait();
				} catch (InterruptedException e) {
					Throwables.propagate(e);
				}
			}
		}
		if (error.get().isPresent())
			Throwables.propagate(error.get().orNull());
		return success.get().orNull();
	}

}

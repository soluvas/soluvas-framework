package org.soluvas.commons.util;

import javax.annotation.Nullable;

import org.soluvas.commons.ProgressMonitor;
import org.soluvas.commons.impl.ProgressMonitorWrapperImpl;

import com.google.common.base.Optional;

/**
 * Provides a {@link ProgressMonitor} via {@link ThreadLocal}.
 * use try-with-resources syntax.
 * 
 * <pre>{@literal
 * try (ThreadLocalProgress progress = new ThreadLocalProgress(monitor)) {
 * 	perpInvMgr.replay();
 * } catch (Exception e) {
 * 	eventBus.post(e);
 * 	log.error("Error replaying quantities: " + e, e);
 * 	throw e;
 * }
 * }</pre>
 * 
 * @author adri
 */
public class ThreadLocalProgress implements AutoCloseable {

	private static final ThreadLocal<ProgressMonitor> threadLocal = new ThreadLocal<>();
	
	public ThreadLocalProgress(@Nullable ProgressMonitor monitor) {
		threadLocal.set(monitor);
	}
	
	/**
	 * Returns wrapped {@link ProgressMonitor} for the current ThreadLocal.
	 * Used by worker methods. This is guaranteed to always return a valid instance.
	 * @return
	 */
	public static ProgressMonitor get() {
		return Optional.fromNullable(threadLocal.get()).or(new ProgressMonitorWrapperImpl());
	}
	
	/**
	 * You should not call this directly. It is called by try-with-resources.
	 * @see java.lang.AutoCloseable#close()
	 */
	@Override
	public void close() throws Exception {
		threadLocal.remove();
	}
	
}

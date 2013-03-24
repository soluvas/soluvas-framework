package org.soluvas.commons;

import javax.annotation.PreDestroy;

import org.eclipse.emf.ecore.EObject;

import com.google.common.base.Supplier;

/**
 * A Supplier that delegates to one or more inner {@link Supplier}s.
 * 
 * @author ceefour
 *
 * @param <T>
 */
public interface DelegatingSupplier<T extends EObject> extends Supplier<T> {

	public abstract void addSupplier(Supplier<T> supplier);

	public abstract void removeSupplier(Supplier<T> supplier);
	
	@PreDestroy
	public abstract void destroy();

}
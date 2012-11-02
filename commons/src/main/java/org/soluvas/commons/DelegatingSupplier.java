package org.soluvas.commons;

import org.eclipse.emf.ecore.EObject;

import com.google.common.base.Supplier;

/**
 * A Supplier that delegates to one or more inner {@link Supplier}s.
 * 
 * @author ceefour
 *
 * @param <T>
 */
public interface DelegatingSupplier<T extends EObject> {

	public abstract void addSupplier(Supplier<T> supplier);

	public abstract void removeSupplier(Supplier<T> supplier);

}
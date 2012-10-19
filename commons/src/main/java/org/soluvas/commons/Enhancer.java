package org.soluvas.commons;

import com.google.common.base.Supplier;

/**
 * Enhances an object using Visitor pattern.
 * Usually used with {@link Supplier} and EnhancedSupplier.
 * @author ceefour
 */
public interface Enhancer<T> {

	public void enhance(T object);
	
}

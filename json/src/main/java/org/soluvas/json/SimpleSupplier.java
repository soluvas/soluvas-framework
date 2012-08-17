package org.soluvas.json;

import com.google.common.base.Supplier;

/**
 * Useful as a workaround to OSGi Blueprint proxy problems.
 * @author ceefour
 */
public class SimpleSupplier<T> implements Supplier<T> {
	
	private T object;

	public SimpleSupplier(T object) {
		super();
		this.object = object;
	}

	@Override
	public T get() {
		return object;
	}

}

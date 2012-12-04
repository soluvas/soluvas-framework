package org.soluvas.commons;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;

/**
 * Fetches from the input {@link Supplier} then
 * passes it to a list of {@link Enhancer}s, in turn, before
 * returning the value. 
 * @author ceefour
 */
public class EnhancedSupplier<T> implements Supplier<T> {
	
	private static final Logger log = LoggerFactory
			.getLogger(EnhancedSupplier.class);
	private Supplier<T> delegate;
	private List<Enhancer<T>> enhancers;
	
	public EnhancedSupplier(@Nonnull Supplier<T> delegate, @Nullable List<Enhancer<T>> enhancers) {
		super();
		this.delegate = delegate;
		this.enhancers = Optional.fromNullable(enhancers).or(ImmutableList.<Enhancer<T>>of());
		log.info("EnhancedSupplier<{}> created with inner: {} and {} enhancers: {}", getClass().getGenericSuperclass(),
				delegate, enhancers.size(), enhancers);
	}

	/* (non-Javadoc)
	 * @see com.google.common.base.Supplier#get()
	 */
	@Override
	public T get() {
		final T obj = delegate.get();
		for (Enhancer<T> enhancer : enhancers) {
			enhancer.enhance(obj);
		}
		return obj;
	}

}

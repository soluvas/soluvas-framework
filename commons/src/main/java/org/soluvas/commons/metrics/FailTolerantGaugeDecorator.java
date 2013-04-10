package org.soluvas.commons.metrics;

import org.slf4j.LoggerFactory;

import com.yammer.metrics.Gauge;

/**
 * Decorates a {@link Gauge} and simply logs WARN if
 * gauge throws exception.
 * @author adri
 */
public class FailTolerantGaugeDecorator<T> implements Gauge<T> {
	
	private final Gauge<T> inner;

	public FailTolerantGaugeDecorator(Gauge<T> inner) {
		super();
		this.inner = inner;
	}

	@Override
	public T getValue() {
		try {
			return inner.getValue();
		} catch (Exception e) {
			LoggerFactory.getLogger(inner.getClass()).warn(
					"Cannot get gauge " + inner.getClass().getName(), e);
			return null;
		}
	}

}

package org.soluvas.data;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;

/**
 * Based on Guava {@link Optional}.
 */
public final class Existence<T> implements Serializable {
	private static final long serialVersionUID = 0;
	private final boolean present;
	@Nullable
	private final T reference;
	@Nullable
	private final String id;

	Existence(boolean present, T reference) {
		this.present = present;
		this.reference = reference;
		this.id = null;
	}

	Existence(boolean present, T reference, String id) {
		this.present = present;
		this.reference = reference;
		this.id = id;
	}
	
	public static <T> Existence<T> absent() {
		return new Existence<>(false, null);
	}

	/**
	 * @param reference
	 * @param id Type of ID is assumed to be string.
	 * @return
	 */
	public static <T> Existence<T> of(T reference, String id) {
		return new Existence<>(true, reference, id);
	}

	public static <T> Existence<T> mismatch(T mismatchedReference, String id) {
		return new Existence<>(false, mismatchedReference, id);
	}

	public boolean isPresent() {
		return present;
	}

	public T get() {
		Preconditions.checkState(present, "Existence value not present");
		return reference;
	}
	
	/**
	 * Note: Type of ID is assumed to be string.
	 * @return
	 */
	public String getId() {
		Preconditions.checkState(present, "Existence value not present");
		return id;
	}

	public T or(T defaultValue) {
		Preconditions.checkNotNull(defaultValue,
				"use Existence.orNull() instead of Existence.or(null)");
		return reference;
	}

	public Existence<T> or(Existence<? extends T> secondChoice) {
		Preconditions.checkNotNull(secondChoice);
		return this;
	}

	public T or(Supplier<? extends T> supplier) {
		Preconditions.checkNotNull(supplier);
		return reference;
	}

	public T orNull() {
		return reference;
	}

	public Set<T> asSet() {
		return Collections.singleton(reference);
	}

	public <V> Existence<V> transform(Function<? super T, V> function) {
		return Existence.of(
				Preconditions.checkNotNull(function.apply(reference),
						"the Function passed to Optional.transform() must not return null."), id);
	}

	@Override
	public boolean equals(@Nullable Object object) {
		if (object instanceof Existence) {
			Existence<?> other = (Existence<?>) object;
			return reference.equals(other.reference);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 0x598df91c + (reference != null ? reference.hashCode() : 0) + (id != null ? id.hashCode() : 0);
	}

	@Override
	public String toString() {
		return "Existence.of(" + reference + ")";
	}

}

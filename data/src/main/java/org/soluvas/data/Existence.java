package org.soluvas.data;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import javax.annotation.Nullable;

import org.soluvas.commons.SlugUtils;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

/**
 * Based on Guava {@link Optional} (which will be deprecated when we switch to Java 8).
 * 
 * <p>Usage:
 * 
 * <pre>
 * @Override
 * protected UrlInfo parseRequest(Request request) {
 * 	if (request.getUrl().getSegments().size() == 1) {
 * 		final String segment1 = request.getUrl().getSegments().get(0);
 * 		if (SlugUtils.SLUG_PATTERN.matcher(segment1).matches()) {
 * 			final Existence&lt;String> existence = productRepo.existsBySlugEx(StatusMask.RAW, segment1);
 * 			switch (existence.getState()) {
 * 			case MATCHED:
 * 				return new UrlInfo(null, ProductShowPage.class, ProductShowPage.params(segment1));
 * 			case MISMATCHED:
 * 				// canonical URI
 * 				throw new RestartResponseException(ProductShowPage.class, ProductShowPage.params(existence.get()));
 * 			default:
 * 			}
 * 		}
 * 	}
 * 	return null;
 * }
 * </pre>
 * 
 * @todo Consider extending {@link java.util.Optional} on Java 8.
 */
public final class Existence<T> implements Serializable {
	
	private static final long serialVersionUID = 0;
	
	public enum State {
		ABSENT,
		MISMATCHED,
		MATCHED
	};
	
	private final State state;
	@Nullable
	private final T reference;
	@Nullable
	private final String id;

	/**
	 * @param present
	 * @param reference
	 * @deprecated ID is mandatory. Otherwise you can't {@link SlugUtils#generateValidSlug(String, com.google.common.base.Predicate)}
	 * for an <i>existing</i> entity.
	 */
	@Deprecated
	Existence(State state, T reference) {
		this.state = state;
		this.reference = reference;
		this.id = null;
	}

	Existence(State state, T reference, String id) {
		this.state = state;
		this.reference = reference;
		this.id = id;
	}
	
	public static <T> Existence<T> absent() {
		return new Existence<>(State.ABSENT, null);
	}

	/**
	 * @param reference
	 * @param id Type of ID is assumed to be string.
	 * @return
	 */
	public static <T> Existence<T> of(T reference, String id) {
		return new Existence<>(State.MATCHED, reference, id);
	}

	public static <T> Existence<T> mismatch(T mismatchedReference, String id) {
		return new Existence<>(State.MISMATCHED, mismatchedReference, id);
	}

	/**
	 * Either {@link State#MATCHED} or {@link State#MISMATCHED}.
	 * @return
	 */
	public boolean isPresent() {
		return state == State.MATCHED || state == State.MISMATCHED;
	}
	
	public State getState() {
		return state;
	}

	public T get() {
		Preconditions.checkState(state != State.ABSENT, "Existence value not present");
		return reference;
	}
	
	/**
	 * Note: Type of ID is assumed to be string.
	 * @return
	 */
	public String getId() {
		Preconditions.checkState(state != State.ABSENT, "Existence value not present");
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

//	public T or(Supplier<? extends T> supplier) {
//		throw new UnsupportedOperationException();
//	}

	@Nullable
	public T orNull() {
		return state != State.ABSENT ? reference : null;
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
		return "Existence." + state.name().toLowerCase() + "(" + reference + " ID=" + id + ")";
	}

}

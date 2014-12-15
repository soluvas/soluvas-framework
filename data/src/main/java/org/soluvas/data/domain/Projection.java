package org.soluvas.data.domain;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

/**
 * Selects a set of fields (both top-level and nested fields) from a database document.
 * @author ceefour
 */
public class Projection {
	
	private final boolean idIncluded;
	private final Set<String> includedFields;
	private final Set<String> excludedFields;
	
	public Projection(boolean idIncluded, Set<String> includedFields,
			Set<String> excludedFields) {
		super();
		this.idIncluded = idIncluded;
		this.includedFields = includedFields;
		this.excludedFields = excludedFields;
	}

	/**
	 * Selects the ID field plus the specified fields, and nothing else.
	 * @author ceefour
	 */
	public static Projection of(String... includedFields) {
		return new Projection(true, ImmutableSet.copyOf(includedFields), ImmutableSet.<String>of());
	}
	
	/**
	 * Selects only the specified fields, excluding the ID field, and nothing else.
	 * @author ceefour
	 */
	public static Projection only(String... includedFields) {
		return new Projection(false, ImmutableSet.copyOf(includedFields), ImmutableSet.<String>of());
	}
	
	/**
	 * Excludes only the specified fields, everything else is included.
	 * @author ceefour
	 */
	public static Projection exclude(String... excludedFields) {
		return new Projection(true, ImmutableSet.<String>of(), ImmutableSet.copyOf(excludedFields));
	}

	/**
	 * @return the idIncluded
	 */
	public boolean isIdIncluded() {
		return idIncluded;
	}

	/**
	 * @return the includedFields
	 */
	public Set<String> getIncludedFields() {
		return includedFields;
	}

	/**
	 * @return the excludedFields
	 */
	public Set<String> getExcludedFields() {
		return excludedFields;
	}

	@Override
	public String toString() {
		return "Projection{" +
				"idIncluded=" + idIncluded +
				", includedFields=" + includedFields +
				", excludedFields=" + excludedFields +
				'}';
	}
}

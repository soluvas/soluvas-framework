package org.soluvas.data;

import javax.annotation.Nullable;

import org.soluvas.commons.Person;

public interface SlugLookup<T> {
	
	/**
	 * Find an entity by user-provided slug, which should be canonicalized
	 * for matching purposes.
	 * e.g. finding a {@link Person} by slug "{@code arum.pus.pita.07}" should return the
	 * Person with actual slug "{@code arum.puspita}". 
	 * @param statusMask TODO
	 * @param upSlug
	 * @return the entity, or {@code null} if not found.
	 */
	@Nullable
	public T findOneBySlug(StatusMask statusMask, String upSlug);

	/**
	 * Checks existence of entity by user-provided slug, which should be canonicalized
	 * for matching purposes.
	 * e.g. checking a {@link Person} by slug "{@code arum.pus.pita.07}" should return {@code true}
	 * if its actual slug was "{@code arum.puspita}".
	 * @param statusMask TODO
	 * @param upSlug
	 * @return The actual slug in the repository, or {@code null} if does not exist.
	 */
	@Nullable
	public String existsBySlug(StatusMask statusMask, String upSlug);

}

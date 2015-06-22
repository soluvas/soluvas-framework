package org.soluvas.data;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.soluvas.commons.Person;
import org.soluvas.data.person.PersonRepository;

import com.google.common.base.Optional;

/**
 * @author ceefour
 *
 * @param <T>
 * @todo change to {@code SlugPathLookup}, see {@link org.soluvas.category.CategoryRepository} for reason
 */
public interface SlugLookup<T> {
	
	/**
	 * Find an entity by user-provided slug, which should be canonicalized
	 * for matching purposes.
	 * e.g. finding a {@link Person} by slug "{@code arum.pus.pita.07}" should return the
	 * Person with actual slug "{@code arum.puspita}". 
	 * @param statusMask TODO
	 * @param upSlug
	 * @return the entity, or {@code null} if not found.
	 * @todo Should throw {@link EntityLookupException} (see for rationale vs {@link Optional}).
	 * @todo Support {@code upSlugPath} instead, see {@link org.soluvas.category.CategoryRepository} for reason
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
	 * 		Actual slug is useful for e.g. canonical URIs. So if someone came using {@code http://www.aksimata.com/hendyirawan}
	 * 		the {@link org.apache.wicket.request.IRequestMapper} can <i>immediately</i> redirect to {@code http://www.aksimata.com/hendy.irawan}
	 * 		without processing the page nor getting the {@link Person} entity from {@link PersonRepository}.
	 * @todo Support {@code upSlugPath} instead, see {@link org.soluvas.category.CategoryRepository} for reason
	 */
	@Nonnull
	public Existence<String> existsBySlug(StatusMask statusMask, String upSlug);

}

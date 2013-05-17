package org.soluvas.data.person;

import javax.annotation.Nullable;

import org.soluvas.commons.Email;
import org.soluvas.commons.Person;
import org.soluvas.data.SlugLookup;
import org.soluvas.data.repository.PagingAndSortingRepository;

/**
 * {@link Person} repository that supports paging and sorting.
 * @author ceefour
 */
public interface PersonRepository extends
		PagingAndSortingRepository<Person, String>, SlugLookup<Person> {

	/**
	 * Find a {@link Person} by Facebook ID or Username (at least one must be specified).
	 * @param facebookId
	 * @param facebookUsername
	 * @return Person, or {@code null} if not found or if both facebookId and facebookUsername
	 * 		were {@code null}.
	 */
	@Nullable
	public Person findOneByFacebook(@Nullable Long facebookId, @Nullable String facebookUsername);

	/**
	 * Find a {@link Person} by any {@link Email}. All email status are included,
	 * regardless of validation status.
	 * <p>Note to implementor: input email must be normalized (lowercased + trimmed)
	 * before querying database.
	 */
	@Nullable
	public Person findOneByEmail(@Nullable String email);

	/**
	 * Find a {@link Person} by Twitter ID or screen name (at least one must be specified).
	 * @param twitterId
	 * @param twitterUsername
	 * @return Person, or {@code null} if not found or if both twitterId and twitterScreenName
	 * 		were {@code null}.
	 */
	@Nullable
	public Person findOneByTwitter(@Nullable Long twitterId, @Nullable String twitterScreenName);

}

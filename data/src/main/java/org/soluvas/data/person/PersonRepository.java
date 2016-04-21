package org.soluvas.data.person;

import java.util.Collection;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.soluvas.commons.AccountStatus;
import org.soluvas.commons.CustomerRole;
import org.soluvas.commons.Email;
import org.soluvas.commons.Person;
import org.soluvas.data.Existence;
import org.soluvas.data.GenericLookup;
import org.soluvas.data.SlugLookup;
import org.soluvas.data.StatusMask;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Projection;
import org.soluvas.data.repository.PagingAndSortingRepository;
import org.soluvas.data.repository.Trashable;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;

/**
 * {@link Person} repository that supports paging and sorting.
 * @author ceefour
 */
public interface PersonRepository extends
		PagingAndSortingRepository<Person, String>, SlugLookup<Person>,
		GenericLookup<Person>,
		Trashable<Person, String> {
	
	/**
	 * 
	 * @param statusMask
	 * @param upSlug
	 * @return
	 * @see #existsBySlug(StatusMask, String)
	 */
	@Nonnull
	public Existence<String> existsBySlugCacheable(StatusMask statusMask, String upSlug);
	
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
	 * @param statusMask TODO
	 */
	@Nullable
	public Person findOneByEmail(StatusMask statusMask, @Nullable String email);
	
	public boolean isExistsByEmail(StatusMask statusMask, String email);
	
	Optional<String> getIdByEmail(StatusMask statusMask, String email);
	
	@Nullable
	public Person findOneById(StatusMask statusMask, @Nullable String id);
	
	@Nullable
	public Person findOneByMobileOrPhoneNumber(StatusMask statusMask, @Nullable String mobileOrPhoneNumber);
	
	public boolean isExistsByMobileOrPhoneNumber(StatusMask statusMask, String mobileOrPhoneNumber);
	
	Optional<String> getIdByMobileOrPhoneNumber(StatusMask statusMask, String mobileOrPhoneNumber);

	/**
	 * Find a {@link Person} by Twitter ID or screen name (at least one must be specified).
	 * @param twitterId
	 * @param twitterUsername
	 * @return Person, or {@code null} if not found or if both twitterId and twitterScreenName
	 * 		were {@code null}.
	 */
	@Nullable
	public Person findOneByTwitter(@Nullable Long twitterId, @Nullable String twitterScreenName);

	/**
	 * Find a {@link Person} by Client Access Token, useful for implementing REST API provider.
	 * @param clientAccessToken
	 * @return Person, or {@code null} if not found.
	 */
	@Nullable
	public Person findOneByClientAccessToken(@Nullable String clientAccessToken);
	
	public Page<Person> findBySearchText(StatusMask statusMask, String searchText, Pageable pageable);
	
	public Page<Person> findAllByKeywordAndStatus(String searchText, Collection<AccountStatus> accountStatuses, Pageable pageable);
	
	public long countBySearchText(StatusMask statusMask, String searchText);
	
	public long countBySearchText(Collection<AccountStatus> accountStatuses, String searchText);

	public Person findOneActive(String personId);
	
	Page<Person> findAll(StatusMask statusMask, Pageable pageable);
	
	Page<Person> findAll(Collection<AccountStatus> accountStatuses, Pageable pageable);
	
	List<Person> findAll(StatusMask statusMask, Collection<String> ids);
	
	List<Person> findAllBySecRoleIds(StatusMask statusMask, Collection<String> secRoleIds);
	
	List<Person> findAllByCustomerRoleIds(StatusMask statusMask, Collection<String> customerRoleIds);
	
	boolean existByCustomerRoleIds(StatusMask statusMask, Collection<String> customerRoleIds);
	
	boolean hasMatchWithSecRoleIds(String personId, Collection<String> secRoleIds);

	Page<Person> findAll(StatusMask statusMask, Projection projection, Pageable pageable);

	long count(StatusMask statusMask);
	
	long countByStatuses(Collection<AccountStatus> accountStatuses);
	
	void setNullCustomerRole(Collection<String> customerRoleIds);
	
	@Nullable
	String getCustomerRoleByPersonId(String personId);

	public ImmutableSet<String> findAllSlugsByStatus(StatusMask statusMask);

	ImmutableSet<String> findAllSlugsByStatus(StatusMask statusMask, Pageable pageable);

	long countAllByKeywordAndRoles(String keyword,
			Collection<AccountStatus> accountStatuses,
			CustomerRole customerRole, Collection<String> custoemrRoleIds);

	Page<Person> findAllByKeywordAndRoles(String keyword,
			Collection<AccountStatus> accountStatuses,
			CustomerRole customerRole, Collection<String> securityRoles,
			Pageable pageable);

	Page<Person> findAllByCustomerRoleIds(StatusMask statusMask,
			Collection<String> customerRoleIds, Pageable pageable);

	long countAllByCustomerRolesIds(StatusMask statusMask,
			Collection<String> customerRoleIds);

	Page<Person> findAll(StatusMask statusMask, Collection<String> ids,
			Pageable pageable);

	/**
	 * @param statusMask
	 * @param slug
	 * @return
	 * @see SlugLookup#existsBySlug(StatusMask, String)
	 */
//	public Existence<String> existsBySlugEx(StatusMask statusMask, String slug);
	
	Page<Person> findAllNotZendeskUserId(Pageable pageable);

}


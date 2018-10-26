package org.soluvas.data.person;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.joda.time.DateTime;
import org.soluvas.commons.AccountStatus;
import org.soluvas.commons.Email;
import org.soluvas.commons.Person;
import org.soluvas.commons.PersonInfo2;
import org.soluvas.commons.PostalAddress2;
import org.soluvas.commons.entity.Person2;
import org.soluvas.commons.impl.CustomerRole2;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

/**
 * {@link Person} repository that supports paging and sorting.
 * @author ceefour
 */
public interface PersonRepository extends
		PagingAndSortingRepository<Person2, String>, SlugLookup<Person2>,
		GenericLookup<Person2>,
		Trashable<Person2, String> {
	
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
	public Person2 findOneByFacebook(@Nullable Long facebookId, @Nullable String facebookUsername);

	/**
	 * Find a {@link Person} by any {@link Email}. All email status are included,
	 * regardless of validation status.
	 * <p>Note to implementor: input email must be normalized (lowercased + trimmed)
	 * before querying database.
	 * @param statusMask TODO
	 */
	@Nullable
	public Person2 findOneByEmail(StatusMask statusMask, @Nullable String email);
	
	public boolean isExistsByEmail(StatusMask statusMask, String email);
	
	Optional<String> getIdByEmail(StatusMask statusMask, String email);
	
	@Nullable
	public Person2 findOneById(StatusMask statusMask, @Nullable String id);
	
	@Nullable
	public Person2 findOneByMobileOrPhoneNumber(StatusMask statusMask, @Nullable String mobileOrPhoneNumber);
	
	public boolean isMobilePhoneNumberAlreadyRegistered(StatusMask statusMask, String mobileOrPhoneNumber);
	
	Optional<String> getIdByMobileOrPhoneNumber(StatusMask statusMask, String mobileOrPhoneNumber);

	/**
	 * Find a {@link Person} by Twitter ID or screen name (at least one must be specified).
	 * @param twitterId
	 * @param twitterUsername
	 * @return Person, or {@code null} if not found or if both twitterId and twitterScreenName
	 * 		were {@code null}.
	 */
	@Nullable
	public Person2 findOneByTwitter(@Nullable Long twitterId, @Nullable String twitterScreenName);

	/**
	 * Find a {@link Person} by Client Access Token, useful for implementing REST API provider.
	 * @param clientAccessToken
	 * @return Person, or {@code null} if not found.
	 */
	@Nullable
	public Person2 findOneByClientAccessToken(@Nullable String clientAccessToken);
	
	public Page<Person2> findBySearchText(StatusMask statusMask, String searchText, Pageable pageable);
	
	public Page<Person2> findAllByKeywordAndStatus(String searchText, Collection<AccountStatus> accountStatuses, Pageable pageable);
	
	public long countBySearchText(StatusMask statusMask, String searchText);
	
	public long countBySearchText(Collection<AccountStatus> accountStatuses, String searchText);

	public Person2 findOneActive(String personId);
	
	Page<Person2> findAll(StatusMask statusMask, Pageable pageable);
	
	Page<Person2> findAll(Collection<AccountStatus> accountStatuses, Pageable pageable);
	
	List<Person2> findAll(StatusMask statusMask, Collection<String> ids);
	
	List<Person2> findAllBySecRoleIds(StatusMask statusMask, Collection<String> secRoleIds);
	
	List<Person2> findAllByCustomerRoleIds(StatusMask statusMask, Collection<String> customerRoleIds);

	boolean existByCustomerRoleIds(StatusMask statusMask, Collection<String> customerRoleIds);
	
	boolean hasMatchWithSecRoleIds(String personId, Collection<String> secRoleIds);

	Page<Person2> findAll(StatusMask statusMask, Projection projection, Pageable pageable);

	long count(StatusMask statusMask);
	
	long countByStatuses(Collection<AccountStatus> accountStatuses);

	/**
	 * Count all people having {@link Person#getFacebookId()}.
	 */
	long countByFacebook();

	void setNullCustomerRole(Collection<String> customerRoleIds);
	
	@Nullable
	String getCustomerRoleByPersonId(String personId);

	public ImmutableSet<String> findAllSlugsByStatus(StatusMask statusMask);

	ImmutableSet<String> findAllSlugsByStatus(StatusMask statusMask, Pageable pageable);

	long countAllByKeywordAndRoles(String keyword,
			Collection<AccountStatus> accountStatuses,
			CustomerRole2 customerRole, Collection<String> securityRoleIds);

	Page<Person2> findAllByKeywordAndRoles(String keyword,
			Collection<AccountStatus> accountStatuses,
			CustomerRole2 customerRole, Collection<String> securityRoleIds,
			Pageable pageable);

	Page<Person2> findAllByCustomerRoleIds(StatusMask statusMask,
			Collection<String> customerRoleIds, Pageable pageable);

	long countAllByCustomerRolesIds(StatusMask statusMask,
			Collection<String> customerRoleIds);

	Page<Person2> findAll(StatusMask statusMask, Collection<String> ids,
			Pageable pageable);

	/**
	 * @param statusMask
	 * @param slug
	 * @return
	 * @see SlugLookup#existsBySlug(StatusMask, String)
	 */
//	public Existence<String> existsBySlugEx(StatusMask statusMask, String slug);
	
	/**
	 * The Person is only 2 attributes: id + zendeskUserId!!
	 * 
	 * @param email
	 * @return
	 */
	@Nullable Person2 getZendeskUserId(String email);
	
	@Nullable Long getZendeskUserIdByPersonId(String personId);
	
	Page<Person2> findAllByEmailExists(StatusMask statusMask, Pageable pageable);
	
	Page<Person2> findAllByEmailExists(DateTime starTime, DateTime endTime, StatusMask statusMask, Pageable pageable);
	
	List<String> findAllIdsByCustomerRoleId(StatusMask statusMask, String customerRoleId);

	public Optional<String> getCustomerRole(String personId);
	
	boolean existsByEmailAndStatus(String email, AccountStatus status);

	boolean existsByEmail(String email);

	ImmutableList<AccountStatus> getStatusesByEmail(String email);

	Person2 findOneByEmail(AccountStatus status, String email);

	double getPerformanceValue(String id);
	
	boolean updatePerformanceValues(final Map<String, Double> upPerformanceMap);

	Page<Person2> findAllWhereCustomerRoleValidThruNotNull(StatusMask statusMask, Pageable pageable);

	public void removeFcmToken(String userId, String oldFirebaseCloudMessagingToken);

	boolean addPrimaryEmail(String id, String primaryEmail);

	boolean addPrimaryMobileNumber(String id, String mobileNumber);
	
	@Nullable PersonInfo2 findOneAsInfo(String id);
	
	ImmutableList<PostalAddress2> getAddresses(String id);

	public void setJneAreaCode(String id, UUID addressId, String areaCode);
	
	public void addAddress(String id, PostalAddress2 address);
	
	@Nullable PostalAddress2 getBillingAddress(String id);

	public void modifyAddress(String personId, PostalAddress2 postalAddress);
	
	ImmutableSet<String> getFcmTokens(String id);

	@Nullable PostalAddress2 getShippingAddress(String id);

	public ImmutableMap<String, String> findCustomerRoleIdMap(Collection<String> personIds);
	
	void setAddressToResellerStartUp(String personId, UUID addressId, String startUpId, Date regDate);
	
}


package org.soluvas.data.person;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Nullable;

import org.apache.commons.beanutils.BeanUtils;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AccountStatus;
import org.soluvas.commons.IdPredicate;
import org.soluvas.commons.PersonCatalog;
import org.soluvas.commons.PersonInfo2;
import org.soluvas.commons.PostalAddress2;
import org.soluvas.commons.entity.Performance;
import org.soluvas.commons.entity.Person2;
import org.soluvas.commons.impl.CustomerRole2;
import org.soluvas.data.EntityLookupException;
import org.soluvas.data.Existence;
import org.soluvas.data.LookupKey;
import org.soluvas.data.StatusMask;
import org.soluvas.data.TrashResult;
import org.soluvas.data.UntrashResult;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Projection;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.domain.Sort.Order;
import org.soluvas.data.repository.PagingAndSortingRepositoryBase;
import org.springframework.cache.annotation.Cacheable;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;

import scala.util.Try;

/**
 * {@link Person} Repository used for demo purposes.
 * @author ceefour
 */
public class EmfPersonRepository extends
		PagingAndSortingRepositoryBase<Person2, String> implements
		PersonRepository {
	
	private static final Logger log = LoggerFactory
			.getLogger(EmfPersonRepository.class);
	private final PersonCatalog catalog;
	
	public EmfPersonRepository(PersonCatalog catalog) {
		super();
		this.catalog = catalog;
	}

	@Override
	public long count() {
		return catalog.getPeople().size();
	}

	@Override @Nullable
	protected String getId(Person2 entity) {
		return entity.getId();
	}

	@Override
	public <S extends Person2> Collection<S> add(Collection<S> entities) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <S extends Person2> Collection<S> modify(Map<String, S> entities) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<String> exists(Collection<String> ids) {
		final Iterable<Person2> filtered = Iterables.filter(catalog.getPeople(), new IdPredicate(ids));
		final Iterable<String> transformed = Iterables.transform(filtered, new org.soluvas.commons.IdFunction());
		final Set<String> transformedSet = ImmutableSet.copyOf(transformed);
		return transformedSet;
	}

	@Override
	public List<Person2> findAll(Collection<String> ids, Sort sort) {
		// TODO: support sort
		final Iterable<Person2> filtered = Iterables.filter(catalog.getPeople(), new IdPredicate(ids));
		final List<Person2> copied = ImmutableList.copyOf(EcoreUtil.copyAll(ImmutableList.copyOf(filtered)));
		return copied;
	}

	@Override
	public long deleteIds(Collection<String> ids) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Page<String> findAllIds(Pageable pageable) {
		final int total = catalog.getPeople().size();
		// sort
		final Order firstOrder = Iterables.getFirst(pageable.getSort(), null);
		final List<Person2> sorted;
		if (firstOrder != null) {
			final Ordering<Person2> ordering = new Ordering<Person2>() {
				@Override
				public int compare(@Nullable Person2 left, @Nullable Person2 right) {
					try {
						final String leftProp = BeanUtils.getSimpleProperty(left, firstOrder.getProperty());
						final String rightProp = BeanUtils.getSimpleProperty(left, firstOrder.getProperty());
						return Strings.nullToEmpty(leftProp).compareToIgnoreCase(Strings.nullToEmpty(rightProp));
					} catch (IllegalAccessException | InvocationTargetException
							| NoSuchMethodException e) {
						log.error("Cannot get property " + firstOrder, e);
						return 0;
					}
				}
			};
			sorted = ordering.immutableSortedCopy(catalog.getPeople());
		} else {
			sorted = catalog.getPeople();
		}
		// page
		final Iterable<Person2> skipped = Iterables.skip(sorted, (int) pageable.getOffset());
		final Iterable<Person2> limited = Iterables.limit(sorted, (int) pageable.getPageSize());
		// return
		final Iterable<String> transformed = Iterables.transform(limited, new org.soluvas.commons.IdFunction());
		final List<String> transformedList = ImmutableList.copyOf(transformed);
		return new PageImpl<>(transformedList, pageable, total);
	}

	@Override
	public Page<Person2> findAll(Pageable pageable) {
		final int total = catalog.getPeople().size();
		// sort
		final Order firstOrder = Iterables.getFirst(pageable.getSort(), null);
		final List<Person2> sorted;
		if (firstOrder != null) {
			final Ordering<Person2> ordering = new Ordering<Person2>() {
				@Override
				public int compare(@Nullable Person2 left, @Nullable Person2 right) {
					try {
						final String leftProp = BeanUtils.getSimpleProperty(left, firstOrder.getProperty());
						final String rightProp = BeanUtils.getSimpleProperty(left, firstOrder.getProperty());
						return Strings.nullToEmpty(leftProp).compareToIgnoreCase(Strings.nullToEmpty(rightProp));
					} catch (IllegalAccessException | InvocationTargetException
							| NoSuchMethodException e) {
						log.error("Cannot get property " + firstOrder, e);
						return 0;
					}
				}
			};
			sorted = ordering.immutableSortedCopy(catalog.getPeople());
		} else {
			sorted = catalog.getPeople();
		}
		// page
		final Iterable<Person2> skipped = Iterables.skip(sorted, (int) pageable.getOffset());
		final Iterable<Person2> limited = Iterables.limit(sorted, (int) pageable.getPageSize());
		// return
		final List<Person2> copied = ImmutableList.copyOf(EcoreUtil.copyAll(ImmutableList.copyOf(limited)));
		return new PageImpl<>(copied, pageable, total);
	}

	@Override
	public Person2 findOneBySlug(StatusMask statusMask, final String slug) {
		final Optional<Person2> found = Iterables.tryFind(catalog.getPeople(), new Predicate<Person2>() {
			@Override
			public boolean apply(@Nullable Person2 input) {
				return slug != null ? slug.equals(input.getSlug()) : false;
			}
		});
		if (found.isPresent()) {
			return found.get();
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		return "EmfPersonRepository ["
				+ (catalog != null ? "articles.size=" + catalog.getPeople().size() : "") + "]";
	}

	@Override
	public Existence<String> existsBySlug(StatusMask statusMask, final String slug) {
		final Optional<Person2> found = Iterables.tryFind(catalog.getPeople(), new Predicate<Person2>() {
			@Override
			public boolean apply(@Nullable Person2 input) {
				return slug != null && slug.equals(input.getSlug());
			}
		});
		return found.isPresent() ? Existence.of(found.get().getSlug(), found.get().getId()) : Existence.<String>absent();
	}
	
	@Cacheable
	@Override
	public Existence<String> existsBySlugCacheable(StatusMask statusMask,
			String upSlug) {
		return existsBySlug(statusMask, upSlug);
	}

	@Override @Nullable
	public Person2 findOneByFacebook(@Nullable Long facebookId,
			@Nullable String facebookUsername) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override @Nullable
	public Person2 findOneByEmail(StatusMask statusMask, @Nullable String email) {
		throw new UnsupportedOperationException("to be implemented");
	}
	
	@Override @Nullable
	public Person2 findOneById(StatusMask statusMask, @Nullable String id) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override @Nullable
	public Person2 findOneByTwitter(@Nullable Long twitterId,
			@Nullable String twitterScreenName) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	@Nullable
	public Person2 findOneByClientAccessToken(@Nullable String clientAccessToken) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public Page<Person2> findBySearchText(
			StatusMask statusMask, @Nullable String idNameEmailMobile, Pageable pageable) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public long countBySearchText(StatusMask statusMask, String searchText) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	@Nullable
	public Person2 findOneByMobileOrPhoneNumber(StatusMask statusMask, @Nullable String mobileNumber) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public Person2 findOneActive(String personId) {
		// FIXME: implement status=ACTIVE|VALIDATED|VERIFIED filter
		return findOne(personId);
	}

	@Override
	public <S extends Person2, K extends Serializable> S lookupOne(
			StatusMask statusMask, LookupKey lookupKey, K key)
			throws EntityLookupException {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public <S extends Person2, K extends Serializable> Map<K, Try<S>> lookupAll(
			StatusMask statusMask, LookupKey lookupKey, Collection<K> keys) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public <K extends Serializable> Map<K, Existence<K>> checkExistsAll(
			StatusMask statusMask, LookupKey lookupKey, Collection<K> keys) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public <K extends Serializable> Existence<K> checkExists(StatusMask statusMask,
			LookupKey lookupKey, K key) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public TrashResult trash(Person2 entity) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public TrashResult trashById(String id) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public Map<String, Try<TrashResult>> trashAll(Collection<Person2> entities) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public Map<String, Try<TrashResult>> trashAllByIds(Collection<String> ids) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public UntrashResult untrash(Person2 entity) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public UntrashResult untrashById(String id) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public Map<String, Try<UntrashResult>> untrashAll(
			Collection<Person2> entities) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public Map<String, Try<UntrashResult>> untrashAllByIds(
			Collection<String> ids) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public Page<Person2> findAll(StatusMask statusMask, Pageable pageable) {
		throw new UnsupportedOperationException();
	}

	@Override
	public long count(StatusMask statusMask) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Person2> findAll(StatusMask statusMask, Collection<String> ids) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Person2> findAllBySecRoleIds(StatusMask statusMask,
			Collection<String> secRoleIds) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasMatchWithSecRoleIds(String personId, Collection<String> secRoleIds) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Page<Person2> findAll(StatusMask statusMask, Projection projection, Pageable pageable) {
		return null;
	}

	@Override
	public List<Person2> findAllByCustomerRoleIds(StatusMask statusMask,
			Collection<String> customerRoleIds) {
		throw new UnsupportedOperationException();
	}

	@Override
	public long countByFacebook() {
		return 0;
	}


	@Override
	public Page<Person2> findAll(Collection<AccountStatus> accountStatuses,
			Pageable pageable) {
		throw new UnsupportedOperationException();
	}

	@Override
	public long countBySearchText(Collection<AccountStatus> accountStatus,
			String searchText) {
		throw new UnsupportedOperationException();
	}

	@Override
	public long countByStatuses(Collection<AccountStatus> accountStatuses) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean existByCustomerRoleIds(StatusMask statusMask,
			Collection<String> customerRoleIds) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setNullCustomerRole(Collection<String> customerRoleIds) {
		throw new UnsupportedOperationException();		
	}

	@Override
	public String getCustomerRoleByPersonId(String personId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ImmutableSet<String> findAllSlugsByStatus(StatusMask statusMask) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ImmutableSet<String> findAllSlugsByStatus(StatusMask statusMask, Pageable pageable) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Page<Person2> findAllByKeywordAndStatus(String searchText,
			Collection<AccountStatus> accountStatuses, Pageable pageable) {
		throw new UnsupportedOperationException();
	}

	@Override
	public long countAllByKeywordAndRoles(String keyword,
			Collection<AccountStatus> accountStatuses,
			CustomerRole2 customerRole, Collection<String> securityRoleIds) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Page<Person2> findAllByKeywordAndRoles(String keyword,
			Collection<AccountStatus> accountStatuses,
			CustomerRole2 customerRole, Collection<String> securityRoleIds,
			Pageable pageable) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Page<Person2> findAllByCustomerRoleIds(StatusMask statusMask,
			Collection<String> customerRoleIds, Pageable pageable) {
		throw new UnsupportedOperationException();
	}
	

	@Override
	public long countAllByCustomerRolesIds(StatusMask statusMask,
			Collection<String> customerRoleIds) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isMobilePhoneNumberAlreadyRegistered(StatusMask statusMask,
			String mobileNumber) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Optional<String> getIdByMobileOrPhoneNumber(
			StatusMask statusMask, String mobileOrPhoneNumber) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isExistsByEmail(StatusMask statusMask, String email) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Optional<String> getIdByEmail(StatusMask statusMask,
			String email) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Page<Person2> findAll(StatusMask statusMask, Collection<String> ids,
			Pageable pageable) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Person2 getZendeskUserId(String email) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Long getZendeskUserIdByPersonId(String personId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Page<Person2> findAllByEmailExists(StatusMask statusMask, Pageable pageable) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Page<Person2> findAllByEmailExists(DateTime starTime, DateTime endTime, StatusMask statusMask,
			Pageable pageable) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<String> findAllIdsByCustomerRoleId(StatusMask statusMask, String customerRoleId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Optional<String> getCustomerRole(String personId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean existsByEmailAndStatus(String email, AccountStatus status) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean existsByEmail(String email) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ImmutableList<AccountStatus> getStatusesByEmail(String email) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Person2 findOneByEmail(AccountStatus status, String email) {
		throw new UnsupportedOperationException();
	}

	@Override
	public double getPerformanceValue(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updatePerformanceValues(Map<String, Double> upPerformanceMap) {
		return false;
	}

	@Override
	public void removeFcmToken(String userId, String oldFirebaseCloudMessagingToken) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<Person2> findAllWhereCustomerRoleValidThruNotNull(StatusMask statusMask, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addPrimaryEmail(String id, String primaryEmail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPrimaryMobileNumber(String id, String mobileNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PersonInfo2 findOneAsInfo(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImmutableList<PostalAddress2> getAddresses(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setJneAreaCode(String id, UUID addressId, String areaCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAddress(String id, PostalAddress2 address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PostalAddress2 getBillingAddress(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyAddress(String personId, PostalAddress2 postalAddress) {
		// TODO Auto-generated method stub
	}
		
	@Override
	public ImmutableSet<String> getFcmTokens(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostalAddress2 getShippingAddress(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void setAddressToResellerStartUp() {

	}

	@Override
	public void setAddressToResellerStartUp(String personId, UUID addressId, String startUpId, Date regDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ImmutableMap<String, String> findCustomerRoleIdMap(Collection<String> personIds) {
		// TODO Auto-generated method stub
				return null;
	}
	
	@Override
	public Map<String, Double> getPerformanceValue(Collection<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Performance> getPerformance(Collection<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Performance getPerformance(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}

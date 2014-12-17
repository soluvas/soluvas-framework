package org.soluvas.data.person;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import org.apache.commons.beanutils.BeanUtils;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AccountStatus;
import org.soluvas.commons.CustomerRole;
import org.soluvas.commons.IdPredicate;
import org.soluvas.commons.Person;
import org.soluvas.commons.PersonCatalog;
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

import scala.util.Try;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;

/**
 * {@link Person} Repository used for demo purposes.
 * @author ceefour
 */
public class EmfPersonRepository extends
		PagingAndSortingRepositoryBase<Person, String> implements
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
	protected String getId(Person entity) {
		return entity.getId();
	}

	@Override
	public <S extends Person> Collection<S> add(Collection<S> entities) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <S extends Person> Collection<S> modify(Map<String, S> entities) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<String> exists(Collection<String> ids) {
		final Iterable<Person> filtered = Iterables.filter(catalog.getPeople(), new IdPredicate(ids));
		final Iterable<String> transformed = Iterables.transform(filtered, new org.soluvas.commons.IdFunction());
		final Set<String> transformedSet = ImmutableSet.copyOf(transformed);
		return transformedSet;
	}

	@Override
	public List<Person> findAll(Collection<String> ids, Sort sort) {
		// TODO: support sort
		final Iterable<Person> filtered = Iterables.filter(catalog.getPeople(), new IdPredicate(ids));
		final List<Person> copied = ImmutableList.copyOf(EcoreUtil.copyAll(ImmutableList.copyOf(filtered)));
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
		final List<Person> sorted;
		if (firstOrder != null) {
			final Ordering<Person> ordering = new Ordering<Person>() {
				@Override
				public int compare(@Nullable Person left, @Nullable Person right) {
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
		final Iterable<Person> skipped = Iterables.skip(sorted, (int) pageable.getOffset());
		final Iterable<Person> limited = Iterables.limit(sorted, (int) pageable.getPageSize());
		// return
		final Iterable<String> transformed = Iterables.transform(limited, new org.soluvas.commons.IdFunction());
		final List<String> transformedList = ImmutableList.copyOf(transformed);
		return new PageImpl<>(transformedList, pageable, total);
	}

	@Override
	public Page<Person> findAll(Pageable pageable) {
		final int total = catalog.getPeople().size();
		// sort
		final Order firstOrder = Iterables.getFirst(pageable.getSort(), null);
		final List<Person> sorted;
		if (firstOrder != null) {
			final Ordering<Person> ordering = new Ordering<Person>() {
				@Override
				public int compare(@Nullable Person left, @Nullable Person right) {
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
		final Iterable<Person> skipped = Iterables.skip(sorted, (int) pageable.getOffset());
		final Iterable<Person> limited = Iterables.limit(sorted, (int) pageable.getPageSize());
		// return
		final List<Person> copied = ImmutableList.copyOf(EcoreUtil.copyAll(ImmutableList.copyOf(limited)));
		return new PageImpl<>(copied, pageable, total);
	}

	@Override
	public Person findOneBySlug(StatusMask statusMask, final String slug) {
		final Optional<Person> found = Iterables.tryFind(catalog.getPeople(), new Predicate<Person>() {
			@Override
			public boolean apply(@Nullable Person input) {
				return slug != null ? slug.equals(input.getSlug()) : false;
			}
		});
		if (found.isPresent()) {
			return EcoreUtil.copy(found.get());
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
		final Optional<Person> found = Iterables.tryFind(catalog.getPeople(), new Predicate<Person>() {
			@Override
			public boolean apply(@Nullable Person input) {
				return slug != null && slug.equals(input.getSlug());
			}
		});
		return found.isPresent() ? Existence.of(found.get().getSlug(), found.get().getId()) : Existence.<String>absent();
	}

	@Override @Nullable
	public Person findOneByFacebook(@Nullable Long facebookId,
			@Nullable String facebookUsername) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override @Nullable
	public Person findOneByEmail(StatusMask statusMask, @Nullable String email) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override @Nullable
	public Person findOneByTwitter(@Nullable Long twitterId,
			@Nullable String twitterScreenName) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	@Nullable
	public Person findOneByClientAccessToken(@Nullable String clientAccessToken) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public Page<Person> findBySearchText(
			StatusMask statusMask, @Nullable String idNameEmailMobile, Pageable pageable) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public long countBySearchText(StatusMask statusMask, String searchText) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	@Nullable
	public Person findOneByPhoneNumber(StatusMask statusMask, @Nullable String mobileNumber) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public Person findOneActive(String personId) {
		// FIXME: implement status=ACTIVE|VALIDATED|VERIFIED filter
		return findOne(personId);
	}

	@Override
	public <S extends Person, K extends Serializable> S lookupOne(
			StatusMask statusMask, LookupKey lookupKey, K key)
			throws EntityLookupException {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public <S extends Person, K extends Serializable> Map<K, Try<S>> lookupAll(
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
	public TrashResult trash(Person entity) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public TrashResult trashById(String id) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public Map<String, Try<TrashResult>> trashAll(Collection<Person> entities) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public Map<String, Try<TrashResult>> trashAllByIds(Collection<String> ids) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public UntrashResult untrash(Person entity) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public UntrashResult untrashById(String id) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public Map<String, Try<UntrashResult>> untrashAll(
			Collection<Person> entities) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public Map<String, Try<UntrashResult>> untrashAllByIds(
			Collection<String> ids) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public Page<Person> findAll(StatusMask statusMask, Pageable pageable) {
		throw new UnsupportedOperationException();
	}

	@Override
	public long count(StatusMask statusMask) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Person> findAll(StatusMask statusMask, Collection<String> ids) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Person> findAllBySecRoleIds(StatusMask statusMask,
			Collection<String> secRoleIds) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasMatchWithSecRoleIds(String personId, Collection<String> secRoleIds) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Page<Person> findAll(StatusMask statusMask, Projection projection, Pageable pageable) {
		return null;
	}

	@Override
	public List<Person> findAllCustomerRoleIds(StatusMask statusMask,
			Collection<String> customerRoleIds) {
		throw new UnsupportedOperationException();
	}

	

	@Override
	public Page<Person> findAll(Collection<AccountStatus> accountStatuses,
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
	public Page<Person> findAllByKeywordAndStatus(String searchText,
			Collection<AccountStatus> accountStatuses, Pageable pageable) {
		throw new UnsupportedOperationException();
	}

	@Override
	public long countAllByKeywordAndRoles(String keyword,
			Collection<AccountStatus> accountStatuses,
			CustomerRole customerRole, Collection<String> custoemrRoleIds,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Page<Person> findAllByKeywordAndRoles(String keyword,
			Collection<AccountStatus> accountStatuses,
			CustomerRole customerRole, Collection<String> securityRoles,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}

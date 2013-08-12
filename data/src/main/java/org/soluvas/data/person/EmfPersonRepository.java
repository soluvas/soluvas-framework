package org.soluvas.data.person;

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
import org.soluvas.commons.IdPredicate;
import org.soluvas.commons.Person;
import org.soluvas.commons.PersonCatalog;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.domain.Sort.Order;
import org.soluvas.data.repository.PagingAndSortingRepositoryBase;

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
	public Person findOneBySlug(final String slug) {
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
	public String existsBySlug(final String slug) {
		final Optional<Person> found = Iterables.tryFind(catalog.getPeople(), new Predicate<Person>() {
			@Override
			public boolean apply(@Nullable Person input) {
				return slug != null && slug.equals(input.getSlug());
			}
		});
		return found.isPresent() ? found.get().getSlug() : null;
	}

	@Override @Nullable
	public Person findOneByFacebook(@Nullable Long facebookId,
			@Nullable String facebookUsername) {
		throw new UnsupportedOperationException();
	}

	@Override @Nullable
	public Person findOneByEmail(@Nullable String email) {
		throw new UnsupportedOperationException();
	}

	@Override @Nullable
	public Person findOneByTwitter(@Nullable Long twitterId,
			@Nullable String twitterScreenName) {
		throw new UnsupportedOperationException();
	}

	@Override
	@Nullable
	public Person findOneByClientAccessToken(@Nullable String clientAccessToken) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Page<Person> findBySearchText(
			@Nullable String idNameEmailMobile, Pageable pageable) {
		throw new UnsupportedOperationException();
	}

	@Override
	public long countBySearchText(String searchText) {
		// TODO Auto-generated method stub
		return 0;
	}

}

package org.soluvas.jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Nullable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Identifiable;
import org.soluvas.commons.SchemaVersionable;
import org.soluvas.data.EntityLookupException;
import org.soluvas.data.Existence;
import org.soluvas.data.GenericLookup;
import org.soluvas.data.LookupKey;
import org.soluvas.data.StatusMask;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.data.domain.Sort.Order;
import org.soluvas.data.repository.PagingAndSortingRepository;
import org.soluvas.data.repository.StatusAwareRepositoryBase;
import org.springframework.transaction.annotation.Transactional;

import scala.util.Try;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;

/**
 * {@link PagingAndSortingRepository} implemented using JPA, supporting 
 * Spring's @{@link Transactional} transaction management.
 * <p>Recommended deployment stack is: Hibernate 4.2 + Spring 3.2 + PostgreSQL 9.1. 
 * @param <T> TODO: should this extend an {@link Identifiable} of some sort?
 * @param <T>
 * @todo {@link SchemaVersionable} support, but how???
 * @author ceefour
 */
public abstract class JpaRepositoryBase<T extends JpaEntity<ID>, ID extends Serializable, E extends Enum<E>> 
	extends StatusAwareRepositoryBase<T, ID>
	implements JpaRepository<T, ID>, GenericLookup<T> {

	protected final Logger log;
	
	@PersistenceContext
	protected EntityManager em;
	
	protected Class<T> entityClass;

	protected String statusProperty;
	protected Set<E> activeStatuses;
	protected Set<E> inactiveStatuses;
	protected Set<E> draftStatuses;
	protected Set<E> voidStatuses;
	
	protected JpaRepositoryBase(Class<T> entityClass,
			@Nullable String statusProperty, Set<E> activeStatuses, Set<E> inactiveStatuses, Set<E> draftStatuses, Set<E> voidStatuses) {
		super();
		this.entityClass = entityClass;
		
		this.statusProperty = statusProperty;
		this.activeStatuses = activeStatuses;
		this.inactiveStatuses = inactiveStatuses;
		this.draftStatuses = draftStatuses;
		this.voidStatuses = voidStatuses;
		
		this.log = LoggerFactory.getLogger(JpaRepositoryBase.class.getName() + "/" + entityClass.getSimpleName());
		log.info("Initializing {} JPA repository", entityClass.getSimpleName());
	}
	
	@PostConstruct
	public void init() {
		
	}
	
	@PreDestroy
	public void destroy() {
		log.info("Shutting down {} JPA repository", entityClass.getSimpleName());
	}
	
	@Override @Transactional
	public Page<T> findAll(StatusMask statusMask, Pageable pageable) {
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		
		// WHERE
		@Nullable
		final Set<E> expectedStatuses;
		if (statusMask != StatusMask.RAW) {
			switch (statusMask) {
			case ACTIVE_ONLY:
				expectedStatuses = activeStatuses;
				break;
			case DRAFT_ONLY:
				expectedStatuses = draftStatuses;
				break;
			case INCLUDE_INACTIVE:
				expectedStatuses = Sets.union(activeStatuses, inactiveStatuses);
				break;
			case VOID_ONLY:
				expectedStatuses = voidStatuses;
				break;
			default:
				throw new IllegalArgumentException("Unrecognized statusMask: " + statusMask);
			}
		} else {
			expectedStatuses = null;
		}
		
		// SELECT COUNT(*) FROM entityClass WHERE ...
		final CriteriaQuery<Long> countCq = cb.createQuery(Long.class);
		final Root<T> countRoot = countCq.from(entityClass);
		countCq.select(cb.count(countRoot));
		if (expectedStatuses != null) {
			countCq.where(countRoot.<E>get(statusProperty).in(expectedStatuses));			
		}
		final long totalRowCount = em.createQuery(countCq).getSingleResult();
		
		
		// SELECT * FROM entityClass WHERE ... ORDER BY ... LIMIT x, y
		// FROM
		final CriteriaQuery<T> cq = cb.createQuery(entityClass);
		final Root<T> root = cq.from(entityClass);
		cq.select(root);
		// WHERE
		if (expectedStatuses != null) {
			cq.where(root.<E>get(statusProperty).in(expectedStatuses));			
		}
		// ORDER BY
		final List<javax.persistence.criteria.Order> jpaOrders = FluentIterable
				.from(Optional.<Iterable<Sort.Order>>fromNullable(pageable.getSort()).or(ImmutableList.<Sort.Order>of()))
				.transform(new Function<Order, javax.persistence.criteria.Order>() {
			@Override
			@Nullable
			public javax.persistence.criteria.Order apply(@Nullable Order input) {
				return input.getDirection() == Direction.ASC ? cb.asc(root.get(input.getProperty())) : cb.desc(root.get(input.getProperty()));
			}
		}).toList();
		cq.orderBy(jpaOrders);
		
		final TypedQuery<T> typedQuery = em.createQuery(cq)
			.setFirstResult((int) pageable.getOffset()).setMaxResults((int) pageable.getPageSize());
		final List<T> pageContent = typedQuery.getResultList();
		
		log.debug("findAll {} {} returned {} of {} rows (paged by {})",
				statusMask, entityClass.getSimpleName(), pageContent.size(), totalRowCount, pageable);
		return new PageImpl<>(pageContent, pageable, totalRowCount);
	}

	@Override @Transactional(readOnly=true)
	public long count() {
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Long> countCq = cb.createQuery(Long.class);
		final Root<T> countRoot = countCq.from(entityClass);
		countCq.select(cb.count(countRoot));
		final Long totalRowCount = em.createQuery(countCq).getSingleResult();
		log.debug("Count All without filter any thing got {} record(s)", totalRowCount);
		return totalRowCount;
	}

	@Override @Transactional(readOnly=true)
	public <S extends T, K extends Serializable> S lookupOne(
			StatusMask statusMask, LookupKey lookupKey, K key)
			throws EntityLookupException {
		throw new UnsupportedOperationException();
	}

	@Override @Transactional(readOnly=true)
	public <S extends T, K extends Serializable> Map<K, Try<S>> lookupAll(
			StatusMask statusMask, LookupKey lookupKey, Collection<K> keys) {
		throw new UnsupportedOperationException();
	}

	@Override @Transactional(readOnly=true)
	public <K extends Serializable> Map<K, Existence<K>> checkExistsAll(
			StatusMask statusMask, LookupKey lookupKey, Collection<K> keys) {
		throw new UnsupportedOperationException();
	}

	@Override @Transactional(readOnly=true)
	public <K extends Serializable> Existence<K> checkExists(
			StatusMask statusMask, LookupKey lookupKey, K key) {
		throw new UnsupportedOperationException();
	}

	@Override
	@Nullable @Transactional(readOnly=true)
	protected final ID getId(T entity) {
		return entity.getId();
	}

	@Override @Transactional
	public <S extends T> Collection<S> add(Collection<S> entities) {
		log.debug("Adding {} {} entities", entities.size(), entityClass.getSimpleName());
		final List<S> addeds = FluentIterable.from(entities).transform(new Function<S, S>() {
			@Override @Nullable
			public S apply(@Nullable S input) {
				em.persist(input);
				return input;
			}
		}).toList();
		log.info("Added {} {} entities", addeds.size(), entityClass.getSimpleName());
		return addeds;
	}

	@SuppressWarnings("null")
	@Override @Transactional
	public <S extends T> Collection<S> modify(Map<ID, S> entities) {
		log.debug("Modifying {} {} entities", entities.size(), entityClass.getSimpleName());
		final List<S> mergedEntities = FluentIterable.from(entities.entrySet()).transform(new Function<Entry<ID, S>, S>() {
			@Override
			public S apply(Entry<ID, S> input) {
				final S mergedEntity = em.merge(input.getValue());
				return mergedEntity;
			};
		}).toList();
		log.debug("{} entities have been modified", mergedEntities.size());
		return mergedEntities;
	}

	@Override @Transactional(readOnly=true)
	public Set<ID> exists(Collection<ID> ids) {
		throw new UnsupportedOperationException();
	}

	@Override @Transactional(readOnly=true)
	public List<T> findAll(Collection<ID> ids, Sort sort) {
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<T> cq = cb.createQuery(entityClass);
		final Root<T> root = cq.from(entityClass);
		cq.select(root).where(root.get("id").in(ids));
		final List<javax.persistence.criteria.Order> jpaOrders = FluentIterable
				.from(Optional.<Iterable<Sort.Order>>fromNullable(sort).or(ImmutableList.<Sort.Order>of()))
				.transform(new Function<Order, javax.persistence.criteria.Order>() {
			@Override
			@Nullable
			public javax.persistence.criteria.Order apply(@Nullable Order input) {
				return input.getDirection() == Direction.ASC ? cb.asc(root.get(input.getProperty())) : cb.desc(root.get(input.getProperty()));
			}
		}).toList();
		cq.orderBy(jpaOrders);
		
		final TypedQuery<T> typedQuery = em.createQuery(cq);
		final List<T> entities = typedQuery.getResultList();
			
		log.debug("findAll by ID(s) {} got {} entities",
				ids, entities.size());
		return entities;
	}

	@Override @Transactional
	public long deleteIds(Collection<ID> ids) {
		final List<T> entities = findAll(ids);
		log.warn("{} entities will be removed..", entities.size());
		if (entities.isEmpty()) {
			return 0;
		}
		for (final T t : entities) {
			em.remove(t);
		}
		log.debug("{} has/have been deleted", entities.size());
		return entities.size();
	}

	@Override
	public Page<ID> findAllIds(Pageable pageable) {
		throw new UnsupportedOperationException();
	}
	
}

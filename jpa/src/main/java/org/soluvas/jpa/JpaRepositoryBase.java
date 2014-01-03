package org.soluvas.jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Nullable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.GenericStatus;
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
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import scala.util.Failure;
import scala.util.Success;
import scala.util.Try;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
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
	@Inject
	protected PlatformTransactionManager txManager;
	
	protected Class<T> entityClass;

	@Nullable
	protected String statusProperty;
	protected Set<E> activeStatuses;
	protected Set<E> inactiveStatuses;
	protected Set<E> draftStatuses;
	protected Set<E> voidStatuses;
	
	/**
	 * At this point, {@link EntityManager} is not yet ready, so use {@link #onAfterInit(TransactionStatus)} for that.
	 * @param entityClass
	 * @param statusProperty
	 * @param activeStatuses
	 * @param inactiveStatuses
	 * @param draftStatuses
	 * @param voidStatuses
	 */
	@Deprecated
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
	
	/**
	 * At this point, {@link EntityManager} is not yet ready, so use {@link #onAfterInit(TransactionStatus)} for that.
	 * @param entityClass
	 * @param statusProperty
	 * @param activeStatuses
	 * @param inactiveStatuses
	 * @param draftStatuses
	 * @param voidStatuses
	 * @param em EntityManager is provided in constructor because there may be multiple {@link EntityManager}s, i.e.
	 * 		one for app-scope and another for multitenant-scoped.
	 */
	protected JpaRepositoryBase(Class<T> entityClass,
			@Nullable String statusProperty, Set<E> activeStatuses, Set<E> inactiveStatuses, Set<E> draftStatuses, Set<E> voidStatuses,
			EntityManager em/*, PlatformTransactionManager txManager*/) {
		super();
		this.entityClass = entityClass;
		
		this.statusProperty = statusProperty;
		this.activeStatuses = activeStatuses;
		this.inactiveStatuses = inactiveStatuses;
		this.draftStatuses = draftStatuses;
		this.voidStatuses = voidStatuses;
		
		this.em = Preconditions.checkNotNull(em, "EntityManager must be provided");
		//this.txManager = Preconditions.checkNotNull(txManager, "PlatformTransactionManager must be provided");
		final Set<String> entityNames = FluentIterable.from(em.getMetamodel().getEntities()).transform(new Function<EntityType, String>() {
			@Override @Nullable
			public String apply(@Nullable EntityType input) {
				return input.getBindableJavaType().getName();
			}
		}).toSet();
//		Preconditions.checkArgument(entityNames.contains(entityClass.getName()),
//				"EntityManager for '%s' JPA repository must include entity '%s'. Make sure you have set e.g. @PersistenceContext(unitName=\"fulan\"). %s known entities are: %s",
//				entityClass.getSimpleName(), entityClass.getName(), entityNames.size(), entityNames);
		Preconditions.checkArgument(entityNames.contains(entityClass.getName()),
				"EntityManager for '%s' JPA repository must include entity '%s'. Make sure you have called factoryBean.setPackagesToScan(). %s known entities are: %s",
				entityClass.getSimpleName(), entityClass.getName(), entityNames.size(), entityNames);
		
		this.log = LoggerFactory.getLogger(JpaRepositoryBase.class.getName() + "/" + entityClass.getSimpleName());
		log.info("Initializing {} JPA repository using {} with {} entities: {}", 
				entityClass.getSimpleName(), em, entityNames.size(), entityNames);
	}
	
	@PostConstruct
	public final void init() {
		Preconditions.checkNotNull(txManager, "PlatformTransactionManager txManager was not @Inject-ed properly.");
		final TransactionTemplate txTemplate = new TransactionTemplate(txManager);
		txTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				onAfterInit(status);
			}
		});
	}
	
	/**
	 * This is @{@link Transactional} (by using {@link PlatformTransactionManager} and {@link TransactionTemplate})
	 * because you may want to use {@link EntityManager#createNativeQuery(String)}
	 * to e.g. create a sequence.
	 * @see http://stackoverflow.com/a/18790494/1343587 
	 */
	protected void onAfterInit(TransactionStatus txStatus) {
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
		switch (lookupKey) {
		case ID:
			return lookupOneById(statusMask, (ID) key);
		default:
			throw new UnsupportedOperationException("Unsupported lookupKey: " + lookupKey);
		}
	}

	@Override @Transactional(readOnly=true)
	public <S extends T, K extends Serializable> Map<K, Try<S>> lookupAll(
			StatusMask statusMask, LookupKey lookupKey, Collection<K> keys) {
		switch (lookupKey) {
		case ID:
			return lookupAllById(statusMask, (Collection) keys);
		default:
			throw new UnsupportedOperationException("Unsupported lookupKey: " + lookupKey);
		}
	}

	@Override @Transactional(readOnly=true)
	public <K extends Serializable> Map<K, Existence<K>> checkExistsAll(
			StatusMask statusMask, LookupKey lookupKey, Collection<K> keys) {
		switch (lookupKey) {
		case ID:
			return (Map) existsAllById(statusMask, (Collection<ID>) keys);
		default:
			throw new UnsupportedOperationException("Unsupported lookupKey: " + lookupKey);
		}
	}

	@Override @Transactional(readOnly=true)
	public <K extends Serializable> Existence<K> checkExists(
			StatusMask statusMask, LookupKey lookupKey, K key) {
		switch (lookupKey) {
		case ID:
			return (Existence<K>) existsById(statusMask, (ID) key);
		default:
			throw new UnsupportedOperationException("Unsupported lookupKey: " + lookupKey);
		}
	}

	@Override
	@Nullable @Transactional(readOnly=true)
	protected final ID getId(T entity) {
		return entity.getId();
	}

	@Override @Transactional
	public <S extends T> Collection<S> add(Collection<S> entities) {
		log.debug("Adding {} {} entities: {}", entities.size(), entityClass.getSimpleName(), 
				FluentIterable.from(entities).transform(new IdFunction()).limit(10));
		final List<S> addeds = FluentIterable.from(entities).transform(new Function<S, S>() {
			@Override @Nullable
			public S apply(@Nullable S input) {
				em.merge(input);
				return input;
			}
		}).toList();
		log.info("Added {} {} entities: {}", addeds.size(), entityClass.getSimpleName(),
				FluentIterable.from(addeds).transform(new IdFunction()).limit(10));
		return addeds;
	}

	@SuppressWarnings("null")
	@Override @Transactional
	public <S extends T> Collection<S> modify(Map<ID, S> entities) {
		log.debug("Modifying {} {} entities: {}", entities.size(), entityClass.getSimpleName(),
				Iterables.limit(entities.keySet(), 10));
		final List<S> mergedEntities = FluentIterable.from(entities.entrySet()).transform(new Function<Entry<ID, S>, S>() {
			@Override
			public S apply(Entry<ID, S> input) {
				final S mergedEntity = em.merge(input.getValue());
				return mergedEntity;
			};
		}).toList();
		log.debug("{} {} entities have been modified", mergedEntities.size(), entityClass.getSimpleName(),
				FluentIterable.from(mergedEntities).transform(new IdFunction()).limit(10));
		return mergedEntities;
	}

	@Override @Transactional(readOnly=true)
	public Set<ID> exists(Collection<ID> ids) {
		return existsAllById(StatusMask.RAW, ids).keySet();
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
			@Override @Nullable
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

	@Override @Transactional(readOnly=true)
	public Page<ID> findAllIds(Pageable pageable) {
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		
		final long totalRowCount = count();
		
		// SELECT * FROM entityClass WHERE ... ORDER BY ... LIMIT x, y
		// FROM
		final CriteriaQuery<T> cq = cb.createQuery(entityClass);
		final Root<T> root = cq.from(entityClass);
		cq.select(root);
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
		final ImmutableList<ID> ids = FluentIterable.from(pageContent).transform(new IdFunction()).toList();
		
		return new PageImpl<>(ids, pageable, totalRowCount);
		
	}

	@Override @Transactional(readOnly=true)
	public Existence<ID> existsById(StatusMask statusMask, ID id) {
		return Preconditions.checkNotNull(existsAllById(statusMask, ImmutableSet.of(id)).get(id),
				"Internal error: existsAllById %s %s does not return Existence for key '%s'",
				entityClass.getName(), statusMask, id);
	}

	@Override @Transactional(readOnly=true)
	public Map<ID, Existence<ID>> existsAllById(StatusMask statusMask,
			Collection<ID> ids) {
		final TypedQuery<ID> query = (TypedQuery) em.createQuery("SELECT e.id FROM " + entityClass.getName() + " e WHERE e.id IN :ids", Serializable.class);
		query.setParameter("ids", ids);
		final Set<ID> existingIds = ImmutableSet.copyOf(query.getResultList());
		final ImmutableMap.Builder<ID, Existence<ID>> existsb = ImmutableMap.builder();
		for (final ID id : ids) {
			if (existingIds.contains(id)) {
				existsb.put(id, Existence.of(id, String.valueOf(id)));
			} else {
				existsb.put(id, Existence.<ID>absent());
			}
		}
		final Map<ID, Existence<ID>> exists = existsb.build();
		log.trace("Exists {} ID {}: {}", statusMask, ids, exists);
		return exists;
	}
	
	/**
	 * Useful to implement {@link GenericLookup#lookupOne(StatusMask, LookupKey, Serializable)}.
	 * @param statusMask
	 * @param key
	 * @return
	 * @throws EntityLookupException
	 */
	@Override
	@Transactional(readOnly=true)
	public <S extends T> S lookupOneById(StatusMask statusMask, @Nullable ID id) throws EntityLookupException {
		final Try<S> lookup = Preconditions.checkNotNull(this.<S>lookupAllById(statusMask, ImmutableSet.of(id)).get(id),
				"Internal error: lookupAllById %s %s does not return Try<S> instance for ID '%s'",
				entityClass.getName(), statusMask, id);
		return lookup.get();
	}
	
	/**
	 * Used to implement {@link GenericLookup#lookupAll(StatusMask, LookupKey, Collection)}.
	 * @param statusMask
	 * @param keys
	 * @return
	 */
	@Override
	@Transactional(readOnly=true)
	public <S extends T> Map<ID, Try<S>> lookupAllById(StatusMask statusMask, Collection<ID> ids) {
		final TypedQuery<S> query = (TypedQuery<S>) em.createQuery("SELECT e FROM " + entityClass.getName() + " e WHERE e.id IN :ids", entityClass);
		query.setParameter("ids", ids);
		final Set<ID> unknownIds = new HashSet<>(ids);
		final ImmutableMap.Builder<ID, Try<S>> lookupb = ImmutableMap.builder();
		for (final S entity : query.getResultList()) {
			final E status = getStatus(entity);
			switch (statusMask) {
			case RAW:
				lookupb.put(entity.getId(), new Success<>(entity));
				break;
			case ACTIVE_ONLY:
				if (activeStatuses.contains(status)) {
					lookupb.put(entity.getId(), new Success<>(entity));
				} else {
					lookupb.put(entity.getId(), new Failure<S>(new EntityLookupException(
							entityClass, statusMask, LookupKey.ID, entity.getId(), this, Optional.of(status))));
				}
				break;
			case DRAFT_ONLY:
				if (draftStatuses.contains(status)) {
					lookupb.put(entity.getId(), new Success<>(entity));
				} else {
					lookupb.put(entity.getId(), new Failure<S>(new EntityLookupException(
							entityClass, statusMask, LookupKey.ID, entity.getId(), this, Optional.of(status))));
				}
				break;
			case INCLUDE_INACTIVE:
				if (Sets.union(activeStatuses, inactiveStatuses).contains(status)) {
					lookupb.put(entity.getId(), new Success<>(entity));
				} else {
					lookupb.put(entity.getId(), new Failure<S>(new EntityLookupException(
							entityClass, statusMask, LookupKey.ID, entity.getId(), this, Optional.of(status))));
				}
				break;
			case VOID_ONLY:
				if (voidStatuses.contains(status)) {
					lookupb.put(entity.getId(), new Success<>(entity));
				} else {
					lookupb.put(entity.getId(), new Failure<S>(new EntityLookupException(
							entityClass, statusMask, LookupKey.ID, entity.getId(), this, Optional.of(status))));
				}
				break;
			}
			unknownIds.remove(entity.getId());
		}
		for (final ID unknownId : unknownIds) {
			lookupb.put(unknownId, new Failure<S>(
					new EntityLookupException(entityClass, statusMask, LookupKey.ID, unknownId, this, Optional.<E>absent())));
		}
		final Map<ID, Try<S>> exists = lookupb.build();
		log.trace("Lookup {} ID {}: {}", statusMask, ids, exists);
		return exists;
	}
	
	/**
	 * Return the status of the entity. If the entity doesn't support status, please return
	 * {@link GenericStatus#BOOKED}.
	 * @param entity
	 * @return
	 */
	protected abstract E getStatus(T entity);
	
}

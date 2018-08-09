package org.soluvas.jpa;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import javax.persistence.metamodel.EntityType;
import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.GenericStatus;
import org.soluvas.commons.Identifiable;
import org.soluvas.commons.SchemaVersionable;
import org.soluvas.commons.tenant.CommandRequestAttributes;
import org.soluvas.commons.tenant.TenantAdded;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.commons.tenant.TenantRepository;
import org.soluvas.commons.tenant.TenantRepositoryListener;
import org.soluvas.commons.tenant.TenantsStarting;
import org.soluvas.commons.tenant.TenantsStopping;
import org.soluvas.data.EntityLookupException;
import org.soluvas.data.Existence;
import org.soluvas.data.GenericLookup;
import org.soluvas.data.LookupKey;
import org.soluvas.data.StatusMask;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Projection;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.data.domain.Sort.Order;
import org.soluvas.data.push.RepositoryException;
import org.soluvas.data.repository.PagingAndSortingRepository;
import org.soluvas.data.repository.StatusAwareRepositoryBase;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;
import com.google.common.eventbus.EventBus;

import liquibase.Contexts;
import liquibase.Liquibase;
import liquibase.database.core.PostgresDatabase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import scala.util.Failure;
import scala.util.Success;
import scala.util.Try;

/**
 * {@link PagingAndSortingRepository} implemented using JPA, supporting 
 * Spring's @{@link Transactional} transaction management.
 * 
 * <p>Recommended deployment stack is: Hibernate 4.2 + Spring 3.2 + PostgreSQL 9.1.
 * 
 * <p>To use tenant-specific repository inside a tenant-independent code such as {@link EventBus} subscriber
 * or Quartz Job, see {@link CommandRequestAttributes#withTenant(String)}.
 *  
 * <p>This repository cannot be {@link Lazy}-init, must be eager-init, because it initializes
 * all tenants during initialization.
 * 
 * @param <T> TODO: should this extend an {@link Identifiable} of some sort?
 * @param <T>
 * @todo {@link SchemaVersionable} support, but how???
 * @author ceefour
 */
public abstract class JpaRepositoryBase<T extends JpaEntity<ID>, ID extends Serializable, E extends Enum<E>> 
	extends StatusAwareRepositoryBase<T, ID>
	implements JpaRepository<T, ID>, GenericLookup<T>, TenantRepositoryListener {

	protected final Logger log;
	@Inject
	protected PlatformTransactionManager txManager;
	@Inject
	protected DataSource dataSource;
	@Inject
	private BeanFactory beanFactory;
	@Autowired(required=false)
	private TenantRepository<?> tenantRepo;
	@Inject
	private Environment env;
	
	protected EntityManager em;
	protected Class<T> entityClass;
	@Nullable
	protected String statusProperty;
	protected Set<E> activeStatuses;
	protected Set<E> inactiveStatuses;
	protected Set<E> draftStatuses;
	protected Set<E> voidStatuses;
	@Nullable
	private String liquibasePath;
	@Nullable
	private Set<String> initialTenantIds;
	
	
	
	/**
	 * At this point, {@link EntityManager} is not yet ready, so use {@link #onAfterInit(TransactionStatus)} for that.
	 * @param entityClass
	 * @param statusProperty
	 * @param activeStatuses
	 * @param inactiveStatuses
	 * @param draftStatuses
	 * @param voidStatuses
	 * @param em EntityManager is provided in constructor because there may be multiple {@link EntityManager}s
	 * 		in a {@link JtaTransactionManager}. Note that for servlet containers like Tomcat, only one {@link EntityManager} is supported
	 *		by {@link org.springframework.orm.jpa.JpaTransactionManager}, but we still can do multitenancy with this.
	 */
	protected JpaRepositoryBase(Class<T> entityClass,
			@Nullable String statusProperty, Set<E> activeStatuses, Set<E> inactiveStatuses, Set<E> draftStatuses, Set<E> voidStatuses,
			EntityManager em/*, PlatformTransactionManager txManager*/) {
		this(entityClass, statusProperty, activeStatuses, inactiveStatuses, draftStatuses, voidStatuses, em,
				null, null);
	}
	
	/**
	 * @param entityClass
	 * @param statusProperty
	 * @param activeStatuses
	 * @param inactiveStatuses
	 * @param draftStatuses
	 * @param voidStatuses
	 * @param em
	 * @param liquibase
	 * @throws SQLException 
	 * @throws LiquibaseException 
	 */
	protected JpaRepositoryBase(Class<T> entityClass,
			@Nullable String statusProperty, Set<E> activeStatuses, Set<E> inactiveStatuses, Set<E> draftStatuses, Set<E> voidStatuses,
			EntityManager em, String liquibasePath, Set<String> initialTenantIds) {
		super();
		this.entityClass = entityClass;
		
		this.statusProperty = statusProperty;
		this.activeStatuses = activeStatuses;
		this.inactiveStatuses = inactiveStatuses;
		this.draftStatuses = draftStatuses;
		this.voidStatuses = voidStatuses;
		this.liquibasePath = liquibasePath;
		this.initialTenantIds = initialTenantIds;
		
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
		if (!entityNames.contains(entityClass.getName())) {
			throw new IllegalArgumentException(String.format("EntityManager for '%s' JPA repository must include entity '%s'. Make sure you have called factoryBean.setPackagesToScan(). %s known entities are: %s",
					entityClass.getSimpleName(), entityClass.getName(), entityNames.size(), entityNames));
		}

		this.log = LoggerFactory.getLogger(JpaRepositoryBase.class.getName() + "/" + entityClass.getSimpleName());
		if (initialTenantIds != null) {
			log.info("Initializing {} JPA repository using {} with {} entities ({}) and {} initial tenants: {}", 
					entityClass.getSimpleName(), em.getClass().getName(), entityNames.size(), entityNames,
					initialTenantIds.size(), initialTenantIds);
		} else {
			log.info("Initializing {} JPA repository using {} with {} entities ({}) and empty initial tenants", 
					entityClass.getSimpleName(), em.getClass().getName(), entityNames.size(), entityNames);
		}
	}
	
	/**
	 * Migrates using Liquibase for the specified {@code tenantId}.
	 * @param tenantId
	 * @throws SQLException
	 * @throws LiquibaseException
	 */
	public void migrate(Set<String> tenantIds) throws RepositoryException {
		final ClassLoaderResourceAccessor resourceAccessor = new ClassLoaderResourceAccessor(this.entityClass.getClassLoader());
		final PostgresDatabase db = new PostgresDatabase();
		try {
			final Liquibase liquibase;
			try {
				liquibase = new Liquibase(liquibasePath, resourceAccessor, db);
			} catch (Exception e) {
				throw new RepositoryException(e, "Cannot migrate tenants %s using '%s': %s", tenantIds, liquibasePath, e);
			}
			for (String tenantId : tenantIds) {
				try (final Closeable cl = CommandRequestAttributes.withMdc(tenantId)) {
					log.info("[{}] Migrating {}", tenantId, entityClass.getSimpleName());
					final Contexts contexts = new Contexts();
					try (final Connection conn = dataSource.getConnection()) {
						// TODO: SET SCHEMA is workaround for Liquibase's not setting schema for <sql>. https://liquibase.jira.com/browse/CORE-1873
						final Statement st = conn.createStatement();
						st.executeUpdate("SET SCHEMA '" + tenantId + "'");
						final JdbcConnection jdbc = new JdbcConnection(conn);
						db.setDefaultSchemaName(tenantId);
						try {
							db.setConnection(jdbc);
							liquibase.update(contexts);
						} finally {
							st.executeUpdate("SET SCHEMA 'public'");
						}
					}
				} catch (Exception e) {
					throw new RepositoryException(e, "Cannot migrate '%s' using '%s': %s", tenantId, liquibasePath, e);
				}
			}
		} finally {
			try {
				db.close();
			} catch (Exception e) {
				log.debug("Ignoring close database error: " + e);
			}
		}
	}
	
	@PostConstruct
	public final void init() throws SQLException, IOException {
		Preconditions.checkNotNull(txManager, "PlatformTransactionManager txManager was not @Inject-ed properly.");
		
		final boolean liquibaseMigrateEnabled = env.containsProperty("liquibaseMigrateEnabled") ? env.getProperty("liquibaseMigrateEnabled", Boolean.class) : true;
		if (liquibasePath != null && liquibaseMigrateEnabled) {
			Preconditions.checkNotNull(dataSource, "dataSource was not @Inject-ed properly.");
			migrate(initialTenantIds);
		}
		
		final TransactionTemplate txTemplate = new TransactionTemplate(txManager);
		txTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				onAfterInit(status);
			}
		});
		
		if (initialTenantIds != null) {
			for (final String tenantId : initialTenantIds) {
				// If you get CommandRequestAttributes' IllegalStateException, do not @Lazy-init this bean!
				try (final Closeable closeable = CommandRequestAttributes.withTenant(tenantId)) {
					txTemplate.execute(new TransactionCallbackWithoutResult() {
						@Override
						protected void doInTransactionWithoutResult(TransactionStatus status) {
							onAfterInitTenant(tenantId, status);
						}
					});
				}
			}
		}
		
		if (tenantRepo != null) {
			tenantRepo.addListener(this);
		}
	}
	
	/**
	 * This is @{@link Transactional} (by using {@link PlatformTransactionManager} and {@link TransactionTemplate})
	 * because you may want to use {@link EntityManager#createNativeQuery(String)}
	 * to e.g. create a sequence.
	 * @see http://stackoverflow.com/a/18790494/1343587 
	 */
	protected void onAfterInit(TransactionStatus txStatus) {
	}
	
	/**
	 * This is @{@link Transactional} (by using {@link PlatformTransactionManager} and {@link TransactionTemplate})
	 * because you may want to use {@link EntityManager#createNativeQuery(String)}
	 * to e.g. create a sequence.
	 * @see http://stackoverflow.com/a/18790494/1343587 
	 */
	protected void onAfterInitTenant(String tenantId, TransactionStatus txStatus) {
	}
	
	@PreDestroy
	public void destroy() {
		log.info("Shutting down {} JPA repository", entityClass.getSimpleName());
	}
	
	@Override
	public void onTenantsStarting(TenantsStarting starting) throws Exception {
		final ImmutableSet<String> origTenantIds = starting.getAddeds().keySet();
		final SetView<String> tenantIds = Sets.difference(origTenantIds, initialTenantIds);
		log.info("Migrating {} {} JPA repositories (excluding {} initialTenants): {}", 
				tenantIds.size(), entityClass.getSimpleName(), initialTenantIds.size(), tenantIds);
		migrate(tenantIds);
		log.info("Migrated {} {} JPA repositories (excluding {} initialTenants): {}", 
				tenantIds.size(), entityClass.getSimpleName(), initialTenantIds.size(), tenantIds);
	}
	
	@Override
	public void onTenantsStopping(TenantsStopping stopping) throws Exception {
	}
	
	@Override
	public void onTenantAdded(TenantAdded tenantAdded) throws Exception {
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
//				log.debug("Order: {}", input);
				final String[] properties = StringUtils.split(input.getProperty(), ".");
//				log.debug("properties: {}", properties);
				Path<Object> path = null;
				int i = 0;
				for (int j = 0; j < properties.length; j++) {
//					log.debug("Path: {}", path);
					i++;
					if (i == properties.length) {
						if (path == null) {
							path = root.get(properties[j]);
						} else {
							path = path.get(properties[j]);
						}
					} else {
						if (path == null) {
							path = root.get(properties[j]);
						} else {
							path = path.get(properties[j]);
						}
					}
				}
				return input.getDirection() == Direction.ASC ? cb.asc(path) : cb.desc(path);
				
//				return input.getDirection() == Direction.ASC ? cb.asc(root.get(input.getProperty())) : cb.desc(root.get(input.getProperty()));
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
				beforeSave(input, ModificationTimePolicy.UPDATE);
//				em.persist(input); //error --> EntityExistsException A different object with the same identifier value was already associated with the session
//				return input;
				return em.merge(input);
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
				beforeSave(input.getValue(), ModificationTimePolicy.UPDATE);
				final S mergedEntity = em.merge(input.getValue());
				return mergedEntity;
			};
		}).toList();
		log.debug("{} {} entities have been modified", mergedEntities.size(), entityClass.getSimpleName(),
				FluentIterable.from(mergedEntities).transform(new IdFunction()).limit(10));
		return mergedEntities;
	}
	
	@Override @Transactional
	public <S extends T> S modify(ID id, S entity, DateTime lastModificationTime) {
		log.debug("Modifying {} '{}' require modificationTime {}", entityClass.getSimpleName(), id, lastModificationTime);
		final T existing = em.find(entityClass, id);
		Preconditions.checkState(lastModificationTime.equals(existing.getModificationTime()), "%s %s on database has already modified by different modification time with %s on memory.",
				entityClass.getSimpleName(), id, entityClass.getSimpleName());
		beforeSave(entity, ModificationTimePolicy.UPDATE);
		final S mergedEntity = em.merge(entity);
		log.debug("{} '{}' have been modified from {} to {}", entityClass.getSimpleName(), id,
				lastModificationTime, entity.getModificationTime());
		return mergedEntity;
	}
	
	@Override
	public <S extends T> Collection<S> add(Collection<S> entities, org.soluvas.data.repository.CrudRepository.ModificationTimePolicy mTimePolicy) {
		log.debug("Adding {} {} entities: {}", entities.size(), entityClass.getSimpleName(), 
				FluentIterable.from(entities).transform(new IdFunction()).limit(10));
		final List<S> addeds = FluentIterable.from(entities).transform(new Function<S, S>() {
			@Override @Nullable
			public S apply(@Nullable S input) {
				beforeSave(input, mTimePolicy);
//				em.persist(input); //error --> EntityExistsException A different object with the same identifier value was already associated with the session
//				return input;
				return em.merge(input);
			}
		}).toList();
		log.info("Added {} {} entities: {}", addeds.size(), entityClass.getSimpleName(),
				FluentIterable.from(addeds).transform(new IdFunction()).limit(10));
		return addeds;
	}
	

	@Override @Transactional(readOnly=true)
	public Set<ID> exists(Collection<ID> ids) {
		return Maps.filterValues(existsAllById(StatusMask.RAW, ids), new Predicate<Existence<ID>>() {
			@Override
			public boolean apply(Existence<ID> input) {
				return input.isPresent();
			}
		}).keySet();
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
		Preconditions.checkNotNull(id, "ID must not be null");
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
	
	protected void beforeSave(T entity, org.soluvas.data.repository.CrudRepository.ModificationTimePolicy mtimePolicy) {
		if (entity.getCreationTime() == null) {
			entity.setCreationTime(new DateTime(getAppManifest().getDefaultTimeZone()));
		}
		if (mtimePolicy == ModificationTimePolicy.UPDATE || entity.getModificationTime() == null) {
			entity.setModificationTime(new DateTime(getAppManifest().getDefaultTimeZone()));
		}
	}

	/**
	 * Uses {@link #beanFactory} to get tenant-specific {@link AppManifest}.
	 * @return
	 */
	protected AppManifest getAppManifest() {
		return beanFactory.getBean(AppManifest.class);
	}
	
	/**
	 * Uses {@link #beanFactory} to get tenant-specific {@link TenantRef}.
	 * @return
	 */
	protected TenantRef getTenant() {
		return beanFactory.getBean(TenantRef.class);
	}
	
	/**
	 * Uses {@link #beanFactory} to get tenant-specific {@code tenantId}.
	 * @return
	 */
	protected String getTenantId() {
		return getTenant().getTenantId();
	}
	
	protected List<Selection<?>> getSelectionsFromProjection(final Root<T> root, final Projection projection){
		Preconditions.checkState(projection.getExcludedFields() == null, "NOT SUPPORT for Excluded fields on Projection.");
		Preconditions.checkNotNull(projection, "Projection must not be null.");
		final List<Selection<?>> selections = new ArrayList<>();
		if (!projection.isIdIncluded()) {
			selections.add(root.get("id"));
		}
		for (final String field : projection.getIncludedFields()) {
			selections.add(root.get(field));
		}
		return selections;
	}
	
}

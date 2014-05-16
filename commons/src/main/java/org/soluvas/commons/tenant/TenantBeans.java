package org.soluvas.commons.tenant;

import java.io.Closeable;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

import javax.annotation.Nullable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.CommonsException;
import org.soluvas.commons.config.CommonsWebConfig;
import org.soluvas.commons.config.MultiTenantConfig;
import org.soluvas.commons.config.TenantSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.eventbus.EventBus;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

/**
 * Manages the lifecycle of tenant-scoped beans, using the same implementation class for all tenants.
 * During application (i.e. this repository's) startup,
 * all {@link Environment} properties are read at once (and saved because they'll be needed for each tenant bean initialization),
 * all tenant beans are initialized together;
 * also during shutdown, if a {@code destroy()} method exists they're destroyed together.
 * During runtime, it subscribes to before/after-add/modify/delete EventBus messages and performs the
 * appropriate operations.
 * 
 * <p>Note: for beforeModify, beforeDelete.. we need those messages to be synchronous (i.e. method calls
 * in a {@link TenantRepository}).
 * i.e. acknowledgement is required.
 * 
 * <p>This class is thread-safe.
 * @author ceefour
 */
public abstract class TenantBeans<T> implements TenantRepositoryListener {

	private final Logger log;
	/**
	 * Stores the currently managed tenant beans. 
	 */
//	private final Map<String, T> beanMap = new LinkedHashMap<>();
	private final Map<String, T> beanMap = new ConcurrentHashMap<>();
	private Method initMethod;
	private Method destroyMethod;
	private final Class<? extends T> implClass;
	
	@Inject
	private MultiTenantConfig tenantConfig;
	@Inject @Named(CommonsWebConfig.APP_EVENT_BUS)
	private EventBus appEventBus;
	@Autowired(required=false)
	private TenantRepository<?> tenantRepo;
	@Inject
	private TenantSelector tenantSelector;
	/**
	 * Ticket: https://github.com/soluvas/soluvas-framework/issues/66
	 * 
	 * Blocked by <a href="https://jira.spring.io/browse/SPR-8471?focusedCommentId=103179&page=com.atlassian.jira.plugin.system.issuetabpanels:comment-tabpanel#comment-103179">SPR-8471</a>
	 * 
	 * <p>Perhaps wait for Spring 4?
	 */
//	@Inject @Cpu
	private final ListeningExecutorService cpuExecutor = MoreExecutors.sameThreadExecutor();

	/**
	 * @param implClass Must be the implementation class, because {@code init()} and {@code destroy()}
	 * 		will only be scanned once on this class.
	 */
	public TenantBeans(Class<? extends T> implClass) {
		super();
		this.implClass = implClass;
		log = LoggerFactory.getLogger(TenantBeans.class.getName() + "/" + implClass.getSimpleName());
		
		try {
			initMethod = implClass.getMethod("init");
		} catch (NoSuchMethodException e) {
		} catch (SecurityException e) {
			throw new CommonsException("Cannot probe class " + implClass.getName(), e);
		}
		try {
			destroyMethod = implClass.getMethod("destroy");
		} catch (NoSuchMethodException e) {
		} catch (SecurityException e) {
			throw new CommonsException("Cannot probe class " + implClass.getName(), e);
		}
		log.info("Lifecycle methods for {}: init={} destroy={}",
				implClass.getSimpleName(), initMethod, destroyMethod);
	}
	
	@PostConstruct
	public void init() {
		final ImmutableMap<String, AppManifest> initialTenantMap = tenantConfig.tenantMap();
		log.info("Initializing {} {} tenant beans: {}", 
				initialTenantMap.size(), implClass.getSimpleName(), initialTenantMap.keySet());
//		for (final Map.Entry<String, AppManifest> tenant : initialTenantMap.entrySet()) {
//			final String tenantId = tenant.getKey();
//			createAndPut(tenantId, tenant.getValue());
//		}
		final ImmutableList<CreateAndPut> tasks = FluentIterable.from(initialTenantMap.entrySet())
			.transform(new Function<Map.Entry<String, AppManifest>, CreateAndPut>() {
				@Override @Nullable
				public TenantBeans<T>.CreateAndPut apply(
						@Nullable Entry<String, AppManifest> input) {
					return new CreateAndPut(input.getKey(), input.getValue());
				}
		}).toList();
		try {
			final List<ListenableFuture<String>> futures = (List) cpuExecutor.invokeAll(tasks);
			final List<String> initializedTenantIds = Futures.allAsList(futures).get();
			log.info("Initialized {} {} tenant beans: {}", 
					initializedTenantIds.size(), implClass.getSimpleName(), initializedTenantIds);
		} catch (InterruptedException | ExecutionException e) {
			throw new TenantException(e, "Cannot initialize %s %s tenant beans: %s",
					initialTenantMap.size(), implClass.getSimpleName(), initialTenantMap.keySet());
		}
		
		if (tenantRepo != null) {
			tenantRepo.addListener(this);
		}
	}
	
	@PreDestroy
	public void destroy() {
		final ImmutableList<String> tenantIdsToRemove = ImmutableList.copyOf(beanMap.keySet());
		log.info("Shutting down {} {} beans: {}",
				beanMap.size(), implClass.getSimpleName(), tenantIdsToRemove);
		
		final ImmutableList<RemoveAndDestroy> tasks = FluentIterable.from(tenantIdsToRemove)
				.transform(new Function<String, RemoveAndDestroy>() {
					@Override @Nullable
					public RemoveAndDestroy apply(String input) {
						return new RemoveAndDestroy(input);
					}
			}).toList();
		try {
			final List<ListenableFuture<String>> futures = (List) cpuExecutor.invokeAll(tasks);
			final List<String> initializedTenantIds = Futures.allAsList(futures).get();
			log.info("Shutted down {} {} tenant beans: {}", 
					initializedTenantIds.size(), implClass.getSimpleName(), initializedTenantIds);
		} catch (InterruptedException | ExecutionException e) {
			throw new TenantException(e, "Cannot shutdown %s %s tenant beans: %s",
					tenantIdsToRemove.size(), implClass.getSimpleName(), tenantIdsToRemove);
		}
		
//		for (String tenantId : tenantIdsRev) {
//			removeAndDestroy(tenantId);
//		}
	}
	
	protected class CreateAndPut implements Callable<String> {
		
		private final String tenantId;
		private final AppManifest appManifest;
		
		public CreateAndPut(String tenantId, AppManifest appManifest) {
			super();
			this.tenantId = tenantId;
			this.appManifest = appManifest;
		}

		@Override
		public String call() throws Exception {
			try (Closeable cl = CommandRequestAttributes.withMdc(tenantId)) {
				log.debug("Initializing '{}' {} {}",
						tenantId, implClass.getSimpleName(), initMethod != null ? "using init method " + initMethod : "without init method");
				final T bean = create(tenantId, appManifest);
				if (initMethod != null) {
					initMethod.invoke(bean);
				}
				beanMap.put(tenantId, bean);
				onCreated(tenantId, appManifest, bean);
				return tenantId;
			} catch (Exception e) {
				throw new TenantException("Cannot initialize " + implClass.getSimpleName() + " bean for '" + tenantId + "': " + e, e);
			}
		}
		
	}
	
	protected class RemoveAndDestroy implements Callable<String> {
		
		private final String tenantId;
		
		public RemoveAndDestroy(String tenantId) {
			super();
			this.tenantId = tenantId;
		}

		@Override
		public String call() throws Exception {
			try (Closeable cl = CommandRequestAttributes.withMdc(tenantId)) {
				log.info("Shutting down '{}' {} {}",
						tenantId, implClass.getSimpleName(), destroyMethod != null ? "using destroymethod " + destroyMethod : "without destroy method");
				final T bean = beanMap.get(tenantId);
				if (bean != null) {
					onDestroying(tenantId, bean);
					beanMap.remove(tenantId);
					if (destroyMethod != null) {
						destroyMethod.invoke(bean);
					}
				} else {
					log.warn("Not removing non-existing {} bean for tenant '{}'",
							implClass.getSimpleName(), tenantId);
				}
				return tenantId;
			} catch (Exception e) {
				throw new TenantException("Cannot destroy " + implClass.getSimpleName() + " bean for '" + tenantId + "'", e);
			}
		}
		
	}
	
//	protected synchronized final void createAndPut(String tenantId, AppManifest appManifest) {
//		try {
//			log.debug("Initializing '{}' {} {}",
//					tenantId, implClass.getSimpleName(), initMethod != null ? "using init method " + initMethod : "without init method");
//			final T bean = create(tenantId, appManifest);
//			if (initMethod != null) {
//				initMethod.invoke(bean);
//			}
//			beanMap.put(tenantId, bean);
//			onCreated(tenantId, appManifest, bean);
//		} catch (Exception e) {
//			throw new CommonsException("Cannot initialize " + implClass.getSimpleName() + " bean for '" + tenantId + "': " + e, e);
//		}
//	}
	
//	protected synchronized final void removeAndDestroy(String tenantId) {
//		try {
//			log.info("Shutting down '{}' {} {}",
//					tenantId, implClass.getSimpleName(), destroyMethod != null ? "using destroymethod " + destroyMethod : "without destroy method");
//			final T bean = beanMap.get(tenantId);
//			if (bean != null) {
//				onDestroying(tenantId, bean);
//				beanMap.remove(tenantId);
//				if (destroyMethod != null) {
//					destroyMethod.invoke(bean);
//				}
//			} else {
//				log.warn("Not removing non-existing {} bean for tenant '{}'",
//						implClass.getSimpleName(), tenantId);
//			}
//		} catch (Exception e) {
//			throw new TenantException("Cannot destroy " + implClass.getSimpleName() + " bean for '" + tenantId + "'", e);
//		}
//	}
	
	/**
	 * Creates the bean for the specified tenant, do <strong>not</strong> call {@code init()},
	 * {@link TenantBeans} will call it.
	 * 
	 * <p><b>Thread safety</b>: This method <b>must</b> be thread safe!
	 * 
	 * @param tenantId
	 * @param appManifest
	 * @return
	 * @throws Exception
	 */
	protected abstract T create(String tenantId, AppManifest appManifest) throws Exception;
	
	/**
	 * Hook that's called after a tenant bean has been created and initialized.
	 * @param tenantId
	 * @param appManifest
	 * @param bean
	 */
	protected void onCreated(String tenantId, AppManifest appManifest, T bean) {
	}
	
	/**
	 * Hook that's called before a tenant bean will be destroyed.
	 * @param tenantId
	 * @param bean
	 */
	protected void onDestroying(String tenantId, T bean) {
	}
	
	/**
	 * Returns an unmodifiable {@link Map} <b>view</b> of tenant mapping, which means
	 * its contents may change based on current state.
	 * 
	 * @return
	 */
	public Map<String, T> unmodifiableView() {
		return Collections.unmodifiableMap(beanMap);
	}
	
	/**
	 * Returns the {@code beanMap}'s {@link Map#size()}.
	 * @return
	 */
	public int size() {
		return beanMap.size();
	}
	
	/**
	 * Returns an {@link ImmutableSet} copy of the {@code beanMap} {@link Map#keySet()}.
	 * @return
	 */
	public ImmutableSet<String> keySet() {
		return ImmutableSet.copyOf(beanMap.keySet());
	}
	
	/**
	 * Returns the bean for {@code tenantId}, or throws a {@link NullPointerException} if not found.
	 * @param tenantId
	 * @return
	 * @throws NullPointerException
	 */
	public T get(String tenantId) {
		final ImmutableSet<String> tenantIds = keySet();
		return Preconditions.checkNotNull( beanMap.get(tenantId),
				"Cannot get %s bean for '%s'. %s available are: %s",
				implClass.getSimpleName(), tenantId, tenantIds.size(), tenantIds);
	}
	
	/**
	 * Get bean based on {@link TenantSelector#tenantRef()}.
	 * @return
	 */
	public T getCurrent() {
		return get(tenantSelector.tenantRef().getTenantId());
	}
	
	@Override
	public void onTenantsStarting(TenantsStarting starting) throws Exception {
//		for (final Map.Entry<String, AppManifest> entry : starting.getAddeds().entrySet()) {
//			final String tenantId = entry.getKey();
//			final AppManifest appManifest = entry.getValue();
//			createAndPut(tenantId, appManifest);
//		}
		
		log.info("Starting {} {} tenant beans: {}", 
				starting.getAddeds().size(), implClass.getSimpleName(), starting.getAddeds().keySet());
		final ImmutableList<CreateAndPut> tasks = FluentIterable.from(starting.getAddeds().entrySet())
				.transform(new Function<Map.Entry<String, AppManifest>, CreateAndPut>() {
					@Override @Nullable
					public TenantBeans<T>.CreateAndPut apply(
							@Nullable Entry<String, AppManifest> input) {
						return new CreateAndPut(input.getKey(), input.getValue());
					}
			}).toList();
		try {
			final List<ListenableFuture<String>> futures = (List) cpuExecutor.invokeAll(tasks);
			final List<String> initializedTenantIds = Futures.allAsList(futures).get();
			log.info("Started {} {} tenant beans: {}", 
					initializedTenantIds.size(), implClass.getSimpleName(), initializedTenantIds);
		} catch (InterruptedException | ExecutionException e) {
			throw new TenantException(e, "Cannot start %s %s tenant beans: %s",
					starting.getAddeds().size(), implClass.getSimpleName(), starting.getAddeds().keySet());
		}
	}
	
	@Override
	public void onTenantsStopping(TenantsStopping stopping) throws Exception {
//		for (final Map.Entry<String, AppManifest> entry : stopping.getTenants().entrySet()) {
//			final String tenantId = entry.getKey();
//			final AppManifest appManifest = entry.getValue();
//			removeAndDestroy(tenantId);
//		}
		
		final ImmutableList<String> tenantIdsToRemove = ImmutableList.copyOf(stopping.getTenants().keySet());
		log.info("Stopping {} {} beans: {}",
				beanMap.size(), implClass.getSimpleName(), tenantIdsToRemove);
		
		final ImmutableList<RemoveAndDestroy> tasks = FluentIterable.from(tenantIdsToRemove)
				.transform(new Function<String, RemoveAndDestroy>() {
					@Override @Nullable
					public RemoveAndDestroy apply(String input) {
						return new RemoveAndDestroy(input);
					}
			}).toList();
		try {
			final List<ListenableFuture<String>> futures = (List) cpuExecutor.invokeAll(tasks);
			final List<String> initializedTenantIds = Futures.allAsList(futures).get();
			log.info("Stopped {} {} tenant beans: {}", 
					initializedTenantIds.size(), implClass.getSimpleName(), initializedTenantIds);
		} catch (InterruptedException | ExecutionException e) {
			throw new TenantException(e, "Cannot stop %s %s tenant beans: %s",
					tenantIdsToRemove.size(), implClass.getSimpleName(), tenantIdsToRemove);
		}
		
	}

}

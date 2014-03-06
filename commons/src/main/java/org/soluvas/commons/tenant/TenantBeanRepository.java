package org.soluvas.commons.tenant;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Nullable;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.CommonsException;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.env.Environment;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.eventbus.EventBus;

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
public abstract class TenantBeanRepository<T> implements TenantRepositoryListener {

	private final Logger log;
	/**
	 * Stores the currently managed tenant beans. 
	 */
	private final Map<String, T> beanMap = new LinkedHashMap<>();
	private Method initMethod;
	private Method destroyMethod;
	private final Class<? extends T> implClass;
	
	/**
	 * @param implClass Must be the implementation class, because {@code init()} and {@code destroy()}
	 * 		will only be scanned once on this class.
	 * @param initialTenantMap
	 * @param appEventBus
	 */
	public TenantBeanRepository(Class<? extends T> implClass, Map<String, AppManifest> initialTenantMap, EventBus appEventBus,
			@Nullable TenantRepository<?> tenantRepo) {
		super();
		this.implClass = implClass;
		log = LoggerFactory.getLogger(TenantBeanRepository.class.getName() + "/" + implClass.getSimpleName());
		
		try {
			initMethod = implClass.getMethod("init");
		} catch (NoSuchMethodException e) {
		} catch (SecurityException e) {
			throw new CommonsException("Cannot probe class " + implClass.getName(), e);
		}
		try {
			implClass.getMethod("destroy");
		} catch (NoSuchMethodException e) {
		} catch (SecurityException e) {
			throw new CommonsException("Cannot probe class " + implClass.getName(), e);
		}
		log.info("Lifecycle methods for {}: init={} destroy={}",
				implClass.getSimpleName(), initMethod, destroyMethod);
		
		log.info("Initializing {} {} tenant beans: {}", 
				initialTenantMap.size(), implClass.getSimpleName(), initialTenantMap.keySet());
		for (final Map.Entry<String, AppManifest> tenant : initialTenantMap.entrySet()) {
			final String tenantId = tenant.getKey();
			createAndPut(tenantId, tenant.getValue());
		}
		
		if (tenantRepo != null) {
			tenantRepo.addListener(this);
		}
	}
	
	@PreDestroy
	public synchronized void destroy() {
		final ImmutableList<String> tenantIdsRev = ImmutableList.copyOf(beanMap.keySet()).reverse();
		log.info("Shutting down {} {} beans in reverse order: {}",
				beanMap.size(), implClass.getSimpleName(), tenantIdsRev);
		for (String tenantId : tenantIdsRev) {
			removeAndDestroy(tenantId);
		}
	}
	
	protected synchronized final void createAndPut(String tenantId, AppManifest appManifest) {
		try {
			log.debug("Initializing '{}' {} {}",
					tenantId, implClass.getSimpleName(), initMethod != null ? "using init method " + initMethod : "without init method");
			final T bean = create(tenantId, appManifest);
			if (initMethod != null) {
				initMethod.invoke(bean);
			}
			beanMap.put(tenantId, bean);
			onCreated(tenantId, appManifest, bean);
		} catch (Exception e) {
			throw new CommonsException("Cannot initialize " + implClass.getSimpleName() + " bean for '" + tenantId + "'", e);
		}
	}
	
	protected synchronized final void removeAndDestroy(String tenantId) {
		try {
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
		} catch (Exception e) {
			throw new CommonsException("Cannot destroy " + implClass.getSimpleName() + " bean for '" + tenantId + "'", e);
		}
	}
	
	/**
	 * Creates the bean for the specified tenant, do <strong>not</strong> call {@code init()},
	 * {@link TenantBeanRepository} will call it.
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
	 * Returns an {@link ImmutableMap} copy of the current state.
	 * If used within a Spring {@link Configurable}, make sure to use {@code prototype} scope.
	 * 
	 * @return
	 */
	public ImmutableMap<String, T> immutableCopy() {
		return ImmutableMap.copyOf(beanMap);
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
	
	@Override
	public void onTenantsStarting(TenantsStarting starting) throws Exception {
		for (final Map.Entry<String, AppManifest> entry : starting.getAddeds().entrySet()) {
			final String tenantId = entry.getKey();
			final AppManifest appManifest = entry.getValue();
			createAndPut(tenantId, appManifest);
		}
	}
	
	@Override
	public void onTenantsStopping(TenantsStopping stopping) throws Exception {
		for (final Map.Entry<String, AppManifest> entry : stopping.getTenants().entrySet()) {
			final String tenantId = entry.getKey();
			final AppManifest appManifest = entry.getValue();
			removeAndDestroy(tenantId);
		}
	}

}

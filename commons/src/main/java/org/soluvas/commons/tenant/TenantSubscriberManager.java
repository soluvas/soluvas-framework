package org.soluvas.commons.tenant;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.CommonsException;
import org.soluvas.commons.config.MultiTenantConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.eventbus.EventBus;

/**
 * Manages tenant {@link EventBus} subscribers.
 * <p>Note: Make sure you mark your {@link Bean} as {@link Lazy}=false.
 * @author ceefour
 */
public abstract class TenantSubscriberManager {
	
	final Map<String, List<Object>> subscriberMap = new LinkedHashMap<>();
	private final MultiTenantConfig tenantConfig;
	private static final Logger log = LoggerFactory
			.getLogger(TenantSubscriberManager.class);

	public TenantSubscriberManager(MultiTenantConfig tenantConfig) {
		super();
		this.tenantConfig = tenantConfig;
		final ImmutableMap<String, AppManifest> initialTenantMap = tenantConfig.tenantMap();
		for (final Map.Entry<String, AppManifest> tenant : initialTenantMap.entrySet()) {
			createSubscribers(tenant.getKey(), tenant.getValue());
		}
	}
	
	@PreDestroy
	public synchronized void destroy() throws IOException {
		final ImmutableList<String> tenantIdsRev = ImmutableList.copyOf(subscriberMap.keySet()).reverse();
		log.info("Shutting down EventBus subscribers for {} tenants in reverse order: {}",
				subscriberMap.size(), tenantIdsRev);
		for (String tenantId : tenantIdsRev) {
			unsubscribeTenant(tenantId);
		}
	}
	
	protected synchronized final void createSubscribers(String tenantId, AppManifest appManifest) {
		try {
			final List<?> subscribers = onReady(tenantId, appManifest);
			log.info("Subscribing {} objects to '{}' EventBus: {}",
					subscribers.size(), tenantId, subscribers);
			final EventBus tenantEventBus = tenantConfig.eventBusMap().get(tenantId);
			subscriberMap.put(tenantId, ImmutableList.copyOf(subscribers));
			for (Object subscriber : subscribers) {
				tenantEventBus.register(subscriber);
			}
		} catch (Exception e) {
			throw new CommonsException("Cannot create EventBus subscribers for tenant '" + tenantId + "'", e);
		}
	}
	
	protected synchronized final void unsubscribeTenant(String tenantId) throws IOException {
		final EventBus tenantEventBus = tenantConfig.eventBusMap().get(tenantId);
		final List<Object> subscribers = subscriberMap.get(tenantEventBus);
		log.info("Unsubscribing {} objects from '{}' EventBus: {}",
				subscribers.size(), tenantId, subscribers);
		for (Object subscriber : subscribers) {
			tenantEventBus.unregister(subscriber);
		}
		subscriberMap.remove(tenantId);
	}
	
	/**
	 * Called when tenant {@link EventBus} is ready for subscribers.
	 * @param tenantId
	 * @param appManifest 
	 * @return List of subscribers to {@link EventBus#register(Object)}, they'll be automatically
	 * 		{@link EventBus#unregister(Object)}-ed when the tenant is removed.
	 */
	protected abstract List<?> onReady(String tenantId, AppManifest appManifest) throws Exception;

}

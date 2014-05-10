package org.soluvas.commons.tenant;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.config.MultiTenantConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.eventbus.EventBus;

/**
 * Manages tenant {@link EventBus} subscribers.
 * <p>Note: Make sure you mark your {@link Bean} as {@link Lazy}=false.
 * @author ceefour
 */
public abstract class TenantSubscribers implements TenantRepositoryListener {
	
	final Map<String, List<Object>> subscriberMap = new LinkedHashMap<>();
	private static final Logger log = LoggerFactory
			.getLogger(TenantSubscribers.class);
	
	@Inject
	private MultiTenantConfig tenantConfig;
	@Inject
	private TenantRepository<?> tenantRepo;

	@PostConstruct
	public void init() {
		final ImmutableMap<String, AppManifest> initialTenantMap = tenantConfig.tenantMap();
		for (final Map.Entry<String, AppManifest> tenant : initialTenantMap.entrySet()) {
			createSubscribers(tenant.getKey(), tenant.getValue(), "Init");
		}
		tenantRepo.addListener(this);
	}
	
	@PreDestroy
	public void destroy() throws IOException {
		final ImmutableList<String> tenantIdsRev = ImmutableList.copyOf(subscriberMap.keySet()).reverse();
		log.info("Shutting down EventBus subscribers for {} tenants in reverse order: {}",
				subscriberMap.size(), tenantIdsRev);
		for (String tenantId : tenantIdsRev) {
			unsubscribeTenant(tenantId, "Shutdown");
		}
	}
	
	protected synchronized final void createSubscribers(String tenantId, AppManifest appManifest, String reason) {
		@Nullable
		final List<Object> existing = subscriberMap.get(tenantId);
		Preconditions.checkState(existing == null,
				"Cannot recreate subscribers for '%s' with %s existing subscribers", 
				tenantId, existing != null ? existing.size() : null);
		try {
			final List<?> subscribers = onReady(tenantId, appManifest);
			log.info("Subscribing {} objects to '{}' EventBus: {}. Reason: {}",
					subscribers.size(), tenantId, subscribers, reason);
			final EventBus tenantEventBus = tenantConfig.eventBusMap().get(tenantId);
			subscriberMap.put(tenantId, ImmutableList.copyOf(subscribers));
			for (Object subscriber : subscribers) {
				tenantEventBus.register(subscriber);
			}
		} catch (Exception e) {
			throw new TenantException("Cannot create EventBus subscribers for tenant '" + tenantId + "' reason " +
					reason + ".", e);
		}
	}
	
	protected synchronized final void unsubscribeTenant(String tenantId, String reason) throws IOException {
		final EventBus tenantEventBus = tenantConfig.eventBusMap().get(tenantId);
		final List<Object> subscribers = subscriberMap.get(tenantEventBus);
		log.info("Unsubscribing {} objects from '{}' EventBus: {}. Reason: {}",
				subscribers.size(), tenantId, subscribers, reason);
		for (Object subscriber : subscribers) {
			tenantEventBus.unregister(subscriber);
		}
		Preconditions.checkNotNull(subscriberMap.remove(tenantId),
				"subscriberMap for '%s' was null. Never subscribed?", tenantId);
	}
	
	@Override
	public void onTenantsStarting(TenantsStarting starting) throws Exception {
		for (final Map.Entry<String, AppManifest> tenant : starting.getAddeds().entrySet()) {
			createSubscribers(tenant.getKey(), tenant.getValue(),
					"TenantsStarting " + starting.getTrackingId());
		}
	}
	
	@Override
	public void onTenantsStopping(TenantsStopping stopping) throws Exception {
		for (final String tenantId : stopping.getTenants().keySet()) {
			unsubscribeTenant(tenantId, "TenantsStopping " + stopping.getTrackingId());
		}
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

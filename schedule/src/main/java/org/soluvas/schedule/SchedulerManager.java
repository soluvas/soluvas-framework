package org.soluvas.schedule;

import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;

/**
 * Manages collections of module-specific tenant-aware map of {@link Scheduler}s.
 * It is needed to provide unified support of {@link Scheduler}s (e.g. shell commands)
 * in a flexible/modular way.
 * @author ceefour
 */
@Deprecated
public class SchedulerManager {
	
	private static final Logger log = LoggerFactory
			.getLogger(SchedulerManager.class);
	
	final Map<String, Map<String, Scheduler>> moduleSchedulerMap = new ConcurrentHashMap<>();
	
	public Set<String> getModules() {
		return moduleSchedulerMap.keySet();
	}
	
	public Map<String, Scheduler> getSchedulerMap(String module) {
		return Preconditions.checkNotNull(moduleSchedulerMap.get(module),
				"Cannot get schedulerMap for module '%s', available modules are: %s",
				module, moduleSchedulerMap.keySet());
	}
	
	/**
	 * Return tenant-specific {@link Scheduler}s.
	 * @param tenantId
	 * @return Key is module name.
	 */
	public Map<String, Scheduler> getTenantSchedulers(final String tenantId) {
		final ImmutableMap.Builder<String, Scheduler> tenantSchedulerMapBuilder = ImmutableMap.builder();
		for (final Entry<String, Map<String, Scheduler>> moduleEntry : moduleSchedulerMap.entrySet()) {
			for (final Entry<String, Scheduler> tenantEntry : moduleEntry.getValue().entrySet()) {
				final String schedulerTenantId = tenantEntry.getKey();
				if (tenantId.equals(schedulerTenantId)) {
					final String schedulerModule = moduleEntry.getKey();
					tenantSchedulerMapBuilder.put(schedulerModule, tenantEntry.getValue());
				}
			}
		}
		return tenantSchedulerMapBuilder.build();
	}
	
	/**
	 * Get a specific {@link Scheduler}.
	 * @param tenantId
	 * @param namespace
	 * @throws NoSuchElementException If it's not found.
	 * @return
	 */
	public Scheduler getScheduler(final String tenantId, final String namespace) {
		final Map<String, Scheduler> tenantSchedulers = moduleSchedulerMap.get(namespace);
		if (tenantSchedulers == null) {
			throw new NoSuchElementException("Unrecognized scheduler namespace: " + namespace);
		}
		final Scheduler scheduler = tenantSchedulers.get(tenantId);
		if (scheduler == null) {
			throw new NoSuchElementException("Cannot find '" + namespace + "' scheduler for tenant '" + tenantId + "'");
		}
		return scheduler;
	}
	
	public void register(String module, Map<String, Scheduler> schedulerMap) {
		log.info("Registering SchedulerMap for module '{}' ({} tenants: {})", 
				module, schedulerMap.size(), Iterables.limit(schedulerMap.keySet(), 10));
		Preconditions.checkState(!moduleSchedulerMap.containsKey(module),
				"SchedulerMap for module '%s' already exists", module);
		moduleSchedulerMap.put(module, schedulerMap);
	}

	public void unregister(String module) {
		final Map<String, Scheduler> schedulerMap = moduleSchedulerMap.get(module);
		if (schedulerMap != null) {
			log.info("Unregistering SchedulerMap for module '{}' ({} tenants: {})", 
					module, schedulerMap.size(), Iterables.limit(schedulerMap.keySet(), 10));
			moduleSchedulerMap.remove(module);
		} else {
			log.info("Not unregistering non-registered SchedulerMap for module '{}'", module);
		}
	}
	
}

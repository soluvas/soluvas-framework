package org.soluvas.commons.tenant;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nullable;
import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.CommonsException;
import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.OnDemandXmiLoader;
import org.soluvas.commons.ResourceType;
import org.soluvas.commons.config.DirectorySourcedConfig;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.eventbus.EventBus;

/**
 * Reads list of tenants from a filesystem folder, e.g. {@code $HOME}.
 * @author ceefour
 * @see DirectorySourcedConfig
 */
public class DirectoryTenantRepository<T> implements TenantRepository<T> {

	private static final Logger log = LoggerFactory
			.getLogger(DirectoryTenantRepository.class);
	
	/**
	 * Whitelisted tenant IDs.
	 * Without whitelisting, all readable tenants will be loaded.
	 */
	@Nullable
	final ImmutableSet<String> whitelist;
	private final File rootDir;
	private final String tenantEnv;
	private final LinkedHashMap<String, AppManifest> tenantMap = new LinkedHashMap<>();
	private final LinkedHashMap<String, TenantState> tenantStateMap = new LinkedHashMap<>();
	/**
	 * If {@link AppManifest#getDomain()} uses a relative domain name, e.g. "dietyuk.{+appDomain}", the tenant's
	 * domain name will be completed using the {@code appDomain}. 
	 */
	private final String appDomain;
	private final EventBus appEventBus;
	@Nullable
	private final TenantProvisioner<T> provisioner;
	private final List<TenantRepositoryListener> listeners = new ArrayList<>();
	
	/**
	 * @param tenantEnv
	 * @param appDomain If {@link AppManifest#getDomain()} uses a relative domain name, e.g. "dietyuk.{+appDomain}", the tenant's
	 * 		domain name will be completed using the {@code appDomain}.
	 * @param rootDir
	 * @throws IOException
	 */
	public DirectoryTenantRepository(EventBus appEventBus, String tenantEnv, String appDomain, File rootDir,
			@Nullable TenantProvisioner<T> provisioner) throws IOException {
		super();
		this.appEventBus = appEventBus;
		this.tenantEnv = tenantEnv;
		this.appDomain = appDomain;
		this.rootDir = rootDir;
		this.provisioner = provisioner;
		this.whitelist = null;
		init();
	}

	/**
	 * @param tenantEnv
	 * @param appDomain If {@link AppManifest#getDomain()} uses a relative domain name, e.g. "dietyuk.{+appDomain}", the tenant's
	 * 		domain name will be completed using the {@code appDomain}.
	 * @param rootDir
	 * @param whitelist
	 * @throws IOException
	 */
	public DirectoryTenantRepository(EventBus appEventBus, String tenantEnv, String appDomain, File rootDir, 
			@Nullable TenantProvisioner<T> provisioner, Set<String> whitelist) throws IOException {
		super();
		this.appEventBus = appEventBus;
		this.tenantEnv = tenantEnv;
		this.appDomain = appDomain;
		this.rootDir = rootDir;
		this.provisioner = provisioner;
		this.whitelist = ImmutableSet.copyOf(whitelist);
		log.info("Using whitelist of {} tenants: {}", whitelist.size(), Iterables.limit(whitelist, 10));
		init();
	}
	
	@PostConstruct
	protected void init() throws IOException {
		final String fqdn;
		try {
			fqdn = InetAddress.getLocalHost().getCanonicalHostName();
		} catch (UnknownHostException e) {
			throw new CommonsException("Cannot get FQDN", e);
		}
		Preconditions.checkState(!Strings.isNullOrEmpty(fqdn), "Invalid FQDN: empty. Check your host OS's configuration.");

		final String pattern = String.format("file://%s/*/model/*_%s.AppManifest.xmi", rootDir, tenantEnv);
		log.debug("Searching tenant AppManifests for fqdn={} appDomain={} using '{}'...", fqdn, appDomain, pattern);
		final Resource[] resources = new PathMatchingResourcePatternResolver(DirectoryTenantRepository.class.getClassLoader())
			.getResources(pattern);
		log.debug("Found {} AppManifests: {}", resources.length, Iterables.limit(ImmutableList.copyOf(resources), 10));
		final Pattern appManifestXmiPattern = Pattern.compile("([^_]+)\\_" + tenantEnv + "\\.AppManifest\\.xmi");
		
		for (final Resource res : resources) {
			final String filename = res.getFilename();
			final Matcher matcher = appManifestXmiPattern.matcher(filename);
			if (!matcher.matches()) {
				log.error("AppManifest.xmi file '{}' (from '{}') does not match pattern: [tenantId]_{}.AppManifest.xmi", filename, res.getFile(), tenantEnv);
				continue;
			}
			final String tenantId = matcher.group(1);
			
			if (whitelist != null && !whitelist.contains(tenantId)) {
				log.info("Skipped tenant '{}' because not in whitelist.", tenantId);
				continue;
			}
			
			log.info("Loading {} AppManifest resources from classpath: {}", resources.length, resources);
			final Pattern tenantIdPattern = Pattern.compile("([^.]+).+");
			
			final ImmutableMap<String, String> scope = ImmutableMap.of(
					"fqdn", fqdn, "appDomain", appDomain);
			final AppManifest tenantManifest = new OnDemandXmiLoader<AppManifest>(
					CommonsPackage.eINSTANCE, res.getURL(), ResourceType.CLASSPATH, scope).get();
			
			tenantMap.put(tenantId, tenantManifest);
			tenantStateMap.put(tenantId, TenantState.ACTIVE);
		}
		
		log.info("Loaded {} initial tenants from '{}': {}", tenantMap.size(), rootDir, Iterables.limit(tenantMap.keySet(), 10));
	}
	
	public String getTenantEnv() {
		return tenantEnv;
	}
	
	public String getAppDomain() {
		return appDomain;
	}
	
	public File getRootDir() {
		return rootDir;
	}
	
	@Nullable
	public ImmutableSet<String> getWhitelist() {
		return whitelist;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.commons.tenant.TenantRepository#findAll()
	 */
	@Override
	public ImmutableMap<String, AppManifest> findAll() {
		return ImmutableMap.copyOf(tenantMap);
	}

	@Override
	public AppManifest newBlank() {
		final AppManifest appManifest = CommonsFactory.eINSTANCE.createAppManifest();
		return appManifest;
	}

	@Override
	public synchronized AppManifest add(String tenantId, AppManifest appManifest, T provisionData, String trackingId) {
		Preconditions.checkState(whitelist == null,
				"Cannot add tenant on whitelisting repository");
		Preconditions.checkArgument(!tenantMap.containsKey(tenantId),
				"Cannot add existing tenant '%s'. %s existing tenants: %s",
				tenantId, tenantMap.size(), tenantMap.keySet());
		provisioner.add(tenantId, appManifest, provisionData, trackingId);
		tenantMap.put(tenantId, appManifest);
		start(tenantId, appManifest, trackingId);
		return appManifest;
	}

	@Override
	public synchronized AppManifest modify(String tenantId, AppManifest appManifest) {
		throw new UnsupportedOperationException();
	}

	@Override
	public synchronized boolean delete(String tenantId) {
		Preconditions.checkState(whitelist == null,
				"Cannot delete tenant on whitelisting repository");
		final AppManifest appManifest = Preconditions.checkNotNull(tenantMap.get(tenantId),
				"Tenant '%s' not found. %s existing tenants: %s",
				tenantId, tenantMap.size(), tenantMap.keySet());
		stop(tenantId, appManifest, null);
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Starts a tenant.
	 * @param tenantId
	 * @param appManifest
	 */
	protected final void start(String tenantId, AppManifest appManifest, String trackingId) {
		tenantStateMap.put(tenantId, TenantState.STARTING);
		final ImmutableMap<String, AppManifest> addeds = ImmutableMap.of(tenantId, appManifest);
//		appEventBus.post(new TenantsStarting(addeds, trackingId));
		final TenantsStarting tenantsStarting = new TenantsStarting(addeds, trackingId);
		for (final TenantRepositoryListener listener : listeners) {
			try {
				listener.onTenantsStarting(tenantsStarting);
			} catch (Exception e) {
				throw new CommonsException("Cannot start tenant '" + tenantId + "' due to failed listener '" + listener + "'", e);
			}
		}
		tenantStateMap.put(tenantId, TenantState.ACTIVE);
	}
	
	/**
	 * Calls {@link #onBeforeStop(String, AppManifest)}.
	 * @param tenantId
	 * @param appManifest
	 * @param trackingId TODO
	 */
	protected final void stop(String tenantId, AppManifest appManifest, String trackingId) {
		tenantStateMap.put(tenantId, TenantState.STOPPING);
		onBeforeStop(tenantId, appManifest);
		final TenantsStopping tenantsStopping = new TenantsStopping(ImmutableMap.of(tenantId, appManifest), trackingId);
		for (final TenantRepositoryListener listener : listeners) {
			try {
				listener.onTenantsStopping(tenantsStopping);
			} catch (Exception e) {
				throw new CommonsException("Cannot stop tenant '" + tenantId + "' due to failed listener '" + listener + "'", e);
			}
		}
		tenantStateMap.put(tenantId, TenantState.RESOLVED);
	}
	
	/**
	 * Hook method called before stop. Useful to stop repositories, release resources, etc.
	 * @param tenantId
	 * @param appManifest
	 */
	protected void onBeforeStop(String tenantId, AppManifest appManifest) {
	}

	@Override
	public T newProvisionData() {
		return provisioner.newProvisionData();
	}
	
	@Override
	public void addListener(TenantRepositoryListener listener) {
		log.info("Adding TenantRepository listener #{} {}", listeners.size() + 1, listener);
		listeners.add(listener);
	}

	@Override
	public synchronized void start(Set<String> tenantIds) {
		for (final String tenantId : tenantIds) {
			final AppManifest appManifest = tenantMap.get(tenantId);
			Preconditions.checkArgument(appManifest != null, "Tenant '%s' not found, %s available: %s",
					tenantId, tenantMap.size(), tenantMap.keySet());
			final TenantState state = tenantStateMap.get(tenantId);
			Preconditions.checkArgument(appManifest != null, "Tenant state for '%s' not found, %s available: %s",
					tenantId, tenantStateMap.size(), tenantStateMap.keySet());
			if (state == TenantState.RESOLVED) {
				start(tenantId, appManifest, null);
			} else {
				log.info("Not starting tenant '{}' because it is in {} state", tenantId, state);
			}
		}
	}

	@Override
	public synchronized void stop(Set<String> tenantIds) {
		for (final String tenantId : tenantIds) {
			final AppManifest appManifest = tenantMap.get(tenantId);
			Preconditions.checkArgument(appManifest != null, "Tenant '%s' not found, %s available: %s",
					tenantId, tenantMap.size(), tenantMap.keySet());
			final TenantState state = tenantStateMap.get(tenantId);
			Preconditions.checkArgument(appManifest != null, "Tenant state for '%s' not found, %s available: %s",
					tenantId, tenantStateMap.size(), tenantStateMap.keySet());
			if (state == TenantState.ACTIVE) {
				stop(tenantId, appManifest, null);
			} else {
				log.info("Not starting tenant '{}' because it is in {} state", tenantId, state);
			}
		}
	}

	@Override
	public ImmutableMap<String, TenantState> getStates() {
		return ImmutableMap.copyOf(tenantStateMap);
	}
	
}

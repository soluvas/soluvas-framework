package org.soluvas.commons.tenant;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nullable;
import javax.annotation.PostConstruct;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryBuilder;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.transport.PushResult;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.CommonsException;
import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.EmfUtils;
import org.soluvas.commons.OnDemandXmiLoader;
import org.soluvas.commons.ResourceType;
import org.soluvas.commons.config.DirectorySourcedConfig;
import org.soluvas.commons.util.GitUtils;
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
public class DirectoryTenantRepository<T extends ProvisionData> implements TenantRepository<T> {

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

		final String pattern = String.format("file://%s/*/model/*.AppManifest.xmi", rootDir);
		log.debug("Searching tenant AppManifests for fqdn={} appDomain={} using '{}'...", fqdn, appDomain, pattern);
		final Resource[] resources = new PathMatchingResourcePatternResolver(DirectoryTenantRepository.class.getClassLoader())
			.getResources(pattern);
		log.debug("Found {} AppManifests: {}", resources.length, Iterables.limit(ImmutableList.copyOf(resources), 10));
		final Pattern appManifestXmiPattern = Pattern.compile("([^_]+).*\\.AppManifest\\.xmi");
		
		final String appManifestTemplatePath = "/META-INF/template.AppManifest.xmi";
		@Nullable
		final URL appManifestTemplate = DirectoryTenantRepository.class.getResource(appManifestTemplatePath);
		
		for (final Resource res : resources) {
			final String filename = res.getFilename();
			final Matcher matcher = appManifestXmiPattern.matcher(filename);
			if (!matcher.matches()) {
				log.error("AppManifest.xmi file '{}' (from '{}') does not match pattern: [tenantId]*.AppManifest.xmi", filename, res.getFile(), tenantEnv);
				continue;
			}
			final String tenantId = matcher.group(1);
			
			if (whitelist != null && !whitelist.contains(tenantId)) {
				log.info("Skipped tenant '{}' because not in whitelist.", tenantId);
				continue;
			}
			
			final ImmutableMap<String, String> scope = ImmutableMap.of(
					"tenantId", tenantId, "fqdn", fqdn, "appDomain", appDomain, "userName", System.getProperty("user.name"));
			
			final AppManifest appManifest;
			if (appManifestTemplate != null) {
				log.info("Combining template AppManifest '{}' with customized '{}'", appManifestTemplate, res.getFile());
				appManifest = new OnDemandXmiLoader<AppManifest>(CommonsPackage.eINSTANCE, appManifestTemplate, ResourceType.CLASSPATH, scope).get();
			} else {
				log.info("No template AppManifest found from classpath '{}', only loading AppManifest from '{}'", appManifestTemplatePath, res.getFile());
				appManifest = CommonsFactory.eINSTANCE.createAppManifest();
			}
			final AppManifest overlay = new OnDemandXmiLoader<AppManifest>(
					CommonsPackage.eINSTANCE, res.getFile(), scope).get();
			EmfUtils.combineEObject(appManifest, overlay);
			
			// env file is usually used to override domain and generalEmail in stg/prd environments
			final File envFile = new File(rootDir, tenantId + "/etc/" + tenantId + "_" + tenantEnv + ".AppManifest.xmi");
			if (envFile.exists()) {
				log.info("Combining with env '{}' specific AppManifest file '{}'", tenantEnv, envFile);				
				final AppManifest envManifest = new OnDemandXmiLoader<AppManifest>(CommonsPackage.eINSTANCE, envFile, scope).get();
				EmfUtils.combineEObject(appManifest, envManifest);
			}
			
			tenantMap.put(tenantId, appManifest);
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
		Preconditions.checkState(!Strings.isNullOrEmpty(tenantId), "TenantID must not be null or empty.");
		Preconditions.checkState(tenantMap.containsKey(tenantId), "Tenant ID %s is not provided", tenantId);
		Preconditions.checkNotNull(appManifest, "App Manifest tenantID %s must not be null.", tenantId);
		
		/*Write appManifest to file and Reload/Update to memory*/
		final ResourceSetImpl rSet = new ResourceSetImpl();
		rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		rSet.getPackageRegistry().put(CommonsPackage.eNS_URI, CommonsPackage.eINSTANCE);
		final File file = new File(URI.createURI(tenantMap.get(tenantId).getResourceUri()).path());
		final org.eclipse.emf.ecore.resource.Resource res = rSet.createResource(URI.createFileURI(file.getPath()));
		appManifest.setResourceName(tenantMap.get(tenantId).getResourceName());
		appManifest.setResourceUri(tenantMap.get(tenantId).getResourceUri());
		appManifest.setResourceType(tenantMap.get(tenantId).getResourceType());
		res.getContents().add(EcoreUtil.copy(appManifest));
		try {
			res.save(ImmutableMap.of(XMIResource.OPTION_LINE_WIDTH, 80,
					XMIResource.OPTION_DECLARE_XML, true,
					XMIResource.OPTION_ENCODING, "UTF-8"));
			res.unload();
			tenantMap.put(tenantId, appManifest);
		} catch (IOException e) {
			throw new RuntimeException(String.format("Cannot save %s XMI file %s", tenantId, file), e);
		}
		
		/*Commit + Pull + Push*/
		cpp(file);
		
		return tenantMap.get(tenantId);
	}
	
	protected void cpp(final File file) {
		GitUtils.disableStrictHostKeyChecking();
		
		try {
			final Repository gitRepo = new RepositoryBuilder().findGitDir(file).setMustExist(true).build();
			final Git git = new Git(gitRepo);
			try {
				//Commit
				log.debug("Commiting {} in {}", file, gitRepo);
				final String message = "Changed App Manifest at " + new DateTime();
				final RevCommit revCommit = git.commit().setAll(true).setMessage(message).call();
				log.info("Committed '{}' as {} in {}", message, revCommit, gitRepo);
				//Pull
				log.debug("Pulling {} due to '{}'", gitRepo, message);
				final PullResult pullResult = git.pull().call();
				// FetchResult doesn't have proper toString()
				final String fetchResult = pullResult.getFetchResult() != null ? pullResult.getFetchResult().getTrackingRefUpdates() + " from " + pullResult.getFetchResult().getURI() : null;
				log.info("Pulled {} from {}. Fetch: {}. Merge: {}.", gitRepo, pullResult.getFetchedFrom(), fetchResult,
						pullResult.getMergeResult());
				// push: MUST set default remote AND branch
				log.debug("Pushing {} due to '{}'", gitRepo, message);
				final Iterable<PushResult> pushResults = git.push().call();
				log.info("Pushed {}: {}", gitRepo, pushResults);
			} catch (Exception e) {
				throw new RuntimeException(String.format("Cannot cpp '%s' to Git repository: %s", file), e);
			}
		} catch (IOException e) {
			throw new RuntimeException(String.format("Can not get Git Repository for %s", file, e));
		}
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
				throw new CommonsException("Cannot start tenant '" + tenantId + "' due to failed listener '" + listener + "': " + e, e);
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
				throw new CommonsException("Cannot stop tenant '" + tenantId + "' due to failed listener '" + listener + "': " + e, e);
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

	@Override
	public AppManifest lookupOne(String tenantId)
			throws IllegalArgumentException {
		final AppManifest appManifest = tenantMap.get(tenantId);
		Preconditions.checkArgument(appManifest != null, "Tenant '%s' not found, %s available: %s",
				tenantId, tenantMap.size(), tenantMap.keySet());
		return appManifest;
	}

	@Override
	public boolean exists(String tenantId) throws IllegalArgumentException {
		Preconditions.checkState(!Strings.isNullOrEmpty(tenantId), "TenantID must not be null or empty");
		final AppManifest appManifest = tenantMap.get(tenantId);
		return appManifest != null;
	}
	
}

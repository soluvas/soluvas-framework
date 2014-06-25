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
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nullable;
import javax.annotation.PostConstruct;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.EmfUtils;
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
import com.google.common.collect.Lists;
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
	private final AtomicBoolean listenersLocked = new AtomicBoolean();
	
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
			throw new TenantException("Cannot get FQDN", e);
		}
		Preconditions.checkState(!Strings.isNullOrEmpty(fqdn), "Invalid FQDN: empty. Check your host OS's configuration.");

		final String pattern = String.format("file://%s/*/model/*.AppManifest.xmi", rootDir);
		log.debug("Searching tenant AppManifests for fqdn={} appDomain={} using '{}'...", fqdn, appDomain, pattern);
		final Resource[] resources = new PathMatchingResourcePatternResolver(DirectoryTenantRepository.class.getClassLoader())
			.getResources(pattern);
		log.debug("Found {} AppManifests: {}", resources.length, Iterables.limit(ImmutableList.copyOf(resources), 10));
		final Pattern appManifestXmiPattern = Pattern.compile("([^_]+).*\\.AppManifest\\.xmi");
		
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
			
			final AppManifest appManifest = combineAppManifest(tenantId, res.getFile()); 
			
			tenantMap.put(tenantId, appManifest);
			tenantStateMap.put(tenantId, TenantState.ACTIVE);
		}
		
		log.info("Loaded {} initial tenants from '{}': {}", tenantMap.size(), rootDir, Iterables.limit(tenantMap.keySet(), 10));
	}
	
	private AppManifest combineAppManifest(String tenantId, AppManifest upAppManifest) {
		final String fqdn;
		try {
			fqdn = InetAddress.getLocalHost().getCanonicalHostName();
		} catch (UnknownHostException e) {
			throw new TenantException("Cannot get FQDN", e);
		}
		Preconditions.checkState(!Strings.isNullOrEmpty(fqdn), "Invalid FQDN: empty. Check your host OS's configuration.");
		
		final String appManifestTemplatePath = "/META-INF/template.AppManifest.xmi";
		@Nullable
		final URL appManifestTemplate = DirectoryTenantRepository.class.getResource(appManifestTemplatePath);

		final AppManifest appManifest;
		if (appManifestTemplate != null) {
			log.info("Combining template AppManifest '{}' with customized", appManifestTemplate);
			appManifest = new OnDemandXmiLoader<AppManifest>(CommonsPackage.eINSTANCE, appManifestTemplate, ResourceType.CLASSPATH)
					.autoExpand(false).get();
		} else {
			log.info("No template AppManifest found from classpath '{}', only loading customized AppManifest", appManifestTemplatePath);
			appManifest = CommonsFactory.eINSTANCE.createAppManifest();
		}
		EmfUtils.combineEObject(appManifest, upAppManifest);

		final ImmutableMap<String, Object> scope = ImmutableMap.<String, Object>of(
				"tenantId", tenantId, "tenantEnv", tenantEnv,
				"fqdn", fqdn, "appDomain", appDomain, "userName", System.getProperty("user.name"));
		try {
			appManifest.expand(scope);
		} catch (Exception e) {
			throw new TenantException(e, "Cannot expand '%s' AppManifest: %s", tenantId, e);
		}

		// NO LONGER SUPPORTED: please use single AppManifest for all environments, use domain{env} and generalEmail{env} properties now
		// env file is usually used to override domain and generalEmail in stg/prd environments
//		final File envFile = new File(rootDir, tenantId + "/etc/" + tenantId + "_" + tenantEnv + ".AppManifest.xmi");
//		if (envFile.exists()) {
//			log.info("Combining with env '{}' specific AppManifest file '{}'", tenantEnv, envFile);				
//			final AppManifest envManifest = new OnDemandXmiLoader<AppManifest>(CommonsPackage.eINSTANCE, envFile, scope).get();
//			EmfUtils.combineEObject(appManifest, envManifest);
		
		return appManifest;
	}
	
	private AppManifest combineAppManifest(String tenantId, File customized) {
		final String fqdn;
		try {
			fqdn = InetAddress.getLocalHost().getCanonicalHostName();
		} catch (UnknownHostException e) {
			throw new TenantException("Cannot get FQDN", e);
		}
		Preconditions.checkState(!Strings.isNullOrEmpty(fqdn), "Invalid FQDN: empty. Check your host OS's configuration.");
		
		final String appManifestTemplatePath = "/META-INF/template.AppManifest.xmi";
		@Nullable
		final URL appManifestTemplate = DirectoryTenantRepository.class.getResource(appManifestTemplatePath);

		final AppManifest appManifest;
		if (appManifestTemplate != null) {
			log.info("Combining template AppManifest '{}' with customized '{}'", appManifestTemplate, customized);
			appManifest = new OnDemandXmiLoader<AppManifest>(CommonsPackage.eINSTANCE, appManifestTemplate, ResourceType.CLASSPATH)
					.autoExpand(false).get();
		} else {
			log.info("No template AppManifest found from classpath '{}', only loading customized AppManifest from '{}'",
					appManifestTemplatePath, customized);
			appManifest = CommonsFactory.eINSTANCE.createAppManifest();
		}
		
		final AppManifest upAppManifest = new OnDemandXmiLoader<AppManifest>(CommonsPackage.eINSTANCE, customized).autoExpand(false).get();
		EmfUtils.combineEObject(appManifest, upAppManifest);
		
		final ImmutableMap<String, Object> scope = ImmutableMap.<String, Object>of(
				"tenantId", tenantId, "tenantEnv", tenantEnv,
				"fqdn", fqdn, "appDomain", appDomain, "userName", System.getProperty("user.name"));
		try {
			appManifest.expand(scope);
		} catch (Exception e) {
			throw new TenantException(e, "Cannot expand '%s' AppManifest using %s: %s", tenantId, scope, e);
		}

		// NO LONGER SUPPORTED: please use single AppManifest for all environments, use domain{env} and generalEmail{env} properties now
		// env file is usually used to override domain and generalEmail in stg/prd environments
//		final File envFile = new File(rootDir, tenantId + "/etc/" + tenantId + "_" + tenantEnv + ".AppManifest.xmi");
//		if (envFile.exists()) {
//			log.info("Combining with env '{}' specific AppManifest file '{}'", tenantEnv, envFile);				
//			final AppManifest envManifest = new OnDemandXmiLoader<AppManifest>(CommonsPackage.eINSTANCE, envFile, scope).get();
//			EmfUtils.combineEObject(appManifest, envManifest);
		
		return appManifest;
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
	public synchronized AppManifest add(String tenantId, AppManifest upAppManifest, T provisionData, String trackingId) {
		// create
		Preconditions.checkState(whitelist == null,
				"To dynamically add/remove tenants, please comment 'tenantWhitelist' in commerce.properties");
		Preconditions.checkArgument(!tenantMap.containsKey(tenantId),
				"Cannot add existing tenant '%s'. %s existing tenants: %s",
				tenantId, tenantMap.size(), tenantMap.keySet());
		provisioner.add(tenantId, upAppManifest, provisionData, trackingId);
		
		// load
		final AppManifest appManifest = combineAppManifest(tenantId, upAppManifest);
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
		final File file = new File(getRootDir(), tenantId + "/model/" + tenantId + ".AppManifest.xmi");
		final org.eclipse.emf.ecore.resource.Resource res = rSet.createResource(URI.createFileURI(file.getPath()));
		res.getContents().add(EcoreUtil.copy(appManifest));
		try {
			res.save(ImmutableMap.<String, Object>of(
					XMIResource.OPTION_LINE_WIDTH, 80,
					XMIResource.OPTION_DECLARE_XML, true,
					XMIResource.OPTION_ENCODING, "UTF-8",
					XMIResource.OPTION_SCHEMA_LOCATION, true));
			res.unload();
			tenantMap.put(tenantId, appManifest);
		} catch (IOException e) {
			throw new TenantException(String.format("Cannot save %s XMI file %s", tenantId, file), e);
		}
		
		/*Commit + Pull + Push*/
		provisioner.cpp(file);
		
		return tenantMap.get(tenantId);
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
		listenersLocked.set(true);
		try {
			for (final TenantRepositoryListener listener : listeners) {
				try {
					listener.onTenantsStarting(tenantsStarting);
				} catch (Exception e) {
					throw new TenantException("Cannot start tenant '" + tenantId + "' due to failed listener '" + listener + "': " + e, e);
				}
			}
			tenantStateMap.put(tenantId, TenantState.ACTIVE);
		} finally {
			listenersLocked.set(false);
		}
	}
	
	/**
	 * Calls {@link #onBeforeStop(String, AppManifest)} then calls {@link TenantRepositoryListener#onTenantsStopping(TenantsStopping)}
	 * for each {@link #listeners} <b>in reverse order</b>.
	 * @param tenantId
	 * @param appManifest
	 * @param trackingId Event Tracking ID.
	 */
	protected final void stop(String tenantId, AppManifest appManifest, String trackingId) {
		tenantStateMap.put(tenantId, TenantState.STOPPING);
		onBeforeStop(tenantId, appManifest);
		final TenantsStopping tenantsStopping = new TenantsStopping(ImmutableMap.of(tenantId, appManifest), trackingId);
		listenersLocked.set(true);
		try {
			for (final TenantRepositoryListener listener : Lists.reverse(listeners)) {
				try {
					listener.onTenantsStopping(tenantsStopping);
				} catch (Exception e) {
					throw new TenantException("Cannot stop tenant '" + tenantId + "' due to failed listener '" + listener + "': " + e, e);
				}
			}
			tenantStateMap.put(tenantId, TenantState.RESOLVED);
		} finally {
			listenersLocked.set(false);
		}
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
		Preconditions.checkState(!listenersLocked.get(),
				"Cannot add TenantRepository listener %s during start/stop. Please only add listeners during app initialization.",
				listener);
		if (listener instanceof TenantBeans) {
			log.info("Adding TenantRepository listener #{}: TenantBeans {}", listeners.size() + 1, listener);
		} else {
			log.info("Adding TenantRepository listener #{}: {}", listeners.size() + 1, listener);
		}
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

	/** (non-Javadoc)
	 * @see org.soluvas.commons.tenant.TenantRepository#lookupOne(java.lang.String)
	 * @deprecated Use {@link #getOriginal(String)} or {@link #getExpanded(String)}
	 */
	@Deprecated
	@Override
	public AppManifest lookupOne(String tenantId)
			throws IllegalArgumentException {
		return getExpanded(tenantId);
	}

	@Override
	public AppManifest getOriginal(String tenantId)
			throws IllegalArgumentException {
		final File appManifestFile = new File(rootDir, tenantId + "/model/" + tenantId + ".AppManifest.xmi");
		final AppManifest origAppManifest = new OnDemandXmiLoader<AppManifest>(CommonsPackage.eINSTANCE, appManifestFile)
				.autoExpand(false).get();
		return origAppManifest;
	}

	@Override
	public AppManifest getExpanded(String tenantId)
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

	@Override
	public boolean remove(Set<String> tenantIds) {
		stop(tenantIds);
		
		//remove tenant's dataDir
		for (final String tenantId : tenantIds) {
			final File tenantDataDir = new File(getRootDir(), tenantId);
			Preconditions.checkState(tenantDataDir.exists(), "Root Dir for %s must be exists.", tenantId);
			try {
				delete(tenantDataDir);
				log.info("Data dir. for tenant id {} has been removed", tenantId);
			} catch (IOException e) {
				log.error(String.format("Can not remove Data dir. for tenant id %s.", tenantId), e);
			}
			provisioner.cpp(tenantDataDir);
		}

		//remove tenant's database
		provisioner.removeDatabases(tenantIds);
		provisioner.removeSchemas(tenantIds);
		
		return false;
	}
	
	 /**
	  * http://www.mkyong.com/java/how-to-delete-directory-in-java/
	  * 
	 * @param file
	 * @throws IOException
	 */
	private void delete(File file) throws IOException{
    	if(file.isDirectory()){
    		//directory is empty, then delete it
    		if(file.list().length==0){
    		   file.delete();
    		} else{
    		   //list all the directory contents
        	   final String files[] = file.list();
 
        	   for (String temp : files) {
        	      //construct the file structure
        	      File fileDelete = new File(file, temp);
 
        	      //recursive delete
        	     delete(fileDelete);
        	   }
 
        	   //check the directory again, if empty then delete it
        	   if(file.list().length==0){
           	     file.delete();
        	   }
    		}
 
    	} else{
    		//if file, then delete it
    		file.delete();
    	}
    }
	
}

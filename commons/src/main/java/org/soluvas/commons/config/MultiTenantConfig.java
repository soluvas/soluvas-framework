package org.soluvas.commons.config;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nullable;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.CommonsException;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.Network;
import org.soluvas.commons.OnDemandXmiLoader;
import org.soluvas.commons.ResourceType;
import org.soluvas.commons.TenantSource;
import org.soluvas.commons.WebAddress;
import org.soluvas.commons.tenant.TenantRepository;
import org.soluvas.commons.tenant.TenantRepositoryListener;
import org.soluvas.commons.tenant.TenantsStarting;
import org.soluvas.commons.tenant.TenantsStopping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

/**
 * Non-web tenant-related application configuration.
 * @author ceefour
 */
@Configuration @Lazy
public class MultiTenantConfig implements TenantRepositoryListener {
	private static final Logger log = LoggerFactory
			.getLogger(MultiTenantConfig.class);

	@Inject
	private SoluvasApplication app;
	@Inject
	private Environment env;
	@Inject @Network
	private ExecutorService networkExecutor;
	@Autowired(required=false)
	private TenantRepository tenantRepo;
	/**
	 * Used only if using {@link TenantSource#CONFIG}, otherwise {@code null}.
	 */
	@Nullable
	private ImmutableMap<String, AppManifest> staticTenantMap = null;
	
	public static enum DataDirLayout {
		/**
		 * @deprecated e.g. {@code $HOME/tuneeca_dev}
		 */
		@Deprecated
		LEGACY,
		/**
		 * e.g. {@code $HOME/commerce_dev/tuneeca} 
		 */
		DEFAULT
	}

	/**
	 * App workspace, used as root directory of tenant directories.
	 * Formerly this was {@code $HOME}, however current best practice is {@code $HOME/appCode_tenantEnv},
	 * e.g. {@code $HOME/commerce_dev, $HOME/hub_dev, $HOME/gauldong_dev}, etc. 
	 */
	private File workspaceDir;
	private DataDirLayout dataDirLayout;
	private String tenantEnv;
	private TenantSource tenantSource;
	private String appDomain;
	private final Map<String, EventBus> eventBusMap = new LinkedHashMap<>();
	private final Map<String, File> dataDirMap = new LinkedHashMap<>();
	private final Map<String, WebAddress> webAddressMap = new LinkedHashMap<>();

	public static String getFqdn() {
		final String fqdn;
		try {
			fqdn = InetAddress.getLocalHost().getCanonicalHostName();
		} catch (UnknownHostException e) {
			throw new CommonsException("Cannot get FQDN", e);
		}
		Preconditions.checkState(!Strings.isNullOrEmpty(fqdn), "Invalid FQDN: empty. Check your host OS's configuration.");
		return fqdn;
	}
	
	public String getTenantEnv() {
		return tenantEnv;
	}
	
	public File getWorkspaceDir() {
		return workspaceDir;
	}
	
	public String getAppDomain() {
		return appDomain;
	}
	
	public static File internalGetWorkspaceDir(String appId, Environment env) {
		final String tenantEnv = env.getRequiredProperty("tenantEnv");
		return new File(env.getProperty("workspaceDir", System.getProperty("user.home") + "/" + appId + "_" + tenantEnv));
	}
	
	static String internalGetAppDomain(String appId, Environment env) {
		final String defaultAppDomain = appId + "." + getFqdn();
		return env.getProperty("appDomain", defaultAppDomain);
	}
	
	/**
	 * Loads {@link AppManifest}s for all tenants, depending on
	 * <code>${tenantSource}</code> property ({@link TenantSource}).
	 * If ${tenantSource} is not specified, default is {@value TenantSource#CONFIG}.
	 * 
	 * @throws IOException
	 */
	@PostConstruct
	public void init() throws IOException {
		final String appId = app.getId();
		tenantEnv = env.getRequiredProperty("tenantEnv");
		workspaceDir = internalGetWorkspaceDir(appId, env);
		dataDirLayout = env.getProperty("dataDirLayout", DataDirLayout.class, DataDirLayout.DEFAULT);
		appDomain = internalGetAppDomain(appId, env);
		// tenantWhitelist: Comma-separated list of tenantIds to load (all others are excluded)
		@Nullable
		final String tenantWhitelistStr = env.getProperty("tenantWhitelist", String.class);
		@Nullable
		final List<String> tenantWhitelist = tenantWhitelistStr != null ? Splitter.on(',').trimResults().omitEmptyStrings().splitToList( tenantWhitelistStr ) : null;
		tenantSource = env.getProperty("tenantSource", TenantSource.class, TenantSource.CONFIG);
		log.info("App '{}' env={} domain={}. Workspace dir={} layout={}. Tenant source {} with {} whitelist: {}", 
				appId, tenantEnv, appDomain, workspaceDir, dataDirLayout, tenantSource, tenantWhitelist != null ? tenantWhitelist.size() : 0, tenantWhitelist);
		if (tenantSource == TenantSource.CONFIG) {
			final Resource[] resources = new PathMatchingResourcePatternResolver(MultiTenantConfig.class.getClassLoader())
				.getResources("classpath*:/META-INF/*.AppManifest.xmi");
			log.info("Loading {} AppManifest resources from classpath: {}", resources.length, resources);
			final Pattern tenantIdPattern = Pattern.compile("([^.]+).+");
			final String fqdn = getFqdn();
	
			final ImmutableMap.Builder<String, AppManifest> builder = ImmutableMap.builder();
			for (final Resource res : resources) {
				final Matcher tenantIdMatcher = tenantIdPattern.matcher(res.getFilename());
				Preconditions.checkState(tenantIdMatcher.matches(), "Invalid AppManifest resource name: %s", res.getFilename());
				final String tenantId = tenantIdMatcher.group(1);
				
				if (tenantWhitelist != null && !tenantWhitelist.contains(tenantId)) {
					log.info("Skipping tenant '{}' in {} ({}) because not in {} whitelist: {}", 
							tenantId, appId, tenantEnv, tenantWhitelist.size(), tenantWhitelist);
					continue;
				}
				
				final ImmutableMap<String, String> scope = ImmutableMap.of(
						"fqdn", fqdn, "appDomain", appDomain);
				final AppManifest tenantManifest = new OnDemandXmiLoader<AppManifest>(
						CommonsPackage.eINSTANCE, res.getURL(), ResourceType.CLASSPATH, scope).get();
				builder.put(tenantId, tenantManifest);
			}
			staticTenantMap = builder.build();
		}
		
		initEventBusMap();
		initDataDirMap();
		initWebAddressMap();
		
		if (tenantRepo != null) {
			tenantRepo.addListener(this);
		}
	}
	
	/**
	 * It uses {@code prototype} scope to prepare for dynamic multitenant system.
	 * 
	 * @return 
	 * @todo Rename {@link AppManifest} to TenantManifest? Should we? Or just keep it as it is? i.e. make AppManifest overriding from global to tenant?
	 * @throws IOException 
	 */
	@Bean @Scope("prototype")
	public ImmutableMap<String, AppManifest> tenantMap() {
		switch (tenantSource) {
		case CONFIG:
			return staticTenantMap;
		case REPOSITORY:
			Preconditions.checkNotNull(tenantRepo, "tenantRepo must provided for tenantSource=%s", tenantSource);
			final ImmutableMap<String, AppManifest> tenantMap = tenantRepo.findAll();
			return tenantMap;
		default:
			throw new IllegalArgumentException("Unknown tenantSource: " + tenantSource);
		}
	}
	
	private void initEventBusMap() {
		for (final Map.Entry<String, AppManifest> entry : tenantMap().entrySet()) {
			final AsyncEventBus eventBus = new AsyncEventBus(entry.getKey(), networkExecutor);
			eventBusMap.put(entry.getKey(), eventBus);
		}
	}

	/**
	 * @return Unmodifiable {@link EventBus} {@link Map} for each tenant.
	 */
	@Bean
	public Map<String, EventBus> eventBusMap() {
		return Collections.unmodifiableMap(eventBusMap);
	}
	
	private void initDataDirMap() {
		for (final Map.Entry<String, AppManifest> tenant : tenantMap().entrySet()) {
			final String dataDirName = dataDirLayout == DataDirLayout.LEGACY ? tenant.getKey() + "_" + tenantEnv : tenant.getKey();
			dataDirMap.put(tenant.getKey(), new File(workspaceDir, dataDirName));
		}
	}
	
	/**
	 * <p>Note: A tenant {@code dataDir} may not be in the dataDirMap (i.e. {@code null}),
	 * and a dataDir value doesn't mean it exists in the filesystem.
	 * @return Unmodifiable {@link Map} of tenant {@code dataDir}.
	 */
	@Bean
	public Map<String, File> dataDirMap() {
		return Collections.unmodifiableMap(dataDirMap);
	}

	private void createWebAddressAndPut(String tenantId, AppManifest appManifest, @Nullable File dataDir) {
		final ImmutableMap<String, Object> scope = ImmutableMap.<String, Object>of(
				"appId", app.getId(),
				"tenantId", tenantId,
				"tenantEnv", tenantEnv,
				"domain", appManifest.getDomain(),
				"fqdn", getFqdn());
		final OnDemandXmiLoader<WebAddress> loader;
		
		final String webAddressRes = "/META-INF/template.WebAddress.xmi";
		if (dataDir != null) {
			final File webAddressFile = new File(dataDir, "model/" + tenantId + "_" + tenantEnv + ".WebAddress.xmi");
			if (webAddressFile.exists()) {
				log.info("Tenant '{}' WebAddress file '{}' exists, loading WebAddress model from file",
						tenantId, webAddressFile);
				loader = new OnDemandXmiLoader<>(CommonsPackage.eINSTANCE, webAddressFile, scope);
			} else {
				log.info("Tenant '{}' WebAddress file '{}' does not exist, loading generic WebAddress model from classpath: {}",
						tenantId, webAddressFile, webAddressRes);
				loader = new OnDemandXmiLoader<>(CommonsPackage.eINSTANCE, MultiTenantConfig.class, webAddressRes, scope);
			}
		} else {
			log.info("Tenant '{}' has no data dir mapping, loading generic WebAddress model from classpath: {}",
					tenantId, dataDir, webAddressRes);
			loader = new OnDemandXmiLoader<>(CommonsPackage.eINSTANCE, MultiTenantConfig.class, webAddressRes, scope);
		}
		
//		final String tenantKey = tenant.getKey() + "_" + tenantEnv;
//				return new StaticXmiLoader<WebAddress>(CommonsPackage.eINSTANCE,
//						new File(dataFolder(), "model/custom.WebAddress.xmi").toString()).get();
		final WebAddress webAddress = loader.get();
		webAddressMap.put(tenantId, webAddress);
	}
	
	private void initWebAddressMap() {
		for (final Map.Entry<String, AppManifest> tenant : tenantMap().entrySet()) {
			final String tenantId = tenant.getKey();
			final File dataDir = dataDirMap.get(tenantId);
			createWebAddressAndPut(tenantId, tenant.getValue(), dataDir);
		}
		log.info("Initialized WebAddressMap with {} entries: {}", webAddressMap.size(), webAddressMap.keySet());
	}

	/**
	 * @return Unmodifiable {@link Map} of tenant {@link WebAddress}es.
	 */
	@Bean
	public Map<String, WebAddress> webAddressMap() {
		return Collections.unmodifiableMap(webAddressMap);
	}

	@Override
	public void onTenantsStarting(TenantsStarting starting) {
		for (Map.Entry<String, AppManifest> tenant : starting.getAddeds().entrySet()) {
			final String tenantId = tenant.getKey();
			// EventBus
			final AsyncEventBus eventBus = new AsyncEventBus(tenantId, networkExecutor);
			eventBusMap.put(tenantId, eventBus);
			log.info("Created EventBus for tenant '{}'", tenantId);
			// dataDir
			final String dataDirName = dataDirLayout == DataDirLayout.LEGACY ? tenant.getKey() + "_" + tenantEnv : tenant.getKey();
			final File dataDir = new File(workspaceDir, dataDirName);
			dataDirMap.put(tenant.getKey(), dataDir);
			log.info("Registered dataDir for tenant '{}'", tenantId, dataDir);
			// WebAddress
			createWebAddressAndPut(tenantId, tenant.getValue(), dataDir);
		}
	}

	@Override
	public void onTenantsStopping(TenantsStopping stopping) {
		for (Map.Entry<String, AppManifest> tenant : stopping.getTenants().entrySet()) {
			final String tenantId = tenant.getKey();
			// WebAddress
			webAddressMap.remove(tenantId);
			log.info("Destroyed WebAddress for tenant '{}'", tenantId);
			// DataDir
			final File dataDir = dataDirMap.remove(tenantId);
			log.info("Unregistered dataDir for tenant '{}': {}", tenantId, dataDir);
			// EventBus
			eventBusMap.remove(tenantId);
			log.info("Destroyed EventBus for tenant '{}'", tenantId);
		}
	}

}

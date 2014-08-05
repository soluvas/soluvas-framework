package org.soluvas.commons.config;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nullable;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.CommonsException;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.IdAsyncEventBus;
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
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.damnhandy.uri.template.MalformedUriTemplateException;
import com.damnhandy.uri.template.UriTemplate;
import com.damnhandy.uri.template.VariableExpansionException;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableMap;
import com.google.common.eventbus.EventBus;

/**
 * Non-web tenant-related application configuration.
 * @author ceefour
 * @see MultiTenantWebConfig
 */
@Configuration("tenantConfig")
public class MultiTenantConfig implements TenantRepositoryListener, DefaultsConfig {
	private static final Logger log = LoggerFactory
			.getLogger(MultiTenantConfig.class);

	@Inject
	private SoluvasApplication app;
	@Inject
	private Environment env;
	@Inject @Network
	private ExecutorService networkExecutor;
	@Autowired(required=false)
	private TenantRepository<?> tenantRepo;
	/**
	 * Used only if using {@link TenantSource#CONFIG}, otherwise {@code null}.
	 */
	@Nullable
	private ImmutableMap<String, AppManifest> staticTenantMap = null;
	
	/**
	 * A {@link String} {@link Supplier} that returns the initial {@code tenantId}.
	 * If (currently) there is only one tenant, it will return that tenant.
	 * If (currently) there are no tenants or there are more than one tenant, it will return {@code null}.
	 * "Currently" because when using {@link TenantRepository},
	 * tenants can be added and removed at any time.
	 * @return
	 */
	private final Supplier<String> initialTenantIdSupplier = new Supplier<String>() {
		@Override @Nullable
		public String get() {
			return tenantMap().size() == 1 ? tenantMap().keySet().iterator().next() : null;
		}
	};
	
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
	private String openDomain;
	private String manageDomain;

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
	
	public String getOpenDomain() {
		return openDomain;
	}
	
	public String getManageDomain() {
		return manageDomain;
	}
	
	public static File internalGetWorkspaceDir(String appId, Environment env) {
		final String tenantEnv = env.getRequiredProperty("tenantEnv");
		return new File(env.getProperty("workspaceDir", System.getProperty("user.home") + "/" + appId + "_" + tenantEnv));
	}
	
	public static String internalGetAppDomain(String appId, Environment env) {
		final String defaultAppDomain = appId + "." + getFqdn();
		return env.getProperty("appDomain", defaultAppDomain);
	}
	
	/**
	 * Loads {@link AppManifest}s for all tenants, depending on
	 * <code>${tenantSource}</code> property ({@link TenantSource}).
	 * If ${tenantSource} is not specified, default is {@value TenantSource#CONFIG}.
	 * 
	 * @throws IOException
	 * @throws VariableExpansionException 
	 * @throws MalformedUriTemplateException 
	 */
	@PostConstruct
	public void init() throws IOException, MalformedUriTemplateException, VariableExpansionException {
		final String appId = app.getId();
		tenantEnv = env.getRequiredProperty("tenantEnv");
		workspaceDir = internalGetWorkspaceDir(appId, env);
		dataDirLayout = env.getProperty("dataDirLayout", DataDirLayout.class, DataDirLayout.DEFAULT);
		
		appDomain = internalGetAppDomain(appId, env);
		openDomain = env.getProperty("openDomain", "open.{+appDomain}");
		if (openDomain.contains("{")) {
			openDomain = UriTemplate.expand(openDomain, ImmutableMap.<String, Object>of("appDomain", appDomain));
		}
		manageDomain = env.getProperty("manageDomain", "manage.{+appDomain}");
		if (manageDomain.contains("{")) {
			manageDomain = UriTemplate.expand(manageDomain, ImmutableMap.<String, Object>of("appDomain", appDomain));
		}
		
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
						"fqdn", fqdn, "appDomain", appDomain, "tenantEnv", tenantEnv);
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
			final IdAsyncEventBus eventBus = new IdAsyncEventBus(entry.getKey(), networkExecutor);
			eventBusMap.put(entry.getKey(), eventBus);
		}
		log.info("Created {} tenant EventBuses: {}", eventBusMap.size(), eventBusMap.keySet());
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
		final Map<String, Object> scope = new HashMap<>();
		scope.put("appId", app.getId());
		scope.put("tenantId", tenantId);
		scope.put("tenantEnv", tenantEnv);
		scope.put("appDomain", appDomain);
		scope.put("domain", appManifest.getDomain());
		scope.put("fqdn", getFqdn());
		scope.put("webHost", appManifest.getWebHost());
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
			final IdAsyncEventBus eventBus = new IdAsyncEventBus(tenantId, networkExecutor);
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
	
	/**
	 * A {@link String} {@link Supplier} that returns the initial {@code tenantId}.
	 * If (currently) there is only one tenant, it will return that tenant.
	 * If (currently) there are no tenants or there are more than one tenant, it will return {@code null}.
	 * "Currently" because when using {@link TenantRepository},
	 * tenants can be added and removed at any time.
	 * 
	 * <p>Usage:
	 * 
	 * <pre>
	 * &lt;!-- BEGIN replace blast-shell-core-0.13.jar!/META-INF/shell/base-command-context.xml -->
	 * &lt;!-- We don't use ${welcome}, and we use newer 3.2 property placeholder mechanism -->
	 * &lt;bean name="threadIo" class="org.apache.felix.gogo.runtime.threadio.ThreadIOImpl" />
	 * 
	 * &lt;bean name="commandProcessor" class="org.apache.felix.gogo.runtime.CommandProcessorImpl">
	 * 	&lt;constructor-arg ref="threadIo" />
	 * &lt;/bean>
	 * 
	 * &lt;bean id="commandRegistry" class="blast.shell.CommandRegistry">
	 * 	&lt;property name="commandShell" ref="commandProcessor" />
	 * 	&lt;property name="actionFactory">
	 * 		&lt;bean
	 * 			class="org.springframework.beans.factory.config.ServiceLocatorFactoryBean">
	 * 			&lt;property name="serviceLocatorInterface" value="blast.shell.ActionFactory" />
	 * 		&lt;/bean>
	 * 	&lt;/property>
	 * &lt;/bean>
	 * 
	 * &lt;!-- Overrides consoleFactory defined in blast-shell-core-0.13.jar!/META-INF/shell/base-command-context.xml -->
	 * &lt;bean id="consoleFactory" class="org.soluvas.commons.shell.SoluvasConsoleFactory">
	 * 	&lt;property name="commandRegistry" ref="commandRegistry" />
	 * 	&lt;property name="commandProcessor" ref="commandProcessor" />
	 * 	&lt;property name="welcomeMessageFile" value="classpath:branding/branding.properties" />
	 * 	&lt;property name="application" value="#{app.id}" />
	 * 	&lt;property name="hotelIdSupplier">
	 * 		&lt;bean class="com.google.common.base.Suppliers" factory-method="ofInstance">
	 * 			&lt;constructor-arg value="${hotelId}" />
	 * 		&lt;/bean>
	 * 	&lt;/property>
	 * 	&lt;property name="tenantIdSupplier" value="#{tenantConfig.initialTenantIdSupplier}" />
	 * 	&lt;property name="tenantEnvSupplier">
	 * 		&lt;bean class="com.google.common.base.Suppliers" factory-method="ofInstance">
	 * 			&lt;constructor-arg value="${tenantEnv}" />
	 * 		&lt;/bean>
	 * 	&lt;/property>
	 * &lt;/bean>
	 * &lt;!-- END replace blast-shell-core-0.13.jar!/META-INF/shell/base-command-context.xml -->
	 * </pre> 
	 * 
	 * @return
	 */
	public Supplier<String> getInitialTenantIdSupplier() {
		return initialTenantIdSupplier;
	}
	
	public String getHotelId() {
		return env.getRequiredProperty("hotelId");
	}
	
	/**
	 * Default {@link Locale} for tenantless operations, e.g. Manage and Open pages.
	 * @return
	 * @see commerce.properties: defaultLocale
	 */
	@Override
	public Locale getDefaultLocale() {
		return Locale.forLanguageTag(env.getRequiredProperty("defaultLocale"));
	}

	/**
	 * Default {@link DateTimeZone} for tenantless operations, e.g. Manage and Open pages.
	 * @return
	 * @see commerce.properties: defaultTimeZone
	 */
	@Override
	public DateTimeZone getDefaultTimeZone() {
		return DateTimeZone.forID(env.getRequiredProperty("defaultTimeZone"));
	}

}

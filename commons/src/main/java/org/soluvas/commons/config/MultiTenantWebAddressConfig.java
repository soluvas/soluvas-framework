package org.soluvas.commons.config;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Nullable;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.lang3.BooleanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.*;
import org.soluvas.commons.tenant.TenantRepository;
import org.soluvas.commons.tenant.TenantRepositoryListener;
import org.soluvas.commons.tenant.TenantsStarting;
import org.soluvas.commons.tenant.TenantsStopping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/**
 * Non-web tenant-related application configuration.
 * @author ceefour
 * @see MultiTenantWebConfig
 * @see MultiTenantConfig
 */
@Configuration
@Import(MultiTenantConfig.class)
public class MultiTenantWebAddressConfig implements TenantRepositoryListener {
	private static final Logger log = LoggerFactory
			.getLogger(MultiTenantWebAddressConfig.class);

	@Inject
	private SoluvasApplication app;
	@Autowired(required=false)
	private TenantRepository<?> tenantRepo;
	@Inject
	private MultiTenantConfig tenantConfig;
	@Inject
	private SysConfigMapHolder<? extends GeneralSysConfig> sysConfigs;
	
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
	
	/**
	 * Loads {@link WebAddress}s for all tenants.
	 * @throws Exception 
	 */
	@PostConstruct
	public void init() throws Exception {
		initWebAddressMap();
		if (tenantRepo != null) {
			tenantRepo.addListener(this);
		}
	}
	
	private void createWebAddressAndPut(String tenantId, AppManifest appManifest, @Nullable File dataDir) throws Exception {
		final Map<String, Object> scope = new HashMap<>();
		scope.put("appId", app.getId());
		scope.put("tenantId", tenantId);
		scope.put("tenantEnv", tenantConfig.getTenantEnv());
		scope.put("appDomain", tenantConfig.getAppDomain());
		scope.put("domain", appManifest.getDomain());
		scope.put("fqdn", MultiTenantConfig.getFqdn());
		scope.put("webHost", appManifest.getWebHost());
		final GeneralSysConfig sysConfig = Preconditions.checkNotNull(sysConfigs.sysConfigMap().get(tenantId),
				"Cannot get GeneralSysConfig for tenant '%s'. %s available tenants: %s",
				tenantId, sysConfigs.sysConfigMap().size(), sysConfigs.sysConfigMap().keySet());
		scope.put("sslSupported", BooleanUtils.isTrue(sysConfig.getSslSupported()));
		final OnDemandXmiLoader<WebAddress> loader;

		// TODO: due to impracticality of classpath resource packaging, hotel-specific files/templates should be put in either
		// app config dir or workspace (hotel's config) dir
		final String hotelWebAddressRes = "/META-INF/template.WebAddress.xmi";
		// Workaround for Pivotal Web Services / Cloud Foundry
		final File hotelWebAddressNoLabel = new File("config/hotel.WebAddress.xmi");
		final File hotelWebAddressWithLabel = new File("config_" + tenantConfig.getTenantEnv() + "/hotel.WebAddress.xmi");
		final File hotelWebAddressFile = (hotelWebAddressNoLabel.exists() ? hotelWebAddressNoLabel : hotelWebAddressWithLabel).getAbsoluteFile();
		if (dataDir != null) {
			final File webAddressFile = new File(dataDir, "model/" + tenantId + "_" + tenantConfig.getTenantEnv() + ".WebAddress.xmi");
			if (webAddressFile.exists()) {
				log.info("Tenant '{}' WebAddress file '{}' exists, loading WebAddress model from file",
						tenantId, webAddressFile);
				loader = new OnDemandXmiLoader<>(CommonsPackage.eINSTANCE, webAddressFile, scope);
			} else {
				if (tenantConfig.getTenantSource() == TenantSource.CONFIG) {
					log.info("Tenant '{}' WebAddress file '{}' does not exist, loading hotel WebAddress model from config dir: {}",
							tenantId, webAddressFile, hotelWebAddressFile);
					loader = new OnDemandXmiLoader<>(CommonsPackage.eINSTANCE, hotelWebAddressFile, scope);
				} else {
					log.info("Tenant '{}' WebAddress file '{}' does not exist, loading hotel WebAddress model from classpath: {}",
							tenantId, webAddressFile, hotelWebAddressRes);
					loader = new OnDemandXmiLoader<>(CommonsPackage.eINSTANCE, MultiTenantWebAddressConfig.class, hotelWebAddressRes, scope);
				}
			}
		} else {
			if (tenantConfig.getTenantSource() == TenantSource.CONFIG) {
				log.info("Tenant '{}' has no data dir mapping, loading hotel WebAddress model from config dir: {}",
						tenantId, dataDir, hotelWebAddressFile);
				loader = new OnDemandXmiLoader<>(CommonsPackage.eINSTANCE, hotelWebAddressFile, scope);
			} else {
				log.info("Tenant '{}' has no data dir mapping, loading hotel WebAddress model from classpath: {}",
						tenantId, dataDir, hotelWebAddressRes);
				loader = new OnDemandXmiLoader<>(CommonsPackage.eINSTANCE, MultiTenantWebAddressConfig.class, hotelWebAddressRes, scope);
			}
		}
		
//		final String tenantKey = tenant.getKey() + "_" + tenantEnv;
//				return new StaticXmiLoader<WebAddress>(CommonsPackage.eINSTANCE,
//						new File(dataFolder(), "model/custom.WebAddress.xmi").toString()).get();
		final WebAddress webAddress = loader.get();
		webAddressMap.put(tenantId, webAddress);
	}
	
	private void initWebAddressMap() throws Exception {
		for (final Map.Entry<String, AppManifest> tenant : tenantConfig.tenantMap().entrySet()) {
			final String tenantId = tenant.getKey();
			final File dataDir = tenantConfig.dataDirMap().get(tenantId);
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
	public void onTenantsStarting(TenantsStarting starting) throws Exception {
		for (Map.Entry<String, AppManifest> tenant : starting.getAddeds().entrySet()) {
			final String tenantId = tenant.getKey();
			final File dataDir = tenantConfig.dataDirMap().get(tenantId);
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
		}
	}
	
}

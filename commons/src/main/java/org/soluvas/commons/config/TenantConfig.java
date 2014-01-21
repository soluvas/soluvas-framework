package org.soluvas.commons.config;

import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.OnDemandXmiLoader;
import org.soluvas.commons.ResourceType;
import org.soluvas.commons.TenantSource;
import org.soluvas.commons.WebAddress;
import org.soluvas.commons.tenant.TenantMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

/**
 * Non-web tenant-related application configuration.
 * @author ceefour
 */
@Configuration @Lazy
public class TenantConfig {
	private static final Logger log = LoggerFactory
			.getLogger(TenantConfig.class);
	
	@Inject
	private Environment env;
	
	/**
	 * Loads {@link AppManifest}s for all tenants, depending on
	 * <code>${tenantSource}</code> property ({@link TenantSource}).
	 * If ${tenantSource} is not specified, default is {@value TenantSource#CONFIG}.
	 * 
	 * @return 
	 * @todo Rename {@link AppManifest} to TenantManifest? Should we? Or just keep it as it is? i.e. make AppManifest overriding from global to tenant?
	 * @throws IOException 
	 */
	@Bean
	public Map<String, AppManifest> tenantMap() throws IOException {
		final TenantSource tenantSource = env.getProperty("tenantSource", TenantSource.class, TenantSource.CONFIG);
		log.info("Tenant source: {}", tenantSource);
		switch (tenantSource) {
		case CONFIG:
			final Resource[] resources = new PathMatchingResourcePatternResolver(TenantConfig.class.getClassLoader())
				.getResources("classpath*:/META-INF/*.AppManifest.xmi");
			log.info("Loading {} AppManifest resources from classpath: {}", resources.length, resources);
			final Pattern tenantIdPattern = Pattern.compile("([^.]+).+");
			final ImmutableMap.Builder<String, AppManifest> builder = ImmutableMap.builder();
			for (final Resource res : resources) {
				final Matcher tenantIdMatcher = tenantIdPattern.matcher(res.getFilename());
				Preconditions.checkState(tenantIdMatcher.matches(), "Invalid AppManifest resource name: %s", res.getFilename());
				final String tenantId = tenantIdMatcher.group(1);
				
				final ImmutableMap<String, String> scope = ImmutableMap.of(
						"appDomain", env.getRequiredProperty("appDomain"));
				final AppManifest tenantManifest = new OnDemandXmiLoader<AppManifest>(
						CommonsPackage.eINSTANCE, res.getURL(), ResourceType.CLASSPATH, scope).get();
				builder.put(tenantId, tenantManifest);
			}
			return builder.build();
		case REPOSITORY:
			throw new UnsupportedOperationException();
		default:
			throw new IllegalArgumentException("Unknown tenantSource: " + tenantSource);
		}
	}

	@Bean
	public Map<String, WebAddress> webAddressMap() throws IOException {
		final TenantMode tenantMode = env.getRequiredProperty("tenantMode", TenantMode.class);
		final String tenantEnv = env.getRequiredProperty("tenantEnv");
		
		switch (tenantMode) {
		case MULTI_PATH:
			throw new IllegalArgumentException("Deprecated (unsupported) tenantMode: " + tenantMode);
		case MULTI_HOST:
			break;
		default:
			throw new IllegalArgumentException("Unsupported tenantMode: " + tenantMode);
		}
		
		final ImmutableMap.Builder<String, WebAddress> webAddressBuilder = ImmutableMap.builder();
		for (final Map.Entry<String, AppManifest> tenant : tenantMap().entrySet()) {
			final String tenantKey = tenant.getKey() + "_" + tenantEnv;
//					return new StaticXmiLoader<WebAddress>(CommonsPackage.eINSTANCE,
//							new File(dataFolder(), "model/custom.WebAddress.xmi").toString()).get();
			final ImmutableMap<String, String> scope = ImmutableMap.of("tenantId", tenant.getKey(),
					"tenantEnv", tenantEnv);
			final OnDemandXmiLoader<WebAddress> loader = new OnDemandXmiLoader<>(CommonsPackage.eINSTANCE,
					MultiTenantWebConfig.class, "/META-INF/tenant.WebAddress.xmi", scope);
			final WebAddress webAddress = loader.get();
			webAddressBuilder.put(tenant.getKey(), webAddress);
		}
		return webAddressBuilder.build();
	}

}

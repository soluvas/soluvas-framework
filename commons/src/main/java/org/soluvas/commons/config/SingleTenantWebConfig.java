package org.soluvas.commons.config;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.CommonsException;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.DataFolder;
import org.soluvas.commons.OnDemandXmiLoader;
import org.soluvas.commons.StaticXmiLoader;
import org.soluvas.commons.WebAddress;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.commons.tenant.TenantRefImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;

/**
 * Reads the tenant information from {@link ServletContext#getContextPath()}.
 * Which means single tenant per webapp context.
 * 
 * <p><strong>Note:</strong> It's recommended to use multitenant {@link MultiTenantConfig} to make your application future-proof.
 * @author rudi
 */
@Configuration @Lazy
public class SingleTenantWebConfig {
	
	private static final Logger log = LoggerFactory
			.getLogger(SingleTenantWebConfig.class);
	@Inject
	private ServletContext servletContext;
	
	@Bean
	public TenantRef tenantRef() {
		final String contextPath = Preconditions.checkNotNull(servletContext, "Cannot inject ServletContext")
				.getContextPath();
		final Matcher tenantMatcher = Pattern.compile("\\/([^_]+)_([^_]+)_([^_]+)").matcher(contextPath);
		Preconditions.checkState(tenantMatcher.matches(),
				"ContextPath %s must match pattern: /{tenantId}_{tenantEnv}_{appCode}",
				contextPath);
		final TenantRef tenant = new TenantRefImpl(tenantMatcher.group(1), tenantMatcher.group(1), tenantMatcher.group(2));
		log.info("Single-tenant Deployment Configuration for {}: clientId={} tenantId={} tenantEnv={} appCode={}",
				contextPath, tenant.getClientId(), tenant.getTenantId(), tenant.getTenantEnv(), tenantMatcher.group(3));
		return tenant;
	}
	
	@Bean @DataFolder
	public String dataFolder() {
		return System.getProperty("user.home") + "/" + tenantRef().getTenantId() + "_" + tenantRef().getTenantEnv();
	}
	
	protected String getFqdn() {
		final String fqdn;
		try {
			fqdn = InetAddress.getLocalHost().getCanonicalHostName();
		} catch (UnknownHostException e) {
			throw new CommonsException("Cannot get FQDN", e);
		}
		Preconditions.checkState(!Strings.isNullOrEmpty(fqdn), "Invalid FQDN: empty. Check your host OS's configuration.");
		return fqdn;
	}
	
	@Bean
	public WebAddress webAddress() {
		final String fqdn = getFqdn();
		final Map<String, Object> scope = ImmutableMap.<String, Object>of("fqdn", fqdn);
		return new OnDemandXmiLoader<WebAddress>(CommonsPackage.eINSTANCE,
				new File(dataFolder(), "model/custom.WebAddress.xmi"), scope).get();
	}

	@Bean
	public AppManifest appManifest() {
		final String fqdn = getFqdn();
		final Map<String, Object> scope = ImmutableMap.<String, Object>of(
				"fqdn", fqdn, "tenantEnv", tenantRef().getTenantEnv());
		final File appManifestFile = new File(dataFolder(),
				"model/" + tenantRef().getTenantId() + "_" + tenantRef().getTenantEnv() + ".AppManifest.xmi");
		return new StaticXmiLoader<AppManifest>(CommonsPackage.eINSTANCE, appManifestFile, scope).get();
	}
	
	/**
	 * @todo Single-tenant is falling out of favor. We should use {@link MultiTenantWebConfig}
	 * 		by (hopefully) Bippo 5.3.
	 * @return
	 */
	@Bean
	public Map<String, AppManifest> tenantMap() {
		return ImmutableMap.of(tenantRef().getTenantId(), appManifest());
	}	
	
}

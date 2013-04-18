package org.soluvas.commons.config;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.DataFolder;
import org.soluvas.commons.WebAddress;
import org.soluvas.commons.XmiObjectLoader;
import org.soluvas.commons.tenant.TenantRef;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.google.common.base.Preconditions;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * Reads the tenant information from {@link HttpServletRequest#getPathInfo()}
 * e.g. http://localhost:8080/{hotelContext}/{app}/t/{tenantId}/{tenantEnv}.
 * Which means tenant is read per request.
 * @author rudi
 */
@Configuration @Scope("request")
public class MultiTenantWebConfig {
	
	private static final Logger log = LoggerFactory
			.getLogger(MultiTenantWebConfig.class);
	@Inject
	private HttpServletRequest request;
	private static final Cache<String, AppManifest> appManifestCache = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build();
	private static final Cache<String, WebAddress> webAddressCache = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build(); 
	
	@Bean @Scope("request")
	public TenantRef tenantRef() {
		String pathInfo = request.getPathInfo();
//		final String contextPath = Preconditions.checkNotNull(servletContext, "Cannot inject ServletContext")
//				.getContextPath();
		final Matcher tenantMatcher = Pattern.compile("\\/t/([^/]+)/([^/]+).*").matcher(pathInfo);
		Preconditions.checkState(tenantMatcher.matches(),
				"Path info %s must match pattern: /t/{tenantId}/{tenantEnv}",
				pathInfo);
		final TenantRef tenant = new TenantRef(tenantMatcher.group(1), tenantMatcher.group(1), tenantMatcher.group(2));
		log.debug("Multi-tenant Deployment Configuration for {}: clientId={} tenantId={} tenantEnv={}",
				pathInfo, tenant.getClientId(), tenant.getTenantId(), tenant.getTenantEnv() );
		return tenant;
	}
	
	@Bean @DataFolder @Scope("request")
	public String dataFolder() {
		return System.getProperty("user.home") + "/" + tenantRef().getTenantId() + "_" + tenantRef().getTenantEnv();
	}
	
	@Bean @Scope("request")
	public AppManifest appManifest() throws ExecutionException {
		final String tenantKey = tenantRef().getTenantId() + "_" + tenantRef().getTenantEnv();
		return appManifestCache.get(tenantKey, new Callable<AppManifest>() {
			@Override
			public AppManifest call() throws Exception {
				return new XmiObjectLoader<AppManifest>(CommonsPackage.eINSTANCE,
						new File(dataFolder(), "model/" + tenantKey + ".AppManifest.xmi").toString()).get();
			}
		});
	}
	
	@Bean @Scope("request")
	public WebAddress webAddress() throws ExecutionException {
		final String tenantKey = tenantRef().getTenantId() + "_" + tenantRef().getTenantEnv();
		return webAddressCache.get(tenantKey, new Callable<WebAddress>() {
			@Override
			public WebAddress call() throws Exception {
				return new XmiObjectLoader<WebAddress>(CommonsPackage.eINSTANCE,
						new File(dataFolder(), "model/custom.WebAddress.xmi").toString()).get();
			}
		});
	}

}

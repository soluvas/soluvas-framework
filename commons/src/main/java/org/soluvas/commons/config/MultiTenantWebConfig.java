package org.soluvas.commons.config;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.felix.service.command.CommandSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.CommonsException;
import org.soluvas.commons.DataFolder;
import org.soluvas.commons.WebAddress;
import org.soluvas.commons.tenant.CommandRequestAttributes;
import org.soluvas.commons.tenant.RequestOrCommandScope;
import org.soluvas.commons.tenant.TenantMode;
import org.soluvas.commons.tenant.TenantNotFoundException;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.commons.tenant.TenantRefImpl;
import org.soluvas.commons.tenant.TenantUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.eventbus.EventBus;

/**
 * Reads the tenant information from {@link HttpServletRequest#getPathInfo()}.
 * Recommended is to use {@link TenantMode#MULTI_HOST}.
 * For {@link TenantMode#MULTI_PATH} (deprecated): e.g. http://localhost:8080/{hotelContext}/{app}/t/{tenantId}/{tenantEnv}.
 * Which means tenant is read per request.
 * Requires either {@link ServletContext} aka {@link WebApplicationContext} or {@link RequestOrCommandScope}
 * to determine the {@link TenantRefImpl} hence, {@code dataDir}.
 * 
 * @author rudi
 * @see MultiTenantConfig
 * @see MultiTenantWebAddressConfig
 * @see SingleTenantWebConfig
 */
@Configuration
public class MultiTenantWebConfig implements TenantSelector {
	
	private static final Logger log = LoggerFactory
			.getLogger(MultiTenantWebConfig.class);
	
	@Inject
	private Environment env;
	@Inject
	private MultiTenantConfig tenantConfig;
	@Inject
	private MultiTenantWebAddressConfig webAddressConfig;
	
	/**
	 * @todo Replace with annotation https://jira.springsource.org/browse/SPR-5192 when it's supported.
	 * @return
	 */
	protected HttpServletRequest getRequest() {
		return ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
	}
	
	/**
	 * If you can't use Spring dependency injection, use this to get the {@link TenantRef}
	 * from a {@link HttpServletRequest}. 
	 * @param httpRequest
	 * @return
	 */
	public static TenantRef getTenantRefMultiPath(HttpServletRequest httpRequest, String tenantEnv) {
		final String pathInfo = httpRequest.getPathInfo();
//		final String contextPath = Preconditions.checkNotNull(servletContext, "Cannot inject ServletContext")
//				.getContextPath();
		final Matcher tenantMatcher = Pattern.compile("\\/t/([^/]+)/([^/]+).*").matcher(pathInfo);
		Preconditions.checkState(tenantMatcher.matches(),
				"Path info '%s' must match pattern: /t/{tenantId}/{tenantEnv}",
				pathInfo);
		final TenantRef pathTenant = new TenantRefImpl(tenantMatcher.group(1), tenantMatcher.group(1), tenantMatcher.group(2));
		log.trace("MULTI_PATH Deployment Configuration for {}: clientId={} tenantId={} tenantEnv={}",
				pathInfo, pathTenant.getClientId(), pathTenant.getTenantId(), pathTenant.getTenantEnv() );
		return pathTenant;
	}
	
	/**
	 * If you can't use Spring dependency injection, use this to get the {@link TenantRef}
	 * from a {@link HttpServletRequest}. 
	 * @param httpRequest
	 * @param openDomain {@link MultiTenantConfig#getOpenDomain()}
	 * @param manageDomain {@link MultiTenantConfig#getManageDomain()}
	 * @return
	 * @see MultiTenantConfig#tenantMap()
	 */
	public static TenantRef getTenantRefMultiHost(HttpServletRequest httpRequest, String tenantEnv,
			Map<String, AppManifest> tenantMap, String openDomain, String manageDomain) {
		Optional<String> tenantId = Optional.absent();
		final String origRequestHost = httpRequest.getServerName().toLowerCase();
		// use AppManifest.domain matching first
		final String requestHostNoWww = origRequestHost.startsWith("www.") ? origRequestHost.substring(4) : origRequestHost;
		
		Preconditions.checkState(!openDomain.equalsIgnoreCase(requestHostNoWww),
				"Trying to get TenantRef for OPEN domain '%s'. Probably incorrect @Inject, check the stacktrace to find out which bean is accessed.", openDomain);
		Preconditions.checkState(!manageDomain.equalsIgnoreCase(requestHostNoWww),
				"Trying to get TenantRef for MANAGE domain '%s'. Probably incorrect @Inject, check the stacktrace to find out which bean is accessed.", manageDomain);
		
		for (final Map.Entry<String, AppManifest> entry : tenantMap.entrySet()) {
			Preconditions.checkNotNull(entry.getValue().getDomain(),
					"Domain for tenant '%s' cannot be null. Please check your TenantRepository configuration.",
					entry.getKey());
			if (entry.getValue().getDomain().equalsIgnoreCase(requestHostNoWww)) {
				tenantId = Optional.of(entry.getKey());
				break;
			}
		}
		// otherwise, fallback to first tenantId
		if (!tenantId.isPresent()) {
			final Matcher hostMatcher = Pattern.compile("(www\\.)?([^.]+).*").matcher(origRequestHost);
			Preconditions.checkState(hostMatcher.matches(),
					"Server name '%s' must match pattern: (www\\.)?([^.]+).*", origRequestHost);
			final String tenantIdFallback = hostMatcher.group(2).toLowerCase();
			Preconditions.checkArgument(!"localhost".equalsIgnoreCase(tenantIdFallback),
					"'%s' is an invalid tenant ID for HTTP Request Host '%s'", tenantIdFallback, origRequestHost);
			tenantId = Optional.of(tenantIdFallback);
		}
		final TenantRef hostTenant = new TenantRefImpl(tenantId.get(), tenantId.get(), tenantEnv);
		log.trace("MULTI_HOST Deployment Configuration for {}: clientId={} tenantId={} tenantEnv={}",
				origRequestHost, hostTenant.getClientId(), hostTenant.getTenantId(), hostTenant.getTenantEnv() );
		return hostTenant;
	}
	
	/**
	 * Gets the request-scoped {@link TenantRef}.
	 * <strong>Important:</strong> This automatically puts an {@link MDC} entry for {@value CommandRequestAttributes#MDC_TENANT_ID}
	 * which will be removed by {@link CommandRequestAttributes#requestCompleted()}.
	 * @return
	 */
	@Bean @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
	@Override
	public TenantRef tenantRef() {
		final RequestAttributes requestAttrs = RequestOrCommandScope.currentRequestAttributes();
		if (requestAttrs instanceof ServletRequestAttributes) {
			final TenantRef tenant;
			final TenantMode tenantMode = env.getRequiredProperty("tenantMode", TenantMode.class);
			switch (tenantMode) {
			case MULTI_PATH:
				tenant = getTenantRefMultiPath(getRequest(), env.getRequiredProperty("tenantEnv"));
				break;
			case MULTI_HOST:
				tenant = getTenantRefMultiHost(getRequest(), env.getRequiredProperty("tenantEnv"),
						tenantConfig.tenantMap(), tenantConfig.getOpenDomain(), tenantConfig.getManageDomain());
				break;
			default:
				throw new IllegalArgumentException("Unsupported tenantMode: " + tenantMode);
			}
			MDC.put(CommandRequestAttributes.MDC_TENANT_ID, tenant.getTenantId());
			return tenant;
		} else if (requestAttrs instanceof CommandRequestAttributes) {
			final CommandSession session = ((CommandRequestAttributes) requestAttrs).getSession();
			try {
				Preconditions.checkState(session.get("clientId") != null, 
						"CommandSession must contain clientId, please run tenant:use command to set desired tenant");
				Preconditions.checkState(session.get("tenantId") != null, 
						"CommandSession must contain tenantId, please run tenant:use command to set desired tenant");
				final String clientId = (String) session.get("clientId");
				final String tenantId = (String) session.get("tenantId");
				final String tenantEnv = env.getRequiredProperty("tenantEnv");
				MDC.put(CommandRequestAttributes.MDC_TENANT_ID, tenantId);
				return new TenantRefImpl(clientId, tenantId, tenantEnv);
			} catch (IllegalStateException e) {
				throw new CommonsException("Cannot get tenantRef from CommandRequestAttributes session " + session, e);
			}
		} else {
			throw new IllegalStateException("Unknown request attributes: " + requestAttrs);
		}
	}
	
	@Bean @DataFolder @Scope(value="request")
	public String dataFolder() throws IOException {
		return getDataDir().getPath();
	}
	
	@Bean @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
	public AppManifest appManifest() throws TenantNotFoundException {
		@Nullable
		final AppManifest appManifest = tenantConfig.tenantMap().get(tenantRef().getTenantId());
		if (appManifest != null) {
			return appManifest;
		} else {
			throw new TenantNotFoundException(String.format("Unknown tenant '%s'. %s available tenants are: %s",
				tenantRef().getTenantId(), tenantConfig.tenantMap().size(), tenantConfig.tenantMap().keySet()));
		}
	}

	/**
	 * @return
	 * @throws IOException
	 * @deprecated Use the global app-wide {@link EventBus} instead.
	 */
	@Bean @Scope(value="request") @Primary @Deprecated
	public EventBus tenantEventBus() throws IOException {
		return Preconditions.checkNotNull(
				tenantConfig.eventBusMap().get(tenantRef().getTenantId()),
				"Unknown tenant EventBus '%s'. %s available EventBuses are for: %s",
				tenantRef().getTenantId(), tenantConfig.eventBusMap().size(), tenantConfig.eventBusMap().keySet());
	}
	
	@Bean @Scope(value="request")
	public WebAddress webAddress() throws TenantNotFoundException {
		@Nullable
		final WebAddress webAddress = webAddressConfig.webAddressMap().get(tenantRef().getTenantId());
		if (webAddress != null) {
			return webAddress;
		} else {
			throw new TenantNotFoundException(String.format("Unknown tenant WebAddress '%s'. %s available WebAddresses are for: %s",
					tenantRef().getTenantId(), webAddressConfig.webAddressMap().size(), webAddressConfig.webAddressMap().keySet()));
		}
	}

	@Override
	public File getDataDir() {
		return TenantUtils.selectBean(this, tenantConfig.dataDirMap(), File.class);
	}

//	/**
//	 * proxyMode is required! See http://forum.springsource.org/showthread.php?141230-Beans-initialized-twice-by-WebApplicationContext&p=454428#post454428
//	 * @return
//	 * @throws ExecutionException
//	 * @see {@link MultiTenantConfig#tenantMap()}
//	 * @todo Maybe, instead of loading ad-hoc, it should get it from {@link MultiTenantConfig#tenantMap()} instead.
//	 */
//	@Bean @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
//	public AppManifest appManifest() throws ExecutionException {
//		final String tenantId = tenantRef().getTenantId();
//		final String tenantKey = tenantId + "_" + tenantRef().getTenantEnv();
//		return appManifestCache.get(tenantKey, new Callable<AppManifest>() {
//			@Override
//			public AppManifest call() throws Exception {
//				URL classpathManifest = MultiTenantWebConfig.class.getResource("/META-INF/" + tenantId + ".AppManifest.xmi");
//				if (classpathManifest != null) {
//					return new StaticXmiLoader<AppManifest>(CommonsPackage.eINSTANCE, classpathManifest, ResourceType.CLASSPATH).get();
//				} else {
//					return new StaticXmiLoader<AppManifest>(CommonsPackage.eINSTANCE,
//						new File(dataFolder(), "model/" + tenantKey + ".AppManifest.xmi").toString()).get();
//				}
//			}
//		});
//	}
//	
//	/**
//	 * @return
//	 * @throws ExecutionException
//	 * @todo Maybe, instead of loading ad-hoc, it should get it from {@link MultiTenantConfig#webAddressMap()} instead.
//	 */
//	@Bean @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
//	public WebAddress webAddress() throws ExecutionException {
//		final String tenantKey = tenantRef().getTenantId() + "_" + tenantRef().getTenantEnv();
//		return webAddressCache.get(tenantKey, new Callable<WebAddress>() {
//			@Override
//			public WebAddress call() throws Exception {
////				return new StaticXmiLoader<WebAddress>(CommonsPackage.eINSTANCE,
////						new File(dataFolder(), "model/custom.WebAddress.xmi").toString()).get();
//				final OnDemandXmiLoader<WebAddress> loader = new OnDemandXmiLoader<>(CommonsPackage.eINSTANCE,
//						MultiTenantWebConfig.class, "/META-INF/tenant.WebAddress.xmi");
//				loader.getScope().put("tenantId", tenantRef().getTenantId());
//				loader.getScope().put("tenantEnv", tenantRef().getTenantEnv());
//				return loader.get();
//			}
//		});
//	}

}

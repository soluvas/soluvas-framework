package org.soluvas.commons.config;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.felix.service.command.CommandSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.CommonsException;
import org.soluvas.commons.DataFolder;
import org.soluvas.commons.WebAddress;
import org.soluvas.commons.tenant.CommandRequestAttributes;
import org.soluvas.commons.tenant.RequestOrCommandScope;
import org.soluvas.commons.tenant.TenantMode;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.commons.tenant.TenantRefImpl;
import org.soluvas.commons.tenant.TenantUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
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
 * @author rudi
 */
@Configuration
public class MultiTenantWebConfig implements TenantSelector {
	
	private static final Logger log = LoggerFactory
			.getLogger(MultiTenantWebConfig.class);
//	@Inject
//	private HttpServletRequest request;
//	private static final Cache<String, AppManifest> appManifestCache = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build();
//	private static final Cache<String, WebAddress> webAddressCache = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build();
	
	@Inject
	private Environment env;
	@Inject
	private MultiTenantConfig tenantConfig;
//	@Resource(name="tenantMap")
//	private Map<String, AppManifest> tenantMap;
	
//	@Inject
//	private BeanFactory appCtx;
	
	/**
	 * @todo Replace with annotation https://jira.springsource.org/browse/SPR-5192 when it's supported.
	 * @return
	 */
	protected HttpServletRequest getRequest() {
		return ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
//		return appCtx.getBean(HttpServletRequest.class); // doesn't work
	}
	
	/**
	 * If you can't use Spring dependency injection, use this to get the {@link TenantRef}
	 * from a {@link HttpServletRequest}. 
	 * @param httpRequest
	 * @return
	 * @see MultiTenantConfig#webAddressMap()
	 */
	public static TenantRef getTenantRef(TenantMode tenantMode, HttpServletRequest httpRequest, String tenantEnv) {
		switch (tenantMode) {
		case MULTI_PATH:
			final String pathInfo = httpRequest.getPathInfo();
//		final String contextPath = Preconditions.checkNotNull(servletContext, "Cannot inject ServletContext")
//				.getContextPath();
			final Matcher tenantMatcher = Pattern.compile("\\/t/([^/]+)/([^/]+).*").matcher(pathInfo);
			Preconditions.checkState(tenantMatcher.matches(),
					"Path info '%s' must match pattern: /t/{tenantId}/{tenantEnv}",
					pathInfo);
			final TenantRef pathTenant = new TenantRefImpl(tenantMatcher.group(1), tenantMatcher.group(1), tenantMatcher.group(2));
			log.debug("MULTI_PATH Deployment Configuration for {}: clientId={} tenantId={} tenantEnv={}",
					pathInfo, pathTenant.getClientId(), pathTenant.getTenantId(), pathTenant.getTenantEnv() );
			return pathTenant;
		case MULTI_HOST:
			final String serverName = httpRequest.getServerName();
			final Matcher hostMatcher = Pattern.compile("(www\\.?)([^.]+).*").matcher(serverName);
			Preconditions.checkState(hostMatcher.matches(),
					"Server name '%s' must match pattern: (www\\.?)([^.]+).*", serverName);
			final String tenantId = hostMatcher.group(2).toLowerCase();
			// FIXME: Search host/domain from AppManifest/SysConfig/WebAddress 
			final TenantRef hostTenant = new TenantRefImpl(tenantId, tenantId, tenantEnv);
			log.debug("MULTI_HOST Deployment Configuration for {}: clientId={} tenantId={} tenantEnv={}",
					serverName, hostTenant.getClientId(), hostTenant.getTenantId(), hostTenant.getTenantEnv() );
			return hostTenant;
		default:
			throw new IllegalArgumentException("Unsupported tenantMode: " + tenantMode);
		}
	}
	
	@Bean @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
	@Override
	public TenantRef tenantRef() {
		final RequestAttributes requestAttrs = RequestOrCommandScope.currentRequestAttributes();
		if (requestAttrs instanceof ServletRequestAttributes) {
			return getTenantRef(env.getRequiredProperty("tenantMode", TenantMode.class),
					getRequest(), env.getRequiredProperty("tenantEnv"));
		} else if (requestAttrs instanceof CommandRequestAttributes) {
			final CommandSession session = ((CommandRequestAttributes) requestAttrs).getSession();
			try {
				final String clientId = Optional.fromNullable((String) session.get("clientId")).or(tenantConfig.tenantMap().keySet().iterator().next());
				final String tenantId = Optional.fromNullable((String) session.get("tenantId")).or(tenantConfig.tenantMap().keySet().iterator().next());
				final String tenantEnv = env.getRequiredProperty("tenantEnv");
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
		return System.getProperty("user.home") + "/" + tenantRef().getTenantId() + "_" + tenantRef().getTenantEnv();
	}
	
	@Bean @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
	public AppManifest appManifest() throws IOException {
		return Preconditions.checkNotNull(
				tenantConfig.tenantMap().get(tenantRef().getTenantId()),
				"Unknown tenant '%s'. %s available tenants are: %s",
				tenantRef().getTenantId(), tenantConfig.tenantMap().size(), tenantConfig.tenantMap().keySet());
	}

	@Bean @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES) @Primary
	public EventBus tenantEventBus() throws IOException {
		return Preconditions.checkNotNull(
				tenantConfig.eventBusMap().get(tenantRef().getTenantId()),
				"Unknown tenant EventBus '%s'. %s available EventBuses are for: %s",
				tenantRef().getTenantId(), tenantConfig.eventBusMap().size(), tenantConfig.eventBusMap().keySet());
	}
	
	@Bean @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
	public WebAddress webAddress() throws IOException {
		return Preconditions.checkNotNull(
				tenantConfig.webAddressMap().get(tenantRef().getTenantId()),
				"Unknown tenant WebAddress '%s'. %s available WebAddresses are for: %s",
				tenantRef().getTenantId(), tenantConfig.webAddressMap().size(), tenantConfig.webAddressMap().keySet());
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

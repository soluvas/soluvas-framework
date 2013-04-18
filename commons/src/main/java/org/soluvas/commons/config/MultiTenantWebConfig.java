package org.soluvas.commons.config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.tenant.TenantRef;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.google.common.base.Preconditions;

/**
 * Reads the tenant information from {@link ServletContext#getContextPath()}
 * e.g. http://localhost:8080/{hotelContext}/{app}/t/{tenantId}/{tenantEnv}.
 * Which means tenant is read per request.
 * @author rudi
 */
@Configuration @Lazy
public class MultiTenantWebConfig {
	
	private static final Logger log = LoggerFactory
			.getLogger(MultiTenantWebConfig.class);
	@Inject
	private ServletContext servletContext;
	
	@Bean @Scope("request")
	public TenantRef tenantRef() {
		final String contextPath = Preconditions.checkNotNull(servletContext, "Cannot inject ServletContext")
				.getContextPath();
		final Matcher tenantMatcher = Pattern.compile("\\/([^/]+)/([^/]+)/t/([^/]+)/([^/]+)").matcher(contextPath);
		Preconditions.checkState(tenantMatcher.matches(),
				"ContextPath %s must match pattern: {hotelContext}/{app}/{tenantId}/{tenantEnv}",
				contextPath);
		final TenantRef tenant = new TenantRef(tenantMatcher.group(3), tenantMatcher.group(3), tenantMatcher.group(4));
		log.debug("Multi-tenant Deployment Configuration for {}: clientId={} tenantId={} tenantEnv={} hotelContext={} app{}",
				contextPath, tenant.getClientId(), tenant.getTenantId(), tenant.getTenantEnv(), 
				tenantMatcher.group(1), tenantMatcher.group(2));
		return tenant;
	}
	
}

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

import com.google.common.base.Preconditions;

/**
 * Reads the tenant information from {@link ServletContext#getContextPath()}.
 * Which means single tenant per webapp context.
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
		final TenantRef tenant = new TenantRef(tenantMatcher.group(1), tenantMatcher.group(1), tenantMatcher.group(2));
		log.info("Single-tenant Deployment Configuration for {}: clientId={} tenantId={} tenantEnv={} appCode={}",
				contextPath, tenant.getClientId(), tenant.getTenantId(), tenant.getTenantEnv(), tenantMatcher.group(3));
		return tenant;
	}
	
}

package org.soluvas.commons.config;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Named;

import org.soluvas.commons.TenantSource;
import org.soluvas.commons.tenant.DirectoryTenantRepository;
import org.soluvas.commons.tenant.TenantProvisioner;
import org.soluvas.commons.tenant.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableSet;
import com.google.common.eventbus.EventBus;

/**
 * Please {@link Import} for {@link TenantSource#CONFIG} or {@link TenantSource#CLASSPATH}.
 * @author ceefour
 */
@Configuration
public class DirectorySourcedConfig {

	@Inject
	private Environment env;
	@Inject
	private ApplicationContext appCtx;
	@Inject
	private SoluvasApplication app;
	@Inject @Named(CommonsWebConfig.APP_EVENT_BUS)
	private EventBus appEventBus;
	@Autowired(required=false) @Nullable
	private TenantProvisioner<?> tenantProvisioner;
	
	@Bean(initMethod="init")
	public TenantRepository<?> tenantRepo() throws IOException {
		final String tenantEnv = env.getRequiredProperty("tenantEnv");
		final String appDomain = MultiTenantConfig.internalGetAppDomain(app.getId(), env);
		final File workspaceDir = MultiTenantConfig.internalGetWorkspaceDir(app.getId(), env);
		Preconditions.checkState(workspaceDir.exists(), "Application workspace directory '%s' must exist", workspaceDir);
		@Nullable
		final String tenantWhitelistStr = env.getProperty("tenantWhitelist", String.class);
		if (tenantWhitelistStr != null) {
			final Set<String> tenantWhitelist = ImmutableSet.copyOf( Splitter.on(',').trimResults().omitEmptyStrings().splitToList( tenantWhitelistStr ) );
			return new DirectoryTenantRepository(appEventBus, tenantEnv, appDomain, workspaceDir, tenantProvisioner, appCtx, tenantWhitelist);
		} else {
			return new DirectoryTenantRepository(appEventBus, tenantEnv, appDomain, workspaceDir, tenantProvisioner, appCtx);
		}
	}
	
}

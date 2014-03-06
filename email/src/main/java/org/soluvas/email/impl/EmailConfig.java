package org.soluvas.email.impl;

import java.io.IOException;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Named;

import org.soluvas.commons.AppManifest;
import org.soluvas.commons.WebAddress;
import org.soluvas.commons.config.CommonsWebConfig;
import org.soluvas.commons.config.MultiTenantConfig;
import org.soluvas.commons.config.TenantSelector;
import org.soluvas.commons.tenant.TenantBeanRepository;
import org.soluvas.commons.tenant.TenantRepository;
import org.soluvas.email.EmailCatalog;
import org.soluvas.email.EmailFactory;
import org.soluvas.email.EmailManager;
import org.soluvas.email.EmailSecurity;
import org.soluvas.email.util.EmailCatalogXmiTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import com.google.common.eventbus.EventBus;

@Configuration @Lazy
@ComponentScan("org.soluvas.email")
public class EmailConfig {
	
	@Inject
	private Environment env;
	@Inject @Named(CommonsWebConfig.APP_EVENT_BUS)
	private EventBus appEventBus;
	@Inject
	private MultiTenantConfig tenantConfig;
	@Inject
	private TenantSelector tenantSelector;
	@Autowired(required=false) @Nullable
	private TenantRepository<?> tenantRepo;
	
	@Bean
	public EmailCatalog emailCatalog() {
		final EmailCatalog emailCatalog = EmailFactory.eINSTANCE.createEmailCatalog();
		final EmailCatalogXmiTracker tracker = new EmailCatalogXmiTracker(
				emailCatalog, appEventBus);
		tracker.scan(EmailConfig.class.getClassLoader(), null);
		return emailCatalog;
	}
	
//		@Bean @Lazy(false)
//		public EmailCatalogXmiTracker emailCatalogXmiTracker() {
//			final EmailCatalogXmiTracker tracker = new EmailCatalogXmiTracker(emailCatalog(), eventBus);
//			tracker.add(org.soluvas.email.EmailPackage.class, "org.soluvas.email");
//			tracker.add(EmailPackage.class, "id.co.bippo.email");
//			return tracker;
//		}
	
	@Bean(destroyMethod="destroy")
	public TenantBeanRepository<EmailManagerImpl> emailMgrBeanRepo() throws IOException {
		final String smtpHost = env.getRequiredProperty("emailSmtpHost");
		final int smtpPort = env.getRequiredProperty("emailSmtpPort", Integer.class);
		final String smtpUser = env.getRequiredProperty("emailSmtpUser");
		final String smtpPassword = env.getRequiredProperty("emailSmtpPassword");
		final EmailSecurity smtpSecurity = env.getRequiredProperty("emailSmtpSecurity", EmailSecurity.class);
		return new TenantBeanRepository<EmailManagerImpl>(EmailManagerImpl.class, tenantConfig.tenantMap(), appEventBus, tenantRepo) {
			@Override
			protected EmailManagerImpl create(String tenantId, AppManifest appManifest) throws Exception {
//					final EventBus tenantEventBus = tenantConfig.eventBusMap().get(tenantId);
				final WebAddress webAddress = tenantConfig.webAddressMap().get(tenantId);
				final EmailManagerImpl emailMgr = new EmailManagerImpl(emailCatalog(), "bippo", "bippo",
						smtpHost, smtpPort, smtpUser, smtpPassword, smtpSecurity,
						appManifest, webAddress);
				return emailMgr;
			}
		};
	}
	
	@Bean @Scope("request")
	public EmailManager emailMgr() throws IOException {
		return emailMgrBeanRepo().get(tenantSelector.tenantRef().getTenantId());
	}
	
}

package org.soluvas.email.impl;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Named;

import org.soluvas.commons.AppManifest;
import org.soluvas.commons.WebAddress;
import org.soluvas.commons.config.CommonsWebConfig;
import org.soluvas.commons.config.MultiTenantWebAddressConfig;
import org.soluvas.commons.tenant.TenantBeans;
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
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import com.google.common.eventbus.EventBus;

@Configuration
@ComponentScan("org.soluvas.email.shell")
public class EmailConfig {
	
	@Inject
	private Environment env;
	@Inject @Named(CommonsWebConfig.APP_EVENT_BUS)
	private EventBus appEventBus;
	@Inject
	private MultiTenantWebAddressConfig webAddressConfig;
	@Autowired(required=false) @Nullable
	private TenantRepository<?> tenantRepo;
	
	@Bean
	public EmailCatalog emailCatalog() {
		final EmailCatalog emailCatalog = EmailFactory.eINSTANCE.createEmailCatalog();
		final EmailCatalogXmiTracker tracker = new EmailCatalogXmiTracker(
				emailCatalog, appEventBus);
		// This scans only once per app (not per tenant), so not too slow, although yes I still prefer static/hybrid approach if practical
		tracker.scan(EmailConfig.class.getClassLoader(), null);
		return emailCatalog;
	}
	
//		@Bean
//		public EmailCatalogXmiTracker emailCatalogXmiTracker() {
//			final EmailCatalogXmiTracker tracker = new EmailCatalogXmiTracker(emailCatalog(), eventBus);
//			tracker.add(org.soluvas.email.EmailPackage.class, "org.soluvas.email");
//			tracker.add(EmailPackage.class, "id.co.bippo.email");
//			return tracker;
//		}
	
	@Bean
	public TenantBeans<EmailManagerImpl> emailMgrBeans() {
		final String smtpHost = env.getRequiredProperty("emailSmtpHost");
		final int smtpPort = env.getRequiredProperty("emailSmtpPort", Integer.class);
		final String smtpUser = env.getRequiredProperty("emailSmtpUser");
		final String smtpPassword = env.getRequiredProperty("emailSmtpPassword");
		final EmailSecurity smtpSecurity = env.getRequiredProperty("emailSmtpSecurity", EmailSecurity.class);
		final String layout = env.getProperty("emailLayout", String.class);
		final Class<?> layoutClass;
		try {
			layoutClass = layout != null ? EmailConfig.class.getClassLoader().loadClass(layout) : null;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Cannot load emailLayout class: " + e, e);
		}
		final String layoutNsPrefix = env.getProperty("emailLayoutNsPrefix", "bippo");
		final String layoutName = env.getProperty("emailLayoutName", "bippo");
		return new TenantBeans<EmailManagerImpl>(EmailManagerImpl.class) {
			@Override
			protected EmailManagerImpl create(String tenantId, AppManifest appManifest) throws Exception {
//					final EventBus tenantEventBus = tenantConfig.eventBusMap().get(tenantId);
				final WebAddress webAddress = webAddressConfig.webAddressMap().get(tenantId);
				final EmailManagerImpl emailMgr = new EmailManagerImpl(emailCatalog(), layoutClass, layoutNsPrefix,
						layoutName, smtpHost, smtpPort, smtpUser, smtpPassword,
						smtpSecurity, appManifest, webAddress);
				return emailMgr;
			}
		};
	}
	
	@Bean @Scope("prototype")
	public EmailManager emailMgr() {
		return emailMgrBeans().getCurrent();
	}
	
}

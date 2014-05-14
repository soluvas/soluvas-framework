package org.soluvas.newsletter;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Named;

import org.soluvas.commons.AppManifest;
import org.soluvas.commons.config.CommonsWebConfig;
import org.soluvas.commons.config.MultiTenantConfig;
import org.soluvas.commons.config.SysConfigMapHolder;
import org.soluvas.commons.config.TenantSelector;
import org.soluvas.commons.tenant.TenantBeans;
import org.soluvas.commons.tenant.TenantRepository;
import org.soluvas.commons.tenant.TenantUtils;
import org.soluvas.newsletter.impl.MailjetManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import com.google.common.eventbus.EventBus;

/**
 * {@link Configuration} for {@link Mailjet}.
 * @author ceefour
 */
@Configuration
@Import(NewsletterConfig.class)
public class MailjetConfig {
	
	@Inject
	private TenantSelector tenantSelector;
	@Inject
	private MultiTenantConfig tenantConfig;
	@Inject @Named(CommonsWebConfig.APP_EVENT_BUS)
	private EventBus appEventBus;
	@Inject
	private SysConfigMapHolder<MailjetSysConfig> sysConfigMapHolder;
	@Autowired(required=false) @Nullable
	private TenantRepository<?> tenantRepo;
	
	@Bean(destroyMethod="destroy")
	public TenantBeans<MailjetManager> mailjetMgrBeans() {
		return new TenantBeans<MailjetManager>(MailjetManagerImpl.class) {
			@Override
			protected MailjetManagerImpl create(String tenantId, AppManifest appManifest)
					throws Exception {
				final MailjetSysConfig sysConfig = TenantUtils.selectBean(tenantId, sysConfigMapHolder.sysConfigMap(), MailjetSysConfig.class);
				return new MailjetManagerImpl(sysConfig.getMailjetEnabled() != null && sysConfig.getMailjetEnabled(),
						sysConfig.getMailjetApiKey(), sysConfig.getMailjetSecretKey(), sysConfig.getMailjetListId());
			}
		};
	}
	
	@Bean @Scope("prototype")
	public MailjetManager mailjetMgr() {
		return mailjetMgrBeans().get(tenantSelector.tenantRef().getTenantId());
	}
	
}
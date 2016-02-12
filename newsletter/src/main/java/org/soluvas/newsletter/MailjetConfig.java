package org.soluvas.newsletter;

import javax.inject.Inject;

import org.soluvas.commons.AppManifest;
import org.soluvas.commons.config.SysConfigMapHolder;
import org.soluvas.commons.tenant.TenantBeans;
import org.soluvas.commons.tenant.TenantUtils;
import org.soluvas.newsletter.impl.MailjetCredentialImpl;
import org.soluvas.newsletter.impl.MailjetManagerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

/**
 * {@link Configuration} for {@link Mailjet}.
 * @author ceefour
 */
@Configuration
@Import(NewsletterConfig.class)
public class MailjetConfig {
	
	@Inject
	private SysConfigMapHolder<? extends MailjetSysConfig> sysConfigMapHolder;
	
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
	
	@Bean(destroyMethod="destroy")
	public TenantBeans<MailjetServiceManager> mjServiceMgrBeans() {
		return new TenantBeans<MailjetServiceManager>(MailjetServiceManagerImpl.class) {
			@Override
			protected MailjetServiceManager create(String tenantId,
					AppManifest appManifest) throws Exception {
				final MailjetSysConfig mjConfig = TenantUtils.selectBean(tenantId, sysConfigMapHolder.sysConfigMap(), 
						MailjetSysConfig.class);
				
				final String contactID = String.valueOf(mjConfig.getMailjetListId());
				final MailjetCredentialImpl mjCredential = new MailjetCredentialImpl(mjConfig.getMailjetApiKey(), 
						mjConfig.getMailjetSecretKey(), contactID);
				final MailjetServiceManagerImpl mjServiceMgr = new MailjetServiceManagerImpl(mjCredential, 
						mjConfig.getMailjetEnabled());
				
				return mjServiceMgr;
			}
			
		};
	}
	
	
	@Bean @Scope("prototype")
	public MailjetManager mailjetMgr() {
		return mailjetMgrBeans().getCurrent();
	}
	
	@Bean @Scope("prototype")
	public MailjetServiceManager mjServiceMgr() {
		return mjServiceMgrBeans().getCurrent();
	}
	
}
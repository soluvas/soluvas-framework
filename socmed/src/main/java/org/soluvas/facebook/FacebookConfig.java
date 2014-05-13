package org.soluvas.facebook;

import javax.inject.Inject;

import org.soluvas.commons.AppManifest;
import org.soluvas.commons.config.SysConfigMapHolder;
import org.soluvas.commons.tenant.TenantBeans;
import org.soluvas.commons.tenant.TenantUtils;
import org.soluvas.socmed.FacebookSysConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.restfb.DefaultFacebookClient;

@Configuration
@ComponentScan("org.soluvas.facebook.shell")
public class FacebookConfig {

	@Inject
	private SysConfigMapHolder<FacebookSysConfig> sysConfigMapHolder;
	
	@Bean
	public TenantBeans<DefaultFacebookClient> tenantFacebookClientBeans() {
		return new TenantBeans<DefaultFacebookClient>(DefaultFacebookClient.class) {
			@Override
			protected DefaultFacebookClient create(String tenantId, AppManifest appManifest)
					throws Exception {
				final FacebookSysConfig sysConfig = TenantUtils.selectBean(tenantId, sysConfigMapHolder.sysConfigMap(), FacebookSysConfig.class);
				return new DefaultFacebookClient(sysConfig.getFacebookTenantAccessToken());
			}
		};
	}
	
	@Bean @Scope("prototype")
	public DefaultFacebookClient tenantFacebookClient() {
		return tenantFacebookClientBeans().getCurrent();
	}
	
	@Bean 
	public TenantBeans<FacebookManager> facebookMgrBeans() {
		return new TenantBeans<FacebookManager>(FacebookManagerImpl.class) {
			@Override
			protected FacebookManagerImpl create(String tenantId, AppManifest appManifest)
					throws Exception {
				final FacebookSysConfig sysConfig = TenantUtils.selectBean(tenantId, sysConfigMapHolder.sysConfigMap(), FacebookSysConfig.class);
				return new FacebookManagerImpl(String.valueOf(sysConfig.getFacebookAppId()), sysConfig.getFacebookAppSecret(),
						sysConfig.getFacebookTenantAccessToken(), sysConfig.getFacebookTenantPageId());
			}
		};
	}
	
	@Bean @Scope("prototype")
	public FacebookManager facebookMgr() {
		return facebookMgrBeans().getCurrent();
	}
	
}
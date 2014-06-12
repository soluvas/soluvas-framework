package org.soluvas.twitter;

import javax.inject.Inject;

import org.soluvas.commons.AppManifest;
import org.soluvas.commons.config.SysConfigMapHolder;
import org.soluvas.commons.tenant.TenantBeans;
import org.soluvas.commons.tenant.TenantUtils;
import org.soluvas.socmed.TwitterSysConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("org.soluvas.twitter.shell")
public class TwitterConfig {

	@Inject
	private SysConfigMapHolder<? extends TwitterSysConfig> sysConfigMapHolder;
	
	@Bean
	public TenantBeans<TwitterManager> twitterMgrBeans() {
		return new TenantBeans<TwitterManager>(TwitterManagerImpl.class) {
			@Override
			protected TwitterManagerImpl create(String tenantId, AppManifest appManifest)
					throws Exception {
				final TwitterSysConfig sysConfig = TenantUtils.selectBean(tenantId, sysConfigMapHolder.sysConfigMap(), TwitterSysConfig.class);
				return new TwitterManagerImpl(
						sysConfig.getTwitterConsumerKey(), sysConfig.getTwitterConsumerSecret(),
						sysConfig.getTwitterTenantScreenName(),
						sysConfig.getTwitterTenantAccessToken(), sysConfig.getTwitterTenantAccessTokenSecret() );
			}
		};
	}
	
	@Bean @Scope("prototype")
	public TwitterManager twitterMgr() {
		return twitterMgrBeans().getCurrent();
	}
	
}

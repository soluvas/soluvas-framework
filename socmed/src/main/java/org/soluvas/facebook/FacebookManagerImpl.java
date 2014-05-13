package org.soluvas.facebook;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author haidar
 */
public class FacebookManagerImpl implements FacebookManager  {

	private final String appId;
	private final String appSecret;
	private final String pageAccessToken;
	private final String pageId;
	
	@Inject
	public FacebookManagerImpl(
			@Value("#{soluvasProps.authFacebookAppId}") String appId,
			@Value("#{soluvasProps.authFacebookAppSecret}") String appSecret,
			@Value("#{soluvasProps.facebookPageAccessToken}") String pageAccessToken,
			@Value("#{soluvasProps.facebookPageId}") String pageId) {
		super();
		this.appId = appId;
		this.appSecret = appSecret;
		this.pageAccessToken = pageAccessToken;
		this.pageId = pageId;
	}
	
	@Override
	public String getAppId() {
		return appId;
	}
	
	@Override
	public String getAppSecret() {
		return appSecret;
	}

	@Override
	public String getPageAccessToken() {
		return pageAccessToken;
	}

	@Override
	public String getPageId() {
		return pageId;
	}
	
}

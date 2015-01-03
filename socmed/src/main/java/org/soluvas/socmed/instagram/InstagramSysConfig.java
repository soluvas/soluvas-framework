package org.soluvas.socmed.instagram;

import org.joda.time.DateTime;

/**
 * A SysConfig which is usable by app, tenant, shop, or person level.
 * 
 * <p>App ID and App Secret are domain-specific, so usually provided by tenant.
 * Although for multitenant-intesive applications like Bippo Commerce, it's much more practical
 * to use an app-wide app ID and secret.
 * 
 * <p>App- or tenant- scoped access token is recommended to get read access to any public Instagram user media feed.
 * 
 * <p>While {@link #getInstagramApiKey()} and {@link #getInstagramApiSecret()} are fixed
 * (and can be configured via {@code application.properties}),
 * {@link #getInstagramAccessToken()} and {@link #getInstagramAccessTokenExpiry()} are usually
 * updated (interactively) from time to time.
 * 
 * @author ceefour
 * @see InstagramSysConfigImpl
 */
public interface InstagramSysConfig {
	
	public final String API_KEY_PROPERTY = "instagramApiKey";
	public final String ACCESS_TOKEN_PROPERTY = "instagramAccessToken";

	public abstract String getInstagramApiKey();

	public abstract void setInstagramApiKey(String instagramAppId);

	public abstract String getInstagramApiSecret();

	public abstract void setInstagramApiSecret(String instagramAppSecret);

	public abstract String getInstagramAccessToken();

	public abstract void setInstagramAccessToken(String instagramAccessToken);

	DateTime getInstagramAccessTokenExpiry();

	void setInstagramAccessTokenExpiry(DateTime instagramAccessTokenExpiry);

	/**
	 * Our base redirect URI (without additional query parameters), usually {@code https://www.mydomain.com/instagram/auth}.
	 * @return
	 */
	String getInstagramCallbackUri();

	void setInstagramCallbackUri(String instagramAuthUri);

}
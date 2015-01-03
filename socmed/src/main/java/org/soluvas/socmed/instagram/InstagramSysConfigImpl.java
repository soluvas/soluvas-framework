package org.soluvas.socmed.instagram;

import java.io.Serializable;

import org.joda.time.DateTime;
import org.springframework.core.env.Environment;

/**
 * @author ceefour
 *
 */
public class InstagramSysConfigImpl implements Serializable, InstagramSysConfig {
	
	private static final long serialVersionUID = 1L;
	private String instagramApiKey;
	private String instagramApiSecret;
	private String instagramCallbackUri;
	private String instagramAccessToken;
	private DateTime instagramAccessTokenExpiry;
	
	public InstagramSysConfigImpl() {
		super();
	}

	/**
	 * Create an app-wide instance using {@link Environment}.
	 * @param env
	 */
	public InstagramSysConfigImpl(Environment env) {
		super();
		setInstagramApiKey(env.getRequiredProperty(API_KEY_PROPERTY));
		setInstagramApiSecret(env.getRequiredProperty("instagramApiSecret"));
		setInstagramCallbackUri(env.getProperty("instagramCallbackUri"));
		setInstagramAccessToken(env.getProperty(ACCESS_TOKEN_PROPERTY));
		if (env.containsProperty("instagramAccessTokenExpiry")) {
			setInstagramAccessTokenExpiry(new DateTime(env.getProperty("instagramAccessTokenExpiry")));
		}
	}

	/* (non-Javadoc)
	 * @see org.soluvas.socmed.instagram.InstagramSysConfig#getInstagramAppId()
	 */
	@Override
	public String getInstagramApiKey() {
		return instagramApiKey;
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.socmed.instagram.InstagramSysConfig#setInstagramAppId(java.lang.String)
	 */
	@Override
	public void setInstagramApiKey(String instagramApiKey) {
		this.instagramApiKey = instagramApiKey;
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.socmed.instagram.InstagramSysConfig#getInstagramAppSecret()
	 */
	@Override
	public String getInstagramApiSecret() {
		return instagramApiSecret;
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.socmed.instagram.InstagramSysConfig#setInstagramAppSecret(java.lang.String)
	 */
	@Override
	public void setInstagramApiSecret(String instagramApiSecret) {
		this.instagramApiSecret = instagramApiSecret;
	}

	@Override
	public String getInstagramCallbackUri() {
		return instagramCallbackUri;
	}

	@Override
	public void setInstagramCallbackUri(String instagramAuthUri) {
		this.instagramCallbackUri = instagramAuthUri;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.socmed.instagram.InstagramSysConfig#getInstagramAccessToken()
	 */
	@Override
	public String getInstagramAccessToken() {
		return instagramAccessToken;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.socmed.instagram.InstagramSysConfig#setInstagramAccessToken(java.lang.String)
	 */
	@Override
	public void setInstagramAccessToken(String instagramAccessToken) {
		this.instagramAccessToken = instagramAccessToken;
	}

	@Override
	public DateTime getInstagramAccessTokenExpiry() {
		return instagramAccessTokenExpiry;
	}

	@Override
	public void setInstagramAccessTokenExpiry(DateTime instagramAccessTokenExpiry) {
		this.instagramAccessTokenExpiry = instagramAccessTokenExpiry;
	}
	
}

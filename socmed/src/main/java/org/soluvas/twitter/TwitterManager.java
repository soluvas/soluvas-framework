package org.soluvas.twitter;

import twitter4j.Twitter;

/**
 * Get Access ConsumerKey and ConsumerSecret and Get AccessToken and AccessSecrets
 * @author haidar
 *
 */
public interface TwitterManager {

	public abstract String getConsumerKey();

	public abstract String getConsumerSecret();

	/**
	 * Twitter screen name of the app itself, usually used for manual RT-ing
	 * or for mentions.
	 * @return
	 */
	public String getAppScreenName();

	/**
	 * Twitter OAuth access token of the app itself, used to tweet using
	 * the app's Twitter account.
	 * @return
	 */
	public String getAppAccessToken();

	/**
	 * Twitter OAuth access token secret of the app itself, used to tweet using
	 * the app's Twitter account
	 * @return
	 */
	public String getAppAccessTokenSecret();
	
	Twitter createTwitter();

	Twitter createTwitter(String accessToken, String accessTokenSecret);
}

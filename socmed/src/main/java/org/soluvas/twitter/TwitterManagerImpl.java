package org.soluvas.twitter;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

/**
 * @author haidar
 *
 */
@Service("twitterMgr") @Lazy
public class TwitterManagerImpl implements TwitterManager  {

	private final String consumerKey;
	private final String consumerSecret;
	private final String appScreenName;
	private final String appAccessToken;
	private final String appAccessTokenSecret;
	
	@Inject
	public TwitterManagerImpl(
			@Value("#{soluvasProps.authTwitterConsumerKey}") String consumerKey,
			@Value("#{soluvasProps.authTwitterConsumerSecret}") String consumerSecret,
			@Value("#{soluvasProps.twitterAppScreenName}") String appScreenName,
			@Value("#{soluvasProps.twitterAppAccessToken}") String appAccessToken,
			@Value("#{soluvasProps.twitterAppAccessTokenSecret}") String appAccessTokenSecret) {
		super();
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
		this.appScreenName = appScreenName;
		this.appAccessToken = appAccessToken;
		this.appAccessTokenSecret = appAccessTokenSecret;
	}
	
	@Override
	public Twitter createTwitter() {
		final Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(consumerKey, consumerSecret);
		return twitter;
	}

	@Override
	public Twitter createTwitter(String accessToken, String accessTokenSecret) {
		final Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(consumerKey, consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(accessToken, accessTokenSecret));
		return twitter;
	}

	@Override
	public String getConsumerKey() {
		return consumerKey;
	}
	
	@Override
	public String getConsumerSecret() {
		return consumerSecret;
	}

	@Override
	public String getAppScreenName() {
		return appScreenName;
	}

	@Override
	public String getAppAccessToken() {
		return appAccessToken;
	}

	@Override
	public String getAppAccessTokenSecret() {
		return appAccessTokenSecret;
	}
	
}

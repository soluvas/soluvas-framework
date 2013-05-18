package org.soluvas.twitter.shell;

import static org.fusesource.jansi.Ansi.ansi;

import javax.inject.Inject;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.soluvas.commons.TwitterAccessible;
import org.soluvas.commons.annotation.TwitterRelated;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.data.EntityLookup;
import org.soluvas.twitter.TwitterManager;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

/**
 * Retweets using {@link Twitter#retweetStatus(long)}.
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="twitter", name="rt", description="Retweets, with optional support for GeoLocation and media.")
public class TwitterRtCommand extends ExtCommandSupport {
	
	@Option(name="-c", description="Specify custom Twitter OAuth Consumer key, if not using TwitterManager configuration.")
	private String consumerKey;
	@Option(name="-s", description="Twitter other OAuth Consumer secret, if not using TwitterManager configuration.")
	private String consumerSecret;
	@Option(name="-i", description="Find the specified TwitterAccessible ID using @TwitterRelated EntityLookup to get the access token pair. Must be specified if not using -a and -t.")
	private String id;
	@Option(name="-a", description="OAuth Access Token for the tweeting Twitter user, must be specified if not using -i.")
	private String accessToken;
	@Option(name="-t", description="OAuth Access Token Secret for the tweeting Twitter user, must be specified if not using -i.")
	private String accessTokenSecret;
	
	@Argument(index=0, name="status ID", required=true, description="Status to retweet.")
	private long statusId;
	
	private final TwitterManager twitterMgr;
	private final EntityLookup<TwitterAccessible, String> lookup;

	@Inject
	public TwitterRtCommand(TwitterManager twitterMgr, @TwitterRelated EntityLookup<TwitterAccessible, String> lookup) {
		super();
		this.twitterMgr = twitterMgr;
		this.lookup = lookup;
	}

	@Override
	protected Object doExecute() throws Exception {
		Preconditions.checkArgument(id != null || (accessToken != null && accessTokenSecret != null),
				"Either id or access token pair must be specified.");

		final Twitter twitter = new TwitterFactory().getInstance();
		final String realConsumerKey = Optional.fromNullable(consumerKey).or(twitterMgr.getConsumerKey());
		
		twitter.setOAuthConsumer(realConsumerKey, 
				Optional.fromNullable(consumerSecret).or(twitterMgr.getConsumerSecret()));
		final String realToken;
		if (id != null) {
			final TwitterAccessible twitterAccessible = Preconditions.checkNotNull(lookup.findOne(id),
					"Cannot find '%s' using %s", id, lookup);
			realToken = twitterAccessible.getTwitterAccessToken();
			twitter.setOAuthAccessToken(new AccessToken(realToken, 
					twitterAccessible.getTwitterAccessTokenSecret()));
		} else {
			realToken = accessToken;
			twitter.setOAuthAccessToken(new AccessToken(accessToken, accessTokenSecret));
		}
		
		log.info("Retweeting using consumer {} token {}: {}", realConsumerKey, realToken, statusId);
		System.out.println(ansi().render("Consumer key: @|yellow %s|@", realConsumerKey));
		System.out.println(ansi().render("Access token: @|yellow %s|@", realToken));
		System.out.println(ansi().render("Retweeting @|bold %s|@ ...", statusId));
		final Status postedStatus = twitter.retweetStatus(statusId);
		log.info("Retweeted: {}", postedStatus);
		System.out.println(ansi().render("@|bold %s|@ @@|bold %s|@ %s", 
				postedStatus.getId(), postedStatus.getUser().getScreenName(), postedStatus.getCreatedAt()));
		return postedStatus.getId();
	}

}

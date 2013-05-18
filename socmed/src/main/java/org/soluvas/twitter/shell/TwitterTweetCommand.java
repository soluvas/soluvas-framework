package org.soluvas.twitter.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.TwitterAccessible;
import org.soluvas.commons.annotation.TwitterRelated;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.data.EntityLookup;
import org.soluvas.twitter.TwitterManager;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import twitter4j.GeoLocation;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

/**
 * Tweets or replies using {@link Twitter#updateStatus(StatusUpdate)}, with optional support for {@link GeoLocation} and media.
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="twitter", name="tweet", description="Tweets or replies, with optional support for GeoLocation and media.")
public class TwitterTweetCommand extends ExtCommandSupport {
	
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
	@Option(name="-r", description="In reply to Status ID. Note: @ mention is NOT prepended, please use mention in status message.")
	private Long reply;
	@Option(name="-l", description="Comma-separated latitude then longitude GeoLocation e.g. 37.786971,-122.399677.")
	private String geo;
	@Option(name="-m", description="Attached media URI. If it's not a local file it's downloaded before uploaded.")
	private String media;
	@Option(name="-p", description="Place ID.")
	private String placeId;
	@Option(name="-d", description="Display coordinates (only effective if geolocation or place ID is provided). If true, the exact coordinates are given. If false, only the place is given.")
	private transient boolean displayCoordinates = true;
	
	@Argument(index=0, name="message", required=true, description="Message to tweet.")
	private String message;
	
	private final TwitterManager twitterMgr;
	private final EntityLookup<TwitterAccessible, String> lookup;

	@Inject
	public TwitterTweetCommand(TwitterManager twitterMgr, @TwitterRelated EntityLookup<TwitterAccessible, String> lookup) {
		super();
		this.twitterMgr = twitterMgr;
		this.lookup = lookup;
	}

	@Override
	protected Object doExecute() throws Exception {
		Preconditions.checkArgument(id != null || (accessToken != null && accessTokenSecret != null),
				"Either id or access token pair must be specified.");

		File tmpFile = null;
		
		try {
			final StatusUpdate statusUpdate = new StatusUpdate(message);
			if (reply != null) {
				statusUpdate.inReplyToStatusId(reply);
			}
			if (geo != null) {
				final Matcher matcher = Pattern.compile("([0-9.-]+),([0-9.-]+)").matcher(geo);
				Preconditions.checkArgument(matcher.matches(), "Invalid geolocation syntax: %s", geo);
				final Double latitude = Double.valueOf(matcher.group(1));
				final Double longitude = Double.valueOf(matcher.group(2));
				statusUpdate.location(new GeoLocation(latitude, longitude));
				statusUpdate.setDisplayCoordinates(displayCoordinates);
			}
			if (placeId != null) {
				statusUpdate.setPlaceId(placeId);
				statusUpdate.setDisplayCoordinates(true);
			}
			if (media != null) {
				if (media.startsWith("/")) {
					statusUpdate.media(new File(media));
				} else if (media.startsWith("file:")) {
					statusUpdate.media(new File(new URI(media)));
				} else {
					tmpFile = File.createTempFile(SlugUtils.generateId(media), ".tmp");
					log.debug("Downloading {} to {}", media, tmpFile);
					System.out.print(ansi().render("Downloading @|bold %s|@ to @|bold %s|@ ...", media, tmpFile));
					FileUtils.copyURLToFile(new URL(media), tmpFile);
					System.out.println(ansi().render(" @|bg_green,bold,white  OK |@"));
					statusUpdate.media(tmpFile);
				}
			}
			
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
			
			log.info("Tweeting using consumer {} token {}: {}", realConsumerKey, realToken, statusUpdate);
			System.out.println(ansi().render("Consumer key: @|yellow %s|@", realConsumerKey));
			System.out.println(ansi().render("Access token: @|yellow %s|@", realToken));
			System.out.println(ansi().render("Tweeting: @|bold %s|@ ...",message));
			final Status postedStatus = twitter.updateStatus(statusUpdate);
			log.info("Tweeted {}", postedStatus);
			System.out.println(ansi().render("@|bold %s|@ @@|bold %s|@ %s", 
					postedStatus.getId(), postedStatus.getUser().getScreenName(), postedStatus.getCreatedAt()));
			return postedStatus.getId();
		} finally {
			if (tmpFile != null) {
				tmpFile.delete();
			}
		}
	}

}

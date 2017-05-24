package org.soluvas.twitter;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.entity.Person2;
import org.soluvas.image.store.Image;
import org.soluvas.image.store.ImageRepository;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

import com.google.common.base.Preconditions;

/**
 * Inspired by org.soluvas.fbcli.FriendListDownloader.
 * @author ceefour
 */
public class TwitterUtils {
	
	private static final Logger log = LoggerFactory.getLogger(TwitterUtils.class);
	
	/**
	 * Fetches twitter user photo from twitter, uploads it to ImageRepository, but not modify any {@link Person2}.
	 * @param person Person name, used for the image name and for logging purposes.
	 * @param consumerKey TODO
	 * @param consumerSecret TODO
	 * @return ImageID from the ImageRepository.
	 * @throws TwitterException 
	 */
	public static String refreshPhotoFromTwitter(final Person2 person, String consumerKey,
			String consumerSecret, ImageRepository imageRepo) throws TwitterException {
		Preconditions.checkNotNull(person, "Person must not be null.");
		final String personTwitterAt = Preconditions.checkNotNull(person.getTwitterAccessToken(),
				"Person %s must has twitter access token.", person.getId());
		final String personTwitterAts = Preconditions.checkNotNull(person.getTwitterAccessTokenSecret(),
				"Person %s must has twitter access token.", person.getId());
		final String personTwitterSn = Preconditions.checkNotNull(person.getTwitterScreenName(),
				"Person %s must has twitter access token.", person.getId());
		
		final ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setOAuthConsumerKey(consumerKey)
			.setOAuthConsumerSecret(consumerSecret)
			.setOAuthAccessToken(personTwitterAt)
			.setOAuthAccessTokenSecret(personTwitterAts);
		final Twitter twitter = new TwitterFactory(cb.build()).getInstance();
		
		final User user = twitter.showUser(personTwitterSn);
		
		final String originalProfileImageURL = user.getOriginalProfileImageURL();
		log.debug("User {} ({}) original photo profile url: {}", user.getId(), user.getName(), originalProfileImageURL);
		return refreshPhotoFromTwitter(originalProfileImageURL, personTwitterSn, person.getName(), imageRepo);
	}

	/**
	 * Fetches twitter user photo from twitter, uploads it to ImageRepository, but not modify any {@link Person2}.
	 * @param twitterScreenName twitter User ID.
	 * @param personName Person name, used for the image name and for logging purposes.
	 * @return ImageID from the ImageRepository.
	 * @deprecated Use {@link #refreshPhotoFromTwitter(Person2, String, String, org.soluvas.image.store.ImageRepository)}
	 */
	@Deprecated
	public static String refreshPhotoFromTwitter(final String twitterScreenName, final String personName,
												 ImageRepository imageRepo) {
		Preconditions.checkNotNull(twitterScreenName, "Twitter screen name must be specified");
		final String photoUrl = "https://api.twitter.com/1/users/profile_image?screen_name=" + twitterScreenName + "&size=bigger";
		return refreshPhotoFromTwitter(photoUrl, twitterScreenName, personName, imageRepo);
	}

	public static String refreshPhotoFromTwitter(
			String photoUrl, final String twitterScreenName, 
			final String personName, ImageRepository imageRepo) {
		Preconditions.checkNotNull(twitterScreenName, "Twitter screen name must be specified");
		try (final CloseableHttpClient httpClient = HttpClients.createDefault()) {
			log.debug("Photo URL for twitter user {} ({}) is {}", twitterScreenName, personName, photoUrl);
			final HttpGet httpGet = new HttpGet(photoUrl);
			try (final CloseableHttpResponse response = httpClient.execute(httpGet)) {
				final File tmpFile = File.createTempFile("twitter_", ".jpg");
				try {
					FileUtils.copyInputStreamToFile(response.getEntity().getContent(), tmpFile);
					log.debug("Photo Status Line {}",  response.getStatusLine());
					final Image newImage = new Image(tmpFile, response.getEntity().getContentType().getValue(),
							personName + " twitter " + twitterScreenName);
					final String imageId = imageRepo.add(newImage).getId();
					log.debug("tmp file path from twitter user {} is {}", tmpFile);
					return imageId;
				} finally {
					tmpFile.delete();
				}
			}
		} catch (final Exception e) {
			throw new RuntimeException("Cannot refresh Twitter user " + twitterScreenName + " (" + personName +") from Twitter URI " + photoUrl, e);
		}
	}
	
}

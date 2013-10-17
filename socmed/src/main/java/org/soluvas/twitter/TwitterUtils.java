package org.soluvas.twitter;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Person;
import org.soluvas.image.store.Image;
import org.soluvas.image.store.ImageRepository;

import com.google.common.base.Preconditions;

/**
 * Inspired by org.soluvas.fbcli.FriendListDownloader.
 * @author ceefour
 */
public class TwitterUtils {
	
	private static final Logger log = LoggerFactory.getLogger(TwitterUtils.class);
	
	/**
	 * Fetches twitter user photo from twitter, uploads it to ImageRepository, but not modify any {@link Person}.
	 * @param twitterScreenName twitter User ID.
	 * @param personName Person name, used for the image name and for logging purposes.
	 * @return ImageID from the ImageRepository.
	 */
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
			final HttpGet httpGet = new HttpGet(photoUrl);
			log.debug("Photo URL for twitter user {} ({}) is {}", twitterScreenName, personName, photoUrl);
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

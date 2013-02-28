package org.soluvas.twitter;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.image.store.Image;
import org.soluvas.image.store.ImageRepository;
import org.soluvas.ldap.SocialPerson;

import com.google.common.base.Strings;

/**
 * Inspired by org.soluvas.fbcli.FriendListDownloader.
 * @author ceefour
 */
public class TwitterUtils {
	
	private transient static Logger log = LoggerFactory.getLogger(TwitterUtils.class);
	
	public TwitterUtils() {
		super();
	}
	
	/**
	 * Fetches twitter user photo from twitter, uploads it to ImageRepository, but not modify any {@link SocialPerson}.
	 * @param twitterScreenName twitter User ID.
	 * @param personName Person name, used for the image name and for logging purposes.
	 * @return ImageID from the ImageRepository.
	 */
	public static String refreshPhotoFromTwitter(final String twitterScreenName, final String personName,
			ImageRepository imageRepo) {
		if (Strings.isNullOrEmpty(twitterScreenName)) {
			log.warn("Twitter Screen Name is {}", twitterScreenName);
		}
		final String photoUrl = "https://api.twitter.com/1/users/profile_image?screen_name=" + twitterScreenName + "&size=bigger";
		final HttpClient httpClient = new DefaultHttpClient();
		try {
			final HttpGet httpGet = new HttpGet(photoUrl);
			log.debug("Photo URL for twitter user {} ({}) is {}", twitterScreenName, personName, photoUrl);
			final HttpResponse response = httpClient.execute(httpGet);
			final File tmpFile = File.createTempFile("twitter_", ".jpg");
			try {
				FileUtils.copyInputStreamToFile(response.getEntity().getContent(), tmpFile);
				log.debug("Photo Status Line {}",  response.getStatusLine());
				final Image newImage = new Image(tmpFile, ".jpg", personName + " twitter " + twitterScreenName);
				final String imageId = imageRepo.add(newImage);
				log.debug("tmp file path from twitter user {} is {}", tmpFile);
				return imageId;
			} finally {
				tmpFile.delete();
				HttpClientUtils.closeQuietly(response);
			}
		} catch (final Exception e) {
			throw new RuntimeException("Cannot refresh Twitter user " + twitterScreenName + " (" + personName +") from Twitter URI " + photoUrl, e);
		} finally {
			HttpClientUtils.closeQuietly(httpClient);
		}
	}
	
}

package org.soluvas.facebook;

import java.io.File;
import java.net.URI;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.entity.Person2;
import org.soluvas.image.store.Image;
import org.soluvas.image.store.ImageRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;

/**
 * Inspired by org.soluvas.fbcli.FriendListDownloader.
 * @author ceefour
 */
@Service @Lazy
public class FacebookUtilsImpl implements FacebookUtils {
	
	private transient static Logger log = LoggerFactory.getLogger(FacebookUtilsImpl.class);
	private FriendListDownloader friendListDownloader;
	private UserListParser userListParser;
	private LoadingCache<String, List<HintPerson>> friendListCache;
	
//	protected FacebookUtilsImpl() {
//		super();
//	}
	
	@Inject
	public FacebookUtilsImpl(FriendListDownloader friendListDownloader,
			UserListParser userListParser) {
		super();
		this.friendListDownloader = friendListDownloader;
		this.userListParser = userListParser;
		this.friendListCache = CacheBuilder.newBuilder().build(new CacheLoader<String, List<HintPerson>>() {
			@Override
			public List<HintPerson> load(String key) throws Exception {
				return findFriends(key);
			}
		});
	}

	/* (non-Javadoc)
	 * @see org.soluvas.facebook.FacebookUtils#findFriends(java.lang.String)
	 */
	@Override
	public List<HintPerson> findFriends(String accessToken) {
		try {
			// Get pages of friends
			URI friendsPageUri = new URIBuilder("https://graph.facebook.com/me/friends")
				.addParameter("access_token", accessToken)
				.addParameter("limit", "250")
				.build();
			Future<List<JsonNode>> pagesFuture = friendListDownloader.fetchFriendsPages(friendsPageUri);
			List<JsonNode> pages = pagesFuture.get();
//			List<JsonNode> pages = Await.result(pagesFuture, Duration.Inf());
			
			// Parse user list from JSON nodes
			List<UserRef> userList = userListParser.parseNodes(pages).get();
//			List<UserRef> userList = Await.result(userListParser.parseNodes(pages), Duration.Inf());
			log.info("Parsed {} users", userList.size());
			
			List<HintPerson> hintPeople = Lists.transform(userList, new Function<UserRef, HintPerson>() {
				@Override
				public HintPerson apply(UserRef input) {
					HintPerson hintPerson = new HintPerson(null, null, input.getName(), null,
							input.getId() + "@facebook.com", input.getId());
					return hintPerson;
				}
			});
			return hintPeople;
		} catch (Exception e) {
			log.error("Cannot find friends", e);
			throw new RuntimeException("Cannot find friends", e);
		}
	}

	/* (non-Javadoc)
	 * @see org.soluvas.facebook.FacebookUtils#findFriendsCached(java.lang.String)
	 */
	@Override
	public List<HintPerson> findFriendsCached(String accessToken) {
		try {
			return friendListCache.get(accessToken);
		} catch (ExecutionException e) {
			log.error("Cannot find friends", e);
			throw new RuntimeException("Cannot find friends", e);
		}
	}
	
	/**
	 * Fetches Facebook user photo from Facebook, uploads it to ImageRepository, but not modify any {@link Person2}.
	 * @param facebookId Facebook User ID.
	 * @param personName Person name, used for the image name and for logging purposes.
	 * @return ImageID from the ImageRepository.
	 */
	public static String refreshPhotoFromFacebook(final Long facebookId, final String personName,
			ImageRepository imageRepo) {
		// Get Image
		final String photoUrl = "http://graph.facebook.com/"+ facebookId + "/picture?width=4288";
		try (final CloseableHttpClient httpClient = HttpClients.createDefault()) {
			final HttpGet httpGet = new HttpGet(photoUrl);
			log.debug("Photo URL for Facebook user {} ({}) is {}", facebookId, personName, photoUrl);
			try (final CloseableHttpResponse response = httpClient.execute(httpGet)) {
				final File tmpFile = File.createTempFile("fb_", ".jpg");
				try {
					FileUtils.copyInputStreamToFile(response.getEntity().getContent(), tmpFile);
					log.debug("Photo Status Line {}",  response.getStatusLine());
					final Predicate<String> predicate = new Predicate<String>() {
						@Override
						public boolean apply(String input) {
							return !imageRepo.exists(input);
						}
					};
					final Image newImage = new Image(tmpFile, response.getEntity().getContentType().getValue(),
							personName + " Facebook " + facebookId, predicate);
					final String imageId = imageRepo.add(newImage).getId();
					log.debug("tmp file path from Facebook user {} is {}", tmpFile);
					return imageId;
				} finally {
					tmpFile.delete();
				}
			}
		} catch (final Exception e) {
			throw new RuntimeException("Cannot refresh Facebook user " + facebookId + " (" + personName +") from Facebook URI " + photoUrl, e);
		}
	}
	
}

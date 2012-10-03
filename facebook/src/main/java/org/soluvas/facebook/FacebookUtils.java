package org.soluvas.facebook;

import java.net.URI;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import akka.dispatch.Await;
import akka.dispatch.Future;
import akka.util.Duration;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Function;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;

/**
 * Inspired by org.soluvas.fbcli.FriendListDownloader.
 * @author ceefour
 */
public class FacebookUtils {
	
	private transient Logger log = LoggerFactory.getLogger(FacebookUtils.class);
	@Inject private FriendListDownloader friendListDownloader;
	@Inject private UserListParser userListParser;
	private LoadingCache<String, List<HintPerson>> friendListCache;
	
	public FacebookUtils() {
		super();
	}
	
	public FacebookUtils(FriendListDownloader friendListDownloader,
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

	/**
	 * Get list of friends as HintPerson object.
	 * @param accessToken
	 * @return
	 */
	public List<HintPerson> findFriends(String accessToken) {
		try {
			// Get pages of friends
			URI friendsPageUri = new URIBuilder("https://graph.facebook.com/me/friends")
				.addParameter("access_token", accessToken)
				.addParameter("limit", "250")
				.build();
			Future<List<JsonNode>> pagesFuture = friendListDownloader.fetchFriendsPages(friendsPageUri);
			List<JsonNode> pages = Await.result(pagesFuture, Duration.Inf());
			
			// Parse user list from JSON nodes
			List<UserRef> userList = Await.result(userListParser.parseNodes(pages), Duration.Inf());
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

	public List<HintPerson> findFriendsCached(String accessToken) {
		try {
			return friendListCache.get(accessToken);
		} catch (ExecutionException e) {
			log.error("Cannot find friends", e);
			throw new RuntimeException("Cannot find friends", e);
		}
	}

}

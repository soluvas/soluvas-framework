package org.soluvas.facebook;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.DecompressingHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import akka.actor.ActorSystem;

/**
 * @author ceefour
 *
 */
public class FacebookUtilsTest {

	private transient Logger log = LoggerFactory
			.getLogger(FacebookUtilsTest.class);
	private ActorSystem actorSystem;
	private DecompressingHttpClient httpClient;
	private FriendListDownloader friendListDownloader;
	private UserListParser userListParser;
	private FacebookUtils facebookUtils;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		actorSystem = ActorSystem.create("FacebookUtilsTest");
		httpClient = new DecompressingHttpClient(new DefaultHttpClient());
		friendListDownloader = new FriendListDownloader(httpClient, actorSystem);
		userListParser = new UserListParser(actorSystem);
		facebookUtils = new FacebookUtils(friendListDownloader, userListParser);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		HttpClientUtils.closeQuietly(httpClient);
	}

	@Test public void findFriends() {
		List<HintPerson> hints = facebookUtils.findFriends("AAABf26iA0m4BAIBVmK2W5RLi4wfB0sZA2JQ99nsSmgg8E5eZAHvwDGUdjqHrmUtSAVAZCnZBJoB6PAmcls2rt8v561n0LmaZC1SflSoP5fQZDZD");
		assertNotNull(hints);
		log.info("Got {} friends", hints.size());
		assertThat(hints, hasSize(greaterThanOrEqualTo(800)));
	}

}

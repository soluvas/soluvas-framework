package org.soluvas.facebook;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.DecompressingHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * @author ceefour
 *
 */
public class FacebookUtilsTest {

	private transient Logger log = LoggerFactory
			.getLogger(FacebookUtilsTest.class);
//	private ActorSystem actorSystem;
	private ExecutorService executor;
	private DecompressingHttpClient httpClient;
	private FriendListDownloader friendListDownloader;
	private UserListParser userListParser;
	private FacebookUtils facebookUtils;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		executor = Executors.newFixedThreadPool(8, new ThreadFactoryBuilder().setNameFormat("FacebookUtilsTest-%d").build() );
//		actorSystem = ActorSystem.create("FacebookUtilsTest");
		httpClient = new DecompressingHttpClient(new DefaultHttpClient());
		friendListDownloader = new FriendListDownloader(httpClient, executor);
		userListParser = new UserListParser(executor);
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
		final List<HintPerson> hints = facebookUtils.findFriends("---");
		assertNotNull(hints);
		log.info("Got {} friends", hints.size());
		assertThat(hints.size(), greaterThanOrEqualTo(800));
	}

}

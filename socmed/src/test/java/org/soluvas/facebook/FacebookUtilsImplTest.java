package org.soluvas.facebook;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.image.impl.DavConnectorImpl;
import org.soluvas.image.impl.ImageMagickTransformerImpl;
import org.soluvas.image.store.ImageStyle;
import org.soluvas.image.store.MongoImageRepository;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * @author ceefour
 *
 */
public class FacebookUtilsImplTest {

	private static final Logger log = LoggerFactory
			.getLogger(FacebookUtilsImplTest.class);
//	private ActorSystem actorSystem;
	private ExecutorService executor;
	private CloseableHttpClient httpClient;
	private FriendListDownloader friendListDownloader;
	private UserListParser userListParser;
	private FacebookUtils facebookUtils;
	private MongoImageRepository personImageRepo;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		executor = Executors.newFixedThreadPool(8, new ThreadFactoryBuilder().setNameFormat("FacebookUtilsTest-%d").build() );
//		actorSystem = ActorSystem.create("FacebookUtilsTest");
		httpClient = HttpClients.createDefault();
		friendListDownloader = new FriendListDownloader(httpClient, executor);
		userListParser = new UserListParser(executor);
		facebookUtils = new FacebookUtilsImpl(friendListDownloader, userListParser);
		final DavConnectorImpl connector = new DavConnectorImpl("http://dav.aksimata.annafi.dev/person/", "http://dav.aksimata.annafi.dev/person/");
		final ImageMagickTransformerImpl transformer = new ImageMagickTransformerImpl(connector);
		final List<ImageStyle> styles = ImmutableList.of(
				new ImageStyle("thumbnail", "t", 50, 50),
				new ImageStyle("small", "s", 128, 128),
				new ImageStyle("normal", "n", 320, 240)
				);
		personImageRepo = new MongoImageRepository("person", 
				"mongodb://localhost/aksimata", connector, transformer, styles);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		personImageRepo.destroy();
		HttpClientUtils.closeQuietly(httpClient);
	}

	@Test public void findFriends() {
		final List<HintPerson> hints = facebookUtils.findFriends("---");
		assertNotNull(hints);
		log.info("Got {} friends", hints.size());
		assertThat(hints.size(), greaterThanOrEqualTo(800));
	}

	@Test
	public void updateHendy() throws IOException {
		final String photoId = FacebookUtilsImpl.refreshPhotoFromFacebook(596326671L, "Hendy Irawan", personImageRepo);
		log.info("Photo ID is {}", photoId);
		Assert.assertNotNull(photoId);
	}

}

package com.soluvas.story;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.code.morphia.logging.MorphiaLoggerFactory;
import com.google.code.morphia.logging.slf4j.SLF4JLogrImplFactory;
import com.soluvas.story.impl.MongoStoryRepository;

/**
 * @author atang
 *
 */
public class PersonStoryRepositoryTest {
	private static final Logger log = LoggerFactory.getLogger(PersonStoryRepositoryTest.class);
	private MongoStoryRepository personStoryRepo;
	private static final Class<?>[] storyEntityClasses = new Class<?>[] {
//		PersonLikeProduct.class,
//		PersonLikeShop.class,
//		PersonCommentProduct.class,
//		PersonBookProduct.class,
//		PersonConfirmProduct.class,
//		PersonCancelProduct.class,
//		PersonBuyProduct.class,
//		PersonExpiredBookProduct.class
	};

	static {
		MorphiaLoggerFactory.registerLogger(SLF4JLogrImplFactory.class);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		personStoryRepo = new MongoStoryRepository(false, "mongodb://127.0.0.1:27017/berbatik_dev", "person");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		personStoryRepo.destroy();
	}

	@Test
	public void listStoryShouldReturnNotEmpty() {
		final List<Story> stories = personStoryRepo.findAllByOwnerId("eman_sipasi");
		log.info("Data story : {}", stories);
		Assert.assertNotNull("shopstory untuk atang tidak boleh null", stories);
		Assert.assertTrue("ShopStory untuk eman_sipasi tidak boleh kosong", 
				!stories.isEmpty());
	}
	
//	@Test
//	public void addStory() {
//		final String id = UUID.randomUUID().toString();
//		final PersonInfo liker = CommonsFactory.eINSTANCE.createPersonInfo("rudi", "rudi.wijaya", "Rudi Wijaya",
//				"rudi_wijaya_0hr139_350a_wedding_fowers", Gender.MALE);
//		final ProductInfo liked = CommonFactory.eINSTANCE.createProductInfo("zibalabel_t03", "zibalabel", "zibalabel.t03", "Ziba Label T03", "zibalabel photoId");
//		final PersonLikeProduct story = new PersonLikeProduct(id, "zibalabel", liker, liked, Story.Status.ACTIVE);
//		
//		personStoryRepo.upsert(story);
//	}
	
	@Test
	public void findPersonStory() {
		final List<Story> findBySubject = personStoryRepo.findAllByOwnerId("atang");
		log.info("Data story : {}", findBySubject);
		Assert.assertNotNull("shopstory untuk rudi tidak boleh null", findBySubject);
	}
	
	@Test
	public void findOneBy_id() {
		final Story findOneBy_Id = personStoryRepo.findOne("a989a71e-dcac-4e69-b9f1-786bd24e1496");
		log.debug("Story for a989a71e-dcac-4e69-b9f1-786bd24e1496: {}", findOneBy_Id);
	}
	
	@Test
	public void update() {
		final Story story = personStoryRepo.findOne("a989a71e-dcac-4e69-b9f1-786bd24e1496");
		log.debug("Story for a989a71e-dcac-4e69-b9f1-786bd24e1496: {}", story);
		
		story.setStatus(StoryStatus.ACTIVE);
		
		personStoryRepo.modify(story.getId(), story);
	}
}

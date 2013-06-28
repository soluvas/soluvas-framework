package com.soluvas.story;

import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author rudi
 *
 */
public class StoryJsonTest {

	private static final Logger log = LoggerFactory.getLogger(StoryJsonTest.class);
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

//	@Test public void storyHasFullProperties() {
//		final PersonInfo commenter = CommonsFactory.eINSTANCE.createPersonInfo("rudi", "rudi", "Rudi Wijaya",
//				"rudi_128", Gender.MALE);
//		final ProductInfo commented = CommonFactory.eINSTANCE.createProductInfo("zibalabel_t01", "zibalabel", "t01", "Vinyl Bag", "t01_128");
//		final PersonCommentProduct commentStory = new PersonCommentProduct("story_id_2012", "comment_123", "zibalabel_t01", "I really love bags",
//				commenter, commented, Story.Status.ACTIVE);
//		commentStory.setCreated(new DateTime(2012, 1, 1, 0, 0).toDate());
//		final String json = JsonUtils.asJson(commentStory);
//		log.info("Comment story: {}", json);
//		final String expected = "{\n  \"id\" : \"story_id_2012\",\n  \"subject\" : \"zibalabel_t01\",\n  \"publicized\" : true,\n  \"kind\" : \"PersonCommentProduct\",\n  \"created\" : \"2011-12-31T17:00:00.000+0000\",\n  \"status\" : \"active\",\n  \"commenter\" : {\n    \"id\" : \"rudi\",\n    \"kind\" : \"Person\",\n    \"slug\" : \"rudi\",\n    \"name\" : \"Rudi Wijaya\",\n    \"photoId\" : \"rudi_128\",\n    \"magentoCustomerId\" : null\n  },\n  \"commented\" : {\n    \"id\" : \"zibalabel_t01\",\n    \"kind\" : \"Product\",\n    \"slug\" : \"t01\",\n    \"name\" : \"Vinyl Bag\",\n    \"photoId\" : \"t01_128\",\n    \"shopId\" : \"zibalabel\"\n  },\n  \"summary\" : \"I really love bags\",\n  \"commentId\" : \"comment_123\"\n}";
//		assertEquals(expected, json);
//	}
//
//	@Test public void storyListHasFullProperties() {
//		final PersonInfo commenter = CommonsFactory.eINSTANCE.createPersonInfo("rudi", "rudi", "Rudi Wijaya",
//				"rudi_128", Gender.MALE);
//		final ProductInfo commented = CommonFactory.eINSTANCE.createProductInfo("zibalabel_t01", "zibalabel", "t01", "Vinyl Bag", "t01_128");
//		final PersonCommentProduct commentStory = new PersonCommentProduct("story_id_2012", "comment_123", "zibalabel_t01", "I really love bags",
//				commenter, commented, Story.Status.ACTIVE);
//		commentStory.setCreated(new DateTime(2012, 1, 1, 0, 0).toDate());
//		final List<Story> stories = ImmutableList.<Story>of(commentStory);
//		final String json = JsonUtils.asJson(stories);
//		log.info("Comment story: {}", json);
//		final String expected = "[ {\n  \"id\" : \"story_id_2012\",\n  \"subject\" : \"zibalabel_t01\",\n  \"publicized\" : true,\n  \"kind\" : \"PersonCommentProduct\",\n  \"created\" : \"2011-12-31T17:00:00.000+0000\",\n  \"status\" : \"active\",\n  \"commenter\" : {\n    \"id\" : \"rudi\",\n    \"kind\" : \"Person\",\n    \"slug\" : \"rudi\",\n    \"name\" : \"Rudi Wijaya\",\n    \"photoId\" : \"rudi_128\",\n    \"magentoCustomerId\" : null\n  },\n  \"commented\" : {\n    \"id\" : \"zibalabel_t01\",\n    \"kind\" : \"Product\",\n    \"slug\" : \"t01\",\n    \"name\" : \"Vinyl Bag\",\n    \"photoId\" : \"t01_128\",\n    \"shopId\" : \"zibalabel\"\n  },\n  \"summary\" : \"I really love bags\",\n  \"commentId\" : \"comment_123\"\n} ]";
//		assertEquals(expected, json);
//	}

}

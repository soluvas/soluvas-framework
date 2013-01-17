package org.soluvas.image.impl;

import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.image.S3Connector;
import org.soluvas.image.UploadedImage;
import org.soluvas.image.store.ImageRepository;

import com.amazonaws.Protocol;

/**
 * @author ceefour
 *
 */
public class S3ConnectorImplTest {

	private static final Logger log = LoggerFactory
			.getLogger(S3ConnectorImplTest.class);
	private S3Connector s3Conn;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
//		s3Conn = new S3ConnectorImpl("s3.annafi.dev:4567", Protocol.HTTP,
//				"abc", "abc",
//				"berbatik-dev-pichi", "berbatik-dev-piclo", "berbatik_dev/",
//				"berbatik-dev-pichi.s3.annafi.dev:4567", "berbatik-dev-piclo.s3.annafi.dev:4567");
		s3Conn = new S3ConnectorImpl(null, Protocol.HTTPS,
				"AKIAJKBALZX7EEJOXYNQ", "*", null,
				"berbatik-stg-pic", "berbatik", "dev",
				null, "pic.stg.berbatik.com");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void uploadFile() {
		UploadedImage up = s3Conn.upload("activity", "mamadekadhis2", ImageRepository.ORIGINAL_CODE, ImageRepository.ORIGINAL_CODE, "jpg",
				new File("/home/ceefour/Pictures/Family/hendy mama dek adhis Trans Studio 388540_2728662699516_1538068978_n.jpg"), "image/jpeg");
		log.info("Uploaded: {}", up);
		assertNotNull(up);
	}

}

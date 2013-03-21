/**
 * 
 */
package org.soluvas.image.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.image.ImageTransform;
import org.soluvas.image.ImageVariant;
import org.soluvas.image.UploadedImage;

import com.google.common.collect.ImmutableMap;

/**
 * @author agus
 *
 */
public class ImageMagickTransformerImplTest {

	private static final Logger log = LoggerFactory
			.getLogger(ImageMagickTransformerImplTest.class);
	private ImageMagickTransformerImpl transformer;
	private FolderConnectorImpl conn;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		conn = new FolderConnectorImpl(System.getProperty("user.home") + "/tmp");
		transformer = new ImageMagickTransformerImpl(conn);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void uploadNeneng() {
		final UploadedImage uploaded = conn.upload("product", "neneng", "o", "o", "jpg",
				new File("/home/agus/Downloads/neneng.jpg"), "image/jpeg");
		log.info("Uploaded: {}", uploaded);
	}
	
	@Test
	public void transformNenengWidthOnly() {
		final ImageVariantImpl sourceVariant = new ImageVariantImpl("o", "o", "jpg");
		final ImageVariantImpl destVariant = new ImageVariantImpl("s", "s", "jpg");
		// constrain to width only, but free height, this is useful for dynamic grid layout, product view, and zoom view
		final ResizeToFitImpl transform = new ResizeToFitImpl(75, null);
		final Map<ImageTransform, ImageVariant> transforms = ImmutableMap.<ImageTransform, ImageVariant>of(transform, destVariant);
		final List<UploadedImage> uploadeds = transformer.transform(conn, "product", "neneng", sourceVariant, transforms);
		log.info("Result: {}", uploadeds);
	}

}

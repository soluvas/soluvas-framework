/**
 * 
 */
package org.soluvas.image.impl;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.image.ImageTransform;
import org.soluvas.image.ImageVariant;
import org.soluvas.image.UploadedImage;

import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

/**
 * @author agus
 *
 */
@RunWith(Theories.class)
public class ImageMagickTransformerImplTest {

	private static final Logger log = LoggerFactory
			.getLogger(ImageMagickTransformerImplTest.class);
	
	@DataPoint
	public static final ListeningExecutorService sameThread = MoreExecutors.sameThreadExecutor();
	@DataPoint
	public static final ListeningExecutorService multi = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(
			Runtime.getRuntime().availableProcessors()));
	
	private ImageTransformerImpl transformer;
	private FolderConnectorImpl conn;
	private final ListeningExecutorService executor;
	
	public ImageMagickTransformerImplTest(ListeningExecutorService executor) {
		this.executor = executor;
	}

	@Override
	protected void finalize() throws Throwable {
		executor.shutdown();
		executor.awaitTermination(10, TimeUnit.SECONDS);
		super.finalize();
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		conn = new FolderConnectorImpl(executor, System.getProperty("user.home") + "/tmp");
		transformer = new ImageMagickTransformerImpl(executor, conn);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void uploadNeneng() throws InterruptedException, ExecutionException {
		final UploadedImage uploaded = conn.upload("product", "neneng", "o", "o", "jpg",
				new File("/home/agus/Downloads/neneng.jpg"), "image/jpeg").get();
		log.info("Uploaded: {}", uploaded);
	}
	
	@Test
	public void transformNenengWidthOnly() throws InterruptedException, ExecutionException {
		final ImageVariantImpl sourceVariant = new ImageVariantImpl("o", "o", "jpg");
		final ImageVariantImpl destVariant = new ImageVariantImpl("s", "s", "jpg");
		// constrain to width only, but free height, this is useful for dynamic grid layout, product view, and zoom view
		final ResizeToFitImpl transform = new ResizeToFitImpl(75, null);
		final Map<ImageTransform, ImageVariant> transforms = ImmutableMap.<ImageTransform, ImageVariant>of(transform, destVariant);
		final List<UploadedImage> uploadeds = transformer.transform(
				conn, null, "product", "neneng", sourceVariant, transforms).get();
		log.info("Result: {}", uploadeds);
	}

	@Test
	public void transformNenengWidthOnlyMany() throws InterruptedException, ExecutionException {
		final ImageVariantImpl sourceVariant = new ImageVariantImpl("o", "o", "jpg");
		final ImageVariantImpl destVariant1 = new ImageVariantImpl("s", "s", "jpg");
		final ImageVariantImpl destVariant2 = new ImageVariantImpl("n", "n", "jpg");
		final ImageVariantImpl destVariant3 = new ImageVariantImpl("l", "l", "jpg");
		// constrain to width only, but free height, this is useful for dynamic grid layout, product view, and zoom view
		final ResizeToFitImpl transform = new ResizeToFitImpl(75, null);
		final Map<ImageTransform, ImageVariant> transforms = ImmutableMap.<ImageTransform, ImageVariant>of(
				EcoreUtil.copy(transform), destVariant1,
				EcoreUtil.copy(transform), destVariant2,
				EcoreUtil.copy(transform), destVariant3);
		final List<UploadedImage> uploadeds = transformer.transform(
				conn, null, "product", "neneng", sourceVariant, transforms).get();
		log.info("Result: {}", uploadeds);
	}

}

package org.soluvas.image.store;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ImageStoreTest {

	private ImageRepository imageStore;

	@Before
	public void setUp() throws Exception {
		Properties props = new Properties();
		props.load(ImageStoreTest.class.getResourceAsStream("/soluvas-image-store.properties"));
		
		imageStore = new MongoImageRepository();
		imageStore.addStyle("thumbnail", "t", 50, 50);
		imageStore.addStyle("small", "s", 125, 125);
		imageStore.addStyle("normal", "n", 240, 320);
		imageStore.setNamespace(props.getProperty("person.image.namespace"));
		imageStore.setDavUri(props.getProperty("person.image.dav.uri"));
		imageStore.setPublicUri(props.getProperty("person.image.public.uri"));
		imageStore.setMongoUri(props.getProperty("person.image.mongo.uri"));
		imageStore.init();
	}

	@After
	public void tearDown() throws Exception {
		imageStore.destroy();
	}

	@Test
	public void shouldCreateSuccessfully() throws FileNotFoundException, IOException {
		File file = new File("/together/project/AksiMata/sample/Shaun-udah-mau-makan.jpg");
//		String imageId = imageStore.create(file.getName(), new FileInputStream(file), "image/jpeg", file.length(), "Shaun udah mau makan");
		String imageId = imageStore.add(new Image(file, "image/jpeg", "Shaun udah mau makan"));
		System.out.println("Created image " + imageId);
		Assert.assertNotNull(imageId);
	}

}

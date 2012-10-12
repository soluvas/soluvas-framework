package org.soluvas.image.store;

/**
 * @author rudi
 * @deprecated Use {@link MongoImageRepository}.
 */
@Deprecated
public class ImageStore extends MongoImageRepository {

	public ImageStore() {
		super();
	}

	public ImageStore(String namespace, String davUri, String publicUri,
			String mongoUri) {
		super(namespace, davUri, publicUri, mongoUri);
	}

}

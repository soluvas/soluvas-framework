package org.soluvas.image.store;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

public interface ImageRepository {

	/**
	 * Ensure folders exists based on namespace and image styles.
	 * @todo Implement
	 */
	public abstract void createFolders();

	/**
	 * Note that the shortCode 'o' (for "original") is reserved.
	 * @param name
	 * @param code
	 * @param maxWidth
	 * @param maxHeight
	 * @deprecated Use setStyles().
	 */
	@Deprecated
	public abstract void addStyle(String name, String code, int maxWidth,
			int maxHeight);

	public abstract List<ImageStyle> getStyles();

	/**
	 * Note that the shortCode 'o' (for "original") is reserved.
	 * 
	 * This does not use the styles, but rather copy it to our own.
	 * 
	 * @param styles Source styles that will be copied.
	 */
	public abstract void setStyles(Collection<ImageStyle> styles);

	/**
	 * Scheme: ${safeDavUri}/${namespace}/${shortCode}/${id}_${shortCode}.${extension}
	 * 
	 * This only works for non-original image styles.
	 * 
	 * @return
	 */
	public abstract URI getImageDavUri(String id, String styleName);

	/**
	 * Scheme: ${publicUri}/${namespace}/${shortCode}/${id}_${shortCode}.${extension}
	 * @return
	 */
	public abstract String getImageUri(String id, String styleName);

	/**
	 * Add an {@link Image} from an {@link InputStream}. This method makes use of a temporary file.
	 * @deprecated Better use {@link MongoImageRepository#add(Image)}.
	 * @param fileName
	 * @param content
	 * @param contentType
	 * @param length
	 * @param name
	 * @return
	 * @throws IOException
	 */
	@Deprecated
	public abstract String create(String fileName, InputStream content,
			String contentType, long length, String name) throws IOException;

	/**
	 * Upload a file.
	 * 
	 * Note: To comply with Soluvas Data, the add() method should accept a VO object (that can be deserialized from
	 * JSON, AMQP, RDF, XMI, etc.). See add().
	 * 
	 * @param originalFile
	 * @param contentType
	 * @param name
	 * @return
	 * @throws IOException
	 */
	public abstract String create(File originalFile, String contentType,
			String name) throws IOException;

	/**
	 * Upload a file.
	 * 
	 * To comply with Soluvas Data, the add() method should accept a VO object (that can be deserialized from
	 * JSON, AMQP, RDF, XMI, etc.). All exceptions are rethrown as runtime exceptions.
	 * 
	 * Required attributes for new {@link Image} are: originalFile, contentType, name.
	 * 
	 * @param newImage
	 * @return
	 */
	public abstract String add(Image newImage);

	public abstract String doCreate(String existingImageId, File originalFile,
			String contentType, long length, String name, String originalName,
			boolean alsoUploadOriginal) throws IOException;

	/**
	 * Delete the image with the specified ID, from the MongoDB metadata including all files and styled images from WebDAV.
	 * @param id Image ID.
	 */
	public abstract void delete(String id);
	
	/**
	 * Delete multiple images with the specified ID, from the MongoDB metadata including all files and styled images from WebDAV.
	 * @param id Image IDs.
	 */
	public abstract void deleteMultiple(Set<String> ids);

	public abstract Image findOne(@Nullable String id);

	public abstract Map<String, Image> findAllByIds(Iterable<String> ids);

	/**
	 * List all {@link Image}s, ordered by Image ID.
	 * @return
	 */
	public abstract List<Image> findAll();

	/**
	 * Search {@link Image}s by ID, fileName, URL. Sorted by ID.
	 * @return
	 */
	public abstract List<Image> search(String searchText);

	/**
	 * For each image, redownloads the original file from WebDAV repository, reprocesses each image style, and re-uploads the processed images to WebDAV repository.
	 * @param ids
	 */
	public abstract void reprocess(Iterable<String> ids);

	public abstract void reprocessAll();

	public abstract String getNamespace();

	public abstract String getDavUri();

	public abstract String getPublicUri();

	public abstract String getMongoUri();

	/**
	 * Note: For now Akka is not used, but for backwards compatibility it is simply ignored.
	 * @param system the Akka actor system to set
	 */
	//	public void setSystem(ActorSystem system) {
	//		this.system = system;
	//	}
	public abstract void setSystem(Object system);

	public abstract void updateUriAll();

	public abstract void updateUri(Collection<String> imageIds);

}
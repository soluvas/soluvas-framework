package org.soluvas.image;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.ws.rs.core.Response;

import org.soluvas.couchdb.CouchDbRepository;
import org.soluvas.data.Existence;
import org.soluvas.data.GenericLookup;
import org.soluvas.data.StatusMask;
import org.soluvas.data.repository.PagingAndSortingRepository;
import org.soluvas.data.repository.Repository;
import org.soluvas.data.repository.StatusAwareRepository;
import org.soluvas.data.repository.Trashable;

/**
 * {@link Media} {@link Repository}.
 * 
 * @author ceefour
 */
public interface MediaRepository extends
		PagingAndSortingRepository<Media, String>,
		GenericLookup<Media>,
		StatusAwareRepository<Media, String>,
		Trashable<Media, String>,
		CouchDbRepository<Media> {

	Existence<String> existsById(StatusMask statusMask, String id);

	Existence<String> existsBySlug(StatusMask statusMask, String upSlug);

	/**
	 * Add {@link Media} from {@link File}.
	 * {@link MediaAttachment} key is initially retrieved from {@link Media#getName()}, because
	 * there is only one attachment per {@link Media}.
	 * Note that Media's name can be changed anytime, but the {@link MediaAttachment} key will stay as it was
	 * (unless the attachment is reuploaded/replaced). 
	 * @param media
	 * @param file Temporary file.
	 * @param contentType
	 * @return
	 */
	Media add(Media media, File file, String contentType);
	
	/**
	 * Add {@link Media} from {@link File}, probing contentType using {@link Files#probeContentType(java.nio.file.Path)}.
	 * @param media
	 * @param file Temporary file.
	 * @return
	 */
	Media add(Media media, File file);

	/**
	 * Returns the public (as opposed to "origin" in {@link #getOriginUri(Media)}) URI of the {@link Media}, which can be behind CDN.
	 * The {@link Media} may require authentication, and the implementation is free to determine whether
	 * the authentication information is embedded in the URI (i.e. via limited session key), or is assumed
	 * to be available in the browser (e.g. CouchDB attachments). 
	 * @param media
	 * @return
	 */
	String getPublicUri(Media media);
	
	/**
	 * Returns the origin (as opposed to "public" in {@link #getPublicUri(Media)}) URI of the {@link Media},
	 * which must not be behind CDN.
	 * The {@link Media} may require authentication, and the implementation is free to determine whether
	 * the authentication information is embedded in the URI (i.e. via limited session key), or is assumed
	 * to be available in the browser (e.g. CouchDB attachments). 
	 * @param media
	 * @return
	 */
	String getOriginUri(Media media);

	/**
	 * Returns the {@link Media}'s binary content as a JAX-RS {@link Response}.
	 * It uses byte array so it's safe even if not consumed.
	 * It returns proper {@code Content-Type} and also with {@code Content-Disposition: inline} header. 
	 * @param media
	 * @return
	 * @throws IOException
	 */
	Response getContent(Media media) throws IOException;
	
}

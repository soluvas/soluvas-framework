package org.soluvas.image;

import java.io.File;
import java.nio.file.Files;

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
		Trashable<Media, String> {

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
	
}

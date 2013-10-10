package org.soluvas.image;

import java.io.File;

import org.soluvas.data.Existence;
import org.soluvas.data.GenericLookup;
import org.soluvas.data.StatusMask;
import org.soluvas.data.repository.PagingAndSortingRepository;
import org.soluvas.data.repository.StatusAwareRepository;
import org.soluvas.data.repository.Trashable;

/**
 * @author ceefour
 *
 */
public interface MediaRepository extends
		PagingAndSortingRepository<Media, String>,
		GenericLookup<Media>,
		StatusAwareRepository<Media, String>,
		Trashable<Media, String> {

	Existence<String> existsById(StatusMask statusMask, String id);

	Existence<String> existsBySlug(StatusMask statusMask, String upSlug);

	Media add(Media media, File file, String contentType);
	
}

package org.soluvas.image.rs;

import java.io.IOException;

import javax.inject.Inject;

import org.soluvas.data.EntityLookupException;
import org.soluvas.data.LookupKey;
import org.soluvas.data.StatusMask;
import org.soluvas.image.Media;
import org.soluvas.image.MediaRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;

/**
 * Works with {@link MediaRepository} to provide Wicket-independent secure media serving
 * via {@link MediaResource}.
 * It uses Spring MVC instead of Wicket because {@link Media} resources may be used in
 * email notifications, Facebook shares, or other non-webapp purposes.
 * @todo FIXME: Migrate to Spring {@link RestController}, see {@link ProductPubResource} for example.
 * @author ceefour
 * @see MediaRepository
 */
@RestController
@Scope("request")
public class MediaResource {
	
	@Inject // Hendy's note: do not comment this, if you don't need this then please configure Spring app to exclude MediaResource controller
	private MediaRepository mediaRepo;

	@RequestMapping(value = "/media/{mediaId}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getContent(@PathVariable("mediaId") String mediaId) throws EntityLookupException, IOException {
		final Media media = Preconditions.checkNotNull(mediaRepo.lookupOne(StatusMask.RAW, LookupKey.ID, mediaId),
				"Cannot find media '%s'", mediaId);
		return mediaRepo.getContent(media);
	}

}

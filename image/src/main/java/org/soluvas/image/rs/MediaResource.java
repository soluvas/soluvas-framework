package org.soluvas.image.rs;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.soluvas.data.EntityLookupException;
import org.soluvas.data.LookupKey;
import org.soluvas.data.StatusMask;
import org.soluvas.image.Media;
import org.soluvas.image.MediaRepository;

/**
 * Works with {@link MediaRepository} to provide Wicket-independent secure media serving
 * via {@link MediaResource}.
 * It uses JAX-RS instead of Wicket because {@link Media} resources may be used in
 * email notifications, Facebook shares, or other non-webapp purposes.
 * @author ceefour
 */
@Path("media")
public class MediaResource {
	
	@Inject
	private MediaRepository mediaRepo;
	
	@GET @Path("{mediaId}")
	public Response getContent(@PathParam("mediaId") String mediaId) throws EntityLookupException, IOException {
		final Media media = mediaRepo.lookupOne(StatusMask.RAW, LookupKey.ID, mediaId);
		return mediaRepo.getContent(media);
	}

}

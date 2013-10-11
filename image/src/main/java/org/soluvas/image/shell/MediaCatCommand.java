package org.soluvas.image.shell; 

import javax.annotation.Nullable;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.data.LookupKey;
import org.soluvas.data.StatusMask;
import org.soluvas.image.Media;
import org.soluvas.image.MediaRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Shell command to show an entity of {@link Media}.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="media", name="cat", description="Get Media by ID.")
public class MediaCatCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(MediaCatCommand.class);

	@Option(name="-s", aliases="--slug", description="Find Media by slug (not by ID).")
	private transient boolean bySlug = false;
	@Option(name="-g", aliases="--guid", description="Find Media by GUID (not by ID).")
	private transient boolean byGuid = false;
	@Option(name="-m", aliases="--mask", description="")
	private transient StatusMask statusMask = StatusMask.RAW;
	
	@Argument(index=0, name="id", required=true, description="Media ID/slug.")
	private String id;
	
	@Override @Nullable
	protected Object doExecute() throws Exception {
		final MediaRepository mediaRepo = getBean(MediaRepository.class);
		if (bySlug) {
			return mediaRepo.lookupOne(statusMask, LookupKey.SLUG, id);
		} else if (byGuid) {
			return mediaRepo.lookupOne(statusMask, LookupKey.GUID, id);
		} else {
			final Media media = mediaRepo.lookupOne(statusMask, LookupKey.ID, id);
			return media;
		}
	}

}
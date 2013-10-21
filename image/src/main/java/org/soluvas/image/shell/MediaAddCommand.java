package org.soluvas.image.shell; 

import java.io.File;

import javax.annotation.Nullable;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.data.StatusMask;
import org.soluvas.image.ImageFactory;
import org.soluvas.image.Media;
import org.soluvas.image.MediaRepository;
import org.soluvas.image.MediaStatus;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Predicate;

/**
 * Add {@link Media} entity.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="media", name="add", description="Add a new Media entity.")
public class MediaAddCommand extends ExtCommandSupport {

	@Option(name="--id", description="Manually set the ID.")
	private String upId;
	@Option(name="--slug", description="Manually set the slug.")
	private String upSlug;
	@Option(name="-s", aliases="--status", description="Media status: DRAFT|BOOKED|VOID.")
	private transient MediaStatus status = MediaStatus.BOOKED;
	
	@Argument(index=0, name="file", required=true,
		description="Relative or absolute path to media file.")
	private String filePath;
	
	@Override
	protected Media doExecute() throws Exception {
		final MediaRepository mediaRepo = getBean(MediaRepository.class);
		final File file = new File(filePath);
		final Media media = ImageFactory.eINSTANCE.createMedia();
		final String id = SlugUtils.generateValidId(file.getName(), new Predicate<String>() {
			@Override
			public boolean apply(@Nullable String input) {
				return !mediaRepo.existsById(StatusMask.RAW, input).isPresent();
			}
		});
		media.setId(id);
		media.setGuid(Media.class.getSimpleName() + "_" + id);
		media.setStatus(status);
		media.setName(file.getName());
//		final String slug = SlugUtils.generateValidScreenName(file.getName(), new Predicate<String>() {
//			@Override
//			public boolean apply(@Nullable String input) {
//				return !mediaRepo.existsBySlug(StatusMask.RAW, input).isPresent();
//			}
//		});
//		media.setSlug(slug);
//		media.setCanonicalSlug(SlugUtils.canonicalize(slug));

		final Media added = mediaRepo.add(media, file);
		return added;
	}

}
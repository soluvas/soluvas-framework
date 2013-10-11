 package org.soluvas.image.shell; 

import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.image.store.Image;
import org.soluvas.image.store.ImageRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Predicate;
import com.google.common.base.Throwables;
import com.google.common.collect.Iterables;

/**
 * Shell command to show an entity of {@link org.soluvas.image.store.Image}.
 *
 * Image class is used to hold the metadata of images in the Soluvas Image Store.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="image", name="cat", description="Get Image by ID.")
public class ImageCatCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(ImageCatCommand.class);

	@Option(name="-n", aliases={"--ns", "--namespace"},
		description="Namespace, e.g. person, shop, product. Default is 'person'.")
	private transient String namespace = "person";

	@Option(name="--index", description="Find Image by index (not by ID). Index starts at 1 (as displayed by 'ls').")
	private Boolean byIndex;

	@Argument(index=0, name="id", required=true, description="Image ID.")
	private String id;

	@Override
	protected Object doExecute() throws Exception {
		final Map<String, ImageRepository> imageRepos = getBeans(ImageRepository.class);
		final ImageRepository imageRepo = Iterables.find(imageRepos.values(), new Predicate<ImageRepository>() {
			@Override
			public boolean apply(@Nullable ImageRepository input) {
				return namespace.equals(input.getNamespace());
			}
		});
		
		if (byIndex == null || byIndex == true) {
			Integer parsedId = null;
			try {
				parsedId = Integer.valueOf(id);
				// TODO: natively support findOneByIndex in Repository
				List<Image> imageList = imageRepo.findAll();
				return imageList.get(parsedId - 1);
			} catch (NumberFormatException e) {
				if (byIndex != null && byIndex == true) {
					Throwables.propagate(e);
					return null;
				} else {
					return imageRepo.findOne(id);
				}
			}
		} else {
			return imageRepo.findOne(id);
		}
	}

}
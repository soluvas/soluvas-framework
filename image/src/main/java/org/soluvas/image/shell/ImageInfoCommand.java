 package org.soluvas.image.shell; 

import java.util.Map;

import javax.annotation.Nullable;

import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.image.store.ImageRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * Shell command to show information about the current Image repository.
 *
 * Image class is used to hold the metadata of images in the Soluvas Image Store.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="image", name="info", description="Show information about the current Image repository.")
public class ImageInfoCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(ImageInfoCommand.class);

	@Option(name="-n", aliases={"--ns", "--namespace"},
		description="Namespace, e.g. person, shop, product. Default is 'person'.")
	private transient String namespace = "person";
	
	@Override
	protected Object doExecute() throws Exception {
		final Map<String, ImageRepository> imageRepos = getBeans(ImageRepository.class);
		final ImageRepository imageRepo = Iterables.find(imageRepos.values(), new Predicate<ImageRepository>() {
			@Override
			public boolean apply(@Nullable ImageRepository input) {
				return namespace.equals(input.getNamespace());
			}
		});
		return imageRepo;
	}

}
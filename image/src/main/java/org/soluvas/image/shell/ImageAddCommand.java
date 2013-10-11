 package org.soluvas.image.shell; 

import java.io.File;
import java.net.URL;
import java.util.Map;

import javax.annotation.Nullable;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.image.store.Image;
import org.soluvas.image.store.ImageRepository;
import org.soluvas.image.util.ImageUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * Shell command to search {@link org.soluvas.image.store.Image} entities.
 *
 * Image class is used to hold the metadata of images in the Soluvas Image Store.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="image", name="add", description="Add a new Image entity.")
public class ImageAddCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(ImageAddCommand.class);

	@Option(name="-n", aliases={"--ns", "--namespace"},
		description="Namespace, e.g. person, shop, product. Default is 'person'.")
	private String namespace;

	@Argument(index=0, name="originalFile", required=true,
		description="File or URL to upload.")
	private String originalFile;
	@Argument(index=1, name="contentType", required=false,
		description="Content type, e.g. image/png.")
	private String contentType;
	@Argument(index=2, name="name", required=false,
		description="Short descriptive name. Default: (base filename).")
	private String name;

	@Override
	protected Object doExecute() throws Exception {
		final Map<String, ImageRepository> imageRepos = getBeans(ImageRepository.class);
		final ImageRepository imageRepo = Iterables.find(imageRepos.values(), new Predicate<ImageRepository>() {
			@Override
			public boolean apply(@Nullable ImageRepository input) {
				return namespace.equals(input.getNamespace());
			}
		});
		
		final Image newImage = new Image();
		final File tmpFile = File.createTempFile("imageadd_", "." + ImageUtils.getExtensionOrJpg(originalFile));
		try {
			if (originalFile != null)
				if (originalFile.matches("[a-z]{2,}:.*")) {
					log.info("Downloading {} to {} for adding image", originalFile, tmpFile);
					URL url = new URL(originalFile);
					FileUtils.copyURLToFile(url, tmpFile);
					newImage.setOriginalFile(tmpFile);
				} else {
					newImage.setOriginalFile(new File(originalFile));
				}
			if (contentType != null)
				newImage.setContentType(contentType);
			if (name != null) {
				newImage.setName(name);
			} else {
				newImage.setName( FilenameUtils.getBaseName(originalFile) );
			}

			final String realNamespace = Optional.fromNullable(namespace).or("person");

			final String addedImageId = imageRepo.add(newImage).getId();
			return addedImageId;
		} finally {
			tmpFile.delete();
		}
	}

}
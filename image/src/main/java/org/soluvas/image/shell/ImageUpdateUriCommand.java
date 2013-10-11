 package org.soluvas.image.shell; 

import java.util.Map;

import javax.annotation.Nullable;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.ProgressMonitor;
import org.soluvas.commons.impl.ShellProgressMonitorImpl;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.image.ImageException;
import org.soluvas.image.store.Image;
import org.soluvas.image.store.ImageRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * Shell command to update an existing {@link Image} URI.
 *
 * @author atang
 */
@Service @Scope("prototype")
@Command(scope="image", name="updateuri", description="Update an existing image URI.")
public class ImageUpdateUriCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(ImageUpdateUriCommand.class);

	@Option(name="-n", aliases={"--ns", "--namespace"},
		description="Namespace, e.g. person, shop, product.")
	private transient String namespace = "person";
	@Option(name="-a", aliases="--all", required=false,
			description="Set all imageUri.")
	private transient boolean all = false;

	@Argument(index=0, name="imageId ...", multiValued=true, required=false,
		description="Image ID(s)")
	private String[] imageIds;
	
	@Override
	protected Object doExecute() throws Exception {
		final Map<String, ImageRepository> imageRepos = getBeans(ImageRepository.class);
		final ImageRepository imageRepo = Iterables.find(imageRepos.values(), new Predicate<ImageRepository>() {
			@Override
			public boolean apply(@Nullable ImageRepository input) {
				return namespace.equals(input.getNamespace());
			}
		});
		
		final ProgressMonitor monitor = new ShellProgressMonitorImpl();
		
		if (all) {
			if (imageIds != null )
				throw new ImageException("ImageId cannot be attached");
			
			imageRepo.updateUriAll(monitor);
		} else {
			Preconditions.checkNotNull(imageIds, "imageId(s) must be specified");
			imageRepo.updateUri(ImmutableList.copyOf(imageIds), monitor);
		}  
		return null;
	}

}
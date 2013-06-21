package org.soluvas.image.shell; 

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.image.ImageException;
import org.soluvas.image.store.ImageRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * Fix image extension.
 *
 * @author atang
 */
@Service @Scope("prototype")
@Command(scope="image", name="fixextension", description="Fix image extension.")
public class ImageFixExtensionCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(ImageFixExtensionCommand.class);

	@Option(name="-n", aliases={"--ns", "--namespace"},
		description="Namespace, e.g. person, shop, product.")
	private transient String namespace = "person";
	@Option(name="-a", aliases="--all", required=false,
			description="Fix all images (without extension).")
	private transient boolean all = false;

	@Argument(index=0, name="imageId ...", multiValued=true, required=false,
		description="Image ID(s)")
	private String[] imageIds;
	
	private final List<ImageRepository> imageRepos;
	
	@Inject
	public ImageFixExtensionCommand(List<ImageRepository> imageRepos) {
		super();
		this.imageRepos = imageRepos;
	}

	@Override
	protected Object doExecute() throws Exception {
		final ImageRepository imageRepo = Iterables.find(imageRepos, new Predicate<ImageRepository>() {
			@Override
			public boolean apply(@Nullable ImageRepository input) {
				return namespace.equals(input.getNamespace());
			}
		});
		
		if (all) {
			if (imageIds != null )
				throw new ImageException("Don't provide imageId(s) if --all is specified");
			
			imageRepo.fixExtensionAll();
		} else {
			Preconditions.checkNotNull(imageIds, "imageId(s) must be specified");
			imageRepo.fixExtension(ImmutableList.copyOf(imageIds));
		}  
		return null;
	}

}

 package org.soluvas.image.shell; 

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.ProgressMonitor;
import org.soluvas.commons.impl.ShellProgressMonitorImpl;
import org.soluvas.commons.shell.TenantCommandSupport;
import org.soluvas.image.store.Image;
import org.soluvas.image.store.ImageRepository;

import com.google.common.collect.ImmutableList;

/**
 * Shell command to update an existing {@link Image} URI.
 *
 * @author atang
 */
@Command(scope="image", name="updateuri", description="Update an existing image URI.")
public class ImageUpdateUriCommand extends TenantCommandSupport {

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

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		final ServiceReference<ImageRepository> imageRepoRef = 
				bundleContext.getServiceReferences(ImageRepository.class, "(namespace=" + namespace + ")").iterator().next();
		final ImageRepository imageRepo = getService(ImageRepository.class, imageRepoRef);
		
		final ProgressMonitor monitor = new ShellProgressMonitorImpl();
		
		if (all) {
			if (imageIds != null )
				throw new RuntimeException("ImageId cannot be attached");
			
			imageRepo.updateUriAll(monitor);
		} else {
			imageRepo.updateUri(ImmutableList.copyOf(imageIds), monitor);
		}  
		return null;
	}

}
 package org.soluvas.image.shell; 

import java.util.Collection;

import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.image.store.ImageRepository;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;

/**
 * Shell command to show information about the current Image repository.
 *
 * Image class is used to hold the metadata of images in the Soluvas Image Store.
 *
 * @author ceefour
 */
@Command(scope="image", name="info", description="Show information about the current Image repository.")
public class ImageInfoCommand extends OsgiCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(ImageInfoCommand.class);

	@Option(name="-n", aliases={"--ns", "--namespace"},
		description="Namespace, e.g. person, shop, product. Default is 'person'.")
	private transient String namespace = "person";

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		final Collection<ServiceReference<ImageRepository>> refs = bundleContext.getServiceReferences(ImageRepository.class, "(namespace=" + namespace + ")");
		final ServiceReference<ImageRepository> ref = Preconditions.checkNotNull(Iterables.getFirst(refs, null), "Cannot find ImageRepository for %s", namespace);
		final ImageRepository imageRepo = getService(ImageRepository.class, ref);
		return imageRepo;
	}

}
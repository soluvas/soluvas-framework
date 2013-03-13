package org.soluvas.image.shell; 

import static org.fusesource.jansi.Ansi.ansi;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.shell.TenantCommandSupport;
import org.soluvas.commons.tenant.TenantUtils;
import org.soluvas.image.ImageException;
import org.soluvas.image.store.ImageRepository;

/**
 * Delete {@link org.soluvas.image.store.Image}s.
 *
 * @author ceefour
 */
@Command(scope="image", name="rm", description="Delete image(s).")
public class ImageRmCommand extends TenantCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(ImageRmCommand.class);

	@Option(name="-n", aliases={"--ns", "--namespace"},
		description="Namespace, e.g. person, shop, product.")
	private String namespace;

	@Option(name="-a", aliases="--all", description="Delete all images.")
	private transient boolean all = false;
	@Argument(index=0, name="id ...", required=false, multiValued=true,
			description="Image ID(s).")
	private String[] ids;

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		final ServiceReference<ImageRepository> imageRepoRef = TenantUtils.getService(bundleContext, tenant, ImageRepository.class, namespace, null);
		final ImageRepository imageRepo = getService(ImageRepository.class, imageRepoRef);
		
		if (all) {
			if (ids == null) {
				System.out.print(ansi().render("Getting image IDs..."));
				ids = imageRepo.findAllIds().toArray(new String[] {});
				System.out.println(ansi().render(" @|bold %d|@", ids.length));
			} else {
				throw new ImageException("If all is specified, ids must be null");
			}
		} else {
			if (ids == null) {
				throw new ImageException("If all is not specified, ids must be specified");
			}
		}
		
		System.out.println(ansi().render("Deleting @|bold %d|@ images...", ids.length));
		long i = 0;
		for (String id : ids) {
			System.out.print(ansi().render("Deleting @|bold %-40s|@...", id));
			if (imageRepo.delete(id)) {
				System.out.println(ansi().render(" @|bold,bg_yellow,white  DELETED |@", id));
				i++;
			} else {
				System.out.println(ansi().render(" @|bold,bg_red,white  WARN |@", id));
			}
		}
		return i;
	}

}

 package org.soluvas.image.shell; 

import java.io.File;

import javax.inject.Inject;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.osgi.framework.ServiceReference;
import org.soluvas.commons.shell.TenantCommandSupport;
import org.soluvas.commons.tenant.TenantUtils;
import org.soluvas.image.DuplicateIdHandling;
import org.soluvas.image.FileExport;
import org.soluvas.image.ImageManager;
import org.soluvas.image.store.Image;
import org.soluvas.image.store.ImageRepository;

/**
 * Import {@link Image}s with metadata from a folder.
 *
 * @author ceefour
 */
@Command(scope="image", name="import", description="Import images with metadata from a folder.")
public class ImageImportCommand extends TenantCommandSupport {

//	private static final Logger log = LoggerFactory.getLogger(ImageImportCommand.class);
	
	@Inject
	private ImageManager imageMgr;

	@Option(name="-n", aliases={"--ns", "--namespace"},
		description="Namespace, e.g. person, shop, product.")
	private transient String namespace = "person";
	@Option(name="-d", aliases="--duplicate",
			description="Duplicate ID handling: SKIP, OVERWRITE, ADD, ERROR.")
	private transient DuplicateIdHandling duplicateIdHandling = DuplicateIdHandling.SKIP;
	
	@Argument(name="dir", required=true,
			description="Source folder.")
	private transient File srcFolder;
	
	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		final ServiceReference<ImageRepository> imageRepoRef = TenantUtils.getService(
				bundleContext, tenant, ImageRepository.class, namespace, null);
		final ImageRepository imageRepo = getService(ImageRepository.class, imageRepoRef);
		
		final long imported = imageMgr.importImages(srcFolder, true, FileExport.ORIGINAL, imageRepo,
				duplicateIdHandling, monitor);
		return imported;
	}

}
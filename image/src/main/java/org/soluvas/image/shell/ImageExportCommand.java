 package org.soluvas.image.shell; 

import java.io.File;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.osgi.framework.ServiceReference;
import org.soluvas.commons.shell.TenantCommandSupport;
import org.soluvas.commons.tenant.TenantUtils;
import org.soluvas.image.FileExport;
import org.soluvas.image.ImageManager;
import org.soluvas.image.store.Image;
import org.soluvas.image.store.ImageRepository;

/**
 * Export original {@link Image}s with metadata to a folder.
 *
 * @author ceefour
 */
@Command(scope="image", name="export", description="Export original images with metadata to a folder.")
public class ImageExportCommand extends TenantCommandSupport {

//	private static final Logger log = LoggerFactory.getLogger(ImageExportCommand.class);
	
	@Inject
	private ImageManager imageMgr;

	@Option(name="-n", aliases={"--ns", "--namespace"}, required=true,
		description="Namespace, e.g. person, shop, product.")
	private String namespace;
	@Option(name="-m", aliases="--meta", description="Export metadata.")
	private transient boolean metadata = true;
	@Option(name="-f", aliases="--file", description="Which image files to export.")
	private transient FileExport fileExport = FileExport.ORIGINAL;
	
	@Argument(name="dir", description="Destination folder.")
	private transient File destFolder = FileUtils.getTempDirectory();
	
	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		final ServiceReference<ImageRepository> imageRepoRef = TenantUtils.getService(
				bundleContext, tenant, ImageRepository.class, namespace, null);
		final ImageRepository imageRepo = getService(ImageRepository.class, imageRepoRef);
		
		final long exported = imageMgr.export(imageRepo, metadata, fileExport, destFolder, monitor);
		return exported;
	}

}
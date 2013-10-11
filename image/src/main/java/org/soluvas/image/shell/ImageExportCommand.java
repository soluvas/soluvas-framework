 package org.soluvas.image.shell; 

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.image.FileExport;
import org.soluvas.image.ImageManager;
import org.soluvas.image.ImageTypes;
import org.soluvas.image.store.Image;
import org.soluvas.image.store.ImageRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Export original {@link Image}s with metadata to a folder.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="image", name="export", description="Export original images with metadata to a folder.")
public class ImageExportCommand extends ExtCommandSupport {

//	private static final Logger log = LoggerFactory.getLogger(ImageExportCommand.class);
	
	@Option(name="-n", aliases={"--ns", "--namespace"}, required=true,
		description="Image type, e.g. PERSON, SHOP, PRODUCT.")
	private ImageTypes imageType;
	@Option(name="-m", aliases="--meta", description="Export metadata.")
	private transient boolean metadata = true;
	@Option(name="-f", aliases="--file", description="Which image files to export.")
	private transient FileExport fileExport = FileExport.ORIGINAL;
	
	@Argument(name="dir", description="Destination folder.")
	private transient File destFolder = FileUtils.getTempDirectory();
	
	@Override
	protected Object doExecute() throws Exception {
		final ImageManager imageMgr = getBean(ImageManager.class);
		final ImageRepository imageRepo = imageMgr.getRepository(imageType);
		final long exported = imageMgr.export(imageRepo, metadata, fileExport, destFolder, monitor);
		return exported;
	}

}
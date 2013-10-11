 package org.soluvas.image.shell; 

import java.io.File;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.image.DuplicateIdHandling;
import org.soluvas.image.FileExport;
import org.soluvas.image.ImageManager;
import org.soluvas.image.ImageTypes;
import org.soluvas.image.store.Image;
import org.soluvas.image.store.ImageRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Import {@link Image}s with metadata from a folder.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="image", name="import", description="Import images with metadata from a folder.")
public class ImageImportCommand extends ExtCommandSupport {

//	private static final Logger log = LoggerFactory.getLogger(ImageImportCommand.class);
	
	@Option(name="-n", aliases={"--ns", "--namespace"}, required=true,
		description="Image type, e.g. PERSON, SHOP, PRODUCT. (must specify explicitly since this command is destructive)")
	private ImageTypes imageType;
	@Option(name="-d", aliases="--duplicate",
			description="Duplicate ID handling: SKIP, OVERWRITE, ADD, ERROR.")
	private transient DuplicateIdHandling duplicateIdHandling = DuplicateIdHandling.SKIP;
	
	@Argument(name="dir", required=true,
			description="Source folder.")
	private transient File srcFolder;
	
	@Override
	protected Object doExecute() throws Exception {
		final ImageManager imageMgr = getBean(ImageManager.class);
		final ImageRepository imageRepo = imageMgr.getRepository(imageType);
		final long imported = imageMgr.importImages(srcFolder, true, FileExport.ORIGINAL, imageRepo,
				duplicateIdHandling, monitor);
		return imported;
	}

}
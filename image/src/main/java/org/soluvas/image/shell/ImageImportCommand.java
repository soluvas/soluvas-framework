 package org.soluvas.image.shell; 

import java.io.File;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.image.DuplicateIdHandling;
import org.soluvas.image.FileExport;
import org.soluvas.image.ImageManager;
import org.soluvas.image.store.Image;
import org.soluvas.image.store.ImageRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * Import {@link Image}s with metadata from a folder.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="image", name="import", description="Import images with metadata from a folder.")
public class ImageImportCommand extends ExtCommandSupport {

//	private static final Logger log = LoggerFactory.getLogger(ImageImportCommand.class);
	
	private final ImageManager imageMgr;

	@Option(name="-n", aliases={"--ns", "--namespace"}, required=true,
		description="Namespace, e.g. person, shop, product. (must specify explicitly since this command is destructive)")
	private String namespace;
	@Option(name="-d", aliases="--duplicate",
			description="Duplicate ID handling: SKIP, OVERWRITE, ADD, ERROR.")
	private transient DuplicateIdHandling duplicateIdHandling = DuplicateIdHandling.SKIP;
	
	@Argument(name="dir", required=true,
			description="Source folder.")
	private transient File srcFolder;
	
	private final List<ImageRepository> imageRepos;

	@Inject
	public ImageImportCommand(List<ImageRepository> imageRepos, ImageManager imageMgr) {
		super();
		this.imageRepos = imageRepos;
		this.imageMgr = imageMgr;
	}
	
	@Override
	protected Object doExecute() throws Exception {
		final ImageRepository imageRepo = Iterables.find(imageRepos, new Predicate<ImageRepository>() {
			@Override
			public boolean apply(@Nullable ImageRepository input) {
				return namespace.equals(input.getNamespace());
			}
		});
		
		final long imported = imageMgr.importImages(srcFolder, true, FileExport.ORIGINAL, imageRepo,
				duplicateIdHandling, monitor);
		return imported;
	}

}
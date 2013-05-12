 package org.soluvas.image.shell; 

import java.io.File;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.image.FileExport;
import org.soluvas.image.ImageManager;
import org.soluvas.image.store.Image;
import org.soluvas.image.store.ImageRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * Export original {@link Image}s with metadata to a folder.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="image", name="export", description="Export original images with metadata to a folder.")
public class ImageExportCommand extends ExtCommandSupport {

//	private static final Logger log = LoggerFactory.getLogger(ImageExportCommand.class);
	
	private final ImageManager imageMgr;
	private final List<ImageRepository> imageRepos;

	@Option(name="-n", aliases={"--ns", "--namespace"}, required=true,
		description="Namespace, e.g. person, shop, product.")
	private String namespace;
	@Option(name="-m", aliases="--meta", description="Export metadata.")
	private transient boolean metadata = true;
	@Option(name="-f", aliases="--file", description="Which image files to export.")
	private transient FileExport fileExport = FileExport.ORIGINAL;
	
	@Argument(name="dir", description="Destination folder.")
	private transient File destFolder = FileUtils.getTempDirectory();
	
	@Inject
	public ImageExportCommand(ImageManager imageMgr,
			List<ImageRepository> imageRepos) {
		super();
		this.imageMgr = imageMgr;
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
		
		final long exported = imageMgr.export(imageRepo, metadata, fileExport, destFolder, monitor);
		return exported;
	}

}
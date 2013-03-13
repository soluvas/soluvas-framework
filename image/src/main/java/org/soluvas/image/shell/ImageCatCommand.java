 package org.soluvas.image.shell; 

import java.util.List;

import javax.annotation.Nullable;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.tenant.ServiceLookup;
import org.soluvas.image.store.Image;
import org.soluvas.image.store.ImageRepository;

import com.google.common.base.Function;
import com.google.common.base.Throwables;

/**
 * Shell command to show an entity of {@link org.soluvas.image.store.Image}.
 *
 * Image class is used to hold the metadata of images in the Soluvas Image Store.
 *
 * @author ceefour
 */
@Command(scope="image", name="cat", description="Get Image by ID.")
public class ImageCatCommand extends OsgiCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(ImageCatCommand.class);

	private final ServiceLookup svcLookup;
	@Option(name="-n", aliases={"--ns", "--namespace"},
		description="Namespace, e.g. person, shop, product. Default is 'person'.")
	private transient String namespace = "person";

	@Option(name="--index", description="Find Image by index (not by ID). Index starts at 1 (as displayed by 'ls').")
	private Boolean byIndex;

	@Argument(index=0, name="id", required=true, description="Image ID.")
	private String id;

	public ImageCatCommand(ServiceLookup svcLookup) {
		super();
		this.svcLookup = svcLookup;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		return svcLookup.withService(ImageRepository.class, session, namespace,
			new Function<ImageRepository, Object>() {
				@Override @Nullable public Object apply(@Nullable ImageRepository imageStore) {
					if (byIndex == null || byIndex == true) {
						Integer parsedId = null;
						try {
							parsedId = Integer.valueOf(id);
							// TODO: natively support findOneByIndex in Repository
							List<Image> imageList = imageStore.findAll();
							return imageList.get(parsedId - 1);
						} catch (NumberFormatException e) {
							if (byIndex != null && byIndex == true) {
								Throwables.propagate(e);
								return null;
							} else {
								return imageStore.findOne(id);
							}
						}
					} else {
						return imageStore.findOne(id);
					}
				}
			});
	}

}
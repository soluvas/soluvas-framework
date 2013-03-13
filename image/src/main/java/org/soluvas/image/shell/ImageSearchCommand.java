 package org.soluvas.image.shell; 

import java.util.List;
import javax.annotation.Nullable;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Option;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.basic.SimpleCommand;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Throwables;


import java.text.NumberFormat;

import org.soluvas.commons.tenant.ServiceLookup;
import org.soluvas.image.store.Image;
import org.soluvas.image.store.ImageRepository;

/**
 * Shell command to search {@link org.soluvas.image.store.Image} entities.
 *
 * Image class is used to hold the metadata of images in the Soluvas Image Store.
 *
 * @author ceefour
 */
@Command(scope="image", name="search", description="Search Image entities by partial Numeric ID, partial slug, or partial title.")
public class ImageSearchCommand extends OsgiCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(ImageSearchCommand.class);

	private ServiceLookup svcLookup;
	@Option(name="-n", aliases={"--ns", "--namespace"},
		description="Namespace, e.g. person, shop, product. Default is 'person'.")
	private String namespace;

	@Argument(index=0, name="searchText", required=true, description="Search text.")
	private String searchText; 

	public ImageSearchCommand(ServiceLookup svcLookup) {
		super();
		this.svcLookup = svcLookup;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		System.out.format("%-35s | %6s | %-25s | %-20s\n",
			"ID", "Size", "File Name", "URI" );
		final String realNamespace = Optional.fromNullable(namespace).or("person");
		return svcLookup.withService(ImageRepository.class, session, realNamespace,
			new Function<ImageRepository, Object>() {
				@Override @Nullable public Object apply(@Nullable ImageRepository imageStore) {
					List<Image> imageList = imageStore.search(searchText);
					for (Image it : imageList) {
						System.out.format("%-35s | %5sk | %-25s | %-20s\n",
							it.getId(), NumberFormat.getIntegerInstance().format(it.getSize() / 1000), 
							it.getFileName(), it.getUri() );
					}
					System.out.format("%d Image entities in '%s'\n",
						imageList.size(), realNamespace);
					return null;
				}
			});
	}

}
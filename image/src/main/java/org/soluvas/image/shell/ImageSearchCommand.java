 package org.soluvas.image.shell; 

import java.text.NumberFormat;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.image.store.Image;
import org.soluvas.image.store.ImageRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * Shell command to search {@link org.soluvas.image.store.Image} entities.
 *
 * Image class is used to hold the metadata of images in the Soluvas Image Store.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="image", name="search", description="Search Image entities by partial Numeric ID, partial slug, or partial title.")
public class ImageSearchCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(ImageSearchCommand.class);

	private final List<ImageRepository> imageRepos;

	@Option(name="-n", aliases={"--ns", "--namespace"},
		description="Namespace, e.g. person, shop, product. Default is 'person'.")
	private String namespace;

	@Argument(index=0, name="searchText", required=true, description="Search text.")
	private String searchText; 

	@Inject
	public ImageSearchCommand(List<ImageRepository> imageRepos) {
		super();
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
		
		System.out.format("%-35s | %6s | %-25s | %-20s\n",
			"ID", "Size", "File Name", "URI" );
		final String realNamespace = Optional.fromNullable(namespace).or("person");
		
		List<Image> imageList = imageRepo.search(searchText);
		for (Image it : imageList) {
			System.out.format("%-35s | %5sk | %-25s | %-20s\n",
				it.getId(), NumberFormat.getIntegerInstance().format(it.getSize() / 1000), 
				it.getFileName(), it.getUri() );
		}
		System.out.format("%d Image entities in '%s'\n",
			imageList.size(), realNamespace);
		return null;
	}

}
 package org.soluvas.image.shell; 

import static org.fusesource.jansi.Ansi.ansi;

import java.text.NumberFormat;
import java.util.Collection;
import java.util.Map;

import javax.annotation.Nullable;

import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.image.store.Image;
import org.soluvas.image.store.ImageRepository;
import org.soluvas.image.store.StyledImage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;

/**
 * Shell command to list entities of {@link Image}.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="image", name="ls", description="List Image entities from repository.")
public class ImageLsCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(ImageLsCommand.class);

	@Option(name="-n", aliases={"--ns", "--namespace"},
			description="Namespace, e.g. person, shop, product.")
	private transient String namespace = "person";

	@Override
	protected Object doExecute() throws Exception {
		final Map<String, ImageRepository> imageRepos = getBeans(ImageRepository.class);
		final ImageRepository imageRepo = Iterables.find(imageRepos.values(), new Predicate<ImageRepository>() {
			@Override
			public boolean apply(@Nullable ImageRepository input) {
				return namespace.equals(input.getNamespace());
			}
		});
		
		System.out.println(ansi().render("@|negative_on %3s|%-48s|%-6s|%-10s|%-20s|%-20s|@",
				"№", "ID", "Size", "Type", "File Name", "Styles" ));
		final long imageCount = imageRepo.count();
		final long totalPages = (imageCount + 99) / 100;
		int i = 0;
		for (int page = 0; page < totalPages; page++) {
			final Page<Image> images = imageRepo.findAll(new PageRequest(page, 100L));
			for (final Image it : images.getContent()) {
				final Collection<String> styles = Collections2.transform(it.getStyles().values(), new Function<StyledImage, String>() {
					@Override @Nullable
					public String apply(@Nullable StyledImage input) {
						return input.getCode() + ":" + input.getWidth() + "×" + input.getHeight();
					}
				});
				// TODO: use locale settings to format date, currency, amount, "and", many
				// TODO: format products
				System.out.println(ansi().render("@|bold,black %3d||@%-48s@|bold,black ||@%5sk@|bold,black ||@%-10s@|bold,black ||@%-20s@|bold,black ||@%s",
						++i, it.getId(), NumberFormat.getIntegerInstance().format(it.getSize() / 1024),
						it.getContentType(), it.getFileName(), Joiner.on(' ').join(styles)) );
			}
			System.out.println(ansi().render("@|bold %d|@ Image entities in '@|bold %s|@' (%s on %s)",
					images.getNumberOfElements(), namespace, imageRepo.getClass().getName(), imageRepo.getConnector().getClass().getName()));
		}
		return null;
	}

}
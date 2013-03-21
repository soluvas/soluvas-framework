 package org.soluvas.image.shell; 

import static org.fusesource.jansi.Ansi.ansi;

import java.text.NumberFormat;
import java.util.Collection;
import java.util.List;

import javax.annotation.Nullable;

import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.shell.TenantCommandSupport;
import org.soluvas.commons.tenant.TenantUtils;
import org.soluvas.image.store.Image;
import org.soluvas.image.store.ImageRepository;
import org.soluvas.image.store.StyledImage;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Collections2;

/**
 * Shell command to list entities of {@link Image}.
 *
 * @author ceefour
 */
@Command(scope="image", name="ls", description="List Image entities from repository.")
public class ImageLsCommand extends TenantCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(ImageLsCommand.class);

	@Option(name="-n", aliases={"--ns", "--namespace"},
		description="Namespace, e.g. person, shop, product.")
	private transient String namespace = "person";

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		final ServiceReference<ImageRepository> imageRepoRef = TenantUtils.getService(
				bundleContext, tenant, ImageRepository.class, namespace, null);
		final ImageRepository imageRepo = getService(ImageRepository.class, imageRepoRef);
		
		System.out.println(ansi().render("@|negative_on %3s|%-48s|%-6s|%-10s|%-20s|%-20s|@",
				"№", "ID", "Size", "Type", "File Name", "Styles" ));
		final List<Image> images = imageRepo.findAll();
		int i = 0;
		for (final Image it : images) {
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
			images.size(), namespace, imageRepo.getClass().getName(), imageRepo.getConnector().getClass().getName()));
		return null;
	}

}
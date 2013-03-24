package org.soluvas.image.rs;

import java.net.URL;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.osgi.framework.InvalidSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.image.store.ImageRepository;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

/**
 * Provides ImageConfig.
 * @author ceefour
 */
//@Path("org.soluvas.image")
@Path("/")
public class ImageResource {
	
	private static final Logger log = LoggerFactory.getLogger(ImageResource.class);
	private final List<ImageRepository> imageRepos;
	
	public ImageResource(List<ImageRepository> imageRepos) {
		super();
		this.imageRepos = imageRepos;
	}

	@GET @Path("imageConfigs.js")
	@Produces("text/javascript")
	public String getImageConfigs() throws InvalidSyntaxException {
		log.trace("Got {} image repositories: {}", imageRepos.size(), imageRepos);
		URL stgUrl = ImageResource.class.getResource("imageConfigs.js.stg");
		STGroupFile stg = new STGroupFile(stgUrl, "UTF-8", '~', '~');
		ST configsSt = stg.getInstanceOf("imageConfigs");
		configsSt.add("imageRepos", imageRepos);
		// render
		String renderedJs = configsSt.render(80);
		return renderedJs;
	}

}

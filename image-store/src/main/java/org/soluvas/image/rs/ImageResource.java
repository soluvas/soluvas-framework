package org.soluvas.image.rs;

import java.net.URL;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.image.store.ImageRepository;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

/**
 * Provides ImageConfig.
 * @author ceefour
 */
@Path("org.soluvas.image")
public class ImageResource {
	
	private transient Logger log = LoggerFactory.getLogger(ImageResource.class);
	private List<ImageRepository> imageRepos;
	
	public ImageResource(List<ImageRepository> imageRepos) {
		super();
		this.imageRepos = imageRepos;
		log.info("Preparing imageConfigs.js from {} repositories", imageRepos.size());
	}

	@GET @Path("imageConfigs.js")
	@Produces("text/javascript")
	public String getImageConfigs() {
		URL stgUrl = ImageResource.class.getResource("imageConfigs.stg");
		STGroupFile stg = new STGroupFile(stgUrl, "UTF-8", '~', '~');
		ST configsSt = stg.getInstanceOf("imageConfigs");
		configsSt.add("imageRepos", imageRepos);
		
		// render
		String renderedJs = configsSt.render(80);
		return renderedJs;
	}

}

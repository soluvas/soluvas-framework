package org.soluvas.image.rs;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.image.DisplayImage;
import org.soluvas.image.ImageManager;
import org.soluvas.image.ImageStyles;
import org.soluvas.image.ImageTypes;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Provides ImageConfig.
 * @author ceefour
 */
//@Path("org.soluvas.image")
@Service @Scope("request")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ImageResource {
	
	private static final Logger log = LoggerFactory.getLogger(ImageResource.class);
	
	private final ImageManager imageMgr;
	
	public ImageResource(ImageManager imageMgr) {
		super();
		this.imageMgr = imageMgr;
	}

	/*@GET @Path("imageConfigs.js")
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
	}*/

	@GET @Path("detail")
	public Map<ImageStyles, DisplayImage> findImagesByProductId(@QueryParam("imageId") String imagetId) {
		final Map<ImageStyles, DisplayImage> imageProductMap = new HashMap<>();
		imageProductMap.put(ImageStyles.LARGE, imageMgr.getSafeImage(ImageTypes.PRODUCT, imagetId, ImageStyles.LARGE));
		imageProductMap.put(ImageStyles.NORMAL, imageMgr.getSafeImage(ImageTypes.PRODUCT, imagetId, ImageStyles.NORMAL));
		imageProductMap.put(ImageStyles.ORIGINAL, imageMgr.getSafeImage(ImageTypes.PRODUCT, imagetId, ImageStyles.ORIGINAL));
		imageProductMap.put(ImageStyles.SMALL, imageMgr.getSafeImage(ImageTypes.PRODUCT, imagetId, ImageStyles.SMALL));
		imageProductMap.put(ImageStyles.THUMBNAIL, imageMgr.getSafeImage(ImageTypes.PRODUCT, imagetId, ImageStyles.THUMBNAIL));
		log.debug("find Image by {} result is {} ", imagetId, imageProductMap);
		return imageProductMap;
	}

}

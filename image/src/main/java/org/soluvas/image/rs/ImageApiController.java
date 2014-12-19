package org.soluvas.image.rs;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.image.DisplayImage;
import org.soluvas.image.ImageManager;
import org.soluvas.image.ImageMvcConfig;
import org.soluvas.image.ImageStyles;
import org.soluvas.image.ImageTypes;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rudi
 * @see ImageMvcConfig
 */
@RestController @Scope("request")
@Transactional
public class ImageApiController {
	
	private static final Logger log = LoggerFactory
			.getLogger(ImageApiController.class);
	
	@Inject
	private ImageManager imageMgr;
	
	@RequestMapping(method=RequestMethod.GET, value="api/product_image/detail/{imageId}")
	public Map<ImageStyles, DisplayImage> findImagesByProductId(@PathVariable String imageId) {
		final Map<ImageStyles, DisplayImage> imageProductMap = new HashMap<>();
		imageProductMap.put(ImageStyles.LARGE, imageMgr.getSafeImage(ImageTypes.PRODUCT, imageId, ImageStyles.LARGE));
		imageProductMap.put(ImageStyles.NORMAL, imageMgr.getSafeImage(ImageTypes.PRODUCT, imageId, ImageStyles.NORMAL));
		imageProductMap.put(ImageStyles.ORIGINAL, imageMgr.getSafeImage(ImageTypes.PRODUCT, imageId, ImageStyles.ORIGINAL));
		imageProductMap.put(ImageStyles.SMALL, imageMgr.getSafeImage(ImageTypes.PRODUCT, imageId, ImageStyles.SMALL));
		imageProductMap.put(ImageStyles.THUMBNAIL, imageMgr.getSafeImage(ImageTypes.PRODUCT, imageId, ImageStyles.THUMBNAIL));
		log.debug("find Image by {} result is {} ", imageId, imageProductMap);
		return imageProductMap;
	}

}

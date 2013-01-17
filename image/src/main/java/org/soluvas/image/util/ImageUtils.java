package org.soluvas.image.util;

import org.apache.commons.io.FilenameUtils;

import com.google.common.base.Strings;

/**
 * @author ceefour
 *
 */
public class ImageUtils {

	/**
	 * Usage:
	 * 
	 * getExtensionOrJpg(image.getFileName());
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getExtensionOrJpg(String fileName) {
		// TODO: so don't hardcode extension!
		return !Strings.isNullOrEmpty(fileName) ? FilenameUtils.getExtension(fileName) : "jpg";
	}


}

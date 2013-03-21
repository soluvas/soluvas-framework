package org.soluvas.image.util;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.io.FilenameUtils;
import org.soluvas.image.ImageException;

import com.google.common.base.Strings;
import com.google.common.collect.Iterators;

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
		final String fileExtension = FilenameUtils.getExtension(Strings.nullToEmpty(fileName));
		return !Strings.isNullOrEmpty(fileExtension) ? fileExtension : "jpg";
	}
	
	public static Dimension getDimension(File file) {
		try {
			final ImageInputStream in = ImageIO.createImageInputStream(file);
			try {
				final ImageReader reader = Iterators.get(ImageIO.getImageReaders(in), 0);
				try {
					reader.setInput(in);
					return new Dimension(reader.getWidth(0), reader.getHeight(0));
				} finally {
					reader.dispose();
				}
			} finally {
				in.close();
			}		
		} catch (IOException e) {
			throw new ImageException("Cannot get image dimension for " + file, e);
		}
	}

}

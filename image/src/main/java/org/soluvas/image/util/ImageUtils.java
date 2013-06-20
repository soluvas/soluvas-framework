package org.soluvas.image.util;

import java.awt.Dimension;
import java.io.File;
import java.util.concurrent.ExecutorService;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.io.FilenameUtils;
import org.soluvas.image.DavConnector;
import org.soluvas.image.ImageConnector;
import org.soluvas.image.ImageException;
import org.soluvas.image.S3Connector;
import org.soluvas.image.impl.DavConnectorImpl;
import org.soluvas.image.impl.S3ConnectorImpl;

import com.amazonaws.Protocol;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterators;

/**
 * @author ceefour
 *
 */
public class ImageUtils {

	public static enum ConnectorType {
		DAV,
		S3
	}
	
	/**
	 * Map between content type (image/jpeg) to extension (jpg); 
	 */
	public static final BiMap<String, String> supportedContentTypes = HashBiMap.create(ImmutableMap.of(
			"image/jpeg", "jpg",
			"image/png", "png",
			"image/gif", "gif"));

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
	
	public static String getExtensionFromMime(String mimeType) {
		return supportedContentTypes.inverse().get(mimeType);
	}
	
	public static Dimension getDimension(File file) {
		try {
			Preconditions.checkState(file.exists(), "Image file '%s' does not exist", file);
			try (final ImageInputStream in = ImageIO.createImageInputStream(file)) {
				final ImageReader reader = Iterators.get(ImageIO.getImageReaders(in), 0);
				try {
					reader.setInput(in);
					return new Dimension(reader.getWidth(0), reader.getHeight(0));
				} finally {
					reader.dispose();
				}
			}
		} catch (Exception e) {
			throw new ImageException("Cannot get image dimension for " + file, e);
		}
	}
	
	/**
	 * Creates either {@link DavConnector} or {@link S3Connector}.
	 * @param type
	 * @param davUri
	 * @param publicUri
	 * @param executor
	 * @param s3AccessKey
	 * @param s3SecretKey
	 * @param s3CanonicalUserId
	 * @param s3Bucket
	 * @param tenantId
	 * @param tenantEnv
	 * @param s3CdnAlias
	 * @return
	 */
	public static ImageConnector createConnector(ConnectorType type,
			String davUri, String publicUri, ExecutorService executor,
			String s3AccessKey, String s3SecretKey, String s3CanonicalUserId,
			String s3Bucket, String tenantId, String tenantEnv,
			String s3CdnAlias) {
		switch (type) {
		case DAV:
			return new DavConnectorImpl(davUri, publicUri, executor);
		case S3:
			return new S3ConnectorImpl(null, Protocol.HTTPS,
					s3AccessKey, s3SecretKey, s3CanonicalUserId, s3Bucket,
					tenantId, tenantEnv, null, s3CdnAlias);
		default:
			throw new ImageException("Unknown connector type: " + type);
		}
	}

}

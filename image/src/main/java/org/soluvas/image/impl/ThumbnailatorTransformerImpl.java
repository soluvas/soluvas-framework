/**
 */
package org.soluvas.image.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URI;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.image.ImageConnector;
import org.soluvas.image.ImageException;
import org.soluvas.image.ImagePackage;
import org.soluvas.image.ImageTransform;
import org.soluvas.image.ImageVariant;
import org.soluvas.image.ThumbnailatorTransformer;
import org.soluvas.image.UploadedImage;
import org.soluvas.image.store.StyledImage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Thumbnailator Transformer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.image.impl.ThumbnailatorTransformerImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ThumbnailatorTransformerImpl#getDestination <em>Destination</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThumbnailatorTransformerImpl extends EObjectImpl implements ThumbnailatorTransformer {
	
	private static final Logger log = LoggerFactory
			.getLogger(ThumbnailatorTransformerImpl.class);
	
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected ImageConnector source;
	/**
	 * The cached value of the '{@link #getDestination() <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected ImageConnector destination;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThumbnailatorTransformerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImagePackage.Literals.THUMBNAILATOR_TRANSFORMER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImageConnector getSource() {
		if (source != null && ((EObject)source).eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (ImageConnector)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImagePackage.THUMBNAILATOR_TRANSFORMER__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageConnector basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImageConnector getDestination() {
		if (destination != null && ((EObject)destination).eIsProxy()) {
			InternalEObject oldDestination = (InternalEObject)destination;
			destination = (ImageConnector)eResolveProxy(oldDestination);
			if (destination != oldDestination) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImagePackage.THUMBNAILATOR_TRANSFORMER__DESTINATION, oldDestination, destination));
			}
		}
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageConnector basicGetDestination() {
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void transform(ImageVariant sourceVariant, ImageTransform imageTransform, ImageVariant destVariant) {
		File styledFile = null;
		final int width;
		final int height;
		try {
			// I don't think Thumbnailer and/or ImageIO is thread-safe
			synchronized (this) {
				styledFile = File.createTempFile(imageId + "_", "_" + style.getCode() + ".jpg");
				final boolean progressive = style.getMaxWidth() >= 512;
				log.info("Resizing {} to {}, quality={} progressive={}", new Object[] {
						originalFile, styledFile, style.getQuality(), progressive });
				final BufferedImage styledImage = Thumbnails.of(originalFile)
						.size(style.getMaxWidth(), style.getMaxHeight())
						.crop(Positions.CENTER).asBufferedImage();
				width = styledImage.getWidth();
				height = styledImage.getHeight();
				log.info("Dimensions of {} is {}x{}", styledFile, width, height);
				ImageWriter jpegWriter = ImageIO.getImageWritersByFormatName("jpg").next();
				final FileImageOutputStream styledOutput = new FileImageOutputStream(styledFile);
				jpegWriter.setOutput(styledOutput);
				try {
					ImageWriteParam jpegParam = jpegWriter.getDefaultWriteParam();
					jpegParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
					jpegParam.setCompressionQuality(style.getQuality());
					// Enable progressive if width >= 512, else disable
					jpegParam.setProgressiveMode(progressive ? ImageWriteParam.MODE_DEFAULT : ImageWriteParam.MODE_DISABLED);
					jpegWriter.write(null, new IIOImage(styledImage, null, null), jpegParam);
//					ImageIO.write(styledImage, "jpg", styledFile); // no quality control
				} finally {
					styledOutput.close();
				}
			}
			
//			ByteArrayOutputStream buf = new ByteArrayOutputStream();
//			ImageIO.write(styledImage, "jpg", buf);
//			byte[] content = buf.toByteArray();
//			ResizeResult result = new ResizeResult(style.getName(), contentType, "jpg", content.length, content,
//					styledImage.getWidth(), styledImage.getHeight());
		} catch (final Exception e) {
			throw new ImageException("Error resizing " + imageId + " to " + style.getCode() + ", destination: " + styledFile, e);
		}
		
		// Upload the styled image
		
//		final URI styledDavUri = getImageDavUri(imageId, style.getName());
		try {
			// upload directly for efficiency
			// TODO: not hardcode styled content type and extension
			final String styledContentType = "image/jpeg";
			String styledExtension = "jpg";
			log.info("Uploading {} {} using {}", style.getName(), imageId, connector );
			UploadedImage styledUpload = connector.upload(namespace, imageId, style.getCode(),
					styledExtension, styledFile, styledContentType);
			final String styledPublicUri = styledUpload.getOriginUri();
			final StyledImage styled = new StyledImage(
					style.getName(), style.getCode(), URI.create(styledPublicUri), styledContentType,
					(int)styledFile.length(), width, height);
			return styled;
		} catch (final Exception e) {
			throw new ImageException("Error uploading " + style.getName() + " " + imageId + " using " + connector, e);
		} finally {
			log.info("Deleting temporary {} image {}", style.getName(), styledFile);
			styledFile.delete();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImagePackage.THUMBNAILATOR_TRANSFORMER__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case ImagePackage.THUMBNAILATOR_TRANSFORMER__DESTINATION:
				if (resolve) return getDestination();
				return basicGetDestination();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ImagePackage.THUMBNAILATOR_TRANSFORMER__SOURCE:
				return source != null;
			case ImagePackage.THUMBNAILATOR_TRANSFORMER__DESTINATION:
				return destination != null;
		}
		return super.eIsSet(featureID);
	}

} //ThumbnailatorTransformerImpl

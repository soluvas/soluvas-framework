/**
 */
package org.soluvas.image.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import org.soluvas.image.ImageFactory;
import org.soluvas.image.ImagePackage;
import org.soluvas.image.ImageTransform;
import org.soluvas.image.ImageVariant;
import org.soluvas.image.ResizeToFill;
import org.soluvas.image.ThumbnailatorTransformer;
import org.soluvas.image.UploadedImage;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

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
	public List<UploadedImage> transform(String namespace, String imageId, ImageVariant sourceVariant,
			Map<ImageTransform, ImageVariant> transforms) {
		// download original
		final File originalFile;
		try {
			originalFile = File.createTempFile(imageId + "_",
					"_" + sourceVariant.getStyleVariant() + "." + sourceVariant.getExtension());
		} catch (IOException e) {
			throw new ImageException(e, "Cannot create temporary file for downloading %s %s",
					sourceVariant.getStyleCode(), imageId);
		}
		source.download(namespace, imageId, sourceVariant.getStyleCode(), sourceVariant.getStyleVariant(), sourceVariant.getExtension(), originalFile);
		
		final ImmutableList.Builder<UploadedImage> uploads = ImmutableList.builder();
		try {
			for (Entry<ImageTransform, ImageVariant> entry : transforms.entrySet()) {
				final ImageTransform transform = entry.getKey();
				final ImageVariant dest = entry.getValue();
				final int width;
				final int height;
				// TODO: do not hardcode quality
				final float quality = 0.9f;
				final File styledFile;
				try {
					styledFile = File.createTempFile(imageId + "_", "_" + dest.getStyleVariant() + "." + dest.getExtension());
				} catch (IOException e1) {
					throw new ImageException(e1, "Cannot create temporary file for styled %s %s",
							dest.getStyleCode(), imageId);
				}
				
				try {
					try {
						// I don't think Thumbnailer and/or ImageIO is thread-safe
						synchronized (this) {
							if (transform instanceof ResizeToFill) {
								final ResizeToFill fx = (ResizeToFill) transform;
								final boolean progressive = fx.getWidth() >= 512;
								log.info("Resizing {} to {}, quality={} progressive={}",
										originalFile, styledFile, quality, progressive );
								Preconditions.checkNotNull(fx.getWidth(), "ResizeToFill.width must not be null");
								Preconditions.checkNotNull(fx.getHeight(), "ResizeToFill.height must not be null");
								// TODO: support other gravity / cropping
								final BufferedImage styledImage = Thumbnails.of(originalFile)
										.size(fx.getWidth(), fx.getHeight())
										.crop(Positions.CENTER).asBufferedImage();
								width = styledImage.getWidth();
								height = styledImage.getHeight();
								log.info("Dimensions of {} is {}x{}", styledFile, width, height);
								final ImageWriter jpegWriter = ImageIO.getImageWritersByFormatName("jpg").next();
								final FileImageOutputStream styledOutput = new FileImageOutputStream(styledFile);
								jpegWriter.setOutput(styledOutput);
								try {
									final ImageWriteParam jpegParam = jpegWriter.getDefaultWriteParam();
									jpegParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
									jpegParam.setCompressionQuality(quality);
									// Enable progressive if width >= 512, else disable
									jpegParam.setProgressiveMode(progressive ? ImageWriteParam.MODE_DEFAULT : ImageWriteParam.MODE_DISABLED);
									jpegWriter.write(null, new IIOImage(styledImage, null, null), jpegParam);
//									ImageIO.write(styledImage, "jpg", styledFile); // no quality control
								} finally {
									styledOutput.close();
								}
							} else {
								throw new ImageException("Unsupported transform: " + transform);
							}
						}
						
//						ByteArrayOutputStream buf = new ByteArrayOutputStream();
//						ImageIO.write(styledImage, "jpg", buf);
//						byte[] content = buf.toByteArray();
//						ResizeResult result = new ResizeResult(style.getName(), contentType, "jpg", content.length, content,
//								styledImage.getWidth(), styledImage.getHeight());
					} catch (final Exception e) {
						throw new ImageException("Error resizing " + imageId + " to " + dest.getStyleCode() + ", destination: " + styledFile, e);
					}
					
					// Upload the styled image
//					final URI styledDavUri = getImageDavUri(imageId, style.getName());
					try {
						// upload directly for efficiency
						// TODO: not hardcode styled content type and extension
						final String styledContentType = "image/jpeg";
						final String styledExtension = "jpg";
						log.debug("Uploading {} {} using {}", dest.getStyleCode(), imageId, destination );
						final UploadedImage styledUpload = destination.upload(namespace, imageId, dest.getStyleCode(),
								dest.getStyleVariant(), styledExtension, styledFile, styledContentType);
						final String styledPublicUri = styledUpload.getOriginUri();
						log.info("Uploaded {} {} as {}", dest.getStyleCode(), imageId, styledPublicUri );
//						final StyledImage styled = new StyledImage(
//								style.getName(), style.getCode(), URI.create(styledPublicUri), styledContentType,
//								(int)styledFile.length(), width, height);
//						return styled;
						
						final UploadedImage uploadedImage = ImageFactory.eINSTANCE.createUploadedImage();
						uploadedImage.setStyleCode(dest.getStyleCode());
						uploadedImage.setStyleVariant(dest.getStyleVariant());
						uploadedImage.setExtension(dest.getExtension());
						uploadedImage.setOriginUri(styledPublicUri);
						uploadedImage.setUri(styledPublicUri);
						uploadedImage.setWidth(width);
						uploadedImage.setHeight(height);
						uploadedImage.setSize(styledFile.length());
						uploads.add(uploadedImage);
						
					} catch (final Exception e) {
						throw new ImageException("Error uploading " + dest.getStyleCode() + " " + imageId + " using " + destination, e);
					}

				} finally {
					log.debug("Deleting temporary {} {} styled image {}", dest.getStyleCode(), imageId, styledFile);
					styledFile.delete();
				}
				
			}
		} finally {
			log.debug("Deleting original file {}", originalFile);
			originalFile.delete();
		}
		return uploads.build();
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

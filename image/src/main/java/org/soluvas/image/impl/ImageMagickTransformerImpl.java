/**
 */
package org.soluvas.image.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
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
import org.soluvas.image.ImageMagickTransformer;
import org.soluvas.image.ImagePackage;
import org.soluvas.image.ImageTransform;
import org.soluvas.image.ImageVariant;
import org.soluvas.image.ResizeToFill;
import org.soluvas.image.TransformGravity;
import org.soluvas.image.UploadedImage;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Magick Transformer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.image.impl.ImageMagickTransformerImpl#getDestination <em>Destination</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImageMagickTransformerImpl extends EObjectImpl implements ImageMagickTransformer {
	
	private static final Logger log = LoggerFactory
			.getLogger(ImageMagickTransformerImpl.class);
	
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
	 */
	protected ImageMagickTransformerImpl() {
		throw new UnsupportedOperationException();
	}

	public ImageMagickTransformerImpl(ImageConnector destination) {
		super();
		this.destination = destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImagePackage.Literals.IMAGE_MAGICK_TRANSFORMER;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImagePackage.IMAGE_MAGICK_TRANSFORMER__DESTINATION, oldDestination, destination));
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
	 * haidar@haidar ~/tmp $ convert -verbose -resize 64x64^ -extent 64x64 -gravity North  *.jpg
	 * test1.jpg JPEG 527x700 527x700+0+0 8-bit DirectClass 99.9KB 0.010u 0:00.010
	 * test1.jpg=>test1_n.jpg JPEG 527x700=>64x64 64x64+0+0 8-bit DirectClass 20.5KB 0.000u 0:00.000
	 * 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public List<UploadedImage> transform(ImageConnector source, String namespace, String imageId, ImageVariant sourceVariant, Map<ImageTransform, ImageVariant> transforms) {
		// download original
		final File originalFile;
		try {
			originalFile = File.createTempFile(imageId + "_",
					"_" + sourceVariant.getStyleVariant() + "." + sourceVariant.getExtension());
		} catch (IOException e) {
			throw new ImageException(e, "Cannot create temporary file for downloading %s %s",
					sourceVariant.getStyleCode(), imageId);
		}
		source.download(namespace, imageId, sourceVariant.getStyleCode(),
				sourceVariant.getStyleVariant(), sourceVariant.getExtension(), originalFile);
		
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
						if (transform instanceof ResizeToFill) {
							final ResizeToFill fx = (ResizeToFill) transform;
							final boolean progressive = fx.getWidth() >= 512;
							Preconditions.checkNotNull(fx.getWidth(), "ResizeToFill.width must not be null");
							Preconditions.checkNotNull(fx.getHeight(), "ResizeToFill.height must not be null");
							final String gravity;
							switch (Optional.fromNullable(fx.getGravity()).or(TransformGravity.CENTER)) {
							case CENTER:
								gravity = "Center";
								break;
							case BOTTOM_CENTER:
								gravity = "South";
								break;
							case BOTTOM_LEFT:
								gravity = "SouthWest";
								break;
							case BOTTOM_RIGHT:
								gravity = "SouthEast";
								break;
							case TOP_LEFT:
								gravity = "NorthWest";
								break;
							case TOP_RIGHT:
								gravity = "NorthEast";
								break;
							case TOP_CENTER:
								gravity = "North";
								break;
							case CENTER_LEFT:
								gravity = "West";
								break;
							case CENTER_RIGHT:
								gravity = "East";
								break;
							default:
								throw new ImageException("Unknown gravity: "  + fx.getGravity());
							}
							
							final CommandLine cmd = new CommandLine("convert");
							cmd.addArgument("-verbose");
							cmd.addArgument(originalFile.getPath());
							cmd.addArgument("-resize");
							cmd.addArgument(fx.getWidth() + "x" + fx.getHeight() + "^");
							cmd.addArgument("-extent");
							cmd.addArgument(fx.getWidth() + "x" + fx.getHeight());
							cmd.addArgument("-gravity");
							cmd.addArgument(gravity);
							cmd.addArgument("-quality");
							cmd.addArgument("90"); // TODO: do not hardcode quality
							cmd.addArgument(styledFile.getPath());
							
							log.debug("Resizing {} to {} position={}, gravity={} progressive={} using: {}",
									originalFile, styledFile, gravity, quality, progressive, cmd );
							
							final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
							final DefaultExecutor executor = new DefaultExecutor();
							executor.setStreamHandler(new PumpStreamHandler(buffer));
							final int executionResult = executor.execute(cmd);
							log.info("{} returned {}: {}", cmd, executionResult, buffer);
							
							width = fx.getWidth();
							height = fx.getHeight();
							log.trace("Dimensions of {} is {}x{}", styledFile, width, height);
						} else {
							throw new ImageException("Unsupported transform: " + transform);
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
						log.debug("Uploading {} {} using {} from {} ({} bytes)",
								dest.getStyleCode(), imageId, destination.getClass().getName(),
								styledFile, styledFile.length());
						final UploadedImage styledUpload = destination.upload(namespace, imageId, dest.getStyleCode(),
								dest.getStyleVariant(), styledExtension, styledFile, styledContentType);
						final String styledPublicUri = styledUpload.getOriginUri();
						log.info("Uploaded {} {} as {} from {} ({} bytes)", dest.getStyleCode(), imageId, styledPublicUri,
								styledFile, styledFile.length());
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
						throw new ImageException(e, "Error uploading %s %s using %s",
								dest.getStyleCode(), imageId, destination.getClass().getName());
					}

				} finally {
					log.trace("Deleting temporary {} {} styled image {}", dest.getStyleCode(), imageId, styledFile);
					styledFile.delete();
					log.debug("Deleted temporary {} {} styled image {}", dest.getStyleCode(), imageId, styledFile);
				}
				
			}
		} finally {
			log.trace("Deleting original file {}", originalFile);
			originalFile.delete();
			log.debug("Deleted original file {}", originalFile);
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
			case ImagePackage.IMAGE_MAGICK_TRANSFORMER__DESTINATION:
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
			case ImagePackage.IMAGE_MAGICK_TRANSFORMER__DESTINATION:
				return destination != null;
		}
		return super.eIsSet(featureID);
	}

} //ImageMagickTransformerImpl

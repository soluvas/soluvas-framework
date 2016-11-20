/**
 */
package org.soluvas.image.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;

import javax.annotation.Nullable;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Position;
import net.coobird.thumbnailator.geometry.Positions;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
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
import org.soluvas.image.TransformGravity;
import org.soluvas.image.UploadedImage;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Thumbnailator Transformer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.image.impl.ThumbnailatorTransformerImpl#getDestination <em>Destination</em>}</li>
 * </ul>
 *
 * @generated
 */
@SuppressWarnings("serial")
public class ThumbnailatorTransformerImpl extends ImageTransformerImpl implements ThumbnailatorTransformer {
	
	/**
	 * Convert {@link TransformGravity} to Thumbnailator's {@link Positions}.
	 * @author rully
	 */
	public static class ToPositions implements
			Function<TransformGravity, Positions> {
		@Override @Nullable
		public Positions apply(TransformGravity input) {
			if (input == null)
				return null;
			return Positions.valueOf(input.name());
		};
	}

	private static final Logger log = LoggerFactory
			.getLogger(ThumbnailatorTransformerImpl.class);
	
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
	protected ThumbnailatorTransformerImpl() {
		throw new UnsupportedOperationException();
	}

	public ThumbnailatorTransformerImpl(ImageConnector destination) {
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
		return ImagePackage.Literals.THUMBNAILATOR_TRANSFORMER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public ImageConnector getDestination() {
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
	public ListenableFuture<List<UploadedImage>> transform(final ImageConnector source, final File sourceFile,
			final String namespace, final String imageId, final ImageVariant sourceVariant,
			final Map<ImageTransform, ImageVariant> transforms) {
		final AsyncFunction<File, List<UploadedImage>> processor = new AsyncFunction<File, List<UploadedImage>>() {
			@Override
			public ListenableFuture<List<UploadedImage>> apply(final File originalFile)
					throws Exception {
				return getExecutor().submit(new Callable<List<UploadedImage>>() {
					@Override
					public List<UploadedImage> call() throws Exception {
						final ImmutableList.Builder<UploadedImage> uploads = ImmutableList.builder();
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
									//synchronized (this) {
//											final BufferedImage originalImage = ImageIO.read(originalFile);
//											final int origWidth = originalImage.getWidth();
//											final int origHeight = originalImage.getHeight();
										if (transform instanceof ResizeToFill) {
											final ResizeToFill fx = (ResizeToFill) transform;
											final boolean progressive = fx.getWidth() >= 512;
											Preconditions.checkNotNull(fx.getWidth(), "ResizeToFill.width must not be null");
											Preconditions.checkNotNull(fx.getHeight(), "ResizeToFill.height must not be null");
											final Position cropPosition = Optional.fromNullable(new ToPositions().apply(fx.getGravity())).or(Positions.CENTER);
											
											// Scaling is not needed! crop(TOP_CENTER) already does its job
											// my "failed" experiment was due to an already padded source image, sigh!
//												// Scale up/down first, use the biggest scale
//												final double targetRatio = (double) fx.getWidth() / fx.getHeight();
//												final double origRatio = (double) origWidth / origHeight;
//												final int sourceWidth;
//												final int sourceHeight;
//												if (targetRatio > origRatio) {
//													// target ratio is wider than original, so sacrifice height
//													sourceWidth = origWidth;
//													sourceHeight = (int) Math.round(1f/targetRatio * origWidth);
//												} else {
//													// target ratio is narrower than original, so sacrifice width
//													sourceWidth = (int) Math.round(targetRatio * origHeight);
//													sourceHeight = origHeight;
//													
//												}
//												final double widthScale = (double) fx.getWidth() / origWidth;
//												final double heightScale = (double) fx.getHeight() / origHeight;
//												final double targetScale = Math.max(widthScale, heightScale);

											log.info("Resizing {} to {} position={}, quality={} progressive={}",
													originalFile, styledFile, cropPosition, quality, progressive );
											
											// Before cropping
											// TODO: support other gravity / cropping
//												final BufferedImage scaledImage = Thumbnails.of(originalFile)
//														.scale(targetScale)
//														.asBufferedImage();
											final BufferedImage styledImage = Thumbnails.of(originalFile)
//														.sourceRegion(cropPosition, sourceWidth, sourceHeight)
													.crop(cropPosition)
													.size(fx.getWidth(), fx.getHeight())
													.asBufferedImage();
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
//													ImageIO.write(styledImage, "jpg", styledFile); // no quality control
											} finally {
												styledOutput.close();
											}
										} else {
											throw new ImageException("Unsupported transform: " + transform);
										}
									//}
									
//										ByteArrayOutputStream buf = new ByteArrayOutputStream();
//										ImageIO.write(styledImage, "jpg", buf);
//										byte[] content = buf.toByteArray();
//										ResizeResult result = new ResizeResult(style.getName(), contentType, "jpg", content.length, content,
//												styledImage.getWidth(), styledImage.getHeight());
								} catch (final Exception e) {
									throw new ImageException("Error resizing " + imageId + " to " + dest.getStyleCode() + ", destination: " + styledFile, e);
								}
								
								// Upload the styled image
//									final URI styledDavUri = getImageDavUri(imageId, style.getName());
								try {
									// upload directly for efficiency
									// TODO: not hardcode styled content type and extension
									final String styledContentType = "image/jpeg";
									final String styledExtension = "jpg";
									log.debug("Uploading {} {} using {} from {} ({} bytes)",
											dest.getStyleCode(), imageId, destination.getClass().getName(),
											styledFile, styledFile.length());
									final UploadedImage styledUpload = destination.upload(namespace, imageId, dest.getStyleCode(),
											dest.getStyleVariant(), styledExtension, styledFile, styledContentType).get();
									final String styledPublicUri = styledUpload.getOriginUri();
									log.info("Uploaded {} {} as {} from {} ({} bytes)", dest.getStyleCode(), imageId, styledPublicUri,
											styledFile, styledFile.length());
//										final StyledImage styled = new StyledImage(
//												style.getName(), style.getCode(), URI.create(styledPublicUri), styledContentType,
//												(int)styledFile.length(), width, height);
//										return styled;
									
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
						return uploads.build();
					}
				});
			}
		};
		return processLocallyThenDelete(source, sourceFile, namespace, imageId,
				sourceVariant, transforms, processor);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
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
			case ImagePackage.THUMBNAILATOR_TRANSFORMER__DESTINATION:
				return destination != null;
		}
		return super.eIsSet(featureID);
	}

} //ThumbnailatorTransformerImpl

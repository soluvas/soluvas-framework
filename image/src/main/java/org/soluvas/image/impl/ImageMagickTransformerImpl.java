package org.soluvas.image.impl;

import java.awt.Dimension;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

import javax.annotation.Nullable;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.PumpStreamHandler;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
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
import org.soluvas.image.ResizeToFit;
import org.soluvas.image.TransformGravity;
import org.soluvas.image.UploadedImage;
import org.soluvas.image.WatermarkLike;
import org.soluvas.image.util.ImageUtils;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;

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
public class ImageMagickTransformerImpl extends ImageTransformerImpl implements ImageMagickTransformer {
	
	public final class TransformFunc implements AsyncFunction<Entry<ImageTransform, ImageVariant>, UploadedImage> {
		private final String namespace;
		private final File originalFile;
		private final String imageId;

		public TransformFunc(String namespace, File originalFile, String imageId) {
			this.namespace = namespace;
			this.originalFile = originalFile;
			this.imageId = imageId;
		}
		
		@Override
		public ListenableFuture<UploadedImage> apply(
				Entry<ImageTransform, ImageVariant> input) throws Exception {
			final ImageTransform transform = input.getKey();
			final ImageVariant dest = input.getValue();
			
			// TODO: do not hardcode quality
			final float quality = 0.85f;
			
			final ListenableFuture<File> styledFileFuture = getExecutor().submit(new Callable<File>() {
				@Override
				public File call() throws Exception {
					final File styledFile;
					try {
						styledFile = File.createTempFile(imageId + "_", "_" + dest.getStyleVariant() + "." + dest.getExtension());
					} catch (IOException e1) {
						throw new ImageException(e1, "Cannot create temporary file for styled %s %s",
								dest.getStyleCode(), imageId);
					}
					
					try {
						/*To Resize + Watermarking:
						 * rudi@rudi ~/tmp/test_image $ convert image2.jpg -verbose -gravity center -resize 800x700^ -extent 800x700 -quality 0.85f*100f miff:- | composite -watermark 15% -gravity center watermark.png - new.jpg*/

						final CommandLine cmd = new CommandLine("convert");
						cmd.addArgument("-verbose");
						cmd.addArgument(originalFile.getPath(), false);
						
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
							
							cmd.addArgument("-gravity");
							cmd.addArgument(gravity);
							cmd.addArgument("-resize");
							cmd.addArgument(fx.getWidth() + "x" + fx.getHeight() + "^");
							cmd.addArgument("-extent");
							cmd.addArgument(fx.getWidth() + "x" + fx.getHeight());
							
							log.debug("ResizeToFill {} to {}, {}x{} gravity={} quality={} progressive={} using: {}",
									originalFile, styledFile, fx.getWidth(), fx.getHeight(),
									gravity, quality, progressive, cmd );
						} else if (transform instanceof ResizeToFit) {
							final ResizeToFit fx = (ResizeToFit) transform;
							Preconditions.checkArgument(fx.getWidth() != null || fx.getHeight() != null,
									"For ResizeToFit, at least one of height or width must be specified");
							final boolean progressive = fx.getWidth() != null ? fx.getWidth() >= 512 : fx.getHeight() >= 512;
							
							cmd.addArgument("-resize");
							final String widthStr = fx.getWidth() != null ? fx.getWidth().toString() : "";
							final String heightStr = fx.getHeight() != null ? fx.getHeight().toString() : "";
							final String onlyShrinkLargerFlag = fx.getOnlyShrinkLarger() ? ">" : "";
							cmd.addArgument(widthStr + "x" + heightStr + onlyShrinkLargerFlag);
							
							log.debug("ResizeToFit {} to {}, {}x{} onlyShrinkLarger={} quality={} progressive={} using: {}",
									originalFile, styledFile, fx.getWidth(), fx.getHeight(), fx.getOnlyShrinkLarger(),
									quality, progressive, cmd );
						} else {
							throw new ImageException("Unsupported transform: " + transform);
						}
						
						// output arguments
						cmd.addArgument("-quality");
						cmd.addArgument(String.valueOf((int)(quality * 100f)));
						// Progressive JPEG: http://calendar.perfplanet.com/2012/progressive-jpegs-a-new-best-practice/
						cmd.addArgument("-interlace");
						cmd.addArgument("line");

						//Watermarking enabled?
						File resizedFile = styledFile;
						File watermarkFile = null;
						if (transform instanceof WatermarkLike) {
							watermarkFile = ((WatermarkLike) transform).getWatermarkFile();
							if (watermarkFile != null) {
								resizedFile = File.createTempFile("watermark_", ".miff");
							}
						}
						cmd.addArgument(resizedFile.getPath(), false);
						
						try {
							// Execute the cmd
							final DefaultExecutor executor = new DefaultExecutor();
							// limit ImageMagick to single-threaded if we use custom executor
							final Map<String, String> environment = sameThreadExecutor ? ImmutableMap.<String, String>of()
									: ImmutableMap.of("MAGICK_THREAD_LIMIT", "1");
							executeCmd(cmd, executor, environment);
							
							// Watermarking
							if (watermarkFile != null) {
								final CommandLine watermarkCmd = new CommandLine("composite");
								watermarkCmd.addArgument("-watermark");
								watermarkCmd.addArgument("15%");
								watermarkCmd.addArgument("-gravity");
								watermarkCmd.addArgument("center");
								watermarkCmd.addArgument(watermarkFile.getPath(), false); // watermark.png
								watermarkCmd.addArgument(resizedFile.getPath(), false); // miff
								
								// output arguments
								watermarkCmd.addArgument("-quality");
								watermarkCmd.addArgument(String.valueOf((int)(quality * 100f)));
								// Progressive JPEG: http://calendar.perfplanet.com/2012/progressive-jpegs-a-new-best-practice/
								watermarkCmd.addArgument("-interlace");
								watermarkCmd.addArgument("line");
								
								watermarkCmd.addArgument(styledFile.getPath(), false); // result
								
								// Execute the cmd
//								final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//								executor.setStreamHandler(new PumpStreamHandler(buffer));
//								log.debug("Watermarking using: {} {}", environment, watermarkCmd);
//								int executionResult;
//								try {
//									executionResult = executor.execute(watermarkCmd, environment);
//								} catch (ExecuteException e) {
//									throw new ImageException(e, "Cannot execute %s %s: %s", environment, watermarkCmd, buffer);
//								}
//								log.info("{} {} returned {}: {}", environment, watermarkCmd, executionResult, buffer);
								executeCmd(watermarkCmd, executor, environment);
							}
							
							return styledFile;
						} finally {
							// delete temporary resizedFile if watermark is enabled
							if (watermarkFile != null) {
								resizedFile.delete();
							}
						}
					} catch (final Exception e) {
						throw new ImageException("Error resizing " + imageId + " to " + dest.getStyleCode() + ", destination: " + styledFile, e);
					}
				}

				/**
				 * @param cmd
				 * @param executor
				 * @param environment
				 * @throws IOException
				 */
				protected void executeCmd(final CommandLine cmd,
						final DefaultExecutor executor,
						final Map<String, String> environment)
						throws IOException {
					final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
					executor.setStreamHandler(new PumpStreamHandler(buffer));
					log.debug("Transforming using: {} {}", environment, cmd);
					int executionResult;
					try {
						executionResult = executor.execute(cmd, environment);
					} catch (ExecuteException e) {
						throw new ImageException(e, "Cannot execute %s %s: %s", environment, cmd, buffer);
					}
					log.info("{} {} returned {}: {}", environment, cmd, executionResult, buffer);
				}
			});
			
			final ListenableFuture<UploadedImage> styledImageFuture = Futures.transform(styledFileFuture, new AsyncFunction<File, UploadedImage>() {
				@Override
				public ListenableFuture<UploadedImage> apply(File styledFile)
						throws Exception {
					// Upload the styled image
//					final URI styledDavUri = getImageDavUri(imageId, style.getName());
					
					// upload directly for efficiency
					// TODO: not hardcode styled content type and extension
					final String styledContentType = "image/jpeg";
					final String styledExtension = "jpg";
					log.debug("Uploading {} {} using {} from {} ({} bytes)",
						dest.getStyleCode(), imageId, destination.getClass().getName(),
						styledFile, styledFile.length());
					final ListenableFuture<UploadedImage> styledUploadFuture = destination.upload(namespace, imageId, dest.getStyleCode(),
						dest.getStyleVariant(), styledExtension, styledFile, styledContentType);
					return styledUploadFuture;
				}
			});
			
			final ListenableFuture<UploadedImage> transformedFuture = Futures.transform(styledImageFuture, new Function<UploadedImage, UploadedImage>() {
				@Override @Nullable
				public UploadedImage apply(@Nullable UploadedImage styledUpload) {
					final File styledFile = Futures.getUnchecked(styledFileFuture);
					try {
						final Dimension styledDim = ImageUtils.getDimension(styledFile);
						final int width = (int) styledDim.getWidth();
						final int height = (int) styledDim.getHeight();
						log.debug("Dimensions of {} is {}x{}", styledFile, width, height);

						final String styledOriginUri = styledUpload.getOriginUri();
						final String styledCdnUri = styledUpload.getUri();
						log.info("Uploaded {} {} as {}/{} from {} ({} bytes)", dest.getStyleCode(), imageId, styledOriginUri, styledCdnUri,
								styledFile, styledFile.length());
	//											final StyledImage styled = new StyledImage(
	//													style.getName(), style.getCode(), URI.create(styledPublicUri), styledContentType,
	//													(int)styledFile.length(), width, height);
	//											return styled;
						
						final UploadedImage uploadedImage = ImageFactory.eINSTANCE.createUploadedImage();
						uploadedImage.setStyleCode(dest.getStyleCode());
						uploadedImage.setStyleVariant(dest.getStyleVariant());
						uploadedImage.setExtension(dest.getExtension());
						uploadedImage.setOriginUri(styledOriginUri);
						uploadedImage.setUri(styledCdnUri);
						uploadedImage.setWidth(width);
						uploadedImage.setHeight(height);
						uploadedImage.setSize(styledFile.length());
						return uploadedImage;
					} finally {
						log.trace("Deleting temporary {} {} styled image {}", dest.getStyleCode(), imageId, styledFile);
						styledFile.delete();
						log.debug("Deleted temporary {} {} styled image {}", dest.getStyleCode(), imageId, styledFile);
					}
				}
			}, getExecutor());
			
			return transformedFuture;
		}
	}

	static final Logger log = LoggerFactory
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
	 * Warning: Running multiple instances of ImageMagick is more memory & IO intensive,
	 * it's better to use {@link #ImageMagickTransformerImpl(ImageConnector)}
	 * which uses {@link MoreExecutors#sameThreadExecutor()} (single-threaded)
	 * but does not limit ImageMagick's parallel processing.
	 * @param executor
	 * @param destination
	 */
	public ImageMagickTransformerImpl(ExecutorService executor, ImageConnector destination) {
		super(executor);
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
		if (destination != null && destination.eIsProxy()) {
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
	public ListenableFuture<List<UploadedImage>> transform(final ImageConnector source, final File sourceFile, final String namespace, 
			final String imageId, final ImageVariant sourceVariant, final Map<ImageTransform, ImageVariant> transforms) {
		final AsyncFunction<File, List<UploadedImage>> processor = new AsyncFunction<File, List<UploadedImage>>() {
			@Override
			public ListenableFuture<List<UploadedImage>> apply(final File originalFile)
					throws Exception {
				final TransformFunc transformFunc = new TransformFunc(namespace, originalFile, imageId);
				final List<ListenableFuture<UploadedImage>> taskFutures = new ArrayList<>();
				for (Entry<ImageTransform, ImageVariant> entry : transforms.entrySet()) {
					taskFutures.add(transformFunc.apply(entry));
				}
				final ListenableFuture<List<UploadedImage>> styledImagesFuture = Futures.allAsList(taskFutures);
				return styledImagesFuture;
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

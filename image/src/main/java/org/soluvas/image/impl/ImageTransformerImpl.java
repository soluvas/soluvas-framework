/**
 */
package org.soluvas.image.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.image.ImageConnector;
import org.soluvas.image.ImageException;
import org.soluvas.image.ImagePackage;
import org.soluvas.image.ImageTransform;
import org.soluvas.image.ImageTransformer;
import org.soluvas.image.ImageVariant;
import org.soluvas.image.UploadedImage;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.image.impl.ImageTransformerImpl#getExecutor <em>Executor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ImageTransformerImpl extends EObjectImpl implements ImageTransformer {
	private static final Logger log = LoggerFactory
			.getLogger(ImageTransformerImpl.class);
	
	/**
	 * The default value of the '{@link #getExecutor() <em>Executor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutor()
	 * @ordered
	 */
	protected static final ListeningExecutorService EXECUTOR_EDEFAULT = MoreExecutors.sameThreadExecutor();

	/**
	 * The cached value of the '{@link #getExecutor() <em>Executor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutor()
	 * @generated
	 * @ordered
	 */
	protected ListeningExecutorService executor = EXECUTOR_EDEFAULT;
	
	/**
	 * <b>Warning:</b> Running multiple instances of ImageMagick is more memory & IO intensive,
	 * it's better to use {@link #ImageMagickTransformerImpl(ImageConnector)}
	 * which uses the default {@link MoreExecutors#sameThreadExecutor()} (single-threaded)
	 * but does not limit ImageMagick's parallel processing.
	 */
	protected boolean sameThreadExecutor = true;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected ImageTransformerImpl() {
		super();
	}
	
	/**
	 * <b>Warning:</b> Running multiple instances of ImageMagick is more memory & IO intensive,
	 * it's better to use {@link #ImageMagickTransformerImpl(ImageConnector)}
	 * which uses the default {@link MoreExecutors#sameThreadExecutor()} (single-threaded)
	 * but does not limit ImageMagick's parallel processing.
	 * @param executor
	 */
	public ImageTransformerImpl(ExecutorService executor) {
		super();
		this.executor = MoreExecutors.listeningDecorator(executor);
		this.sameThreadExecutor = false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImagePackage.Literals.IMAGE_TRANSFORMER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ListeningExecutorService getExecutor() {
		return executor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public abstract ListenableFuture<List<UploadedImage>> transform(ImageConnector source, File sourceFile, String namespace, String imageId, ImageVariant sourceVariant, Map<ImageTransform, ImageVariant> transforms);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImagePackage.IMAGE_TRANSFORMER__EXECUTOR:
				return getExecutor();
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
			case ImagePackage.IMAGE_TRANSFORMER__EXECUTOR:
				return EXECUTOR_EDEFAULT == null ? executor != null : !EXECUTOR_EDEFAULT.equals(executor);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (executor: ");
		result.append(executor);
		result.append(')');
		return result.toString();
	}

	/**
	 * @param source
	 * @param sourceFile
	 * @param namespace
	 * @param imageId
	 * @param sourceVariant
	 * @param transforms
	 * @param processor 
	 * @return
	 */
	protected ListenableFuture<List<UploadedImage>> processLocallyThenDelete(final ImageConnector source, final File sourceFile,
			final String namespace, final String imageId, final ImageVariant sourceVariant, final Map<ImageTransform, ImageVariant> transforms, AsyncFunction<File, List<UploadedImage>> processor) {
		final ListenableFuture<File> originalFileFuture;
		final boolean deleteAfterProcess;
		if (sourceFile != null) {
			deleteAfterProcess = false;
			originalFileFuture = Futures.immediateFuture(sourceFile);
		} else {
			deleteAfterProcess = true;
			originalFileFuture = getExecutor().submit(new Callable<File>() {
				@Override
				public File call() throws Exception {
					// download original
					final File originalFile;
					try {
						originalFile = File.createTempFile(imageId + "_",
								"_" + sourceVariant.getStyleVariant() + "." + sourceVariant.getExtension());
					} catch (IOException e) {
						throw new ImageException(e, "Cannot create temporary file for downloading %s %s",
								sourceVariant.getStyleCode(), imageId);
					}
					final boolean downloaded = source.download(namespace, imageId, sourceVariant.getStyleCode(),
							sourceVariant.getStyleVariant(), sourceVariant.getExtension(), originalFile);
					log.debug("Downloaded image {} {} to {}", sourceVariant.getStyleCode(), imageId, originalFile);
					Preconditions.checkState(downloaded, "Cannot download %s %s", sourceVariant.getStyleCode(), imageId);
					return originalFile;
				}
			});
		}
		final ListenableFuture<List<UploadedImage>> styledImagesFuture = Futures.transform(originalFileFuture, processor, getExecutor());
		if (deleteAfterProcess) {
			styledImagesFuture.addListener(new Runnable() {
				@Override
				public void run() {
					final File originalFile = Futures.getUnchecked(originalFileFuture);
					log.trace("Deleting original file {}", originalFile);
					originalFile.delete();
					log.debug("Deleted original file {}", originalFile);
				}
			}, getExecutor());
		}
		return styledImagesFuture;
	}

} //ImageTransformerImpl

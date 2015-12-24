/**
 */
package org.soluvas.image.impl;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

import org.apache.commons.io.FileUtils;
import org.eclipse.emf.ecore.EClass;
import org.soluvas.image.*;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import org.springframework.context.annotation.Bean;


/**
 * <!-- begin-user-doc -->
 * Usage:

	@Bean
	public FolderConnector folderConnector() {
		final String mediaFolder = env.getRequiredProperty("workspaceDir") + "/media";
		return new FolderConnectorImpl(mediaFolder);
	}

	@Bean
	public ImageTransformer imageTransformer() {
		final File convertBin = new File("/usr/bin/convert");
		if (convertBin.exists()) {
			return new ImageMagickTransformerImpl(folderConnector());
		} else {
			return new ThumbnailatorTransformerImpl(folderConnector());
		}
	}

	@PersonImage @Bean
	public MongoImageRepository mongoPersonImageRepo() throws Exception {
		final MongoSysConfig sysConfig = sysConfigMapHolder.sysConfigMap().get(APP_ID);
		final String mongoUri = sysConfig.getMongoUri();
		final ImageConnector imageConnector = folderConnector();
		final ImageTransformer imageTransformer = imageTransformer();
		return new MongoImageRepository("person", mongoUri, imageConnector,
			imageTransformer, ImmutableList.of(
				new ImageStyle("thumbnail", "t", 128, 128),
				new ImageStyle("small", "s", 256, 256),
				new ImageStyle("normal", "n", 512, 512),
				new ImageStyle("large", "l", 1024, 1024) ));
	}
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.image.impl.FolderConnectorImpl#getFolder <em>Folder</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FolderConnectorImpl extends ImageConnectorImpl implements FolderConnector {
	/**
	 * The default value of the '{@link #getFolder() <em>Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFolder()
	 * @generated
	 * @ordered
	 */
	protected static final String FOLDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFolder() <em>Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFolder()
	 * @generated
	 * @ordered
	 */
	protected String folder = FOLDER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected FolderConnectorImpl() {
		super();
	}
	
	public FolderConnectorImpl(String folder) {
		super();
		this.folder = folder;
	}
	
	public FolderConnectorImpl(ListeningExecutorService executor, String folder) {
		super(executor);
		this.folder = folder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImagePackage.Literals.FOLDER_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFolder() {
		return folder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImagePackage.FOLDER_CONNECTOR__FOLDER:
				return getFolder();
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
			case ImagePackage.FOLDER_CONNECTOR__FOLDER:
				return FOLDER_EDEFAULT == null ? folder != null : !FOLDER_EDEFAULT.equals(folder);
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
		result.append(" (folder: ");
		result.append(folder);
		result.append(')');
		return result.toString();
	}

	@Override
	public String getUriTemplate() {
		return null;
	}
	
	protected File getLocation(String namespace, String imageId,
			String styleCode, String styleVariant, String extension) {
		return new File(folder, String.format("%s/%s/%s_%s.%s",
				namespace, styleCode, imageId, styleVariant, extension));
	}

	@Override
	public ListenableFuture<UploadedImage> upload(final String namespace, final String imageId,
			final String styleCode, final String styleVariant, final String extension, final File file,
			final String contentType) {
		return getExecutor().submit((Callable<UploadedImage>) () -> {
            final File destFile = getLocation(namespace, imageId, styleCode, styleVariant, extension);
            try {
                destFile.getParentFile().mkdirs();
				log.debug("Copying {} to {}", file, destFile);
                FileUtils.copyFile(file, destFile);
                final UploadedImageImpl uploaded = new UploadedImageImpl();
                // FIXME: fill
                return uploaded;
            } catch (IOException e) {
                throw new ImageException("Cannot copy " + file + " to " + destFile, e);
            }
        });
	}

	@Override
	public boolean download(String namespace, String imageId, String styleCode,
			String styleVariant, String extension, File file) {
		final File sourceFile = getLocation(namespace, imageId, styleCode, styleVariant, extension);
		try {
			log.debug("Copying {} to {}", sourceFile, file);
			FileUtils.copyFile(sourceFile, file);
			return true;
		} catch (IOException e) {
			throw new ImageException("Cannot copy " + sourceFile + " to " + file, e);
		}
	}

	@Override
	public void delete(String namespace, String imageId, String styleCode,
			String styleVariant, String extension) {
		final File sourceFile = getLocation(namespace, imageId, styleCode, styleVariant, extension);
		log.debug("Deleting {} (namespace={} imageId={} styleCode={} styleVariant={} extension={})",
				sourceFile, namespace, imageId, styleCode, styleVariant, extension);
		sourceFile.delete();
	}

} //FolderConnectorImpl

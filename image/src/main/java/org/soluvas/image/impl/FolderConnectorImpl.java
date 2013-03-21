/**
 */
package org.soluvas.image.impl;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.eclipse.emf.ecore.EClass;
import org.soluvas.image.FolderConnector;
import org.soluvas.image.ImageException;
import org.soluvas.image.ImagePackage;
import org.soluvas.image.UploadedImage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Folder Connector</b></em>'.
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
	public UploadedImage upload(String namespace, String imageId,
			String styleCode, String styleVariant, String extension, File file,
			String contentType) {
		final File destFile = getLocation(namespace, imageId, styleCode, styleVariant, extension);
		try {
			destFile.getParentFile().mkdirs();
			FileUtils.copyFile(file, destFile);
			final UploadedImageImpl uploaded = new UploadedImageImpl();
			// FIXME: fill
			return uploaded;
		} catch (IOException e) {
			throw new ImageException("Cannot copy " + file + " to " + destFile, e);
		}
	}

	@Override
	public boolean download(String namespace, String imageId, String styleCode,
			String styleVariant, String extension, File file) {
		final File sourceFile = getLocation(namespace, imageId, styleCode, styleVariant, extension);
		try {
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
		sourceFile.delete();
	}

} //FolderConnectorImpl

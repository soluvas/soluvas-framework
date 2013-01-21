/**
 */
package org.soluvas.image;

import java.io.File;
import org.soluvas.commons.Gender;
import org.soluvas.commons.ProgressMonitor;
import org.soluvas.commons.SerializableEObject;
import org.soluvas.image.store.ImageRepository;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.soluvas.image.ImagePackage#getImageManager()
 * @model
 * @extends SerializableEObject
 * @generated
 */
public interface ImageManager extends SerializableEObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String getDefaultPhotoId(Gender gender);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Downloads all images and exports them to a folder.
	 * <!-- end-model-doc -->
	 * @model imageRepoDataType="org.soluvas.image.ImageRepository" destFolderDataType="org.soluvas.commons.File"
	 * @generated
	 */
	long export(ImageRepository imageRepo, boolean metadata, FileExport files, File destFolder, ProgressMonitor monitor);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Import from metadata file and images.
	 * 
	 * Can't have "import" as name because it's a reserved keyword.
	 * <!-- end-model-doc -->
	 * @model srcFolderDataType="org.soluvas.commons.File" imageRepoDataType="org.soluvas.image.ImageRepository"
	 * @generated
	 */
	long importImages(File srcFolder, boolean metadata, FileExport files, ImageRepository imageRepo, DuplicateIdHandling duplicateIdHandling, ProgressMonitor monitor);

} // ImageManager

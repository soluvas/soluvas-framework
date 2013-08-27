/**
 */
package org.soluvas.image;

import java.io.File;

import java.util.Collection;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import javax.annotation.Nullable;

import org.soluvas.commons.Gender;
import org.soluvas.commons.Imageable;
import org.soluvas.commons.PersonInfo;
import org.soluvas.commons.PersonLike;
import org.soluvas.commons.ProgressMonitor;
import org.soluvas.image.store.ImageRepository;
import org.soluvas.ldap.SocialPerson;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.soluvas.image.ImagePackage#getImageManager()
 * @model
 * @generated
 */
public interface ImageManager extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Object / non-person missing image URI.
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	String getNoImageUri();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	String getDefaultPhotoId(Gender gender);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	String getPersonIconUri(Gender gender);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the provided URI if specified. Otherwise, return the default photo ID based on given gender.
	 * If gender is not known, will return unknown gender photo URI.
	 * <!-- end-model-doc -->
	 * @model required="true"
	 * @generated
	 */
	String getPersonPhotoUri(String uri, Gender gender);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return the non-object URI if not null, otherwise return the default non-object image URI.
	 * <!-- end-model-doc -->
	 * @model required="true"
	 * @generated
	 */
	String getObjectPhotoUri(String uri);

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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets the DisplayImage for an imageId & styleName in a specified repository.
	 * <!-- end-model-doc -->
	 * @model required="true" namespaceDataType="org.soluvas.image.ImageType" styleDataType="org.soluvas.image.ImageStyle"
	 */
	DisplayImage getSafeImage(ImageType namespace, @Nullable String imageId, @Nullable ImageStyle style);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets DisplayImages for [Identifiable & Imageable] & styleName in a specified repository.
	 * If image is not available, use the default object noimage.
	 * Returns Map<entityId, DisplayImage>.
	 * Note the parameter must implement both Identifiable and Imageable.
	 * <!-- end-model-doc -->
	 * @model dataType="org.soluvas.commons.Map<org.eclipse.emf.ecore.EString, org.soluvas.image.DisplayImage>" required="true" namespaceDataType="org.soluvas.image.ImageType" namespaceRequired="true" imageablesDataType="org.soluvas.commons.Collection<? extends org.soluvas.commons.Imageable>" imageablesRequired="true" styleDataType="org.soluvas.image.ImageStyle"
	 * @generated
	 */
	Map<String, DisplayImage> getSafeImages(ImageType namespace, Collection<? extends Imageable> imageables, ImageStyle style);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets DisplayImages for image IDs & styleName in a specified repository.
	 * If image is not available, use the default object noimage.
	 * Returns Map<imageId, DisplayImage>.
	 * <!-- end-model-doc -->
	 * @model dataType="org.soluvas.commons.Map<org.eclipse.emf.ecore.EString, org.soluvas.image.DisplayImage>" required="true" namespaceDataType="org.soluvas.image.ImageType" namespaceRequired="true" imageIdsDataType="org.soluvas.commons.Collection<org.eclipse.emf.ecore.EString>" imageIdsRequired="true" styleDataType="org.soluvas.image.ImageStyle"
	 * @generated
	 */
	Map<String, DisplayImage> getSafeImagesById(ImageType namespace, Collection<String> imageIds, ImageStyle style);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets the DisplayImage for an imageId & styleName in a specified repository. If image is not available, use the gender to select the representation.
	 * <!-- end-model-doc -->
	 * @model required="true" namespaceDataType="org.soluvas.image.ImageType" styleDataType="org.soluvas.image.ImageStyle"
	 */
	DisplayImage getSafePersonPhoto(ImageType namespace, @Nullable String imageId, @Nullable ImageStyle style, @Nullable Gender gender);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets the DisplayImage for an imageId & styleName in a specified repository. If image is not available, use the gender to select the representation.
	 * <!-- end-model-doc -->
	 * @model required="true" namespaceDataType="org.soluvas.image.ImageType" styleDataType="org.soluvas.image.ImageStyle"
	 * @generated
	 */
	DisplayImage getSafePersonPhoto(ImageType namespace, PersonLike person, ImageStyle style);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets DisplayImages for SocialPersons & styleName in a specified repository.
	 * If image is not available, use the gender to select the representation.
	 * Returns Map<personId, DisplayImage>
	 * <!-- end-model-doc -->
	 * @model dataType="org.soluvas.commons.Map<org.eclipse.emf.ecore.EString, org.soluvas.image.DisplayImage>" required="true" namespaceDataType="org.soluvas.image.ImageType" namespaceRequired="true" peopleDataType="org.soluvas.commons.Collection<? extends org.soluvas.commons.PersonLike>" peopleRequired="true" styleDataType="org.soluvas.image.ImageStyle"
	 * @generated
	 */
	Map<String, DisplayImage> getSafePersonPhotos(ImageType namespace, Collection<? extends PersonLike> people, ImageStyle style);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets DisplayImages for SocialPersons & styleName in a specified repository.
	 * If image is not available, use the gender to select the representation.
	 * Returns Map<personId, DisplayImage>
	 * <!-- end-model-doc -->
	 * @model dataType="org.soluvas.commons.Map<org.eclipse.emf.ecore.EString, org.soluvas.image.DisplayImage>" required="true" namespaceDataType="org.soluvas.image.ImageType" namespaceRequired="true" peopleDataType="org.soluvas.commons.Collection<org.soluvas.image.SocialPerson>" peopleRequired="true" styleDataType="org.soluvas.image.ImageStyle"
	 * @generated
	 */
	Map<String, DisplayImage> getSafeSocialPersonPhotos(ImageType namespace, Collection<SocialPerson> people, ImageStyle style);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.soluvas.image.ImageRepository" required="true" imageTypeDataType="org.soluvas.image.ImageType" imageTypeRequired="true"
	 * @generated
	 */
	ImageRepository getRepository(ImageType imageType);

	String getThumbnailPhotoUri(SocialPerson person);

} // ImageManager

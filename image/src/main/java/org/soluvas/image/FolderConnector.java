/**
 */
package org.soluvas.image;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Folder Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Directly save to filesytem folder, useful for testing.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.image.FolderConnector#getFolder <em>Folder</em>}</li>
 * </ul>
 *
 * @see org.soluvas.image.ImagePackage#getFolderConnector()
 * @model
 * @generated
 */
public interface FolderConnector extends ImageConnector {
	/**
	 * Returns the value of the '<em><b>Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Location to save.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Folder</em>' attribute.
	 * @see org.soluvas.image.ImagePackage#getFolderConnector_Folder()
	 * @model required="true" changeable="false"
	 * @generated
	 */
	String getFolder();

} // FolderConnector
